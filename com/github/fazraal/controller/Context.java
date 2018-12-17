package com.github.fazraal.controller;

import com.github.fazraal.AllStudent;
import com.github.fazraal.Strategy;

import java.io.File;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public  void  print(AllStudent student, String type , int index){
        this.strategy.doOperation(student,type,index);
    }

}
