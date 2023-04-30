package domain;

import java.util.ArrayList;

public class Basket {

    private int money;
    private ArrayList<Menu> menus = new ArrayList<>();

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addCoin(int coin){
        this.money += coin;
    }

    public void spendMoney(int money){
        this.money -= money;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }
}
