package powerSet;

import java.util.ArrayList;

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
        return null;
    }
}
