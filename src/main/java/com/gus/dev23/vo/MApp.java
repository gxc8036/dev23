package com.gus.dev23.vo;

public class MApp {
    static{
        System.setProperty("jna.library.path", "/Users/gus/Library/Java/Extensions");
    }
    public static void main(String[] args) {
        int result = RustLibrary.INSTANCE.add(1, 2);
        System.out.println("Result: " + result);
    }
}
