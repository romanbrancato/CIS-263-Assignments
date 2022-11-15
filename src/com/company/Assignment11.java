package com.company;

import java.lang.*;
import java.util.*;

class FordFulkerson {
    //Number of vertices
    int V = 6;

    //Returns true if there is a path from source to sink in residual graph
    boolean BFS(int[][] residualGraph, int source, int sink, int[] parent){
        // Create a visited array and mark all vertices as not visited
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            visited[i] = false;
        }

        //Create a queue and enqueue source vertex and mark source vertex as visited
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (queue.size() != 0){
            int u = queue.poll();

            for(int v = 0; v < V; v++){
                if(!visited[v] && residualGraph[u][v] > 0){
                    //If a connection is found to the sink node halt bfs and set its parent and return true
                    if(v == sink){
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        //No connection found
        return false;
    }

    //FOLLOWING METHOD REFERENCED FROM: https://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/
    int fordFulkerson(int[][] graph, int source, int sink){
        int u, v;

        //Create a residual graph based on original
        int[][] residualGraph = new int[V][V];

        for(u = 0; u < V; u++){
            for(v = 0; v < V; v++){
                residualGraph[u][v] = graph[u][v];
            }
        }

        //Parent array filled by BFS and to store path
        int[] parent = new int[V];

        //Initialize flow to 0
        int maxFlow = 0;

        //Augment the flow while there is path from source to sink
        while(BFS(residualGraph, source, sink, parent)){
            int pathFlow = Integer.MAX_VALUE;
            for(v = sink; v != source; v = parent[v]){
                u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            //Update residual capacities of the edges and reverse edges along the path
            for(v = sink; v != source; v = parent[v]){
                u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }
            //Adding path flow to total flow
            maxFlow += pathFlow;
        }
        return maxFlow;
    }

    public static void main(String[] args){
        int[][] graph = new int[][]{
                {0, 4, 2, 0, 0, 0}, // source
                {0, 0, 1, 2, 4, 0}, // a
                {0, 0, 0, 0, 2, 0}, // b
                {0, 0, 0, 0, 0, 3}, // c
                {0, 0, 0, 0, 0, 3}, // d
                {0, 0, 0, 0, 0, 0}  // sink
        };

        FordFulkerson m = new FordFulkerson();

        System.out.println("Max Flow is " + m.fordFulkerson(graph, 0, 5));
    }
}
