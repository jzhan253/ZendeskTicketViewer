package com.zendeskcodingchallenge.ZendeskTicketViewer.external;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zendeskcodingchallenge.ZendeskTicketViewer.entity.Ticket;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
public class ZendeskClient {

    private static final String SUBDOMAIN = getProperty("subdomain");
    private static final String EMAIL = getProperty("email");
    private static final String PASSWORD = getProperty("password");
    private static final String URL_TEMPLATE = "https://%s.zendesk.com/api/v2/tickets%s.json/";

    private static String getProperty(String s) {
        Properties p = new Properties();
        try{
            p.load(ZendeskClient.class.getResourceAsStream("/config.properties"));
        } catch(IOException e){
            e.printStackTrace();
            return "";
        }
        return p.getProperty(s);
    }

    private static String buildURL(String suffix){
        return String.format(URL_TEMPLATE, SUBDOMAIN, suffix);
    }

    public List<Ticket> getTicketList(){
        try{
            String resultStr = searchZendesk(buildURL(""), 0);
            if(resultStr == null || resultStr.length() == 0) return new ArrayList<>();
            return getList(resultStr);
        } catch (ZendeskException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Ticket getSingleTicket(long id){
        try{
            String resultStr = searchZendesk(buildURL("/" + id), 1);
            if(resultStr == null || resultStr.length() == 0) return null;
            return getTicket(resultStr);
        } catch (ZendeskException e){
            e.printStackTrace();
            return null;
        }
    }

    private Ticket getTicket(String data){
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try{
            return mapper.readValue(data, Ticket.class);
        } catch (JsonProcessingException | ZendeskException e) {
            e.printStackTrace();
            System.out.println("haha");
            return null;
        }
    }


    private List<Ticket> getList(String data){
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try{
            return Arrays.asList(mapper.readValue(data, Ticket[].class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private String searchZendesk(String url, int flag) throws ZendeskException{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        ResponseHandler<String> responseHandler = response -> {
            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode != 200) {
                System.out.println("Response status: " + response.getStatusLine().getReasonPhrase());
                throw new ZendeskException("Failed to get result from Zendesk API, 1");
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                throw new ZendeskException("Failed to get result from Zendesk API, 2");
            }
            JSONObject obj = null;
            try {
                obj = new JSONObject(EntityUtils.toString(entity));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if(obj != null){
                try {
                    return flag == 0 ? obj.getJSONArray("tickets").toString() : obj.getJSONObject("ticket").toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            } else return null;

        };

        try {
            HttpGet request = new HttpGet(url);
            if(EMAIL == null || EMAIL.length() == 0 || PASSWORD == null || PASSWORD.length() == 0) return "";
            String encoding = Base64.getEncoder().encodeToString((EMAIL + ":" + PASSWORD).getBytes(StandardCharsets.UTF_8));
            request.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
            return httpclient.execute(request, responseHandler);
        } catch (IOException | ZendeskException e) {
            e.printStackTrace();
            throw new ZendeskException("Failed to get result from Zendesk API, 3");
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
