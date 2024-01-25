import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.image;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;

public class PlayerComponent2 extends Component {

    private PhysicsComponent physics;
    int playerVelocity = 3;



    private AnimationChannel animIdle, animWalkDefault, animWalkFront, animWalkUp, animWalkRight, animWalkLeft;
    private AnimatedTexture animTexture;


    public PlayerComponent2() {
        Image imagePlayerFront = image("pugFrente.png");
        Image imagePlayerUp = image("pugEspalda.png");
        Image imagePlayerRight = image("pudDerecha.png");
        Image imagePlayerLeft = image("pugIzquierda.png");
        animWalkFront = new AnimationChannel(imagePlayerFront, 3, 32, 32, Duration.seconds(0.66), 0, 2);
        animWalkUp = new AnimationChannel(imagePlayerUp, 3, 32, 32, Duration.seconds(0.66), 0, 2);
        animWalkRight = new AnimationChannel(imagePlayerRight, 3, 32, 32, Duration.seconds(0.66), 0, 2);
        animWalkLeft = new AnimationChannel(imagePlayerLeft, 3, 32, 32, Duration.seconds(0.66), 0, 2);

        animWalkDefault = new AnimationChannel(imagePlayerFront, 3, 32, 32, Duration.seconds(0.66), 0, 2);

        animIdle = new AnimationChannel(imagePlayerFront, 4, 32, 32, Duration.seconds(1), 1, 1);

        animTexture = new AnimatedTexture(animWalkDefault);
        animTexture.loop();

    }

    public void moveLeft(){

        entity.translateX(-1 * playerVelocity);
    }
    public void moveDown(){

        entity.translateY(playerVelocity);

    }
    public void moveRight(){

        entity.translateX(playerVelocity);

    }
    public void moveUp(){

        entity.translateY(-1 * playerVelocity);

    }


    @Override
    public void onAdded() {

        entity.getViewComponent().addChild(animTexture);

    }

    @Override
    public void onUpdate(double tpf) {
/*
        if (physics.isMovingX()) {
            if (animTexture.getAnimationChannel() != animWalkDefault) {
                animTexture.loopAnimationChannel(animWalkDefault);
            }
        } else {
            if (animTexture.getAnimationChannel() != animIdle) {
                animTexture.loopAnimationChannel(animIdle);
            }
        }
 */
    }



}
