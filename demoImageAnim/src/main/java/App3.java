/*
 * FXGL - JavaFX Game Library. The MIT License (MIT).
 * Copyright (c) AlmasB (almaslvl@gmail.com).
 * See LICENSE for details.
 */

// Importaciones necesarias para la aplicación
import com.almasb.fxgl.animation.Interpolators;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.animation.Interpolator;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;


import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;


public class App3 extends GameApplication {
    AnimatedTexture animTexture;


    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1480);
        settings.setHeight(1020);
    }


    @Override
    protected void initGame() {
        // Configura el color de fondo de la escena del juego
        getGameScene().setBackgroundColor(Color.BLACK);

        //Traigo el sprite completo.
        animTexture = texture("sprite_pug.png").toAnimatedTexture(9, Duration.seconds(0.6));



            // Invoca el método para colocar un robot en la posición calculada

           // spawnRobot();


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

        // Crea un botón que al hacer clic, invoca la creación de un robot desde un frame específico
     //Crearé 4 botones
        var btnDown = new Button("Down");
        var btnLeft= new Button("Left");
        var btnRight = new Button("Right");
        var btnUp = new Button("Up");
        btnDown.setOnAction(e->{ animTexture.playFrom(1);});
        btnLeft.setOnAction(e->{ animTexture.playFrom(4);});
        btnRight.setOnAction(e->{ animTexture.playFrom(7);});
        btnUp.setOnAction(e->{ animTexture.playFrom(10);});

        // Organiza los controles en un VBox y lo agrega a la escena UI
        var vboxDown = new VBox(10, frameSpinner, btnDown);
        var vboxLeft = new VBox(10, frameSpinner, btnLeft);
        var vboxRight = new VBox(10, frameSpinner, btnRight);
        var vboxUp = new VBox(10, frameSpinner, btnUp);

        addUINode(vboxDown, 1230, 500);
        addUINode(vboxLeft, 1230, 550);
        addUINode(vboxRight, 1230, 600);
        addUINode(vboxUp, 1230, 660);

    }

    // Método para crear un robot y reproducir la animación desde un frame específico
    //x
    private void spawnRobotForFrame(double x, double y, int startFrame) {
        // Crea un canal de animación y una textura animada
        var animChannel = new AnimationChannel(image("robot_roll.png"), 7, 275, 275, Duration.seconds(2.6), 0, 23);
        var animTexture = new AnimatedTexture(animChannel);
        animTexture.playFrom(startFrame);

        // Construye y adjunta la entidad del robot a la escena del juego
        var e = entityBuilder()
                .at(x, y)
                .view(animTexture)
                .buildAndAttach();

        // Configura la acción a realizar cuando se completa un ciclo de animación
        //animTexture.setOnCycleFinished(() -> e.removeFromWorld());
    }

    // Método para crear un robot con un interpolador específico y un nombre
    private void spawnRobot(double x, double y, Interpolator interpolator, String name) {
        // Añade un texto con el nombre del interpolador cerca del robot
        var text = addText(name, x + 120, y + 30);
        text.fontProperty().unbind();
        text.setFont(Font.font(18));

        // Crea un canal de animación y una textura animada con el interpolador dado
        var animChannel = new AnimationChannel(image("robot_roll.png"), 7, 275, 275, Duration.seconds(2.6), 0, 23);
        var animTexture = new AnimatedTexture(animChannel);
        animTexture.setInterpolator(interpolator);
        animTexture.loop();

        // Construye y adjunta la entidad del robot a la escena del juego
        entityBuilder()
                .at(x, y)
                .view(animTexture)
                .buildAndAttach();
    }

    // Método para crear un robot con opciones de reproducción específicas
    private void spawnRobot(double x, double y, boolean isReverse, boolean isLoop) {
        // Añade un texto indicando el modo de reproducción cerca del robot
        var text = addText(isReverse ? "Reverse" : "Play", x + 120, y + 30);
        text.fontProperty().unbind();
        text.setFont(Font.font(18));

        // Crea un canal de animación y una textura animada con opciones de reproducción
        var animChannel = new AnimationChannel(image("robot_death.png"), 7, 275, 275, Duration.seconds(2.6), 0, 26);
        var animTexture = new AnimatedTexture(animChannel);

        // Configura la animación según las opciones de reproducción
        if (isLoop) {
            if (isReverse) {
                animTexture.loopReverse();
            } else {
                animTexture.loop();
            }
        } else {
            if (isReverse) {
                animTexture.playReverse();
            } else {
                animTexture.play();
            }
        }

        // Construye y adjunta la entidad del robot a la escena del juego
        entityBuilder()
                .at(x, y)
                .view(animTexture)
                .buildAndAttach();
    }






    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        launch(args);
    }
}
