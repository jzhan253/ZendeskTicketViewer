package com.zendeskcodingchallenge.ZendeskTicketViewer.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zendeskcodingchallenge.ZendeskTicketViewer.entity.Ticket;
import com.zendeskcodingchallenge.ZendeskTicketViewer.services.TicketService;
import com.zendeskcodingchallenge.ZendeskTicketViewer.util.Result;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TicketsController {

    private final TicketService ticketService;

    @Autowired
    public TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(value="/tickets")
    public Result<List<Ticket>> getTickets() {
        List<Ticket> res = ticketService.getTickets();
        if(res == null || res.size() == 0){
            return new Result<>(400, "Not able to get the tickets list!");
        }
        Result<List<Ticket>> r = new Result<>(200, "Success");
        r.setData(res);
        return r;
    }

    @GetMapping(value="/tickets/{id}")
    public Result<Ticket> getTicket(@PathVariable long id){
        Ticket res = ticketService.getTicket(id);
        if(res == null) return new Result<>(400, "No such Ticket!");
        Result<Ticket> r = new Result<>(200, "Success");
        r.setData(res);
        return r;
    }




}
