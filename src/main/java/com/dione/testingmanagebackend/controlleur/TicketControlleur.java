package com.dione.testingmanagebackend.controlleur;

import com.dione.testingmanagebackend.entities.Ticket;
import com.dione.testingmanagebackend.service.serviceImpl.TicketServiceImpl;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketManager")
public class TicketControlleur {

    private final TicketServiceImpl ticketService;

    private Ticket ticket = new Ticket();

    public TicketControlleur (TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTicket(){
        List<Ticket> tickets = ticketService.getAllTicket();
        return ResponseEntity.ok().body(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable(value="refTicket") Long refTicket) throws ResourceNotFoundException {
        ticket = ticketService.getTicket(refTicket);
        return ResponseEntity.ok().body(ticket);
    }

    @PostMapping
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){
        return ResponseEntity.ok().body(ticketService.addTicket(ticket));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable (value = "refTicket", required = false) Long refTicket, @RequestBody Ticket ticketRequest ) throws ResourceNotFoundException {
        ticketRequest.setRefTicket(refTicket);
        return ResponseEntity.ok().body(ticketService.updateTicket(ticketRequest));
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable(value="refTicket") Long refTicket){
        ticketService.deleteTicket(refTicket);
        return "ok";
    }
}
