package com.me.lists.linked;

/**
 * Implementation of the Singly(one-sided) Linked IList
 */
public class SingleLinkedList extends AbstractLinkedList {

    @Override
    public void addFirst(int value){
        if (head == null){
            head = new Link();
            head.data = value;
        } else {
            Link newHead = new Link();
            newHead.data = value;
            newHead.next = this.head;
            this.head = newHead;
        }
        size++;
    }

    @Override
    public void removeFirst(){
        if (head != null){
            head = head.next;
            size--;
        }
    }

    @Override
    public void addLast(int value){
        Link lastLink = getLast();
        if (lastLink != null){
            lastLink.next = new Link();
            lastLink.next.data = value;
        } else {
            head = new Link();
            head.data = value;
        }
        size++;
    }

    @Override
    public void removeLast(){
        if (head != null) {
            if (head.next == null)
                head = null;
            Link curLink = head.next;
            Link prevLink = head;
            while (curLink.next != null){
                prevLink = curLink;
                curLink = curLink.next;
            }
            prevLink.next = null;
            size--;
        }
    }

    @Override
    public Link getLast(){
        if (head == null) return null;
        if (head.next == null) return head;
        Link currentLink = head.next;
        while (currentLink.next != null){
            currentLink = currentLink.next;
        }
        return currentLink;
    }

    public static void main(String[] args){
        SingleLinkedList ll = new SingleLinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.removeLast();
        ll.removeFirst();
        ll.removeFirst();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(0);
        ll.display();
        System.out.println("Length of Linked list is [" + ll.length() + "]" );
        System.out.println("Index of 5 in Linked list is [" + ll.indexOf(5) + "]" );
        System.out.println("Index of 0 in Linked list is [" + ll.indexOf(0) + "]" );
        System.out.println("Index of 7 in Linked list is [" + ll.indexOf(7) + "]" );
        System.out.println("Index of 6 in Linked list is [" + ll.indexOf(6) + "]" );
        System.out.println("Value of 6th element is " + ll.get(6));
        System.out.println("Value of 3d element is " + ll.get(3));
        System.out.println("Value of 0 element is " + ll.get(0));
        System.out.println("Value of 7 element is " + ll.get(7));
    }

}