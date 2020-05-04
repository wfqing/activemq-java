package com.etoak.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 测试BlockingQueue
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年3月27日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class TestBlockingQueue {
	public static void main(String[] args) {
		//TestAddAndRemove();
		
		
	}
	/**
	 * 测试add（e）和 remove()
	 * remove从队列中移除头部元素
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @see [类、类#方法、类#成员]
	 */
	public static void TestAddAndRemove() {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
		queue.add(1);
		queue.add(2);
		//queue.add(3);
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
	}
	
	public static void testOfferAndPoll() {
		
	}
	
	
}
