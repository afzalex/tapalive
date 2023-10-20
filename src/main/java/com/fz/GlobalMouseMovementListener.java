package com.fz;


import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;

import java.time.LocalTime;

public class GlobalMouseMovementListener implements NativeMouseInputListener {

    Reference<LocalTime> lastActivityTime;

    public GlobalMouseMovementListener(Reference<LocalTime> lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }


    @Override
    public void nativeMouseClicked(NativeMouseEvent e) {
        lastActivityTime.set(LocalTime.now());
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent e) {
        lastActivityTime.set(LocalTime.now());
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {
        lastActivityTime.set(LocalTime.now());
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent e) {
        lastActivityTime.set(LocalTime.now());
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent e) {
        lastActivityTime.set(LocalTime.now());
    }
}
