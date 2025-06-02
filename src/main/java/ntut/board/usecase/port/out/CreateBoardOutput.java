package ntut.board.usecase.port.out;

public class CreateBoardOutput {
  private String id;

  public CreateBoardOutput(String id){
    this.id = id;
  }

  public String getId(){
    return this.id;
  }
}


