package com.fz;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.time.LocalTime;

public class GlobalKeyListener implements NativeKeyListener {

    IgnorableReference<LocalTime> lastActivityTime;

    public GlobalKeyListener(IgnorableReference<LocalTime> lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        this.lastActivityTime.set(LocalTime.now());
    }

}