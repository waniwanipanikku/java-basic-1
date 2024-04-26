// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {

	public static void main(String[] args) { 

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// BufferedReader というのは、データ読み込みのクラス(型)
			// クラスの変数を作るには、new を使う。

			// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
			//  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
        
            
        
		try {
            while(true){
			System.out.println("何歳ですか?");
			String line = reader.readLine();
            if(line.equals("q")||line.equals("e")){
                System.out.println("終了します");
                break;
            }
			int age = Integer.parseInt(line);
            if(age<0||age>=120){
                System.out.println("正しい年齢を入力してください");

            }else{
			System.out.println("あなたは" + age + "歳ですね。");
			System.out.println("2030年のあなたの年齢は" + (age + 6) + "歳ですね。");
            int c =2023-age;
            int d;
            if (c>=1868&c<=1911) {
                d=c-1867;
                System.out.println("あなたが誕生した元号は明治"+d+"年です");
            }else if (c>=1912&c<=1925) {
                d=c-1911;
                System.out.println("あなたが誕生した元号は大正"+d+"年です");
            }else if (c>=1926&c<=1988) {
                d=c-1925;
                System.out.println("あなたが誕生した元号は昭和"+d+"年です");
            }else if (c>=1989&c<=2018) {
                d=c-1988;
                
                System.out.println("あなたが誕生した元号は平成"+d+"年です");
            }else if (c>=2019&c<=2024) {
                d=c-2018;
                System.out.println("あなたが誕生した元号は令和"+d+"年です");
            }
        }
        }
		}
		catch(IOException e) {
			System.out.println(e);
		}
    


	}
}


