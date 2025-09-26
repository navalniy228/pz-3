package lab03;

public class Task4 {

    public static void main(String[] args) {
        printResults(2, 8, 5);   // допустиме
        printResults(1, 10, 30); // допустиме, межа k=30
        printResults(3, 5, 0);   // k=0, некоректне
        printResults(2, 4, 31);  // k=31, некоректне
        printResults(-1, 5, 10); // a<0, некоректне
    }

    public static double sumSeries(double a, double b, int k) {
        if (k <= 0 || k > 30) {
            throw new IllegalArgumentException("Invalid k=" + k);
        }
        if (a < 0 || b <= 0) {
            throw new IllegalArgumentException("Invalid parameters: a=" + a + ", b=" + b);
        }
        double sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += Math.sqrt(a * i) * Math.pow(b / i, 1.0 / b);
        }
        return sum;
    }

    static void printResults(double a, double b, int k) {
        System.out.print("a:" + a + " b:" + b + " k:" + k + " result:");
        try {
            System.out.println(sumSeries(a, b, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
package lab03;

public class Task10 {

    public static void main(String[] args) {
        printResults(-1, 5); // t<0
        printResults(0, 5);  // t=0
        printResults(4, 3);  // t>=0
        printResults(9, 0);  // n=0 (помилка)
        printResults(16, -2); // n<0 (помилка)
    }

    public static double xFunc(double t, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid n=" + n);
        }
        double sum = 0;
        if (t < 0) {
            for (int i = 1; i <= n; i++) {
                sum += Math.pow(i, 2) * i; // i^2 * i = i^3
            }
        } else {
            double sqrtT = Math.sqrt(t);
            for (int i = 1; i <= n; i++) {
                sum += sqrtT * i;
            }
        }
        return sum;
    }

    static void printResults(double t, int n) {
        System.out.print("t:" + t + " n:" + n + " result:");
        try {
            System.out.println(xFunc(t, n));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
package lab03;

public class Task11 {

    public static void main(String[] args) {
        printResults(0.1);
        printResults(0.01);
        printResults(0.0001);
        printResults(-0.5);  // помилка, ε<=0
        printResults(0);     // помилка, ε=0
    }

    public static double infiniteSum(double eps) {
        if (eps <= 0) {
            throw new IllegalArgumentException("Invalid epsilon=" + eps);
        }
        double sum = 0;
        for (int i = 1; ; i++) {
            double term = 1.0 / (i * i);
            if (term < eps) break;
            sum += term;
        }
        return sum;
    }

    static void printResults(double eps) {
        System.out.print("eps:" + eps + " result:");
        try {
            System.out.println(infiniteSum(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
