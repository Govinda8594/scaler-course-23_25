package com.scaler.LLDProject.Tictactoe.models;


import com.scaler.LLDProject.Tictactoe.factory.BotPlayingStrategyFactory;
import com.scaler.LLDProject.Tictactoe.strategy.BotPlayerStrategy;

public class Bot extends Player {
    private DifficultyLevel difficulty;
    private BotPlayerStrategy botPlayerStrategy;

    public Bot(Character symbol, String name, int id, PlayerType playerType, DifficultyLevel difficultyLevel) {
        super(symbol, name, id, playerType);
        this.difficulty = difficultyLevel;
        this.botPlayerStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficulty;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficulty = difficultyLevel;
    }

    @Override
    public Cell makeMove(Board board) {
        System.out.println("Bot is making the move");
        Cell cell = botPlayerStrategy.makeMove(board);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;
    }
}
