# Arrays
* Linear Data Structure
* Elements are stored in contiguous memory locations
* Can access elements randomly using index
* Stores homogeneous elements i.e, similar elements

## Syntax:
Array declaration
* datatype varname[] = new datatype[size];  
* datatype[] varname = new datatype[size];

Can also do declaration and initialization at once
* Datatype varname [] = {ele1, ele2, ele3, ele4};

## Advantages
* Random access
* Easy sorting and iteration
* Replacement of multiple variables

## Disadvantages
* Size is fixed
* Difficult to insert and delete
* If capacity is more and occupancy less, most of the array gets wasted
* Needs **contiguous memory** to get allocated

## Applications
* For storing information in a linear fashion
* Suitable for applications that require frequent searching

## Demonstration of Array
```java
import java.util.*;

class JavaDemo {
	public static void main (String[] args) {
	    int[] priceOfPen = new int[5];
	    Scanner in = new Scanner(System.in);
	    for(int i = 0; i<priceOfPen.length; i++)
	        priceOfPen[i] = in.nextInt();

	    for(int i = 0; i < priceOfPen.length; i++)
		    System.out.print(priceOfPen[i] + " ");
	}
}
```
```
Input:
23 13 56 78 10

Output:
23 13 56 78 10
```

***
