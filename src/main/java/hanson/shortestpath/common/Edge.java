package hanson.shortestpath.common;

import java.util.Objects;

/**
 * Created by hanson on 10/06/2018
 */
public class Edge {

    private int id;
    private Vertex source;
    private Vertex target;
    private double weght;

    public Edge(int id, Vertex source, Vertex target, double weght) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.weght = weght;
    }

    public int getId() {
        return id;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getTarget() {
        return target;
    }

    public double getWeght() {
        return weght;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge edge = (Edge) o;
        return getId() == edge.getId() &&
                Double.compare(edge.getWeght(), getWeght()) == 0 &&
                Objects.equals(getSource(), edge.getSource()) &&
                Objects.equals(getTarget(), edge.getTarget());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSource(), getTarget(), getWeght());
    }
}
