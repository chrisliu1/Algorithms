/**   
* @Title: BothwayQueue.java 
* @Package intro2Algorithm.chapter10 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年3月11日 下午9:18:04 
* @version V1.0   
*/
package intro2Algorithm.chapter10;

import java.util.Scanner;

import intro2Algorithm.chapter10.Queue.EasyQueue;

/** 
* @ClassName: BothwayQueue 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年3月11日 下午9:18:04 
*  
*/
public class BothwayQueue {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int state;
		String choosedSide;
		System.out.println("Input the length of queue");
		int length = sc.nextInt();
		System.out.println("Input the head of queue");
		int head = sc.nextInt();
		bothwayqueue queue = new bothwayqueue(length, head);
		while(true){
			System.out.println("enqueue is 1, dequeue is 2");
			state = sc.nextInt();
			if(state == 1){
				System.out.println("head is 1, tail is 2");
				if(sc.nextInt() == 1) choosedSide = "head";
				else				  choosedSide = "tail";
				System.out.println("Input a number");
				queue.enqueue(choosedSide, sc.nextInt());
			}
			else{
				System.out.println("head is 1, tail is 2");
				if(sc.nextInt() == 1) choosedSide = "head";
				else				  choosedSide = "tail";
				System.out.println(queue.dequeue(choosedSide));
			}
			queue.display();
		}
		
	}
	
	public static class bothwayqueue{
		private int head;
		private int tail;
		private int length;
		private boolean full;
		private static int[] queue;
		
		public bothwayqueue(int length, int head){
			this.length =length;
			this.head = head-1;
			this.tail = this.head;
			queue = new int[length];
			this.full = false;
		}
		
		public void enqueue(String choosedSide, int x){
			if(this.tail == this.head && this.full == true)
				System.out.println("The queue is full");
			else{
				if(choosedSide == "tail")
				{
					queue[this.tail] = x;
					if(this.tail == this.length-1){
						this.tail = 0;
					}
					else this.tail += 1;
				}
				else
				{	
					if(this.head == 0) this.head = this.length;
					this.head -= 1;
					queue[this.head] = x;
				}
			}
			
			if(this.tail == this.head){
				this.full = true;
			}
			else{
				this.full = false;
			}
		}
		
		public String dequeue(String choosedSide){
			int x;
			if(this.head == this.tail && this.full == false) return "The queue is empty"; 
			if(choosedSide == "head"){
				x = queue[this.head];
				queue[this.head] = 0;
				if(this.head == this.length-1) {
					this.head = 0;
				}
				else {
					this.head += 1;
				}
			}
			else{
				if(this.tail == 0){
					x = queue[this.length-1];
					queue[this.length-1] = 0;
					this.tail = length - 1;
				}
				else{
					x = queue[this.tail-1];
					queue[this.tail-1] = 0;
					this.tail -= 1;
				}
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
