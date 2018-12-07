package com.me.graph.impl;

import com.me.stack.impl.StackArray;

/**
 * Implementation of Deep First Search
 */
public class GraphArrayDeepSearch extends GraphArray {

    protected StackArray stack;

    public void traverseImpl(int start){
        stack.push(start);
        visit(vertexes[start]);
        while (!stack.isEmpty()){
            int adjVIndex = findAdjVertex(stack.peek());
            if (adjVIndex == -1){
                stack.pop();
            } else {
                visit(vertexes[adjVIndex]);
                stack.push(adjVIndex);
            }
        }
        System.out.println();
        //cleanup
        for (SimpleVertex vertex : vertexes)
            vertex.isVisited = false;
    }

    /**
     * Traverse graph using DFS
     */
    public void traverse(){
        traverseImpl(0);
    }

    public GraphArrayDeepSearch(int size) {
        super(size);
        stack = new StackArray(size);
    }

    public static void main(String[] args){
        //example 1
        GraphArrayDeepSearch graph = new GraphArrayDeepSearch(5);
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

        System.out.println("Visits 1: ");
        graph.traverse();

        //example 2
        GraphArrayDeepSearch graph2 = new GraphArrayDeepSearch(10);
        graph2.addVertex(new SimpleVertex('A')); //0
        graph2.addVertex(new SimpleVertex('B')); //1
        graph2.addVertex(new SimpleVertex('C')); //2
        graph2.addVertex(new SimpleVertex('D')); //3
        graph2.addVertex(new SimpleVertex('E')); //4
        graph2.addVertex(new SimpleVertex('F')); //5
        graph2.addVertex(new SimpleVertex('G')); //6
        graph2.addVertex(new SimpleVertex('H')); //7
        graph2.addVertex(new SimpleVertex('I')); //8
        graph2.addVertex(new SimpleVertex('J')); //9
        //edges
        graph2.addEdge(new SimpleEdge(0, 1));  //AB
        graph2.addEdge(new SimpleEdge(0, 2));  //AC
        graph2.addEdge(new SimpleEdge(0, 4));  //AE
        graph2.addEdge(new SimpleEdge(0, 5));  //AF
        graph2.addEdge(new SimpleEdge(1, 2));  //BC
        graph2.addEdge(new SimpleEdge(1, 7));  //BH
        graph2.addEdge(new SimpleEdge(2, 3));  //CD
        graph2.addEdge(new SimpleEdge(3, 4));  //DE
        graph2.addEdge(new SimpleEdge(3, 9));  //DJ
        graph2.addEdge(new SimpleEdge(4, 5));  //EF
        graph2.addEdge(new SimpleEdge(4, 9));  //EJ
        graph2.addEdge(new SimpleEdge(5, 6));  //FG
        graph2.addEdge(new SimpleEdge(6, 7));  //GH
        graph2.addEdge(new SimpleEdge(6, 8));  //GI
        graph2.addEdge(new SimpleEdge(7, 8));  //HI
        graph2.addEdge(new SimpleEdge(8, 9));  //IJ

        System.out.println("Visits 2: ");
        graph2.traverse();

        //example 3
        GraphArrayDeepSearch graph3 = new GraphArrayDeepSearch(7);
        graph3.addVertex(new SimpleVertex('Q')); //0
        graph3.addVertex(new SimpleVertex('W')); //1
        graph3.addVertex(new SimpleVertex('E')); //2
        graph3.addVertex(new SimpleVertex('R')); //3
        graph3.addVertex(new SimpleVertex('Z')); //4
        graph3.addVertex(new SimpleVertex('F')); //5
        graph3.addVertex(new SimpleVertex('D')); //6
        //edges
        graph3.addEdge(new SimpleEdge(6, 2));  //DE
        graph3.addEdge(new SimpleEdge(6, 5));  //DF
        graph3.addEdge(new SimpleEdge(5, 0));  //FQ
        graph3.addEdge(new SimpleEdge(5, 4));  //FZ
        graph3.addEdge(new SimpleEdge(2, 1));  //EW
        graph3.addEdge(new SimpleEdge(2, 3));  //ER

        System.out.println("Visits 3: ");
        graph3.traverseImpl(6);
    }

}
