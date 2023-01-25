package permitation;

import java.util.ArrayList;
import java.util.Arrays;

public class RockScissorPaper {
    public static void main(String[] args) {
        ArrayList<String[]> output = rockPaperScissors(5);
        for (String[] s : output){
            System.out.println(Arrays.toString(s));
        }

        /*
        [["rock", "rock", "rock", "rock", "rock"],
        ["rock", "rock", , "rock", "rock", "paper"],
        ["rock", "rock", , "rock", "rock", "scissors"],
        ["rock", "rock", "rock", "paper", "rock"],
        ["rock", "rock", "rock", "paper", "paper"],
        ["rock", "rock", "rock", "paper", "scissors"],
        ["rock", "rock", "rock", "scissors", "rock"],
        // ...etc ...]
        */
    }

    static String[] rps = new String[]{"rock","paper","scissors"};

    public static ArrayList<String[]> rockPaperScissors(int rounds) {
        ArrayList<String[]> result = new ArrayList<>();
        pi(0,rounds,new String[rounds],result);

        return result;
    }

    //nΠr = n개중 r개를 뽑는 경우의 수
    //3개중 5개를 뽑는 경우의 수
    public static void pi(int r, int rounds, String[] arr, ArrayList<String[]> result){

        if(r==rounds) {
            String[] newArr = Arrays.copyOf(arr,rounds);
            result.add((newArr));
            return;
        }
        for (String s : rps) {
            arr[r] = s;
            pi(r+1, rounds, arr,result);
        }
    }
}
