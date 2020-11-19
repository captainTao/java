package com.seat;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 需求： 座位优先级：孕妇>病人>老人>小孩>普通人；
 * */
public class Main {
    public static void main(String[] args) {
        Queue<People> peopleQueue = new PriorityQueue<>(new SeatPriority());
        peopleQueue.offer(new People("Tom", "E2"));
        peopleQueue.offer(new People("ShiJi", "N3"));
        peopleQueue.offer(new People("Long", "P1"));
        peopleQueue.offer(new People("Lie", "N2"));
        peopleQueue.offer(new People("Wen", "S2"));
        peopleQueue.offer(new People("Hong", "C3"));
        peopleQueue.offer(new People("Li", "C2"));
        peopleQueue.offer(new People("Lu", "E5"));

        System.out.println("优先级顺序为：");
        int len = peopleQueue.size();
        for (int i = 0; i < len; i++) {
            People e = peopleQueue.poll();
            System.out.println(e.name + ", " + e.number + ", " + e.type.sign);
        }
    }
}
