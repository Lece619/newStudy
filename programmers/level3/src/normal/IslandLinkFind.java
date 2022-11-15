/*
https://school.programmers.co.kr/learn/courses/30/lessons/42861
        탐욕법(Greedy)
        섬 연결하기
*/
package normal;

import java.util.*;

public class IslandLinkFind {

    public int solution(int n, int[][] costs)
    {
        int sum = 0;
        int[] island = new int[n];

        for(int i = 0; i < n; i++)
            island[i] = i;

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        for(int i = 0; i < costs.length; i++)
        {
            if(find(island, costs[i][0]) != find(island, costs[i][1]))
            {
                unite(island, costs[i][0], costs[i][1]);
                sum += costs[i][2];
            }
        }

        return sum;
    }


    //==> 순환을 표현하는 방법을 기억해 둘만하다.
    private int find(int[] island, int x)
    {
        if(island[x]== x)
            return x;
        return find(island, island[x]);
    }

    private void unite(int[] island, int x, int y)
    {
        int a = find(island, x);
        int b = find(island, y);
        island[a] = b;
    }

    public static void main(String[] args) {
        IslandLinkFind islandLink = new IslandLinkFind();

        int n = 5;
        int[][] costs = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}};
        int solution = islandLink.solution(n, costs);

        System.out.println("solution = " + solution);
    }
}