package com.trains.graph.allpaths;

import com.trains.graph.Path;
import org.junit.Assert;

import java.util.List;

public class AllPathsTestFixture {

    public void checkValidPath(List<Path> paths, Path expectedPath, int expectedEdges) {
        Assert.assertTrue(paths.stream().anyMatch(path -> {
            boolean equals = path.equals(expectedPath);
            if (equals) {
                Assert.assertEquals(expectedPath.weight(), path.weight());
                Assert.assertEquals(expectedEdges + 1, path.size());
            }
            return equals;
        }));
    }

}
