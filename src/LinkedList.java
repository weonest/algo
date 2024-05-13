public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    public void addFirst(Object data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        size++;
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object data) {
        Node node = new Node(data);
        if (size == 0) {
            addFirst(data);
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public void add(int index, Object data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node tmp1 = node(index - 1);
        Node tmp2 = tmp1.next;
        Node node = new Node(data);

        tmp1.next = node;
        node.next = tmp2;

        size++;

        if (node.next == null) {
            tail= node;
        }
    }

    public Object removeFirst() {
        Node temp = head;
        head = temp.next;

        Object removedData = temp.data;
        size --;
        return removedData;
    }

    public Object remove(int index) {
        if (index == 0) {
            return removeFirst();
        }

        Node temp = node(index - 1);
        Node deletedNode = temp.next;

        temp.next = deletedNode.next;

        if (deletedNode == tail) {
            tail = temp;
        }
        size--;
        return deletedNode.data;
    }

    public Object get(int index) {
        return node(index).data;
    }

    public int indexOf(Object data) {
        Node temp = head;

        int index = 0;

        while (temp.data != data) {
            temp = temp.next;
            index++;
            if (temp == null) {
                return -1;
            }
        }
        return index;
    }

    private Node node(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        Node tmp = head;
        String str = "[";
        while (tmp.next != null) {
            str += tmp.data + ", ";
            tmp = tmp.next;
        }

        str += tmp.data;
        return str + "]";
    }

    private static class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                   "data=" + data +
                   '}';
        }
    }

    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addLast(10);
        numbers.addLast(15);
        numbers.addLast(20);
        numbers.addLast(30);
        System.out.println(numbers.remove(1));
        System.out.println(numbers);
    }
}
