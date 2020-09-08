import java.math.BigInteger;

class MyMath {

    private static int primeCertainty = 10;

    PerformOperation isOdd () {
        return (candidate -> candidate % 2 == 1);
    }

    PerformOperation isPrime () {
        return (candidate ->
            BigInteger.valueOf(candidate).isProbablePrime(MyMath.primeCertainty));
    }

    PerformOperation isPalindrome () {
        return (candidate -> {
            String string = String.valueOf(candidate);
            String reverse = new StringBuilder(string).reverse().toString();
            return string.equals(reverse);
        });
    }

}
