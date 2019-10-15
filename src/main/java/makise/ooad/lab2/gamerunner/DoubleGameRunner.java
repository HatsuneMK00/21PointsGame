package makise.ooad.lab2.gamerunner;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.entity.Response;

import java.util.ArrayList;

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
        return null;
    }
}
