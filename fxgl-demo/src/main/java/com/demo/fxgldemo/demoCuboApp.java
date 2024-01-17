package com.demo.fxgldemo;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.input.view.KeyView;
import com.almasb.fxgl.input.virtual.VirtualButton;
import com.demo.fxgldemo.components.PlayerComponent;
import com.demo.fxgldemo.components.PlayerCuboComponent;
import com.demo.fxgldemo.factories.DemoFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGL.set;
import static com.almasb.fxgl.dsl.FXGLForKtKt.onKey;

public class demoCuboApp extends GameApplication {

    public static void main(String[] args) {
        launch(args);

    }


    //Agregamos referencia al Factory y a nuestro player
    private final DemoFactory demoFactory = new DemoFactory();
    private Entity playerCubo;
    private Entity playerCubo2;

    @Override
    protected void initSettings(GameSettings gameSettings) {

        System.out.println(" ------------------------------------------       Estoy en initSettings    ");
        gameSettings.setTitle("Probando demoCuboApp");
        gameSettings.setMainMenuEnabled(false);

    }

    @Override
    protected void initInput() {
        System.out.println(" ------------------------------------------       Estoy en initInput     -------------");


        // onKey(KeyCode.A,() -> playerCubo.translateX(-5.0));
        onKey(KeyCode.A, () -> {
            System.out.println("-------he presionado hacia la Izquierda --------");
            playerCubo.translateX(-5.0);
            return null; // Agrega esta línea para indicar que la expresión lambda retorna null

        });
        onKey(KeyCode.D, () -> {
            playerCubo.translateX(5.0);
            return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });
        onKey(KeyCode.W, () -> {
            playerCubo.translateY(-5.0);
            return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });
        onKey(KeyCode.S, () -> {
            playerCubo.translateY(5.0);
            return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });

        // ------------------ Playercubo2 --------------------
        onKey(KeyCode.J, () -> {
            playerCubo2.translateX(-5.0);
            return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });
        onKey(KeyCode.L, () -> {
            playerCubo2.translateX(5.0);
            return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });
        onKey(KeyCode.I, () -> {
            playerCubo2.translateY(-5.0);
            return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });
        onKey(KeyCode.K, () -> {
            playerCubo2.translateY(5.0);
            return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });



    }


    @Override
    protected void initGame() {

        getGameWorld().addEntityFactory(demoFactory);
        //getGameScene().setBackgroundColor(Paint.valueOf("green"));
        getGameScene().setBackgroundColor(Color.color(0, 0, 0.05, 1.0));

        playerCubo = spawn("playerCubo",0,450);//lo ubico abajo en el centro
        set("playerCubo", playerCubo);

        playerCubo2 = spawn("playerCubo2",500,5);//lo ubico abajo en el centro
        set("playerCubo2", playerCubo2);//agrego a properties del GameWorld.

        spawn("playerCubo3",50,50);//creo cubo para luego agregar imagen

        //generamos 2 tipos de objeto aleatoriamente
        run( ()->{
            var ax = random(25,800);
            var ay = random(25,600);

            spawn("c1",ax,ay);


        }, Duration.seconds(0.1));
        run( ()->{
            var ax2 = random(25,800);
            var ay2 = random(25,600);

            spawn("c2",ax2,ay2);
        }, Duration.seconds(0.7));

        run(()->{
            spawn("rect",0,50);
        },Duration.seconds(0.9));


        System.out.println(" ------------------------------------------       Estoy en initGame     -------------");
        System.out.println(" ------------------------------------------ Las properties son:   "+getGameWorld().getProperties().toStringMap()+"--------------------------");
    }






}
