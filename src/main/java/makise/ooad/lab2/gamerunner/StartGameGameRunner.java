package makise.ooad.lab2.gamerunner;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.entity.Response;

import java.util.ArrayList;

public class StartGameGameRunner extends GameRunner {
    @Override
    protected String getHandlerLevel() {
        return "start";
    }

//    处理一次玩家开始游戏（发两张牌）的逻辑
//    玩家id和所有可能的需要的数据都在request里面
    //    这个方法调用后为各发两张牌的状态

//    每个request里面都有一个PointGame类对象的引用 表示该用户游玩的21点游戏 键为"game"
//    这个request里面有一个int[] bets 表示每个人下的注 键为"bets"
//    其他的request里面有一个playerId 键为"playerId"
    @Override
    protected Response echo(Request request) {
        return null;
    }
}
