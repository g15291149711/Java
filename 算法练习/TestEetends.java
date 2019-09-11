package com.gxg;



class Base{
    public Base(){
        System.out.println("sss");
    }
    public Base(String s){
        System.out.print("B");
    }
}
public class TestEetends extends Base{
    public TestEetends (String s) {
        System.out.print("D");
    }
    public static void main(String[] args){
        TestEetends testEetends = new TestEetends("C");
    }
}
