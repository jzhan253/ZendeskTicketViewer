package com.zendeskcodingchallenge.ZendeskTicketViewer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zendeskcodingchallenge.ZendeskTicketViewer.entity.Ticket;
import com.zendeskcodingchallenge.ZendeskTicketViewer.external.ZendeskClient;
import com.zendeskcodingchallenge.ZendeskTicketViewer.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Service
public class TicketService {

    private final ZendeskClient client;

    @Autowired
    public TicketService(ZendeskClient c){
        client = c;
    }

    public List<Ticket> getTickets() {
        return client.getTicketList();
    }

    public Ticket getTicket(Long id){
        return client.getSingleTicket(id);
    }
}
