//By: Suhani Shah 
import java.io.File; //Used for reading the file 
import java.io.FileNotFoundException; //Checks if the file is not found and retursn an error
import java.util.ArrayList; //Used to create and utilize array lists
import java.util.HashMap; //Used to create and utilize hash maps
import java.util.LinkedList; //Used to create and utilize linked lists
import java.util.List; //Used to create and utilize list
import java.util.Map; //Used to create and utilize map
import java.util.Queue; //Used to create and utilize queues
import java.util.Scanner; //Used to create and utilize scanners to read the file 


public class Path {
    private Map<Character, List<Character>> adjacentList;
   
    /*pre: 
     *post: initializes an empty adjacency list
    */
    // Creates a new graph with empty adjacency list
    public Path() {
        adjacentList = new HashMap<>();
    }
   
    /*pre: 
     *post: adds an undirected edge between one and two to the adjacency list
     *@param: one: the first node to connect
     *@param: two: the second node to connect 
     */
    // Adds two way connection between two nodes in the graph
    public void addEdge(char one, char two) {
        adjacentList.putIfAbsent(one, new ArrayList<>());
        adjacentList.putIfAbsent(two, new ArrayList<>());
        adjacentList.get(one).add(two);
        adjacentList.get(two).add(one);
    }
   
    /*pre: 
     *post: returns shortest path length as a string or "no path" if one doesnt exsist
     *
     *@param: start: The character representing the starting node in the graph
     *@param: end: The character representing the destination node in the graph
     */
    // Uses a BFS (Breadth First Search) to find shortest path between start and end nodes
    public String findShortestPath(char start, char end) {
        if (!adjacentList.containsKey(start) || !adjacentList.containsKey(end)) {
            return "No Path";
        }
        Queue<Character> queue = new LinkedList<>(); //creates a queue for each visited characters
        Map<Character, Integer> distances = new HashMap<>(); //track the distance from start to each node 
        Map<Character, Character> predecessor = new HashMap<>(); //map to track previous node in the path to each node 
        for (char node : adjacentList.keySet()) {
            distances.put(node, -1);
        }
        queue.add(start);
        distances.put(start, 0);

        while (!queue.isEmpty()) {
            char current = queue.poll();
            if (current == end) {
                return String.valueOf(distances.get(current));
            }
            for (char neighbor : adjacentList.get(current)) {
                if (distances.get(neighbor) == -1) {
                    distances.put(neighbor, distances.get(current) + 1); //set neighbors distance to current distance plus one 
                    predecessor.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return "No Path";
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("graph.dat"));
            int numLines = Integer.parseInt(scanner.nextLine());

            System.out.println("Nodes: Shortest Path");
            System.out.println("--------------------");
           
            for (int i = 0; i < numLines; i++) {
                Path graph = new Path();
                String[] edges = scanner.nextLine().split(" ");
                for (String edge : edges) {
                    if (edge.length() >= 2) { //Adds both directions since graph is undirected
                        char first = edge.charAt(0);
                        char second = edge.charAt(1);
                        graph.addEdge(first, second);
                    }
                }
               
                String test = scanner.nextLine();
                if (test.length() >= 2) {
                    char start = test.charAt(0);
                    char end = test.charAt(1);
                    String result = graph.findShortestPath(start, end);
                    System.out.println(start + " and " + end + ": " + result);
                } else {
                    System.out.println(test + " : No Path");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }
}


    