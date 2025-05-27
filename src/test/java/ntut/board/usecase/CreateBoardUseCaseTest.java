package ntut.usecase;

import ntut.entity.Board;
import ntut.entity.BoardMember;
import ntut.entity.BoardMemberType;
import ntut.usecase.CreateBoardInput;
import ntut.usecase.CreateBoardUseCase;
import ntut.usecase.CqrsOutput;
import ntut.usecase.ExitCode;
import ntut.port.InMemoryBoardRepository;
import ntut.usecase.BoardRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateBoardUseCaseTest {

    private BoardRepository boardRepository;
    private CreateBoardUseCase useCase;

    private final String teamId = "team-123";
    private final String boardName = "Sample Board";
    private final String userId = "user-456";

    @BeforeEach
    public void setUp() {
        boardRepository = new InMemoryBoardRepository();
        useCase = new CreateBoardUseCase(boardRepository);
    }

    @Test
    public void should_succeed_when_create_board_in_team() {
        CreateBoardInput input = new CreateBoardInput();
        input.setTeamId(teamId);
        input.setName(boardName);
        input.setUserId(userId);

        CqrsOutput output = useCase.execute(input);

        assertNotNull(output.getId());
        assertEquals(ExitCode.SUCCESS, output.getExitCode());

        Board board = boardRepository.findById(output.getId()).orElseThrow();
        assertEquals(output.getId(), board.getBoardId());
        assertEquals(boardName, board.getName());
        assertEquals(teamId, board.getTeamId());

        BoardMember boardMember = board.getBoardMemberById(userId).orElseThrow();
        assertEquals(userId, boardMember.getUserId());
        assertEquals(board.getBoardId(), boardMember.getBoardId());
        assertEquals(BoardMemberType.Manager, boardMember.getMemberType());
    }
}

