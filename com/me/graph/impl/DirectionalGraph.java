package com.me.graph.impl;

import com.me.graph.IEdge;

/**
 *  Directional Graph implementation
 */
public class DirectionalGraph extends GraphArray {

    public DirectionalGraph(int size) {
        super(size);
    }

    /**
     * Ensure directional graph style
     * @param v1 index of first vertex
     * @param v2 index of second vertex
     */
    @Override
    protected void addSimpleEdge(int v1, int v2) {
        adjMatrix[v1][v2] = 1;
    }

    @Override
    public void addEdge(IEdge edge) {
        SimpleEdge simpleEdge = (SimpleEdge) edge;
        addSimpleEdge(simpleEdge.v1, simpleEdge.v2);
    }

}
