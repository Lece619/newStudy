package normal;
//https://programmers.co.kr/learn/courses/30/lessons/12941 최소값만들기

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MakeMin {

        public int solution(int []A, int []B)
        {
            int answer = 0;
            int size = A.length;
            Arrays.sort(A);
            Arrays.sort(B);
            for (int i = 0; i < size; i++) {
                answer=A[i]*B[size-i-1];
            }

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");

            return answer;
        }
}
