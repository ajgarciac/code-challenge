package hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
    https://www.hackerrank.com/challenges/lisa-workbook/problem
 */
public class LisasWorkbook {

    public static void main(String[] args) {

    }

    public static int workbook(int n, int k, List<Integer> arr) {
        AtomicInteger page = new AtomicInteger();
        AtomicInteger specials = new AtomicInteger();
        arr.forEach(p -> {
            System.out.println(String.format("Problems: %d", p));
            int cp = p/k;
            int ip = 0;
            int fp = 0;
            for (int i = 1; i <= cp; i++){
                page.getAndIncrement();
                ip = fp + 1;
                fp = i*k;
                if (page.get() >= ip && page.get() <= fp){
                    specials.getAndIncrement();
                }
            }
            int fpp = p%k;
            if (fpp > 0){
                page.getAndIncrement();
                ip = fp + 1;
                fp = p;
                if (page.get() >= ip && page.get() <= fp){
                    specials.getAndIncrement();
                }
            }
        });
        return specials.get();
    }

    @Test
    void test1(){
        List<Integer> list = Arrays.asList(4,2);
        int k = 3;
        Assert.assertEquals(workbook(list.size(), k, list), 1 );
    }

    @Test
    void test2(){
        List<Integer> list = Arrays.asList(4, 2, 6, 1, 10);
        int k = 3;
        Assert.assertEquals(workbook(list.size(), k, list), 4 );
    }




}
