import java.math.BigDecimal;
import java.util.Scanner;

/**
 *POJ1001
 *stripTrailingZeros() and replaceAll("^0", "") remove all useless 0
 *toPlainString() can avoid scientific notation
 **/

public class Exponentiation
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			BigDecimal r = sc.nextBigDecimal();
			int n = sc.nextInt();
			BigDecimal output = r.pow(n).stripTrailingZeros();
			System.out.println(output.toPlainString().replaceAll("^0", ""));
		}
	}
}