package org.example;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.Viewport;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.PhysicsWorld;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import static com.almasb.fxgl.dsl.FXGL.*;
import static org.example.AppType.*;

/**
 * Hello world!
 */
public class App extends GameApplication {

    private final AppFactory appFactory = new AppFactory();
    private Entity player;
    private Entity image;
    private Entity huesoAleatorio;
    private Entity nave;
    private Entity backround;

    @Override
    protected void initSettings(GameSettings gameSettings) {

        gameSettings.setTitle("DemoImage");
        gameSettings.setWidth(800);
        gameSettings.setHeight(600);


    }

    public void anim() {
        //Creación de AnimatedTexture utilizando AnimationChannel

        AnimatedTexture texture;
        AnimationChannel animIdle, animWalk;

        Image image = image("lilpuddinpuggums.png");

        animIdle = new AnimationChannel(image, 4, 32, 42, Duration.seconds(1), 1, 1);
        animWalk = new AnimationChannel(image, 4, 32, 42, Duration.seconds(0.66), 0, 3);

        texture = new AnimatedTexture(animIdle);
        texture.loop();




    }

    @Override
    protected void initInput() {


        onKey(KeyCode.A, () -> {
            System.out.println("-------he presionado hacia la Izquierda --------");
            player.translateX(-5.0);

            //return null; // Agrega esta línea para indicar que la expresión lambda retorna null

        });
        onKey(KeyCode.D, () -> {
            player.translateX(5.0);
            //return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });

        onKey(KeyCode.W, () -> {
            player.translateY(-5.0);
            // return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });
        onKey(KeyCode.S, () -> {
            player.translateY(5.0);
            // return null; // Agrega esta línea para indicar que la expresión lambda retorna null
        });


    }

    @Override
    protected void initPhysics() {
        //--El perrito come huesos:--
        /// Obtengo el PhysicsWold con getPhysicsWorld()
        /// Agrego un Manejador de Colision
        /// Indico un Handler, en este caso creo uno nuevo aquí sobreescribiendo su métdo onCollisionBegin.
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(PLAYER, HUESO) {
            @Override
            protected void onCollisionBegin(Entity i, Entity h) {
                h.removeFromWorld();
                System.out.println("////////************///////////////****************");
            }
        });
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(appFactory);

        //Agrego un background
        //getGameScene().setBackgroundRepeat("bfrances.png");//La repite 4 veces en toda la pantalla de acuerdo a su tamaño.
        //getGameScene().setBackgroundColor(Color.color(0, 0.800, 0.05, 1.0));

        backround = spawn("background");


        player = spawn("player");
        set("player", player);

        nave = spawn("nave");
        nave.translateX(100);
        set("nave", nave);


        //Creación aleatoria de huesos
        run(() -> {
            spawn("huesoAleatorio");
        }, Duration.seconds(0.2));

        //La pantalla seguirá al Jugador y se duplicará de ser necesario.
        Viewport viewport = getGameScene().getViewport();
        viewport.setBounds(-1500, 0, 250 * 70, getAppHeight());
        viewport.bindToEntity(player, getAppWidth() / 2, getAppHeight() / 2);
        viewport.setLazy(true);

    }


    //fin
    public static void main(String[] args) {
        launch(args);
    }
}
