package org.example.components;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.scene.image.Image;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.image;

public class PlayerComponent extends Component {
    private AnimatedTexture texture;
    private AnimationChannel animIdle, animWalk; //Inactivo, Caminar;

    Image image = image("lilpuddinpuggums.png");

    public PlayerComponent() {
        animIdle = new AnimationChannel(image, 4, 32, 42, Duration.seconds(1), 1, 1);
        animWalk = new AnimationChannel(image, 4, 32, 42, Duration.seconds(0.66), 0, 3);

        texture = new AnimatedTexture(animIdle);
        texture.loop();
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


