package ntut.ddd.entity;

import java.io.Serializable;
import java.util.UUID;

public interface Entity<ID> extends Serializable {
  ID getId();
}

