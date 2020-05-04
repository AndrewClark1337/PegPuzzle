/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Andrew Clark, Justin Greco, Mohammed Yaseen
 */
public class Solver{
    final public static int[] DX = {-1,-1,0,0,1,1};
    final public static int[] DY = {-1,0,-1,1,0,1};
    final public static int SIZE = 5;
    public static void Solver()
    {
        System.out.println("Solver Created!");
    }
   
    public static int[][] solve(int start)
    {
        HashMap<Integer,Integer> distances = new HashMap<Integer,Integer>();
        distances.put(start, 0);
        int [][] path = new int [100000][16];

        LinkedList<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        //System.out.println(start);
       // print(start);
        //ArrayList<int[]> path=new ArrayList<int[]>();
        int[] temp = {start,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        path[0]=Arrays.copyOf(temp,15);
        //path.add(temp);
        //int x =0;
        int y =1;
        while (q.size() > 0) 
        {
            
            int cur = q.poll();
            int curdist = distances.get(cur);
            
            ArrayList<Integer> nextList = getNextPos(cur);
            //System.out.printf("%d, %d - ", curdist, cur);
            //System.out.println(nextList);

            for (int i=0; i<nextList.size(); i++) {
                if (!distances.containsKey(nextList.get(i))) {
                    distances.put(nextList.get(i), curdist+1);
                    q.offer(nextList.get(i));
                    int parent = find(cur,path,curdist);
                   // System.out.println(parent);
                    path[y]=Arrays.copyOf(path[parent],15);
                    path[y][curdist+1]=nextList.get(i);
                    //System.out.println(Arrays.toString(path[y]));
                    y++;
                }
            }
            //x=y;

        }
        return path;
    }
    
    public static int find(int target,int[][] path,int dist) //finds the parent path 
    {
        for(int i = 0;i<path.length;i++)
        {
            String s = Arrays.toString(path[i]);
           // System.out.printf("%d, %d- %s\n",target,dist,s);
            if(path[i][dist]==target)
            {
                return i;
            }
        }
        return -1;
    }
    
    public static boolean on(int mask, int bit) {
        return (mask & (1<<bit)) != 0;
    }
    
    public static boolean inbounds(int myr, int myc) {
        return myr >= 0 && myr < SIZE && myc >= 0 && myc <= myr;
    }
    
    public static ArrayList<Integer> getNextPos(int mask) {

        ArrayList<Integer> pos = new ArrayList<Integer>();

        for (int r =0; r<SIZE; r++) {
            for (int c=0; c<=SIZE; c++) {


                for (int dir=0; dir<DX.length; dir++) {


                    if (!inbounds(r+2*DX[dir], c+2*DY[dir])) continue;


                    if (on(mask, SIZE*r+c) && on(mask, SIZE*(r+DX[dir]) + c + DY[dir]) && !on(mask, SIZE*(r+2*DX[dir]) + c + 2*DY[dir])) {
                        int newpos = apply(mask, dir, r, c);
                        pos.add(newpos);
                    }
                }
            }
        }


        return pos;
    }
    
    public static int apply(int mask, int dir, int r, int c) {


        int start = SIZE*r + c;
        int mid = SIZE*(r+DX[dir]) + c + DY[dir];
        int end = SIZE*(r+2*DX[dir]) + c + 2*DY[dir];


        return mask - (1<<start) - (1<<mid) + (1<<end);
    }
}
