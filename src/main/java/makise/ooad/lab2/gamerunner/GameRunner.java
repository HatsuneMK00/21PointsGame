package makise.ooad.lab2.gamerunner;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.entity.Response;
import makise.ooad.lab2.pointgame.House;
import makise.ooad.lab2.pointgame.Player;
import makise.ooad.lab2.pointgame.PointGame;

import java.util.ArrayList;

public abstract class GameRunner {
    private GameRunner nextGameRunner = null;
//    这里可以不写死一个成员变量 而是通过一个需要实现类实现的抽象方法来实现不同子类不同处理级别
//    private int level;

//    发现这个方法不需要新建一个类来写 责任链模式可以做一些更改 少一个类
    public static GameRunner constructGameRunnerCOR(){
        GameRunner gameRunner = new HitGameRunner();
        GameRunner temp1 = new StandGameRunner();
        gameRunner.setNextGameRunner(temp1);
        GameRunner temp2 = new DoubleGameRunner();
        temp1.setNextGameRunner(temp2);
        temp1 = new StartGameGameRunner();
        temp2.setNextGameRunner(temp1);
        return gameRunner;
    }
    protected Response capAndReturn(House house, PointGame pointGame,Response response,int[] winStatus){
        if(winStatus==null){
            GameStatus houseStatus = new GameStatus(0,house.getBetNum(),house.getMoney().getBalance(),house.getHand().getCards(),
                    house.getHand().isBusted(),2);
            response.addGameStatus(houseStatus);
            for(Player player:pointGame.getPlayers()){
                GameStatus tem = new GameStatus(player.getId(),player.getBetNum(),player.getMoney().getBalance(),
                        player.getHand().getCards(),player.getHand().isBusted(),2);
                response.addGameStatus(tem);
            }
        }
        else {
            GameStatus houseStatus = new GameStatus(0,house.getBetNum(),house.getMoney().getBalance(),house.getHand().getCards(),
                    house.getHand().isBusted(),2);
            response.addGameStatus(houseStatus);
            int i = 0;
            for(Player player:pointGame.getPlayers()) {
                GameStatus tem = new GameStatus(player.getId(), player.getBetNum(), player.getMoney().getBalance(),
                        player.getHand().getCards(), player.getHand().isBusted(), winStatus[i++]);
                response.addGameStatus(tem);
            }
        }
        return response;
    }
    public void setNextGameRunner(GameRunner nextGameRunner) {
        this.nextGameRunner = nextGameRunner;
    }

    public GameRunner getNextGameRunner() {
        return nextGameRunner;
    }

    public Response handleRequest(Request request) {
        Response response = null;
//        注意这里如果level是对象的话 使用equal方法
        if (request.getLevel().equals(this.getHandlerLevel())) {
            response = this.echo(request);
        } else {
            if (nextGameRunner != null) {
//                System.out.println(this.getClass().getName() + " dispatcher");
                response = nextGameRunner.handleRequest(request);
            } else {
                System.out.println("cannot not be handled");
            }
        }
        return response;
    }

    abstract protected String getHandlerLevel();

    abstract protected Response echo(Request request);
}
