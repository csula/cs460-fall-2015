package edu.csula.cs460.game;

import java.util.List;

public abstract class GameState {
    List<Player> players;

    public abstract List<Player> getActivePlayers();

    public abstract boolean isOver();

    public abstract void execute(Player player, Move move);

    public abstract List<Move> getLegalMoves();
}
