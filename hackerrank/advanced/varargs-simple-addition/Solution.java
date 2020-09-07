class Add {

    void add (int... operands) {
        int sum = 0;
        for (int i = 0; i < operands.length; i++) {
            int operand = operands[i];
            sum += operand;
            System.out.print(operand);
            if (i < operands.length - 1) {
                System.out.print("+");
            }
        }
        System.out.print("=");
        System.out.println(sum);
    }

}
