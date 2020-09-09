

/*
 * Java的数据结构:
 * 
 * 枚举
 * 集合
 * 向量
 * 栈
 * 字典
 * 哈希表
 * 属性
 * Collection
 * */

/* 枚举:   --->enum
 *  Enumeration <type> Name;
 * 
 *  .hasMoreElements()
 *  .nextElement()
 * */
/*
import java.util.Vector;
import java.util.Enumeration;


public class Main {
   public static void main(String args[]) {
      Enumeration<String> days;
      Vector<String> dayNames = new Vector<String>();
      dayNames.add("Sunday");
      dayNames.add("Monday");
      dayNames.add("Tuesday");
      dayNames.add("Wednesday");
      dayNames.add("Thursday");
      dayNames.add("Friday");
      dayNames.add("Saturday");
      days = dayNames.elements();

      while (days.hasMoreElements()){
         System.out.println(days.nextElement()); 
      }
   }
}
*/


/*
 * BitSet
 * 
 * 常见的应用场景是对海量数据进行一些统计工作，比如日志分析、用户数统计等。
 * BitSet()
 * BitSet(int size)
 * 
 * .and(set)
 * .andNot(set)
 * .or(set)
 * .xor(set)
 * */


/*
import java.util.BitSet;

public class Main {
 
  public static void main(String args[]) {
     BitSet bits1 = new BitSet(16);
     BitSet bits2 = new BitSet(16);
      
     // set some bits
     for(int i=0; i<16; i++) {
        if((i%2) == 0) bits1.set(i);
        if((i%5) != 0) bits2.set(i);
     }
     System.out.println("Initial pattern in bits1: ");
     System.out.println(bits1);
     System.out.println("\nInitial pattern in bits2: ");
     System.out.println(bits2);
 
     // AND bits  
     bits2.and(bits1);
     System.out.println("\nbits2 AND bits1: ");
     System.out.println(bits2);
     System.out.println(bits1);
 
     // OR bits   
//     bits2.or(bits1);
     bits1.or(bits2);
     System.out.println("\nbits2 OR bits1: ");
     System.out.println(bits2);
     System.out.println(bits1);
 
     // XOR bits 
     bits2.xor(bits1);
     System.out.println("\nbits2 XOR bits1: ");
     System.out.println(bits2);
     System.out.println(bits1);
  }
}
*/



/*
 * 向量:
 * 
 * 使用第①种方式系统会自动对向量进行管理。
 * Vector()
 * 
 * 使用第②种方式，会创建一个初始容量（即向量可存储数据的大小）为 initialCapacity 的空向量，当真正存放的数据超过该容量时，系统会自动扩充容量，每次增加一倍。
 * Vector(int size)
 * 
 * 使用第③中方式，会创建一个初始容量为 initialCapacity 的空向量，当真正存放的数据超过该容量时，系统每次会自动扩充 capacityIncrement。如果 capacityIncrement 为0，那么每次增加一倍，。
 * Vector(int size,int incr)
 * 
 * Vector(Collection c)
 * */

/*
import java.util.*;
public class Main {

   public static void main(String args[]) {
      // initial size is 3, increment is 2
      Vector v = new Vector(3, 2);
      
      System.out.println("Initial size: " + v.size());
      System.out.println("Initial capacity: " + v.capacity());
      v.addElement(new Integer(1));
      v.addElement(new Integer(2));
      v.addElement(new Integer(3));
      v.addElement(new Integer(4));
      System.out.println("Capacity after four additions: " 
      + v.capacity());
      
      v.addElement(new Double(5.45));
      System.out.println("Current capacity1: " +
      v.capacity());
      v.addElement(new Double(6.08));
      System.out.println("Current capacity2: " +
              v.capacity());
      v.addElement(new Integer(7));
      System.out.println("Current capacity3: " +
      v.capacity());
      v.addElement(new Float(9.4));
      System.out.println("Current capacity4: " +
              v.capacity());
      v.addElement(new Integer(10));
      System.out.println("Current capacity5: " +
      v.capacity());
      v.addElement(new Integer(11));
      v.addElement(new Integer(12));
      System.out.println("First element: " +
         (Integer)v.firstElement());
      System.out.println("Last element: " +
         (Integer)v.lastElement());
      if(v.contains(new Integer(3)))
         System.out.println("Vector contains 3.");
      // enumerate the elements in the vector.
      Enumeration vEnum = v.elements();
      System.out.println("\nElements in vector:");
      while(vEnum.hasMoreElements())
         System.out.print(vEnum.nextElement() + " ");
      System.out.println();
   }
}
*/


/* stack  ---> 堆
 *  后入先出
 * .push()
 * .pop()
 */

/*
import java.util.*;

public class Main {
 
    static void showpush(Stack<Integer> st, int a) {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }
 
    static void showpop(Stack<Integer> st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }
 
    public static void main(String args[]) {
        Stack<Integer> st = new Stack<Integer>();
        System.out.println("stack: " + st);
        showpush(st, 42);
        showpush(st, 66);
        showpush(st, 99);
        showpop(st);
        showpop(st);
        showpop(st);
        try {
            showpop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }
}
*/


/*
 * 字典  
 * Dictionary类已经过时了，--->改用 Map
 * 
 * HashMap
 * .put(key, value)
 * .remove(key)
 * .get(key)
 * */

/*
import java.util.*;

public class Main {

   public static void main(String[] args) {
      Map m1 = new HashMap(); 
      m1.put("Zara", "8");
      m1.put("Mahnaz", "31");
      m1.put("Ayan", "12");
      m1.put("Daisy", "14");
      m1.put("Daisy", "17");
      m1.remove("Zara");
      System.out.println(m1.get("Zara"));
      System.out.println(" Map Elements:");
      System.out.print("\n" + m1);
   }
}
*/



/*
 * 哈希表:
 * Hashtable:
 * 
 * 和HashMap类很相似，但是它支持同步
 * Hashtable()
 * Hashtable(int size)
 * Hashtable(int size,float fillRatio)
 * Hashtable(Map m)
 * 
 * .put(key, value)
 * .get(key)  ---> value
 * */

/*
import java.util.*;

public class Main {

   public static void main(String args[]) {
      // Create a hash map
      Hashtable balance = new Hashtable();
      Enumeration names;
      String str;
      double bal;

      balance.put("Zara", new Double(3434.34));
      balance.put("Mahnaz", new Double(123.22));
      balance.put("Ayan", new Double(1378.00));
      balance.put("Daisy", new Double(99.22));
      balance.put("Qadir", new Double(-19.08));

      // Show all balances in hash table.
      names = balance.keys();
      while(names.hasMoreElements()) {
         str = (String) names.nextElement();
         System.out.println(str + ": " +
         balance.get(str));
      }
      System.out.println("\n");
      
      // 更改value
      bal = ((Double)balance.get("Zara")).doubleValue();
      System.out.println("bal: " + bal);
      balance.put("Zara", new Double(bal+1000));
      System.out.println("Zara's new balance: " +
      balance.get("Zara"));
   }
}
*/


/*
 * Properties
 * 
 * 继承自Hashtable
 * .put(key, value)
 * .setProperty(key, value)
 * .getProperty(key, defaultValue)
 * */

/*
import java.util.*;

public class Main {
 
   public static void main(String args[]) {
      Properties capitals = new Properties();
      Set states;
      String str;
      
      capitals.put("Illinois", "Springfield");
      capitals.put("Missouri", "Jefferson City");
      capitals.put("Washington", "Olympia");
      capitals.put("California", "Sacramento");
      capitals.put("Indiana", "Indianapolis");
      
      System.out.println(capitals + "\n");
 
      // Show all states and capitals in hashtable.
      states = capitals.keySet(); 
      Iterator itr = states.iterator();
      while(itr.hasNext()) {
         str = (String) itr.next();
         System.out.println("The capital of " +
            str + " is " + capitals.getProperty(str) + ".");
      }
      System.out.println();
 
      // look for state not in list -- specify default
      str = capitals.getProperty("Indiana", "Not Found");
      System.out.println("The capital of Florida is "
          + str + ".");
   }
}
*/

/*
 * 数据结构作业小结： 
 * 1.栈内存和堆内存的区别？
 * 2.内存划分为那些区？
 * 3.向量和数组的区别？
 * 4.取1-100内的随机整数100次，然后输出没有被取到的整数Bitset
 * */

/*
 * 
 * 
 1题：
 栈：存放局部变量，由系统分配，先进后出，更新速度快，存放变量生命周期结束，立即被释放。
 堆：存放对象，由程序员分配，先进先出，更新速度慢，没有引用的时候，会被系统内存回收机制不定时回收。
 
 2题：
 寄存器；栈内存；堆内存；本地方法区（Native方法服务）；方法区（类信息，静态常量方法）；非RAM存储；
 
 3题：
https://blog.csdn.net/qq_37723158/article/details/79024838
向量和数组相似，都可以保存一组数据（数据列表）。

a.向量的容量是可变的; 数组不可变。
b.向量的任意位置可以插入不同类型的对象，无需考虑对象的类型，而数组是同一类型。
c.向量作为一种对象提供了比数组更多的方法。
d.向量只能存储对象，不能直接存储简单数据类型，而数组可以。

 4题：
 
import java.util.BitSet;
public class Main{
    public static void main(String args[]) {
        BitSet numBit = new BitSet(100);
        BitSet randomBit = new BitSet(100);
        for(int i=0; i<100;i++ ) {
            numBit.set(i+1);
            randomBit.set((int)(Math.random()*100 + 1));    
        }
        System.out.println(numBit);
        System.out.println(randomBit);
        numBit.andNot(randomBit);
        System.out.println("100内没有被取到的整数有：\n"+numBit);
    }
}
  * */

