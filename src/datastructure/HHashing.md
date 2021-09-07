# Hashing
* Uses special Hash function
* A hash function maps element to an address for storage
* This provides constant-time access
* Collision is handled by collision resolution techniques
* Collision resolution technique
  - Chaining
  - Open Addressing

## Advantages
* The hash function helps in fetching element in constant time
* An efficient way to store elements

## Disadvantages
* Collision resolution increases complexity

## Applications
* Suitable for the application needs constant time fetching

## Demonstration of HashSet – to find string has unique characters

```java
import java.util.*;

class HashSetDemo1{

	static boolean isUnique(String s)
	{
		HashSet<Character> set =new HashSet<Character>();
		
		for(int i=0;i<s.length();i++)
		    {
				char c=s.charAt(i);
				if(c==' ')
					continue;
				if(set.add(c)==false)
					return false;
					
			}
			
		return true;
	}
	
	
	public static void main(String[] args)
	{
		String s="helo wqty ";
		boolean ans=isUnique(s);
		if(ans)
			System.out.println("string has unique characters");
		else
			System.out.println("string does not have unique characters");

		
		
	}
}
```
Output:
```
string has unique characters
```

## Demonstration of HashMap – count the characters in string

```java
import java.util.*;

class HashMapDemo
{

	static void check(String s)
	{
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++)
			{char c=s.charAt(i);
			 if(!map.containsKey(c))
				map.put(c,1);
			 else
				map.put(c,map.get(c)+1);
			}
			
		
		
		Iterator<Character> itr = map.keySet().iterator();
		while (itr.hasNext()) {
			Object x=itr.next();
			System.out.println("count of "+x+" : "+map.get(x));
		}
	}
	
	public static void main(String[] args)
	{
		String s="hello";
		check(s);
	}
}
```
Output
```
count of e : 1
count of h : 1
count of l : 2
count of o : 1
```

## Demonstration of HashTable – to find string has unique characters

```java
import java.util.*; 
class hashTabledemo { 
	public static void main(String[] arg) 
	{ 
		// creating a hash table 
		Hashtable<Integer, String> h = 
					new Hashtable<Integer, String>(); 

		Hashtable<Integer, String> h1 = 
					new Hashtable<Integer, String>(); 

		h.put(3, "Geeks"); 
		h.put(2, "forGeeks"); 
		h.put(1, "isBest"); 

		// create a clone or shallow copy of hash table h 
		h1 = (Hashtable<Integer, String>)h.clone(); 

		// checking clone h1 
		System.out.println("values in clone: " + h1); 

		// clear hash table h 
		h.clear(); 

		// checking hash table h 
		System.out.println("after clearing: " + h); 
				System.out.println("values in clone: " + h1); 


	} 
} 
```
Output
```
values in clone: {3=Geeks, 2=forGeeks, 1=isBest}
after clearing: {}
values in clone: {3=Geeks, 2=forGeeks, 1=isBest}
```
