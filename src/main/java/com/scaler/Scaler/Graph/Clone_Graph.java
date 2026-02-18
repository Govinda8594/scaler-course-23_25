package com.scaler.Scaler.Graph;

import java.util.*;

//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//        Note: The test cases are generated in the following format (use the following format to use See Expected Output option):
//        First integer N is the number of nodes.
//        Then, N intgers follow denoting the label (or hash) of the N nodes.
//        Then, N2 integers following denoting the adjacency matrix of a graph, where Adj[i][j] = 1 denotes presence of an undirected edge between the ith and jth node, O otherwise.
//        Problem Constraints
//        1 <= Number of nodes <= 105

public class Clone_Graph {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map;

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return auxCloneGraph(node);
    }

    public UndirectedGraphNode auxCloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                clone.neighbors.add(auxCloneGraph(neighbor));
            } else clone.neighbors.add(map.get(neighbor));

        }
        return clone;
    }

    /////////////////////////////////Iterative ////////////////
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        // Map to store the mapping of original nodes to cloned nodes
        HashMap<UndirectedGraphNode, UndirectedGraphNode> cloneMap = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        // Clone the root node and add it to the map and queue
        UndirectedGraphNode clonedRoot = new UndirectedGraphNode(node.label);
        cloneMap.put(node, clonedRoot);
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            // Iterate through the neighbors of the current node
            for (UndirectedGraphNode neighbor : current.neighbors) {
                if (!cloneMap.containsKey(neighbor)) {
                    // If the neighbor is not cloned yet, create a new cloned node
                    UndirectedGraphNode clonedNeighbor = new UndirectedGraphNode(neighbor.label);
                    cloneMap.put(neighbor, clonedNeighbor);
                    // Add the cloned neighbor to the neighbors of the cloned current node
                    cloneMap.get(current).neighbors.add(clonedNeighbor);
                    // Add the neighbor to the queue for processing its neighbors
                    queue.offer(neighbor);
                } else {
                    // If the neighbor is already cloned, add it to the neighbors of the cloned current node
                    cloneMap.get(current).neighbors.add(cloneMap.get(neighbor));
                }
            }
        }
        return clonedRoot;
    }

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}


