package view;

import domain.Basket;
import domain.Menu;

public class Validator {

    public static final String INVALID_MESSAGE_RANGE = "범위의 숫자만 입력해 주세요";
    public static final String INVALID_MESSAGE_NO_INTEGER = "숫자만 입력해 주세요";
    private static final String INVALID_MESSAGE_NOMONEY = "돈이 부족합니다.";
    public static String INVALID_MESSAGE = "1 ~ 3 사이에 숫자만 입력해 주세요";

    int num;
    public boolean behaviorValid(String behaviorNum) {
        INVALID_MESSAGE = INVALID_MESSAGE_RANGE;
        try{
            num = Integer.parseInt(behaviorNum);
        }catch (Exception e){
            INVALID_MESSAGE = INVALID_MESSAGE_NO_INTEGER;
            return false;
        }
        return num > 0 && num < 4;
    }

    public boolean coinValid(String coin) {
        INVALID_MESSAGE = INVALID_MESSAGE_RANGE;
        try{
            num = Integer.parseInt(coin);
        }catch (Exception e){
            INVALID_MESSAGE = INVALID_MESSAGE_NO_INTEGER;
            return false;
        }
        return num > 0 && num < 5;
    }
    public boolean menuValid(String menu) {
        INVALID_MESSAGE = INVALID_MESSAGE_RANGE;
        try{
            num = Integer.parseInt(menu);
        }catch (Exception e){
            INVALID_MESSAGE = INVALID_MESSAGE_NO_INTEGER;
            return false;
        }
        return num > 0 && num < ( Menu.values().length + 2 );
    }

    public boolean addMenuValid(Basket basket, int menu) {
        INVALID_MESSAGE = INVALID_MESSAGE_NOMONEY;
        return basket.getMoney() < Menu.getMenuByNum(menu).getPrice();
    }
}
