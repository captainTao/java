// 泛型作业：

package com.company;

/**
 * 1、泛型在集合、数组中的应用
 *
 * a. 集合类型List，Map, Set，Queue 在初始化后面的类型可以是字符串，整型，浮点型，或其他类对象
 * List<String> mutable = new ArrayList<>();
 * Map<String, Integer> map = new HashMap<>();
 * Set<String> set = new TreeSet<>();
 * Queue<String> q = new LinkedList<>();
 *
 * b.可以定义一个模板，让所有类型都能够通用，比如加和运算，转换，输出等等
 *
 **/


/**
 *
 * 2、计算圆锥、方锥的体积（默认方锥的底为矩形）
 * 描述:声明一个泛型类，包含计算体积的方法，只关心它的底是否能计算面积，并不关心底的类型。
 * 声明圆类和矩形类，分别包含计算面积的方法。用户输入圆锥的半径和高，打印输出圆锥的体积。
 * 输入方锥的长、宽、高，计算方锥的体积并输出。
 * 公式：1/3*底面积*高
 * 圆锥:半径、高
 * 方锥:长、宽、高
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("请依次输入圆锥的半径、高，并用空格隔开：");
        Scanner scanner1 = new Scanner(System.in);
        List<Double> circlePar = judgeInput(scanner1, 2, "double");
        Circle circle = new Circle(circlePar.get(0));
        Cone<Circle> coneCircle = new Cone<>(circle, circlePar.get(1));
        System.out.println("圆锥的体积是：" + coneCircle.getBulk());

        System.out.println("请输入方锥的长、宽、高，并用空格隔开：");
        Scanner scanner2 = new Scanner(System.in);
        List<Double> rectPar = judgeInput(scanner2, 3, "double");
        Rect rect = new Rect(rectPar.get(0), rectPar.get(1));
        Cone<Rect> coneRect = new Cone<>(rect, rectPar.get(2));
        System.out.println("方锥的体积是：" + coneRect.getBulk());

    }

    public static List judgeInput(Scanner scanner, int num, String str) {
        List<Object> list = new ArrayList<>();
        str = str.toLowerCase();
        for (int i = 0; i < num; i++) {
            if (str.equals("int") && scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            } else if (str.equals("double") && scanner.hasNextDouble()) {
                Double d = scanner.nextDouble();
                if (d.doubleValue() > 0) {
                    list.add(d);
                } else {
                    System.out.println("数据小于0, exit! ");
                    System.exit(0);
                }
            } else if (str.equals("string") && scanner.hasNext()) {
                list.add(scanner.next());
            } else if (scanner.hasNext()) {
                System.out.println("无法处理输入数据, exit!");
                System.exit(0);
            }
        }
        return list;
    }
}

class Cone<T> {
    private T s;
    private double h;

    public Cone(T s, double h) {
        this.s = s;
        this.h = h;
    }

    public double getBulk() {
        Double area = Double.valueOf(s.toString());
        System.out.println(area);
        return 1.0 / 3 * area * h;
    }
}

class Circle {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public String toString() {
        return "" + Math.PI * r * r;
    }
}

class Rect {
    private double w;
    private double l;

    public Rect(double w, double l) {
        this.w = w;
        this.l = l;
    }

    public String toString() {
        return "" + w * l;
    }
}