import java.util.*;
import java.io.*;

public class QuickUnionUF {
    private int[] parent;  // parent[i] = parent of i
    private int count;     // number of components
    int cF;

    
    public QuickUnionUF(int n) {
        parent = new int[n];
        count = n;
        cF=0;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    
    public int count() {
        return count;
    }
  
    
    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            cF++;
            p = parent[p];
        }
        // System.out.println(cF);
        return p;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;  
        if (p < 0 || p >= n) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

  
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ; 
        count--;
    }


    public static void main(String[] args) {
        
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader("mediumUF.txt");
            br = new BufferedReader(fr);
            String sCurrentLine;

            br = new BufferedReader(new FileReader("mediumUF.txt"));
            sCurrentLine = br.readLine();
            QuickUnionUF wqu = new QuickUnionUF(Integer.parseInt(sCurrentLine));;


            while ((sCurrentLine = br.readLine()) != null) 
            {
                String arr[] = sCurrentLine.split(" ");
                
                    wqu.union(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
                    

                System.out.println(wqu);
                System.out.println("coF  : "+wqu.cF);

            }

            } 
        catch (IOException e) 
        {

            e.printStackTrace();


        }
        System.out.println();
}}