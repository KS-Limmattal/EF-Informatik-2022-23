import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameOfLife {

    static boolean[][] createRandom(int xSize, int ySize) {
        Random rnd = new Random();
        boolean[][] cells = new boolean[xSize][ySize];

        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                cells[i][j] = rnd.nextBoolean();
            }
        }

        return cells;
    }

    static void printCells(boolean[][] cells) {
        int xSize = cells.length;
        int ySize = cells[0].length;

        for (int j = 0; j < ySize; j++) { // Zeile für Zeile
            for (int i = 0; i < xSize; i++) {
                System.out.print((cells[i][j]) ? "@" : ".");
            }
            System.out.println();
        }

        System.out.println();
    }

    static int getNumberOfActiveNeighbours(boolean[][] cells, int x, int y) {
        int xSize = cells.length;
        int ySize = cells[0].length;
        int numberOfActiveNeighbours = 0;

        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (cells[(i + xSize) % xSize][(j + ySize) % ySize])
                    numberOfActiveNeighbours++;
            }
        }

        if (cells[x][y]) {
            numberOfActiveNeighbours--;
        }
        
        return numberOfActiveNeighbours;
    }

    static boolean[][] getNextGeneration(boolean[][] oldGeneration) {
        int xSize = oldGeneration.length;
        int ySize = oldGeneration[0].length;
        boolean[][] nextGeneration = new boolean[xSize][ySize];

        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                int numberOfActiveNeighbours = getNumberOfActiveNeighbours(oldGeneration, i, j);
                if (numberOfActiveNeighbours == 3 || (oldGeneration[i][j] && numberOfActiveNeighbours == 2)) {
                    nextGeneration[i][j] = true;
                } // else = false
            }
        }
        return nextGeneration;
    }

    public static void main(String[] args) throws InterruptedException { // ohne throws keine Kompilation möglich
        boolean[][] cells = createRandom(60, 20);

        for (int i = 0; i < 500; i++) {
            printCells(cells);
            TimeUnit.MILLISECONDS.sleep(500);
            cells = getNextGeneration(cells);
        }
    }
}
