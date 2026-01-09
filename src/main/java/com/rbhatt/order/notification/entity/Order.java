package com.rbhatt.order.notification.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String customerEmail;

    private BigDecimal amount;

    private Instant createdAt;
    private Instant updatedAt;

    public enum Status {
        CREATED, PAID, SHIPPED, FAILED
      }
}
