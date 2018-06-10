package hanson.shortestpath.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanson on 10/06/2018
 */
public class Graph {

    private List<Vertex> vertices;
    private List<Edge> edges;

    public Graph() {
        this(new ArrayList<Vertex>(), new ArrayList<Edge>());
    }

    public Graph(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public Graph addVertex(Vertex vertex) {
        vertices.add(vertex);
        return this;
    }

    public Graph addEdge(Edge edge) {
        edges.add(edge);
        return this;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
