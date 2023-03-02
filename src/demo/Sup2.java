package demo;

public class Sup2 implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<20;i--) {
            System.out.println("Sub2 " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}
