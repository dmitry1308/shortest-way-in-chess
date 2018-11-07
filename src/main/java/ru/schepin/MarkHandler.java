package ru.schepin;

import java.util.ArrayList;

public class MarkHandler {
    public int[][] mark(ArrayList<Node> nearestNodes, Node node, int[][] marked) {
        ArrayList<Node> selected = selectUnmarkedNodes(nearestNodes, marked);
        if (!selected.isEmpty()) {
            assignMarking(node, selected, marked);
        }
        return marked;
    }

    private ArrayList<Node> selectUnmarkedNodes(ArrayList<Node> nearestNodes, int[][] marked) {
        ArrayList<Node> unmarkedNodes = new ArrayList<>();
        for (int i = 0; i < nearestNodes.size(); i++) {
            int point = marked[nearestNodes.get(i).getY()][nearestNodes.get(i).getX()];

            if (point == 0) {
                unmarkedNodes.add(nearestNodes.get(i));
            }
        }
        return unmarkedNodes;
    }

    private void assignMarking(Node node, ArrayList<Node> selected, int[][] marked) {
        int markNumber = marked[node.getY()][node.getX()];
        int mark = markNumber + 1;
        for (int i = 0; i < selected.size(); i++) {
            marked[selected.get(i).getY()][selected.get(i).getX()] = mark;
        }
    }


}
