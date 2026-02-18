package com.scaler.LLDProject.Tictactoe.strategy;


import com.scaler.LLDProject.Tictactoe.models.Board;
import com.scaler.LLDProject.Tictactoe.models.Cell;
import com.scaler.LLDProject.Tictactoe.models.CellState;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayerStrategy {
    @Override
    public Cell makeMove(Board board) {
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (CellState.EMPTY.equals(cell.getCellState())) {
                    return cell;
                }
            }
        }
        return null;
    }
}
