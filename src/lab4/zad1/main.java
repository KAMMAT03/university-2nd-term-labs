package lab4.zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        File file = new File("src/lab4/zad1/g8.txt");

        try {
            Scanner scanner = new Scanner(file);

            int numberOfVertices = Integer.parseInt(scanner.nextLine());
            int numberOfEdges = Integer.parseInt(scanner.nextLine());

            Graph graph = new Graph(numberOfVertices);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                int source = Integer.parseInt(parts[0]);
                int destination = Integer.parseInt(parts[1]);
                double weight = Double.parseDouble(parts[2]);
                graph.addEdge(source, destination, weight);
            }
            scanner.close();

            List<Edge> minimumSpanningTree = graph.kruskalMST();
            float sum = 0;

            System.out.println("Minimum spanning tree:");
            for (Edge edge : minimumSpanningTree) {
                System.out.println(edge.source + " - " + edge.destination + ", weight: " + edge.weight);
                sum += edge.weight;
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("File + " + file.getName() + " not found.");
        }
    }
}

