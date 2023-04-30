package service;

import domain.Basket;
import domain.Menu;
import view.InputView;
import view.OutputView;
import view.Validator;

public class MachineService {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    Validator validator = new Validator();

    private Basket basket;

    public void OnMachine(){
        outputView.printOnMessage();
        basket = new Basket();
    }

    public void runningMachine() {
        int behaviorNum = inputView.chooseBehavior();

        while(behaviorNum != 3){

            if(behaviorNum == 1){
                buyMenu();
                behaviorNum = inputView.chooseBehavior();
                continue;
            }
            if(behaviorNum == 2) {
                insertMoney();
                behaviorNum = inputView.chooseBehavior();
            }
        }
    }

    private void buyMenu() {
        int menu;
        while((menu = inputView.pressMenu(basket)) != 5){
            if(validator.addMenuValid(basket, menu)){
                System.out.println(Validator.INVALID_MESSAGE);
                continue;
            };
            addMenuOnBasket(menu);
        }
    }

    private void addMenuOnBasket(int menu) {
        Menu menuByNum = Menu.getMenuByNum(menu);
        basket.getMenus().add(menuByNum);
        basket.spendMoney(menuByNum.getPrice());
        outputView.comeBeverage(menuByNum);
    }

    public void insertMoney(){
        int coin;
        while((coin = inputView.insertCoin()) != 4){
            addCoin(coin);
        }
    }

    private void addCoin(int coin) {
        if(coin == 1)
            basket.addCoin(50);
        if(coin == 2)
            basket.addCoin(100);
        if(coin == 3)
            basket.addCoin(500);
    }


    public void OffMachine() {
        outputView.printOffMessage(basket.getMoney());
    }
}
