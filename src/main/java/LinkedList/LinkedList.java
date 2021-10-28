package LinkedList;

import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;
    public int count;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void add(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int value) {
        Node node = head;
        Node newNode;
        if (head.value == value){
            if (head.next == null){
                head = tail = null;
            }else
                head = head.next;
            return true;
        }
        while (node.next != null){
            if (node.next.value == value){
                if (node.next == tail){
                    node.next = null;
                    tail = node;
                }else {
                    newNode = node.next.next;
                    node.next = newNode;
                }
                return true;
            }else {
                node = node.next;
            }
        }
        return false;
    }

    public void removeAll(int value) {
        Node node = head;
        Node newNode;
        if (head.next == null){
            if (head.value == value){
                head = tail = null;
            }
        }else {
            while (node != null){
                if (node.value == value){
                    head = head.next;
                    node = head;
                }else if (node.next != null){
                    if (node.next == tail && tail.value == value){
                        node.next = null;
                        tail = node;
                    }else if (node.next.value == value){
                        newNode = node.next.next;
                        node.next = newNode;
                    }else {
                        node = node.next;
                    }
                }else {
                    node = null;
                }
            }
        }
    }

    public void clear() {
        tail = head = null;
    }

    public int count() {
        count = 0;
        Node node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node nodeAfter, Node nodeToInsert) {
        Node node = head;
        Node newNode;
        if(nodeAfter == null && count() == 0){
            head = nodeToInsert;
            tail = nodeToInsert;
        } else if (nodeAfter != null) {
            while (node != null) {
                if(node == tail && node.value == nodeAfter.value){
                    tail.next = nodeToInsert;
                    tail = nodeToInsert;
                    node = null;
                }
                else if (node.value == nodeAfter.value) {
                    newNode = node;
                    node = node.next;
                    newNode.next = nodeToInsert;
                    nodeToInsert.next = node;
                    node = null;
                } else
                    node = node.next;
            }
        }
    }

    public LinkedList listReturn(LinkedList list, LinkedList list2) {
        LinkedList newList = null;
        if (list.count() == list2.count()) {
            newList = new LinkedList();
            Node node1 = list.head;
            Node node2 = list2.head;
            while (node1 != null && node2 != null) {
                newList.add(new Node(node1.value + node2.value));
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return newList;
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + "  ");
            node = node.next;
        }
        System.out.println();
    }

    public Node headOfList(LinkedList list) {
        return list.head;
    }

    public Node tailOfList(LinkedList list) {
        return list.tail;
    }

}