// Time Complexity : O(1) for all methods
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : None

class MinStack {
    int min;
    Node tos;

    class Node {
        int data;
        Node next;
        int currentMin;

        public Node(int data, int currentMin) {
            this.data = data;
            this.currentMin = currentMin;
            this.next = null;
        }
    }

    public MinStack() {
    }

    public void push(int val) {

        if (tos == null) {
            min = val;
            tos = new Node(val, min);
        } else {
            if (val < min) {
                min = val;
            }
            Node newNode = new Node(val, min);
            newNode.next = tos;
            tos = newNode;
        }
    }

    public void pop() {
        if (tos != null) {
            Node temp = tos.next;
            tos.next = null;
            tos = temp;
            if (tos != null) {
                min = tos.currentMin;
            }
        }
    }

    public int top() {
        return tos.data;
    }

    public int getMin() {
        return tos.currentMin;
    }
}
