package com.me.graph.weighted;

import com.me.graph.impl.SimpleEdge;

/**
 * Weighted Edge which connects two vertexes
 */
public class WeightedEdge extends SimpleEdge {
    int weight;

    public WeightedEdge(int v1, int v2, int weight) {
        super(v1, v2);
        this.weight = weight;
    }
}
