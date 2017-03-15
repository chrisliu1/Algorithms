/**   
* @Title: Queue.java 
* @Package intro2Algorithm.chapter10 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年3月11日 下午7:58:33 
* @version V1.0   
*/
package intro2Algorithm.chapter10;

import java.util.Scanner;

/** 
* @ClassName: Queue 
* @Description: 队列，能够处理上溢与下溢
* @author wjliu1998@gmail.com
* @date 2017年3月11日 下午7:58:34 
*  
*/
public class Queue {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int state;
		System.out.println("Input the length of queue");
		int length = sc.nextInt();
		System.out.println("Input the head of queue");
		int head = sc.nextInt();
		EasyQueue queue = new EasyQueue(head, length);
		while(true){
			System.out.println("enqueue is 1, dequeue is 2");
			state = sc.nextInt();
			if(state == 1){
				System.out.println("Input a number");
				queue.enqueue(sc.nextInt());
			}
			else{
				System.out.println(queue.dequeue());
			}
			queue.display();
		}
		
	}
	
	public static class EasyQueue
	{
		private int tail;
		private int head;
		private int length;
		private static int[] queue;
		private boolean full;
		
		public EasyQueue(int head, int length){
			this.head = head-1;
			this.tail = this.head;
			this.length = length;
			this.queue = new int[length];
			this.full = false;
		}
		
		public void enqueue(int x){
			if(this.tail == this.head && this.full == true)
				System.out.println("The queue is full");
			else{
				queue[this.tail] = x;
				if(this.tail == this.length-1){
					this.tail = 0;
				}
				else this.tail += 1;
			}
			
			if(this.tail == this.head){
				this.full = true;
			}
			else{
				this.full = false;
			}
		}
		
		public String dequeue(){
			if(this.head == this.tail && this.full == false) return "The queue is empty"; 
			
			int x = queue[this.head];
			queue[this.head] = 0;
			 
			if(this.head == this.length-1) {
				this.head = 0;
			}
			else {
				this.head += 1;
			}
			return Integer.toString(x);
		}
		
		public void display(){
			for(int number: queue){
					System.out.print(number);
			}
		}
		
		
	}
	
}
