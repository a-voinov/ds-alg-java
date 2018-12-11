package com.me.graph.impl;

import com.me.graph.IEdge;

/**
 * Simple Edge which connects two vertexes
 */
public class SimpleEdge implements IEdge {
    int v1;
    int v2;

    public SimpleEdge(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int getV1() {
        return v1;
    }

    public int getV2() {
        return v2;
    }
}
