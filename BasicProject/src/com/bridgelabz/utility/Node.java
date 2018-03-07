package com.bridgelabz.utility;

class Node<T>
{
	private T value;
	private Node<T> pointer;

	public Node(T value, Node<T> pointer) 
	{
		this.value = value;
		this.pointer = pointer;
	}
	
	public Node() 
	{
		super();
	}

	public T getValue() 
	{
		return value;
	}

	public void setValue(T value) 
	{
		this.value = value;
	}

	public Node<T> getPointer() 
	{
		return pointer;
	}

	public void setPointer(Node<T> pointer) 
	{
		this.pointer = pointer;
	}	
	
	@Override
	public String toString() 
	{
		return "Node [value=" + value + ", pointer=" + pointer + "]";
	}

}