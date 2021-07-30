package com.source2sea.recruitment;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/get-ticket")
public class TicketController {

    TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{movieName}")
    public Ticket getTicket(@PathVariable("movieName") String movieName, @RequestParam("age") Integer age, @RequestParam("clientType") String clientType) {
        return ticketService.getTicket(movieName, age, clientType);
    }
}
