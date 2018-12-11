package com.me.graph.weighted;

import com.me.graph.impl.SimpleVertex;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Minimal spanning tree algorithm implemented on weighted graph
 */
public class MinimalSpanningTree extends WeightedGraph {

    private PriorityQueue<WeightedEdge> pq;

    public MinimalSpanningTree(int size) {
        super(size);
        pq = new PriorityQueue<>(size, new Comparator<WeightedEdge>() {
            @Override
            public int compare(WeightedEdge o1, WeightedEdge o2) {
                return o1.weight - o2.weight;
            }
        });
    }

    public void mst(){
        System.out.println();
        vertexes[0].setVisited(true);
        int lowestDestVertex = 0;
        int n = 0;
        while (n < vertexes.length - 1){
            //chose vertex
            int v = -1;
            for (int i = lowestDestVertex; i < vertexes.length; i++) {
                if (vertexes[i].isVisited()) {
                    v = i;
                    break;
                }
            }
            if (v == -1) break;
            //add edges to priority queue
            for (int i = 0; i < vertexes.length; i++) {
                if (adjMatrix[v][i] > 0 && !vertexes[i].isVisited()){
                    WeightedEdge edge = new WeightedEdge(v, i, adjMatrix[v][i]);
                    pq.add(edge);
                }
            }
            //poll edge with lowest weight
            WeightedEdge lowest = pq.poll();
            if (lowest == null){
                System.out.println("Error. Graph not connected.");
                return;
            }
            vertexes[lowest.getV2()].setVisited(true);
            lowestDestVertex = lowest.getV2();
            n++;
            System.out.print("" + vertexes[lowest.getV1()].getLabel() + vertexes[lowest.getV2()].getLabel() + " ");
            //remove visited vertex edges from queue
            Iterator iterator = pq.iterator();
            while (iterator.hasNext()) {
                WeightedEdge edge = (WeightedEdge) iterator.next();
                if (edge.getV2() == lowest.getV2())
                    iterator.remove();
            }
        }
    }

    public static void main(String[] args){
        MinimalSpanningTree graph = new MinimalSpanningTree(6);
        graph.addVertex(new SimpleVertex( 'A')); // 0
        graph.addVertex(new SimpleVertex( 'B')); // 1
        graph.addVertex(new SimpleVertex( 'C')); // 2
        graph.addVertex(new SimpleVertex( 'D')); // 3
        graph.addVertex(new SimpleVertex( 'E')); // 4
        graph.addVertex(new SimpleVertex( 'F')); // 5
        graph.addEdge(new WeightedEdge(0, 1, 6)); // AB 6
        graph.addEdge(new WeightedEdge(0, 3, 4)); // AD 4
        graph.addEdge(new WeightedEdge(1, 2, 10)); // BC 10
        graph.addEdge(new WeightedEdge(1, 3, 7)); // BD 7
        graph.addEdge(new WeightedEdge(1, 4, 7)); // BE 7
        graph.addEdge(new WeightedEdge(2, 3, 8)); // CD 8
        graph.addEdge(new WeightedEdge(2, 4, 5)); // CE 5
        graph.addEdge(new WeightedEdge(2, 5, 6)); // CF 6
        graph.addEdge(new WeightedEdge(3, 4, 12)); // DE 12
        graph.addEdge(new WeightedEdge(4, 5, 7)); // EF 7
        System.out.print("Minimum spanning tree: ");
        graph.mst(); //minimal spanning tree traverse
        System.out.println();
    }
}
