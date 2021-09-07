# Queue
* Linear Data Structure
* Follows FIFO: First In First Out
* Insertion can take place from the rear end.
* Deletion can take place from the front end.
* Eg: queue at ticket counters, bus station
* 4 major operations:
  - enqueue(ele) – used to insert element at top
  - dequeue() – removes the top element from queue
  - peekfirst() – to get the first element of the queue
  - peeklast() – to get the last element of the queue
* All operation works in constant time i.e, O(1)

## Advantages
* Maintains data in FIFO manner
* Insertion from beginning and deletion from end takes O(1) time

## Applications
* Scheduling
* Maintaining playlist
* Interrupt handling

## Demonstration of Queue- using Array

```java
import java.util.*;

class Queue{

 int front;
 int rear;
 int[] arr;
 
 Queue()
 {
   front=rear=-1;
   arr=new int[10];
  }
  
  void enqueue(int a)
  {
    if(rear==arr.length-1)
		System.out.println("overflow");
	else
		arr[++rear]=a;
	
	if(front==-1)
		front++;
   }
   
   int dequeue()
   {
     int x=-1;
	 if(front==-1)
		System.out.println("underflow");
	 else
		x=arr[front++];
	 if(rear==0)
	     rear--;
	 return x;
    }
	
	void display()
	{
	  for(int i=front;i<=rear;i++)
		System.out.print(arr[i]+" ");

	 System.out.println();


	}
}

public class QueueDemo{

	public static void main(String[] args)
	{
	  Queue ob=new Queue();
	  ob.enqueue(1);
	  ob.enqueue(2);
	  ob.enqueue(3);
	  ob.enqueue(4);
	  ob.enqueue(5);
	  ob.display();
	  ob.dequeue();
	  ob.display();
	 }
}
	  
```



Output:

```
1 2 3 4 5 
2 3 4 5 
```

## Demonstration of Queue- using LinkedList

```java
class LNode{
	
	int data;
	LNode next;

	LNode(int d)
	{
		data=d;
	}
}


class Queue{

	LNode enqueue(LNode head,int a)
	{
		LNode tmp=new LNode(a);
		if(head==null)
			head=tmp;
		else
		 { 
			LNode tmp1=head;
			while(tmp1.next!=null)
				tmp1=tmp1.next;
			
			tmp1.next=tmp;
		}
		return head;
	}
	
	
	LNode dequeue(LNode head)
	{
		if(head==null)
		        System.out.println("underflow");
		   else
				head=head.next;
			return head;
	}
	
	void display(LNode head)
	{
		
				System.out.println("\n list is : ");
				if(head==null){
					
					System.out.println("no LNodes");
			
					return;
					}
				 
				LNode tmp=head;

				while(tmp!=null){
						
				System.out.print(tmp.data+" ");
					 
				tmp=tmp.next;
					 
					
				}
	}
	
	}
	
	public class QueueDemoLL{
		
		public static void main(String[] args)
		{
			Queue ob=new Queue();
			LNode head=null;
			
			head=ob.enqueue(head,1);
			head=ob.enqueue(head,2);
			head=ob.enqueue(head,3);
			head=ob.enqueue(head,4);
			head=ob.enqueue(head,5);
			ob.display(head);
			head=ob.dequeue(head);
			ob.display(head);
		}
	}

```


Output
```
list is : 
1 2 3 4 5 
list is : 
2 3 4 5 
```