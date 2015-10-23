package edu.csula.cs460.graph;

public class Node {
    private int id;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        return getId() == node.getId();

    }

    @Override
    public String toString() {
        return "Node{" +
            "id=" + id +
            '}';
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
