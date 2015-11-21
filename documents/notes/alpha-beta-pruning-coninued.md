# Objectives

* Quiz 2 Discussion
* Minimax & Alpha-beta review
* Implementation of above two in bidding tic-tac-toe
* Homework 4 announcement
* Project

# Metrics/Desired Outcomes

* Apply Minimax to solve bidding tic-tac-toe
* Understanding of homework
* Understanding of project description

## Pseudocode

**Minmax - Our modification to use Graph interface**
```js
function minimax(graph, sourceNode, depth, maximizingPlayer) {
    // usually being optimized in a way to compute even before
    // the end of game by **evaluate** function
    if (depth = 0 || sourceNode is a leaf) {
        return evaluate(soureNode.gameState); // return a number
    }

    if (maximizingPlayer) {
        bestValue = Number.MAX_VALUE; // positive infinite
        for (node in graph.neighbors(sourceNode)) {
            value = minimax(node, graph, depth - 1, false);
            bestValue = Math.max(bestValue, value);
        }
        return bestValue;
    } else {
        bestValue = Number.MIN_VALUE; // negative infinite
        for (node in graph.neighbors(sourceNode)) {
            value = minimax(node, graph, depth - 1, true);
            bestValue = Math.min(bestValue, value);
        }
        return bestValue;
    }
}

// initial call of the above function to traverse 3 level for example
minimax(graph, startingNode, 3, TRUE);
```

```js
function alphabeta(node, depth, α, β, maximizingPlayer)
    if depth = 0 or node is a terminal node
        return the heuristic value of node
    if maximizingPlayer
        v := -∞
        for each child of node
            v := max(v, alphabeta(child, depth - 1, α, β, FALSE))
            α := max(α, v)
            if β ≤ α
                break (* β cut-off *)
        return v
    else
        v := ∞
        for each child of node
            v := min(v, alphabeta(child, depth - 1, α, β, TRUE))
            β := min(β, v)
            if β ≤ α
                break (* α cut-off *)
        return v
```

# Sample code for Bidding Tic-tac-tie

```java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static String[][] board;
    static int[] playerBids = {4, 4};
    static int currentPlayer = 0;
    static int tieWinner = 0;

    public static void main(String[] args) {
        // parse the input
        Scanner in = new Scanner(System.in);

        String player = in.nextLine();
        String move = in.nextLine();

        List<Integer> player1History = Arrays.stream(
            in.nextLine().split(" ")
         ).mapToInt(token -> {
            System.err.println("player history move: " + token);
            if (token != null && !token.equals("")) {
                return Integer.parseInt(token);
            } else {
                return 0;
            }
        })
            .boxed()
            .collect(Collectors.toList());

        List<Integer> player2History = Arrays.stream(
            in.nextLine().split(" ")
        ).mapToInt(token -> {
            if (token != null && !token.equals("")) {
                return Integer.parseInt(token);
            } else {
                return 0;
            }
        })
            .boxed()
            .collect(Collectors.toList());

        board = new String[3][3];

        int row = 0;
        while (in.hasNextLine()) {
            board[row] = in.nextLine().split("");
            for (int j = 0; j < board[row].length; j ++) {
                System.err.print(board[row][j] + " ");
            }
            row ++;
            System.err.println();
        }

        // calculate current bid
        for (int i = 0; i < player1History.size(); i ++) {
            if (player1History.get(i) > player2History.get(i)) {
                playerBids[0] -= player1History.get(i);
                playerBids[1] += player1History.get(i);
            } else if (player1History.get(i) < player2History.get(i)) {
                playerBids[0] += player2History.get(i);
                playerBids[1] -= player2History.get(i);
            } else {
                int tieLoser = (tieWinner == 0) ? 1 : 0;
                playerBids[tieWinner] -= player2History.get(i);
                playerBids[tieLoser] += player2History.get(i);
                tieWinner = tieLoser;
            }
        }

        switch (player) {
            case "X":
                currentPlayer = 0;
                break;
            case "O":
                currentPlayer = 1;
                break;
        }

        switch (move) {
            case "BID":
                System.err.println("Current player bid: " + playerBids[currentPlayer]);
                System.out.println(generateRandomBidding())

                break;
            case "PLAY":
                String randomMove = generateRandomMoves();
                System.out.println(randomMove);
                break;
        }
    }

    public static int generateRandomBidding() {
        if (playerBids[currentPlayer] > 0) {
            Random ran = new Random();
            int randomBid = ran.nextInt(playerBids[currentPlayer]);
            return (randomBid == 0) ? 1 : randomBid;   
        } else {
            return 0;
        }
    }

    public static String generateRandomMoves() {
        Random ran = new Random();
        int row = ran.nextInt(3);
        int col = ran.nextInt(3);

        System.err.println("Current board position: ");
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                System.err.print(board[i][j]);
            }
            System.err.println();
        }
        System.err.println("Checking position " + row + ":" + col);

        if (!board[row][col].equals("_")) {
            return generateRandomMoves();
        } else{
            return "" + row + " " + col;
        }
    }
}
```

# Instructions on Bidding Tic-tac-toe

- [x] Being able to read board position
- [x] Store the board as two dimensional array of Tile
- [x] Able to parse a list of history and compute how much gold each player has
- [x] Able to determine who you are (player 1 or 2)
- [x] Able to do debug print (`System.err.print`)
- [ ] List possible next moves out of player (you or your opponent)
- [ ] Use rule-based approach to solve bidding
```
If opponent has no gold:
    return 1;
else check board position, if about to win/lose:
    return all gold
else return random gold (or maybe use minimax score below to compute gold)
```
- [ ] Apply minimax/alpha-beta to find out best move for tic-tac-toe
    - [ ] Evaluate function that take end board and return a score based on the rule below
    ```
100 for 3 in a line
10 for 2 in a line with an empty tile on third
1 for 1 in a line with two empty tile on the same line
(do the negative for opponent)
0 otherwise
Evaluate total 8 lines and return the sum score (vertical, diagonal and horizontal ones)
    ```
    - [ ] Using the above scores in the leaf node, pass it up and use in the minimax function
    - [ ] pick best move
---
Extra:
- [ ] Can your code take bidding into concern of minimax as well?
