package com.me.graph.impl;

/**
 * Output of minimal spanning tree based on Deep First Search
 */
public class MinimalSpanningTree extends GraphArrayDeepSearch {

    protected void visit(SimpleVertex vertex1, SimpleVertex vertex2) {
        System.out.print("" + vertex1.label + vertex2.label + " ");
        vertex2.isVisited = true;
    }

    @Override
    public void traverseImpl(int start) {
        stack.push(start);
        vertexes[start].isVisited = true;
        while (!stack.isEmpty()){
            int currentV = stack.peek();
            int adjVIndex = findAdjVertex(currentV);
            if (adjVIndex == -1){
                stack.pop();
            } else {
                visit(vertexes[currentV], vertexes[adjVIndex]);
                stack.push(adjVIndex);
            }
        }
        System.out.println();
        //cleanup
        for (SimpleVertex vertex : vertexes)
            vertex.isVisited = false;
    }

    public MinimalSpanningTree(int size) {
        super(size);
    }

    public static void main(String[] args){
        //example 1
        MinimalSpanningTree graph = new MinimalSpanningTree(5);
        graph.addVertex(new SimpleVertex('A'));
        graph.addVertex(new SimpleVertex('B'));
        graph.addVertex(new SimpleVertex('C'));
        graph.addVertex(new SimpleVertex('D'));
        graph.addVertex(new SimpleVertex('E'));
        //edges
        graph.addEdge(new SimpleEdge(0, 1)); // AB
        graph.addEdge(new SimpleEdge(0, 2)); // AC
        graph.addEdge(new SimpleEdge(0, 3)); // AD
        graph.addEdge(new SimpleEdge(0, 4)); // AE
        graph.addEdge(new SimpleEdge(1, 2)); // BC
        graph.addEdge(new SimpleEdge(1, 3)); // BD
        graph.addEdge(new SimpleEdge(1, 4)); // BE
        graph.addEdge(new SimpleEdge(2, 3)); // CD
        graph.addEdge(new SimpleEdge(2, 4)); // CE
        graph.addEdge(new SimpleEdge(3, 4)); // DE

        System.out.println("Visits : ");
        graph.traverse();
    }
}
