package view;

import domain.Menu;

public class OutputView {

    static final String START = """
            =================================
            ====    !!! Jin Coffee !!!    ===
            =================================""";

    static final String END = """
            =================================
            ====    !!! THANK YOU  !!!    ===
            =================================""";
    static final String END_BALANCE = """
            =================================
            ====    !!! YOUR MONEY  !!!   ===
            ====\t %s won !!!!!
            =================================""";
    public void printOnMessage() {
        System.out.println(START);
    }


    public void printOffMessage(int money) {
        System.out.println(END);
        System.out.printf(END_BALANCE, money);

    }

    public void comeBeverage(Menu menuByNum) {
        int time = menuByNum.getTime();
        for (int i = 0; i < time; i++) {
            try{
                Thread.sleep(500);
                System.out.println(time - i + " ! ");
                if(i == time - 1){
                    System.out.println(menuByNum.getMenuName() + " ! 완성!!");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
