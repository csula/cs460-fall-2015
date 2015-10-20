# Objectives

* Homework 1 Announcement
* Recap of Graph
* DFS (Depth First Search)
* Recursion Review
* BFS (Breadth First Search)

# Metrics/Desired Outcomes

* Understanding BFS/DFS
* Able to implement BFS/DFS

# Information

## Recap of Graph

* Graph
* Node
* Edge

> Graph is just an abstract data structure you can use to traverse and reason behind
certain problem.

### Examples

* Map
* Maze
* Game Tree
* http://visualgo.net/dfsbfs.html
* http://qiao.github.io/PathFinding.js/visual/

> We have data now, how do we process it to produce a useful output?

## Depth First Search (DFS)

![DFS](Depth-First-Search.gif)

### Pseudocode

```javascript
function DFS(v) {
    // label v as discovered
    for (node in Graph.neighbors(v)) {
        if (!node.isDiscovered()) {
            DFS(n);
        }
    }
}
```
## Recursion Review

![Recursion by Google](recursion.png)

* Base case
* Induction

## Breadth First Search (BFS)

![BFS](Breadth-First-Search-Algorithm.gif)

### Pseudocode

```javascript
function BFS(v) {
    for (node in G) {
        node.distance = Number.MAX_VALUE;
        node.parent = null;
    }

    // create empty queue Q      
    var queue = new Queue();

    v.distance = 0;
    queue.enqueue(v);

    while (!queue.isEmpty()) {
        var u = queue.dequeue();
    
        for (node in Graph.neighbors(u)) {
            if (node.distance == Number.MAX_VALUE) {
                node.distance = u.distance + edge.value 
                // note that I'm leaving edge value up to 
                // you to implement
                node.parent = u;
                queue.enqueue(node);
            }
        }
    }
}
```

# Learning

1. Solve https://www.hackerrank.com/challenges/saveprincess
2. ~~Implement Game interface~~

> Due to time constraint, I decide to remove the game interface as part of learning from this class; we will talk about it when I talk about Dijkstra algorithm. Stay Tuned!

## Hacker Rank Save Princess Solution

```java
import java.io.*;
import java.util.*;

public class Solution {
    
    static enum MOVE {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }
    
    public static void main(String[] args) {
        // read from System in as example
        Scanner in = new Scanner(System.in);
        
        // get the size of the two dimension array of tiles
        int size = in.nextInt();
        
        Tile[][] tiles = new Tile[size][size];
        
        int startRow = 0;
        int startCol = 0;
        Tile endTile = new Tile();
        List<MOVE> moves = new ArrayList<>();
        
        // parse each tile one by one
        for (int i = 0; i < tiles.length; i ++) {
            String str = in.next();
            for (int j = 0; j < tiles[i].length; j ++) {
                tiles[i][j] = new Tile(String.valueOf(str.charAt(j)), i, j);
                
                if (tiles[i][j].state == Tile.STATE.START) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        
        moves = BFS(tiles, tiles[startRow][startCol]);
        
        for (MOVE move: moves) {
            System.out.println(move);
        }
    }
    
    /**
     * BFS implementation by pseudocode provided
     **/
    public static List<MOVE> BFS(Tile[][] tiles, Tile startTile) {
        List<MOVE> result = new ArrayList<>();
        Map<Tile, Tile> parents = new HashMap<>();
        Map<Tile, Integer> distances = new HashMap<>();
        Tile endTile = new Tile();
        
        Queue<Tile> queue = new LinkedList<Tile>();
        
        distances.put(startTile, 0);
        parents.put(startTile, null);
        queue.add(startTile);
        
        while (!queue.isEmpty()) {
            Tile u = queue.poll();
            
            // for all the neighbors (possible next moves)
            for (Tile tile: findPossibleNextMoves(tiles, u.row, u.col)) {
                if (!distances.containsKey(tile)) {
                    distances.put(tile, distances.get(u) + 1);
                    parents.put(tile, u);
                    queue.add(tile);
                }
                
                if (tile.state == Tile.STATE.END) {
                    endTile = tile;
                }
            }
        }
        
        // build the list of moves by recursively calling parent
        while (endTile.state != Tile.STATE.START) {
            // construct move from endTile to parent
            if (parents.get(endTile) == null) {
                break;
            }
            if (endTile.row > parents.get(endTile).row) {
                result.add(MOVE.DOWN);
            } else if (endTile.row < parents.get(endTile).row) {
                result.add(MOVE.UP);
            } else if (endTile.col < parents.get(endTile).col) {
                result.add(MOVE.LEFT);
            } else {
                result.add(MOVE.RIGHT);
            }
            endTile = parents.get(endTile);
        }
        
        Collections.reverse(result);
        
        return result;
    }
    
    public static List<Tile> findPossibleNextMoves(
        Tile[][] tiles, 
        int row, 
        int col
    ) {
        List<Tile> result = new ArrayList<>();
        for (MOVE move: MOVE.values()) {
            switch (move) {
                case UP:
                    if (row - 1 >= 0) {
                        result.add(tiles[row-1][col]);
                    }
                    break;
                case LEFT:
                    if (col - 1 >= 0) {
                        result.add(tiles[row][col-1]);
                    }
                    break;
                case DOWN:
                    if (row + 1 < tiles.length) {
                        result.add(tiles[row+1][col]);
                    }
                    break;
                case RIGHT:
                    if (col + 1 < tiles[row].length) {
                        result.add(tiles[row][col+1]);
                    }
                    break;
            }
        }
        
        return result;
    }
    
    static class Tile {
        enum STATE {
            EMPTY,
            START,
            END
        }
        
        public final STATE state;
        public final int row;
        public final int col;
        
        // dummy constructor
        public Tile() {
            state = STATE.EMPTY;
            row = 0;
            col = 0;
        }
        
        public Tile(String str, int row, int col) {
            switch (str) {
                case "-":
                    this.state = STATE.EMPTY;
                    break;
                case "m":
                    this.state = STATE.START;
                    break;
                case "p":
                    this.state = STATE.END;
                    break;
                default:
                    this.state = STATE.EMPTY;
                    System.out.println("Error while constructing Tile class. " + 
                        "Got " + str
                    );
            }
            this.row = row;
            this.col = col;
        }
        
        @Override
        public String toString() {
            return "" + this.state + "@" + this.row + ":" + this.col;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tile)) return false;

            Tile tile = (Tile) o;

            return row == tile.row && col == tile.col && state == tile.state;
        }
    }
}
```