package hackerrank.algorithms.strings;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/*
 https://www.hackerrank.com/challenges/game-of-thrones/problem
*/
public class GameOfThronesI {

    public static String gameOfThrones(String s) {
        AtomicInteger odds = new AtomicInteger();
        List<Character> chars = s.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        chars.stream().distinct().collect(Collectors.toList()).forEach(c -> {
            if (chars.stream().filter(i -> i.equals(c)).collect(Collectors.toList()).size() % 2 > 0)
                odds.getAndIncrement();
        });
        return odds.get() > 1 ? "NO" : "YES";
    }

    @Test
    void test1(){
        Assert.assertEquals(gameOfThrones("aaabbbb"), "YES" );
    }

    @Test
    void test2(){
        Assert.assertEquals(gameOfThrones("cdefghmnopqrstuvw"), "NO" );
    }

    @Test
    void test3(){
        Assert.assertEquals(gameOfThrones("cdcdcdcdeeeef"), "YES" );
    }
}
