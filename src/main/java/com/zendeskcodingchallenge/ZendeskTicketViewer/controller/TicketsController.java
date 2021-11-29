package com.zendeskcodingchallenge.ZendeskTicketViewer.controller;

import com.zendeskcodingchallenge.ZendeskTicketViewer.entity.Ticket;
import com.zendeskcodingchallenge.ZendeskTicketViewer.services.TicketService;
import com.zendeskcodingchallenge.ZendeskTicketViewer.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TicketsController {

    private final TicketService ticketService;

    @Autowired
    public TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(value="/tickets")
    public Result<List<Ticket>> getTickets() {
        return ticketService.getTickets();
    }

    @GetMapping(value="/tickets/{id}")
    public Result<Ticket> getTicket(@PathVariable long id){
        return ticketService.getTicket(id);
    }




}
