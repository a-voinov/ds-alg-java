package com.me.graph.weighted;

import com.me.graph.impl.SimpleVertex;

/**
 * Implementation of Dijkstra's shortest path algorithm
 */
public class DijkstraAlgorithm extends WeightedGraph {

    private class DestPath{
        int distance;
        int parent;

        DestPath(int distance, int parent) {
            this.distance = distance;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "DestPath{" +
                    "distance=" + distance +
                    ", parent=" + parent +
                    '}';
        }
    }

    private DestPath[] sptSet; //Shortest path tree set
    private DestPath[] sptPSet; //Vertices which are not included into a tree set yet

    public DijkstraAlgorithm(int size) {
        super(size);
        sptSet = new DestPath[size];
        sptPSet = new DestPath[size];
    }

    private final int INF = Integer.MAX_VALUE;

    private int getMin(){
        int min = INF; int im = -1;
        for (int i = 0; i < sptPSet.length; i++)
            if (sptPSet[i].distance < min && sptSet[i].distance == INF) {
                min = sptPSet[i].distance;
                im = i;
            }
        return im;
    }

    private void initDestPath(){
        //init sptSet
        sptSet[0] = new DestPath(0, -1);
        sptPSet[0] = new DestPath(0, -1);
        for (int i = 1; i < sptSet.length; i++) {
            sptSet[i] = new DestPath(INF, -1);
            sptPSet[i] = new DestPath(INF, -1);
        }
    }

    private int start; //root vertex

    /**
     * Build Shortest path tree from root
     * @param v root
     */
    public void path(int v){
        start = v;
        int sptN = 0;
        initDestPath();
        //main cycle
        while (sptN != sptSet.length - 1) {
            //find adjacent vertices
            for (int i = 0; i < adjMatrix.length; i++)
                if (adjMatrix[v][i] > 0 && sptSet[i].distance == INF) {
                    int sum = sptSet[v].distance + adjMatrix[v][i];
                    if (sum < sptPSet[i].distance) //update distances
                        sptPSet[i] = new DestPath(sum, v);
                }
            //pick vertex with minimum distance
            v = getMin();
            //put it in SPT Set
            sptSet[v] = sptPSet[v];
            sptN++;
        }
    }

    private void tracePath(int v1, int v2){
        DestPath path = sptSet[v2];
        if (path.parent != v1) tracePath(v1, path.parent);
        System.out.print("->" + v2);
    }

    /**
     * Print shortest path from root to specified vertex
     */
    public void tracePath(int v){
        System.out.print(start);
        tracePath(start, v);
        System.out.println();
    }

    public static void main(String args[]){
        DijkstraAlgorithm graph = new DijkstraAlgorithm(9);
        graph.addVertex(new SimpleVertex( 'A')); // 0
        graph.addVertex(new SimpleVertex( 'B')); // 1
        graph.addVertex(new SimpleVertex( 'C')); // 2
        graph.addVertex(new SimpleVertex( 'D')); // 3
        graph.addVertex(new SimpleVertex( 'E')); // 4
        graph.addVertex(new SimpleVertex( 'F')); // 5
        graph.addVertex(new SimpleVertex( 'G')); // 6
        graph.addVertex(new SimpleVertex( 'H')); // 7
        graph.addVertex(new SimpleVertex( 'I')); // 8
        graph.addEdge(new WeightedEdge(0, 1, 4));
        graph.addEdge(new WeightedEdge(0, 7, 8));
        graph.addEdge(new WeightedEdge(1, 7, 11));
        graph.addEdge(new WeightedEdge(1, 2, 8));
        graph.addEdge(new WeightedEdge(7, 6, 1));
        graph.addEdge(new WeightedEdge(7, 8, 7));
        graph.addEdge(new WeightedEdge(8, 6, 6));
        graph.addEdge(new WeightedEdge(2, 8, 2));
        graph.addEdge(new WeightedEdge(2, 3, 7));
        graph.addEdge(new WeightedEdge(6, 5, 2));
        graph.addEdge(new WeightedEdge(2, 5, 4));
        graph.addEdge(new WeightedEdge(3, 5, 14));
        graph.addEdge(new WeightedEdge(3, 4, 9));
        graph.addEdge(new WeightedEdge(5, 4, 10));
        graph.path(0);
        graph.tracePath(8);
        graph.tracePath(3);
        graph.tracePath(4);
    }

}
