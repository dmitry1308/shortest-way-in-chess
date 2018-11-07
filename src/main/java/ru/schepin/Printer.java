package ru.schepin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Printer {
    private static final String[] symbols = {" . ", "sta", "fin", " x ", " 0 "};

    public void printEntityIdentification() {
        System.out.println("Расшифровка обозначений на поле: ");
        System.out.println(symbols[0] + " - Пустая клетка");
        System.out.println(symbols[1] + " - Старт");
        System.out.println(symbols[2] + " - Финиш");
        System.out.println(symbols[3] + " - Барьер");
        System.out.println(symbols[4] + " - Путь фигуры");
        System.out.println();
    }

    public void printPathInCoordinates(ArrayList<Node> path) {
        Collections.reverse(path);
        System.out.println("Координаты пути: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.println("{" + path.get(i).getX() + "; " + path.get(i).getY() + "}");
        }
        System.out.println();
    }

    public void printMarked(int[][] marked) {
        for (int i = 0; i < marked.length; i++) {
            for (int j = 0; j < marked[i].length; j++) {
                System.out.print(marked[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printResultDisplay(ArrayList<Node> path) {
        System.out.println("Результат пути фигуры: ");
        int[][] fieldWithStartDates = assignFieldEntitiesInNumbers();
        int[][] fieldWithPathInNumber = assignFieldWithPathInNumber(fieldWithStartDates, path);

        for (int y = 0; y < InitialData.field.getY(); y++) {
            for (int x = 0; x < InitialData.field.getX(); x++) {
                System.out.print(symbols[fieldWithPathInNumber[y][x]]);
            }
            System.out.println();
        }
    }

    private int[][] assignFieldWithPathInNumber(int[][] fieldWithStartDates, ArrayList<Node> path) {
        for (int i = 0; i < path.size(); i++) {
            Node figure = path.get(i);
            fieldWithStartDates[figure.getY()][figure.getX()] = 4;
        }
        return fieldWithStartDates;
    }

    public void displayStartAllOnBoard() {
        System.out.println("Стартовые данные: ");
        int[][] fieldWithStartDates = assignFieldEntitiesInNumbers();

        for (int i = 0; i < InitialData.field.getX(); i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();

        for (int y = 0; y < InitialData.field.getY(); y++) {
            for (int x = 0; x < InitialData.field.getX(); x++) {
                System.out.print(symbols[fieldWithStartDates[y][x]]);
            }
            System.out.print(" " + y);
            System.out.println();
        }

        System.out.println();
    }

    private int[][] assignFieldEntitiesInNumbers() {
        int[][] matrixOfField = new int[InitialData.field.getY()][InitialData.field.getX()];
        List<Node> barriers = InitialData.barriers;
        for (int i = 0; i < barriers.size(); i++) {
            Node obstacle = barriers.get(i);
            matrixOfField[obstacle.getY()][obstacle.getX()] = 3;
        }

        matrixOfField[InitialData.start.getY()][InitialData.start.getX()] = 1;
        matrixOfField[InitialData.finish.getY()][InitialData.finish.getX()] = 2;

        return matrixOfField;
    }
}
