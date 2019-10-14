package makise.ooad.lab2.controller;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@ResponseBody
@Controller
public class BetController {
    @Autowired
    GameService gameService;

//    不知道数组放在url里传不传的过来
    @GetMapping("bet")
    public ArrayList<GameStatus> bet(@RequestParam("bets") int[] bets){
        return gameService.startGame(bets);
    }

    @GetMapping("double/{id}")
    public ArrayList<GameStatus> doubleBet(@PathVariable("id") int playerId){
        return gameService.doubleBet(playerId);
    }
}
