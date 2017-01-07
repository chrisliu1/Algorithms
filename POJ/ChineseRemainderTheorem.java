/**POJ1006
 * set x
 * x % 23 == a  physical
 * x % 28 == b  emotion
 * x % 33 == c  intellectual
 * 
 * According to ChineseRemainderTheorem
 * 28 * 33 * a % 23 == 1
 * 23 * 33 * b % 28 == 1
 * 23 * 28 * c % 33 == 1
 * we can get a == 6 b == 19 c == 2
 * 
 * day == 28*33*6*p + 23*33*19*e + 23*28*2*i == 5544*p + 14421*e + 1288*i
 */







import java.util.Scanner;

public class ChineseRemainderTheorem
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int p, e, i, d;
		int gap;
		int n = 1;
		while(sc.hasNext())
		{
			p = sc.nextInt();
			e = sc.nextInt();
			i = sc.nextInt();
			d = sc.nextInt();
			if(p == -1) break;
	        gap = (5544 * p + 14421 * e + 1288 * i - d ) % 21252; 
	        if(gap <= 0 )   
	        {  
	            gap += 21252;  
	        }
	        System.out.println("Case " + n + ": the next triple peak occurs in " + gap + " days.");
			n++;
		}
	}
}