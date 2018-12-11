package com.me.graph.impl;

import com.me.graph.IVertex;

/**
 * Simple Vertex with visitation flag variable and label
 */
public class SimpleVertex implements IVertex {
    boolean isVisited;
    char label;

    public SimpleVertex(char label) {
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public char getLabel() {
        return label;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
