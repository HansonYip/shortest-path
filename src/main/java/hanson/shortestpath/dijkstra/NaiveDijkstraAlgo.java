package hanson.shortestpath.dijkstra;

import hanson.shortestpath.common.Edge;
import hanson.shortestpath.common.Graph;
import hanson.shortestpath.common.Vertex;

import java.util.*;

/**
 * Naive Dijkstra: it is a simple implementation of Dijkstra algorithm without any performance
 * optimization, e.g. storing the graph in the form of adjacency lists and using
 * a priority queue as a set of unvisited vertices.
 * Created by hanson on 10/06/2018
 */
public class NaiveDijkstraAlgo {
    private List<Vertex> vertices;
    private List<Edge> edges;

    // Cache result
    private List<Vertex> unvisitedVertices;
    private Map<Vertex, Double> distance;
    private Map<Vertex, Vertex> predecessor;

    public NaiveDijkstraAlgo(Graph graph) {
        vertices = graph.getVertices();
        edges = graph.getEdges();
    }

    public void findAllShortestPaths(Vertex source) {
        // initialize
        unvisitedVertices = new ArrayList<>(vertices);
        distance = new HashMap<>();
        predecessor = new HashMap<>();
        distance.put(source, 0.0);

        while (!unvisitedVertices.isEmpty()) {
            Vertex vertex = getMinimalDistanceVertex(unvisitedVertices);
            unvisitedVertices.remove(vertex);
            calculateMinimalDistance(vertex);
        }
    }

    private void calculateMinimalDistance(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(vertex)) {  // find neighbor
                double dist = distance.get(vertex) + edge.getWeght();
                if (!distance.containsKey(edge.getTarget()) || dist < distance.get(edge.getTarget())) {
                    distance.put(edge.getTarget(), dist);
                    predecessor.put(edge.getTarget(), vertex);
                }
            }
        }
    }

    private Vertex getMinimalDistanceVertex(List<Vertex> unvisitedVertices) {
        double minDist = Double.POSITIVE_INFINITY;
        Vertex vertex = null;
        for (Vertex unvisitedVertex : unvisitedVertices) {
            if (distance.containsKey(unvisitedVertex) && distance.get(unvisitedVertex) < minDist) {
                vertex = unvisitedVertex;
            }
        }
        return vertex;
    }

    public List<Vertex> getShortestPath(Vertex target) {
        List<Vertex> path = new ArrayList<>();
        path.add(target);
        Vertex vertex = target;
        while (predecessor.containsKey(vertex)) {
            path.add(predecessor.get(vertex));
            vertex = predecessor.get(vertex);
        }
        Collections.reverse(path);
        return path.size() == 1? null : path;
    }

    public double getShortestDistance(Vertex target) {
        return distance.containsKey(target) ? distance.get(target) : Double.POSITIVE_INFINITY;
    }

}
