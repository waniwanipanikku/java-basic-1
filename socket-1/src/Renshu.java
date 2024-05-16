class Renshu {

    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    public int sumUpToN(int x) {
        int sum = 0;
        for (int i = 1; i <= x; i++) {
            sum += i;
        }
        return sum;
    }

    public int sumFromPtoQ(int x, int y) {
        int sum = 0;
        if (x > y) {
            return -1;
        }
        for (int i = x; i <= y; i++) {
            sum += i;
        }
        return sum;
    }

    public int sumFromArrayIndex(int[] x, int y) {
        if (x.length <= y) {
            return -1;
        }
        int sum = 0;
        for (int i = y; i < x.length; i++) {
            sum += x[i];
        }
        return sum;

    }

    public int selectMaxValue(int[] x) {
        int max = x[1];
        for (int i = 0; i < x.length; i++) {
            if (x[i] > max) {
                max = x[i];
            }
        }
        return max;
    }

    public int selectMinValue(int[] x) {
        int min = x[1];
        for (int i = 0; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
            }
        }
        return min;
    }

    public int selectMaxIndex(int[] x) {
        int max = x[1];
        int maxIndex = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] > max) {
                max = x[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int selectMinIndex(int[] x) {
        int min = x[1];
        int minIndex = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    public void swapArrayElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    boolean swapTwoArrays(int[] a, int[] b){
        if (a.length != b.length) {
            return false; 
        }
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            a[i] = b[i];
            b[i] = temp;
        }
        return true; 
    }
    
    // ここに続きを実装していく。
}