package AdvanceLevelQuestions.Graphs.Representation;

import java.util.Scanner;

public class GraphWithAdjMatrix {

    public static void main(String[] args) {
        // Matrix representation we need , no of vertices and edges
        int vertices = 0, edges = 0;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the no of vertices");
        vertices = scanner.nextInt();
        int[][] matrix = new int[vertices][vertices];
        if (!checkIfValidInput(vertices)) {
            System.out.println("Negative value not allowed");
            return;
        }

        System.out.println("Enter the no of Edges");
        edges = scanner.nextInt();

        if(!checkIfGraphValid(vertices, edges)){
            System.out.println("Graph is not valid with "+ vertices+ " vertices and "+ edges + " edges");
            return;
        }

        int m,n;
        System.out.println("Enter the vertices separated by space like 2 3");
        for (int i = 0; i < edges; i++) {
            System.out.println(i+1 +" th Edge is between :\n");
            m = scanner.nextInt();
            n = scanner.nextInt();
            matrix[m - 1][n - 1] = 1;
            matrix[n -1][m -1] = 1;
        }

        printMatrix(matrix,vertices);
    }

    public static Boolean checkIfValidInput(int value)  {
        return value > 0;
    }

    public static Boolean checkIfGraphValid(int vertices, int edges) {
        return edges <= vertices * (vertices - 1);
    }

    public static void printMatrix(int[][] matrix, int vertices) {
        System.out.println("Here is your matrix representation : ");
        for(int i = 0; i < vertices; i++) {
            for(int j = 0; j < vertices; j++) {
                System.out.print(" "+ matrix[i][j]+ " ");
            }
            System.out.println("\n");
        }
    }

}
