package com.example.demo;

public class HelloDay2 {

	public static void main(String[] args) {
		System.out.println("Hello Day 2");
		
		int[] datas = {1, 2, 3, 4, 5};

        // Don't
        for(int i = 0; i < datas.length; i++) {
            System.out.println(datas[i]);
        }

        // Do
        int length = datas.length;
        for(int i = 0; i < length; i++) {
            System.out.println(datas[i]);
        }

        // Do
        int i = 0; //optional
        for(int data : datas) {
            System.out.println(data);
            i++; //optional
        }
	}

}
