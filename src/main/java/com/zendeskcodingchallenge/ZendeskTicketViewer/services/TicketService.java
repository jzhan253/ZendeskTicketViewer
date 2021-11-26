package com.zendeskcodingchallenge.ZendeskTicketViewer.services;

import com.zendeskcodingchallenge.ZendeskTicketViewer.entity.Ticket;
import com.zendeskcodingchallenge.ZendeskTicketViewer.external.ZendeskClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
