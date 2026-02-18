package com.scaler.LLDProject.Tictactoe.strategy;

import com.scaler.LLDProject.Tictactoe.models.Board;
import com.scaler.LLDProject.Tictactoe.models.Move;

public interface WinningStrategy {

    boolean checkWinner(Board board, Move move);

    void handelUndo(Board board, Move lastmove);
}
