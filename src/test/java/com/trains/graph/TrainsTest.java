package com.trains.graph;

import com.trains.OutputHandler;
import com.trains.graph.allpaths.BFSPaths;
import com.trains.graph.allpaths.Paths;
import com.trains.graph.shortpath.Dijkstra;
import com.trains.graph.shortpath.ShortestPath;
import com.trains.graph.traverse.DefaultTraverse;
import com.trains.graph.traverse.Traverse;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TrainsTest {

    String res = "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
    private Trains trains;

    @Before
    public void setUp() throws Exception {

        Paths paths = new BFSPaths();
        ShortestPath shortestPath = new Dijkstra();
        Traverse traverse = new DefaultTraverse();
        trains = new Trains(paths, shortestPath, traverse);
    }

    @Test
    public void integrationTest() {
        trains.run(res);
    }
}
