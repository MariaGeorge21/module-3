package com.ust.practice;

import java.util.Scanner;

public class EvenOdd {
	public static void oddeven(int array[],int even[],int odd[],int oddeven[]) {
		int c=0;
		int len=0;
		
		for(int i=0;i<array.length;i++) {
			if(array[i]%2==0) {
				c++;
				
				/*
				 * even[i]=array[i]; System.out.println(even[i]);
				 */
			}
			else {
				continue;
			}
			
			
		}
		System.out.println("Even array is");
		for(int k=0;k<array.length;k++)
		{
			if(array[k]%2==0) {
				even[k]=array[k];
				System.out.println(even[k]);
			}
		}
		
		System.out.println("Odd array is");
		for(int j=0;j<array.length;j++) {
			if(array[j]%2!=0) {
				odd[j]=array[j];
				System.out.println(odd[j]);
			}
			else {
				continue;
			}
		}
		System.out.println("mergered array is");
		for(int l=0;l<array.length;l++)
		{
			for(int k=0;k<array.length;k++)
			{
				oddeven[l]=even[k];
				len=oddeven.length;
			
			}
			for(int n=len;n<array.length;n++)
			{
				oddeven[l]=odd[n];
			
			}
		
			
		}
		for(int l=0;l<oddeven.length;l++) {
			System.out.println(oddeven[l]);
		}
		
		
		
		
		
			
		}
	
	
	

	public static void main(String[] args) {
	 int []array= {1,2,3,4,5,6,7,8,9,10};
	 int []odd=new int [10];
	 int []even=new int[10];
	 int []oddeven=new int[10];
	
		
		
		oddeven(array,even,odd,oddeven);
		

	}

}
