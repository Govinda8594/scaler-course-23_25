package com.scaler.LLDProject.Tictactoe.strategy;


import com.scaler.LLDProject.Tictactoe.models.Board;
import com.scaler.LLDProject.Tictactoe.models.Cell;

public interface BotPlayerStrategy {
    Cell makeMove(Board board);
}
