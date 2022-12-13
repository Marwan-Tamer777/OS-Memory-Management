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
public class Process {
    private String name;
    private int size;
    
    Process(){}
    
    Process(String s,int i){
        setName(s);
        setSize(i);
    }
    
    String getName(){return name;}
    int getSize(){return size;}
    
    void setName(String s){name=s;}
    void setSize(int i){size =i;}
    
    
    public void enterProcess(){
        Scanner scan = new Scanner(System.in);
        String tempS;
        int tempI;
        System.out.println("Please Enter Process Name: ");
        tempS = scan.nextLine();
        name = tempS;
        
        System.out.println("Please Enter Process Size: ");
        tempI = scan.nextInt();
        size = tempI;
    };
    
    static List<Process> DeepCopy(List<Process> ps){
        List<Process> copy = new ArrayList<Process>();
        int size = ps.size();
        
        for(int i=0;i<size;i++){
            Process p = new Process( ps.get(i).getName(), ps.get(i).getSize());
            copy.add(p);
        }
        
        return copy;
    }
    
}
