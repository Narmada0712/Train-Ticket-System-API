package com.trainticket.system;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.trainticket.system.model.Ticket;
import com.trainticket.system.repository.TicketRepository;
import com.trainticket.system.service.TicketService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrainTicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketService ticketService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPurchaseTicket() {
        Ticket ticketToPurchase = new Ticket();
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticketToPurchase);

        Ticket purchasedTicket = ticketService.purchaseTicket(ticketToPurchase);

        assertNotNull(purchasedTicket);
        verify(ticketRepository, times(1)).save(any(Ticket.class));
    }

    @Test
    public void testGetAllTickets() {
        List<Ticket> ticketList = new ArrayList<>();
        when(ticketRepository.findAll()).thenReturn(ticketList);

        List<Ticket> retrievedTickets = ticketService.getAllTickets();

        assertNotNull(retrievedTickets);
        assertEquals(ticketList, retrievedTickets);
        verify(ticketRepository, times(1)).findAll();
    }

    

    
}
