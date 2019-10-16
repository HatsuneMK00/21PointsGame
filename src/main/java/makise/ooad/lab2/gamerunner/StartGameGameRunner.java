package makise.ooad.lab2.gamerunner;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.entity.Response;
import makise.ooad.lab2.pointgame.House;
import makise.ooad.lab2.pointgame.Player;
import makise.ooad.lab2.pointgame.PointGame;

import java.util.ArrayList;
import java.util.HashMap;

public class StartGameGameRunner extends GameRunner {
    @Override
    protected String getHandlerLevel() {
        return "start";
    }

//    处理一次玩家开始游戏（发两张牌）的逻辑
//    玩家id和所有可能的需要的数据都在request里面
    //    这个方法调用后为各发两张牌的状态
//    只负责处理一个玩家得游戏开局
//    每个request里面都有一个PointGame类对象的引用 表示该用户游玩的21点游戏 键为"game"
//    这个request里面有一个int bet 表示该玩家下的注 键为"bet"
//    request里面有一个playerId 键为"playerId"
    @Override
    protected Response echo(Request request) {
        HashMap<String,Object> requestContent = request.getRequestContent();
        PointGame pointGame = (PointGame) requestContent.get("game");
        int bet = (Integer) requestContent.get("bet");
        int id = (Integer)requestContent.get("playerID");
        Player currentPlayer = pointGame.getPlayers().get(id);
        currentPlayer.getHand(pointGame.getDealer());
        currentPlayer.setBetNum(bet);
        House house = pointGame.getHouse();
        house.getHand(pointGame.getDealer());
        house.setBetNum(bet);
        int turn = 1;
        Response response = new Response(1,turn,false);
        return capAndReturn(house,pointGame,response,2);
    }
}
