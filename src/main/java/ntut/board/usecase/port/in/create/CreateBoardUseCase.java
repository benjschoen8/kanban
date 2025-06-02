package ntut.board.usecase.port.in.create;

import ntut.board.entity.Board;
import ntut.board.entity.BoardBuilder;
import ntut.board.usecase.port.out.BoardRepository;
import ntut.board.usecase.port.out.CreateBoardOutput;

public class CreateBoardUseCase {
  private BoardRepository boardRepository;

  public CreateBoardUseCase(BoardRepository boardRepository){
    this.boardRepository = boardRepository;
  }

  public CreateBoardOutput execute(CreateBoardInput input){
    Board board = BoardBuilder.newInstance()
                              .name(input.getName())
                              .teamId(input.getTeamId())
                              .userId(input.getUserId())
                              .build();
    boardRepository.save(board);
    return new CreateBoardOutput(board.getBoardId());
  }
}
