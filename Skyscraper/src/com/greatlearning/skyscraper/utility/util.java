package com.greatlearning.skyscraper.utility;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class util {

    Stack<Integer> trackLargest = new Stack<>();
    Queue<Integer> inputFloorSize = new LinkedList<>();

    int floorNumber, floorSize;
    int [] arr;

    Scanner sc = new Scanner(System.in);

    public void inputFloorSize(){

        System.out.println("enter the total numbers of the building");
        floorNumber = sc.nextInt();
        arr = new int [floorNumber];

        for (int i = 0; i<floorNumber; i++){
            System.out.println("enter the floor size given on day :"+(i+1));
            floorSize = sc.nextInt();
            if (floorSize != 0){
                inputFloorSize.add(floorSize);
                arr[i]=floorSize;
                if (inputFloorSize.size() == 1)
                {
                trackLargest.push(floorSize);
                }
           
                else if (floorSize > trackLargest.peek())
                    trackLargest.push(floorSize);
                // else
                //     trackLargest.push(trackLargest.peek());
            }
            else {
                System.out.println("floor size cannot be zero");
                i--;
            }
        }
        sortFloor(arr);
    }

    public void sortFloor(int [] arr){ //sorting array in ascending order by selection sort

        int size = floorNumber;
        
        for (int i=0; i<size; i++){
            int index = i;
            for (int j=i+1; j<size; j++){
                if (arr[index]>arr[j]){
                    index=j;
                }
            }
            int largestNumber = arr[index];
            arr[index]=arr[i];
            arr[i]=largestNumber;
        }
}
    
    
}
