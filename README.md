Trains

Instructions to build and execute
- To build it execute
```
./gradlew clean build 
```
- This will create a zip under build/distributions/trains-1.0.0.zip

- Execute it with 
```./bin/trains```

Assumptions:
Output 9, is about shortest path from B to B. A shortest path, by definition, do not contain cycles.  
The output, imho, should be 0. If we look for the kth shortest path,in this case the 2th shortestpath, then it can be 9. Anyway I decide to yield a 0.

Reference: 
Introduction to Algorithms, Third Edition  
By Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein  
Page 646

https://mitpress.mit.edu/books/introduction-algorithms
