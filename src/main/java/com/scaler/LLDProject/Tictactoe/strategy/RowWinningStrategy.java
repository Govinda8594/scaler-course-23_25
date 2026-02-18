package com.scaler.LLDProject.Tictactoe.strategy;


import com.scaler.LLDProject.Tictactoe.models.Board;
import com.scaler.LLDProject.Tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {
    Map<Integer, Map<Character, Integer>> rowMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Character symbol = move.getPlayer().getSymbol();
        if (!rowMaps.containsKey(row)) {
            rowMaps.put(row, new HashMap<>());
        }
        Map<Character, Integer> rowMap = rowMaps.get(row);
        if (!rowMap.containsKey(symbol)) {
            rowMap.put(symbol, 0);
        }
        rowMap.put(symbol, rowMap.get(symbol) + 1);
        return rowMap.get(symbol).equals(board.getDimension());
    }

    @Override
    public void handelUndo(Board board, Move lastmove) {

        int row = lastmove.getCell().getRow();
        Character symbol = lastmove.getPlayer().getSymbol();

        Map<Character, Integer> rowMap = rowMaps.get(row);
        rowMap.put(symbol, rowMap.get(symbol) - 1);
    }
}
