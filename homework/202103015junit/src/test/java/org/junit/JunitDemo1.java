package org.junit;

//import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
    /*
    JUnit 所提供的断言方法:
    assertArrayEquals(expecteds, actuals)	查看两个数组是否相等。
    assertEquals(expected, actual)	查看两个对象是否相等。类似于字符串比较使用的equals()方法。
    assertNotEquals(first, second)	查看两个对象是否不相等。
    assertNull(object)	查看对象是否为空。
    assertNotNull(object)	查看对象是否不为空。
    assertSame(expected, actual)	查看两个对象的引用是否相等。类似于使用“==”比较两个对象。
    assertNotSame(unexpected, actual)	查看两个对象的引用是否不相等。类似于使用“!=”比较两个对象。
    assertTrue(condition)	查看运行结果是否为true。
    assertFalse(condition)	查看运行结果是否为false。
    assertThat(actual, matcher)	查看实际值是否满足指定的条件。
    fail()	让测试失败。
     */

public class JunitDemo1 {

    //assertEquals(expected, actual)查看两个对象是否相等。类似于字符串比较使用的equals()方法。
    @Test
    public void test1() {
        assertEquals(2 + 2, 4);
    }


    //assertArrayEquals(expecteds, actuals)	查看两个数组是否相等。
    int[] list1 = {1};
    int[] list2 = {1};

    @Test
    public void test2() {
        assertArrayEquals(list1, list2);
    }


    //assertNull(object) 查看对象是否为空
    String a = null;

    @Test
    public void test3() {
        assertNull(a);
    }

}
