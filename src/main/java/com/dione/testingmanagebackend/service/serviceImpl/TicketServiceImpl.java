package com.dione.testingmanagebackend.service.serviceImpl;

import com.dione.testingmanagebackend.entities.Ticket;
import com.dione.testingmanagebackend.repository.TicketRepository;
import com.dione.testingmanagebackend.service.ITicketService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements ITicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    @Override
    public Ticket getTicket(Long refTicket) throws ResourceNotFoundException {
        return ticketRepository.findById(refTicket).orElseThrow(() -> new ResourceNotFoundException("ticket non trouvé"));
    }

    @Override
    public Ticket updateTicket(Ticket ticket) throws ResourceNotFoundException {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long refTicket) {
        ticketRepository.deleteById(refTicket);
    }

    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }
}
