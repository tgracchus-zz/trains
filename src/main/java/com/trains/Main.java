package com.trains;

import com.trains.graph.Trains;
import com.trains.graph.allpaths.BFSPaths;
import com.trains.graph.allpaths.Paths;
import com.trains.graph.shortpath.Dijkstra;
import com.trains.graph.shortpath.ShortestPath;
import com.trains.graph.traverse.DefaultTraverse;
import com.trains.graph.traverse.Traverse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Paths paths = new BFSPaths();
        ShortestPath shortestPath = new Dijkstra();
        Traverse traverse = new DefaultTraverse();
        Trains trains = new Trains(paths, shortestPath, traverse);
        Scanner in = new Scanner(System.in);
        trains.run(in.nextLine());
    }
}
