# Heap
* Binary Heap can be visualized array as a complete binary tree
* Arr[0] element will be treated as root
* length(A) – size of array
* heapSize(A) – size of heap
* Generally used when we are dealing with minimum and maximum elements
* For ith node

  | (i-1)/2 | Parent      |
  |---------|-------------|
  | (2*i)+1	| Left child  |
  | (2*i)+2	| Right Child |

## Advantages
* Can be of 2 types: min heap and max heap
* Min heap keeps smallest and element and top and max keeps largest
* O(1) for dealing with min or max elements

## Disadvantages
* Random access not possible
* Only min or max element is available for accessibility

## Applications
* Suitable for applications dealing with priority
* Scheduling algorithm
* caching

## Demonstration of Max Heap

```java
import java.util.*;


class Heap{

	int heapSize;
	
	void build_max_heap(int[] a)
	{
		heapSize=a.length;
		for(int i=(heapSize/2);i>=0;i--)
			max_heapify(a,i);
		
	}
	
	void max_heapify(int[] a,int i)
	{
		int l=2*i+1;
		int r=2*i+2;
		int largest=i;
		if(l<heapSize &&a[l]>a[largest])
			largest=l;
		if(r<heapSize &&a[r]>a[largest])
			largest=r;
		if(largest!=i)
		{
			int t=a[i];
			a[i]=a[largest];
			a[largest]=t;
		    max_heapify(a,largest);
		}
		
	}
	
	//to delete the max element
	
	int extract_max(int[] a)
	{
		if(heapSize<0)
			System.out.println("underflow");
		int max=a[0];
		a[0]=a[heapSize-1];
		heapSize--;
		max_heapify(a,0);
		return max;
	}
	
	void increase_key(int[] a,int i,int key)
	{
		if(key<a[i])
			System.out.println("error");
		a[i]=key;
		while(i>=0 && a[(i-1)/2]<a[i])
		{
			int t=a[(i-1)/2];
			a[(i-1)/2]=a[i];
			a[i]=t;
			
			i=(i-1)/2;
		}
	}
	
	void print_heap(int a[])
	{
		for(int i=0;i<heapSize;i++)
		    System.out.println(a[i]+" ");
	}
}
	
public class HeapDemo{
	
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int a[]=new int[n];
		
		System.out.println("enter the elements of array");
		
		for(int i=0;i<n;i++)
		  a[i]=in.nextInt();
	         Heap ob=new Heap();
		
		ob.build_max_heap(a);
		ob.print_heap(a);
		
		
		System.out.println("maximum element is : "+ob.extract_max(a));
		ob.print_heap(a);
		System.out.println("maximum element is : "+ob.extract_max(a));
		ob.increase_key(a,6,800);
		ob.print_heap(a);
		   
	}

}
```

Output
```
7
enter the elements of array
50 100 10 1 3 20 5
100
50
20
1
3
10
5
maximum element is : 100
50
5
20
1
3
10
maximum element is : 50
800
5
20
1
3
```