# Java Style Guide

This guide is establish some guidelines of Java programming style.

To start off, we will talk about general format for code containing
syntax, indentation, characters per line.

### Naming convention

* `lowerCamelCase` for variables and methods.
* `CONSTANT_ALL_CAP` for constants
* `UpperCamelCase` for class name

### Indentation

* `4 spaces` to indent.

### 80 Characters per line

With some exceptions like if you only have one word left on the line, then just
go with the word within line.

### Egyptian Bracket Style

```java
if (true) {
    // one true bracket style
}
```

over

```java
if (true)
{
    // :grumpycat:
}
```

### No wild card `*` import

As wild card import occurs, it destroy a way to trace down.

## General Structure

Variables comes before methods

```java
public class Node {
    // immutable by default -- final
    public final String name;
    public final Collection<Edge> edges;

    public String getName() {
        return name;
    }

    public Node setName(String name) {
        this.name = name;
        // return this for chaining setters
        return this;
    }

    public Collection<Edge> getEdges() {
        return edges;
    }

    public Node setEdges(Collecton<Edge> edges) {
        this.edges = edges;
        return this;
    }
}
```
