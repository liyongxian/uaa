package com.hollysys.hiadsp.common.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Storage<T> {
	// 仓库最大存储量
	private final int MAX_SIZE = 1000;

	// 仓库存储的载体
	private LinkedList<T> list = new LinkedList<T>();

	// 锁
	private final Lock lock = new ReentrantLock();

	// 仓库满的条件变量
	private final Condition full = lock.newCondition();

	// 仓库空的条件变量
	private final Condition empty = lock.newCondition();

	// 生产num个产品
	public void produce(T obj) {
		// 获得锁
		lock.lock();

		// 如果仓库剩余容量不足
		while (list.size() + 1 > MAX_SIZE) {
			try {
				// 由于条件不满足，生产阻塞
				full.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		list.add(obj);

		// 唤醒其他所有线程
		full.signalAll();
		empty.signalAll();

		// 释放锁
		lock.unlock();
	}

	/**
	 * 消费num个产品。如果队列中产品数小于sum，则全部消费完。
	 * @param num 
	 */
	public void consume(int num) {
		// 获得锁
		lock.lock();
		List<T> result = new ArrayList<T>();

		// 如果仓库存储量不足
		while (list.size() == 0) {
			try {
				empty.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 消费条件满足情况下，消费num个产品
		int size = Math.min(num, list.size());
		for (int i = 1; i <= size; ++i) {
			result.add(list.remove());
		}

		// 唤醒其他所有线程
		full.signalAll();
		empty.signalAll();

		// consumer
		if(result.size() > 0)
			this.consume(result);

		// 释放锁
		lock.unlock();
	}

	public abstract void consume(List<T> entities);

	// set/get方法
	public int getMAX_SIZE() {
		return MAX_SIZE;
	}

	public LinkedList<T> getList() {
		return list;
	}

	public void setList(LinkedList<T> list) {
		this.list = list;
	}
}