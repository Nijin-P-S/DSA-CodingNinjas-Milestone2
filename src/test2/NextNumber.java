package test2;

/*
Given a large number represented in the form of a linked list.
Write code to increment the number by 1 in-place(i.e. without using extra space).
 */


import java.util.Stack;

class LinkedList<T>{
    T data;
    LinkedList<T> next;
    LinkedList(T data){
        this.data = data;
    }
}


public class NextNumber {
    public static LinkedList<Integer> nextLargeNumber(LinkedList<Integer> head) {
        if(head == null)
            return head;

        Stack<LinkedList> stack = new Stack<>();

        LinkedList<Integer> tail = head;

        while(tail!=null){
            stack.push(tail);
            tail=tail.next;
        }

        tail = stack.pop();
        head = tail;

        while(!stack.isEmpty()){
            tail.next = stack.pop();
            tail = tail.next;
        }

        tail.next = null;

        tail = head;
        LinkedList<Integer> lastPointer = null;
        int carry = 0;
        while(tail!=null){
            if(tail.next == null)
                lastPointer = tail;
            if(head == tail){
                carry = (tail.data+1)/10;
                tail.data = (tail.data+1) %10;
                tail = tail.next;
            }
            else{
                int sum = tail.data+carry;
                tail.data = sum%10;
                carry = sum/10;
                tail=tail.next;
            }
        }

        if(carry!=0){
            LinkedList<Integer> node = new LinkedList<>(carry);
            lastPointer.next = node;

        }

        tail = head;

        while(tail!=null){
            stack.push(tail);
            tail=tail.next;
        }
        tail = stack.pop();
        head = tail;

        while(!stack.isEmpty()){
            tail.next = stack.pop();
            tail = tail.next;
        }

        tail.next = null;

        return head;
    }

}
