package com.me.graph.impl;

import com.me.queue.impl.QueueArray;

/**
 * Implementation of Breadth First Search
 */
public class GraphArrayBreadthSearch extends GraphArray {

    private QueueArray queue;

    public GraphArrayBreadthSearch(int size) {
        super(size);
        queue = new QueueArray(size);
    }

    public void traverse(){
        queue.enqueue(0);
        visit(vertexes[0]);
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            int adjV;
            while ((adjV = findAdjVertex(v)) != -1){
                visit(vertexes[adjV]);
                queue.enqueue(adjV);
            }
        }
        //cleanup
        for (SimpleVertex vertex : vertexes)
            vertex.isVisited = false;
    }

    public static void main(String[] args){
        GraphArrayBreadthSearch graph = new GraphArrayBreadthSearch(5);
        graph.addVertex(new SimpleVertex('A'));
        graph.addVertex(new SimpleVertex('B'));
        graph.addVertex(new SimpleVertex('C'));
        graph.addVertex(new SimpleVertex('D'));
        graph.addVertex(new SimpleVertex('E'));
        //edges
        graph.addEdge(new SimpleEdge(0, 1));  //AB
        graph.addEdge(new SimpleEdge(1, 2));  //BC
        graph.addEdge(new SimpleEdge(0, 3));  //AD
        graph.addEdge(new SimpleEdge(3, 4));  //DE

        System.out.println("Visits : ");
        graph.traverse();
    }
}
