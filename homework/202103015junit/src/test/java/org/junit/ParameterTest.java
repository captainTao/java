package org.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class ParameterTest {
    //@CsvFileSource允许您使用类路径中的CSV文件。CSV文件中的每一行都会调用一次参数化测试。
    @ParameterizedTest
    @CsvFileSource(resources = "/ADD.csv", numLinesToSkip = 1, delimiter = ',')
    //numLinesToSkip忽略几行，delimiter默认为','
    public void testCsvAdd(int a, int b, int c) {
        Count count = new Count();
        int result = count.add(a, b);
        assertEquals(result, c);
    }

    //@ValueSource –提供对文字值数组（即整数，字符串等）的访问。
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testNum(int a) {
        assertTrue(a > 0);
    }

    //@CsvSource允许将参数列表表示为逗号分隔的值
    @ParameterizedTest
    @CsvSource({"1,2", "5,5"})
    public void testSub(int a, int b) {
        Count count = new Count();
        int result = count.sub(a, b);
        assertEquals(result, 0);
    }
}
