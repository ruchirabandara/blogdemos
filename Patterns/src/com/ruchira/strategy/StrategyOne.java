package com.ruchira.strategy;

public class StrategyOne implements IStrategy {
	private String string;

	public void run() {
		double d = Math.random();
		System.out.println("Strategy " + d + " Run");
		this.string = "Strategy " + d + " Result";
	}

	public String getString() {
		return string;
	}

}
