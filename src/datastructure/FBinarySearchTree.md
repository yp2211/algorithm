# Binary Search Tree

* Binary tree with the additional restriction
* Restriction:
  - The left child must always be less than the root node
  - The right child must always be greater than the root node
* Insertion, Deletion, Search is much more efficient than a binary tree

## Advantages
* Maintains order in elements
* Can easily find the min and max Nodes in the tree
* Inorder traversal gives sorted elements

## Disadvantages
* Random access not possible
* Ordering adds complexity

## Applications
* Suitable for sorted hierarchical data

## Demonstration of Binary Search Tree
```java
class TLNode{

	int data;
	TLNode left,right;
	
	TLNode(int d)
	{
		data=d;
	}
 }
 
 public class BST{
 
	TLNode root;
	
	TLNode insert(int d,TLNode root)
	{
	  if(root==null)
	    root=new TLNode(d);
	  
      else if(d<=root.data)
		root.left=insert(d,root.left);
	
	  else
		root.right=insert(d,root.right);
	
	  return root;
	}
	
	TLNode search(int d,TLNode root)
	{
		if(root.data==d)
			return root;
		else if(d<root.data)
			return search(d,root.left);
	    else
			return search(d,root.right);
	}
	
	
	
	void inorder(TLNode r)
   {
		if(r==null)
		    return;
		
		
		inorder(r.left);
		System.out.println(r.data);
		inorder(r.right);
		
   }
   

TLNode delete(TLNode root, int data) 
    { 
        
        if (root == null)  return root; 
 
        if (data < root.data) 
            root.left = delete(root.left, data); 
        else if (data > root.data) 
            root.right = delete(root.right, data); 
  
        else
        { 
            
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            
            root.data = minValue(root.right); 
  
            root.right = delete(root.right, root.data); 
        } 
  
        return root; 
    } 	
   int minValue(TLNode root) 
    { 
        int minv = root.data; 
        while (root.left != null) 
        { 
            minv = root.left.data; 
            root = root.left; 
        } 
        return minv; 
    } 

   
   public static void main(String[] args)
   {
		BST ob=new BST();
		ob.root=ob.insert(50,ob.root); 
                ob.root=ob.insert(30,ob.root); 
                ob.root=ob.insert(20,ob.root); 
                ob.root=ob.insert(20,ob.root); 
                ob.root=ob.insert(70,ob.root); 
                ob.root=ob.insert(60,ob.root); 
                ob.root=ob.insert(80,ob.root);    
		ob.root=ob.delete(ob.root,50);
		System.out.println("******" +ob.root.data);
		ob.inorder(ob.root);
		
		TLNode find=ob.search(30,ob.root);
		if(find==null)
			System.out.println("not found");
		else
			System.out.println("found : "+find.data);
		
		
	}
}
```
  
Output:

```  
******60
20
20
30
60
70
80
found : 30
```
