# Stack
* Linear Data Structures using Java
* Follows LIFO: Last In First Out
* Only the top elements are available to be accessed
* Insertion and deletion takes place from the top
* Eg: a stack of plates, chairs, etc
* 4 major operations:
  - push(ele) – used to insert element at top
  - pop() – removes the top element from stack
  - isEmpty() – returns true is stack is empty
  - peek() – to get the top element of the stack

* All operation works in constant time i.e, O(1)

## Advantages
* Maintains data in a LIFO manner
* The last element is readily available for use
* All operations are of O(1) complexity

## Disadvantages
* Manipulation is restricted to the top of the stack
* Not much flexible

## Applications
* Recursion
* Parsing
* Browser
* Editors

## Demonstration of Stack – using Array

```java
import java.util.*;

class Stack
{
   int[] a;
   int top;
   Stack()
   {	
	a=new int[100];
	top=-1;
   }
  
  void push(int x)
  {	
	if(top==a.length-1)
	  System.out.println("overflow");
	else
	 a[++top]=x;
   }
   
   int pop()
   {
     if(top==-1)
		{System.out.println("underflow");
	     return -1;
		}
	 else
	   return(a[top--]);
	}
	
	void display()
	{
		for(int i=0;i<=top;i++)
			System.out.print(a[i]+" ");
		System.out.println();	
	}
	
	boolean isEmpty()
	{
		if(top==-1)
			return true;
		else 
			return false;
	}
	
	int peek()
	{
		if(top==-1)
			return -1;
		return (a[top]);
	}
	
	
}

public class Demo
{
	public static void main(String args[])
	{
		
		Stack s=new Stack();
		Scanner in= new Scanner(System.in);
		
		 do
			{System.out.println("\n******** MENU *******");
			 System.out.println("\n1.PUSH");
			 System.out.println("\n2.POP");
			 System.out.println("\n3.PEEK");
			 System.out.println("\n4 IS EMPTY");
			 System.out.println("\n5.EXIT");
			 System.out.println("\n enter ur choice : ");
			 switch(in.nextInt())
				{
				 case 1: 
					 System.out.println("\nenter the value ");
					 s.push(in.nextInt());
					 break;
				 case 2: 
					System.out.println("\n popped element : "+ s.pop());
					 break;
				 
				case 3: 
					System.out.println("\n top element : "+ s.peek());
					 break;
				 case 4: System.out.println("\n is empty : "+ s.isEmpty());
						 break;
				 case 5: System.exit(0);
						 break;
				 default: System.out.println("\n Wrong Choice!");
						  break;
				}
			 System.out.println("\n do u want to cont... ");
			}while(in.nextInt()==1);

	}
}
```





Output:
```
******** MENU *******

1.PUSH

2.POP

3.PEEK

4 IS EMPTY

5.EXIT

 enter ur choice :
1

enter the value
12

 do u want to cont...
1

******** MENU *******

1.PUSH

2.POP

3.PEEK

4 IS EMPTY

5.EXIT

 enter ur choice :
1

enter the value
56

 do u want to cont...
1

******** MENU *******

1.PUSH

2.POP

3.PEEK

4 IS EMPTY

5.EXIT

 enter ur choice :
2

 popped element : 56

 do u want to cont...
1

******** MENU *******

1.PUSH

2.POP

3.PEEK

4 IS EMPTY

5.EXIT

 enter ur choice :
4

 is empty : false

 do u want to cont...
1

******** MENU *******

1.PUSH

2.POP

3.PEEK

4 IS EMPTY

5.EXIT

 enter ur choice :
2

 popped element : 12

 do u want to cont...
```

## Demonstration of Stack – using LinkedList

```java
import java.util.*;

class LNode
{
	 int data;
	 LNode next;
	 LNode(int d)
	 {
		data=d;
	 }
	 
}

 class Stack
{
	 LNode push(int d,LNode head){  
		
				LNode tmp1 = new LNode(d);
				
				if(head==null)
				   
					head=tmp1;
				
				else
				{
					tmp1.next=head;
					
					head=tmp1;
				}
				return head;
			 }
			 
			 
	 LNode pop(LNode head){
		   
		    if(head==null)
		        System.out.println("underflow");
		   else
				head=head.next;
			return head;
		 }
	

	void display(LNode head){
		
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

    boolean isEmpty(LNode head)
	{
		if(head==null)
			return true;
		else
			return false;
	}
	
	int peek(LNode head)
	{
		if(head==null)
			return -1;
		return head.data;
	}
	
}


public class Demo{
		
		public static void main(String[] args)
		{
		Stack s=new Stack();
		LNode head=null;
		Scanner in=new Scanner(System.in);
		
		 do
			{System.out.println("\n******** MENU *******");
			 System.out.println("\n1.PUSH");
			 System.out.println("\n2.POP");
			 System.out.println("\n3.PEEK");
			 System.out.println("\n4 IS EMPTY"); 
			 System.out.println("\n5 DISPLAY");
			 System.out.println("\n6.EXIT");
			 System.out.println("\n enter ur choice : ");
			 switch(in.nextInt())
				{
				 case 1: 
					 System.out.println("\nenter the value ");
					 head=s.push(in.nextInt(),head);
					 break;
				 case 2: 
					 head=s.pop(head);
					 break;
				 
				case 3: 
				System.out.println("\n top element : "+ s.peek(head));
					 break;
				 case 4: 
System.out.println("\n is empty : "+ s.isEmpty(head));
						 break;
				 case 5: s.display(head); 
						 break;
				 case 6: System.exit(0);
						 break;
				 default: System.out.println("\n Wrong Choice!");
						  break;
				}
			 System.out.println("\n do u want to cont... ");
			}while(in.nextInt()==1);

	}
}

```

Output
```
******** MENU *******

1.PUSH

2.POP

3.PEEK

4 IS EMPTY

5 DISPLAY

6.EXIT

 enter ur choice :
1

enter the value
12

 do u want to cont...
1

******** MENU *******

1.PUSH

2.POP

3.PEEK

4 IS EMPTY

5 DISPLAY

6.EXIT

 enter ur choice :
1

enter the value
56

 do u want to cont...
1

******** MENU *******

1.PUSH

2.POP

3.PEEK

4 IS EMPTY

5 DISPLAY

6.EXIT

 enter ur choice :
5

 list is :
56 12
 do u want to cont...
1

******** MENU *******

1.PUSH

2.POP

3.PEEK

4 IS EMPTY

5 DISPLAY

6.EXIT

 enter ur choice :
3

 top element : 56

 do u want to cont...
1

******** MENU *******

1.PUSH

2.POP

3.PEEK

4 IS EMPTY

5 DISPLAY

6.EXIT

 enter ur choice :
4

 is empty : false

 do u want to cont...
1
```