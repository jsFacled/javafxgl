package org.example;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;

/**
 * Hello world!
 */
public class App extends GameApplication {

    private final AppFactory appFactory = new AppFactory();
    private Entity image;
    private Entity huesoAleatorio;
    private Entity nave;


    @Override
    protected void initSettings(GameSettings gameSettings) {

        gameSettings.setTitle("DemoImage");
    }


    @Override
    protected void initInput() {
        onKey(KeyCode.A, () -> {
            System.out.println("-------he presionado hacia la Izquierda --------");
            image.translateX(-5.0);
            //return null; // Agrega esta línea para indicar que la expresión lambda retorna null

        });
        onKey(KeyCode.D, () -> {
            image.translateX(5.0);
            //return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });

        onKey(KeyCode.W, () -> {
            image.translateY(-5.0);
            // return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });
        onKey(KeyCode.S, () -> {
            image.translateY(5.0);
            // return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });


    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(appFactory);

        //Agrego un background
        getGameScene().setBackgroundColor(Color.color(0, 0.800, 0.05, 1.0));

        image = spawn("image");
        set("image", image);

      nave = spawn("nave");
      nave.translateX(100);
      set("nave", nave);



        //Creación aleatoria de huesos
        run(() -> {
            spawn("huesoAleatorio");
            }, Duration.seconds(0.5));




    }

    //fin
    public static void main(String[] args) {
        launch(args);
    }
}
