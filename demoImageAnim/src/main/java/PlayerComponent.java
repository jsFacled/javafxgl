import com.almasb.fxgl.core.View;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
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

    private AnimationChannel animIdleChannel, animWalkChannel; //Inactivo, Caminar;

    String imagePlayerNombre = "sprite_pug.png";
    Image imagePlayer = image(imagePlayerNombre);

    AnimatedTexture animTexture;
    double imagePlayerY = 19;


    public PlayerComponent() {
        /*
            //Esta línea selecciona un cuadrado y muestra lo que se ve de la imagen original
          animTexture = texture("sprite_pug.png").subTexture(new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6));

            //Con esta línea se realiza un loop, recorriendo toda la fila.También se puede agregar directamente a la línea anterior.
          animTexture.loop();
        */

        animTexture = texture("sprite_pug.png").subTexture(new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();


      /*
      /Luego se debe agregar la animación en onAdded()
      */
    }


     public AnimatedTexture asignarMovimiento(String mov) {
        /*
         * En este método se asigna la coordenada "y" del sprite de acuerdo a la fila que representa el movimiento
         */

        switch (mov) {
            case "down":
                imagePlayerY = 20;
                break;
            case "left":
                imagePlayerY = 71;
             // player.translateX(-5);
                break;
            case "right":
                imagePlayerY = 117;
                break;
            case "up":
                imagePlayerY = 162;
                break;

            default:
                imagePlayerY = 20;

        }
        animTexture = texture("sprite_pug.png").subTexture(new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();
return animTexture;

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

    }

    @Override
    public void onUpdate(double tpf) {


    }


}//fin
