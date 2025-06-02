package ntut.board.entity;

import java.util.UUID;

public class BoardBuilder {
  private String userId;
  private String teamId;
  private String name;
  private String boardId;

  public static BoardBuilder newInstance() {
    return new BoardBuilder();
  }

  public BoardBuilder userId(String userId) {
    this.userId = userId;
    return this;
  }

  public BoardBuilder name(String name){
    this.name = name;
    return this;
  }

  public BoardBuilder teamId(String teamId){
    this.teamId = teamId;
    return this;
  }

  public Board build(){
    this.boardId = UUID.randomUUID().toString();
    Board board = new Board(teamId, boardId, name, userId);
    return board;
  }
}
