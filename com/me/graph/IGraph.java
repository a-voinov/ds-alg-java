package com.me.graph;

/**
 * Common Graph operations
 */
public interface IGraph {
    /**
     * Add vertex to Graph
     */
    void addVertex(IVertex v);
    /**
     * Add an edge between two vertexes
     */
    void addEdge(IEdge e);
}
