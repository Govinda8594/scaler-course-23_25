package com.scaler.LLDProject.Tictactoe.models;

import com.scaler.LLDProject.Tictactoe.exception.DuplicateSysmbolException;
import com.scaler.LLDProject.Tictactoe.exception.MoreThanOneBotException;
import com.scaler.LLDProject.Tictactoe.exception.PlayerAndBotCountMismatchException;
import com.scaler.LLDProject.Tictactoe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    private List<Player> playerList;
    private Board board;
    private Player winner;
    private GameState gamestate;
    private int nextPlayerIndex;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategies;

    private Game(List<Player> players, int dimension, List<WinningStrategy> winningStrategies) {
        this.playerList = players;
        this.board = new Board(dimension);
        this.gamestate = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.moves = new ArrayList<>();
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGamestate() {
        return gamestate;
    }

    public void setGamestate(GameState gamestate) {
        this.gamestate = gamestate;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void printBoard() {
        board.printBoard();
    }

    public void makeMove() {
        Player player = playerList.get(nextPlayerIndex);
        Cell cell = player.makeMove(board);
        Move move = new Move(cell, player);
        moves.add(move);
        if (checkWinner(move, board)) {
            gamestate = GameState.CONCLUDED;
            winner = player;
            return;
        }
        if (moves.size() == board.getDimension() * board.getDimension()) {
            gamestate = GameState.DRAW;
            return;
        }
        nextPlayerIndex++;
        nextPlayerIndex = nextPlayerIndex % playerList.size();
    }

    private boolean checkWinner(Move move, Board board) {
        for (WinningStrategy strategy : winningStrategies) {
            if (strategy.checkWinner(board, move))
                return true;
        }
        return false;
    }

    public void undo() {
        if (moves.size() == 0) {
            System.out.println("No moves to undo");
            return;
        }
        Move lastmove = moves.get(moves.size() - 1);
        moves.remove(lastmove);
        Cell cell = lastmove.getCell();
        cell.setPlayer(null);
        cell.setCellState(CellState.EMPTY);
        for (WinningStrategy strategy : winningStrategies) {
            strategy.handelUndo(board, lastmove);
        }
        if (nextPlayerIndex != 0) {
            nextPlayerIndex--;
        } else {
            nextPlayerIndex = playerList.size() - 1;
        }
    }

    public static class Builder {
        private List<Player> players;
        private int dimension;

        private List<WinningStrategy> winningStrategies;

        private Builder() {
            this.players = new ArrayList<>();
            this.dimension = 0;
//            this.winningStrategies = new ArrayList<>();
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Game build() throws MoreThanOneBotException, PlayerAndBotCountMismatchException, DuplicateSysmbolException {
            validateBotCount();
            validateDimensionAndPlayerCount();
            validateUniqueSysmbolForEachPlayer();
            return new Game(players, dimension, winningStrategies);
        }

        private void validateUniqueSysmbolForEachPlayer() throws DuplicateSysmbolException {
            HashSet<Character> symbol = new HashSet<Character>();
            for (Player player : players) {
                if (symbol.contains(player.getSymbol())) {
                    throw new DuplicateSysmbolException();
                }
                symbol.add(player.getSymbol());
            }
        }

        private void validateDimensionAndPlayerCount() throws PlayerAndBotCountMismatchException {
            if (players.size() != dimension - 1) {
                throw new PlayerAndBotCountMismatchException();
            }
        }

        private void validateBotCount() throws MoreThanOneBotException {
            int botcount = 0;
            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botcount++;
                }
                if (botcount > 1) {
                    throw new MoreThanOneBotException();
                }
            }
        }
    }
}
