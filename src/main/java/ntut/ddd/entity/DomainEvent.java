package ntut.ddd.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class DomainEvent{
  private final UUID id;
  private final LocalDateTime occurredOn;

  public DomainEvent(LocalDateTime occurredOn) {
    this.id = UUID.randomUUID();
    this.occurredOn = occurredOn;
  }

  public LocalDateTime occurredOn() {
    return this.occurredOn;
  }

  public UUID id() {
    return this.id;
  }
}
