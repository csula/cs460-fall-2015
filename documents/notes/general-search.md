# Objectives

* Recursion Review
* DFS (Depth First Search)
* BFS (Breadth First Search)

# Metrics/Desired Outcomes

* Understanding BFS/DFS
* Able to implement BFS/DFS

# Recursion Review

* Base case
* Induction

# DFS

![DFS](Depth-First-Search.gif)

## Pseudocode

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

# BFS

![BFS](Breadth-First-Search-Algorithm.gif)

## Pseudocode

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