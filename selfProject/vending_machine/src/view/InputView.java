package view;

import domain.Basket;
import domain.Menu;

import java.util.Scanner;

public class InputView {

    private static final String INSERT_COIN_MESSAGE = "\n\n" +
            "=================================\n" +
                    "1. 50 원 \n" +
                    "2. 100 원 \n" +
                    "3. 500 원 \n" +
                    "4. 그만넣기 \n" +
            "=================================";

    private static final String MESSAGE_START_END =
            "=================================";
    Validator validator = new Validator();

    private static final String INSERT_MESSAGE = "" +
            "=================================\n" +
            "======돈 돈 돈 돈 돈 돈 돈 돈======\n" +
            "=================================";
    private static final String CHOOSE_BEHAVIOR =
            "=================================\n"+
            "1. 구매\n" +
            "2. 돈넣기\n" +
            "3. 끝내기\n" +
            "=================================";
    Scanner scanner = new Scanner(System.in);

    public int chooseBehavior() {
        System.out.println(CHOOSE_BEHAVIOR);
        String behaviorNum = scanner.nextLine();

        if(!validator.behaviorValid(behaviorNum)){
            System.out.println(Validator.INVALID_MESSAGE);
            return chooseBehavior();
        }
        return Integer.parseInt(behaviorNum);
    }

    public int insertCoin() {
        System.out.println(INSERT_MESSAGE);
        System.out.println(INSERT_COIN_MESSAGE);
        String coin = scanner.nextLine();

        if(!validator.coinValid(coin)){
            System.out.println(Validator.INVALID_MESSAGE);
            return insertCoin();
        }
        return Integer.parseInt(coin);
    }

    public int pressMenu(Basket basket) {
        printMenu(basket.getMoney());
        String menu = scanner.nextLine();

        if(!validator.menuValid(menu)){
            System.out.println(Validator.INVALID_MESSAGE);
            return pressMenu(basket);
        }
        return Integer.parseInt(menu);
    }

    private void printMenu(int money) {
        System.out.println(MESSAGE_START_END);
        System.out.println("===\t잔액 : " + money +" 원 \t !!!");
        for (Menu menu : Menu.values()) {
            System.out.printf("%d. %s ( %d )\n", menu.ordinal() + 1, menu.getMenuName(), menu.getPrice());
        }
        int length = Menu.values().length + 1;
        System.out.printf("%d. 주문 안해!\n", length);
        System.out.println(MESSAGE_START_END);
    }
}
