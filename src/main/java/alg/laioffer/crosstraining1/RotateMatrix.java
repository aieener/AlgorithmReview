package alg.laioffer.crosstraining1;

public class RotateMatrix {
  public void rotate(int[][] matrix) {
    int N = matrix.length;
    if(N < 1 ) return;
    for(int level = 0; level < N / 2 ; level++) {
      int left = level;
      int right = N - 2 - level; // as level gets innerside the square size shrink by level
      for(int i = left; i <= right; i++) {
        int tmp = matrix[left][i];
        matrix[left][i] = matrix[N - i -1][left];
        matrix[N - i - 1][left] = matrix[N - 1 - left][N - 1 - i];
        matrix[N - 1 - left][N - 1 - i] = matrix[i][N - 1 - left];
        matrix[i][N - 1 - left] = tmp;
      }
    }
  }
}
