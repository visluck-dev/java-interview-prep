import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class TokenBucket {

    String bucketName;
    private final int capacity;
    private double fillRate;
    private TimeUnit fillRateUnit;
    private int availToken;
    private double lastFillTime;
    private long reFillTime;


    public TokenBucket(String bucketName, int capacity, int fillRate, TimeUnit fillRateUnit, int availToken) {
        bucketName = bucketName;
        this.capacity = capacity;
        this.fillRate = fillRate;
        this.availToken = availToken;
        this.fillRateUnit = fillRateUnit;
    }

    public boolean consumeToken()
    {
        if(availToken <=0)return false;
        this.availToken-=1;
        return true;
    }

   synchronized boolean getToken()
    {
        if(this.availToken > 1)
        {
            return consumeToken();
        }
        refill();
       return consumeToken();

    }


    synchronized void refill()
    {

         long time = System.nanoTime();
         long lastFilled = this.reFillTime;

         long timePassed = fillRateUnit.convert(time,TimeUnit.NANOSECONDS)-lastFilled;
         int tokenToAdd = (int) Math.floor( timePassed*fillRate);
         availToken=Math.max(capacity,tokenToAdd+availToken);

    }



}
