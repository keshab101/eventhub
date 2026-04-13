package com.eventhub.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eventhub.events.entity.Event;
import com.eventhub.events.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {

	private final EventRepository repo;

    public Event create(Event event) {
        event.setAvailableSeats(event.getTotalSeats());
        return repo.save(event);
    }

    public List<Event> getAll() {
        return repo.findAll();
    }
    
}
