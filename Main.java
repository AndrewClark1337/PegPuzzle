/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import puzzle.Board;
import puzzle.Board;
import puzzle.Display;
import puzzle.Display;
import puzzle.Solver;
import puzzle.Solver;

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
            for(int i = 0; i < path.length;i++)
            {
                if(path[i][13]!= 0)
                {
                    
                    for(int j=0;j<14;j++)
                    {
                        d.print(path[i][j]);
                    }
                    System.out.println("_____________________________________");
                }
            }
            System.out.println();
        }  
    }
}
