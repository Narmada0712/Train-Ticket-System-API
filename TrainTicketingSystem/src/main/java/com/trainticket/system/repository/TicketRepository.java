package com.trainticket.system.repository;

import java.util.List;

//TicketRepository.java

// TrainTicketRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import com.trainticket.system.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Additional query methods can be defined if needed
	List<Ticket> findBySeatSection(char section);
}


