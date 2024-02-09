
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.getInput;
import static com.almasb.fxgl.dsl.FXGL.image;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;

public class PlayerComponentFinal extends Component {

    // ** Establezco los elementos a utilizar
    int playerVelocity = 3;
    static Image imagePlayer = image("sprite_pug.png");
    MovementType movement = MovementType.DEFAULT;
    double imagePlayerY;
    double imagePlayerYforDown = 20;
    double imagePlayerYforUp = 162;
    double imagePlayerYforLeft = 71;
    double imagePlayerYforRight = 117;


    private AnimationChannel animIdle, animWalkDefault, animWalkFront, animWalkUp, animWalkRight, animWalkLeft;
    private AnimatedTexture animTexture, animTextureUp, animTextureRight, animTextureLeft;


    public PlayerComponentFinal() {

        //Capturamos 4 imágens.png
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

        //Creo un nodo para agregarlo al método moveUp()
        animTextureUp = new AnimatedTexture(animWalkUp);
        animTextureRight = new AnimatedTexture(animWalkRight);
        animTextureLeft = new AnimatedTexture(animWalkLeft);


    }

    public AnimatedTexture assignAnimatedTextureByMovement(MovementType mov) {
        /* De la imagen principal selecciona el Rectángulo que necesita
         *Establezco la coordenada Y del sprite para ir asignando a cada movimiento
         * */

        AnimatedTexture animTextureFromSprite = texture("sprite_pug.png").subTexture(new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();
        switch (mov) {
            case DOWN:
                imagePlayerY = imagePlayerYforDown;
                break;
            case LEFT:
                imagePlayerY = imagePlayerYforLeft;
                break;
            case RIGHT:
                imagePlayerY = imagePlayerYforRight;
                break;
            case UP:
                imagePlayerY = imagePlayerYforUp;
                break;
            default:
                imagePlayerY = imagePlayerYforDown;
        }

        return animTextureFromSprite;
    }


    public void assignMovement(MovementType mov) {
        /*       -- Movimientos ASWD --
         * Recibe un Enum del movimiento a asignar.
         * Se declara una variable condicional "movement".

         * En cada movimiento se va cambiando dicha variable.
         * */


        switch (mov) {
            case DOWN:
                movement = mov;
                entity.translateY(1 * playerVelocity);
                break;
            case LEFT:
                movement = mov;
                entity.translateX(-1 * playerVelocity);
                break;
            case RIGHT:
                movement = mov;
                entity.translateX(1 * playerVelocity);
                break;
            case UP:
                movement = mov;
                entity.translateY(-1 * playerVelocity);
                break;
            default:
                movement = MovementType.DEFAULT;

        }
    }


    @Override
    public void onAdded() {

        entity.getViewComponent().addChild(animTexture);


    }

    @Override
    public void onUpdate(double tpf) {
        switch (movement) {
            case LEFT:
                animTexture.set(assignAnimatedTextureByMovement(movement));
                break;
            case DOWN:
                animTexture.set(assignAnimatedTextureByMovement(movement));
                break;
            case RIGHT:
                animTexture.set(assignAnimatedTextureByMovement(movement));
                break;
            case UP:
                animTexture.set(assignAnimatedTextureByMovement(movement));
                break;

        }

    }


}
