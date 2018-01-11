package com.trains;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;

public class TrainsTest {

    private final String res = "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
    private Trains trains;

    @Before
    public void setUp() throws Exception {
        trains = Trains.newDefaultTrains();
    }

    @Test
    public void integrationTest() {
        String result = trains.run(res).stream().collect(Collectors.joining());
        Assert.assertEquals(result, "Output #1: 9Output #2: 5Output #3: 13Output #4: 22Output #5: NO SUCH ROUTEOutput #6: 2Output #7: 3Output #8: 9Output #9: 0Output #10: 7");
    }
}
