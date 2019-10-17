package makise.ooad.lab2.service;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.entity.Response;
import makise.ooad.lab2.gamerunner.GameRunner;
import makise.ooad.lab2.pointgame.PointGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;

//这边考虑要不要把这个类变成一个抽象基类或者接口？（模板方法模式 游戏的实现会更加具有扩展性）
//或者是把gameRunner抽象为一个基类 效果一样但是多了一层 不知道有没有用 可以将实现的包和Service包完全分隔开
//还是挺有用的
@Service
public class GameService {
//    现在这个game是全局唯一的
//    但是可以比较容易的换成一个session唯一的
    @Autowired
    PointGame game;
    private GameRunner gameRunner = GameRunner.constructGameRunnerCOR();

    public Response gameContinue(Request request){
        request.getRequestContent().put("game",game);
        Response response = gameRunner.handleRequest(request);
        if (response == null) {
            System.out.println("what???");
            return response;
        }
        if (response.getTurn() == 0) {
            request.getRequestContent().put("playerId",0);
            request.setLevel("stand");
            response = gameRunner.handleRequest(request);
        }
        return response;
    }
}
