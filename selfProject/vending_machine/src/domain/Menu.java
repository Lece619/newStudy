package domain;

import java.util.Arrays;

public enum Menu {
    Menu1("커피", 300, 5),
    Menu2("율무차",400, 7),
    Menu3("유자차", 500, 4),
    Menu4("우유", 250, 3);

    private String menuName;
    private int price;
    private int time;

    Menu(String menuName, int price, int time) {
        this.menuName = menuName;
        this.price = price;
        this.time = time;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public int getTime() {
        return time;
    }

    public static Menu getMenuByNum(int num){
        return Arrays.stream(Menu.values()).filter(menu -> menu.ordinal() == num - 1).findFirst().get();
    }

}
