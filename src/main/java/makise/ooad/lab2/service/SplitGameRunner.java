package makise.ooad.lab2.service;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;

import java.util.ArrayList;

public class SplitGameRunner extends GameRunner {
    @Override
    protected String getHandlerLevel() {
        return "split";
    }

//    处理一次玩家split的逻辑
//    玩家id和所有可能的需要的数据都在request里面
    //    这个方法调用后为用户id为{id}的用户分牌后的状态

    @Override
    protected ArrayList<GameStatus> echo(Request request) {
        return null;
    }
}
