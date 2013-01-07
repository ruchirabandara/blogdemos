package com.ruchira.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StrategyExecutor {

	//private Collection<IStrategy> iStrategies = new ArrayList<IStrategy>();
	private Collection<Future<IStrategy>> iStrategies = new ArrayList<Future<IStrategy>>();
	private int CONCURRENT_RUNS = 5;
	private ExecutorService executorService = Executors
			.newFixedThreadPool(CONCURRENT_RUNS);;

	public synchronized void setStrategy(IStrategy strategy) {
		if (iStrategies.size() < CONCURRENT_RUNS) {
			//iStrategies.add(strategy);
			iStrategies.add(executorService.submit(strategy, strategy));
		} else {
			System.out.println("Strategy Executor is at capacity!");
		}

	}

	public void runStrategies() {
		for (Future<IStrategy> iStrategy : iStrategies) {
			try {
				System.out.println(iStrategy.get().getString());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//executorService.shutdown();
		clearStrategies();
		//reInitializerExecutor();
	}

	public void clearStrategies() {
		iStrategies = Collections.emptyList();
	}
	private void reInitializerExecutor(){
		executorService = Executors
				.newFixedThreadPool(CONCURRENT_RUNS);
	}
}
