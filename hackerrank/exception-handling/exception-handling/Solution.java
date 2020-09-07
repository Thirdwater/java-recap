class MyCalculator {

    long power (int base, int power) throws Exception {
        if (base < 0 || power < 0) {
            throw new Exception("n or p should not be negative.");
        }
        if (base == 0 && power == 0) {
            throw new Exception("n and p should not be zero.");
        }
        assert -10 <= base && base <= 10;
        assert -10 <= power && power <= 10;

        return (long) Math.pow(base, power);
    }

}
