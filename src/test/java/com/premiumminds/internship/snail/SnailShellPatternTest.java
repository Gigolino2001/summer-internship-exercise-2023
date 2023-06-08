package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  };

  @Test
  public void ScreenLockinPatternEmptyMatrixTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {{}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {};
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternSingletonMatrixTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {{1}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {1};
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternOddLargeMatrixTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {
        { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        { 10, 11, 12, 13, 14, 15, 16, 17, 18 },
        { 19, 20, 21, 22, 23, 24, 25, 26, 27 },
        { 28, 29, 30, 31, 32, 33, 34, 35, 36 },
        { 37, 38, 39, 40, 41, 42, 43, 44, 45 },
        { 46, 47, 48, 49, 50, 51, 52, 53, 54 },
        { 55, 56, 57, 58, 59, 60, 61, 62, 63 },
        { 64, 65, 66, 67, 68, 69, 70, 71, 72 },
        { 73, 74, 75, 76, 77, 78, 79, 80, 81 }
    };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {
        1, 2, 3, 4, 5, 6, 7, 8, 9,
        18, 27, 36, 45, 54, 63, 72, 81, 80,
        79, 78, 77, 76, 75, 74, 73, 64, 55,
        46, 37, 28, 19, 10, 11, 12, 13, 14,
        15, 16, 17, 26, 35, 44, 53, 62, 71,
        70, 69, 68, 67, 66, 65, 56, 47, 38,
        29, 20, 21, 22, 23, 24, 25, 34, 43,
        52, 61, 60, 59, 58, 57, 48, 39, 30,
        31, 32, 33, 42, 51, 50, 49, 40, 41
    };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternEvenLargeMatrixTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {
        { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
        { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
        { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 },
        { 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 },
        { 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 },
        { 51, 52, 53, 54, 55, 56, 57, 58, 59, 60 },
        { 61, 62, 63, 64, 65, 66, 67, 68, 69, 70 },
        { 71, 72, 73, 74, 75, 76, 77, 78, 79, 80 },
        { 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 },
        { 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 }
    };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        20, 30, 40, 50, 60, 70, 80, 90, 100,
        99, 98, 97, 96, 95, 94, 93, 92, 91,
        81, 71, 61, 51, 41, 31, 21, 11, 12,
        13, 14, 15, 16, 17, 18, 19, 29, 39,
        49, 59, 69, 79, 89, 88, 87, 86, 85,
        84, 83, 82, 72, 62, 52, 42, 32, 22,
        23, 24, 25, 26, 27, 28, 38, 48, 58,
        68, 78, 77, 76, 75, 74, 73, 63, 53,
        43, 33, 34, 35, 36, 37, 47, 57, 67,
        66, 65, 64, 54, 44, 45, 46, 56, 55
    };
    assertArrayEquals(result, expected);
  }
}