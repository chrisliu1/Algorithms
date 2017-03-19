/**   
* @Title: Stacks2Queue.java 
* @Package intro2Algorithm.chapter10 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年3月13日 下午7:15:25 
* @version V1.0   
*/
package intro2Algorithm.chapter10;

import java.util.Scanner;
import java.util.Stack;

import javax.management.RuntimeErrorException;
/** 
* @ClassName: Stacks2Queue 
* @Description: 用两个栈实现一个队列
* 方法：
* 有两个栈A与B，将B作为缓冲栈
* 入队时，进行stack1.push
* 出队时，先检查是否两个栈都为空
* 若A为空B不空，进行stack2.pop
* 若A不为空B为空，将A中的值倒入B再stack2.pop
* 入队时复杂度为O(1)，出队为O(n)
* 
* 两个队列实现一个栈与此类似
* @author wjliu1998@gmail.com
* @date 2017年3月13日 下午7:15:25 
*  
*/
public class Stacks2Queue {
	static Stack<Integer> stack1 = new Stack<>();
	static Stack<Integer> stack2 = new Stack<>();
	
	public void push(int n){
		stack1.push(new Integer(n));
	}
	
	public int pop(){
		if(stack1.empty() && stack2.empty())
			throw new RuntimeException("Queue is empty");
		
		if(stack2.empty()){
			while(!stack1.empty())
				stack2.push(stack1.pop());
		}
		
		return stack2.pop();
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Stacks2Queue queue = new Stacks2Queue();
		while(true){
			System.out.print("Push is 1, Pop is 2:");
			if(sc.nextInt() == 1){
				System.out.println("Input a number:");
				queue.push(sc.nextInt());
			}
			else{
				System.out.println(queue.pop());
			}
			
			for(int number: stack1){
				System.out.print(number);
			}
			System.out.println();
			for(int number: stack2){
				System.out.println(number);
			}
		}
	}
}
