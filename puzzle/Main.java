/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;


/**
 *
 * @author Andrew Clark, Justin Greco, Mohammed Yaseen
 */

public class Main {
    public static void main(String[] args)
    {
        Board board = new Board();
        
        Display d = new Display();
        Solver s = new Solver();
        for(int k = 0;k<5;k++)
        {
            System.out.printf("======= %d =======\n",k);
            
            int start = board.createBoard(k);
            System.out.println();
            int[][] path = s.solve(start);
            int count = 1;
            for(int i = 0; i < path.length;i++)
            {
                if(path[i][13]!= 0)
                {
                    System.out.printf("Solution #%d:\n",count);
                    System.out.println("_____________________________________");
                    System.out.println();
                    for(int j=0;j<14;j++)
                    {
                        d.print(path[i][j]);
                    }
                    
                    count++;
                }
            }
   
        }  
    }
}
