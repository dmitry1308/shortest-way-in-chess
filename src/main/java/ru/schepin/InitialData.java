package ru.schepin;

import java.util.Arrays;
import java.util.List;

public class InitialData {
    static List<Node> barriers =
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

    static Node field = new Node(12, 12);

    static Node start = new Node(2, 0);
    static Node finish = new Node(6, 10);


}
