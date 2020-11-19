package com.seat;

public class People {
    protected String name;
    protected String number;
    protected FigureType type;
    protected int num;

    public People(String name, String number){
        this.name = name;
        this.number = number;
        this.type = FigureType.valueOf(number.toUpperCase().substring(0,1));
        this.num = Integer.valueOf(number.substring(1));
    }
}

enum FigureType {
    S(4, "Pregnant"), P(3,"Patient"), E(2,"Elder"), C(1,"Child"), N(0,"Normal");

    public final int typeValue;
    public final String sign;
    FigureType(int typeValue, String sign){
        this.typeValue = typeValue;
        this.sign = sign;
    }
}