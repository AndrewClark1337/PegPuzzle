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
public class Board {
    final public static int SIZE = 5;
    public void Board()
    {
        System.out.println("Board Created!");
    }
    public int createBoard(int hole) {
        int holeC,holeR;
        switch(hole)
        {
            case 0: holeC = 0; holeR=0; break;      //reworked the holeR/holeC part to make it easier to use
            case 1: holeC = 0; holeR = 1; break;
            case 2: holeC = 1; holeR = 1; break;
            case 3: holeC = 0; holeR = 2; break;
            case 4: holeC = 1; holeR = 2; break;
            case 5: holeC = 2; holeR = 2; break;
            case 6: holeC = 0; holeR = 3; break;
            case 7: holeC = 1; holeR = 3; break;
            case 8: holeC = 2; holeR = 3; break;
            case 9: holeC = 3; holeR = 3; break;
            case 10: holeC = 0; holeR = 4 ; break;
            case 11: holeC = 1; holeR = 4; break;
            case 12: holeC = 2; holeR = 4; break;
            case 13: holeC = 3; holeR = 4; break;
            case 14: holeC = 4; holeR = 4; break;
            default:
                System.out.println("Error: invalid starting position!");
                return 0;
                
        }

        int mask = 0;
        for (int i=0; i<SIZE; i++)
            for (int j=0; j<=i; j++)
                mask = mask | (1<<(SIZE*i+j));


        return mask - (1<<(SIZE*holeR+holeC));
    }
}
