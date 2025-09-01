import java.math.BigInteger;
import java.util.*;

public class Main {
    static class Root {
        int base;
        String value;
        Root(int b, String v){ base=b; value=v; }
    }

    public static void main(String[] args) {
        // ---------- TEST CASE 1 ----------
        int n1 = 4, k1 = 3, m1 = k1 - 1;
        Root[] roots1 = {
            new Root(10,"4"),
            new Root(2,"111"),
            new Root(10,"12"),
            new Root(4,"213")
        };
        System.out.println("=== Test Case 1 ===");
        solve(n1, m1, roots1);

        // ---------- TEST CASE 2 ----------
        int n2 = 10, k2 = 7, m2 = k2 - 1;
        Root[] roots2 = {
            new Root(6,"13444211440455345511"),
            new Root(15,"aed7015a346d635"),
            new Root(15,"6aeeb69631c227c"),
            new Root(16,"e1b5e05623d881f"),
            new Root(8,"316034514573652620673"),
            new Root(3,"2122212201122002221120200210011020220200"),
            new Root(3,"20120221122211000100210021102001201112121"),
            new Root(6,"20220554335330240002224253"),
            new Root(12,"45153788322a1255483"),
            new Root(7,"1101613130313526312514143")
        };
        System.out.println("=== Test Case 2 ===");
        solve(n2, m2, roots2);
    }

    static void solve(int n, int m, Root[] roots) {
        // decode roots
        List<BigInteger> rts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rts.add(new BigInteger(roots[i].value, roots[i].base));
        }

        // polynomial coefficients
        List<BigInteger> coef = new ArrayList<>();
        coef.add(BigInteger.ONE); // start with 1

        for (int i = 0; i < m; i++) {
            BigInteger r = rts.get(i);
            List<BigInteger> next = new ArrayList<>();
            next.add(coef.get(0)); // leading coefficient stays 1
            for (int j = 1; j < coef.size(); j++) {
                next.add(coef.get(j).subtract(next.get(j-1).multiply(r)));
            }
            next.add(coef.get(coef.size()-1).negate().multiply(r));
            coef = next;
        }

        // output
        System.out.println("Degree: " + m);
        System.out.print("Coefficients: ");
        for (int i = 0; i < coef.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(coef.get(i));
        }
        System.out.println();
        System.out.print("Roots used: ");
        for (int i = 0; i < m; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(rts.get(i));
        }
        System.out.println("\nConstant term: " + coef.get(coef.size()-1));
        System.out.println();
    }
}
