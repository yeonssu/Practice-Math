package permitation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ChickenSource {
    public static void main(String[] args) {
        ArrayList<Integer[]> output1 = newChickenRecipe(new int[]{1, 10, 1100, 1111}, 2);
        for (Integer[] i : output1) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("-".repeat(50));
        /*
        [
        [1, 10], [1, 1100], [1, 1111],
        [10, 1], [10, 1100], [10, 1111],
        [1100, 1], [1100, 10], [1100, 1111],
        [1111, 1], [1111, 10], [1111, 1100]
        ];
        */

        ArrayList<Integer[]> output2 = newChickenRecipe(new int[]{10000, 10, 1}, 3);
        // null 이라서 반복문 실행안됨
        // for(Integer[] i : output2){
        //   System.out.println(Arrays.toString(i));
        // }
        System.out.println("-".repeat(50));


        ArrayList<Integer[]> output3 = newChickenRecipe(new int[]{11, 1, 10, 1111111111, 10000}, 4);
        for (Integer[] i : output3) {
            System.out.println(Arrays.toString(i));
        }
        /*
        [
        [1, 10, 11, 1111111111],
        [1, 10, 1111111111, 11],
        [1, 11, 10, 1111111111],
        [1, 11, 1111111111, 10],
        [1, 1111111111, 10, 11],
        [1, 1111111111, 11, 10],
        [10, 1, 11, 1111111111],
        [10, 1, 1111111111, 11],
        [10, 11, 1, 1111111111],
        [10, 11, 1111111111, 1],
        [10, 1111111111, 1, 11],
        [10, 1111111111, 11, 1],
        [11, 1, 10, 1111111111],
        [11, 1, 1111111111, 10],
        [11, 10, 1, 1111111111],
        [11, 10, 1111111111, 1],
        [11, 1111111111, 1, 10],
        [11, 1111111111, 10, 1],
        [1111111111, 1, 10, 11],
        [1111111111, 1, 11, 10],
        [1111111111, 10, 1, 11],
        [1111111111, 10, 11, 1],
        [1111111111, 11, 1, 10],
        [1111111111, 11, 10, 1],
        ]
        */
    }

    public static ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        Arrays.sort(stuffArr);
        ArrayList<String> stringStuff = new ArrayList<>(Arrays.stream(stuffArr).mapToObj(Integer::toString).collect(Collectors.toList()));
        ArrayList<Integer> newStuff = new ArrayList<>();
        for (String s : stringStuff) {
            int countZero = (int) s.chars().filter(x -> x == '0').count();
            if (countZero < 3) {
                newStuff.add(Integer.valueOf(s));
            }
        }
        if (newStuff.size() < choiceNum || newStuff.size() == 0) return null;

        ArrayList<Integer[]> result = new ArrayList<>();
        permutation(0, choiceNum, new Integer[choiceNum], newStuff, result);
        return result;
    }

    //n개 중 choiceNum만큼 뽑는다(r=0부터 choiceNum까지 커진다)
    //stuff는 새로운배열 , stuffArr은 원래 배열, result에 새로운 배열을 추가한다
    public static void permutation(int r, int choiceNum, Integer[] stuff, ArrayList<Integer> stuffArr, ArrayList<Integer[]> result) {
        Integer[] newArray = Arrays.copyOf(stuff, choiceNum);
        if (r == choiceNum) {
            result.add(newArray);
            return;
        }
        for (Integer i : stuffArr) {
            if (Arrays.stream(stuff).filter(x -> x == i).count() >= 1) continue;
            newArray[r] = i;
            permutation(r + 1, choiceNum, newArray, stuffArr, result);
        }
    }

}
