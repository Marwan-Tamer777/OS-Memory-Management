/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.os.memory.management;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10
 */
public class Policies {
    
    static List<Partition> FirstFit(List<Partition> partitions, List<Process> processes){
        List<Partition> newPartitions = Partition.DeepCopy(partitions);
        List<Process> newProcesses = Process.DeepCopy(processes);
        
        int procsSize = newProcesses.size();
        OSMemoryManagement.UnAllocatedProcesses = new ArrayList<>();
        
        for(int x = 0;x<procsSize;x++){
            for(int y = 0;y<newPartitions.size();y++){
                
                if(newPartitions.get(y).getSize()>=newProcesses.get(x).getSize() && newPartitions.get(y).getFull() == false){
                    Partition fragment = newPartitions.get(y).setProcess(newProcesses.get(x), newPartitions.size());
                    if(fragment != null){
                        newPartitions.add(y+1,fragment);
                    }
                    break;
                }
                
                if(y==newPartitions.size()-1){
                    System.out.println(newProcesses.get(x).getName() + " Cannot be Allocated.");
                    OSMemoryManagement.UnAllocatedProcesses.add(newProcesses.get(x));
                }
            }
        }
        
        return newPartitions;
    }
    
    
    static void CompactList(List<Partition> partitions){
        Partition newPart = new Partition("Parition"+(partitions.size()),0);
        
        for(int i=0;i<partitions.size();i++){
            if(partitions.get(i).getFull() == false){
                newPart.setSize(newPart.getSize()+partitions.get(i).getSize());
                partitions.remove(i);
                i--;
            }
        }
        
        partitions.add(newPart);
    };
    
    static void printPartitions(List<Partition> Partitions){
        int size = Partitions.size();
        String concat;
        for(int i=0;i<size;i++){
            concat = "";
            concat += Partitions.get(i).getName();
            concat += "("+Partitions.get(i).getSize()+ " KB)";
            concat += " => ";
            
            if(Partitions.get(i).getFull()){
                concat += Partitions.get(i).getProcess().getName();
            } else {
                concat += "External Fragment";
            }
            
            System.out.println(concat);
        }
    }
    
    
}
