package com.schedule.eventz;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.schedule.eventz.models.Event;
import com.schedule.eventz.repositories.EventRepository;
import com.schedule.eventz.service.EventService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EventRepository eventRepository;
    private final EventService eventService;
    private final ResourceLoader resourceLoader;

    public DataInitializer(EventRepository eventRepository, EventService eventService, ResourceLoader resourceLoader) {
        this.eventRepository = eventRepository;
        this.eventService = eventService;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void run(String... args) throws Exception {
        if (eventRepository.count() == 0) {
            Resource resource = resourceLoader.getResource("classpath:dummy-events.json");
            try (InputStream inputStream = resource.getInputStream()) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                List<Event> events = objectMapper.readValue(inputStream, new TypeReference<List<Event>>() {});
                for (Event event : events) {
                    eventService.saveEvent(event);
                }
            }
        }
    }
}
