
一、选择题：(每道题5分，共35分，多选不得分，少选一个1分，全对5分)
1.BC，2.D 3.ABCD 4.BCD 5.AD 6.B 7.ABD
1.下列说法正确的有()
A.JRE为开发工具包，提供了开发环境和运行环境。
B.一个Java文件只能定义一个public类型的class，并且class名称和文件名要完全一致；
C.数组所有元素初始化为默认值，整型都是0，浮点型是0.0，布尔型是false;
D.String属于基本数据类型;

2.下列说法正确的有()
A.整数的除法对于除数为0时运行时将报错，编译也会报错。
B.浮点赋值语句，float f1 = 3.14; 不会报错。
C.short,char 大小都只有1个字节。
D.一般用单引号来表示字符，双引号来表示字符串。

3.下列说法正确的有()
A.用+连接字符串和其他数据类型，会将其他类型数据自动转换为字符类型.
B.用"""..."""表示多行字符串，是从java_13才开始支持的。
C.字符串的不可变是指字符串内容不可变。对字符串重新赋值，只是改变变量名的指向而已。
D.数组一旦创建后，大小就不可改变。

4.下列说法错误的有()
A.在类中，protected修饰的字段表示子类是可以访问的。
B.所有类继承自最原始的基类NSObject。
C.子类默认的构造方法是从父类继承的。
D.抽象类可以被实例化。

5.下列说法正确的有()
A.用final修饰的方法不能被Override。
B.用final修饰的类可以被继承。
C.用final修饰的类实例字段在初始化后可以被修改。
D.Override和Overload不同的是，一个是重写老方法，一个增加新方法。

6.下列关于接口，说法正确的有()
A.抽象类是可以被实例化的。
B.如果一个抽象类中没有字段，所有方法都是抽象方法，那么就可以定义为接口.
C.接口中添加default方法后，在类的实现中就必须写该方法的实现。
D.一个类只能继承自一个类，一个类也只能实现一个接口。

7.下列说法正确的有()
A.用static修饰的字段，称为静态字段.
B.静态字段并不属于实例,是所有实例都会共享该字段。
C.静态方法需要实例化.
D.静态方法经常用于工具类,也经常用于辅助方法



二、问答题:（共17分）
1. 基础数据类型有哪些？（2分）
基础类型有 8 种：byte、boolean、char、short、int、float、long、double

2. == 和 equals 的区别是什么？（2分）
== 用于基本类型：比较的是值是否相同；
euqals 用于引用类型：比较的是引用是否相同（若类中覆盖了equals(),一般是比较内容，具体以equals的实现为准）；

3. 抽象类能使用 final 修饰吗？（3分）
不能，定义抽象类就是让其他类继承的，如果定义为 final 该类就不能被继承，这样彼此就会产生矛盾，所以 final 不能修饰抽象类

4. 普通类和抽象类有哪些区别？（4分）
普通类不能包含抽象方法，抽象类可以包含抽象方法。
抽象类不能直接实例化，普通类可以直接实例化。

5. java操作字符串的都有哪些类？（2分）
String、StringBuffer、StringBuilder。

6.接口和抽象类有哪些区别？（4分）
a.一个类可以实现很多个接口，但是只能继承一个抽象类。
b.抽象类可以有构造函数；接口不能有。
c.抽象类不一定非要有抽象方法,而接口都是抽象方法。
d.接口中的方法默认使用 public 修饰；抽象类中的方法可以是任意访问修饰符。
e.抽象类可以有 main 方法，并且我们能运行它；接口不能有 main 方法
f.接口中的字段是public statc final类型，而抽象类中的字段可以随意修饰。


三、编程题：（每道题8分，共48分）
1.写程序,完成下列功能:
a.提示用户输入姓名，成绩
b.并用StringBuilder/StringJoiner拼接成字符串输出。
c.对输入成绩进行判断，分优，良，及格，差，并输出。

import java.util.Scanner;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {
        String name = getName();
        double score = getScore();
        String result = judgeScore(score);

//      * StringBuilder str = new StringBuilder();
//      * str.append("Hi " + name +", your score is " + score + ", " +result + "!");

        StringJoiner str = new StringJoiner(", ", "Hi ", "!");
        str.add(name).add("your score is " + score).add(result);
        System.out.println(str);
    }

    private static String getName() {
        String name = "";
        boolean flagName = true;
        System.out.println("请输入姓名：");
        while (flagName) {
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextLine()) {
                name = scan.nextLine();
                if (name.replaceAll(" ", "").length() != 0) {
                    flagName = false;
                } else {
                    System.out.println("输入姓名为空白, 请重新输入!");
                }
            } else {
                System.out.println("输入姓名为空，请重新输入！");
            }
        }
        return name;
    }

    private static float getScore() {
        float score = 0;
        boolean flagScore = true;
        System.out.println("请输入成绩：");
        while (flagScore) {
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextFloat()) {
                score = scan.nextFloat();
                if (score >= 0 && score <= 100) {
                    flagScore = false;
                } else {
                    System.out.println("输入成绩错误，请重新输入!");
                }
            } else {
                System.out.println("成绩格式错误，请重新输入!");
            }
        }
        return score;
    }

    private static String judgeScore(double score) {
        if (score >= 90) {
            return " 优";
        } else if (score >= 70) {
            return "良";
        } else if (score >= 60) {
            return "及格";
        } else {
            return "差";
        }
    }
}



2.程序题，跟电脑划拳，用户输入石头剪刀布后，然后打印输出谁赢了。


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("请选择对应序号:");
        System.out.println(" 1: 石头");
        System.out.println(" 2: 剪刀");
        System.out.println(" 3: 布");
        judgeChoice(getUserChoice(), getComputerChoice());
    }

    private static int getUserChoice() {
        boolean userChoiceFlag = true;
        int userChoice = 0;
        while (userChoiceFlag) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                if (userChoice < 1 || userChoice > 3) {
                    System.out.println("你不按常理出拳！请重新选择对应序号：");
                    continue;
                }
                userChoiceFlag = false;
            } else {
                System.out.println("输入为非整数！请重新选择对应序号：");
            }
        }
        return userChoice;
    }

    private static int getComputerChoice() {
        String[] arr = {"石头", "剪刀", "布"};
        int computerChoice = ((int) Math.random() * 3) + 1;
        System.out.println("电脑选择的序号为：" + computerChoice + " " + arr[computerChoice - 1]);
        return computerChoice;
    }

    private static void judgeChoice(int userChoice, int computerChoice) {
        switch (userChoice - computerChoice) {
            case -1:
            case 2:
                System.out.println("你赢了!");
                break;
            case 0:
                System.out.println("平局！");
                break;
            default:
                System.out.println("你输了！");
                break;

            /*JDK 14才支持*/
//          case -1, 2 -> System.out.println("你赢了!");
//          case 0 -> System.out.println("平局！");
//          default -> System.out.println("你输了！");
        }
    }
}


3.完成下列程序：

public class JoinChar {

    public static void main(String[] args) {
        // 请将下面一组int值视为字符的Unicode码，把它们拼成一个字符串，然后输出：：
        int a = 72;
        int b = 105;
        int c = 65281;
        // ToDo..
        String str = "" +(char)a + (char)b  + (char)c;
        
        // StringBuffer str = new StringBuffer();
        // str.append((char)a).append((char)b).append((char)c);
        System.out.println(str);
    }

}

4.完成下列程序：
public class Main {

    public static void main(String[] args) {
        // 完成setter,getter方法：
        Person hong = new Person();
        hong.setName("小红");
        hong.setAge(17);
        // 给setName()添加重载方法
        Person lei = new Person();
        lei.setName("李","雷");
        // 给Person增加两个构造方法:如果不输入年龄，则默认18岁，
        // 比如：李刚默认18岁
        Person gang = new Person("李刚");
        Person ming = new Person("小明", 12);

        System.out.println(hong.getName());
        System.out.println(lei.getName());
        System.out.println(gang.getAge());
        System.out.println(ming.getAge());
    }

}

class Person {

    private String name;
    private int age;

    // ToDo...
    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setName(String fistName, String lastName) {
        this.name = fistName + lastName;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected int getAge() {
        return age;
    }

    protected Person() {
    }

    protected Person(String name) {
        this(name, 18); // 调用另一个构造方法Person(String, int)
    }

    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


5.给Person类增加一个静态字段count和静态方法getCount，统计实例的个数

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person("小明");
        System.out.println(Person.getCount()); // 1
        Person p2 = new Person("小红");
        System.out.println(Person.getCount()); // 2
        Person p3 = new Person("小军");
        System.out.println(Person.getCount()); // 3
    }

}

class Person {
    protected String name;
    // ToDo...
    protected static int count;
    protected static int getCount() {
        return count;
    }
    public Person(String name) {
        this.name = name;
        count++;
    }
}


6.完成下列程序：


public class Main {

    public static void main(String[] args) {
        // TODO: 用接口给一个有工资收入和稿费收入的小伙伴算税:
        Income[] incomes = new Income[]{new SalaryIncome(7500), new RoyaltyIncome(12000)};
        double total = 0;
        // TODO:
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        System.out.println(total);
    }

}

/**
 * 定义接口Income
 */
interface Income {

    // TODO
    double getTax();

}


/**
 * 工资减去基数3000,大于3000元收20%的税
 */
class SalaryIncome implements Income {

    // TODO
    protected double income;

    public SalaryIncome(double income) {
        this.income = income;
    }

    @Override
    public double getTax() {
        return income > 3000 ? (income - 3000) * 0.2 : 0;
    }

}

/**
 * 稿费收入税率是20%
 */

class RoyaltyIncome implements Income {

    // TODO
    protected double income;

    public RoyaltyIncome(double income) {
        this.income = income;
    }

    @Override
    public double getTax() {
        return income * 0.2;
    }
}


