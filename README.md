# 🔗 Graph Shortest Path Finder

This Java program reads a set of undirected edges from a file and uses **Breadth-First Search (BFS)** to compute the **shortest path length** between two nodes in an undirected graph.

Developed by: **Suhani Shah**

## 📘 Overview

Given a list of edges and a pair of nodes, this program builds a graph and finds the shortest number of steps between the two nodes using BFS traversal. If no path exists between them, it outputs `"No Path"`.

## 🛠 Features

- Reads graph edges and queries from a file
- Constructs an undirected graph using an adjacency list
- Implements BFS to find the shortest path
- Handles disconnected graphs and invalid nodes
- Graceful error handling if the input file is missing

## 📁 Input Format

The input file `graph.dat` should be formatted as:

1. First line: An integer `n` representing the number of test cases.
2. For each test case:
   - One line with space-separated edge pairs (e.g., `AB BC CD`)
   - One line with two characters (e.g., `AC`) indicating the source and destination nodes for the shortest path

### Example `graph.dat`:

2
AB BC CD
AD
XY YZ
XZ

## 📤 Output Format

The program outputs the start and end nodes along with the shortest path length, or `"No Path"` if unreachable.

### Example Output:

A and D: 3
X and Z: 2

## 🧪 How It Works

- **Graph Construction**: Uses a `HashMap<Character, List<Character>>` to store the adjacency list.
- **BFS Traversal**: Explores nodes level-by-level from the start node to compute the shortest path.
- **Edge Addition**: Undirected edges are added both ways (`A-B` and `B-A`).

## 🧾 Files

- `Path.java`: Main class with graph logic and file input handling.
- `graph.dat`: Input file containing edge data and test cases.

## ✅ Usage

1. Ensure `Path.java` and `graph.dat` are in the same directory.
2. Compile and run:

```bash
javac Path.java
java Path
