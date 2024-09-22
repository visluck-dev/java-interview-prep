public class ThreadTest
{

    public static   class ParllelRun extends Thread
    {
        @Override
        public void run()
        {
            System.out.println("hellO");
        }
    }

    public  static class ParallelRun2 implements Runnable{

        @Override
        public void run() {
            System.out.println("hello2");
        }
    }




    public static void main(String[] args) {

        ParllelRun p = new ParllelRun();
        p.start();

        ParallelRun2 p2= new ParallelRun2();
        Thread t = new Thread(p2);
        t.start();


    }
}
