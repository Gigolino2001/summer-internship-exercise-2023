package com.premiumminds.internship.snail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(final int[][] matrix) {
    
    // If the matrix is null it is returned an empty list 
    final CompletableFuture<int[]> snails = new CompletableFuture<int[]>();
    if (matrix.length == 0 || matrix == null) {
      snails.complete(new int[0]);
      return snails;
    }


    ExecutorService executor = Executors.newSingleThreadExecutor();
    executor.submit(new Runnable() {
      @Override
      public void run() {

        // Initialize variables
        int rows = matrix.length, cols = matrix[0].length;
        int firstRow = 0, lastRow = rows - 1, firstCol = 0, lastCol = cols - 1;
        int size = rows * cols;
        int[] result = new int[size];
        int i = 0;

        // While exists cells to explore
        while(i < size){

          // Traverse the first row of the untraversed portion of the matrix
          for (int col = firstCol; col <= lastCol; col++) {
            result[i++] = matrix[firstRow][col];
          }
          
          // Update the index of the first row of the untraversed portion of the matrix
          firstRow++;

          // Traverse the last column of the untraversed portion of the matrix
          for (int row = firstRow; row <= lastRow; row++) {
            result[i++] = matrix[row][lastCol];
          }

          // Update the index of the last column of the untraversed portion of the matrix
          lastCol--;
          
          // Check if there are still unexplored cells remaining
          if (i < size){

            // Traverse the last row of the untraversed portion of the matrix
            for (int col = lastCol; col >= firstCol; col--) {
              result[i++] = matrix[lastRow][col];
            }
            
            // Update the index of the last row of the untraversed portion of the matrix
            lastRow--;

            // Traverse the first column of the untraversed portion of the matrix
            for (int row = lastRow; row >= firstRow; row--) {
              result[i++] = matrix[row][firstCol];
            }

            // Update the index of the first column of the untraversed portion of the matrix
            firstCol++;
          }
        }
        
        snails.complete(result);
      }
    
    });

    executor.shutdown();
    return snails;

  }
}
