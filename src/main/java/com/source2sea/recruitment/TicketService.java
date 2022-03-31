package com.source2sea.recruitment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Based on the name of the film, age, and customer type, the class creates and delivers a ticket in response to an inquiry.
 * By creating a ticket, it is understood as saving the ticket and calculating its price, including the discount,
 * on the basis of the following rules:
 *
 * - for regular customers (clientType = "NORMAL") standard ticket price for a given movie without any discount
 * - for PREMIUM customers under 18 the discount is 50%
 * - for PREMIUM customers over 18 years of age, the discount is 90%
 * - for VIP customers over 26 years of age, the discount is 95%
 * - for VIP clients under 26 years of age, the discount is 90%
 */
@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private MovieService movieService;

    public Ticket getTicket(String movieName, Integer age, String clientType) {
        double p = movieService.getPrice(movieName);

        if(clientType == "NORMAL"){
            p = p;
        }else if (clientType == "PREMIUM"){
            if(age < 18){
                p = p * 0.5;
            }else{
                p = p * 0.90;
            }
        }else if (clientType == "BONUS"){
            if(age < 26){
                p = p * 0.9;
            }else{
                p = p * 0.95;
            }
        }

        Long id = ticketRepository.save(createEntity(movieName, age, clientType)).getId();

        return new Ticket(movieName, id, p);
    }

    private TicketEntity createEntity(String movieName, Integer age, String clientType) {
        TicketEntity entity = new TicketEntity();

        entity.setClientAge(age);
        entity.setClientType(clientType);
        entity.setMovieName(movieName);

        return entity;
    }

}
