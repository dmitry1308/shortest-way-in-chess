package ru.schepin;

import ru.schepin.handlers.MarkHandler;
import ru.schepin.handlers.PathHandler;
import ru.schepin.handlers.StepHandler;
import ru.schepin.models.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private static List<Node> visited = new ArrayList<>();
    private static int[][] marked = new int[InitialData.field.getY()][InitialData.field.getX()];
    private static Queue<Node> queue = new LinkedList<>();
    private static Node startNode = InitialData.start;
    private static Node finishNode = InitialData.finish;
    private static Printer printer = new Printer();

    private static boolean finished = false;


    public static void main(String[] args) {
        printer.printEntityIdentification();
        printer.displayStartAllOnBoard();

        queue.add(startNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                visited.add(node);
                if (node.equals(finishNode)) {
                    finished = true;
                    break;
                }
                ArrayList<Node> nearestNodes = new StepHandler().findNearestNodes(node, queue, visited);
                node.setNear(nearestNodes);
                marked = new MarkHandler().mark(nearestNodes, node, marked);
               // printer.printMarked(marked);
            }
        }
        if (finished) {
            PathHandler pathHandler = new PathHandler();
            ArrayList<Node> path = pathHandler.buildPath(finishNode, visited, marked);
            printer.printPathInCoordinates(path);
            printer.printResultDisplay(path);
        }
    }
}
