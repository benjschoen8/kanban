package ntut.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateBoardUseCaseTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void should_succeed_when_create_board_in_team() {
        CreateWorkflowInput input = new CreateWorkflowInput();
        input.getBoardId(boardId);
        input.setName(workflowName);


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

