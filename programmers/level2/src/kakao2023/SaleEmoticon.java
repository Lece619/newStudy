/*
https://school.programmers.co.kr/learn/courses/30/lessons/150368
        2023 KAKAO BLIND RECRUITMENT
        이모티콘 할인행사
*/

package kakao2023;

import java.util.ArrayList;

//할인율은 10%, 20%, 30%, 40% 중 하나로 설정
public class SaleEmoticon {
    ArrayList<String> saleTable = new ArrayList<>();
    int subscription = 0;
    int price = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        makeSaleTable(new StringBuilder(), emoticons.length);
        for (String sale : saleTable) {
            findSubscription(users, sale, emoticons);
        }

        return new int[]{subscription, price};
    }

    private void findSubscription(int[][] users, String sale, int[] emoticons) {

        int totalSubscription = 0;
        int totalPrice = 0;
        int[] emotionPrice = makeEmotionPrice(sale, emoticons);

        for (int[] user : users) {

            int limitSaleRate = user[0];
            int limitPrice = user[1];
            int usersPrice = 0;

            for (int i = 0; i < sale.length(); i++) {
                int itemsSale = Integer.parseInt(String.valueOf(sale.charAt(i))) * 10;

                if(itemsSale >= limitSaleRate){
                    usersPrice += emotionPrice[i];
                }
            }

            if(limitPrice <= usersPrice){
                totalSubscription++;
            }else{
                totalPrice += usersPrice;
            }
        }

        if(subscription < totalSubscription){
            subscription = totalSubscription;
            price = totalPrice;
            return;
        }

        if(subscription == totalSubscription){
            price = Math.max( price, totalPrice);
            return;
        }
    }

    private int[] makeEmotionPrice(String sale, int[] emoticons) {
        int[] result = new int[emoticons.length];
        for (int i = 0; i < emoticons.length; i++) {
            result[i] = ( emoticons[i] / 10 ) * (10 - Integer.parseInt(String.valueOf(sale.charAt(i))));
        }
        return result;
    }

    private void makeSaleTable(StringBuilder sb, int length) {
        if(sb.length() == length){
            saleTable.add(sb.toString());
            return;
        }
        for (int i = 1; i <= 4; i++) {
            sb.append( i );
            makeSaleTable(sb, length);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        SaleEmoticon saleEmoticon = new SaleEmoticon();
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
        int[] solution = saleEmoticon.solution(users, emoticons);
        for (int i : solution) {
            System.out.print( i + " ");
        }
    }
}
