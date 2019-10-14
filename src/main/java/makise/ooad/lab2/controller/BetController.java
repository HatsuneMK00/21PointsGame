package makise.ooad.lab2.controller;

import makise.ooad.lab2.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class BetController {
    @Autowired
    GameService gameService;

    @GetMapping("bet/{id}")
    public void bet(@PathVariable("id") Integer id, @RequestParam("num") Integer betNum){

    }

    @GetMapping("double/{id}")
    public void doubleBet(@PathVariable("id") Integer playerId){

    }
}
