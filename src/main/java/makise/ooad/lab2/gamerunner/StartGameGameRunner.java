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

//    处理开始游戏（发两张牌）的逻辑
//    玩家id和所有可能的需要的数据都在request里面
    //    这个方法调用后为各发两张牌的状态
//    每个request里面都有一个PointGame类对象的引用 表示该用户游玩的21点游戏 键为"game"
//    这个request里面有一个int[] bets 表示玩家下的注 键为"bets"
//    request里面有一个playerId 键为"playerId"
    @Override
    protected Response echo(Request request) {
        HashMap<String,Object> requestContent = request.getRequestContent();
        PointGame pointGame = (PointGame) requestContent.get("game");
        int[] bets = (int[]) requestContent.get("bets");
        House house = pointGame.getHouse();
        house.getHand(pointGame.getDealer());
        int i=0;//小标从0开始，与玩家的下标是错位的
        for(Player player : pointGame.getPlayers()){
            player.setBetNum(i);
            player.getHand(pointGame.getDealer());
            house.addBet(i++);
        }
        int turn = 1;
        Response response = new Response(1,turn,false);
        return capAndReturn(house,pointGame,response,null);
    }
}
