package DoublyLinkedList;

import java.util.*;

public class DoublyLinkedList {
    public Node head;
    public Node tail;
    public int count;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(Node node) {
        if (head == null) {
            this.head = node;
            this.head.next = null;
            this.head.previous = null;
        } else {
            this.tail.next = node;
            node.previous = tail;
        }
        this.tail = node;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            } else
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
        Node newNode;
        if (head == null) {
            return false;
        }
        if (head.next == null && head.value == value) {
            head = null;
            tail = null;
            return true;
        }
        while (true) {
            if (head.value != value && head.next == null) {
                return false;
            }
            if (head.value == value) {
                newNode = head.next;
                head = null;
                head = newNode;
                head.previous = null;
                return true;
            }
            if (node.next == tail && tail.value == value) {
                node.next = null;
                tail = node;
                tail.previous = node.previous;
                return true;
            } else if (node.next.value == value) {
                newNode = node;
                node = node.next;
                newNode.next = node.next;
                return true;
            } else
                node = node.next;
            if (node.next == null) {
                return false;
            }
        }
    }

    public void removeAll(int value) {
        Node node = head;
        Node newNode;
        while (node != null) {
            if(count() == 0){
                break;
            }else if (head.value == value && count() == 1){
                head = null;
                tail= null;
                break;
            } else if (head.value == value) {
                head = head.next;
                head.previous = null;
                node = head;
            }
            else if (node.next == tail && tail.value == value) {
                newNode = node.previous;
                node.next = null;
                tail = node;
                tail.previous = newNode;
                tail.next = null;
                break;
            }
            else if (node.next != null && node.next.value == value) {
                newNode = node;
                node = node.next;
                newNode.next = node.next;
                node = newNode;
            }
            else {
                newNode = node;
                node = node.next;
                if (node != null) {
                    node.previous = newNode;
                }
            }
        }
    }

    public void clear() {
        Node newNode;
        while (head != null) {
            newNode = head.next;
            head.previous = null;
            head = null;
            head = newNode;
            if(head == null){
                tail = null;
            }
        }
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
        if (nodeAfter == null && count() == 0) {
            head = nodeToInsert;
            tail = nodeToInsert;
            head.previous = null;
        } else if (nodeAfter == null) {
            newNode = head;
            head.previous = nodeToInsert;
            head = nodeToInsert;
            head.next = newNode;
        } else
            while (node != null) {
                if (node == tail && node.value == nodeAfter.value) {
                    tail.next = nodeToInsert;
                    tail = nodeToInsert;
                    tail.previous = node;
                    break;
                } else if (node.value == nodeAfter.value) {
                    newNode = node;
                    node = node.next;
                    newNode.next = nodeToInsert;
                    nodeToInsert.next = node;
                    nodeToInsert.previous = newNode;
                    break;
                } else
                    node = node.next;
            }
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