/**   
* @Title: Stacks2Queue.java 
* @Package intro2Algorithm.chapter10 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author wjliu1998@gmail.com
* @date 2017��3��13�� ����7:15:25 
* @version V1.0   
*/
package intro2Algorithm.chapter10;

import java.util.Scanner;
import java.util.Stack;

import javax.management.RuntimeErrorException;
/** 
* @ClassName: Stacks2Queue 
* @Description: ������ջʵ��һ������
* ������
* ������ջA��B����B��Ϊ����ջ
* ���ʱ������stack1.push
* ����ʱ���ȼ���Ƿ�����ջ��Ϊ��
* ��AΪ��B���գ�����stack2.pop
* ��A��Ϊ��BΪ�գ���A�е�ֵ����B��stack2.pop
* ���ʱ���Ӷ�ΪO(1)������ΪO(n)
* 
* ��������ʵ��һ��ջ�������
* @author wjliu1998@gmail.com
* @date 2017��3��13�� ����7:15:25 
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
