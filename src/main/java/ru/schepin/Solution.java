package ru.schepin;

import java.util.*;

public class Solution {
    static int fieldX = 10;
    static int fieldY = 10;
    static List<Node> visited;
    static int[][] marked = new int[fieldX][fieldY];
    static int markNumber = 0;
    static Queue<Node> queue;


    public static void main(String[] args) {
        Solution solution = new Solution();
        visited = new ArrayList<>();

        for (int i = 0; i < marked.length; i++) {
            for (int j = 0; j < marked[i].length; j++) {
                marked[i][j] = 0;
            }
        }


        Node startNode = new Node(5, 5);
        Node finishNode = new Node(0, 1);
        marked[0][0] = 0;

        queue = new LinkedList<Node>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited.add(node);
            if (node.equals(finishNode)) {
                System.out.println(node);
                PathHandler pathHandler = new PathHandler();
                ArrayList<Node> path = pathHandler.findPath(finishNode, visited, marked);
                print(path);
                break;
            }
            ArrayList<Node> nearestNodes;
            nearestNodes = solution.findNearestNodes(node);
            node.setNear(nearestNodes);
            mark(nearestNodes, node);
            print();
        }
    }

    private static void print(ArrayList<Node> path) {

        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i).getX() + ", " + path.get(i).getY());
        }
    }

    private static void print() {
        for (int i = 0; i < marked.length; i++) {
            for (int j = 0; j < marked[i].length; j++) {
                System.out.print(marked[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void mark(ArrayList<Node> nearestNodes, Node node) {
        ArrayList<Node> selected = new ArrayList<>();
        for (int i = 0; i < nearestNodes.size(); i++) {
            int point = marked[nearestNodes.get(i).getY()][nearestNodes.get(i).getX()];

            if (point == 0) {
                selected.add(nearestNodes.get(i));
            }
        }
        if (!selected.isEmpty()) {
            int markNumber = marked[node.getY()][node.getX()];
            int mark = markNumber + 1;
            for (int i = 0; i < selected.size(); i++) {
                marked[selected.get(i).getY()][selected.get(i).getX()] = mark;
            }
        }

    }


    private ArrayList<Node> findNearestNodes(Node node) {
        ArrayList<Node> nodeList = new ArrayList<>();
        for (int x = node.getX() - 1; x <= node.getX() + 1; x++) {
            for (int y = node.getY() - 1; y <= node.getY() + 1; y++) {
                Node around = new Node(x, y);
                if (inRange(around)) {
                    if (isNotVisited(around)) {
                        nodeList.add(around);
                        queue.add(around);
                    }

                }
            }
        }
        return nodeList;

    }

    private boolean inRange(Node around) {
        return around.getX() < fieldX && around.getY() < fieldY && around.getX() >= 0 && around.getY() >= 0;
    }

    private boolean isNotVisited(Node around) {
        if (!visited.contains(around)) {
            return true;
        }
        return false;
    }

}
