package com.seat;

import java.util.Comparator;

public class SeatPriority implements Comparator<People> {

    @Override
    public int compare(People o1, People o2) {
        if (o1.type.equals(o2.type)){
            return o1.num - o2.num;
        }
        return o2.type.typeValue - o1.type.typeValue;
    }
}
