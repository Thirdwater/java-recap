import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * accept(TreeVisitor) will be called and propagate throughout the tree,
 * invoking visitNode(TreeNode) and visitLeaf(TreeLeaf) appropriately.
 */

class SumInLeavesVisitor extends TreeVis {

    private int leafSum = 0;

    public int getResult () {
        return leafSum;
    }

    public void visitNode (TreeNode node) {
        // Do nothing
    }

    public void visitLeaf (TreeLeaf leaf) {
        leafSum += leaf.getValue();
    }

}

class ProductOfRedNodesVisitor extends TreeVis {

    private BigInteger redProduct = BigInteger.ONE;
    private static final BigInteger MODULO = BigInteger.valueOf(1_000_000_007);

    public int getResult () {
        return redProduct.intValue();
    }

    public void visitNode (TreeNode node) {
        if (node.getColor() == Color.RED) {
            redProduct = redProduct.multiply(BigInteger.valueOf(node.getValue()));
            redProduct = redProduct.mod(ProductOfRedNodesVisitor.MODULO);
        }
    }

    public void visitLeaf (TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            redProduct = redProduct.multiply(BigInteger.valueOf(leaf.getValue()));
            redProduct = redProduct.mod(ProductOfRedNodesVisitor.MODULO);
        }
    }

}

class FancyVisitor extends TreeVis {

    private int evenDepthNonLeafSum = 0;
    private int greenLeafSum = 0;

    public int getResult () {
        return Math.abs(evenDepthNonLeafSum - greenLeafSum);
    }

    public void visitNode (TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthNonLeafSum += node.getValue();
        }
    }

    public void visitLeaf (TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }

}

public class Solution {

    public static Tree solve () {
        try (Scanner scanner = new Scanner(System.in)) {
            /*
             * Parse and preprocess inputs
             */
            int numNodes = scanner.nextInt();
            assert 2 <= numNodes && numNodes <= 100_000;

            int[] values = new int[numNodes];
            for (int i = 0; i < numNodes; i++) {
                int value = scanner.nextInt();
                assert 1 <= value && value <= 1_000;
                values[i] = value;
            }

            Color[] colors = new Color[numNodes];
            for (int i = 0; i < numNodes; i++) {
                int colorCode = scanner.nextInt();
                assert colorCode == 0 || colorCode == 1;
                if (colorCode == 0) {
                    colors[i] = Color.RED;
                }
                if (colorCode == 1) {
                    colors[i] = Color.GREEN;
                }
            }

            // Parse edges (can't assume left = parent, right = child)
            Map<Integer, List<Integer>> edgeMap = new HashMap<Integer, List<Integer>>();
            for (int i = 0; i < numNodes - 1; i++) {
                int leftInput = scanner.nextInt();
                int rightInput = scanner.nextInt();
                assert 1 <= leftInput && leftInput <= numNodes;
                assert 1 <= rightInput && rightInput <= numNodes;
                int leftIndex = leftInput - 1;
                int rightIndex = rightInput - 1;

                if (edgeMap.containsKey(leftIndex)) {
                    edgeMap.get(leftIndex).add(rightIndex);
                } else {
                    List<Integer> edgeList = new ArrayList<Integer>();
                    edgeList.add(rightIndex);
                    edgeMap.put(leftIndex, edgeList);
                }
                if (edgeMap.containsKey(rightIndex)) {
                    edgeMap.get(rightIndex).add(leftIndex);
                } else {
                    List<Integer> edgeList = new ArrayList<Integer>();
                    edgeList.add(leftIndex);
                    edgeMap.put(rightIndex, edgeList);
                }
            }

            // Resolve parent-child relationships
            Map<Integer, List<Integer>> parentChildMap = new HashMap<Integer, List<Integer>>();
            boolean[] isLeaf = new boolean[numNodes];
            int[] parents = new int[numNodes];
            int[] depths = new int[numNodes];
            Arrays.fill(isLeaf, true);
            Arrays.fill(parents, 0);
            Arrays.fill(depths, 0);
            // Start with root, the single known parent in all cases
            List<Integer> parentCandidates = new ArrayList<Integer>();
            parentCandidates.add(0);
            while (!parentCandidates.isEmpty()) {
                int parentIndex = parentCandidates.remove(0);
                for (int childIndex: edgeMap.get(parentIndex)) {
                    if (parentChildMap.containsKey(parentIndex)) {
                        parentChildMap.get(parentIndex).add(childIndex);
                    } else {
                        List<Integer> childList = new ArrayList<Integer>();
                        childList.add(childIndex);
                        parentChildMap.put(parentIndex, childList);
                    }
                    isLeaf[parentIndex] = false;
                    parents[childIndex] = parentIndex;
                    depths[childIndex] = depths[parentIndex] + 1;

                    edgeMap.get(childIndex).remove(Integer.valueOf(parentIndex));
                    // A node can have at most 1 parent
                    if (!edgeMap.get(childIndex).isEmpty()) {
                        parentCandidates.add(childIndex);
                    } else {
                        edgeMap.remove(childIndex);
                    }
                }
                edgeMap.remove(parentIndex);
            }

            /*
             * Construct trees
             */
            Tree[] trees = new Tree[numNodes];
            for (int i = 0; i < numNodes; i++) {
                Tree tree;
                if (isLeaf[i]) {
                    tree = new TreeLeaf(values[i], colors[i], depths[i]);
                } else {
                    tree = new TreeNode(values[i], colors[i], depths[i]);
                }
                trees[i] = tree;
            }
            for (int parentIndex: parentChildMap.keySet()) {
                for (int childIndex: parentChildMap.get(parentIndex)) {
                    TreeNode parent = (TreeNode) trees[parentIndex];
                    parent.addChild(trees[childIndex]);
                }
            }

            return trees[0];
        }
    }

}
