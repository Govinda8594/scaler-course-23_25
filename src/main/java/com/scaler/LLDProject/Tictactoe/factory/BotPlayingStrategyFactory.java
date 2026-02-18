package com.scaler.LLDProject.Tictactoe.factory;


import com.scaler.LLDProject.Tictactoe.models.DifficultyLevel;
import com.scaler.LLDProject.Tictactoe.strategy.BotPlayerStrategy;
import com.scaler.LLDProject.Tictactoe.strategy.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayerStrategy getBotPlayingStrategy(DifficultyLevel difficultyLevel) {
        return new EasyBotPlayingStrategy();
    }
}
