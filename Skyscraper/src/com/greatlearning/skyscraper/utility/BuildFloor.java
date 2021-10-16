package com.greatlearning.skyscraper.utility;

import java.util.Stack;

public class BuildFloor extends util{

    public void buildingFloor (){

        // int i=0;
        // while (!inputFloorSize.isEmpty() || !trackLargest.isEmpty()){
        //     System.out.println("Day: "+(i+1));
        //     int y = trackLargest.peek();
        //     int x = inputFloorSize.poll();
        //     while (x>=y){
        //         System.out.print(y);
        //         // inputFloorSize.remove(y);
        //         trackLargest.removeElement(y);
        //         while (inputFloorSize.peek()<trackLargest.peek()){
        //             y = trackLargest.pop();
        //             System.out.print(" "+y);
        //         }
        //         if ( y >= inputFloorSize.peek())
        //             break;
        //         System.out.println();
        //     }
        //     if (x<y) {
        //         System.out.println();
        //     }
        //     i++;
        // }
        Stack<Integer> checkFloor = new Stack<>();
        int i=0, j=floorNumber-1;
        while(!inputFloorSize.isEmpty()){
            int x = inputFloorSize.poll();
            int y = arr[j];
            System.out.println("Day: "+(i+1));
            checkFloor.push(x);
            if (y<=x){
                System.out.print(y);
                j--;
                while(!inputFloorSize.isEmpty() && inputFloorSize.peek()<arr[j]){
                    
                    if (checkFloor.search(arr[j]) != -1){
                        System.out.print(" "+arr[j]);
                        j--;
                    }
                    else{
                        break;
                    }
                }
                if(!inputFloorSize.isEmpty())
                System.out.println();
                // if (y<=x)
                // break;
            }
            else
            System.out.println();
            i++;
        }
        for (int z=j; z>=0; z--){
            System.out.print(" "+arr[z]);
        }
        System.out.println();
    }
    
}
