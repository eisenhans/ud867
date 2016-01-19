package com.udacity.builditbigger.javajokes;

public class JokeTeller {

	private int count;

	public String tellJoke() {
		String joke = "This is joke " + ++count;
		System.out.println("Telling joke: " + joke);

		return joke;
	}
}