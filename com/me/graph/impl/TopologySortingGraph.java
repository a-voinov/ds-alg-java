package com.me.graph.impl;

/**
 * Implementation of topology sort in directed graph
 */
public class TopologySortingGraph extends DirectionalGraph {

    private SimpleVertex sortedVertexes[];
    private int[][] adjMatrixCopy;

    public TopologySortingGraph(int size) {
        super(size);
        sortedVertexes = new SimpleVertex[size];
        adjMatrixCopy = new int[size][size];
    }

    /**
     * Method returns index of successor vertex
     * @param vi vertex index
     * @return -1 if zero successors
     */
    private int getSuccessor(int vi){
        int si = -1;
        for (int i = 0; i < adjMatrixCopy.length; i++)
            if (adjMatrixCopy[vi][i] > 0){
                si = i;
            }
        return si;
    }

    /**
     * Method finds vertex in graph without successors
     * @return - 1 if graph is cycled
     */
    private int getNoSuccessorVertex(){
        int i;
        boolean isFound = false;
        for (i = 0; i < vCount; i++)
            if (!vertexes[i].isVisited && getSuccessor(i) == -1) {
                isFound = true;
                break;
            }
        return isFound ? i : -1;
    }

    /**
     * Method sorts vertexes in accessibility order, and prints the result
     */
    public void topologySort(){
        //prepare adjMatrix copy
        for (int i = 0; i < adjMatrix.length; i++) {
            System.arraycopy(adjMatrix[i], 0, adjMatrixCopy[i], 0, adjMatrix[0].length);
        }
        boolean fail = false;
        //sort
        for(int i = 0; i < vCount; i++){
            int noSuccessorVertexIndex = getNoSuccessorVertex();
            if (noSuccessorVertexIndex == -1){
                System.out.println("Graph has cycle! Topology sort fails.");
                fail = true;
                break;
            }
            sortedVertexes[vCount - i - 1] = vertexes[noSuccessorVertexIndex];
            //mark vertex as visited
            vertexes[noSuccessorVertexIndex].isVisited = true;
            //remove adjustment info
            for (int j = 0; j < adjMatrixCopy.length; j++)
                adjMatrixCopy[j][noSuccessorVertexIndex] = 0;
        }
        if (!fail) {
            //print
            System.out.println("Topology sorted graph : ");
            for (SimpleVertex sortedVertex : sortedVertexes)
                System.out.print(sortedVertex.label);
            System.out.println();
        }
        //cleanup
        for (int i = 0; i < sortedVertexes.length; i++) {
            vertexes[i].isVisited = false;
            sortedVertexes[i] = null;
        }
    }

    public static void main(String[] args){
        TopologySortingGraph graph = new TopologySortingGraph(8);
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
        graph.topologySort(); // Сортировка
    }

}
