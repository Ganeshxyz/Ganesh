package com.bridgelabz.utility;

class Node<T>
{
	private T mValue;
	private Node<T> mPointer;

	public Node(T value, Node<T> pointer) 
	{
		this.mValue = value;
		this.mPointer = pointer;
	}
	
	public Node() 
	{
		super();
	}

	public T getValue() 
	{
		return mValue;
	}

	public void setValue(T value) 
	{
		this.mValue = value;
	}

	public Node<T> getPointer() 
	{
		return mPointer;
	}

	public void setPointer(Node<T> pointer) 
	{
		this.mPointer = pointer;
	}	
	
	@Override
	public String toString() 
	{
		return "Node [value=" + mValue + ", pointer=" + mPointer + "]";
	}

}

public class LinkedList<T>
{
	Node<T> start;
	Node<T> end;
	int size;
	
	public Node<T> emptyList()
	{
		start=null;
		end=null;
		size=0;
		return start; 
	}
	
	public void add(T value)
	{
		Node<T> newnode=new Node<T>(value, null);
		size++;
		if(start==null)
		{
			start=newnode;
			end=start;
		}
		else
		{
			newnode.setPointer(start);
			start=newnode;
		}
	}
	public T getLastItem()
	{
		return end.getValue();
	}
	public T getFirstItem()
	{
		if(start!=null)
		{
			return start.getValue();
		}
		else
		{
			return null;
		}
	}
	public void removeFirst()
	{
		Node<T> temp=start;
		start.setPointer(start.getPointer());
		temp.setPointer(null);
	}
	public void remove(T value)
	{
		Node<T> temp=start;
		Node<T> prevpointer;
		size--;
		if(temp==end)
		{
			start=null;
			end=start;
		}
		else if(start.getValue().equals(value))
		{
			start=temp.getPointer();
			temp.setPointer(null);
		}
		else if(end.getValue().equals(value))
		{
			do
			{
				prevpointer=temp;
				temp=temp.getPointer();
			}
			while(temp!=end);
			end=prevpointer;
			prevpointer.setPointer(null);
		}
		else
		{
			do
			{
				prevpointer=temp;
				temp=temp.getPointer();
				if(temp.getValue().equals(value))
				{
					prevpointer.setPointer(temp.getPointer());
					temp.setPointer(null);
				}	
			}
			while(temp.getPointer()!=null);
		}
	}
	public void removeInteger(int value)
	{
		Node<T> temp=start;
		Node<T> prevpointer;
		size--;
		if(temp==end)
		{
			start=null;
			end=start;
		}
		else if(((int)start.getValue())==value)
		{
			start=temp.getPointer();
			temp.setPointer(null);
		}
		else if(((int)end.getValue())==value)
		{
			do
			{
				prevpointer=temp;
				temp=temp.getPointer();
			}
			while(temp!=end);
			end=prevpointer;
			prevpointer.setPointer(null);
		}
		else
		{
			do
			{
				prevpointer=temp;
				temp=temp.getPointer();
				if(((int)temp.getValue())==value)
				{
					prevpointer.setPointer(temp.getPointer());
					temp.setPointer(null);
				}	
			}
			while(temp.getPointer()!=null);
		}
	}
	public boolean search(T value)
	{
		Node<T> temp=start;
		do
		{
			if(temp.getValue().equals(value))
			{
				return true;
			}
			temp=temp.getPointer();
		}
		while(temp!=null);
		return false;
	}
	public boolean searchInteger(int value)
	{
		Node<T> temp=start;
		int a;
		do
		{
			a=(int)temp.getValue();
			if(a==value)
			{
				return true;
			}
			temp=temp.getPointer();
		}
		while(temp!=null);
		return false;
	}
	public int size()
	{
		return size;
	}
	public void append(T value)
	{
		Node<T> newnode=new Node<T>(value, null);
		size++;
		if(start==null)
		{
			start=newnode;
			end=start;
		}
		else
		{
			end.setPointer(newnode);
			end=newnode;
			newnode.setPointer(null);
		}
	}
	public void display()
	{
		Node<T> temp=start;
		if(size==0)
		{
			System.out.println("Empty");
		}
		else if(size==1)
		{
			System.out.println(start.getValue()+"  ");
		}
		else
		{
			do
			{
				System.out.println(temp.getValue());
				temp=temp.getPointer();
			}
			while(temp!=null);
		}
	}
	@Override
	public String toString()
	{
		Node<T> temp=start;
		String tostring="";
		if(start==null)
		{
			return "";
		}
		else if(start==end)
		{
			return ""+start.getValue();
		}
		else
		{
			do
			{
				tostring=""+tostring+""+temp.getValue()+" ";
				temp=temp.getPointer();
			}
			while(temp!=null);
		}
		return tostring;
	}
	public void order()
	{
		 T temp=null;
		 int a,b;
		 for(Node<T> i=start;i!=null;i=i.getPointer())
		 {
			 for(Node<T> j=i.getPointer();j!=null;j=j.getPointer())
			 {
				 a=(int)i.getValue();
				 b=(int)j.getValue();
				 if(a>b)
				 {
					 temp=i.getValue();
					 i.setValue(j.getValue());
					 j.setValue(temp);
				 }
			 }
		 }
	}
	public void orderString()
	{
		 T temp=null;
		 String a,b;
		 for(Node<T> i=start;i!=null;i=i.getPointer())
		 {
			 for(Node<T> j=i.getPointer();j!=null;j=j.getPointer())
			 {
				 a=(String)i.getValue();
				 b=(String)j.getValue();
				 if(a.compareTo(b)>0)
				 {
					 temp=i.getValue();
					 i.setValue(j.getValue());
					 j.setValue(temp);
				 }
			 }
		 }
	}
	public void reverseLinkedList()
	{
		LinkedList<T> list=new LinkedList<T>();
		for(Node<T> i=start;i!=null;i=i.getPointer())
		{
			list.add(i.getValue());
		}
		start=null;end=null;size=0;
		int capacity=list.size;
		for(int i=0;i<capacity;i++)
		{
			add(list.getLastItem());
			list.remove(list.getLastItem());
		}
	}
	public String[] retrieve()
	{
		String array[]=new String[size];
		int count=0;
		for(Node<T> i=start;i!=null;i=i.getPointer())
		{
			array[count]=(String)i.getValue();
			count++;
		}
		return array;
	}
}