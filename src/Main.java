import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    static int startingCity = 0;
    static int numberOfCities;
    static int minutes;
    static int[][] travelCost;
    static String filename = "ftv33.atsp";
    static Matrix costMatrix;
    static SelectionType selectionType = SelectionType.TOURNAMENT;

    public static void main(String[] args) {

        minutes = 5;
        costMatrix = new Matrix();
        costMatrix.readFromFile(filename);
        costMatrix.display();

        numberOfCities = costMatrix.getSize();
        System.out.println(numberOfCities);
        travelCost = new int[numberOfCities][numberOfCities];

        for (int i = 0; i < numberOfCities; i++) {
            for (int j = 0; j < numberOfCities; j++) {
                travelCost[i][j] = (int) costMatrix.getValue(i, j);
            }
        }

        printTravelCosts();
        Genetic genetic = new Genetic(numberOfCities, selectionType, travelCost, startingCity, 0);
        Genome result = genetic.optimize(minutes);
        System.out.println(result);
    }

    public static void printTravelCosts() {
        for (int i = 0; i < numberOfCities; i++) {
            for (int j = 0; j < numberOfCities; j++) {
                System.out.print(travelCost[i][j]);
                if (travelCost[i][j] / 10 == 0)
                    System.out.print("  ");
                else
                    System.out.print(' ');
            }
            System.out.println("");
        }
    }


}
