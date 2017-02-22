import java.util.LinkedList;
import java.util.Scanner;

/**   
* @Title: RSA.java 
* @Package  
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author wjliu1998@gmail.com
* @date 2017��2��22�� ����9:56:20 
* @version V1.0   
*/

/** 
* @ClassName: RSA 
* @Description: ԭ����ʵ��һ��RSA���ܣ������ڴ���ȡ��ķ������Ѿ�ʵ�ֵ���ȡ����������
* @author wjliu1998@gmail.com
* @date 2017��2��22�� ����9:56:20 
*  
*/
public class RSA {
	static LinkedList<Long> encryptedList = new LinkedList<>();
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("������Ҫ���������:");
		String cryptograph = sc.nextLine();
		Encryption(43, 59, cryptograph);
		System.out.print("���ܺ���ַ�Ϊ:");
		for(double encryptedNumber: encryptedList)
		{
			System.out.print(encryptedNumber + " ");
		}
		System.out.println();
	}
	
	/*public static void Encryption(int p, int q, String cryptograph){
		LinkedList<Integer> numberList = new LinkedList<>();

		int length = cryptograph.length();
		int n, e = 0;
		for(int i = 0; i < length; i = i + 2)
		{
			int encryptedNumber = (cryptograph.charAt(i)-97)*100 + (cryptograph.charAt(i+1) - 97);
			numberList.add(encryptedNumber);
		}
		
		for(int i = 3; i < Math.max(p-1, q-1); i++)
		{
			if((p-1)%i!=0 && (q-1)%i!=0)
			{
				e = i;
				break;
			}
		}
		n = p * q;
		for(int encryptedNumber: numberList)
		{
			BigInteger encrypted = (BigInteger)Math.pow(encryptedNumber, 13) % n;
			encryptedList.add(encrypted);
		}
		
	}*/
	
	public static int GetInverse(int dividend, int divisor){
		if(dividend % divisor == 0)
		{
			System.out.println("���������뻥��");
			return (Integer) null;
		}
		LinkedList<Equation> equationList = new LinkedList<>();
		LinkedList<LinearCombination> linearList = new LinkedList<>();
		final int finalDividend = dividend;
		final int finalDivisor = divisor;
		while(dividend % divisor != 1)
		{
			int quotient = dividend / divisor;
			int remainder = dividend % divisor;
			equationList.add(new Equation(dividend, divisor, quotient, remainder));
			dividend = divisor;
			divisor = remainder;
		}
		equationList.add(new Equation(dividend, divisor, dividend/divisor, dividend%divisor));
		int listLength = equationList.size();
		int coefficient1 = 1;
		int coefficient2 = -(dividend/divisor);
		linearList.add(new LinearCombination(coefficient1, dividend, coefficient2, divisor));
		for(int i = 1; i < listLength; i++)
		{
			int temp1 = coefficient1;
			int temp2 = coefficient2;
			coefficient2 = temp1 + temp2 * (-equationList.get(listLength-1-i).getQuotient());
			coefficient1 = temp2;
			linearList.add(new LinearCombination(coefficient1, equationList.get(listLength-1-i).getDividend(), coefficient2, equationList.get(listLength-1-i).getDivisor()));
		}
		if(linearList.get(listLength-1).getBase1() == finalDivisor) 
			return linearList.get(listLength-1).getCoefficient1();
		else if(linearList.get(listLength-1).getBase2() == finalDivisor) 
			return linearList.get(listLength-1).getCoefficient2();
		else
			return (Integer) null;
	}
}

class Equation{
	private int dividend;	//������
	private int divisor;	//����
	private int quotient;  	//��
	private int remainder; 	//����
	public Equation(int dividend, int divisor, int quotient, int remainder){
		this.dividend = dividend;
		this.divisor = divisor;
		this.quotient = quotient;
		this.remainder = remainder;
	}
	public int getDividend()
	{
		return this.dividend;
	}
	public int getDivisor()
	{
		return this.divisor;
	}
	public int getQuotient()
	{
		return this.quotient;
	}
}

class LinearCombination{
	private int coefficient1;	//ϵ��1
	private int coefficient2; 	//ϵ��2
	private int base1;
	private int base2;
	public LinearCombination(int coefficient1, int base1, int coefficient2, int base2){
		this.coefficient1 = coefficient1;
		this.base1 = base1;
		this.coefficient2 = coefficient2;
		this.base2 = base2;
	}
	public int getCoefficient1()
	{
		return this.coefficient1;
	}
	public int getCoefficient2()
	{
		return this.coefficient2;
	}
	public int getBase1()
	{
		return this.base1;
	}
	public int getBase2()
	{
		return this.base2;
	}
	
}
