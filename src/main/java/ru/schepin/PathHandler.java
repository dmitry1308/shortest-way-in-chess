package ru.schepin;

import java.util.ArrayList;
import java.util.List;

public class PathHandler {
    public ArrayList<Node> findPath(Node finish, List<Node> visited, int[][] marked) {
        ArrayList<Node> shortestWay = new ArrayList<>();
        shortestWay.add(finish);
        int curentMarkPoint = Solution.marked[finish.getY()][finish.getX()];
        Node currentNode = finish;
        int nextMarkPoint = curentMarkPoint - 1;
        while (nextMarkPoint >= 0) {
           
            ArrayList<Node> templist = findNodeWithNextMarkPoint(marked, nextMarkPoint);

            Node nextNode = findNeededNodeFromTempList(templist, visited, currentNode);
            shortestWay.add(nextNode);

            currentNode = nextNode;
            nextMarkPoint--;
        }
        return shortestWay;
    }

    private Node findNeededNodeFromTempList(ArrayList<Node> templist, List<Node> visited, Node currentNode) {
        Node nextNode = null;
        loop:
        for (int i = 0; i < templist.size(); i++) {
            for (int j = 0; j < visited.size(); j++) {
                if (templist.get(i).equals(visited.get(j))) {
                    if (visited.get(j).getNear().contains(currentNode)) {
                        nextNode = visited.get(j);
                        break loop;
                    }
                }
            }
        }
        return nextNode;
    }

    private ArrayList<Node> findNodeWithNextMarkPoint(int[][] marked, int nextMarkPoint) {
        Node possibleNode = new Node();
        ArrayList<Node> tempList = new ArrayList<>();
        for (int i = 0; i < marked.length; i++) {
            for (int j = 0; j < marked[i].length; j++) {
                possibleNode.setY(i);
                possibleNode.setX(j);
                if (marked[i][j] == nextMarkPoint) {
                    tempList.add(new Node(j, i));
                }
            }
        }
        return tempList;
    }


}

