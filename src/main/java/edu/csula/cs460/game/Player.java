package edu.csula.cs460.game;

public interface Player {
    void accept(GameState gameState);

    Move getMove();
}
