package hackerrank.interviewpk.strings;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

/*
* Two strings, A and B, are called anagrams if they contain all the same characters in the same frequencies. For this
* challenge, the test is not case-sensitive. For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.
https://www.hackerrank.com/challenges/java-anagrams/problem?isFullScreen=true
 *
* */
public class JavaAnagrams {



    public static boolean areAnagram(String a, String b){
        if (a.length() != b.length())
            return false;
        if (a.length() <= 1)
            return a.equalsIgnoreCase(b);
        char[] a2 = a.toLowerCase().toCharArray();
        char[] b2 = b.toLowerCase().toCharArray();
        Arrays.sort(a2);
        Arrays.sort(b2);

        return Arrays.equals(a2, b2);
    }

    @Test
    void test1(){
        Assert.assertTrue(areAnagram("anagram", "margana"));
    }

    @Test
    void test2(){
        Assert.assertFalse(areAnagram("anagramm", "marganaa"));
    }

    @Test
    void test3(){
        Assert.assertTrue(areAnagram("Hello", "hello"));
    }

    @Test
    void test4(){
        Assert.assertFalse(areAnagram("anagramm", "anagramgg"));
    }

    @Test
    void test5(){
        Assert.assertTrue(areAnagram("a","a"));
    }

    @Test
    void test6(){
        Assert.assertFalse(areAnagram("a","b"));
    }
}
