package makise.ooad.lab2.entity;

import java.util.ArrayList;

public class Response {
    private int round;
    //    用于指示接下来是玩家行动还是电脑行动
//    0表示电脑 其他数字对应玩家id
//    这个属性注意保持数组中所有对象一致
    private int turn;
    //    指示一轮是否结束
    private boolean isEnd;
    private ArrayList<GameStatus> gameStatuses = new ArrayList<>();
    public Response(int round,int turn,boolean isEnd){
        this.round = round;
        this.isEnd = isEnd;
        this.turn = turn;
    }
    public Response(){
    }
    public ArrayList<GameStatus> getGameStatus() {
        return gameStatuses;
    }
    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
    public void addGameStatus(GameStatus gameStatus) {
        this.gameStatuses.add(gameStatus);
    }
}
