public class BubbleSort
{
	public static void main(String[] args)
	{
		int[] list = new int[10];
		for(int i = 0; i < 10; i++)
		{
			list[i] = (int)(Math.random() * 100);
			System.out.print(list[i] + " ");
		}
		System.out.println();
		bubble_sort(list);
		for(int i = 0; i < 10; i++)
		{
			System.out.print(list[i] + " ");
		}
	}
	
	public static void bubble_sort(int[] list)
	{
		for(int i = 0; i <= list.length - 2; i++)
		{
			for(int j = list.length-1; j > i; j--)
			{
				if(list[j] < list[j-1])
				{
					int temp = list[j];
					list[j] = list[j-1];
					list[j-1] = temp;
				}
			}
		}
	}
}