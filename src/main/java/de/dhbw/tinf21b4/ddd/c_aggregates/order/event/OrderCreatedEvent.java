package de.dhbw.tinf21b4.ddd.c_aggregates.order.event;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record OrderCreatedEvent(UUID eventId, Instant eventCreatedAt, UUID orderId) {

    public OrderCreatedEvent {
        Objects.requireNonNull(eventId);
        Objects.requireNonNull(eventCreatedAt);
        Objects.requireNonNull(orderId);
    }

    public OrderCreatedEvent(Instant eventCreatedAt, UUID orderId) {
        this(UUID.randomUUID(), eventCreatedAt, orderId);
    }
}
