package makise.ooad.lab2.controller;

import makise.ooad.lab2.testing.Entity;
import makise.ooad.lab2.testing.HoldOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("test")
public class testController {
    @Autowired
    HoldOn holdOn;

    @RequestMapping("holdon")
    public int holdOn(){
        return this.holdOn.pleaseHoldOn();
    }
}
