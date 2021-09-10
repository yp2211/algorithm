package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2 {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDD"));
        System.out.println(predictPartyVictory("RDRDD"));
    }

    public static String predictPartyVictory(String senate) {
        // Queue
        Queue<Integer> r = new LinkedList<Integer>();
        Queue<Integer> d = new LinkedList<Integer>();
        int length = senate.length();
        for(int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }
        while (!(r.isEmpty() || d.isEmpty())) {
            int rPoll = r.poll();
            int dPoll = d.poll();
            if (rPoll < dPoll) {
                r.offer(rPoll + length);  // +length --> round control
            } else {
                d.offer(dPoll + length);
            }
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}
