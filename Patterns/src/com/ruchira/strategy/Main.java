package com.ruchira.strategy;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StrategyOne strategyOne = new StrategyOne();
		StrategyTwo strategyTwo = new StrategyTwo();
		StrategyExecutor strategyExecutor = new StrategyExecutor();
		strategyExecutor.setStrategy(strategyOne);
		/*strategyExecutor.setStrategy(strategyTwo);
		strategyExecutor.setStrategy(strategyOne);
		strategyExecutor.setStrategy(strategyTwo);
		strategyExecutor.setStrategy(strategyOne);
		strategyExecutor.setStrategy(strategyTwo);*/
		strategyExecutor.runStrategies();
		System.out.println("run two");
		strategyExecutor.setStrategy(strategyOne);
		strategyExecutor.runStrategies();
	}

}
