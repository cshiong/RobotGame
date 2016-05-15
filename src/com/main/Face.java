package com.main;

/**
 * Created by cboyd002c on 5/11/16.
 */
public enum Face {
    N("NORTH"),
    E("EAST"),
    S("SOUTH"),
    W("WEST");

     private final String name;

    private Face(final String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return getName();
    }

}
