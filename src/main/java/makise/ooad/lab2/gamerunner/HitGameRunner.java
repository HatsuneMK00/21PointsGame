package makise.ooad.lab2.gamerunner;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.entity.Response;
import makise.ooad.lab2.pointgame.PointGame;

import java.util.ArrayList;
import java.util.HashMap;

public class HitGameRunner extends GameRunner {
    @Override
    protected String getHandlerLevel() {
        return "hit";
    }

//    处理一次玩家hit的逻辑
//    玩家id和所有可能的需要的数据都在request里面
    //    这个方法调用后为用户id为{id}的用户抽了一张牌后的状态

    @Override
    protected Response echo(Request request) {
//        Response response = new Response();
//        HashMap<String, Object> requestContent = request.getRequestContent();
//        PointGame pointGame = (PointGame) requestContent.get("game");
//        GameStatus gameStatus = new GameStatus();
//        pointGame.setRound(pointGame.getRound() + 1);
//        gameStatus.setRound(pointGame.getRound());
//        response.addGameStatus(gameStatus);
        return null;
    }
}
