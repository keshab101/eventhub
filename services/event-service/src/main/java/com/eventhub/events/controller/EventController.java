package com.eventhub.events.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventhub.events.entity.Event;
import com.eventhub.events.services.EventService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

	private final EventService service;

    @PostMapping
    public Event create(@RequestBody Event event) {
        return service.create(event);
    }

    @GetMapping
    public List<Event> getAll() {
        return service.getAll();
    }

}
