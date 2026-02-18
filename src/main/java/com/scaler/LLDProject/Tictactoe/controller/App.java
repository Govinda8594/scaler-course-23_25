package com.scaler.LLDProject.Tictactoe.controller;


import com.scaler.LLDProject.Tictactoe.exception.DuplicateSysmbolException;
import com.scaler.LLDProject.Tictactoe.exception.MoreThanOneBotException;
import com.scaler.LLDProject.Tictactoe.exception.PlayerAndBotCountMismatchException;
import com.scaler.LLDProject.Tictactoe.models.*;
import com.scaler.LLDProject.Tictactoe.strategy.ColumnWinningStrategy;
import com.scaler.LLDProject.Tictactoe.strategy.DiagonalWinningStrategy;
import com.scaler.LLDProject.Tictactoe.strategy.RowWinningStrategy;
import com.scaler.LLDProject.Tictactoe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws DuplicateSysmbolException, MoreThanOneBotException, PlayerAndBotCountMismatchException {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
        int dimension = 3;
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new HumanPlayer('X', "Govinda", 1, PlayerType.HUMAN));
        players.add(new Bot('0', "GPT", 2, PlayerType.BOT, DifficultyLevel.EASY));
//        players.add(new HumanPlayer('0',"BARD",3,PlayerType.HUMAN));
//        players.add(new HumanPlayer('0',"GJ",2,PlayerType.HUMAN));

        ArrayList<WinningStrategy> strategies = new ArrayList<WinningStrategy>();
        strategies.add(new RowWinningStrategy());
        strategies.add(new ColumnWinningStrategy());
        strategies.add(new DiagonalWinningStrategy());

        Game game = gameController.createGame(dimension, players, strategies);

        while (GameState.IN_PROGRESS.equals(game.getGamestate())) {
            gameController.printBoard(game);
            System.out.println("Does anyone want to undo ? (y/n)");
            String undo = scanner.next();
            if (undo.equalsIgnoreCase("y")) {
                gameController.undo(game);
                continue;
            }
            gameController.makeMove(game);
        }

        if (GameState.CONCLUDED.equals(game.getGamestate())) {
            System.out.println(game.getWinner().getName() + " has won the game");
        }

        if (GameState.DRAW.equals(game.getGamestate())) {
            System.out.println("Its a draw");
        }
    }
}
