package makise.ooad.lab2.service;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.pointgame.Dealer;
import makise.ooad.lab2.pointgame.Judge;
import makise.ooad.lab2.pointgame.Player;

import java.util.ArrayList;

public abstract class Handler {
    private Handler nextHandler = null;
//    这里可以不写死一个成员变量 而是通过一个需要实现类实现的抽象方法来实现不同子类不同处理级别
//    private int level;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }

    public ArrayList<GameStatus> handleRequest(Request request) {
        ArrayList<GameStatus> response = null;
//        注意这里如果level是对象的话 使用equal方法
        if (request.getLevel().equals(this.getHandlerLevel())) {
            response = this.echo(request);
        } else {
            if (nextHandler != null) {
                System.out.println(this.getClass().getName() + " dispatcher");
                response = nextHandler.handleRequest(request);
            } else {
//                没有处理者时的处理逻辑
            }
        }
        return response;
    }

    abstract protected String getHandlerLevel();

    abstract protected ArrayList<GameStatus> echo(Request request);
}
