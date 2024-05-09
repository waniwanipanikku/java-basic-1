import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyExceptionHoliday {

	public static void main(String[] args) {

		MyExceptionHoliday myE=new MyExceptionHoliday();

	}

	MyExceptionHoliday(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader というのは、データ読み込みのクラス(型)
		// クラスの変数を作るには、new を使う。

		// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
		//  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
		while(true){
        try {
			System.out.println("何日ですか?");
			String line = reader.readLine();
			int theday = Integer.parseInt(line);
			System.out.println("日付" + theday + "日ですね。");

			test(theday);
            System.out.println(theday+"日は休日または土日です");
            System.out.print("\n");
        

		}
		catch(IOException e) {
			System.out.println(e);
		} catch (NoHolidayException e) {
			e.printStackTrace();
		}
    }
	}

	void test(int theday) throws NoHolidayException{
        if(theday<1||theday>31){
            throw new IllegalArgumentException("1から31までの日付を入力してください。");
        }
        int dayOFWeek=(theday+2)%7;
		if(theday==3||theday==6||dayOFWeek==0||dayOFWeek==6){
			return;
		}else{
            throw new NoHolidayException();
        }
	}

}
