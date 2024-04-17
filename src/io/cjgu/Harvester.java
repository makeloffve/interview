package io.cjgu;

import java.util.Arrays;
import java.util.Comparator;

public class Harvester {

    /**
     * 1. 按结束时间先排序
     * 2. 从最早结束麦田开始收割
     * 2.1 如果下个麦田开始时间在当前麦田结束时间之后,那么直接用这台收割机,也不需要新的
     * 2.2 开始时间在当前麦田结束时间之前, 需要用新的收割机
     *
     * @param harvestTimes 麦田工作开始结束时间
     * @return 需要多少台机器
     */
    public static int minHarvesters(int[][] harvestTimes) {
        if (harvestTimes == null || harvestTimes.length == 0) return 0;

        Arrays.sort(harvestTimes, Comparator.comparingInt(time -> time[1]));

        int harvesterCount = 1;
        int lastEndTime = harvestTimes[0][1];

        for (int i = 1; i < harvestTimes.length; i++) {
            int start = harvestTimes[i][0];
            int end = harvestTimes[i][1];
            if (start > lastEndTime) {
                harvesterCount++;
                lastEndTime = end;
            }
        }

        return harvesterCount;
    }

    public static void main(String[] args) {
        int[][] harvestTimes = {{1, 4}, {3, 5}, {0, 6}, {5, 7}, {3, 9}};
        System.out.println(minHarvesters(harvestTimes));
    }

}
