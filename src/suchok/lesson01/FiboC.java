package suchok.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

import java.util.ArrayList;

public class FiboC {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    static long fasterC(long n, long m) {
        long prev = 0;
        long curr = 1;
        long res = 0;
        boolean isCorrect = true;
        for (int i = 0; i < m * m; i++) {
            long temp = curr;
            curr = (prev + curr) % m;
            prev = temp;
            if (prev == 0 && curr == 1 ) {
                res = i + 1;
                break;
            }
        }
        long pisanoPeriod = res;
        n = n % pisanoPeriod;
        if (n == 0) return 0;
        else if (n == 1) return 1;
        for (int i = 0; i < n - 1; i++) {
            long temp = curr;
            curr = (prev + curr) % m;
            prev = temp;
        }
        return curr % m;
    }
}

