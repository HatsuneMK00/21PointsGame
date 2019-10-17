package makise.ooad.lab2.controller;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.entity.Response;
import makise.ooad.lab2.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

@ResponseBody
@Controller
public class BetController {
    @Autowired
    GameService gameService;

//    不知道数组放在url里传不传的过来
    @GetMapping("gameProgress/bet")
    public Response bet(@RequestParam("bets") int[] bets){
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

        requestContent.put("bets",bets);
        request.setRequestContent(requestContent);
        return gameService.gameContinue(request);
    }
}
