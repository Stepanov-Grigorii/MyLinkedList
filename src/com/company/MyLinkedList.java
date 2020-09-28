package com.company;

public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node<T> {

        public T value;
        Node<T> next;
        Node<T> prev;

        Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(T value) {
        Node<T> node = new Node<>(value, null, null);
        if (size == 0) {
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void addFirst(T value) {
        if (size == 0) {
            add(value);
        } else{
            Node<T> node = new Node<>(value, null, null);
            node.next = head;
            head.prev = node;
            head = node;
            size++;
        }
    }

    public void addInMiddle(T value){
        if (size < 3) {
            add(value);
        } else{
            Node<T> iNode = head;
            Node<T> node = new Node<>(value, null, null);
            for (int i = 0; i != size / 2 - 1; i++){
                iNode = iNode.next;
            }
            node.next = iNode.next;
            node.prev = iNode;
            iNode.next.prev = node;
            iNode.next = node;
            size++;
        }
    }

    public boolean remove(T value) {
        Node<T> current = head;
        while (current != null) {
            if (!current.value.equals(value)) {
                current = current.next;
                continue;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
                if (current.next != null)
                    current.next.prev = current.prev;
            } else {
                head = current.next;
            }
            if (current.next == null) {
                tail = current.prev;
            }
            size--;
            return true;
        }
        return false;
    }
}
