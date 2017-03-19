/**   
* @Title: CircularLinkedListProblem.java 
* @Package intro2Algorithm.chapter10 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年3月19日 下午12:33:58 
* @version V1.0   
*/
package intro2Algorithm.chapter10;

import java.util.Scanner;

/** 
* @ClassName: CircularLinkedListProblem 
* @Description: 单向循环链表的实现
* @author wjliu1998@gmail.com
* @date 2017年3月19日 下午12:33:58 
*  
*/
public class CircularLinkedListProblem {
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	CircularLinkedList L = new CircularLinkedList(0, null);
	while(true){
		System.out.print("Insert is 1, delete is 2:");
		if(sc.nextInt() == 1){
			System.out.print("Input the number:");
			CircularLinkedList Node = new CircularLinkedList(sc.nextInt(), null);
			L.insert(L, Node);
		}
		else{
			System.out.print("Input the number:");
			L.delete(L, L.search(L, sc.nextInt()));
		}
		L.display(L);
	}
	}
}

class CircularLinkedList{
	public int key;
	public CircularLinkedList next;
	public CircularLinkedList head = null;
	public CircularLinkedList current = null;
	public CircularLinkedList(int key, CircularLinkedList next){
		this.key = key;
		this.next = next;
	}
	
	public CircularLinkedList search(CircularLinkedList L, int key){
		CircularLinkedList x = L.head;
		while(x != null && x.key != key){
			x = x.next;
		}
		return x;
	}
	
	public void insert(CircularLinkedList L, CircularLinkedList x){
		if(L.head == null) {
			x.next = x;
			L.head = x;
			L.current = x;
		}
		else{
			x.next = L.head;
			L.current.next = x;
			L.current = x;
		}
	}
	
	public void delete(CircularLinkedList L, CircularLinkedList x){
		if(L.head == null) System.out.println("LinkedList is empty");
		else{
			CircularLinkedList crusor = L.head;
			do{
				crusor = crusor.next;
			}
			while(crusor.next.key != x.key);

			if(L.current == L.head) L.current = L.head = null;
			else{
				if(crusor.next == L.current) L.current = crusor;
				if(crusor.next == L.head) L.head = L.head.next;
			}
			
			crusor.next = x.next;
			x.next = null;
		}
	}
	
	public void display(CircularLinkedList L){
		if(L.head != null){
		CircularLinkedList x = L.head;
		do{
			System.out.print(x.key);
			x = x.next;
		}while(x != L.head);
		System.out.println();
		}
	}
}