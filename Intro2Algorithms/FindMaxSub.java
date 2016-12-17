
import java.util.Random;

public class FindMaxSub
{
	public static void main(String[] args)
	{
		int[] list = new int[10];
		Random r1 = new Random(5);
		for(int i = 0; i < 10; i++)
		{
			list[i] = (int)(r1.nextInt()/1000000);
			System.out.print(list[i] + " ");
		}
		int[] answer = find_max_subarray(list, 0, list.length-1);
		System.out.println();
		for(int i = 0; i < 3; i++)
		{
			System.out.print(answer[i] + " ");
		}
	}
	
	public static int[] find_max_crossing_subarray(int[] list, int low, int mid, int high)
	{
		int left_sum = Integer.MIN_VALUE;
		int right_sum = Integer.MIN_VALUE;
		int sum = 0;
		int max_left = mid;
		for(int i = mid; i >= low; i--)
		{
			sum += list[i];
			if(sum > left_sum)
			{
				left_sum = sum;
				max_left = i;
			}
		}
		sum = 0;
		int max_right = mid + 1;
		for(int i = mid+1; i <= high; i++)
		{
			sum += list[i];
			if(sum > right_sum)
			{
				right_sum = sum;
				max_right = i;
			}
		}
		int[] list2 = {max_left, max_right, left_sum + right_sum};
		return list2;
	}
	
	public static int[] find_max_subarray(int[] list, int low, int high)
	{
		int return_list[] = new int[3];
		if(low == high)
		{
			return_list[0] = low;
			return_list[1] = high;
			return_list[2] = list[low];
			return return_list;
		}
		else
		{
			int mid = (int) Math.floor((low+high)/2);
			int[] left_list = find_max_subarray(list, low, mid);
			int[] right_list = find_max_subarray(list, mid+1, high);
			int[] cross_list = find_max_crossing_subarray(list, low, mid, high);
			if(left_list[2] >= right_list[2] && left_list[2] >= cross_list[2])       return left_list;
			else if(left_list[2] <= right_list[2] && right_list[2] >= cross_list[2]) return right_list;
			else																	 return cross_list;
		}
	}
}
