package makise.ooad.lab2.testing;

import org.springframework.stereotype.Service;

@Service
public class HoldOn {
    private Entity entity = new Entity();

    public int pleaseHoldOn(){
        entity.add();
        return entity.getNum();
    }
}
