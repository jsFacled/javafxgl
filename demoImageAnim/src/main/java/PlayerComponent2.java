import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.image;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;

public class PlayerComponent2 extends Component {

    Entity entity = new Entity();
    private PhysicsComponent physics;
    int playerVelocity = 3;
    //double imagePlayerY;
    static String imagePlayerNombre = "sprite_pug.png";
    static Image imagePlayer = image(imagePlayerNombre);
    static  double imagePlayerY=19;

    // double imagePlayerY;

    //imagePlayerY=19;
    private AnimatedTexture animTexture;


   static Rectangle2D rectangle2DImagePlayerDownYFrente= new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30);
    Rectangle2D rectangle2DImagePlayerIzquierda= new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30);
    Rectangle2D rectangle2DImagePlayerDerecha= new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30);
    Rectangle2D rectangle2DImagePlayerArriba= new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30);




    public PlayerComponent2() {

             /*
      /Luego se debe agregar la animación en onAdded()
      */
        //     animTexture =texture("sprite_pug.png").subTexture(new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();
        //  animTexture=  texture("sprite_pug.png").subTexture(rectangle2DImagePlayerIzquierda).toAnimatedTexture(3, Duration.seconds(0.6));
        // animTexture=asignarAnimTexture(imagePlayerY);
        onUpdate(.1);
    }

    public void moveLeft(){
        imagePlayerY = 71;
        entity.translateX(-1 * playerVelocity);
    }
    public void moveDown(){
        imagePlayerY = 20;
        entity.translateY(playerVelocity);

    }
    public void moveRight(){
        imagePlayerY = 117;
        entity.translateX(playerVelocity);

    }
    public void moveUp(){
        imagePlayerY = 162;
        entity.translateY(-1 * playerVelocity);

    }
    public void notMove(){

    }

    public void asignarMovimiento(String mov) {
        /*
         * En este método se asigna la coordenada "y" del sprite de acuerdo a la fila que representa el movimiento
         */
        switch (mov) {

            case "down":
                imagePlayerY = 20;
                entity.translateY(playerVelocity);


                break;
            case "left":
                imagePlayerY = 71;
                entity.translateX(-1 * playerVelocity);
                entity.setProperty("imagePlayerY", imagePlayerY);
                entity.getViewComponent().onAdded();
                break;
            case "right":
                imagePlayerY = 117;
                entity.translateX(playerVelocity);

                break;
            case "up":
                imagePlayerY = 162;

                entity.translateY(-1 * playerVelocity);

                break;

            default:
                imagePlayerY = 20;

        }


//        animTexture = texture("sprite_pug.png").subTexture(new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();
//return animTexture;


    /*
        animTextureFrenteAndDown=texture("sprite_pug.png").subTexture(new Rectangle2D(0,20,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureDerecha=texture("sprite_pug.png").subTexture(new Rectangle2D(0,117,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureIzquierda=texture("sprite_pug.png").subTexture(new Rectangle2D(0,71,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureUp=texture("sprite_pug.png").subTexture(new Rectangle2D(0,162,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
*/
        onUpdate(.1);


    }

    public AnimatedTexture asignarAnimTexture(double imagePlayerY) {
        return animTexture = texture("sprite_pug.png").subTexture(new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();
    }

    @Override
    public void onAdded() {
        //entity.getViewComponent().addChild(animTexture);

        entity.getViewComponent().addChild(animTexture);

    }

    @Override
    public void onUpdate(double tpf) {

        imagePlayerY=entity.getProperties().getDouble("imagePlayerY");

        animTexture=asignarAnimTexture(imagePlayerY);

        // animTexture.loop();
    }

}
