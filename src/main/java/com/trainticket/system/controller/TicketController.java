package com.trainticket.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trainticket.system.model.Ticket;
import com.trainticket.system.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestBody Ticket ticket) {
        return ticketService.purchaseTicket(ticket);
    }

    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @DeleteMapping("/remove/{ticketId}")
    public ResponseEntity<String> removeUser(@PathVariable Long ticketId) {
        ticketService.removeUser(ticketId);
        return ResponseEntity.ok("Deletion successful.Ticket with ID " + ticketId + " removed.");
    }
    

    @PutMapping("/modifySeat/{ticketId}")
    public ResponseEntity<String> modifyUserSeat(
            @PathVariable Long ticketId,
            @RequestParam char newSeatSection) {
        Ticket updatedTicket = ticketService.modifyUserSeat(ticketId, newSeatSection);

        if (updatedTicket != null) {
            return ResponseEntity.ok("Update successful. Ticket with ID " + ticketId + " modified.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/receipt/{ticketId}")
    public Ticket getReceiptDetails(@PathVariable Long ticketId) {
        return ticketService.getTicketById(ticketId);
    }
    @GetMapping("/usersBySection/{section}")
    public List<Ticket> getUsersBySection(@PathVariable char section) {
        return ticketService.getTicketsBySection(section);
    }
}
