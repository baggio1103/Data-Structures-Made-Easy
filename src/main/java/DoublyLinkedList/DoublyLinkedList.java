package DoublyLinkedList;

import java.util.*;

public class DoublyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(Node node) {
        if (head == null){
            this.head = node;
        }else {
            node.previous = tail;
            this.tail.next = node;
        }
        this.tail = node;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int value) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int value) {
        Node node = head;
        if (head != null){
            if (head.value == value){
                if (head.next == null){
                    head = tail = null;
                } else {
                    head = head.next;
                    head.previous = null;
                }
                return true;
            }
            while (node != null){
                if (node.value == value){
                    if (node == tail){
                        tail = tail.previous;
                        tail.next = null;
                    }else {
                        node.previous.next = node.next;
                        node.next.previous = node.previous;
                    }
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public void removeAll(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                if (node == head) {
                    if (node.next == null){
                        node = head = tail = null;
                    }else {
                        head = head.next;
                        head.previous = null;
                        node = head;
                    }
                } else if (node == tail) {
                    tail = tail.previous;
                    tail.next = null;
                    node = null;
                } else {
                    node.previous.next = node.next;
                    node.next.previous = node.previous;
                    node = node.next;
                }
            } else {
                node = node.next;
            }
        }
    }

    public void insertAfter(Node nodeAfter, Node nodeToInsert) {
        if (nodeAfter == null) {
            head = tail = nodeToInsert;
        } else {
            if (nodeAfter == head) {
                if (nodeAfter.next != null) {
                    nodeToInsert.next = nodeAfter.next;
                    nodeAfter.next.previous = nodeToInsert;
                    nodeToInsert.previous = nodeAfter;
                    nodeAfter.next = nodeToInsert;
                }else {
                    nodeAfter.next = nodeToInsert;
                    nodeToInsert.previous = nodeAfter;
                    nodeToInsert.next = null;
                    tail = nodeToInsert;
                }
            }else {
                tail.next = nodeToInsert;
                nodeToInsert.previous = tail;
                nodeToInsert.next = null;
                tail = nodeToInsert;
            }
        }
    }

    public int size() {
        size = 0;
        Node node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public void clear() {
        this.head = this.tail = null;
    }

    public void traverse(boolean forward) {
        if (forward) {
            Node node = head;
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.next;
            }
        }else {
            Node node = tail;
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.previous;
            }
        }
        System.out.println();
    }

    public Node headOfList(DoublyLinkedList list) {
        return list.head;
    }

    public Node tailOfList(DoublyLinkedList list) {
        return list.tail;
    }

}