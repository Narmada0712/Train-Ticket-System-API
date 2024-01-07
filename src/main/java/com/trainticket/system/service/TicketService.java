package com.trainticket.system.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainticket.system.model.Ticket;
import com.trainticket.system.repository.TicketRepository;
import com.trainticket.system.ticketseat.TrainSeatAllocator;

@Service
public class TicketService {
 @Autowired
 private TicketRepository ticketRepository;
 
 @Autowired
 public TicketService(TicketRepository ticketRepository) {
     this.ticketRepository = ticketRepository;
 }
 public void saveOrUpdateTicket(Ticket ticket) {
     ticketRepository.save(ticket);
 }

 public Ticket purchaseTicket(Ticket ticket) {
     char allocatedSeatSection = TrainSeatAllocator.allocateSeat();
     ticket.setSeatSection(allocatedSeatSection);
     return ticketRepository.save(ticket);
 }

 public List<Ticket> getAllTickets() {
     return ticketRepository.findAll();
 }

 public void removeUser(Long ticketId) {
     Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
     if (ticket != null) {
         TrainSeatAllocator.deallocateSeat(ticket.getSeatSection());
         ticketRepository.deleteById(ticketId);
         System.out.println("Deletion successful. Ticket with ID " + ticketId + " removed.");
     }
 }

 public Ticket modifyUserSeat(Long ticketId, char newSeatSection) {
     Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
     if (ticket != null) {
         TrainSeatAllocator.deallocateSeat(ticket.getSeatSection());
         ticket.setSeatSection(newSeatSection);
         TrainSeatAllocator.allocateSeat();
         Ticket updatedTicket = ticketRepository.save(ticket);
         System.out.println("Update successful. Ticket with ID " + ticketId + " modified.");
         return updatedTicket;
     }
     return null;
 }
 public Ticket getTicketById(Long ticketId) {
     return ticketRepository.findById(ticketId).orElse(null);
 }
 public List<Ticket> getTicketsBySection(char section) {
     return ticketRepository.findBySeatSection(section);
 }
}
