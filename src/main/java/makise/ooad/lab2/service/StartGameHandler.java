package makise.ooad.lab2.service;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;

import java.util.ArrayList;

public class StartGameHandler extends Handler {
    @Override
    protected String getHandlerLevel() {
        return "start";
    }

//    处理一次玩家开始游戏（发两张牌）的逻辑
//    玩家id和所有可能的需要的数据都在request里面
    //    这个方法调用后为各发两张牌的状态

    @Override
    protected ArrayList<GameStatus> echo(Request request) {
        return null;
    }
}
