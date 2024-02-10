
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.util.Duration;
import static com.almasb.fxgl.dsl.FXGL.image;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;

public class PlayerComponentFinal extends Component {

    // ** Establezco los elementos a utilizar
    int playerVelocity = 3;
    static Image imagePlayer = image("sprite_pug.png");

    MovementType movement = MovementType.DEFAULT;
    double imagePlayerY;

    ///Capto la coordenada "y" de cada sprite
    double imagePlayerYforDown = 20;
    double imagePlayerYforUp = 162;
    double imagePlayerYforLeft = 71;
    double imagePlayerYforRight = 117;

    // ** Inicializo animTexture con movimiento Down.
   AnimatedTexture animTexture=texture("sprite_pug.png").subTexture(new Rectangle2D(0, imagePlayerYforDown, imagePlayer.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();;

    // ** Constructor Vacío
    public PlayerComponentFinal() {
    }

    // ** Asigno movimiento
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

    // ** Asigno Textura Animada de acuerdo al Movimiento
    public AnimatedTexture assignAnimatedTextureByMovement(MovementType mov) {
        // De la imagen principal selecciona el Rectángulo que necesita
         //Establezco la coordenada -Y- del sprite para ir asignando a cada movimiento


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


    @Override
    public void onAdded() {
        entity.getViewComponent().addChild(animTexture);
    }

    @Override
    public void onUpdate(double tpf) {
        animTexture.set(assignAnimatedTextureByMovement(movement));
    }

}
