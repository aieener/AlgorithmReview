package CIT_596.HW9;

import java.util.ArrayList;
import java.util.List;

public class CheckIsPrime {
    public boolean isPrime(long n){
        for(long i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIsPrime cp = new CheckIsPrime();
        long [] targets = new long[] {7, 97,997, 8831,
                104743, 15485867,179424691, 32416187567L,100123456789L, 101012345678989L,
                1000000000100011L, 10000000002065383L, 100109100129100151L, 1023456987896543201L };

        List<Double> res = new ArrayList<>();
        List<Integer> len = new ArrayList<>();

        long startTime;
        long endTime;
        double runTime = 0;
        for(Long i : targets) {
            startTime = System.nanoTime();
            cp.isPrime(i);
            endTime = System.nanoTime();
            runTime = (endTime - startTime)/ 1000000.0 ;
            res.add(runTime);
            len.add(i.toString().length());
        }
        System.out.println(res);
        System.out.println(len);
    }
}
