package com.zendeskcodingchallenge.ZendeskTicketViewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ZendeskTicketViewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZendeskTicketViewerApplication.class, args);
	}

}
