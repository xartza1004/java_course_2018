package com.example.demo;

public class FizzBuzz {

    public static void main(String[] args) {
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

    public String say(int input) {
        /*String word = Integer.toString(input);

        if(canDivide15(input)) {
            word = "FizzBuzz";
        } else if(canDivide3(input)) {
            word = "Fizz";
        } else if(canDivide5(input)) {
            word = "Buzz";
        }

       return word;*/

        /*int[] numbers = {15, 3, 5};
        String[] words = {"FizzBuzz", "Fizz", "Buzz"};

        for(int i = 0; i < 3; i++) {
            if(input % numbers[i] == 0) {
                return words[i];
            }
        }

        return Integer.toString(input);*/

        return canDivide15(input) ? "FizzBuzz"
                : canDivide3(input) ? "Fizz"
                : canDivide5(input) ? "Buzz"
                : Integer.toString(input);

    }

    private boolean canDivide15(int input) {
        return input % 15 == 0;
    }

    private boolean canDivide3(int input) {
        return input % 3 == 0;
    }

    private boolean canDivide5(int input) {
        return input % 5 == 0;
    }
}
