package com.me.graph.impl;

/**
 * Implementation of Warshall Algorithm
 */
public class WarshallAlgorithm extends DirectionalGraph {

    protected int[][] transitiveAdjMatrix;

    public WarshallAlgorithm(int size) {
        super(size);
        transitiveAdjMatrix = new int[size][size];
    }

    private void buildTransitiveAdjMatrix(){
        //prepare adjMatrix copy
        for (int i = 0; i < adjMatrix.length; i++) {
            System.arraycopy(adjMatrix[i], 0, transitiveAdjMatrix[i], 0, adjMatrix[0].length);
        }
        //warshall
        for (int i = 0; i < transitiveAdjMatrix.length; i++)
            for (int j = 0; j < transitiveAdjMatrix.length; j++)
                if (transitiveAdjMatrix[i][j] > 0)
                    for (int k = 0; k < transitiveAdjMatrix.length; k++)
                        if (transitiveAdjMatrix[k][i] > 0) {
                            transitiveAdjMatrix[k][j] = 1;
                        }
    }

    /**
     * returns is path available from vertex with index v1 to vertex with index v2
     * @return
     */
    public boolean hasAvailablePath(int v1, int v2){
        return transitiveAdjMatrix[v1][v2] == 1;
    }

    public static void main(String[] args){
        WarshallAlgorithm graph = new WarshallAlgorithm(8);
        graph.addVertex(new SimpleVertex('A')); // 0
        graph.addVertex(new SimpleVertex('B')); // 1
        graph.addVertex(new SimpleVertex('C')); // 2
        graph.addVertex(new SimpleVertex('D')); // 3
        graph.addVertex(new SimpleVertex('E')); // 4
        graph.addVertex(new SimpleVertex('F')); // 5
        graph.addVertex(new SimpleVertex('G')); // 6
        graph.addVertex(new SimpleVertex('H')); // 7
        graph.addEdge(new SimpleEdge(0, 3)); // AD
        graph.addEdge(new SimpleEdge(0, 4)); // AE
        graph.addEdge(new SimpleEdge(1, 4)); // BE
        graph.addEdge(new SimpleEdge(2, 5)); // CF
        graph.addEdge(new SimpleEdge(3, 6)); // DG
        graph.addEdge(new SimpleEdge(4, 6)); // EG
        graph.addEdge(new SimpleEdge(5, 7)); // FH
        graph.addEdge(new SimpleEdge(6, 7)); // GH
        graph.buildTransitiveAdjMatrix();
        System.out.println("A -> H : " + graph.hasAvailablePath(0, 7));
        System.out.println("D -> A : " + graph.hasAvailablePath(3, 0));
        System.out.println("B -> H : " + graph.hasAvailablePath(1, 7));
        System.out.println("E -> B : " + graph.hasAvailablePath(4, 1));
        System.out.println("C -> H : " + graph.hasAvailablePath(2, 7));
        System.out.println("A -> F : " + graph.hasAvailablePath(0, 5));
    }

}
