package com.ArchitectConsultant.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.ArchitectConsultant.service.QueueSort;

public class ArchitectConsultant {
    public static void main(String[] args) {
        int numberOfFloors = 0;
        Scanner sc = new Scanner(System.in);
        Queue<Integer> floorsSizes = new LinkedList<Integer>();
        // Read input from user for number of floors.
        System.out.println("enter the total no of floors in the building :");
        numberOfFloors = sc.nextInt();
        for (int i = 0; i < numberOfFloors; i++) {
            System.out.println("enter the floor size given on day " + (i + 1));
            int size = sc.nextInt();
            if (floorsSizes.contains(size) || size == 0) {
                i--;
                System.out.println("please re-enter size; distinct non-zero size expected");
            } else {
                floorsSizes.add(size);
            }
        }
        constructBuilding(floorsSizes);
        sc.close();
    }

    static void constructBuilding(Queue<Integer> floorSizes) {
        int count = 1;
        int max = 0;
        Queue<Integer> temp = new LinkedList<Integer>();
        while (!floorSizes.isEmpty()) {
            max = Collections.max(floorSizes);
            System.err.println();
            System.out.println("Day " + count++);
            if (floorSizes.peek() >= max) {
                System.out.print(floorSizes.remove() + " ");
                QueueSort.sortQueue(temp);
                if(!floorSizes.isEmpty()){
                    max = Collections.max(floorSizes);
                    while(!temp.isEmpty()){
                        if(temp.peek() > max)
                            System.out.print(temp.remove() + " ");
                    }
                }else{
                    while(!temp.isEmpty() ){
                        System.out.print(temp.remove() + " ");
                    }
                }
                
            } else {
                System.out.println("");
                temp.add(floorSizes.remove());
            }
        }
    }

    
}