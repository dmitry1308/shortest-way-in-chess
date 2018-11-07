package ru.schepin;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class StepHandler {
    public ArrayList<Node> findNearestNodes(Node node, Queue<Node> queue, List<Node> visited) {
        ArrayList<Node> nodeList = new ArrayList<>();
        for (int x = node.getX() - 1; x <= node.getX() + 1; x++) {
            for (int y = node.getY() - 1; y <= node.getY() + 1; y++) {
                Node around = new Node(x, y);
                if (inRange(around) && isNotVisited(around, visited) && !InitialData.barriers.contains(around)) {
                    nodeList.add(around);
                    queue.add(around);
                }
            }
        }
        return nodeList;
    }

    private boolean inRange(Node around) {
        return around.getX() < InitialData.field.getX() && around.getY() < InitialData.field.getY() && around.getX() >= 0 && around.getY() >= 0;
    }

    private boolean isNotVisited(Node around, List<Node> visited) {
        if (!visited.contains(around)) {
            return true;
        }
        return false;
    }
}
