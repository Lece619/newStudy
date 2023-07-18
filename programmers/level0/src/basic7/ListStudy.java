package basic7;

import java.util.LinkedList;
import java.util.List;

public class ListStudy {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] swapArr = new int[]{1, 2, 3, 4, 5};
        ListStudy listStudy = new ListStudy();
        listStudy.swap(swapArr[0], swapArr[1]);

        for (int i : swapArr) {
            System.out.println(i);

        }
        System.out.println();

        listStudy.swap(swapArr, 0, 1);
        for (int i : swapArr) {
            System.out.println(i);
        }
    }

    void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
