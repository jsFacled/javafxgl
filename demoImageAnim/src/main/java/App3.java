/*
 * FXGL - JavaFX Game Library. The MIT License (MIT).
 * Copyright (c) AlmasB (almaslvl@gmail.com).
 * See LICENSE for details.
 */

// Importaciones necesarias para la aplicación

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;


/**
 * En App3 hay 4 Botones que cambian la posición del jugador animado.
 * Inicializa con playerDown.
 */

public class App3 extends GameApplication {
    String nameImagePug = "sprite_pug.png";
    AnimatedTexture  animTextureDown, animTextureLeft, animTextureRight, animTextureUp;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1480);
        settings.setHeight(1020);
    }


    @Override
    protected void initGame() {
        // Configura el color de fondo de la escena del juego
        //Set the background color of the game scene
        getGameScene().setBackgroundColor(Color.gray(0.5));
        playerDown();
    }

    /**
     * --------------------- 4 methods that create the player's position ----------
     *------------------------------------------------------------------------------
     */

    public Entity playerUp(){
        Image imageTexturePug = image(nameImagePug);
        int iWidth= (int) (imageTexturePug.getWidth()/3);
        int iHeight= (int) (imageTexturePug.getHeight()/4);

        var animChannelUp    = new AnimationChannel(imageTexturePug, 3, iWidth,iHeight,Duration.seconds(2.6), 9, 11);
        animTextureUp=new AnimatedTexture(animChannelUp);

        return entityBuilder()
                .type(AppType.PLAYER)
                .view(animTextureUp.loop())
                .at(getAppCenter())
                .collidable()
                .buildAndAttach();
    }

    public Entity playerDown(){
        Image imageTexturePug = image(nameImagePug);
        int iWidth= (int) (imageTexturePug.getWidth()/3);
        int iHeight= (int) (imageTexturePug.getHeight()/4);

        var animChannelDown  = new AnimationChannel(imageTexturePug, 3, iWidth,iHeight, Duration.seconds(2.6), 0, 2);
        animTextureDown=new AnimatedTexture(animChannelDown);

        return entityBuilder()
                .type(AppType.PLAYER)
                .view(animTextureDown.loop())
                .at(getAppCenter())
                .collidable()
                .buildAndAttach();
    }

    public Entity playerRight(){
        Image imageTexturePug = image(nameImagePug);
        int iWidth= (int) (imageTexturePug.getWidth()/3);
        int iHeight= (int) (imageTexturePug.getHeight()/4);

        var animChannelRight = new AnimationChannel(imageTexturePug,3 ,iWidth ,iHeight, Duration.seconds(2.6), 6, 8);
        animTextureRight=new AnimatedTexture(animChannelRight);

        return entityBuilder()
                .type(AppType.PLAYER)
                .view(animTextureRight.loop())
                .at(getAppCenter())

                .collidable()
                .buildAndAttach();
    }

    public Entity playerLeft(){
        Image imageTexturePug = image(nameImagePug);
        int iWidth= (int) (imageTexturePug.getWidth()/3);
        int iHeight= (int) (imageTexturePug.getHeight()/4);

        var animChannelLeft  = new AnimationChannel(imageTexturePug,3 , iWidth, iHeight, Duration.seconds(2.6), 3, 5);
        animTextureLeft=new AnimatedTexture(animChannelLeft);

        return entityBuilder()
                .type(AppType.PLAYER)
                .view(animTextureLeft.loop())
                .at(getAppCenter())
                .collidable()
                .buildAndAttach();
    }


    /**
     *
     * ------------------------- UI -------------------------
     * ------------------------------------------------------
     */

    @Override
    protected void initUI() {


        var frameText = new Label("Clik Down, Left, Right or Up!");
        frameText.setTextFill(Color.WHITE);
        frameText.setFont(Font.font("Verdama",25));

        ;

    // Crear Botón que al hacer clic, invoca la creación de un robot desde un frame específico
     //Crearé 4 botones
        /// Create Button that, when clicked, invokes the creation of a robot from a specific frame
        ///I will create 4 buttons
        var btnDown = new Button("Down");
        var btnLeft= new Button("Left");
        var btnRight = new Button("Right");
        var btnUp = new Button("Up");


        btnDown.setOnAction(e->playerDown() );
        btnLeft.setOnAction(e->playerLeft());
        btnRight.setOnAction(e-> playerRight());
        btnUp.setOnAction(e-> playerUp());


        // Organiza los controles en un VBox
        /// Organize controls in a VBox
        /*
        var vboxDown = new VBox(10, frameSpinner, btnDown);
        var vboxLeft = new VBox(10, frameSpinner, btnLeft);
        var vboxRight = new VBox(10, frameSpinner, btnRight);
        var vboxUp = new VBox(10, frameSpinner, btnUp);


        // Agrego los VBox a la escena UI
        /// I add the VBoxes to the UI scene
        addUINode(vboxDown, 1100, 700);
        addUINode(vboxLeft, 1050, 650);
        addUINode(vboxRight, 1150, 650);
        addUINode(vboxUp, 1100, 600);

        */



        // Agrego los VBox a la escena UI
        /// I add the VBoxes to the UI scene
        addUINode(btnDown, 1100, 700);
        addUINode(btnLeft, 1050, 650);
        addUINode(btnRight, 1150, 650);

        addUINode(btnUp, 1100, 600);
        addUINode(frameText, 950, 550);

    }



    public static void main(String[] args) {
        launch(args);
    }
}
