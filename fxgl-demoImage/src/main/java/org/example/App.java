package org.example;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;

import static com.almasb.fxgl.dsl.FXGL.getGameWorld;
import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

/**
 * Hello world!
 *
 */
public class App extends GameApplication {

    private final AppFactory appFactory = new AppFactory();
    private Entity image;
    @Override
    protected void initSettings(GameSettings gameSettings) {

        gameSettings.setTitle("DemoImage");
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(appFactory);

        spawn("image",100,0);

    }

    //fin
    public static void main( String[] args ) { launch(args); }
}
