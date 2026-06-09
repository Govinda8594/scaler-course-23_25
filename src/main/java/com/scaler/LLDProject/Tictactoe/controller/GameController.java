package com.scaler.LLDProject.Tictactoe.controller;

import com.scaler.LLDProject.Tictactoe.exception.DuplicateSysmbolException;
import com.scaler.LLDProject.Tictactoe.exception.MoreThanOneBotException;
import com.scaler.LLDProject.Tictactoe.exception.PlayerAndBotCountMismatchException;
import com.scaler.LLDProject.Tictactoe.models.Game;
import com.scaler.LLDProject.Tictactoe.models.Player;
import com.scaler.LLDProject.Tictactoe.strategy.WinningStrategy;

import java.util.List;

public class GameController {

    public Game createGame(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategies) throws DuplicateSysmbolException, MoreThanOneBotException, PlayerAndBotCountMismatchException {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(playerList)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public void undo(Game game) {
        game.undo();
    }
}
