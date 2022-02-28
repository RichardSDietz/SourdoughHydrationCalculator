package com.example.sourdoughhydrationhelper;

public class DoughType {
    private String doughTypeName;
    public DoughType(String doughTypeName) { this.doughTypeName = doughTypeName; }
    public String getDoughTypeName(){ return doughTypeName; }
    public void setDoughTypeName(String doughTypeName){ this.doughTypeName = doughTypeName; }

    @Override
    public String toString() { return doughTypeName; }
}
