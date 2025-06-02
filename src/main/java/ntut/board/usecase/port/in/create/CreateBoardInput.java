package ntut.board.usecase.port.in.create;

public class CreateBoardInput {
  private String teamId;
  private String userId;
  private String name;
  
  public void setTeamId(String teamId){
    this.teamId = teamId;
  }

  public void setUserId(String userId){
    this.userId = userId;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getTeamId(){
    return this.teamId;
  }

  public String getUserId(){
    return this.userId;
  }

  public String getName(){
    return this.name;
  }
}



