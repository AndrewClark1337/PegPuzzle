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
public class Display {
    public void Display()
    {
        System.out.println("Display Created!");
    }
    final public static int SIZE = 5;
    public void print(int mask) {


        for (int i=0; i<SIZE; i++) {


            for (int j=0; j<SIZE-1-i; j++) System.out.print(" ");


            for (int j=0; j<=i; j++) {
                if (on(mask, SIZE*i+j)) System.out.print("X ");
                else					System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static boolean on(int mask, int bit) {
        return (mask & (1<<bit)) != 0;
    }

}
