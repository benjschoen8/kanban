package ntut.ddd.usecase;

import ntut.ddd.entity.AggregateRoot;
import ntut.ddd.entity.DomainEvent;

public interface DomainEventBus {
  
  void post(DomainEvent DomainEvent);
  void postAll(AggregateRoot aggregateRoot);
  void register(Object object);
  void unregister(Object object);
}
