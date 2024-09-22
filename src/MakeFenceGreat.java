import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MakeFenceGreat {


    private static long solve(int n, List<int[]> fence) {
        if(n==1)return 0;
        long [][] dp = new long[n+1][4];
        for(long k=0;k<=2;k++)dp[1][(int)k]=  fence.get(0)[1]*k;
        long ans = Long.MAX_VALUE;

        for(int i=2;i<=n;i++)
        {
            HashMap<Integer,Long> mp = new HashMap<>();
            for(int l=0;l<=2;l++)
            {
                mp.put(fence.get(i -2)[0]+ l, dp[i -1][l]);
            }

            for(int k=0;k<=2;k++)
            {

                int curval = fence.get(i-1)[0] +k ;
                int cost = fence.get(i-1)[1]*k;
                dp[i][k]=Long.MAX_VALUE;
                for(Integer x : mp.keySet())
                {
                    if(curval !=x)
                    {
                        dp[i][k]= Math.min(dp[i][k],mp.get(x)+cost);
                        if(i==n)ans=Math.min(ans,dp[i][k]);
                    }
                }



            }

        }



        return ans;
    }



    public static void main(String[] args) {

        FastReader sc = new FastReader();
        int t = sc.nextInt();
        List<Long>ans = new ArrayList<>();
        while(t-- > 0)
        {
            int n;
            n = sc.nextInt();
            List<int[] > fence = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();int b= sc.nextInt();
                fence.add(new int[]{a,b});

            }
            ans.add(solve(n,fence));

        }
        ans.stream().forEach(System.out::println);
    }


    static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}



