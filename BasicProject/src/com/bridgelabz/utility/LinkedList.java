package com.bridgelabz.utility;


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
	public boolean searchInteger(T value)
	{
		Node<T> temp=start;
		do
		{
			if(temp.getValue()==value)
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
	public String listToString()
	{
		Node<T> temp=start;
		String tostring=null;
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

}