package com.fz;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import lombok.extern.slf4j.Slf4j;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Slf4j
public class Main {

    public static final LocalTime TIMEFRAME_START = LocalTime.of(9, 0);
    public static final LocalTime TIMEFRAME_END = LocalTime.of(22, 0);

    public void run() throws NativeHookException, AWTException {
        log.info("Welcome to TapAlive");
        Reference<LocalTime> lastActivityTime = new Reference<>(LocalTime.now());
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(new GlobalKeyListener(lastActivityTime));
        GlobalScreen.addNativeMouseListener(new GlobalMouseMovementListener(lastActivityTime));
        GlobalScreen.addNativeMouseMotionListener(new GlobalMouseMovementListener(lastActivityTime));
        Robot bot = new Robot();
        while (true) {
            var now = LocalTime.now();
            if (now.isBefore(TIMEFRAME_START) || now.isAfter(TIMEFRAME_END)) {
                log.error("OUT_OF_TIMEFRAME");
                System.exit(1);
            }
            bot.delay(30 * 1000);
            if (ChronoUnit.MINUTES.between(lastActivityTime.get(), LocalTime.now()) < 1) {
                log.info("Ignoring because recent activity detected at {}", lastActivityTime.get());
                continue;
            }
            Point pointerLocation = MouseInfo.getPointerInfo().getLocation();
            log.info("Triggered mouse down at {}", pointerLocation);
            bot.mouseMove(pointerLocation.x, pointerLocation.y);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    public static void main(String[] args) throws AWTException, NativeHookException {
        Main main = new Main();
        main.run();
    }
}