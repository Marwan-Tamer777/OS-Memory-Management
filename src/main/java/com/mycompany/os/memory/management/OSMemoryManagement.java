/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.os.memory.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * Os Section AI-4
 * 20200508
 * 20200318
 * 20200474
 * 20200043
 * 20200172
 */
public class OSMemoryManagement {
    
    static List<Partition> Partitions = new ArrayList<>();
    static List<Process> Processes = new ArrayList<>();
    static List<Process> UnAllocatedProcesses = new ArrayList<>();
    static int TotalPartitions;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner scan = new Scanner(System.in);
        int tempI;
        
        //Testing.
        /*Partitions.add(new Partition("Partition0",90));
        Partitions.add(new Partition("Partition1",20));
        Partitions.add(new Partition("Partition2",5));
        Partitions.add(new Partition("Partition3",30));
        Partitions.add(new Partition("Partition4",120));
        Partitions.add(new Partition("Partition5",80));
        
        Processes.add(new Process("Process1",15));
        Processes.add(new Process("Process2",90));
        Processes.add(new Process("Process3",30));
        Processes.add(new Process("Process4",100));
        */
        System.out.println("Please Enter Partitions Count: ");
        tempI = scan.nextInt();
        for(int i=0;i<tempI;i++){
            Partition p= new Partition();
            p.enterPartition();
            Partitions.add(p);
        }
        
        System.out.println("Please Enter Processes Count: ");
        tempI = scan.nextInt();
        for(int i=0;i<tempI;i++){
            Process p= new Process();
            p.enterProcess();
            Processes.add(p);
        }
        
        while(true){
            System.out.print("Please Select Policy:\n" +
            "1. First-Fit policy.\n" +"2. Worst-Fit policy.\n"+  "3. Best-Fit policy.\n" + "4.Exit.\n"); 
            int choice;
            TotalPartitions = Partitions.size();
            choice = scan.nextInt();
            
            switch (choice) {
                case 1 -> {
                    List<Partition> newList = Policies.FirstFit(Partitions, Processes);
                    Policies.printPartitions(newList);
                    System.out.print("want Compaction?\n1.Yes.\n2.No.\n");
                    choice = scan.nextInt();
                    if(choice == 1 ){
                        Policies.CompactList(newList);
                        newList = Policies.FirstFit(newList,UnAllocatedProcesses);
                        Policies.printPartitions(newList);
                    }
                }
                case 2 -> {
                    List<Partition> newList = Policies.WorstFit(Partitions, Processes);
                    Policies.printPartitions(newList);
                    System.out.print("want Compaction?\n1.Yes.\n2.No.\n");
                    choice = scan.nextInt();
                    if(choice == 1 ){
                        Policies.CompactList(newList);
                        newList = Policies.WorstFit(newList,UnAllocatedProcesses);
                        Policies.printPartitions(newList);
                    }
                }
                case 3 -> {
                    List<Partition> newList = Policies.BestFit(Partitions, Processes);
                    Policies.printPartitions(newList);
                    System.out.print("want Compaction?\n1.Yes.\n2.No.\n");
                    choice = scan.nextInt();
                    if(choice == 1 ){
                        Policies.CompactList(newList);
                        newList = Policies.BestFit(newList,UnAllocatedProcesses);
                        Policies.printPartitions(newList);
                    }
                }
                case 4 -> {
                    System.out.println("Closing Program");
                    return;
                }
                default -> System.out.println("Wrong Input");
            }
        }
    }
    
}
