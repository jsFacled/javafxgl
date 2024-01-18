package org.example;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.KeyCode;

import static com.almasb.fxgl.dsl.FXGL.getGameWorld;
import static com.almasb.fxgl.dsl.FXGL.set;
import static com.almasb.fxgl.dsl.FXGLForKtKt.onKey;
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
    protected void initInput() {
        onKey(KeyCode.A, () -> {
            System.out.println("-------he presionado hacia la Izquierda --------");
            image.translateX(-5.0);
            return null; // Agrega esta línea para indicar que la expresión lambda retorna null

        });
        onKey(KeyCode.D, () -> {
            image.translateX(5.0);
            return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(appFactory);

        image = spawn("image",500,500);
        set("image", image);

    }

    //fin
    public static void main( String[] args ) { launch(args); }
}
