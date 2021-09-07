package datastructure;

import java.util.*;

// BLinkedList
public class BLinkedList {

    int data;
    BLinkedList next;

    BLinkedList(int data) {
        this.data = data;
        this.next = null;

    }
}


class BLinkedListDemo {

    BLinkedList head;

    BLinkedList insertInBeg(int key, BLinkedList head) {
        BLinkedList ttmp = new BLinkedList(key);

        if (head != null) {
            ttmp.next = head;
        }
        head = ttmp;
        return head;
    }


    BLinkedList insertInEnd(int key, BLinkedList head) {
        BLinkedList ttmp = new BLinkedList(key);
        BLinkedList ttmp1 = head;

        if (ttmp1 == null)
            head = ttmp;
        else {
            while (ttmp1.next != null)
                ttmp1 = ttmp1.next;
            ttmp1.next = ttmp;

        }

        return head;

    }


    BLinkedList insertAtPos(int key, int pos, BLinkedList head) {
        BLinkedList ttmp = new BLinkedList(key);

        if (pos == 1) {
            ttmp.next = head;
            head = ttmp;
        } else {
            BLinkedList ttmp1 = head;
            for (int i = 1; ttmp1 != null && i < pos; i++)
                ttmp1 = ttmp1.next;
            ttmp.next = ttmp1.next;
            ttmp1.next = ttmp;
        }

        return head;
    }


    BLinkedList delete(int pos, BLinkedList head) {
        BLinkedList ttmp = head;
        if (pos == 1)
            head = ttmp.next;
        else {
            for (int i = 1; ttmp != null && i < pos - 1; i++)
                ttmp = ttmp.next;
            ttmp.next = ttmp.next.next;
        }
        return head;
    }

    int length(BLinkedList head) {
        BLinkedList ttmp = head;
        int c = 0;
        if (ttmp == null)
            return 0;
        else {
            while (ttmp != null) {
                ttmp = ttmp.next;
                c++;
            }
        }
        return c;
    }

    BLinkedList reverse(BLinkedList head) {
        BLinkedList prevLNode = null, curLNode = head, nextLNode = null;
        while (curLNode != null) {
            nextLNode = curLNode.next;
            curLNode.next = prevLNode;

            prevLNode = curLNode;
            curLNode = nextLNode;
        }

        head = prevLNode;
        return head;
    }


    void display(BLinkedList head) {
        BLinkedList ttmp = head;
        while (ttmp != null) {
            System.out.print(ttmp.data + " ");
            ttmp = ttmp.next;
        }
    }

    public static void main(String[] args) {
        BLinkedListDemo l = new BLinkedListDemo();
        l.head = null;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n********* MENU *********");
            System.out.println("\n1.Insert In End");
            System.out.println("\n2.Insert In Beg");
            System.out.println("\n3.Insert At A  Particular Pos");
            System.out.println("\n4.Delete At a Pos");
            System.out.println("\n5.Length");
            System.out.println("\n6.Reverse");
            System.out.println("\n7.Display");
            System.out.println("\n8.EXIT");
            System.out.println("\nenter ur choice : ");
            int n = in.nextInt();
            switch (n) {
                case 1:
                    System.out.println("\nenter the value ");
                    l.head = l.insertInEnd(in.nextInt(), l.head);
                    break;
                case 2:
                    System.out.println("\nenter the value");
                    l.head = l.insertInBeg(in.nextInt(), l.head);
                    break;
                case 3:
                    System.out.println("\nenter the value");
                    l.head = l.insertAtPos(in.nextInt(), in.nextInt(), l.head);
                    break;
                case 4:
                    l.head = l.delete(in.nextInt(), l.head);
                    break;
                case 5:
                    System.out.println(l.length(l.head));
                    break;
                case 6:
                    l.head = l.reverse(l.head);
                    break;
                case 7:
                    l.display(l.head);
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n Wrong Choice!");
                    break;
            }
            System.out.println("\n do u want to cont... ");
        } while (in.nextInt() == 1);

    }
}