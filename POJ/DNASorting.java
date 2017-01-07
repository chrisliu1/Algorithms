/**
 * POJ1007
 * 
 */
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class DNASorting
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int lines = sc.nextInt();
		sc.nextLine();
		ArrayList<DNA> DNAList = new ArrayList<DNA>();
		int inversions = 0;
		while(lines > 0)
		{
			String dna_string = sc.nextLine();
			for(int i = 0; i < length; i++)
			{
				for(int j = i+1; j < length; j++)
				{
					if((int)dna_string.charAt(j) < (int)dna_string.charAt(i)) inversions++;
				}
			}
			DNAList.add(new DNA(dna_string, inversions));
			inversions = 0;
			lines--;
		}
		
		Collections.sort(DNAList, new DNACompare());
		
		for(DNA dna: DNAList)
		{
			System.out.println(dna.getDNA());
		}
		sc.close();
	}
}

class DNACompare implements Comparator
{
	@Override
	public int compare(Object arg0, Object arg1) {
        DNA d1=(DNA)arg0;
        DNA d2=(DNA)arg1;

        if(d1.get_inversions() > d2.get_inversions()){
            return 1;
        }else if(d1.get_inversions() == d2.get_inversions()){
            return 0;
        }else{
            return -1;
        }
    }
}

class DNA
{
	private int inversions;
	private String DNA_String;
	public DNA(String DNA_String, int inversions) {
		this.DNA_String = DNA_String;
		this.inversions = inversions;
	}
	
	public int get_inversions()
	{
		return this.inversions;
	}
	
	public String getDNA()
	{
		return this.DNA_String;
	}
	
}