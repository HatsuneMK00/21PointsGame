package makise.ooad.lab2.entity;

import java.util.ArrayList;

public class Response {
    private ArrayList<GameStatus> gameStatuses = new ArrayList<>();

    public ArrayList<GameStatus> getGameStatus() {
        return gameStatuses;
    }

    public void addGameStatus(GameStatus gameStatus) {
        this.gameStatuses.add(gameStatus);
    }
}
