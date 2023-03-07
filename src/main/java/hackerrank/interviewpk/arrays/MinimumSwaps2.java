package hackerrank.interviewpk.arrays;

import org.testng.Assert;
import org.testng.annotations.Test;
/*
    https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 */
public class MinimumSwaps2 {
    static int minimumSwaps(int[] arr) {
        int index = 0, temp = 0, moves = 0;
        while (index < arr.length){
            if (index+1 != arr[index]){
                temp = arr[index];
                arr[index] = arr[temp-1];
                arr[temp-1] = temp;
                moves++;
            }else{
                index++;
            }
        }
        return moves;
    }

    @Test
    void test1(){
        Assert.assertEquals(minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6}), 5 );
    }

    @Test
    void test2(){
        Assert.assertEquals(minimumSwaps(new int[]{4, 3, 1, 2}), 3 );
    }

    @Test
    void test3(){
        Assert.assertEquals(minimumSwaps(new int[]{2, 3, 4, 1, 5}), 3 );
    }

    @Test
    void test4(){
        Assert.assertEquals(minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7}), 3 );
    }
}
