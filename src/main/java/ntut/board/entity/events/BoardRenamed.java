package ntut.board.entity.events;

import ntut.ddd.entity.DomainEvent;
import java.time.LocalDateTime;

public class BoardRenamed extends DomainEvent {
  private String teamId;
  private String boardId;
  private String oldName;
  private String newName;

  public BoardRenamed(String teamId, String boardId, String newName, String oldName){
    super(LocalDateTime.now());
    this.teamId = teamId;
    this.boardId = boardId;
    this.oldName = oldName;
    this.newName = newName;
  }

  public String teamId() {
    return this.teamId;
  } 

  public String boardId() {
    return this.boardId;
  } 

  public String oldName() {
    return this.oldName;
  } 

  public String newName() {
    return this.newName;
  } 
}
