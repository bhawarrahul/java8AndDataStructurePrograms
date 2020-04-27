package com.adobe.program.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 * <p>
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 * <p>
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 * Example 1:
 * <p>
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 * Note:
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        int[] array = {2, 7, 4, 1, 8, 1}; // ans 1
        System.out.println(new LastStoneWeight().lastStoneWeight(array));
    }

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0 || !(stones.length >= 1 && stones.length <= 30)) {
            return 0;
        }
        Queue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            if (stone >= 1 && stone <= 1000) {
                pQueue.add(stone);
            } else {
                return 0;
            }
        }
        while (pQueue.size() > 1) {
            pQueue.offer(pQueue.poll() - pQueue.poll());
        }
        return pQueue.poll();
    }
}
