package com.zendeskcodingchallenge.ZendeskTicketViewer;

import com.zendeskcodingchallenge.ZendeskTicketViewer.controller.TicketsController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZendeskTicketViewerApplicationTests {

	@Autowired
	private TicketsController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
