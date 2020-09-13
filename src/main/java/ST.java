import java.util.Scanner;

public class ST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] d = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                d[i][j] = sc.nextInt();
            }
        }
        System.out.println(dfs(d));

    }

    public static int dfs(int[][] d){
        if(d == null) return -1;
        int row = d.length;
        int col = d[0].length;

        int[][] length = new int[row][col];

        boolean[][] visited = new boolean[row][col];
        length[0][0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                getM(d, length,visited, i, j);
            }
        }

        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(length[i][j] > max){
                    max = length[i][j];
                }
            }
        }
        return max;
    }

    public static int getM(int[][] d, int[][] len, boolean[][] v, int i, int j){
        if(v[i][j])
            return 0;
        v[i][j] = true;
        int r = d.length;
        int c = d[0].length;

        int max  =1;

        if(j>0 && d[i][j] < d[i][j-1]){
            if(v[i][j - 1] == false ){
                max = Math.max(max, getM(d, len, v, i, j - 1) + 1);
            }else{
                max = Math.max(max, len[i][j-1] + 1);
            }
        }

        if(i>0 && d[i][j] < d[i-1][j]){
            if(v[i-1][j] == false ){
                max = Math.max(max, getM(d, len, v, i-1, j) + 1);
            }else{
                max = Math.max(max, len[i-1][j] + 1);
            }
        }
        if(i < c -1  && d[i][j] < d[i][j+1]){
            if(v[i][j+1] == false ){
                max = Math.max(max, getM(d, len, v, i, j+1) + 1);
            }else{
                max = Math.max(max, len[i][j+1] + 1);
            }
        }

        if(i < r -1  && d[i][j] < d[i+1][j]){
            if(v[i+1][j] == false ){
                max = Math.max(max, getM(d, len, v, i+1, j) + 1);
            }else{
                max = Math.max(max, len[i+1][j] + 1);
            }
        }

        len[i][j] = max;
        return max;
    }


}