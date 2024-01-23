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

public class PlayerComponent extends Component {
    /*
    /Aquí se maneja la imagen del player. En Factory No.
    *Debe manejarse dentro del Constructor.
    *Luego mostrarse en onAdded()

     */
    Entity entity = new Entity();
    private PhysicsComponent physics;
    int playerVelocity = 3;

    static String imagePlayerNombre = "sprite_pug.png";
    static Image imagePlayer = image(imagePlayerNombre);

    double imagePlayerY=19;
    //imagePlayerY=19;
    private AnimatedTexture animTexture;


    Rectangle2D rectangle2DImagePlayerDownYFrente= new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30);
    Rectangle2D rectangle2DImagePlayerIzquierda= new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30);
    Rectangle2D rectangle2DImagePlayerDerecha= new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30);
    Rectangle2D rectangle2DImagePlayerArriba= new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30);



    public PlayerComponent() {
             /*
      /Luego se debe agregar la animación en onAdded()
      */
        //animTexture =texture("sprite_pug.png").subTexture(new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();
         animTexture=  texture("sprite_pug.png").subTexture(rectangle2DImagePlayerIzquierda).toAnimatedTexture(3, Duration.seconds(0.6)).loop();

    }



     public void asignarMovimiento(String mov) {
        /*
         * En este método se asigna la coordenada "y" del sprite de acuerdo a la fila que representa el movimiento
         */

        switch (mov) {
            case "down":
                imagePlayerY = 20;
                getEntity().translateY(playerVelocity);
                break;
            case "left":
                imagePlayerY = 71;

                getEntity().translateX(-1*playerVelocity);
             // player.translateX(-5);
                break;
            case "right":
                imagePlayerY = 117;
                getEntity().translateX(playerVelocity);
                break;
            case "up":
                imagePlayerY = 162;
                getEntity().translateY(-1*playerVelocity);

                break;

            default:
                imagePlayerY = 20;

        }



        animTexture = texture("sprite_pug.png").subTexture(new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();
//return animTexture;


    /*
        animTextureFrenteAndDown=texture("sprite_pug.png").subTexture(new Rectangle2D(0,20,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureDerecha=texture("sprite_pug.png").subTexture(new Rectangle2D(0,117,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureIzquierda=texture("sprite_pug.png").subTexture(new Rectangle2D(0,71,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureUp=texture("sprite_pug.png").subTexture(new Rectangle2D(0,162,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
*/

    }


    @Override
    public void onAdded() {

       entity.getViewComponent().addChild(animTexture);
       //entity.getViewComponent().addChild(texture(imagePlayerNombre));
    }

    @Override
    public void onUpdate(double tpf) {
        //imagePlayerY=animTexture.getLayoutY();

    }


}//fin
