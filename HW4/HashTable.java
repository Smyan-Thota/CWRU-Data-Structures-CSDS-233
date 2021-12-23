package HW4;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.LinkedList;

//node class to create a new node
class Node{
	
	//string to store the key
	String key;
	//int to store the value of the node
	int value;
	//node pointer to point to the next node
	Node next;

	//constructor to create an object of node class with key and value input
	public Node(String key, int value) {
	this.key=key;
	this.value=value;

	}//end of constructor class
	
	@Override
    public String toString()
    {
        return "(" + this.key + ": " + this.value + ")";
    }
}//end of node class

//hashtable class to represent the table
class HashTable {

	//array to store objects of node type
	private LinkedList<Node>[] hashtable;
	//length of the array
	private int length;
	
	//constructor to create an object of the type hash table
	public HashTable(int length) {
		
		this.length=length;
		this.hashtable = new LinkedList[this.length];
	}
	//checks the size of the linked list
	public int size() {
		return hashtable.length;
	}
	//checks if the linked list is empty
	public boolean isEmpty() {
		return size()==0;
	}
	
	//helper method to find the position of a node given the key and the value
	private int position(String key, int value) {
		if(hashtable[value]==null)
			return -1;
		
		for(int j=0;j<hashtable[value].size();j++) 
		{
			if(hashtable[value].get(j).key.equals(key))	
				return j;
		}
		return -1;
	}
	//has function that finds the index for a given key
	private int getindex(String key)
    {
        int value = (key.hashCode() % size());
        if(value < 0)
            value += size();
        return value;
    }
	//function to check if rehashing is neccessary
	private boolean rehashCheck() {
		for(int j=0;j<size();j++)
		{
			if(hashtable[j].size() > size() && hashtable[j]!=null)
				return true;
		}
		return false;
	}
	
	
	//insert method to insert a key and a value into hashtable 
		public void insert(String key, int value)
		{
			int index = getindex(key);
			int position = position(key,value);
			
			if(position!= -1) {
				hashtable[index].get(position).value++;
			}
			
			else {
				hashtable[index].add(new Node(key,value));
			}
			
			if(this.rehashCheck())
				this.rehasher();		
		}
		
	//rehashing helper function
	private void rehasher() {
		HashTable newhashtable = new HashTable(this.hashtable.length*2);
		
		for(int i=0;i<size();i++)
		{	
			 if(hashtable[i] != null)
	            {
				 	//utilising iterator function
	                Iterator<Node> iter = hashtable[i].iterator();
	                while(iter.hasNext())
	                {
	                    Node node = iter.next();
	                    newhashtable.insert(node.key,node.value);
	                }
	            }
			
		}
		
		this.hashtable = newhashtable.hashtable;
	}
	

	
	
	//wordcounter 
	public void wordcounter(String input) {
		String ar[] = input.split("\\P{Alpha}+");
		Hashtable newhashtable = new Hashtable(ar.length);
		for(int i=0;i<ar.length;i++) {
			if(position(ar[i],getindex(ar[i]))!=-1) {	
			}	
		}	
	}		
}
