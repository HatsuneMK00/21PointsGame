package makise.ooad.lab2.gamerunner;

import javafx.print.PageLayout;
import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.entity.Response;
import makise.ooad.lab2.pointgame.House;
import makise.ooad.lab2.pointgame.Player;
import makise.ooad.lab2.pointgame.PointGame;
import org.graalvm.compiler.hotspot.stubs.CreateExceptionStub;

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
        House house = pointGame.getHouse();
        house.hit(pointGame.getDealer());
        Player currentPlayer = pointGame.getPlayers().get(id);
        int isWin = pointGame.getJudge().judge(house,currentPlayer);
        int turn = id+1;
        boolean isEnd = id==pointGame.getPlayers().size();
        Response response = new Response(pointGame.getRound()+1,turn,isEnd);
        return capAndReturn(house,pointGame, response,isWin);
    }
}
