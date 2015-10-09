# Objectives

* Learn how to represent knowledge using Graph as data structure
* Homework 1 discussion

# Metrics/Desired Outcomes

* Understanding graphs theory
* Programming graphs
* Reading/writing graphs from/to file
* Basic graph traversal
* Complexity analysis (space and/or time)

# Information

## Knowledge Representation

### Examples

* Social network
* Map/city (locations)
* Game States

### Types of Graphs

* Directed/Undirected
* Weighted

### Best Practices

> Or at least good practices ...

* Abstract as graph data structure
* Abstract problems as states

## Graph as Abstract Data Structure

### 3 ways to represent graph

1. Adjacency Matrix
2. Adjacency List
3. Object Oriented

#### Complexity Analysis

  | Adjacency List | Adjacency Matrix 
-- | -- | --
Store graph | O(&#124;V&#124; + &#124;E&#124;) | O(&#124;V&#124;<sup>2</sup>)
Add vertex | O(1)| O(&#124;V&#124;<sup>2</sup>)
Add edge | O(1) | O(1) 
Remove vertex | O(&#124;E&#124;) | O(&#124;V&#124;<sup>2</sup>)
Remove edge | O(&#124;E&#124;) | O(1)
Query | O(&#124;V&#124;) | O(1)
Remarks | Slow to remove vertices and edges, because it needs to find all vertices or edges | Slow to add or remove vertices, because matrix must be re-sized/copied


### Components

* Node (vertex)
* Edge
* Graph

### Methods

* Adjacent
* Neighbors

## Graph Traversal Algorithms Overview

* Breadth First Search (BFS)
* Depth First Search (DFS)
* A-star
* Dijkstra
* Alpha-beta
* Min-max

# Learning

## Homework 1

Finish remaining code for graph package
