/**   
* @Title: SingleLinkedList.java 
* @Package intro2Algorithm.chapter10 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年3月15日 下午8:01:50 
* @version V1.0   
*/
package intro2Algorithm.chapter10;

import java.util.Scanner;

/** 
* @ClassName: SingleLinkedList 
* @Description: 单向链表，并用单向链表实现栈和队列 
* @author wjliu1998@gmail.com
* @date 2017年3月15日 下午8:01:50 
*  
*/
public class SingleLinkedListProblem {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SingleLinkedList L = new SingleLinkedList(0, null);
		while(true){
			System.out.print("Insert is 1, delete is 2, reverse is 3:");
			int number = sc.nextInt();
			if(number == 1){
				System.out.print("Input the number:");
				SingleLinkedList Node = new SingleLinkedList(sc.nextInt(), null);
				L.insert(L, Node);
			}
			else if(number == 2){
				System.out.print("Input the number:");
				L.delete(L, L.search(L, sc.nextInt()));
			}
			else{
				L.reverse();
			}
			L.display(L);
		}
		/*ListStack stack = new ListStack();
		while(true){
			System.out.print("Insert is 1, delete is 2:");
			if(sc.nextInt() == 1){
				System.out.print("Input the number:");
				SingleLinkedList Node = new SingleLinkedList(sc.nextInt(), null);
				stack.push(stack.head, Node);
			}
			else{
				System.out.print("Input the number:");
				stack.pop();
			}
			stack.display(stack.head);
		}*/
		/*ListQueue queue = new ListQueue();
		while(true){
			System.out.print("Insert is 1, delete is 2:");
			if(sc.nextInt() == 1){
				System.out.print("Input the number:");
				SingleLinkedList Node = new SingleLinkedList(sc.nextInt(), null);
				queue.enqueue(Node);
			}
			else{
				System.out.print("Input the number:");
				queue.dequeue();
			}
			queue.display();
		}*/
	}
}

class SingleLinkedList{
	public int key;
	public SingleLinkedList next;
	public SingleLinkedList head = null;
	public SingleLinkedList(int key, SingleLinkedList next){
		this.key = key;
		this.next = next;
	}
	
	public SingleLinkedList search(SingleLinkedList L, int key){
		SingleLinkedList x = L.head;
		while(x != null && x.key != key){
			x = x.next;
		}
		return x;
	}
	
	public void insert(SingleLinkedList L, SingleLinkedList x){
		x.next = L.head;
		L.head = x;
	}
	
	public void delete(SingleLinkedList L, SingleLinkedList x){
		SingleLinkedList crusor = L.head;
		if(crusor.key == x.key){
			L.head = crusor.next;
			crusor.next = null;
		}
		else{
			while(crusor.next.key != x.key && crusor.next != null){
				crusor = crusor.next;
			}
			crusor.next = x.next;
			x.next = null;
		}
	}
	
	public void display(SingleLinkedList L){
		SingleLinkedList x = L.head;
		while(x != null){
			System.out.print(x.key);
			x = x.next;
		}
		System.out.println();
	}
	
	public void reverse(){
		SingleLinkedList current = null;
		SingleLinkedList next = this.head;
		this.head = null;
		
		while(next != null){
	        current = next;
	        next = next.next;
	        current.next = this.head;
	        this.head = current;
		}
	}
}

class ListStack{
	public SingleLinkedList head = null;
	public ListStack(){
		this.head = new SingleLinkedList(0, null);
	}
	
	public void push(SingleLinkedList head, SingleLinkedList x){
		head.insert(head, x);
	}
	
	public void pop(){
		head.delete(this.head, this.head.head);
	}
	
	public void display(SingleLinkedList L){
		SingleLinkedList x = L.head;
		while(x != null){
			System.out.print(x.key);
			x = x.next;
		}
		System.out.println();
	}
}

class ListQueue{
	private SingleLinkedList top = null;
	private SingleLinkedList tail = null;
	public ListQueue(){
		this.top = null;
		this.tail = null;
	}
	
	public void enqueue(SingleLinkedList x){
		if(this.top == null && this.tail == null){
			this.top = x;
			this.tail = x;
		}
		else{
			this.tail.next = x;
			this.tail = x;
		}
	}
	
	public void dequeue(){
		 if(this.top == this.tail){
			 this.top = null;
			 this.tail = null;
		 }
		 else{
		 int x = this.top.key;
		 this.top = this.top.next;
		 System.out.println(x);
		 }
	}
	
	public void display(){
		SingleLinkedList x = this.top;
		while(x != null){
			System.out.print(x.key);
			x = x.next;
		}
		System.out.println();
	}
}