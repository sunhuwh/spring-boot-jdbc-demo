package com.my.app.dao.impl;

public abstract class BasicDaoImpl {
    
    protected Integer converInt(Object o){
        if(o==null){
            return null;
        }
        return ((Number)o).intValue();
    }
    
    protected String converString(Object o){
        if(o==null){
            return null;
        }
        return String.valueOf(o);
    }
    
}
