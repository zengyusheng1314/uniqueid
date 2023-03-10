package com.sean.uniqueid.generator.impl;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author zengyusheng
 * @date 2023/3/9 17:08
 */

public class RandomIdGeneratorTest {

//    @Test
//    public void testGetLastSubstrSplitByDot() {
//        RandomIdGenerator idGenerator = new RandomIdGenerator();
//        String actualSubstr = idGenerator.getLastSubstrSplitByDot("field1.field2.field3");
//        Assert.assertEquals("field3", actualSubstr);
//
//        actualSubstr = idGenerator.getLastSubstrSplitByDot("field1");
//        Assert.assertEquals("field1", actualSubstr);
//
//        actualSubstr = idGenerator.getLastSubstrSplitByDot("field1#field2#field3");
//        Assert.assertEquals("field1#field2#field3", actualSubstr);
//    }
//
//    @Test
//    public void testGetLastSubstrSplitByDot_nullOrEmpty() {
//        RandomIdGenerator idGenerator = new RandomIdGenerator();
//        String actualSubstr = idGenerator.getLastSubstrSplitByDot(null);
//        Assert.assertNull(actualSubstr);
//
//        actualSubstr = idGenerator.getLastSubstrSplitByDot("");
//        Assert.assertEquals("", actualSubstr);
//    }
//
//    @Test
//    public void testGenerateRandomAlphameric() {
//        RandomIdGenerator idGenerator = new RandomIdGenerator();
//        String actualRandomString = idGenerator.generateRandomAlphameric(6);
//        Assert.assertNotNull(actualRandomString);
//        Assert.assertEquals(6, actualRandomString.length());
//        for (char c : actualRandomString.toCharArray()) {
//            Assert.assertTrue(('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z'));
//        }
//    }
//
//    @Test
//    public void testGenerateRandomAlphameric_lengthEqualsOrLessThanZero() {
//        RandomIdGenerator idGenerator = new RandomIdGenerator();
//        String actualRandomString = idGenerator.generateRandomAlphameric(0);
//        Assert.assertEquals("", actualRandomString);
//
//        actualRandomString = idGenerator.generateRandomAlphameric(-1);
//        Assert.assertNull(actualRandomString);
//    }
}