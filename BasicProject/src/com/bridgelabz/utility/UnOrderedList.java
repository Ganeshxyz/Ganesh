package com.bridgelabz.utility;


public class UnOrderedList 
{
	Node start;
	Node end;
	int size;
	
	public UnOrderedList emptyList()
	{
		this.start=null;
		this.end=null;
		this.size=0;
		return this; 
	}
	
	public void add(int value)
	{
		Node newnode=new Node(value, null);
		size++;
		if(start==null)
		{
			start=newnode;
			end=start;
		}
		else
		{
			end.setPointer(start);
			end=newnode;
		}
	}
	public void remove(int value)
	{
		
	}
}

class Node<T>
{
	private int value;
	private Node pointer;
	
	public Node(int value, Node pointer) 
	{
		this.value = value;
		this.pointer = pointer;
	}

	public int getValue() 
	{
		return value;
	}

	public void setValue(int value) 
	{
		this.value = value;
	}

	public Node getPointer() 
	{
		return pointer;
	}

	public void setPointer(Node pointer) 
	{
		this.pointer = pointer;
	}	
}