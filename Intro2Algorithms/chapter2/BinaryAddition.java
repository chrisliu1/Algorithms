/**   
* @Title: BinaryAddition.java 
* @Package intro2Algorithm.chapter2 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author wjliu1998@gmail.com
* @date 2017��3��9�� ����9:27:22 
* @version V1.0   
*/
package intro2Algorithm.chapter2;

/** 
* @ClassName: BinaryAddition 
* @Description: TODO(������һ�仰��������������) 
* @author wjliu1998@gmail.com
* @date 2017��3��9�� ����9:27:22 
*  
*/
public class BinaryAddition {
	public static void main(String[] args)
	{
		String addend1 = "1110";
		String addend2 = "1111";
		System.out.println(Addition(addend1, addend2));
	}

	public static String Addition(String addend1, String addend2)
	{
		int flag = 0;
		int count = addend1.length()-1;
		String result = "";
		while(count >= 0)
		{
			if(addend1.charAt(count) == addend2.charAt(count))
			{
				if(addend1.charAt(count) == '0')
				{
					if(flag == 1)
					{
						result = "1" + result;
						flag = 0;
					}
					else
					{
						result = "0" + result;
						flag = 0;
					}
				}
				else
				{
					if(flag == 1)
					{
						result = "1" + result;
						flag = 1;
					}
					else
					{
						result = "0" + result;
						flag = 1;
					}
				}
			}
			else
			{
				if(flag == 1)
				{
					result = "0" + result;
					flag = 1;
				}
				else
				{
					result = "1" + result;
					flag = 0;
				}
			}
			count--;
		}
		if(flag == 1)
			result = "1" + result;
		else
			result = "0" + result;
		return result;
	}
}
