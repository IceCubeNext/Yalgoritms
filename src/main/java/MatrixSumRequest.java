import java.io.*;

public class MatrixSumRequest {
    public void sum() throws IOException{
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String[] parameters = br.readLine().split(" ");
        int N = Integer.parseInt(parameters[0]);
        int M = Integer.parseInt(parameters[1]);
        int requestAmount = Integer.parseInt(parameters[2]);
        int[][] matrix = new int[N][M];
        int[][] preSums = new int[N][M];
        for (int i = 0; i < N; i++ ) {
            String[] values = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
                if (i == 0 && j == 0) {
                    preSums[i][j] = matrix[i][j];
                }else if(i == 0) {
                    preSums[i][j] = preSums[0][j - 1] + matrix[i][j];
                } else if (j == 0) {
                    preSums[i][j] = preSums[i - 1][0] + matrix[i][j];
                } else {
                    preSums[i][j] = preSums[i - 1][j] + preSums[i][j - 1] - preSums[i - 1][j - 1] + matrix[i][j];
                }
            }
        }
        for(int k = 0; k < requestAmount; k++) {
            String[] coordinates = br.readLine().split(" ");
            int x1 = Integer.parseInt(coordinates[0]) -1;
            int y1 = Integer.parseInt(coordinates[1]) -1;
            int x2 = Integer.parseInt(coordinates[2]) -1;
            int y2 = Integer.parseInt(coordinates[3]) -1;
            long sum = preSums[x2][y2]
                    - (x1 > 0 ? preSums[x1 - 1][y2] : 0)
                    - (y1 > 0 ? preSums[x2][y1 - 1] : 0)
                    + (x1 > 0 && y1 > 0 ? preSums[x1 - 1][y1 - 1] : 0);
            System.out.println(sum);
        }

    }

}
