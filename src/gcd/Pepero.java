package gcd;

import java.util.ArrayList;

public class Pepero {
    public static void main(String[] args) {
        int M = 4;
        int N = 8;
        ArrayList<Integer[]> output = divideChocolateStick(M, N);
        System.out.println(output);
        // [[1, 4, 8], [2, 2, 4], [4, 1, 2]]
    }
    public static ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        ArrayList<Integer[]> result = new ArrayList<>();

        int min = Math.min(M,N);
        int max = Math.max(M,N);

        //유클리드 알고리즘
        while (min!=0){
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        int gcd = max;

        for (int i = 1; i <= gcd; i++) {
            if (gcd%i==0) result.add(new Integer[]{i,M/i,N/i});
        }
        return result;
    }

}
