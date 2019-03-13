package Prac_3;

/**
 * Created by yuding on 12/17/17.
 * GoldBach 猜想
 * Every even int greater than 2 can be expressed as the sum of
 * two primes
 */
public class GoldBach {
    public void check(){
        for(int i = 4;  i < 1000000; i+= 2){
            if(!checkEvenNumber(i)){
                System.out.println("Con!");
                break;
            }
            if(i % 10000 == 0){
                System.out.println("Holds <=" + i);
            }
        }
    }

    // mem this!!!
    // To check if a number a is prime
    // for i from 2 to sqrt(a),
    // if n is not divisible by all i, then it's a prime!
    private boolean isPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    // check if n can be express as the sum of i and n - i
    // Noticed only need to check to n / 2
    private boolean checkEvenNumber(int n){
        for(int i = 2; i <= n / 2; i++){
            if(isPrime(i) && isPrime(n - i)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GoldBach gb = new GoldBach();
        gb.check();
    }
}
