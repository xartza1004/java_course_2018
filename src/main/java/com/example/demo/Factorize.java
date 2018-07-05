package com.example.demo;

public class Factorize {

	public String of(int input) {
		String result = ".";

		while (input > 1) {
			for (int i = 2; i <= input; i++) {
				if (input % i == 0) {
					result = result.concat(", ").concat(Integer.toString(i));
					input /= i;
					break;
				}
			}
		}

		return result.substring(3);
	}

}
