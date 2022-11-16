/*
https://school.programmers.co.kr/learn/courses/30/lessons/42577
        해시
        전화번호 목록
*/

package hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PhoneNumberBook {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        ArrayList<Set<String>> startNum = new ArrayList<>();
        IntStream.range(0,21).forEach(i->startNum.add(new HashSet<>()));
        for (String s : phone_book) {
            startNum.get(s.length()).add(s);
        }
        for (String s : phone_book) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                 sb.append(s.charAt(i));
                 if(startNum.get(i+1).contains(sb.toString())){
                     return false;
                 }
            }
        }

        Set<String> numbers = new HashSet<>();
        for (String num : phone_book) {
            for (String number : numbers) {
                if(num.equals(number)){
                    continue;
                }
                if(num.startsWith(number)){
                    return false;
                }
                if(number.startsWith(num)){
                    return false;
                }
            }
            numbers.add(num);
        }

        return answer;
    }


    public static void main(String[] args) {
        PhoneNumberBook phoneNumberBook = new PhoneNumberBook();
        String[] phone_book = {"123","456","789"};

        boolean solution = phoneNumberBook.solution(phone_book);
        System.out.println("phone_book = " + solution);

    }
}
