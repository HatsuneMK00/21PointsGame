package makise.ooad.lab2.pointgame;

abstract class Gambler {
//    用户id
    protected int id;
//    用户名字
    protected String name;
//    手牌对象
    protected Hand hand = new Hand();
//    钱包对象
    protected Money money = new Money();

    public void getTwoCard(Dealer dealer){

    }

    public void getOneCard(Dealer dealer){

    }

    public void bust(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public abstract void hit();
    public abstract void stand();
}
