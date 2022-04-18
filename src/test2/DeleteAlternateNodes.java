package test2;

/*
Given a Singly Linked List of integers, delete all the alternate nodes in the list.
 */

class Node<T>{
    Node<T> next;
    T data;

    Node(T data){
        this.data = data;
    }
}

public class DeleteAlternateNodes {
    public static void deleteAlternateNodes(Node<Integer> head) {
        //Your code goes here
        if(head == null || head.next == null)
            return ;

        Node<Integer> pointer = head;

        while(pointer!=null && pointer.next!=null){
            pointer.next = pointer.next.next;
            pointer = pointer.next;
        }
    }
}
