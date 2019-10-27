package makise.ooad.lab2.controller;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.entity.Response;
import makise.ooad.lab2.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@ResponseBody
@Controller
public class BetController {
    @Autowired
    GameService gameService;

    //    不知道数组放在url里传不传的过来
    @ApiOperation(value = "每位玩家下注并开始游戏", notes = "传入一个bets数组")
    @ApiImplicitParam(name = "bets", value = "按照顺序传入每位玩家下的注并开始游戏，调用后会给所有人发两张牌，即进入游戏开始状态", required = true)
    @GetMapping("gameProgress/bet")
    public Response bet(@RequestParam("bets") int[] bets) {
        Request request = new Request();
        request.setLevel("start");
        HashMap<String, Object> requestContent = new HashMap<>();
////        测试用
//        if (bets == null){
//            System.out.println("no bets");
//            return null;
//        }
//        for (int i:bets
//             ) {
//            System.out.println(i);
//        }
//        System.out.println(bets.getClass());

        requestContent.put("bets", bets);
        request.setRequestContent(requestContent);
        return gameService.gameContinue(request);
    }
}
