package org.example.components;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.image;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;

public class PlayerComponent extends Component {
    private AnimatedTexture texture;
    private AnimationChannel animIdle, animWalk; //Inactivo, Caminar;
    Image image = image("sprite_pug.png");
    private AnimatedTexture animTexture;
    double imageY = 0;

    // private AnimationChannel animWalkRright,animWalkLeft,animWalkUp,animWalkDdown;

    public PlayerComponent() {
       /*
        animIdle = new AnimationChannel(image, 4, 32, 42, Duration.seconds(1), 1, 1);
        animWalk = new AnimationChannel(image, 4, 32, 42, Duration.seconds(0.66), 0, 3);

        texture = new AnimatedTexture(animIdle);
        texture.loop();
        */

        //-- otra forma --:
        //                  .view(texture("sprite_pug.png").subTexture(new Rectangle2D(0,20,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(1)).loop())
/*
** Con channels
        animWalkDdown = new AnimationChannel(image, 3, 32, 42, Duration.seconds(1), 0, 2);
        animWalkLeft = new AnimationChannel(image, 3, 32, 42, Duration.seconds(1), 1, 1);
        animWalkRright = new AnimationChannel(image, 3, 32, 42, Duration.seconds(1), 1, 1);
        animWalkUp = new AnimationChannel(image, 3, 32, 42, Duration.seconds(1), 1, 1);
  */
        /*
         ** Con texture.subTexture.toAnimatedTexture
         *

        var animWalkDdown = texture("sprite_pug.png").subTexture(new Rectangle2D(0, 20, image.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(1)).loop();
        var idle = texture("sprite_pug.png").subTexture(new Rectangle2D(0, 20, image.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(1));
        */

    }


    void asignarMovimiento(String mov) {
    /*
    * En este método se asigna la coordenada "y" del sprite de acuerdo a la fila que representa el movimiento
    */

        switch (mov) {
            case "down":
                imageY = 20;
                break;
            case "left":
                imageY = 71;
                break;
            case "right":
                imageY = 117;
                break;
            case "up":
                imageY = 162;
                break;

            default:
                imageY = 20;

        }
        animTexture = texture("sprite_pug.png").subTexture(new Rectangle2D(0, imageY, image.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();

    /*
        animTextureFrenteAndDown=texture("sprite_pug.png").subTexture(new Rectangle2D(0,20,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureDerecha=texture("sprite_pug.png").subTexture(new Rectangle2D(0,117,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureIzquierda=texture("sprite_pug.png").subTexture(new Rectangle2D(0,71,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureUp=texture("sprite_pug.png").subTexture(new Rectangle2D(0,162,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
*/

    }


    @Override
    public void onUpdate(double tpf) {
        if (texture.getAnimationChannel() != animWalk) {
            texture.loopAnimationChannel(animWalk);

        } else {
            if (texture.getAnimationChannel() != animIdle) {
                texture.loopAnimationChannel(animIdle);
            }
        }
    }


}//fin


