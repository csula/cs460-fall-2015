package edu.csula.cs460.game;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Game {
    private GameState gameState;

    public void run() {
        while (!gameState.isOver()) {
            gameState.getActivePlayers()
                .stream()
                .map(player -> {
                    player.accept(getGameState(player));
                    return player;
                })
                .collect(Collectors.toMap(Function.identity(), Player::getMove))
                .forEach(gameState::execute);
        }
    }

    public GameState getGameState(Player player) {
        return gameState;
    }
}
