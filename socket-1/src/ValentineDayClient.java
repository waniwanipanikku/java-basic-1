import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class ValentineDayClient {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            

            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            System.out.println("贈り物を送ります");
            
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while(true){
            System.out.println("メッセージを入力してください(例:ハッピーヴァレンタイン！) ↓");
            String message = scanner.next();
            if (message.equalsIgnoreCase("exit")) {
                break; // "exit"と入力された場合はループを抜けて終了
            }
            System.out.println("プレゼントの内容を入力してください(例:チョコ) ↓");
            String content = scanner.next();
            

            ValentineDay present = new ValentineDay();
            present.setMessage(message);
            present.setContent(content);

            oos.writeObject(present);
            oos.flush();

            

            ValentineDay okaeshiPresent = (ValentineDay) ois.readObject();

            String replayMsg = okaeshiPresent.getMessage();
            System.out.println("サーバからのメッセージは" + replayMsg);
            //String replayContent = okaeshiPresent.getContent();
            //System.out.println(replayContent + "をもらいました！");
            }
            scanner.close();
            ois.close();
            oos.close();
            socket.close();
            
        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
