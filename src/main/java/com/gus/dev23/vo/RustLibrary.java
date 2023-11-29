package com.gus.dev23.vo;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface RustLibrary extends Library {
    RustLibrary INSTANCE = Native.load("fx_lic", RustLibrary.class);
    int add(int left, int right);
    void foo();
}
