package makise.ooad.lab2.gamerunner;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.entity.Response;
import makise.ooad.lab2.pointgame.House;
import makise.ooad.lab2.pointgame.Player;
import makise.ooad.lab2.pointgame.PointGame;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class StandGameRunner extends GameRunner {
    @Override
    protected String getHandlerLevel() {
        return "stand";
    }

//    处理一次玩家stand的逻辑
//    玩家id和所有可能的需要的数据都在request里面
    //    类似其他handler的说明

    @Override
    protected Response echo(Request request) {
        HashMap<String,Object> requestContent = request.getRequestContent();
        int id = (Integer) requestContent.get("playerId");
        PointGame pointGame = (PointGame) requestContent.get("game");
        int turn=id;
        House house = pointGame.getHouse();
        boolean isEnd = id==pointGame.getPlayers().size();
        int[] winStatus = null;
        if(id==0) {//如果传进来的id已经为0，则说明之前最后一个玩家在hit或double时进入了bust状态，则庄家行动，并直接进入结算
            house.hit(pointGame.getDealer());
            winStatus=payOff(pointGame);
        } else {//如果不为零，turn+1
            turn = (id+1)%(pointGame.getPlayers().size()+1);
            if(isEnd){//如果发现选择stand的是最后一名玩家，则庄家行动，进入结算
                turn=-1;
                house.hit(pointGame.getDealer());
                winStatus=payOff(pointGame);
            }
        }
        Response response = new Response(pointGame.getRound()+1,turn,isEnd);
        return capAndReturn(house,pointGame, response,winStatus);
    }
    private int[] payOff(@NotNull PointGame pointGame){
        int[] winStatus = new int[pointGame.getPlayers().size()];
        int i = 0;//winStatus数组的下标和player的下标是错位的，注意!!!
        House house = pointGame.getHouse();
        for(Player player : pointGame.getPlayers()){
            winStatus[i++]=pointGame.getJudge().judge(house,player);
        }
        return winStatus;
    }
}
