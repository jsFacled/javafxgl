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
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

// Importación estática para facilitar el acceso a funciones de FXGL
import static com.almasb.fxgl.dsl.FXGL.*;

/**
 * Clase principal que extiende GameApplication para crear la aplicación de juego.
 * Implementa varios métodos para la inicialización y gestión del juego.
 */
public class App2 extends GameApplication {

    // Método para configurar los ajustes del juego
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1480);
        settings.setHeight(1020);
    }

    // Método para inicializar los elementos del juego
    @Override
    protected void initGame() {
        // Configura el color de fondo de la escena del juego
        getGameScene().setBackgroundColor(Color.BLACK);

        // Obtiene todos los interpoladores disponibles
        var interpolators = Interpolators.values();

        // Crea y coloca robots en función de los interpoladores
        // Son 14 en total (2 filas de 7)
        for (int i = 0; i < interpolators.length; i++) {
            // Calcula las posiciones en función de la fila y columna en la hoja de sprites
            var x = i % 7;
            var y = i / 7;

            // Invoca el método para colocar un robot en la posición calculada
            spawnRobot(x * 150, y * 360, interpolators[i].EASE_OUT(), interpolators[i].toString());
        }

        // Crea y coloca robots adicionales con diferentes configuraciones
        //Son los 4 robots en la ultima fila que muestran robot_death
        spawnRobot(0, 360 * 2, false, false);
        spawnRobot(160, 360 * 2, true, false);
        spawnRobot(320, 360 * 2, false, false);
        spawnRobot(480, 360 * 2, true, false);
        spawnRobot(640, 360 * 2, true, true);
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
        var btn = new Button("Play from frame");
        btn.setOnAction(e -> {
            spawnRobotForFrame(900, 700, frameSpinner.getValue());
        });

        // Organiza los controles en un VBox y lo agrega a la escena UI
        var vbox = new VBox(10, frameSpinner, btn);
        addUINode(vbox, 1230, 820);
    }

    // Método para crear un robot y reproducir la animación desde un frame específico
    private void spawnRobotForFrame(double x, double y, int startFrame) {
        // Crea un canal de animación y una textura animada
        // Asigna el canal a AnimatedTexture
        // Ejecuta métdo de AnimatedTexture para comenzar desde un frame en específico.
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
