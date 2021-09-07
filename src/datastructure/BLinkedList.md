# Linked List
* Linear Data Structure
* Elements can be stored as per memory availability
* Can access elements on linear fashion only
* Stores homogeneous elements i.e, similar elements
* Dynamic in size
* Easy insertion and deletion
* Starting element or Node is the key which is generally termed as head.

## Advantages
* Dynamic in size
* No wastage as capacity and size is always equal
* Easy insertion and deletion as 1 link manipulation is required
* Efficient memory allocation

## Disadvantages
* If head Node is lost, the linked list is lost
* No random access possible

## Applications
* Suitable where memory is limited
* Suitable for applications that require frequent insertion and deletion

## Demonstration of Linked List

```java
import java.util.*;

class LLNode {

    int data;
    LLNode next;

    LLNode(int data) {
        this.data = data;
        this.next = null;

    }
}


class Demo {

    LLNode head;


    LLNode insertInBeg(int key, LLNode head) {
        LLNode ttmp = new LLNode(key);

        if (head != null) {
            ttmp.next = head;
        }
        head = ttmp;
        return head;
    }


    LLNode insertInEnd(int key, LLNode head) {
        LLNode ttmp = new LLNode(key);
        LLNode ttmp1 = head;

        if (ttmp1 == null)
            head = ttmp;
        else {
            while (ttmp1.next != null)
                ttmp1 = ttmp1.next;
            ttmp1.next = ttmp;

        }

        return head;

    }


    LLNode insertAtPos(int key, int pos, LLNode head) {
        LLNode ttmp = new LLNode(key);

        if (pos == 1) {
            ttmp.next = head;
            head = ttmp;
        } else {
            LLNode ttmp1 = head;
            for (int i = 1; ttmp1 != null && i < pos; i++)
                ttmp1 = ttmp1.next;
            ttmp.next = ttmp1.next;
            ttmp1.next = ttmp;
        }

        return head;
    }


    LLNode delete(int pos, LLNode head) {
        LLNode ttmp = head;
        if (pos == 1)
            head = ttmp.next;
        else {
            for (int i = 1; ttmp != null && i < pos - 1; i++)
                ttmp = ttmp.next;
            ttmp.next = ttmp.next.next;
        }
        return head;
    }

    int length(LLNode head) {
        LLNode ttmp = head;
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

    LLNode reverse(LLNode head) {
        LLNode prevLNode = null, curLNode = head, nextLNode = null;
        while (curLNode != null) {
            nextLNode = curLNode.next;
            curLNode.next = prevLNode;

            prevLNode = curLNode;
            curLNode = nextLNode;
        }

        head = prevLNode;
        return head;
    }


    void display(LLNode head) {
        LLNode ttmp = head;
        while (ttmp != null) {
            System.out.print(ttmp.data + " ");
            ttmp = ttmp.next;
        }
    }

    public static void main(String[] args) {
        LinkedListDemo l = new LinkedListDemo();
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
```

Output:
```
********* MENU *********

1.Insert In End

2.Insert In Beg

3.Insert At A  Particular Pos

4.Delete At a Pos

5.Length

6.Reverse

7.Display

8.EXIT

enter ur choice :
1

enter the value
23

do u want to cont...
1

********* MENU *********

1.Insert In End

2.Insert In Beg

3.Insert At A  Particular Pos

4.Delete At a Pos

5.Length

6.Reverse

7.Display

8.EXIT

enter ur choice :
1

enter the value
56

do u want to cont...
1

********* MENU *********

1.Insert In End

2.Insert In Beg

3.Insert At A  Particular Pos

4.Delete At a Pos

5.Length

6.Reverse

7.Display

8.EXIT

enter ur choice :
2

enter the value
10

do u want to cont...
1

********* MENU *********

1.Insert In End

2.Insert In Beg

3.Insert At A  Particular Pos

4.Delete At a Pos

5.Length

6.Reverse

7.Display

8.EXIT

enter ur choice :
7
10 23 56
do u want to cont...
1

********* MENU *********

1.Insert In End

2.Insert In Beg

3.Insert At A  Particular Pos

4.Delete At a Pos

5.Length

6.Reverse

7.Display

8.EXIT

enter ur choice :
3

enter the value
67
2

do u want to cont...
1

********* MENU *********

1.Insert In End

2.Insert In Beg

3.Insert At A  Particular Pos

4.Delete At a Pos

5.Length

6.Reverse

7.Display

8.EXIT

enter ur choice :
7
10 23 67 56
do u want to cont...
1

********* MENU *********

1.Insert In End

2.Insert In Beg

3.Insert At A  Particular Pos

4.Delete At a Pos

5.Length

6.Reverse

7.Display

8.EXIT

enter ur choice :
4
2

do u want to cont...
1

********* MENU *********

1.Insert In End

2.Insert In Beg

3.Insert At A  Particular Pos

4.Delete At a Pos

5.Length

6.Reverse

7.Display

8.EXIT

enter ur choice :
7
10 67 56
do u want to cont...
1

********* MENU *********

1.Insert In End

2.Insert In Beg

3.Insert At A  Particular Pos

4.Delete At a Pos

5.Length

6.Reverse

7.Display

8.EXIT

enter ur choice :
6

do u want to cont...
1

********* MENU *********

1.Insert In End

2.Insert In Beg

3.Insert At A  Particular Pos

4.Delete At a Pos

5.Length

6.Reverse

7.Display

8.EXIT

enter ur choice :
7
56 67 10
do u want to cont...
```