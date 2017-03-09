import java.util.*;

public class InsertionSort
{
	public static void main(String[] args)
	{
		int[] list = new int[10];
		for(int i = 0; i < 10; i++)
		{
			list[i] = (int) (Math.random() * 100);
		}
		insertion_sort_up(list);
		for(int i = 0; i < 10; i++)
		{
			System.out.print(list[i] + " ");
		}
		System.out.print("\n");
		insertion_sort_down(list);
		for(int i = 0; i < 10; i++)
		{
			System.out.print(list[i] + " ");
		}
	}
	
	public static int[] insertion_sort_up(int[] list)
	{
		for(int j = 1; j < list.length; j++)
		{
			int key = list[j];
			int i = j - 1;
			while(i > -1 && list[i] > key)
			{
				list[i+1] = list[i];
				i = i - 1;
			}
			list[i+1] = key;
		}
		return list;
	}
	public static int[] insertion_sort_down(int[] list)
	{
		for(int j = list.length-2; j >= 0; j--)
		{
			int key = list[j];
			int i = j + 1;
			while(i <= list.length-1 && list[i] > key)
			{
				list[i-1] = list[i];
				i++;
			}
			list[i-1] = key;
		}
		return list;
	}
}