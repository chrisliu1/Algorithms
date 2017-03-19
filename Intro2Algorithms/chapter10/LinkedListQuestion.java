/**   
* @Title: LinkedListQuestion.java 
* @Package intro2Algorithm.chapter10 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年3月15日 下午6:44:59 
* @version V1.0   
*/
package intro2Algorithm.chapter10;

import java.util.Scanner;

/** 
* @ClassName: LinkedListQuestion 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年3月15日 下午6:44:59 
*  
*/
public class LinkedListQuestion {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		/*LinkedList L = new LinkedList(null, 0, null);
		while(true){
			System.out.print("Insert is 1, delete is 2:");
			if(sc.nextInt() == 1){
				System.out.print("Input the number:");
				LinkedList Node = new LinkedList(null, sc.nextInt(), null);
				L.insert(L, Node);
			}
			else{
				System.out.print("Input the number:");
				L.delete(L, L.search(L, sc.nextInt()));
			}
			L.display(L);
		}*/
		SentinalLinkedList L = new SentinalLinkedList(null, 0, null);
		SentinalLinkedList sentinal = new SentinalLinkedList(null, 10000,null);
		sentinal.setSentinal(sentinal);
		L.nil = sentinal;

		while(true){
			System.out.print("Insert is 1, delete is 2:");
			if(sc.nextInt() == 1){
				System.out.print("Input the number:");
				SentinalLinkedList Node = new SentinalLinkedList(null, sc.nextInt(), null);
				L.insert(L, Node);
			}
			else{
				System.out.print("Input the number:");
				L.delete(L, L.search(L, sc.nextInt()));
			}
			L.display(L);
		}
	}

	/** 
	 * @Title: setSentinal 
	 * @Description: TODO
	 * @param sentinal void 
	 * @throws 
	 */

}

/**
 * 
* @ClassName: LinkedList 
* @Description: 双向链表
* @author wjliu1998@gmail.com
* @date 2017年3月15日 下午7:25:13 
*
 */
class LinkedList{
	private LinkedList prev;
	private int key;
	private LinkedList next;
	private LinkedList head = null;
	public LinkedList(LinkedList prev, int key, LinkedList next){
		this.prev = prev;
		this.key = key;
		this.next = next;
	}
	
	public LinkedList search(LinkedList L, int key){
		LinkedList x = L.head;
		while(x != null && x.key != key){
			x = x.next;
		}
		return x;
	}
	
	public void insert(LinkedList L, LinkedList x){
		x.next = L.head;
		if(L.head != null) L.head.prev = x;
		L.head = x;
		x.prev = null;
	}
	
	public void delete(LinkedList L, LinkedList x){
		if(x.prev != null) x.prev.next = x.next;
		else L.head = x.next;
		if(x.next  != null) x.next.prev = x.prev;
	}
	
	public void display(LinkedList L){
		LinkedList x = L.head;
		while(x != null){
			System.out.print(x.key);
			x = x.next;
		}
		System.out.println();
	}
}

/**
 * 
* @ClassName: SentinalLinkedList 
* @Description: 带哨兵的链表 
* @author wjliu1998@gmail.com
* @date 2017年3月15日 下午8:00:48 
*
 */
class SentinalLinkedList{
	private SentinalLinkedList prev;
	private int key;
	private SentinalLinkedList next;
	public SentinalLinkedList nil = null;
	
	public SentinalLinkedList(SentinalLinkedList prev, int key, SentinalLinkedList next){
		this.prev = prev;
		this.key = key;
		this.next = next;
	}
	
	public void setSentinal(SentinalLinkedList sentinal){
		sentinal.prev = sentinal;
		sentinal.next = sentinal;
	}
	public SentinalLinkedList search(SentinalLinkedList L, int key){
		SentinalLinkedList x = L.nil.next;
		while(x != L.nil && x.key != key){
			x = x.next;
		}
		return x;
	}
	
	public void insert(SentinalLinkedList L, SentinalLinkedList x){
		x.next = L.nil.next;
		L.nil.next.prev = x;
		L.nil.next = x;
		x.prev = L.nil;
	}
	
	public void delete(SentinalLinkedList L, SentinalLinkedList x){
		x.prev.next = x.next;
		x.next.prev = x.prev;
	}
	
	public void display(SentinalLinkedList L){
		SentinalLinkedList x = L.nil.next;
		while(x != L.nil){
			System.out.print(x.key);
			x = x.next;
		}
		System.out.println();
	}
}
