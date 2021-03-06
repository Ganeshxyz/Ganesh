/**
 * Purpose Distributing cards to 4 players using 2D array
 * @author Ganesh
 * @since 15 March 2018
 */
package com.bridgelabz.objectoriented;

import com.bridgelabz.utility.Utility;

public class DeckOfCards 
{
	public static void main(String[] args) 
	{
		String suit[]={"Clubs","Diamonds","Hearts","Spades"};
		String rank[]={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		String non_shuffled_cards[][]=new String [52][2];
		int row=0,column=0;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<13;j++)
			{
				non_shuffled_cards[row][column]=suit[i];
				non_shuffled_cards[row][column+1]=rank[j];
				row++;
			}
		}
		String distribute_cards[][]=Utility.deckOfCards(non_shuffled_cards,suit,rank);
		distribute_cards=Utility.alignSpace(distribute_cards);
		System.out.println("Distributed Cards=");
		for(int i=0;i<14;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(distribute_cards[i][j]+"  ");
			}
			System.out.println();
		}
	}
}