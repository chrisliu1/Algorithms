/**   
* @Title: StrassenMethod.java 
* @Package intro2Algorithm.chapter4 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年3月13日 下午8:42:21 
* @version V1.0   
*/
package intro2Algorithm.chapter4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/** 
* @ClassName: StrassenMethod 
* @Description: 4.2矩阵乘法的Strassen算法
* 解答：
* 4.2-3 加入全为0的行与列使矩阵规模为2的幂
* 
* 4.2-7(a+bi)(c+di)=(ac−bd)+(ad+bc)i(a+bi)(c+di)=(ac−bd)+(ad+bc)i，可以发现ad+bc=(a+b)(c+d)−ac−bd，只需要3次乘法。
* @author wjliu1998@gmail.com
* @date 2017年3月13日 下午8:42:21 
*  
*/
public class StrassenMethod {
	public static void main(String[] args) throws IOException{
		//BufferedReader in = new BufferedReader(new FileReader("D:\\eclipse\\IDE\\Algorithms\\src\\intro2Algorithm\\chapter4\\matrix"));
		Random r1 = new Random(5);
		long start, end, costtime;
		int matrix1[][], matrix2[][];
		int row = 1000;
		//try{
				
			matrix1 = new int[row][row];
			matrix2 = new int[row][row];
			for(int i = 0; i < row; i++){
				//String string[] = in.readLine().split(" ");
				for(int j = 0; j < row; j++)
					matrix1[i][j] = (int)(r1.nextInt()/1000000000);
					//Integer.valueOf(string[j]);
			}
			
			for(int i = 0; i < row; i++){
				//String string[] = in.readLine().split(" ");
				for(int j = 0; j < row; j++)
					matrix2[i][j] = (int)(r1.nextInt()/1000000000);
					//Integer.valueOf(string[j]);
			}
			
			/*for(int i = 0; i < 4; i++){
				for(int j = 0; j < 4; j++)
					System.out.print(matrix1[i][j] + " ");
				System.out.println();
			}
			
			for(int i = 0; i < 4; i++){
				for(int j = 0; j < 4; j++)
					System.out.print(matrix2[i][j] + " ");
				System.out.println();
			}*/
			start = System.currentTimeMillis();
			int matrix[][] = square_matrix_multiply(matrix1, matrix2, row);
			end = System.currentTimeMillis();
			costtime = end - start;
			
			/*for(int i = 0; i < row; i++){
				for(int j = 0; j < row; j++)
					//System.out.print(matrix[i][j] + " ");
				System.out.println();
			}*/
			
			System.out.println();
			System.out.println(costtime);
			
			start = System.currentTimeMillis();
			int matrixB[][] = strassen_method(matrix1, matrix2, row);
			end = System.currentTimeMillis();
			costtime = end - start;
			/*for(int i = 0; i < row; i++){
				for(int j = 0; j < row; j++)
					//System.out.print(matrixB[i][j] + " ");
				System.out.println();
			}*/
			
			System.out.println();
			System.out.println(costtime);
		//}
		/*catch(FileNotFoundException ex){
		
		}
		finally{
			in.close();
		}*/
	}
	
	public static int[][] square_matrix_multiply(int[][] matrixA, int[][] matrixB, int row){
		int matrix[][] = new int[row][row];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < row; j++){
				matrix[i][j] = 0;
				for(int k = 0; k < row; k++)
					matrix[i][j] = matrix[i][j] + matrixA[i][k] * matrixB[k][j];
			}
		}
		return matrix;
	}
	
	public static int[][] strassen_method(int[][] matrixA, int[][] matrixB, int row){
		
		int C[][] = new int[row][row];
		
		int halfrow = row / 2;		
		int A11[][] = new int[halfrow][halfrow];
		int A12[][] = new int[halfrow][halfrow];
		int A21[][] = new int[halfrow][halfrow];
		int A22[][] = new int[halfrow][halfrow];
		int B11[][] = new int[halfrow][halfrow];
		int B12[][] = new int[halfrow][halfrow];
		int B21[][] = new int[halfrow][halfrow];
		int B22[][] = new int[halfrow][halfrow];
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < row; j++){
				if(i < halfrow && j < halfrow){
					A11[i][j] = matrixA[i][j];
					B11[i][j] = matrixB[i][j];
				}
				else if(i < halfrow && j >= halfrow){
					A12[i][j-halfrow] = matrixA[i][j];
					B12[i][j-halfrow] = matrixB[i][j];
				}
				else if(i >= halfrow && j < halfrow){
					A21[i-halfrow][j] = matrixA[i][j];
					B21[i-halfrow][j] = matrixB[i][j];
				}
				else{
					A22[i-halfrow][j-halfrow] = matrixA[i][j];
					B22[i-halfrow][j-halfrow] = matrixB[i][j];
				}
			}
			
		}		
				

		int S1[][] = new int[halfrow][halfrow];
		int S2[][] = new int[halfrow][halfrow];
		int S3[][] = new int[halfrow][halfrow];
		int S4[][] = new int[halfrow][halfrow];
		int S5[][] = new int[halfrow][halfrow];
		int S6[][] = new int[halfrow][halfrow];
		int S7[][] = new int[halfrow][halfrow];
		int S8[][] = new int[halfrow][halfrow];
		int S9[][] = new int[halfrow][halfrow];
		int S10[][] = new int[halfrow][halfrow];
		
		int P1[][] = new int[halfrow][halfrow];
		int P2[][] = new int[halfrow][halfrow];
		int P3[][] = new int[halfrow][halfrow];
		int P4[][] = new int[halfrow][halfrow];
		int P5[][] = new int[halfrow][halfrow];
		int P6[][] = new int[halfrow][halfrow];
		int P7[][] = new int[halfrow][halfrow];
		
		int C11[][] = new int[halfrow][halfrow];
		int C12[][] = new int[halfrow][halfrow];
		int C21[][] = new int[halfrow][halfrow];
		int C22[][] = new int[halfrow][halfrow];
		
		for(int i = 0; i < halfrow; i++){
			for(int j = 0; j < halfrow; j++){
				S1[i][j] = B12[i][j] - B22[i][j];
				S2[i][j] = A11[i][j] + A12[i][j];
				S3[i][j] = A21[i][j] + A22[i][j];
				S4[i][j] = B21[i][j] - B11[i][j];
				S5[i][j] = A11[i][j] + A22[i][j];
				S6[i][j] = B11[i][j] + B22[i][j];
				S7[i][j] = A12[i][j] - A22[i][j];
				S8[i][j] = B21[i][j] + B22[i][j];
				S9[i][j] = A11[i][j] - A21[i][j];
				S10[i][j] = B11[i][j] + B12[i][j];
			}
		}
		
		P1 = square_matrix_multiply(A11, S1, halfrow);
		P2 = square_matrix_multiply(S2, B22, halfrow);
		P3 = square_matrix_multiply(S3, B11, halfrow);
		P4 = square_matrix_multiply(A22, S4, halfrow);
		P5 = square_matrix_multiply(S5, S6, halfrow);
		P6 = square_matrix_multiply(S7, S8, halfrow);
		P7 = square_matrix_multiply(S9, S10, halfrow);
		
		for(int i = 0; i < halfrow; i++){
			for(int j = 0; j < halfrow; j++){
				C11[i][j] = P5[i][j] - P2[i][j] + P4[i][j] + P6[i][j];
				C12[i][j] = P1[i][j] + P2[i][j];
				C21[i][j] = P3[i][j] + P4[i][j];
				C22[i][j] = P5[i][j] + P1[i][j] - P3[i][j] - P7[i][j];
			}
		}
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < row; j++){
				if(i < halfrow && j < halfrow){
					C[i][j] = C11[i][j];
				}
				else if(i < halfrow && j >= halfrow){
					C[i][j] = C12[i][j-halfrow];
				}
				else if(i >= halfrow && j < halfrow){
					C[i][j] = C21[i-halfrow][j];
				}
				else{
					C[i][j] = C22[i-halfrow][j-halfrow];
				}
			}
			
		}
		return C;
	}
}
