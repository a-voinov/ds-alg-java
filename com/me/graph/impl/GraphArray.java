package com.me.graph.impl;

import com.me.graph.IEdge;
import com.me.graph.IGraph;
import com.me.graph.IVertex;

/**
 * Graph implementation using array of vertexes and adjustment matrix
 */
public class GraphArray implements IGraph {

    protected SimpleVertex vertexes[];
    protected int vCount = 0;
    protected int[][] adjMatrix;

    public GraphArray(int size) {
        vertexes = new SimpleVertex[size];
        adjMatrix = new int[size][size];
    }

    protected void visit(SimpleVertex vertex){
        vertex.isVisited = true;
        System.out.print(vertex.label + ", ");
    }

    /**
     * Find vertex adjusted to specified vertex
     * @param v vertex index
     * @return adjusted vertex index
     */
    protected int findAdjVertex(int v){
        for (int i = 0; i < adjMatrix.length; i++)
            if (adjMatrix[v][i] != 0 && !vertexes[i].isVisited)
                return i;
        return -1;
    }

    /**
     * Add an edge between two vertexes
     * @param v1 index of first vertex
     * @param v2 index of second vertex
     */
    protected void addSimpleEdge(int v1, int v2){
        adjMatrix[v1][v2] = 1;
        adjMatrix[v2][v1] = 1;
    }

    /**
     * @param v Expects SimpleVertex
     */
    @Override
    public void addVertex(IVertex v) {
        vertexes[vCount++] = (SimpleVertex)v;
    }

    /**
     * @param edge Expects SimpleEdge
     */
    @Override
    public void addEdge(IEdge edge) {
        SimpleEdge simpleEdge = (SimpleEdge) edge;
        addSimpleEdge(simpleEdge.v1, simpleEdge.v2);
    }
}
