package com.scaler.LLDProject.Tictactoe.strategy;


import com.scaler.LLDProject.Tictactoe.models.Board;
import com.scaler.LLDProject.Tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {

    Map<Character, Integer> leftDiaMap = new HashMap<Character, Integer>();
    Map<Character, Integer> rightDiaMap = new HashMap<Character, Integer>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();
        Character symbol = move.getPlayer().getSymbol();
        if (row == column) {
            if (!leftDiaMap.containsKey(symbol)) {
                leftDiaMap.put(symbol, 0);
            }
            leftDiaMap.put(symbol, leftDiaMap.get(symbol) + 1);
            if (leftDiaMap.get(symbol).equals(board.getDimension())) {
                return true;
            }
        }
        if (row + column == board.getDimension() - 1) {
            if (!rightDiaMap.containsKey(symbol)) {
                rightDiaMap.put(symbol, 0);
            }
            rightDiaMap.put(symbol, rightDiaMap.get(symbol) + 1);
            if (rightDiaMap.get(symbol).equals(board.getDimension())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void handelUndo(Board board, Move lastmove) {

        int row = lastmove.getCell().getRow();
        ;
        int col = lastmove.getCell().getColumn();
        ;
        Character symbol = lastmove.getPlayer().getSymbol();
        if (row == col) {
            leftDiaMap.put(symbol, leftDiaMap.get(symbol) - 1);
        }
        if (row + col == board.getDimension() - 1) {
            rightDiaMap.put(symbol, rightDiaMap.get(symbol) - 1);
        }
    }
}
