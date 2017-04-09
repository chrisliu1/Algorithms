/**   
* @Title: HeapProblem.java 
* @Package intro2Algorithm.chapter6 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author wjliu1998@gmail.com
* @date 2017��3��19�� ����6:45:20 
* @version V1.0   
*/
package intro2Algorithm.chapter6;
/*
 * 6.2-3 �����иı�
 * 6.2-4 �����иı�
 * 6.2-5 ��Ϊ�߶�Ϊlgn��ÿ�ν�����ΪO(1),���Ӷ�ΪO(lgn)
 * 6.3-2 ��Ϊֻ�д������ϲ��ܱ�֤���ǵ��������Ƕ�
 * 6.5-4 ���������heapIncreaseKey�Ĵ���
 * 6.5-6 �����������ƶ�С���������ȣ�ֱ��û��С���������Ⱥ���ڿճ���λ����
 * 6.5-6 �����ѣ�ʵ�ֶ��У��Ƚ��Ĺؼ��ִ���֮��ġ� ʵ��ջ����֮
 * 
 */
import  java.lang.reflect.Array;
import java.util.Arrays;
/** 
* @ClassName: HeapProblem 
* @Description: ά���ѵ�����
* @author wjliu1998@gmail.com
* @date 2017��3��19�� ����6:45:20 
*  
*/
public class HeapProblem {
	public static void main(String[] args){
		int[] list1 = {0, 27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0}; //��Ϊ��������1Ϊ��ʼ������0��Ϊ���
		int[] list2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int[] list3 = {0, 4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		int[] list4 = {0, 5, 13, 2, 25, 7, 17, 20, 8, 4};
		int[] list5 = {0, 15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1};
		Heap heap = new Heap(list1);
		Heap heap2 = new Heap(list2);
		Heap heap3 = new Heap(list3);
		Heap heap4 = new Heap(list4);
		Heap heap5 = new Heap(list5);
		Heap heap5b = new Heap(list5);
		//heap.maxHeapify(3);
		//heap.display();
		System.out.println();
		heap5.buildMaxHeap();
		heap5.displayHeap();
		
		heap5b.buildMaxHeapInsert(list5);
		heap5b.displayHeap();
		

	} 
}

class Heap{
	private int[] heap;
	private int size;
	public Heap(int[] heap){
		this.heap = heap;
		this.size = this.heap.length-1;
	}
	
	public void buildMaxHeap(){
		for(int i = (int)Math.floor((double)this.size) / 2; i >= 1; i--)
			maxHeapify(i);
	}
	
	/**
	 * 
	 * @Title: buildMaxHeapInsert 
	 * @Description: �ò���ķ������� �������ɵĶѲ�����һ��������{1��2��3��4��5}
	 * 6-1.b:��ΪmaxHeapInsert�ĸ��Ӷ�ΪO(lgn),Ҫִ��n�Σ����Ӷ�ΪO(nlgn)
	 * @throws
	 */
	public void buildMaxHeapInsert(int[] list){
		this.heap = new int[list.length];
		this.heap[0] = list[0];
		this.heap[1] = list[1];
		this.size = 1;
		for(int i = 2; i <= list.length-1; i++) maxHeapInsert(list[i]);
	}
	
	public void buildMinHeap(){

		for(int i = (int)Math.floor((double)this.size / 2); i >= 1; i--)
			minHeapify(i);
	}
	/**
	 * 
	 * @Title: maxHeapify 
	 * @Description: ά���ѵ����ʣ�Ĭ������������������������
	 * @param i void 
	 * @throws
	 */
	
	public void maxHeapify(int i){
		int left = left(i);
		int right = right(i);
		int largest;
		
		if(left <= this.size && this.heap[left] > this.heap[i]) largest = left;
		else														   largest = i;
		
		if(right <= this.size && this.heap[right] > this.heap[largest]) largest = right;
		
		if(largest != i){
			int temp = this.heap[largest];
			this.heap[largest] = this.heap[i];
			this.heap[i] = temp;
			display();
			System.out.println();
			maxHeapify(largest);
		}
		
	}
	
	/**
	 * 
	 * @Title: minHeapify 
	 * @Description: ��С�ѣ�ʱ�临�Ӷ���������ͬ
	 * @param i void 
	 * @throws
	 */
	public void minHeapify(int i){		
		int left = left(i);
		int right = right(i);
		int smallest;
	
		if(left <= this.size && this.heap[left] < this.heap[i]) smallest = left;
		else														   smallest = i;
	
		if(right <= this.size && this.heap[right] < this.heap[smallest]) smallest = right;
	
		if(smallest != i){
			int temp = this.heap[smallest];
			this.heap[smallest] = this.heap[i];
			this.heap[i] = temp;
			minHeapify(smallest);
	}
	}
	
	/**
	 * 
	 * @Title: heapSort 
	 * @Description: ������ 
	 * 6.4-3 ��Ϊ�����ʱ�䶼ΪO(nlgn),����ͽ����ʱ�䶼ΪO(nlgn)
	 * @throws
	 */
	public void heapSort(){
		buildMaxHeap();
		for(int i = this.size; i >= 2; i--){
			int temp = this.heap[i];
			this.heap[i] = this.heap[1];
			this.heap[1] = temp;
			this.size -= 1;
			maxHeapify(1);
		}
	}
	
	/**
	 * 
	 * @Title: heapMaximum 
	 * @Description: �������ֵ
	 * @return int 
	 * @throws
	 */
	public int heapMaximum(){
		return this.heap[1];
	}
	
	public int heapMinimum(){
		return this.heap[1];
	}
	/**
	 * 
	 * @Title: heapExtractMax 
	 * @Description: ��ȡ���ֵ
	 * @return int 
	 * @throws
	 */
	public int heapExtractMax(){
		if(this.size < 1) System.err.println("heap underflow");
		int max = this.heap[1];
		this.heap[1] = this.heap[this.size];
		this.size -= 1;
		maxHeapify(1);
		return max;
	}
	
	public int heapExtractMin(){
		if(this.size < 1) System.err.println("heap underflow");
		int max = this.heap[1];
		this.heap[1] = this.heap[this.size];
		this.size -= 1;
		minHeapify(1);
		return max;
	}
	
	/**
	 * 
	 * @Title: heapIncreaseKey 
	 * @Description: ��Ԫ�صĹؼ���ֵ����
	 * @param i
	 * @param key void 
	 * @throws
	 */
	public void heapIncreaseKey(int i, int key){
		if(key < this.heap[i]) System.err.println("new key is smaller than current key");
		this.heap[i] = key;
		while(i > 1 && this.heap[parent(i)] < this.heap[i]) {
			int temp = this.heap[i];
			this.heap[i] = this.heap[parent(i)];
			this.heap[parent(i)] = temp;
			i = parent(i);
		}
	}
	
	public void heapDecreaseKey(int i, int key){
		if(key > this.heap[i]) System.err.println("new key is larger than current key");
		this.heap[i] = key;
		while(i > 1 && this.heap[parent(i)] > this.heap[i]) {
			int temp = this.heap[i];
			this.heap[i] = this.heap[parent(i)];
			this.heap[parent(i)] = temp;
			i = parent(i);
		}
	}
	
	public void maxHeapInsert(int key){
		this.size += 1;
		this.heap = Arrays.copyOf(this.heap, this.size+1);
		this.heap[this.size] = -111111;
		heapIncreaseKey(this.size, key);
	}
	
	public void minHeapInsert(int key){
		this.size += 1;
		this.heap = Arrays.copyOf(this.heap, this.size+1);
		this.heap[this.size] = 111111;
		heapDecreaseKey(this.size, key);
	}
	
	/**
	 * 
	 * @Title: heapDelete 
	 * @Description: �൱��ɾ����iΪ�ڵ������
	 * @param i void 
	 * @throws
	 */
	public void heapDelete(int i){
		this.heap[i] = this.heap[this.size];
		this.size -= 1;
		maxHeapify(i);
	}
	
	public void displayHeap(){
		for(int i = 0; i <= this.size; i++)
			System.out.print(this.heap[i] + " ");
		System.out.println();
	}
	
	public void display(){
		for(int i: this.heap)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public int parent(int i){
		return (int) Math.floor((double)i/2);
	}
	
	public int left(int i){
		return 2*i;
	}
	
	public int right(int i){
		return 2*i + 1;
	}
}