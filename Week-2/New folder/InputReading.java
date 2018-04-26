//implementing Scanner classes
import java.util.*;
import java.io.*;
public class InputReading
{
	public static void main(String[] args)throws IOException {
			// Scanner scan=new Scanner(System.in);
			// String str=sc.nextLine();
			// String [] aa=str.split(",");
			/* array 
			for(int i=0;i<aa.length;i++)
			{
				if(i==0)
					System.out.println(aa[0].substring(1,2));
				else if(i<aa.length-1)
					System.out.println(aa[i]);
				else
					System.out.println(aa[i].substring(0,1));

			}
			*/
			// int n=Integer.parseInt(sc.nextLine());
			// String str=scan.nextLine();
			// int k=0;
			// for(int i=0;i<n;i++)
			// {
			// 	while(k<n && sc.hasNextLine())
			// 	{
			// 		System.out.println(str);
			// 		k++;
			// 	}System.out.println();
			// }
			// File file=new File("C:\\Users\\haree\\Desktop\\Week-2\\input.txt");
			// if(file.exists()){
			// 	System.out.println("yes ");
			// }
			File file=new File("input.txt");
			try
			{	Scanner sc=new Scanner(file);
				while(sc.hasNextLine())
			{
				System.out.println(sc.nextLine());
			}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		// 	 BufferedReader br = null;
  //       FileReader fr = null;
  //       try
  //       {
  //       	fr=new FileReader("input.txt");
		// 	br=new BufferedReader(fr);
  //       	String str=br.readLine();
		// 	while(str!=null)
		// 	{
		// 		System.out.println(str);
		// 		str=br.readLine();
		// 	}	

		// }	
		// catch(Exception e)
		// {
		// 	System.out.println(e.getMessage());
		// }
        }
}