import java.math.BigInteger;
import static java.lang.System.in;  // Problem specifications

class Prime {

    private static int certainty = 10;

    void checkPrime (int... candidates) {
        boolean isFirstCandidate = true;
        for (int i = 0; i < candidates.length; i++) {
            BigInteger candidate = BigInteger.valueOf(candidates[i]);
            if (candidate.isProbablePrime(Prime.certainty)) {
                if (!isFirstCandidate) {
                    System.out.print(" ");
                }
                System.out.print(candidate);
                isFirstCandidate = false;
            }
            if (i == candidates.length - 1) {
                System.out.println();
            }
        }
    }

}
