package ntut.ddd.entity;

import java.util.List;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class AggregateRoot<ID> implements Entity<ID>{
  protected final ID id;
  private final List<DomainEvent> domainEvents;
  protected boolean isDeleted;

  public AggregateRoot(ID id) {
    this.id = id;
    this.domainEvents = new CopyOnWriteArrayList<>();
  }

  public void addDomainEvent(DomainEvent domainEvent) {
    this.domainEvents.add(domainEvent);
  }

  public List<DomainEvent> getDomainEvents() {
    return Collections.unmodifiableList(this.domainEvents);
  }

  public void clearDomainEvents(){
    this.domainEvents.clear();
  }

  public ID getId(){
    return this.id;
  }
}
