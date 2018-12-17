package com.github.fazraal.controller;

import com.github.fazraal.AllStudent;
import com.github.fazraal.Strategy;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<Integer, Strategy> strategyMap = new HashMap<>();
    private static  final  Context CONTEXT = new Context();

    public  static  Context instance(){
        return CONTEXT;
    }

    public  void  register(int strategyKey , Strategy strategy){
        this.strategyMap.put(strategyKey , strategy);
    }

    public Strategy getStrategy(int strategyKey) throws IllegalAccessException {
        Strategy strategy = strategyMap.get(strategyKey);
        if(strategy == null){
            throw  new IllegalAccessException("Неверный ключ команды");
        }
        return  strategy;
    }
}
