package com.scaler.LLDProject.Splitwise.strategies;

import com.scaler.LLDProject.Splitwise.dto.Transaction;

import java.util.List;
import java.util.Map;

public interface SettleStrategies {
    List<Transaction> settleUpGroup(Map<String, Integer> settle);
}
