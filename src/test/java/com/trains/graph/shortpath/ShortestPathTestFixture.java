package com.trains.graph.shortpath;

import com.trains.graph.Path;
import org.junit.Assert;

public class ShortestPathTestFixture {
    public void checkValidPath(Path path, Path expectedPath) {
        Assert.assertEquals(expectedPath, path);
        Assert.assertEquals(expectedPath.weight(), path.weight());
    }
}
