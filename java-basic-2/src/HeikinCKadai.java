import java.util.Random;

public class HeikinCKadai {
    public static void main(String[] args) {
    final int N =100;
    Kamoku[] students=new Kamoku[N];
    Random r =new Random();
            
    for(int i=0;i<N;i++){
            int score =r.nextInt(101);
            students[i]=new Kamoku(score);
    }
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=students[i].getScore();
        }
        double ave=(double)sum/N;
        System.out.println("平均点は"+ave+"です。");

        System.out.println("合格者一覧");
        for(int i=0;i<N;i++){
            if(students[i].getScore()>=80){
                System.out.println("学籍番号"+(i+1)+"の点数は"+students[i].getScore()+"点");
            }
        }
    }



}
