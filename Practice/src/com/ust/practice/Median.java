package com.ust.practice;

public class Median {
	
	public static void median(float[] data,int len) {
		if(data.length%2==0) {
			System.out.println((data[(len/2)]+data[(len/2)-1])/2);
			
		}
		else {
			System.out.println(data[len/2]);
		}
		
	}
	public static void main(String[] args) {
		float []data= {1,2,4,5,10,12,13,15};
		int len=data.length;
		median(data,len);
		
	}

}
