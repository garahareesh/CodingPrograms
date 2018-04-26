import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of testcases:");
		int testcases=Integer.parseInt(sc.nextLine());
		
			int c=0;
			while(c<noOfLines)
			{
			System.out.println("Enter the noOfLines:");
			int noOfLines=Integer.parseInt(sc.nextLine());
			System.out.println("Enter the n:");
			int n=Integer.parseInt(sc.nextLine());
				int [] temp=new int[n];
					int r=0;
				while(r<n)
				{
						System.out.println("Enter the elements");
							temp[r++]=Integer.parseInt(sc.nextLine());
				}
				if(sc.hasNextLine())
					sc.nextLine();
				c++;
				int len=temp.length;
					for(int i=0;i<len-1;i=i+2)
					{
						int te=temp[i];
						temp[i]=temp[i+1];
						temp[i+1]=te;
					}
			System.out.println("c---"+c);
			int[] qq=new int [len];
			qq=Arrays.copyOf(temp,len);
			if(c==2)
			{

			for(int e=0;e<len;e++)
			{
				if(e<len-1)
					System.out.print(temp[e]+", ");
				else if(e==len-1)
					System.out.print(temp[e]);
			}
			for(int y=0;y<len;y++)
			{
				if(y<len-1)
					System.out.print(qq[y]+", ");
				else if(y==len-1)
					System.out.print(qq[y]);
			}
			}
			System.out.println();
		}
		System.out.println();
	}	
}