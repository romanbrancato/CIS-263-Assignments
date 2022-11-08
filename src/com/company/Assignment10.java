package com.company;

import java.util.*;

class Graph {
    int V;

    //Uses array of lists for adjacency
    LinkedList<Integer> adjacencyList[];

    Graph(int v){
        V = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjacencyList[i] = new LinkedList();
    }

    void addEdge(int v, int w){
        adjacencyList[v].add(w);
    }

    //THE FOLLOWING CODE WAS REFERENCED FROM: https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
    void DFSUtil(int v, boolean visited[]){
        //Mark the current node as visited and print it
        if(v <= V) {
            visited[v] = true;
        }else{
            System.out.print("Node is not in graph");
            return;
        }
        System.out.print(v + " ");

        //Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adjacencyList[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void DFS(int v){
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        DFSUtil(v, visited);
    }

    //THE FOLLOWING CODE WAS REFERENCED FROM: https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
    void BFS(int s){
        //Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        //Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        //Mark the current node as visited and enqueue it
        if(s <= V) {
            visited[s] = true;
        }else{
            System.out.print("Node is not in graph");
            return;
        }
        queue.add(s);

        while (queue.size() != 0) {
            //Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            //Get all adjacent vertices of the dequeued vertex s
            //If an adjacent has not been visited, then mark it visited and enqueue it
            Iterator<Integer> i = adjacencyList[s].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    //THE FOLLOWING CODE WAS REFERENCED FROM: https://www.geeksforgeeks.org/java-program-for-topological-sorting/
    void topologicalSortUtil(int v, boolean visited[], Stack s){
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adjacencyList[v].iterator();
        while(it.hasNext()){
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, s);
        }

        // Push current vertex to stack which stores result
        s.push(v);
    }

    void topologicalSort(){
        Stack s = new Stack();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        // Call the recursive helper function to store Topological Sort starting from all vertices one by one
        for (int i = 0; i < V; i++) {
            if (visited[i] == false)
                topologicalSortUtil(i, visited, s);
        }
        //Print contents of stack
        while (s.empty()==false) {
            System.out.print(s.pop() + " ");
        }
    }

    //THE FOLLOWING CODE WAS REFERENCED FROM: https://www.geeksforgeeks.org/strongly-connected-components/
    Graph getTranspose(){
        Graph g = new Graph(V);
        for (int v = 0; v < V; v++) {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adjacencyList[v].listIterator();
            while(i.hasNext())
                g.adjacencyList[i.next()].add(v);
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack s) {
        // Mark the current node as visited and print it
        visited[v] = true;
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adjacencyList[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if(!visited[n])
                fillOrder(n, visited, s);
        }
        // All vertices reachable from v are processed by now, push v to Stack
        s.push(v);
    }

    void findSCCs(){
        Stack s = new Stack();
        // Mark all the vertices as not visited (For first DFS)
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++) {
            visited[i] = false;
        }
        // Fill vertices in stack according to their finishing times
        for (int i = 0; i < V; i++) {
            if (visited[i] == false)
                fillOrder(i, visited, s);
        }
        // Create a reversed graph
        Graph gr = getTranspose();
        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        // Now process all vertices in order defined by Stack
        while (s.empty() == false) {
            // Pop a vertex from stack
            int v = (int)s.pop();
            // Print Strongly connected component of the popped vertex
            if (visited[v] == false) {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String args[]){
        Graph g = new Graph(13);

        g.addEdge(1, 2);
        g.addEdge(2, 6);
        g.addEdge(3, 4);
        g.addEdge(4, 8);
        g.addEdge(5, 1);
        g.addEdge(6, 3);
        g.addEdge(7, 3);
        g.addEdge(7, 8);
        g.addEdge(7, 11);
        g.addEdge(9, 5);
        g.addEdge(9, 10);
        g.addEdge(10, 5);
        g.addEdge(10, 6);
        g.addEdge(10, 11);
        g.addEdge(11, 12);
        g.addEdge(12, 8);

        System.out.println("Depth First Traversal (starting from vertex 2)");
        g.DFS(2);

        System.out.println();

        System.out.println("Depth First Traversal (starting from vertex 7)");
        g.DFS(7);

        System.out.println();

        System.out.println("Depth First Traversal (starting from vertex 15)");
        g.DFS(15);

        System.out.println();

        System.out.println("Breadth First Traversal (starting from vertex 7)");
        g.BFS(7);

        System.out.println();

        System.out.println("Breadth First Traversal (starting from vertex 2)");
        g.BFS(2);

        System.out.println();

        System.out.println("Breadth First Traversal (starting from vertex 14)");
        g.BFS(14);

        System.out.println();

        System.out.println("Topological sort of the given graph");
        g.topologicalSort();

        System.out.println();

        Graph g2 = new Graph(13);
        g2.addEdge(1, 5);
        g2.addEdge(2, 1);
        g2.addEdge(3, 2);
        g2.addEdge(2, 7);
        g2.addEdge(3, 4);
        g2.addEdge(4, 8);
        g2.addEdge(5, 2);
        g2.addEdge(5, 6);
        g2.addEdge(5, 9);
        g2.addEdge(6, 2);
        g2.addEdge(6, 10);
        g2.addEdge(7, 3);
        g2.addEdge(7, 6);
        g2.addEdge(7, 8);
        g2.addEdge(7, 11);
        g2.addEdge(8, 12);
        g2.addEdge(10, 9);
        g2.addEdge(12, 7);

        System.out.println("Following are strongly connected components in given graph ");
        g2.findSCCs();
    }
}
