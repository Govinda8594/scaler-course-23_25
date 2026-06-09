package com.scaler.Scaler.Graph;
//Given the number of vertices A in a Cyclic Graph.
//        Your task is to determine the minimum number of colors required to color the graph so that no two Adjacent vertices have the same color.
//        A cyclic graph with A vertices is a graph with A edges, such that it forms a loop. See example test case explanation for more details.
//
//        Problem Constraints
//        3 <= A <= 109

public class Coloring_A_Cycle_Graph {

    public int solve(int vertices) {
        // Check if number of vertices
        // is odd or even.
        // If number of vertices is even
        // then color require is 2 otherwise 3
        if (vertices % 2 == 0)
            return 2;
        return 3;
    }
}
