class MyCalculator implements AdvancedArithmetic {

    // Methods are public by defaults in interfaces,
    // but package-private by defaults in classes.
    @Override
    public int divisor_sum (int n) {
        assert n <= 1_000;
        int smallestCheck = (int) Math.floor(Math.sqrt(n));
        int sum = 0;
        for (int i = 1; i <= smallestCheck; i++) {
            if (n % i == 0) {
                int pair = n / i;
                if (i == pair) {
                    sum += i;
                } else {
                    sum += i + pair;
                }
            }
        }
        return sum;
    }

}
