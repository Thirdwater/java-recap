import java.util.Scanner;
import java.util.BitSet;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int bitsetSize = scanner.nextInt();
            int numOperations = scanner.nextInt();
            assert 1 <= bitsetSize && bitsetSize <= 1_000;
            assert 1 <= numOperations && numOperations <= 10_000;

            BitSet bitset1 = new BitSet(bitsetSize);
            BitSet bitset2 = new BitSet(bitsetSize);
            BitSet[] operands = {bitset1, bitset2};
            for (int i = 0; i < numOperations; i++) {
                String operation = scanner.next();
                int left = scanner.nextInt();
                int right = scanner.nextInt();
                if (operation.equals("AND") ||
                    operation.equals("OR") ||
                    operation.equals("XOR")) {
                    assert left == 1 || left == 2;
                    assert right == 1 || right == 2;
                    BitSet leftOperand = operands[left - 1];
                    BitSet rightOperand = operands[right - 1];
                    if (operation.equals("AND")) {
                        leftOperand.and(rightOperand);
                    } else if (operation.equals("OR")) {
                        leftOperand.or(rightOperand);
                    } else if (operation.equals("XOR")) {
                        leftOperand.xor(rightOperand);
                    }
                } else if (operation.equals("FLIP") || operation.equals("SET")) {
                    assert left == 1 || left == 2;
                    assert 0 <= right && right < bitsetSize;
                    BitSet operand = operands[left - 1];
                    int index = right;
                    if (operation.equals("FLIP")) {
                        operand.flip(index);
                    } else if (operation.equals("SET")) {
                        operand.set(index);
                    }
                }
                System.out.format("%d %d%n", bitset1.cardinality(), bitset2.cardinality());
            }
        }
    }

}
