public class MinStepToReachOne {

    MinStepToReachOne(int N ){
        // given N
        // three operation  N/3 , N/2 , or -1 (one of operation )
        //can be performed K times to reach 1
        // give me minimum number of K
        System.out.println("Min Step to reach "+ N +" : "+minStep(N));


    }

    public  int minStep( Integer n)
    {

        // f(n) --> Min (f(n-1) , f(n/2) , f(n/3)) + 1
        // bottom up dp
        // for i : (1,n) dp[i] = dp[n-1]+1, dp[n/2] {n%2==0) , dp[n/3] {n%3 ==0}
        // dp [i] min number of step to reach val i :

        int [] dp = new int[n+1];

        dp[1] = 0;
        for(int i=2;i<=n;i++)
        {
            dp[i] = dp[i-1]+1;
            if(i%2==0)dp[i]= Math.min(dp[i],dp[i/2]+1);
            if(i%3==0)dp[i] = Math.min(dp[i],dp[i/3]+1);

        }
        return dp[n];
    }

    public  int minStepSpaceOpt( Integer n)
    {

        // f(n) --> Min (f(n-1) , f(n/2) , f(n/3)) + 1
        // bottom up dp
        // for i : (1,n) dp[i] = dp[n-1]+1, dp[n/2] {n%2==0) , dp[n/3] {n%3 ==0}
        // dp [i] min number of step to reach val i :

        int [] dp = new int[n+1];

        dp[1] = 0;
        for(int i=2;i<=n;i++)
        {
            dp[i] = dp[i-1]+1;
            if(i%2==0)dp[i]= Math.min(dp[i],dp[i/2]+1);
            if(i%3==0)dp[i] = Math.min(dp[i],dp[i/3]+1);

        }
        return dp[n];
    }

}

