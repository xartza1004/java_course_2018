package com.example.demo.solid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FizzBuzz {

    public String say(int input) {
    	// Register conditions
    	List<Condition> conditions = new ArrayList<>();
    	conditions.add(new FizzBuzzCondition());
    	conditions.add(new FizzCondition());
    	conditions.add(new BuzzCondition());
    	conditions.add(new KBTGCondition());
    	
    	conditions.add(new DefaultCondition());
    	
    	// Process
    	
    	/*for (Condition condition : conditions) {
    		if (condition.check(input)) {
    			return condition.say(input);
    		}
    	}
    	throw new RuntimeException("Condition not match");*/
    	
    	return conditions.parallelStream()
    	.filter(c -> c.check(input))
    	.map(c -> c.say(input))
    	.collect(Collectors.toList()).get(0);
    	
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

        /*return canDivide15(input) ? "FizzBuzz"
                : canDivide3(input) ? "Fizz"
                : canDivide5(input) ? "Buzz"
                : Integer.toString(input);*/
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
