package makise.ooad.lab2.gamerunner;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.entity.Response;
import makise.ooad.lab2.pointgame.House;
import makise.ooad.lab2.pointgame.Player;
import makise.ooad.lab2.pointgame.PointGame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DoubleGameRunner extends GameRunner {
    @Override
    protected String getHandlerLevel() {
        return "double";
    }

//    处理一次玩家double的逻辑
//    玩家id和所有可能的需要的数据都在request里面
//    类似其他handler的说明
    @Override
    protected Response echo(Request request) {
        HashMap<String, Object> requestContent = request.getRequestContent();
        int id = (Integer) requestContent.get("playerId");
        PointGame pointGame = (PointGame) requestContent.get("game");
        Player currentPlayer = pointGame.getPlayers().get(id-1);
        House house = pointGame.getHouse();
        house.addBet(currentPlayer.getBetNum());
        currentPlayer.addBet(currentPlayer.getBetNum());
        currentPlayer.hit(pointGame.getDealer());
        int turn = (id+1)%(pointGame.getPlayers().size()+1);
        int round = pointGame.getRound();
        Response response = new Response(round,turn,false);
        return capAndReturn(house,pointGame,response,null);
    }
}
