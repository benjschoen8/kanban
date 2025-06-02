package ntut.board.usecase.port.out;

import ntut.board.entity.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BoardRepository {
    private Map<String, Board> boards = new HashMap<>();

    public void save(Board board) {

        // use memory repository
        boards.put(board.getBoardId(), board);
    }
    
    public Board findById(String boardId) {
        return boards.get(boardId);
    }
}
