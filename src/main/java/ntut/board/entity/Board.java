package ntut.board.entity;

import ntut.ddd.entity.AggregateRoot;
import ntut.board.entity.events.*;

public class Board extends AggregateRoot{
  private String teamId;
  private String name;

  public Board(String teamId, String boardId, String name, String userId){
    super(boardId);
    this.name = name;
    this.teamId = teamId;
    this.addDomainEvent(new BoardCreated(teamId, boardId, name, userId));
  }

  public void setName(String newName){
    if (this.name.equals(newName)){
      return;
    }
    String oldName = this.name;
    this.name = newName;
    this.addDomainEvent(new BoardRenamed(this.teamId, this.getBoardId(), oldName, newName));
  }

  public String getBoardId() {
    return getId().toString();
  }

  public String getName(){
    return this.name;
  }
}
