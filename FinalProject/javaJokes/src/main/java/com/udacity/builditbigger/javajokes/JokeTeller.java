package com.udacity.builditbigger.javajokes;

public class JokeTeller {

	private int count;

	public String tellJoke() {
		return "This is joke " + ++count;
	}
}