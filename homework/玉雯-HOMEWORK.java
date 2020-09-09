import java.util.*;

public class HOMEWORK_2 {
    public static void main(String[] args) {
        String homeworkNum;
        do {
            System.out.println("请输入题号(1-5),跳出按0");
            homeworkNum = new Scanner(System.in).next();
            switch (homeworkNum) {
                case "1" -> homework1();
                case "2" -> homework2();
                case "3" -> homework3();
                case "4" -> homework4();
                case "5" -> homework5();
                case "6" -> homework6();
                default -> System.out.println("么得，拜拜");
            }
        } while (!homeworkNum.equals("0"));
    }

    //1.写程序,完成下列功能:
    //a.提示用户输入姓名，成绩
    //b.并用StringBuilder/StringJoiner拼接成字符串输出。
    //c.对输入成绩进行判断，分优，良，及格，差，并输出。
    public static void homework1() {
        StringJoiner str = new StringJoiner(":");
        final int MaxScore = 100;
        final int MinScore = 0;

        System.out.println("请输入您的名字");
        Scanner name = new Scanner(System.in);
        String input1 = name.next();
        str.add(input1);

        System.out.println("请输入您的分数");
        Scanner score = new Scanner(System.in);
        String input2 = score.next();
        str.add(input2);

        int i = Integer.parseInt(input2);
        if (i > MaxScore | i < MinScore) {
            System.out.println(input1 + "：请核实分数");
        } else {
            if (i >= 85) {
                str.add("优");
            }else if (i >= 75) {//
                str.add("良");
            }else if (i >= 60) {//
                str.add("及格");
            }else {
                str.add("差");
            }
            System.out.println(str);
        }
    }

    //==================================
    //2.程序题，跟电脑划拳，用户输入石头剪刀布后，然后打印输出谁赢了。
    public static void homework2() {
        List<String> guessList = new ArrayList<String>();
        guessList.add("石头");
        guessList.add("剪刀");
        guessList.add("布");

        System.out.println("猜拳！石头，剪刀，布，你出什么？");
        String typeIn = new Scanner(System.in).next();

        if (!typeIn.equals("石头") && !typeIn.equals("剪刀") && !typeIn.equals("布")) {
            System.out.println("猜拳只能出石头剪刀布哦");
            return;
        }
        Random computer = new Random();
        int n = computer.nextInt(guessList.size());
        String comGuess = guessList.get(n);
        System.out.println("电脑猜拳：" + comGuess);

        HashMap<String, String> scissorMap = new HashMap<String, String>();
        scissorMap.put("石头", "你输了");
        scissorMap.put("剪刀", "平局");
        scissorMap.put("布", "你赢了");

        HashMap<String, String> rockMap = new HashMap<String, String>();
        rockMap.put("石头", "平局");
        rockMap.put("剪刀", "你赢了");
        rockMap.put("布", "你输了");

        HashMap<String, String> paperMap = new HashMap<String, String>();
        paperMap.put("石头", "你赢了");
        paperMap.put("剪刀", "你输了");
        paperMap.put("布", "平局");

        HashMap<String, HashMap> guessMap = new HashMap<String, HashMap>();
        guessMap.put("石头", rockMap);
        guessMap.put("剪刀", scissorMap);
        guessMap.put("布", paperMap);

        System.out.println(guessMap.get(typeIn).get(comGuess));
    }

    //============================
    // 3.完成下列程序：

    public static void homework3() {
        int a = 72;
        int b = 105;
        int c = 65281;

        String word = String.valueOf((char) a) + String.valueOf((char) b) + String.valueOf((char) c);
        System.out.println(word);

    }

    //============================
// 4.
    public static void homework4() {

        // 完成setter,getter方法：
        Person hong = new Person();
        hong.setName("小红");
        hong.setAge(17);
        // 给setName()添加重载方法
        Person lei = new Person();
        lei.setName("李", "雷");
        // 给Person增加两个构造方法:如果不输入年龄，则默认18岁，
        // 比如：李刚默认18岁
        Person gang = new Person("李刚");
        Person ming = new Person("小明", 12);

        System.out.println(hong.getName());
        System.out.println(lei.getName());
        System.out.println(gang.getAge());
        System.out.println(ming.getAge());
    }


    //    5===============
    public static void homework5() {
        Person p1 = new Person("小明");
        System.out.println(Person.getCount()); // 1
        Person p2 = new Person("小红");
        System.out.println(Person.getCount()); // 2
        Person p3 = new Person("小军");
        System.out.println(Person.getCount()); // 3
    }


    public static void homework6() {
        // TODO: 用接口给一个有工资收入和稿费收入的小伙伴算税:
        Income[] incomes = new Income[]{new SalaryIncome(7500), new RoyaltyIncome(12000)};
        double total = 0;
        // TODO:
        for (Income income : incomes) {
            System.out.println(income.getTax());
            total = total + income.getTax();
            System.out.println(total);
        }
        System.out.println("最终税费："+total);
    }

}

//=====4、5题通用的Person=====
class Person {

    private static int count;
    private static ArrayList<String> nameList;


    private String name; //4
    private int age;

    static public int getCount() {
        return count;
    }

    public Person() {
        count++;

    }

    public Person(String name, int age) {
        count++;
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        count++;
        this.name = name;
        this.age = 18;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName(String lastName, String firstName) {
        this.name = lastName + firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }
};


//======6题要的=========
/*** 定义接口Income*/
interface Income {
    double getTax();
}



/*
 * 工资减去基数3000,大于3000元收20%的税
 */
class SalaryIncome implements Income {

    private double income;

    public SalaryIncome(double sum) {
        income = sum;
    }

    public double getTax() {
        return (income - 3000) * 0.2;
    }
}

/**
 * 稿费收入税率是20%
 */

class RoyaltyIncome implements Income {
    private double income;

    public RoyaltyIncome(double sum) {
        income = sum;
    }

    public double getTax() {
        return income * 0.2;
    }
}

