package com.rbhatt.order.notification.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
  name = "webhook_events",
  uniqueConstraints = {
    @UniqueConstraint(columnNames = "event_id")
  }
)
@Getter @Setter
public class WebhookEvent {
    
    @Id
  @GeneratedValue
  private UUID id;

  @Column(name = "event_id", nullable = false)
  private String eventId;

  @Column(name = "event_type", nullable = false)
  private String eventType;

  @Lob
  @Column(nullable = false)
  private String payload;

  private String signature;

  private Instant receivedAt;

  private Instant processedAt;

  @Enumerated(EnumType.STRING)
  private Status status;

  private int attemptCount;

  private String lastError;

  public enum Status {
    RECEIVED, PROCESSING, PROCESSED, FAILED, DEAD_LETTER
  }

}