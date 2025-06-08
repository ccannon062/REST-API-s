package com.schedule.eventz.repositories;

import com.schedule.eventz.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByLocation(String location);
    List<Event> findByStartTimeAfter(LocalDateTime dateTime);
    List<Event> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
