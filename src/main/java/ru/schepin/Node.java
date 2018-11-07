package ru.schepin;

import java.util.List;
import java.util.Objects;

public class Node {
    private int x;
    private int y;
    private List<Node> near;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x &&
                y == node.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }


    public List<Node> getNear() {
        return near;
    }

    public void setNear(List<Node> near) {
        this.near = near;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", near=" + near +
                '}';
    }
}
