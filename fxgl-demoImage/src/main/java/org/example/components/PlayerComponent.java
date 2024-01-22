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

   // private AnimationChannel animWalkRright,animWalkLeft,animWalkUp,animWalkDdown;
    Image image = image("sprite_pug.png");

    public PlayerComponent() {
        animIdle = new AnimationChannel(image, 4, 32, 42, Duration.seconds(1), 1, 1);
        animWalk = new AnimationChannel(image, 4, 32, 42, Duration.seconds(0.66), 0, 3);

        texture = new AnimatedTexture(animIdle);
        texture.loop();

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
 */
     var animWalkDdown = texture("sprite_pug.png").subTexture(new Rectangle2D(0,20,image.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(1)).loop();
 var idle = texture("sprite_pug.png").subTexture(new Rectangle2D(0,20,image.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(1));


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


