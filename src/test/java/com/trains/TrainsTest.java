package com.trains;

import com.trains.Trains;
import org.junit.Before;
import org.junit.Test;

public class TrainsTest {

    String res = "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
    private Trains trains;

    @Before
    public void setUp() throws Exception {
        trains = Trains.newDefaultTrains();
    }

    @Test
    public void integrationTest() {
        trains.run(res);
    }
}
