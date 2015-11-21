package edu.csula.cs460.graph;

public class Node<T> {
    private int id;
    private T data;

    public Node(int id) {
        this.id = id;
        this.data = null;
    }
    public Node(int id, T data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
            "id=" + id +
            ", data=" + data +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node<?> node = (Node<?>) o;

        if (getId() != node.getId()) return false;
        return !(getData() != null ? !getData().equals(node.getData()) : node.getData() != null);

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getData() != null ? getData().hashCode() : 0);
        return result;
    }
}
