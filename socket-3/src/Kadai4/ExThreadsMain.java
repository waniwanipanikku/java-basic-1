package Kadai4;

public class ExThreadsMain {

    public static void main(String[] args) {
        //数字をカウントし出力
        Thread thread1 = new Thread(() -> {
            task1();
        });

        //アルファベットを出力
        Thread thread2 = new Thread(() -> {
            task2();
        });

        //現在時刻を出力
        Thread thread3 = new Thread(() -> {
            task3();
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void task1() {
        for (int i = 1; i <= 26; i++) {
            try {
                System.out.println("Count:" + i);
                Thread.sleep(500); // ミリ秒単位のスリープ時間
            } catch (InterruptedException e) {
                // スレッドが中断された場合は、例外を出力します。
                System.err.println(e);
            }
        }

    }

    public static void task2() {
        for (char i = 'A'; i <= 'Z'; i++) {
            try {
                System.out.println("Alphabet:" + i);
                Thread.sleep(500); // ミリ秒単位のスリープ時間
            } catch (InterruptedException e) {
                // スレッドが中断された場合は、例外を出力します。
                System.err.println(e);
            }
        }
    }

    public static void task3() {
        for(int i=1;i<=26;i++){
        try {
            System.out.println("Current Time: " + java.time.LocalTime.now());
            Thread.sleep(500); // ミリ秒単位のスリープ時間
        } catch (InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }}
    }
}
