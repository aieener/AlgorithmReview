package CIT_596.HW2;

/**
 * Created by yuding on 1/31/18.
 */
public class QS {
    public int[] quickSort(int[] array){
        if(array == null || array.length == 0 ){
            return array;
        }
        qSort(array, 0, array.length - 1);
        return array;
    }

    // wrapper function
    public void qSort(int[] array, int start, int end){
        // base case
        if(start >= end){
            return;
        }

        int pivotPos = partition(array, start, end);
        qSort(array, start,pivotPos - 1);
        qSort(array, pivotPos + 1, end);
    }

    private int partition(int [] array, int start, int end){
        int pivotIndex = pivotIndex(start, end);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, end);

        int l = start;
        int r = end - 1;
        while( l <= r){ // here has to be l <= r since we want to ensure they accross
            if(array[l] < pivot){
                l++;
            } else if (array[r] > pivot){
                r--;
            } else {
                swap(array, l++, r--);
            }
        }

        swap(array, l, end);

        return l;
    }

    private int pivotIndex(int left, int right){
        // Math.random() --> (0, 1)
        return left + (int) (Math.random() * (right - left + 1));
    }

    private void swap(int [] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


    private int[] geneArray(int size) {
        int [] res = new int[size];
        for(int i = 0; i < size; i++) {
            int cur = -size + (int) (Math.random() * (2 * size));
            res[i] = cur;
        }
        return res;
    }

    public double calAve(int [] array){
        double [] duationList  = new double[10];
        double res = 0.0;
        for(int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();
            quickSort(array);
            long endTime = System.currentTimeMillis();
            res +=  (endTime - startTime) / 1000.0;
        }
        res = res / 10.0;
        return res;
    }

    public static void main(String[] args) {
        QS sol = new QS();
        int seed = 1000;
        for(int i = 0; i < 10; i++) {
            int [] array = sol.geneArray(seed);
            System.out.println(seed);
            System.out.println(sol.calAve(array));
            seed = 3 * seed;
        }
    }
}
