package com.demo.fxgldemo;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

public class demoApp extends GameApplication {
    public static void main(String[] args) { launch(args);    }

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setMainMenuEnabled(true);
        gameSettings.setTitle("Demo Fac 1");
       gameSettings.setAppIcon("bf-asomado.png");
    }
}
