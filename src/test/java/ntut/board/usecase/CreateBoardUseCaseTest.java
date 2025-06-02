package ntut.board.usecase;

import ntut.board.entity.Board;
import ntut.board.usecase.port.in.create.CreateBoardUseCase;
import ntut.board.usecase.port.in.create.CreateBoardInput;
import ntut.board.usecase.port.out.BoardRepository;
import ntut.board.usecase.port.out.CreateBoardOutput;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateBoardUseCaseTest {
    @Test
    public void createBoardUseCaseTest() {
        CreateBoardInput input = new CreateBoardInput();
        input.setUserId("userId");
        input.setTeamId("teamId");
        input.setName("boardName");
        BoardRepository repository = new BoardRepository(); 
        CreateBoardUseCase useCase = new CreateBoardUseCase(repository); // 建立 Use Case 實例
 
        CreateBoardOutput output = useCase.execute(input);      // 用物件來呼叫

        // Simulate fetching the saved board from the repository
        Board savedBoard = repository.findById(output.getId());

        //assertions
        assertNotNull(output.getId());
        assertEquals("boardName", savedBoard.getName());
        assertEquals(output.getId(), savedBoard.getId());
    }
    
}

