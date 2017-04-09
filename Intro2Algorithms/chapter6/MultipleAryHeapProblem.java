/**   
* @Title: MultipleArrayHeapProblem.java 
* @Package intro2Algorithm.chapter6 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年3月23日 下午7:52:10 
* @version V1.0   
*/
package intro2Algorithm.chapter6;

import java.util.Arrays;

/** 
* @ClassName: MultipleArrayHeapProblem 
* @Description: d叉树 
* @author wjliu1998@gmail.com
* @date 2017年3月23日 下午7:52:10 
*  
*/
public class MultipleAryHeapProblem {
	public static void main(String[] args){
		int[] list1 = {0, 27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0}; //因为书上是以1为开始，加入0作为填充
		int[] list2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int[] list3 = {0, 4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		int[] list4 = {0, 5, 13, 2, 25, 7, 17, 20, 8, 4};
		int[] list5 = {0, 15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1};
		int[] list6 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
		MultipleAryHeap heap = new MultipleAryHeap(list1, 3);
		MultipleAryHeap heap2 = new MultipleAryHeap(list2, 3);
		MultipleAryHeap heap3 = new MultipleAryHeap(list3, 3);
		MultipleAryHeap heap4 = new MultipleAryHeap(list4, 3); 
		MultipleAryHeap heap5 = new MultipleAryHeap(list5, 3);
		MultipleAryHeap heap5b = new MultipleAryHeap(list5, 3);
		MultipleAryHeap heap6 = new MultipleAryHeap(list6, 4);
		//heap.maxHeapify(3);
		//heap.display();
		System.out.println();
		heap6.buildMaxHeap();
		heap6.heapExtractMax();
		heap6.displayHeap();

	} 
}

class MultipleAryHeap{
	private int branch;
	private int[] heap;
	private int size;
	
	public MultipleAryHeap(int[] heap, int branch){
		this.heap = heap;
		this.size = this.heap.length-1;
		this.branch = branch;
	}
	
	public void buildMaxHeap(){
		for(int i = (int)Math.floor((double)(this.size/this.branch)); i >= 1; i--)
			maxHeapify(i);
	}
	
	public void maxHeapify(int i){
		int largest = i;
		int child;
		
		for(int index = 1; index <= this.branch; index++){
			child = child(i, index);
			if(child <= this.size && this.heap[child] > this.heap[largest]) largest = child;
		}
		
		if(largest != i){
			int temp = this.heap[largest];
			this.heap[largest] = this.heap[i];
			this.heap[i] = temp;
			display();
			System.out.println();
			maxHeapify(largest);
		}
		
	}
	
	public int heapExtractMax(){
		if(this.size < 1) System.err.println("heap underflow");
		int max = this.heap[1];
		this.heap[1] = this.heap[this.size];
		this.size -= 1;
		maxHeapify(1);
		return max;
	}
	
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
	
	public void maxHeapInsert(int key){
		this.size += 1;
		this.heap = Arrays.copyOf(this.heap, this.size+1);
		this.heap[this.size] = -111111;
		heapIncreaseKey(this.size, key);
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
	
	public int child(int i, int index){
		return i*this.branch - (this.branch - 2) + (index - 1);
	}
	
	public int parent(int i){
		return (int) Math.floor((double)(i+this.branch-2));
	}
}
