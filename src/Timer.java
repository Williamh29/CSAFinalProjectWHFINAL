public class Timer implements Runnable{
    public static Integer seconds = 40;

    @Override
    public void run() {
        for(int i = seconds; i>0; i--){
            try {
                System.out.println(seconds);
                Thread.sleep(1000);
                seconds--;
                ClickColors.setScore();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(seconds);
        ClickColors.gameOver();
    }
}