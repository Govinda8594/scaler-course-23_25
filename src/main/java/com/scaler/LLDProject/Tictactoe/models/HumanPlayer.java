package com.scaler.LLDProject.Tictactoe.models;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private static final Scanner sc = new Scanner(System.in);

    public HumanPlayer(Character symbol, String name, int id, PlayerType playerType) {
        super(symbol, name, id, playerType);
    }

    @Override
    public Cell makeMove(Board board) {
        System.out.println(this.getName() + ", It's your turn to make a move.enter row and col");
        int row = sc.nextInt();
        int col = sc.nextInt();
        while (!validateRowAndCol(row, col, board)) {
            System.out.println(",Invalid Move, Please enter row and col again!");
            row = sc.nextInt();
            col = sc.nextInt();
        }
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;
    }

    private boolean validateRowAndCol(int row, int col, Board board) {
        if (row >= board.getDimension() || row < 0) {
            return false;
        }
        if (col >= board.getDimension() || col < 0) {
            return false;
        }
        if (CellState.FILLED.equals(board.getBoard().get(row).get(col).getCellState())) {
            return false;
        }
        return true;
    }
}
