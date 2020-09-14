import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class MinStack {

    private Deque<Integer> stack;
    private List<Integer> sortedList;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        sortedList = new ArrayList<>();
    }

    public void push(int x) {
        stack.addFirst(x);
        sortedList.add(x);
        Collections.sort(sortedList);
    }

    public void pop() {
        int top = top();
        stack.removeFirst();
        sortedList.remove(Integer.valueOf(top));
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return sortedList.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
