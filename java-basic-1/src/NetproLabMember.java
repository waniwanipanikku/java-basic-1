import java.util.Random;

public class NetproLabMember {

    public static void main(String[] args) {
        int years=15;
        int c=3;
        Random r=new Random();
        double total=1;
        int[][] m=new int[years][c];
        for(int i=0;i<years;i++){
            m[i][0]=110+(r.nextInt(20)-10);
            m[i][1]=m[i][0]*(20+i)/100;
            m[i][2]=10+(r.nextInt(6)-3);
            int men=m[i][0]-m[i][1];
            long cpsRatio = combination(m[i][0], m[i][2]);
            long menRatio = combination(men, m[i][2]);
            total*=(double)menRatio/cpsRatio;
        }
        System.out.println(total);
    }
    public static final long combination(final int n, int r) {
        long nu=1;
        long de=1;
        for(int i=0;i<r;i++){
            nu*=(n-i);
            de*=(i+1);
        }
        return nu/de;

    }
}
