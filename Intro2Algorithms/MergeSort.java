
public class MergeSort
{
	public static void main(String[] args)
	{
		int[] list = new int[10];
		for(int i = 0; i < 10; i++)
		{
			list[i] = (int)(Math.random() * 100);
			System.out.print(list[i] + " ");
		}
		merge_sort(list, 0, list.length-1);
		for(int i = 0; i < 10; i++)
		{
			System.out.print(list[i] + " ");
		}
	}
	
	public static void merge_sort(int[] list, int begin, int end)
	{
		if(begin < end)
		{
			int half =  ((begin+end) % 2 == 0 ? (begin+end)/2 : (begin+end-1)/2 );
			merge_sort(list, begin, half);
			merge_sort(list, half+1, end);
			merge(list, begin, half, end);
		}
	}
	
	public static void merge(int[] list, int begin, int half, int end)
	{
		int[] listA = new int[10];
		int[] listB = new int[10];
		int n1 = half - begin + 1;
		int n2 = end - half;
		int i = 0;
		for(i = 0; i < n1; i++)
		{
			listA[i] = list[begin + i];
		}
		listA[i] = 1000;
		int j = 0;
		for(j = 0; j < n2; j++)
		{
			listB[j] = list[half + j + 1];
		}
		listB[j] = 1000;
		
		i = 0;
		j = 0;
		for(int k = begin; k <= end; k++)
		{
			if(listA[i] <= listB[j])
			{
				list[k] = listA[i];
				i++;
			}
			else
			{
				list[k] = listB[j];
				j++;
			}
		}
	}
}