package greedy;

import java.util.Arrays;

public class GymClothes2 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n+2];
        initStudents(lost, reserve, students);

        for (int i = 1; i < n; i++) {
            findRemainClothes(students, i);
        }

        return (int) Arrays.stream(students).filter(i->i>=0).count();
    }

    private void findRemainClothes(int[] students, int i) {
        if(students[i]>=0){
            return;
        }
        if(students[i -1]>0){
            students[i]++;
            students[i -1]--;
            return;
        }
        if(students[i +1]>0){
            students[i]++;
            students[i +1]--;
        }
    }

    private void initStudents(int[] lost, int[] reserve, int[] students) {
        students[0] = -1;
        students[students.length - 1] = -1;
        for (int i : lost) {
            students[i]--;
        }

        for (int i : reserve) {
            students[i]++;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        GymClothes2 gymClothes2 = new GymClothes2();
        System.out.println("gymClothes2.solution(n, lost, reserve) = " + gymClothes2.solution(n, lost, reserve));
    }
}
