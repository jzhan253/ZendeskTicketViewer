package com.zendeskcodingchallenge.ZendeskTicketViewer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zendeskcodingchallenge.ZendeskTicketViewer.entity.Ticket;
import com.zendeskcodingchallenge.ZendeskTicketViewer.external.ZendeskClient;
import com.zendeskcodingchallenge.ZendeskTicketViewer.util.Result;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.List;

public class ZendeskClientTest {

    private static ZendeskClient client;

    @Test
    @BeforeAll
    static void testSetup(){
        client = new ZendeskClient();
        assertThat(client).isNotNull();
    }

    @Test
    void getSingleTicketTest() throws JsonProcessingException {
        Result<Ticket> expected = new Result<>(200, "Success");
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        expected.setData(mapper.readValue("{\"subject\":\"Sample ticket: Meet the ticket\",\"email_cc_ids\":[],\"created_at\":\"2021-11-20T22:28:39Z\",\"description\":\"Hi there,\\n\\nI’m sending an email because I’m having a problem setting up your new product. Can you help me troubleshoot?\\n\\nThanks,\\n The Customer\\n\\n\",\"external_id\":null,\"type\":\"incident\",\"via\":{\"channel\":\"sample_ticket\",\"source\":{\"rel\":null,\"from\":{},\"to\":{}}},\"allow_attachments\":true,\"updated_at\":\"2021-11-20T22:28:40Z\",\"problem_id\":null,\"follower_ids\":[],\"due_at\":null,\"id\":1,\"assignee_id\":421882017952,\"raw_subject\":\"Sample ticket: Meet the ticket\",\"forum_topic_id\":null,\"custom_fields\":[],\"allow_channelback\":false,\"satisfaction_rating\":null,\"submitter_id\":421882017952,\"priority\":\"normal\",\"collaborator_ids\":[],\"url\":\"https:\\/\\/zendeskcodingchallenge9222.zendesk.com\\/api\\/v2\\/tickets\\/1.json\",\"tags\":[\"sample\",\"support\",\"zendesk\"],\"brand_id\":360007062572,\"ticket_form_id\":360003507672,\"sharing_agreement_ids\":[],\"group_id\":360022276852,\"organization_id\":null,\"followup_ids\":[],\"recipient\":null,\"is_public\":true,\"has_incidents\":false,\"fields\":[],\"status\":\"open\",\"requester_id\":421882020032}", Ticket.class));
        Result<Ticket> actual = client.getSingleTicket(1);
        Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        Assertions.assertEquals(expected.getResultCode(), actual.getResultCode());
        Ticket expectedData = expected.getData();
        Ticket actualData = actual.getData();
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(expectedData,actualData));
    }

    @Test
    void getInvalidTicketTest() {
        Result<Ticket> expected = new Result<>(404, "Failed to get result from Zendesk API, Ticket Not Found!");
        // requesting an invalid ticket
        Result<Ticket> actual = client.getSingleTicket(1000);
        Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        Assertions.assertEquals(expected.getResultCode(), actual.getResultCode());
        Ticket actualData = actual.getData();
        assertThat(actualData).isNull();
    }

    @Test
    void getTicketsTest() throws JsonProcessingException {
        Result<Ticket> expected1 = new Result<>(200, "Success");
        Result<Ticket> expected2 = new Result<>(200, "Success");
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        expected1.setData(mapper.readValue("{\"subject\":\"Sample ticket: Meet the ticket\",\"email_cc_ids\":[],\"created_at\":\"2021-11-20T22:28:39Z\",\"description\":\"Hi there,\\n\\nI’m sending an email because I’m having a problem setting up your new product. Can you help me troubleshoot?\\n\\nThanks,\\n The Customer\\n\\n\",\"external_id\":null,\"type\":\"incident\",\"via\":{\"channel\":\"sample_ticket\",\"source\":{\"rel\":null,\"from\":{},\"to\":{}}},\"allow_attachments\":true,\"updated_at\":\"2021-11-20T22:28:40Z\",\"problem_id\":null,\"follower_ids\":[],\"due_at\":null,\"id\":1,\"assignee_id\":421882017952,\"raw_subject\":\"Sample ticket: Meet the ticket\",\"forum_topic_id\":null,\"custom_fields\":[],\"allow_channelback\":false,\"satisfaction_rating\":null,\"submitter_id\":421882017952,\"priority\":\"normal\",\"collaborator_ids\":[],\"url\":\"https:\\/\\/zendeskcodingchallenge9222.zendesk.com\\/api\\/v2\\/tickets\\/1.json\",\"tags\":[\"sample\",\"support\",\"zendesk\"],\"brand_id\":360007062572,\"ticket_form_id\":360003507672,\"sharing_agreement_ids\":[],\"group_id\":360022276852,\"organization_id\":null,\"followup_ids\":[],\"recipient\":null,\"is_public\":true,\"has_incidents\":false,\"fields\":[],\"status\":\"open\",\"requester_id\":421882020032}", Ticket.class));
        expected2.setData(mapper.readValue("{\"subject\":\"velit eiusmod reprehenderit officia cupidatat\",\"email_cc_ids\":[],\"created_at\":\"2021-11-21T00:16:25Z\",\"description\":\"Aute ex sunt culpa ex ea esse sint cupidatat aliqua ex consequat sit reprehenderit. Velit labore proident quis culpa ad duis adipisicing laboris voluptate velit incididunt minim consequat nulla. Laboris adipisicing reprehenderit minim tempor officia ullamco occaecat ut laborum.\\n\\nAliquip velit adipisicing exercitation irure aliqua qui. Commodo eu laborum cillum nostrud eu. Mollit duis qui non ea deserunt est est et officia ut excepteur Lorem pariatur deserunt.\",\"external_id\":null,\"type\":null,\"via\":{\"channel\":\"api\",\"source\":{\"rel\":null,\"from\":{},\"to\":{}}},\"allow_attachments\":true,\"updated_at\":\"2021-11-21T00:16:25Z\",\"problem_id\":null,\"follower_ids\":[],\"due_at\":null,\"id\":2,\"assignee_id\":421882017952,\"raw_subject\":\"velit eiusmod reprehenderit officia cupidatat\",\"forum_topic_id\":null,\"custom_fields\":[],\"allow_channelback\":false,\"satisfaction_rating\":null,\"submitter_id\":421882017952,\"priority\":null,\"collaborator_ids\":[],\"url\":\"https:\\/\\/zendeskcodingchallenge9222.zendesk.com\\/api\\/v2\\/tickets\\/2.json\",\"tags\":[\"est\",\"incididunt\",\"nisi\"],\"brand_id\":360007062572,\"ticket_form_id\":360003507672,\"sharing_agreement_ids\":[],\"group_id\":360022276852,\"organization_id\":361631067192,\"followup_ids\":[],\"recipient\":null,\"is_public\":true,\"has_incidents\":false,\"fields\":[],\"status\":\"open\",\"requester_id\":421882017952}", Ticket.class));
        Result<List<Ticket>> actual = client.getTicketList();
        Assertions.assertEquals(expected1.getMessage(), actual.getMessage());
        Assertions.assertEquals(expected1.getResultCode(), actual.getResultCode());
        Ticket actualData1 = actual.getData().get(0);
        Ticket actualData2 = actual.getData().get(1);
        Ticket expectedData1 = expected1.getData();
        Ticket expectedData2 = expected2.getData();
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(expectedData1,actualData1));
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(expectedData2,actualData2));
    }


}
