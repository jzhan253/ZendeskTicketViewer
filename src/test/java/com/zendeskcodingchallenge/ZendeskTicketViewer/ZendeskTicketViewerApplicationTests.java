package com.zendeskcodingchallenge.ZendeskTicketViewer;

import com.zendeskcodingchallenge.ZendeskTicketViewer.controller.TicketsController;
import com.zendeskcodingchallenge.ZendeskTicketViewer.entity.Ticket;
import com.zendeskcodingchallenge.ZendeskTicketViewer.services.TicketService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
class ZendeskTicketViewerApplicationTests {

	@Autowired
	private TicketsController controller;

	@Autowired
	private TicketService service;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void testCreate(){
		Ticket t = new Ticket();
	}

}
