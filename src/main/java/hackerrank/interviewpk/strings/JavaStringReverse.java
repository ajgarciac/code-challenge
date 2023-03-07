package hackerrank.interviewpk.strings;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
    https://www.hackerrank.com/challenges/java-string-reverse/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
public class JavaStringReverse {

    public static boolean isPalindrome(String str){
        if (str.length() == 1)
            return true;
        int l = 0;
        int r = str.length() -1;
        while (str.charAt(l) == str.charAt(r) && l <= r){
            l++;
            r--;
        }
        return l >= r;

    }

    @Test
    void test1(){
        Assert.assertTrue(isPalindrome("madam"));
    }

    @Test
    void test2(){
        Assert.assertFalse(isPalindrome("lorem"));
    }

    @Test
    void test3(){
        Assert.assertFalse(isPalindrome("java"));
    }

    @Test
    void test4(){
        Assert.assertTrue(isPalindrome("abcddcba"));
    }

    @Test
    void test5(){
        Assert.assertTrue(isPalindrome("b"));
    }
}
