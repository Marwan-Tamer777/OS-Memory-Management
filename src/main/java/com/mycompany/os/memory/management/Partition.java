/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.os.memory.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 10
 */
public class Partition {
    private String name;
    private int size;
    private Process process = null;
    private boolean full = false;
    
    Partition(){
    }
    
    Partition(String s,int i){
        setName(s);
        setSize(i);
    }
    
    Partition(String s,int i,Process p){
        setName(s);
        setSize(i);
        setProcess(p);
    }
    
    Partition(String s,int i,Process p, boolean f){
        setName(s);
        setSize(i);
        setProcess(p);
        setFull(f);
    }
    
    String getName(){return name;}
    int getSize(){return size;}
    Process getProcess(){return process;}
    boolean getFull(){return full;}
    
    void setName(String s){name = s;}
    void setSize(int i){size = i;}
    void setProcess(Process p){process=p;}
    void setFull(boolean f){full = f;}
    
    
    public void enterPartition(){
        Scanner scan = new Scanner(System.in);
        String tempS;
        int tempI;
        System.out.println("Please Enter Partition Name: ");
        tempS = scan.nextLine();
        name = tempS;
        
        System.out.println("Please Enter Partition Size: ");
        tempI = scan.nextInt();
        size = tempI;
    };
    
    
    Partition setProcess(Process p, int totalParitions){
        Partition newP = null;
        
        if(p.getSize()<getSize()){
            //External Fragmantaion
            newP = new Partition();
            newP.setSize(getSize()-p.getSize());
            newP.setName("Parition"+(totalParitions));
            setSize(p.getSize());
        }
        
        full = true;
        setProcess(p);
        return newP;
    };
    
    static List<Partition> DeepCopy(List<Partition> ps){
        List<Partition> copy = new ArrayList<Partition>();
        int size = ps.size();
        
        for(int i=0;i<size;i++){
            Partition p = new Partition( ps.get(i).getName(), ps.get(i).getSize(), ps.get(i).getProcess(),ps.get(i).getFull());
            copy.add(p);
        }

        return copy;
    }
}
