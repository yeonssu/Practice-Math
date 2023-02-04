package powerSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static java.util.Arrays.sort;

public class HouseMeal {
    public static void main(String[] args) {
        ArrayList<String[]> output = missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup"});
        System.out.println(output);
        /*
        [ [],
        [eggroll, fishSoup, kimchi],
        [eggroll, fishSoup],
        [eggroll, kimchi],
        [eggroll],
        [fishSoup, kimchi],
        [fishSoup],
        [kimchi],
        ]
        */
    }

    public static ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        Stack<String> stack = new Stack<>();
        ArrayList<String[]> result = new ArrayList<>();

        Arrays.sort(sideDishes);
        result = makeList(stack, 0, sideDishes, result);
        result.sort((x,y)->Arrays.toString(x).compareTo(Arrays.toString(y)));
        return result;
    }

    public static ArrayList<String[]> makeList(Stack<String> stack, int idx, String[] sideDishes, ArrayList<String[]> result) {
        if (idx >= sideDishes.length) {
            String[] sub = stack.toArray(new String[0]);
            result.add(sub);
            return result;
        } else {
            stack.push(sideDishes[idx]);
            makeList(stack, idx + 1, sideDishes, result);

            stack.pop();
            makeList(stack, idx + 1, sideDishes, result);
        }
        return result;
    }
}
