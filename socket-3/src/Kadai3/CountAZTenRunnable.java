package Kadai3;

public class CountAZTenRunnable implements Runnable {
    String myAlfabetstr = "noAlfabet";

    public static void main(String[] args) {
        CountAZTenRunnable[] cts = new CountAZTenRunnable[26];
        for (int i = 0; i < 25; i++) {
            cts[i] = new CountAZTenRunnable();
            String name = (char) (97 + i) + "_";
            cts[i].setAlfabet(name);

        }
        for (CountAZTenRunnable ct : cts) {
            new Thread(ct).start();
        }

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("main:i=" + i);

                Thread.sleep(500); // ミリ秒単位のスリープ時間
            }
        } catch (InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }

    private void setAlfabet(String alfabetstr) {
        myAlfabetstr = alfabetstr;
    }

    // run メソッドは、新しいスレッドが実行するコードを含みます。
    public void run() {
        // この try-catch ブロックは、0 から 9 までの値を 1000 ミリ秒間隔で出力するループを実行します。
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(myAlfabetstr + i);

                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(1000); // ミリ秒単位のスリープ時間
            }
        } catch (InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }
}
