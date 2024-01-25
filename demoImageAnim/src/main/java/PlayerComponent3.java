
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

public class PlayerComponent3 extends Component {

    private PhysicsComponent physics;
    int playerVelocity = 3;



    private AnimationChannel animIdle, animWalkDefault, animWalkFront, animWalkUp, animWalkRight, animWalkLeft;
    private AnimatedTexture animTexture;


    public PlayerComponent3() {

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
