package combination;

import java.util.ArrayList;

public class BlackJack {
    public static void main(String[] args) {
        int output = boringBlackjack(new int[]{1, 2, 3, 4});
        System.out.println(output); // 1

        int output2 = boringBlackjack(new int[]{2, 3, 4, 8, 13});
        System.out.println(output2); // 3
    }

    public static int boringBlackjack(int[] cards) {
        ArrayList<Integer> sum = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int firstCard = cards[i];
                    int secondCard = cards[j];
                    int thirdCard = cards[k];

                    sum.add(firstCard + secondCard + thirdCard);
                }
            }
        }
        int cnt = 0;
        for (int i : sum){
            if(isPrime(i)) cnt++;
        }
        return cnt;
    }

    public static boolean isPrime(int x) {
        if (x == 1) return false;
        if (x == 2) return true;

        for (int i = 2; i < Math.sqrt(x)+1; i++) if (x % i == 0) return false;

        return true;
    }
}
