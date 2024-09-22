import java.util.Scanner;

public class PartitionArrayMaxSum {

    int [] arr = new int[]{1,15,7,9,2,5,10};
    int k = 2;

    public  static int maxSumAfterPartitioning(int[] arr, int K) {
        int n = arr.length;

        int [][]dp = new int[K+1][n+1]; // dp[k][n] --> max sum possilble if i make Kth partion at index n

        int[][]maxi= new int[n+1][n+1];

        for(int i=0;i<n;i++)
        {
            int curMax= arr[i];
            for(int j=i;j<n;j++)
            {
                curMax=Math.max(curMax,arr[j]);
                maxi[i][j]= curMax;
            }
        }

        for(int k=1;k<=K;k++)
        {
            int mxConst =0;
            for(int j=1;j<=n;j++)
            {
                mxConst = Math.max(mxConst, dp[j-1][k-1] * maxi[0][3]);
                //dp[j][k] = dp[1...j-1][k-1]
            }
        }

        return 1;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

    }
}
