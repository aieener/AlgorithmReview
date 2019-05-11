package alg.laioffer.prac3;

/**
 * Created by yuding on 12/17/17.
 * Fermat 大定理
 * no three possible int a, b, c holds a^n + b^n = c^n
 * for any int val n greater than 2
 */
public class FermatLast {
    private static final int LIMIT  = 1000;
    public void check(int n){
        for(int i = 1; i < LIMIT; i++) {
            for(int j = 1; j < LIMIT; j++) {
                if(check(n, i, j)){
                    System.out.println("Con!");
                    return;
                }
            }
        }
        System.out.println("Proved!" );
    }

    // keep in mind that set helper method's visibility to private
    private boolean check(int n , int a, int b){
        long c = (long) Math.pow(Math.pow(a,n) + Math.pow(b,n), 1 / n) ;

        return Math.pow(c, n) == Math.pow(a,n) + Math.pow(b,n);

    }

    public static void main(String[] args) {
        FermatLast f = new FermatLast();
        f.check(3);
    }
}
