/**   
* @Title: QuickSortProblem.java 
* @Package intro2Algorithm.chapter7 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年3月25日 上午10:21:58 
* @version V1.0   
*/
package intro2Algorithm.chapter7;

/** 
* @ClassName: QuickSortProblem 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年3月25日 上午10:21:58 
*  
*/
public class QuickSortProblem {
	public static void main(String[] args){
		int[] list = {13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11};
		QuickSort ql = new QuickSort(list);
		ql.quickSort(0, list.length-1);
		for(int i: list)
			System.out.print(i + " ");
	}
}

class QuickSort{
	private int[] list;
	private int length;
	public QuickSort(int[] list){
		this.list = list;
		this.length = list.length;
	}
	
	public void quickSort(int p, int r){
		if(p < r){
			int q = partition(p, r);
			quickSort(p, q - 1);
			quickSort(q + 1, r);
		}
	}
	public int partition(int p, int r){
		int x = this.list[r];
		int i = p - 1;
		int temp;
		for(int j = p; j <= r-1; j++){
			if(this.list[j] <= x){
				i++;
				temp = this.list[i];
				this.list[i] = this.list[j];
				this.list[j] = temp;
			}
		}
		temp = this.list[i+1];
		this.list[i+1] = this.list[r];
		this.list[r] = temp;
		return i+1;
	}
}