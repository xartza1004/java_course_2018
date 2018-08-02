package com.example.demo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void สวัสดี_somkiat_when_input_is_somkiat() {
        Reception reception = new Reception();
        String actualResult = reception.get("somkiat");
        assertEquals("สวัสดี somkiat", actualResult);
    }

    @Test
    public void สวัสดี_tum_when_input_is_tum() {
        Reception reception = new Reception();
        String actualResult = reception.get("tum");
        assertEquals("สวัสดี tum", actualResult);
    }
    
    @Test
    public void just_test() {
    	
    }
    
    public String solution_1(String S, String C) {
    	List<String> result = new ArrayList<>();
        String lowerS = S.replace("-", "").toLowerCase();
        String mailFormat = "@".concat(C.toLowerCase()).concat(".com");
        
        String[] names = lowerS.split(", ");
        String[] splitName;
        String resultName;
        int n;
        for (String name : names) {
        	splitName = name.split(" ");
        	resultName = "".concat(String.valueOf(splitName[0].charAt(0))).concat("_").concat(splitName[splitName.length - 1]);
        	n = 1;
        	while (result.contains(resultName.concat(String.valueOf(n)))) {
        		n++;
        	}
        	result.add(resultName.concat(String.valueOf(n)));
        }
        
        return String.join(mailFormat.concat(", "), result).concat(mailFormat).replace("1@", "@");
    }
    
    public int solution_2(String S) {
    	String timeslot = "I 168h";
    	int result = 0;
    	
    	String[] periods = S.split("\n");
    	for (String period : periods) {
    		
    	}
    	
    	return result;
    }
    
    public int solution_3(String S) {
        int result = 0;
        int numOfWords;
        
        String replace;
        replace = S.replace(".", "!").replace("?", "!").replaceAll(" +", " ").replace("! ", "!");
        if (replace.startsWith(" ")) {
            replace = replace.substring(1);
        }
        
		String[] sentences = replace.split("!");
		for (String sentence : sentences) {
		    numOfWords = sentence.split(" ").length;
		    if (numOfWords > result) {
		        result = numOfWords;
		    }
		}
		
		return result;
    }
}
