package com.demo.fxgldemo;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.Viewport;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.input.virtual.VirtualButton;
import com.demo.fxgldemo.components.PlayerComponent;
import com.demo.fxgldemo.factories.DemoFactory;
import javafx.scene.input.KeyCode;

import static com.almasb.fxgl.dsl.FXGL.*;


/**
 * GameApplication es el GameWorld.
 * Aquí se crea la Entidad Player, en initGame() con: player = spawn("player", 50, 50);
 * Para obtener el Mundo del Juego se llama a getGameWold().
 *
 */


public class demoApp extends GameApplication {
    public static void main(String[] args) {
        launch(args);
    }

    private Entity player;

    @Override
    protected void initSettings(GameSettings gameSettings) {

        gameSettings.setWidth(1280);
        gameSettings.setHeight(720);
        gameSettings.setTitle("Demo Fac 1");
        gameSettings.setAppIcon("bf-asomado.png");

    }

    @Override
    protected void initInput() {
        getInput().addAction(new UserAction("Left") {
            @Override
            protected void onAction() {
                player.getComponent(PlayerComponent.class).left();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(PlayerComponent.class).stop();
            }
        }, KeyCode.A, VirtualButton.LEFT);

        getInput().addAction(new UserAction("Right") {
            @Override
            protected void onAction() {
                player.getComponent(PlayerComponent.class).right();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(PlayerComponent.class).stop();
            }
        }, KeyCode.D, VirtualButton.RIGHT);

        getInput().addAction(new UserAction("Jump") {
            @Override
            protected void onActionBegin() {
                player.getComponent(PlayerComponent.class).jump();
            }
        }, KeyCode.W, VirtualButton.A);

    }


    /**
     * Creación del Mundo del Juego
     */

    @Override
    protected void initGame() {
        /*
        *   // Agregamos primero el Factory
        * */
        getGameWorld().addEntityFactory(new DemoFactory());


        /*
            ** // Creación del Player.
          *Primero hay que configurarlo en un Factory. He creado la clase demoFactory
        * */
        player = spawn("player", 50, 50);//llama al método que crea un player.
        set("player", player);//lo agrega al GameWorld.


    /*
    getGameWorld().addEntityFactory(new PlatformerFactory());

    player = null;
    nextLevel();

    // player must be spawned after call to nextLevel, otherwise player gets removed
      //El jugador debe generarse después de llamar al siguiente nivel; de lo contrario, el jugador será eliminado.
    // before the update tick _actually_ adds the player to game world
      //antes de la marca de actualización _en realidad_ agrega al jugador al mundo del juego
    player = spawn("player", 50, 50);

    set("player", player);

    spawn("background");

    Viewport viewport = getGameScene().getViewport();
    viewport.setBounds(-1500, 0, 250 * 70, getAppHeight());
    viewport.bindToEntity(player, getAppWidth() / 2, getAppHeight() / 2);
    viewport.setLazy(true);
     */


    }
}