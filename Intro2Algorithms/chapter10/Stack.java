/**   
* @Title: Stack.java 
* @Package intro2Algorithm.chapter10 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年3月7日 下午9:46:47 
* @version V1.0   
*/
package intro2Algorithm.chapter10;

import java.util.ArrayList;
import java.util.Scanner;

/** 
* @ClassName: Stack 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年3月7日 下午9:46:47 
*  
*/
public class Stack {
	public static void main(String[] args)
	{
		/*EasyStack easyStack = new EasyStack(6);
		System.out.println("Input a number to push or a '-' to pop ");
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String number = sc.next();
			if(number.equals("-"))
				System.out.println(easyStack.pop());
			else
				easyStack.push(Integer.valueOf(number));
			easyStack.display();
		}*/
		Scanner sc = new Scanner(System.in);
		CombinedStack stack = new CombinedStack(10);
		while(true)
		{
			System.out.print("Select the stack:");
			int stackName = sc.nextInt();
			System.out.print("Input a number to push or a '-' to pop:");
			String number = sc.next();
			if(number.equals("-"))
				System.out.println(stack.pop(stackName));
			else
				stack.push(stackName, Integer.valueOf(number));
			stack.display();
		}
	}
}

/**
 * 
* @ClassName: EasyStack 
* @Description: 简单的栈
* @author wjliu1998@gmail.com
* @date 2017年3月9日 下午7:37:32 
*
 */
class EasyStack
{
	private int top;
	private int[] stack;
	private int size;
	
	public EasyStack(int size)
	{
		this.top = -1;
		this.stack = new int[size];
		this.size = size;
	}
	
	public boolean stackEmpty()
	{
		if(this.top == -1)
			return true;
		else return false;
	}
	
	public boolean stackFull()
	{
		if(this.top == this.size-1)
			return true;
		else
			return false;
	}
	
	public void push(int s)
	{
		if(stackFull()) System.out.println("Stack is full");
		else
		{
			this.top += 1;
			this.stack[this.top] = s;
		}
	}
	
	public String pop()
	{
		if(stackEmpty())
		{
			return "underflow";
		}
		else
		{
			this.top = this.top - 1;
			return "You get " + Integer.toString(this.stack[this.top+1]);
		}
	}
	
	public void display()
	{
		int count = 0;
		System.out.println("Remain numbers");
		for(int number:stack)
			if(number != 0 && count <= this.top)
			{
				System.out.print(number + " ");
				count++;
			}
	}
}
	
	/**
	 * 在一个数组中实现两个栈
	* @ClassName: CombinedStack 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author wjliu1998@gmail.com
	* @date 2017年3月9日 下午7:48:02 
	*
	 */
class CombinedStack
{
		private int top1;
		private int top2;
		private int[] combinedStack;
		private int size;
		private static Scanner sc = new Scanner(System.in);
		
		public CombinedStack(int size)
		{
			this.top1 = -1;
			this.top2 = size;
			this.combinedStack = new int[size];
			this.size = size;
		}
		
		public boolean stack1Empty()
		{
			if(this.top1 == -1)
				return true;
			else return false;
		}
		
		public boolean stack2Empty()
		{
			if(this.top2 == this.size)
				return true;
			else return false;
		}
		
		public boolean stackFull()
		{
			if(this.top2 == this.top1 + 1)
				return true;
			else
				return false;
		}
		
		public void push(int stackName, int s)
		{
			if(stackName == 1)
			{
				if(stackFull()) System.out.println("Stack is full");
				else
				{
					this.top1 += 1;
					this.combinedStack[this.top1] = s;
				}
			}
			else
			{
				if(stackFull()) System.out.println("Stack is full");
				else
				{
					this.top2 -= 1;
					this.combinedStack[this.top2] = s;
				}
			}
		}
		
		public String pop(int stackName)
		{
			if(stackName == 1)
			{
				if(stack1Empty())
				{
					return "underflow";
				}
				else
				{
					this.top1 = this.top1 - 1;
					return "You get " + Integer.toString(this.combinedStack[this.top1+1]);
				}
			}
			else
			{
				if(stack2Empty())
				{
					return "underflow";
				}
				else
				{
					this.top2 = this.top2 + 1;
					return "You get " + Integer.toString(this.combinedStack[this.top2-1]);
				}
			}
		}
		
		public void display()
		{
			int count = 0;
			System.out.println("Remain numbers");
			for(int number:combinedStack)
			{
				if(number != 0 && count <= this.top1)
				{
					System.out.print(number + " ");
					count++;
				}
				else if(number != 0 && count >= this.top2)
				{
					System.out.print(number + " ");
					count++;
				}
				else
					count++;
			}
		}
}

