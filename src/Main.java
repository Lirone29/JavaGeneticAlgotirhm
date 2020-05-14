public class Main {

    static int choice = -1;
    int populationSize = 20;

    public static void main(String[] args) {

        Matrix costMatrix = new Matrix();
        costMatrix.readFromFile("tsp10.atsp");
        costMatrix.display();

        int numberOfCities = costMatrix.getSize();
        int[][] travelPrices = new int[numberOfCities][numberOfCities];

        for (int i = 0; i < numberOfCities; i++) {
            for (int j = 0; j < numberOfCities; j++) {
                travelPrices[i][j] = (int) costMatrix.getValue(i,j);
            }
        }
        //printTravelPrices(travelPrices,numberOfCities);
        Genetic genetic = new Genetic(numberOfCities, SelectionType.ROULETTE, travelPrices, 0, 0);
        Genome result = genetic.optimize();
        System.out.println(result);
    }

    public static void printTravelPrices(int[][] travelPrices, int numberOfCities){
        for(int i = 0; i<numberOfCities; i++){
            for(int j=0; j<numberOfCities; j++){
                System.out.print(travelPrices[i][j]);
                if(travelPrices[i][j]/10 == 0)
                    System.out.print("  ");
                else
                    System.out.print(' ');
            }
            System.out.println("");
        }
    }

}
