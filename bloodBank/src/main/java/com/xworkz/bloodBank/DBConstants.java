package com.xworkz.bloodBank;

//@Component
public enum DBConstants {



    URL("jdbc:mysql://localhost:3306/library"),
    USERNAME("root"),
    PWD("tiger");
    private String s;

    DBConstants(String s)
    {
        this.s = s;
    }
public String getS(){
        return s;
}


}
