/*
 * FXGL - JavaFX Game Library. The MIT License (MIT).
 * Copyright (c) AlmasB (almaslvl@gmail.com).
 * See LICENSE for details.
 */

// Importaciones necesarias para la aplicación
import com.almasb.fxgl.animation.Interpolators;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.animation.Interpolator;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;


import java.awt.*;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;


public class App3 extends GameApplication {
    AnimatedTexture animTexture;
    String nameImagePug = "sprite_pug.png";

    AnimatedTexture  animTextureDown, animTextureLeft, animTextureRight, animTextureUp;
    Entity player;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1480);
        settings.setHeight(1020);
    }


    @Override
    protected void initGame() {
        // Configura el color de fondo de la escena del juego
        getGameScene().setBackgroundColor(Color.gray(0.5));


/*--------Esta parte la llevo a newPlayerAnimado() ------------
    -----------------------------------------------------

        Image imageTexturePug = image(nameImagePug);
        int iWidth= (int) (imageTexturePug.getWidth()/3);
        int iHeight= (int) (imageTexturePug.getHeight()/4);




    //Traigo el sprite completo.
        animTexture = texture(nameImagePug).toAnimatedTexture(12, Duration.seconds(0.6));

//4 movimientos
        var animChannelDown  = new AnimationChannel(imageTexturePug, 3, iWidth,iHeight, Duration.seconds(2.6), 0, 2);
        var animChannelLeft  = new AnimationChannel(imageTexturePug,3 , iWidth, iHeight, Duration.seconds(2.6), 3, 5);
        var animChannelRight = new AnimationChannel(imageTexturePug,3 ,iWidth ,iHeight, Duration.seconds(2.6), 6, 8);
        var animChannelUp    = new AnimationChannel(imageTexturePug, 3, iWidth,iHeight,Duration.seconds(2.6), 9, 11);

        animTextureDown=new AnimatedTexture(animChannelDown);
        animTextureLeft=new AnimatedTexture(animChannelLeft);
        animTextureRight=new AnimatedTexture(animChannelRight);
        animTextureUp=new AnimatedTexture(animChannelUp);

        animTextureLeft.loop();

        // Invoca el método para colocar un robot en la posición calculada
        // Creo a Player

        // spawnRobot();
        // Construye y adjunta la entidad del robot a la escena del juego
        entityBuilder()
                .type(AppType.PLAYER)
                .view(animTextureLeft)
                .at(50,50)

                .collidable()
                .buildAndAttach();
        // Configura la acción a realizar cuando se completa un ciclo de animación
        //animTexture.setOnCycleFinished(() -> e.removeFromWorld());

----
-------------
*/


    }
    public Entity newPlayer() {
        return entityBuilder()
                .type(AppType.PLAYER)
                .viewWithBBox(new Rectangle(25,25,Color.BEIGE))
                .at(200,200)
                .collidable()
                .buildAndAttach();
    }

    public Entity playerUp(){
        Image imageTexturePug = image(nameImagePug);
        int iWidth= (int) (imageTexturePug.getWidth()/3);
        int iHeight= (int) (imageTexturePug.getHeight()/4);


         var animChannelUp    = new AnimationChannel(imageTexturePug, 3, iWidth,iHeight,Duration.seconds(2.6), 9, 11);
        animTextureUp=new AnimatedTexture(animChannelUp);



        // Construye y adjunta(attach) la entidad del robot a la escena del juego
        return entityBuilder()
                .type(AppType.PLAYER)
                .view(animTextureUp.loop())
                .at(50,50)

                .collidable()
                .buildAndAttach();

    }
    public Entity playerDown(){
        Image imageTexturePug = image(nameImagePug);
        int iWidth= (int) (imageTexturePug.getWidth()/3);
        int iHeight= (int) (imageTexturePug.getHeight()/4);

        var animChannelDown  = new AnimationChannel(imageTexturePug, 3, iWidth,iHeight, Duration.seconds(2.6), 0, 2);

        animTextureDown=new AnimatedTexture(animChannelDown);



        // Construye y adjunta(attach) la entidad del robot a la escena del juego
        return entityBuilder()
                .type(AppType.PLAYER)
                .view(animTextureDown.loop())
                .at(50,50)

                .collidable()
                .buildAndAttach();

    }
    public Entity playerRight(){
        Image imageTexturePug = image(nameImagePug);
        int iWidth= (int) (imageTexturePug.getWidth()/3);
        int iHeight= (int) (imageTexturePug.getHeight()/4);
var animChannelRight = new AnimationChannel(imageTexturePug,3 ,iWidth ,iHeight, Duration.seconds(2.6), 6, 8);

         animTextureRight=new AnimatedTexture(animChannelRight);

        // Construye y adjunta(attach) la entidad del robot a la escena del juego
        return entityBuilder()
                .type(AppType.PLAYER)
                .view(animTextureRight.loop())
                .at(50,50)

                .collidable()
                .buildAndAttach();

    }
    public Entity playerLeft(){
        Image imageTexturePug = image(nameImagePug);
        int iWidth= (int) (imageTexturePug.getWidth()/3);
        int iHeight= (int) (imageTexturePug.getHeight()/4);

         var animChannelLeft  = new AnimationChannel(imageTexturePug,3 , iWidth, iHeight, Duration.seconds(2.6), 3, 5);
         animTextureLeft=new AnimatedTexture(animChannelLeft);




        // Construye y adjunta(attach) la entidad del robot a la escena del juego
        return entityBuilder()
                .type(AppType.PLAYER)
                .view(animTextureLeft.loop())
                .at(50,50)

                .collidable()
                .buildAndAttach();

    }


    public Entity newPlayerAnimado(AnimatedTexture name){
        Image imageTexturePug = image(nameImagePug);
        int iWidth= (int) (imageTexturePug.getWidth()/3);
        int iHeight= (int) (imageTexturePug.getHeight()/4);

        //Traigo el sprite completo.
       // animTexture = texture(nameImagePug).toAnimatedTexture(12, Duration.seconds(0.6));

//4 movimientos
        var animChannelDown  = new AnimationChannel(imageTexturePug, 3, iWidth,iHeight, Duration.seconds(2.6), 0, 2);
        var animChannelLeft  = new AnimationChannel(imageTexturePug,3 , iWidth, iHeight, Duration.seconds(2.6), 3, 5);
        var animChannelRight = new AnimationChannel(imageTexturePug,3 ,iWidth ,iHeight, Duration.seconds(2.6), 6, 8);
        var animChannelUp    = new AnimationChannel(imageTexturePug, 3, iWidth,iHeight,Duration.seconds(2.6), 9, 11);

        animTextureDown=new AnimatedTexture(animChannelDown);
        animTextureLeft=new AnimatedTexture(animChannelLeft);
        animTextureRight=new AnimatedTexture(animChannelRight);
        animTextureUp=new AnimatedTexture(animChannelUp);


        AnimatedTexture animTextureAsignada;
        if (name == animTextureDown) animTextureAsignada=animTextureDown;
        if (name == animTextureRight) animTextureAsignada=animTextureRight;
        if (name == animTextureLeft) animTextureAsignada=animTextureLeft;
        if (name == animTextureUp) animTextureAsignada=animTextureUp;



        // Construye y adjunta(attach) la entidad del robot a la escena del juego
       return entityBuilder()
                .type(AppType.PLAYER)
                .view(animTexture.loop())
                .at(50,50)

                .collidable()
                .buildAndAttach();


    }



    // Método para inicializar la interfaz de usuario (UI)
    @Override
    protected void initUI() {
    // Crea un control Spinner para seleccionar un frame específico
        //public Spinner(("min"), ("max"), ("initialValue"));
        // * Un Spinner es un control de interfaz de usuario en JavaFX que permite al usuario seleccionar un valor de
        // un conjunto predefinido o un rango específico.
        // Puede ser utilizado para seleccionar números, fechas, horas, u otros tipos de datos.
        // *
        var frameSpinner = new Spinner<Integer>(0, 23, 0);
        frameSpinner.setPrefWidth(200);

    // Crear Botón que al hacer clic, invoca la creación de un robot desde un frame específico
     //Crearé 4 botones
        var btnDown = new Button("Down");
        var btnLeft= new Button("Left");
        var btnRight = new Button("Right");
        var btnUp = new Button("Up");

      // Agrego funciones a cada botón
        /* -- Forma A ---
        btnDown.setOnAction(e->{ animTexture.playFrom(1);});
        btnLeft.setOnAction(e->{ animTexture.playFrom(4);});
        btnRight.setOnAction(e->{ animTexture.playFrom(7);});
        btnUp.setOnAction(e->{ animTexture.playFrom(10);});
        */
        /* -- Forma B --
        btnDown.setOnAction(e->{ animTextureDown.loop();});
        btnLeft.setOnAction(e->{ animTextureLeft.loop();});
        btnRight.setOnAction(e->{ animTextureRight.loop();});
        btnUp.setOnAction(e->{ animTextureUp.loop();});
        */

        /*
        * -- Forma C --
        * */

        btnDown.setOnAction(e->playerDown() );
        btnLeft.setOnAction(e->playerLeft());
        btnRight.setOnAction(e-> playerRight());
        btnUp.setOnAction(e-> playerUp());


        // Organiza los controles en un VBox
        var vboxDown = new VBox(10, frameSpinner, btnDown);
        var vboxLeft = new VBox(10, frameSpinner, btnLeft);
        var vboxRight = new VBox(10, frameSpinner, btnRight);
        var vboxUp = new VBox(10, frameSpinner, btnUp);

        // Agrego los VBox a la escena UI
        addUINode(vboxDown, 1100, 700);
        addUINode(vboxLeft, 1050, 650);
        addUINode(vboxRight, 1150, 650);
        addUINode(vboxUp, 1100, 600);

        // Organiza los controles en un VBox y lo agrega a la escena UI


    }

    // Método para crear un robot y reproducir la animación desde un frame específico







    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        launch(args);
    }
}
