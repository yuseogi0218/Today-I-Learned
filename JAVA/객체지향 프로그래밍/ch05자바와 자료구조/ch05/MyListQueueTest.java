package Chapter5.ch05;

public class MyListQueueTest {

	public static void main(String[] args) {

		MyListQueue listQueue = new MyListQueue();
		listQueue.enQueue("A");
		listQueue.enQueue("B");
		listQueue.enQueue("C");
		listQueue.enQueue("D");
		listQueue.enQueue("E");
		
		System.out.println(listQueue.deQueue()); // 가장 먼저 들어온 A 가 제거 됨.
		listQueue.printAll();
	}
}
