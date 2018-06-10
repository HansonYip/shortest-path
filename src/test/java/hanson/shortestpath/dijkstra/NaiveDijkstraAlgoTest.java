package hanson.shortestpath.dijkstra;

import hanson.shortestpath.common.Edge;
import hanson.shortestpath.common.Graph;
import hanson.shortestpath.common.Vertex;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by hanson on 10/06/2018
 */
public class NaiveDijkstraAlgoTest {

    @Test
    public void findAllShortestPaths() {
        // Create Graph
        Vertex vertex1 = new Vertex(1, "Node_1");
        Vertex vertex2 = new Vertex(2, "Node_2");
        Vertex vertex3 = new Vertex(3, "Node_3");
        Vertex vertex4 = new Vertex(4, "Node_4");
        Vertex vertex5 = new Vertex(5, "Node_5");
        Vertex vertex6 = new Vertex(6, "Node_6");
        Vertex vertex7 = new Vertex(7, "Node_7");
        Graph graph = new Graph();
        graph.addVertex(vertex1)
                .addVertex(vertex2)
                .addVertex(vertex3)
                .addVertex(vertex4)
                .addVertex(vertex5)
                .addVertex(vertex6)
                .addVertex(vertex7)
                .addEdge(new Edge(1, vertex1, vertex2, 2))
                .addEdge(new Edge(2, vertex1, vertex3, 1))
                .addEdge(new Edge(3, vertex2, vertex4, 2))
                .addEdge(new Edge(4, vertex2, vertex6, 3))
                .addEdge(new Edge(5, vertex3, vertex4, 2))
                .addEdge(new Edge(6, vertex3, vertex5, 5))
                .addEdge(new Edge(7, vertex5, vertex7, 2))
                .addEdge(new Edge(7, vertex6, vertex7, 4));

        NaiveDijkstraAlgo algo = new NaiveDijkstraAlgo(graph);
        algo.findAllShortestPaths(vertex1);
        assertEquals(3, algo.getShortestDistance(vertex4), 0.000001);
        assertEquals(8, algo.getShortestDistance(vertex7), 0.000001);
        assertTrue(Arrays.asList(vertex1, vertex2, vertex6).equals(algo.getShortestPath(vertex6)));
    }
}