package com.fz;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.time.LocalTime;

public class GlobalKeyListener implements NativeKeyListener {

    Reference<LocalTime> lastActivityTime;

    public GlobalKeyListener(Reference<LocalTime> lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        this.lastActivityTime.set(LocalTime.now());
    }

}