package ru.practicum.events.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.events.model.EventsSort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@NoArgsConstructor
public class PublicEventRequests {
    private String text;
    private List<Long> categories;
    private Boolean paid;
    private LocalDateTime rangeStart;
    private LocalDateTime rangeEnd;
    private Boolean onlyAvailable;
    private EventsSort sortEvents;
    private Integer from;
    private Integer size;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static PublicEventRequests of(String text,
                                         List<Long> categories,
                                         String paid,
                                         String rangeStart,
                                         String rangeEnd,
                                         String onlyAvailable,
                                         String sort,
                                         Integer from,
                                         Integer size) {
        PublicEventRequests request = new PublicEventRequests();
        request.setText(text);
        if (paid != null) {
            request.setPaid(Boolean.parseBoolean(paid));
        }

        if (rangeStart != null) {
            request.setRangeStart(LocalDateTime.parse(rangeStart, formatter));
        }

        if (rangeEnd != null) {
            request.setRangeEnd(LocalDateTime.parse(rangeEnd, formatter));
        }

        if (onlyAvailable != null) {
            request.setOnlyAvailable(Boolean.parseBoolean(onlyAvailable));
        }

        if (sort != null) {
            request.setSortEvents(EventsSort.valueOf(sort.toUpperCase()));
        }

        request.setFrom(from);
        request.setSize(size);

        if (categories != null) {
            request.setCategories(categories);
        }

        return request;
    }

    public boolean hasCategories() {
        return categories != null && !categories.isEmpty();
    }
}