package Recursion;

public class countGoodNumbers {
    static final long mod = 1000000007;
    public int CountGoodNumbers(long n) {

        long even = (n + 1)/2;
        long odd = n/2;

        long first = power(5, even);
        long second = power(4, odd);

        return (int)((first*second) % mod);
    }

    private long power(long x, long n) {
        if (n == 0) return 1;

        long half = power(x, n/2);

        if(n % 2 == 0) {
            return (half * half) % mod;
        }else {
            return (half * half % mod * x) % mod;
        }
    }
}
