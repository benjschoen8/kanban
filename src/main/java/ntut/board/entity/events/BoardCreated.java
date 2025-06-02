package ntut.board.entity.events;

import ntut.ddd.entity.DomainEvent;
import java.time.LocalDateTime;

public class BoardCreated extends DomainEvent {
  private String teamId;
  private String boardId;
  private String name;
  private String userId;

  public BoardCreated(String teamId, String boardId, String name, String userId){
    super(LocalDateTime.now());
    this.teamId = teamId;
    this.boardId = boardId;
    this.name = name;
    this.userId = userId;
  }

  public String teamId() {
    return this.teamId;
  } 

  public String boardId() {
    return this.boardId;
  } 

  public String name() {
    return this.name;
  } 

  public String userId() {
    return this.userId;
  } 
}
