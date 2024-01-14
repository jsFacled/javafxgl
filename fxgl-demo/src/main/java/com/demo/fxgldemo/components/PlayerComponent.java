package com.demo.fxgldemo.components;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.image;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */

/**
 * Se especifican las características y comportamiento del Jugador
 * Gestionando su animación, movimiento y capacidad de salto.
 * Este componente puede ser agregado a una entidad del juego.
 * <p>
 * **physics
 * Representa el componente de física asociado al jugador.
 * Se utiliza para controlar la física del jugador, como la velocidad y la detección de colisiones.
 * <p>
 * **texture
 * Se utiliza para visualizar la animación del jugador en pantalla.
 * <p>
 * **AnimationChannel
 * Definen canales de animación para la textura animada.
 * ***animIdle: representa la animación cuando el jugador está inactivo
 * ***animWalk: representa la animación al caminar.
 */
public class PlayerComponent extends Component {
    //private PhysicsComponent physics;
    private AnimatedTexture texture;

    private AnimationChannel animIdle, animWalk;

    private int jumps = 2;

    public PlayerComponent() {
        /*
            Se inicializan y configuran los elementos necesarios para la representación visual y la animación del jugador.
            Esto incluye:
              -cargar la imagen del jugador,
              -crear canales de animación para los estados idle y caminar,
              -y configurar una textura animada con la animación de reposo, lista para ser utilizada en el juego.
         */

        Image image = image("player.png");

        animIdle = new AnimationChannel(image, 4, 32, 42, Duration.seconds(1), 1, 1);
        animWalk = new AnimationChannel(image, 4, 32, 42, Duration.seconds(0.66), 0, 3);

        texture = new AnimatedTexture(animIdle);//hace referencia a la textura animada que representa la animación de reposo del jugador.
        texture.loop();
    }

    @Override
    public void onAdded() {
        /*
            Método llamado cuando el componente es agregado a una entidad.
         */

        entity.getTransformComponent().setScaleOrigin(new Point2D(16, 21));
        entity.getViewComponent().addChild(texture);

        /*
        physics.onGroundProperty().addListener((obs, old, isOnGround) -> {
            if (isOnGround) {
                jumps = 2;
            }
        });

         */
    }

    @Override
    public void onUpdate(double tpf) {
        /*
            Método llamado en cada actualización del juego,
            permitiendo la lógica de actualización específica del componente.
            En resumen, este método asegura que la animación del jugador se actualice correctamente
            en cada fotograma del juego según si el jugador está en movimiento horizontal o no.
            Si está en movimiento, se utiliza la animación de caminar,
            y si no está en movimiento, se utiliza la animación de reposo.
            Esto proporciona una representación visual coherente del estado del jugador en el juego.
         */


        /*
        if (physics.isMovingX()) {
            if (texture.getAnimationChannel() != animWalk) {
                texture.loopAnimationChannel(animWalk);
            }
        } else {
            if (texture.getAnimationChannel() != animIdle) {
                texture.loopAnimationChannel(animIdle);
            }
        }
        */

    }

    public void left() {
        getEntity().setScaleX(-1);
       // physics.setVelocityX(-170);
    }

    public void right() {
        getEntity().setScaleX(1);
        //physics.setVelocityX(170);
    }

    public void stop() {
        //physics.setVelocityX(0);
    }

    public void jump() {
        if (jumps == 0)
            return;

//        physics.setVelocityY(-300);

        jumps--;
    }
}
