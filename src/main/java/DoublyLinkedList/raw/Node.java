package DoublyLinkedList.raw;

public class Node {
    public int value;
    public Node next;
    public Node previous;

    public Node(int value){
        this.value = value;
        this.next = this.previous = null;
    }

}
