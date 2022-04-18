package test2;

/*
You need to implement a class for Dequeue i.e. for double ended queue. In this queue,
elements can be inserted and deleted from both the ends.
You don't need to double the capacity.
You need to implement the following functions -
1. constructor
You need to create the appropriate constructor. Size for the queue passed is 10.
2. insertFront -
This function takes an element as input and insert the element at the front of queue.
Insert the element only if queue is not full. And if queue is full, print -1 and return.
3. insertRear -
This function takes an element as input and insert the element at the end of queue.
Insert the element only if queue is not full. And if queue is full, print -1 and return.
4. deleteFront -
This function removes an element from the front of queue. Print -1 if queue is empty.
5. deleteRear -
This function removes an element from the end of queue. Print -1 if queue is empty.
6. getFront -
Returns the element which is at front of the queue. Return -1 if queue is empty.
7. getRear -
Returns the element which is at end of the queue. Return -1 if queue is empty.
 */

class DoubleNode{
    int data;
    DoubleNode prev;
    DoubleNode next;

    DoubleNode(int data){
        this.data = data;
        prev = null;
        next = null;
    }
}

public class Dequeue {
    DoubleNode head;
    DoubleNode tail;
    int size;
    int capacity;

    public Dequeue(int size){
        this.capacity = size;
    }

    public void insertFront(int val){
        if(size==capacity)
        {
            System.out.println("-1");
            return;
        }
        if(head==null && tail == null){
            DoubleNode node = new DoubleNode(val);
            head = node;
            tail = node;
            size++;
            return;
        }
        DoubleNode node = new DoubleNode(val);
        node.next = head;
        head.prev = node;
        head = node;
        size++;
        return;
    }

    public void insertRear(int val){
        if(size==capacity)
        {
            System.out.println("-1");
            return;
        }
        if(head==null && tail == null){
            DoubleNode node = new DoubleNode(val);
            head = node;
            tail = node;
            size++;
            return;
        }
        DoubleNode node = new DoubleNode(val);
        node.prev = tail;
        tail.next = node;
        tail = node;
        size++;
        return;
    }

    public void deleteFront(){
        if(size == 0)
        {
            System.out.println("-1");
            return;
        }

        if(size == 1)
        {
            tail=null;
            head =null;
            size--;
            return;
        }

        else{
            head = head.next;
            head.prev = null;
            size--;
            return;
        }
    }

    public void deleteRear(){
        if(size == 0)
        {
            System.out.println("-1");
            return;
        }

        if(size == 1)
        {
            tail=null;
            head =null;
            size--;
            return;
        }

        else{
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }
    }

    public int getFront(){
        if(size == 0)
        {
            return -1;
        }

        else
            return head.data;
    }

    public int getRear(){
        if(size == 0)
        {
            return -1;
        }

        else
            return tail.data;
    }
}
