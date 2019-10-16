package makise.ooad.lab2.pointgame;

import makise.ooad.lab2.entity.GameStatus;

abstract class Gambler {
//    用户id
    protected int id;
//    用户名字
    protected String name;
//    手牌对象
    protected Hand hand;
//    钱包对象
    protected Money money;

    public Gambler(int id,String name, int moneyAmount){
        money = new Money(moneyAmount);
        this.id=id;
        this.name=name;
    }
    public Gambler(){}
    public void getHand(Dealer dealer){
        this.hand = dealer.start();
    }

    public void getOneCard(Dealer dealer){
        if(!hand.addCard(dealer.deal()))
            bust();
    }

    public void bust(){
        hand.setBusted();
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
    public int getBetNum() {
        return hand.getBetNum();
    }

    public void setBetNum(int betNum) {
        hand.setBetNum(betNum);
    }
    public abstract boolean hit(Dealer dealer);
    public void addBet(int amount){
        hand.setBetNum(hand.getBetNum()+amount);
        money.subtractMoney(amount);
    }
}
