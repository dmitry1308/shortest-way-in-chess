package ru.schepin;

import ru.schepin.models.Node;

import java.util.Arrays;
import java.util.List;

public class InitialData {
    public static List<Node> barriers =
            Arrays.asList(
                    new Node(1, 1),
                    new Node(2, 1),
                    new Node(3, 1),
                    new Node(4, 1),
                    new Node(5, 4),
                    new Node(6, 4),
                    new Node(0, 4),
                    new Node(1, 4),
                    new Node(2, 4),
                    new Node(3, 4));

    public static Node field = new Node(12, 12);

    public static Node start = new Node(2, 0);
    public static Node finish = new Node(6, 10);


}
