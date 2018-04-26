
import java.util.*;
import java.io.*;    
class test
{

    public void readFile(String fileName) 
    {
       try 
       {
         File file = new File(fileName);
         Scanner scanner = new Scanner(file);
         // while (scanner.hasNextLine()) 
         // {
          while(scanner.hasNext())
          {
           System.out.println(scanner.next());
          }
         // }
         scanner.close();
       } 
       catch (FileNotFoundException e) 
       {
         e.printStackTrace();
       }
    }

  public static void main(String[] args)
  {

test tt = new test();
tt.readFile("in.txt");

    
  }
}
