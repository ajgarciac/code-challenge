package hackerrank.interviewpk.dictionarieshashmaps.hashtables;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

/*
 https://www.hackerrank.com/challenges/ctci-ransom-note/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */

public class RansomNote {

    public static void checkMagazine(List<String> magazine, List<String> note) {
        System.out.println(isPossible(magazine, note) ? "Yes" : "No");
    }

    public static boolean isPossible(List<String> magazine, List<String> note) {

        Map<String, Long> magazineCounts = magazine.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        Map<String, Long> noteCounts = note.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        for (String word : note.stream().distinct().collect(Collectors.toList())){
            if (!magazineCounts.containsKey(word))
                return false;
            if (noteCounts.get(word) > magazineCounts.get(word))
                return false;
        }
        return true;
    }

    @Test
    void test1(){
        List<String> magazine = Arrays.asList("attack at dawn".split(" "));
        List<String> note = Arrays.asList("Attack at dawn".split(" "));
        Assert.assertFalse(isPossible(magazine, note));
    }

    @Test
    void test2(){
        List<String> magazine = Arrays.asList("give me one grand today night".split(" "));
        List<String> note = Arrays.asList("give one grand today".split(" "));
        Assert.assertTrue(isPossible(magazine, note));
    }

    @Test
    void test3(){
        List<String> magazine = Arrays.asList("two times three is not four".split(" "));
        List<String> note = Arrays.asList("two times two is four".split(" "));
        Assert.assertFalse(isPossible(magazine, note));
    }

    @Test
    void test4(){
        List<String> magazine = Arrays.asList("ive got a lovely bunch of coconuts".split(" "));
        List<String> note = Arrays.asList("ive got some coconuts".split(" "));
        Assert.assertFalse(isPossible(magazine, note));
    }
}
