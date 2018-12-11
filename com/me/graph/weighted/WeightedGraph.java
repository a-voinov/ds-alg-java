package com.me.graph.weighted;

import com.me.graph.IEdge;
import com.me.graph.impl.GraphArray;

/**
 * Weighted Graph implementation
 */
public class WeightedGraph extends GraphArray {

    public WeightedGraph(int size) {
        super(size);
    }

    /**
     * Add an edge between two vertexes
     * @param v1 index of first vertex
     * @param v2 index of second vertex
     */
    protected void addWeightedEdge(int v1, int v2, int weight){
        adjMatrix[v1][v2] = weight;
        adjMatrix[v2][v1] = weight;
    }

    @Override
    public void addEdge(IEdge edge) {
        WeightedEdge weightedEdge = (WeightedEdge) edge;
        addWeightedEdge(weightedEdge.getV1(), weightedEdge.getV2(), weightedEdge.weight);
    }
}
