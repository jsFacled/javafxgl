package com.demo.fxgldemo;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.Viewport;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.input.virtual.VirtualButton;
import com.demo.fxgldemo.components.PlayerComponent;
import javafx.scene.input.KeyCode;

import static com.almasb.fxgl.dsl.FXGL.*;


/**
 * Aquí se crea la Entidad Player, en initGame() con: player = spawn("player", 50, 50);
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
    Creacion del GameWorld
    * */

        /*
        Creación del Player
        * */
        player = spawn("player", 50, 50);
        set("player", player);


    /*
    getGameWorld().addEntityFactory(new PlatformerFactory());

    player = null;
    nextLevel();

    // player must be spawned after call to nextLevel, otherwise player gets removed
    // before the update tick _actually_ adds the player to game world
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