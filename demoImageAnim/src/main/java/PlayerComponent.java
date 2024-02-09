import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;

public class PlayerComponent extends Component {
    /*
    /Aquí se maneja la imagen del player. En Factory No.
    *Debe manejarse dentro del Constructor.
    *Luego mostrarse en onAdded()

     */
    Entity entity = new Entity();
    Entity player;
    private PhysicsComponent physics;
    int playerVelocity = 3;
    //double imagePlayerY;
    static String imagePlayerNombre = "sprite_pug.png";
    static Image imagePlayer = image(imagePlayerNombre);
    //double imagePlayerY;

   // double imagePlayerY;

    //imagePlayerY=19;
     AnimatedTexture animTexture;

/*
    Rectangle2D rectangle2DImagePlayerDownYFrente= new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30);
    Rectangle2D rectangle2DImagePlayerIzquierda= new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30);
    Rectangle2D rectangle2DImagePlayerDerecha= new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30);
    Rectangle2D rectangle2DImagePlayerArriba= new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30);


 */


    public PlayerComponent() {

             /*
      /Luego se debe agregar la animación en onAdded()
      */
        //     animTexture =texture("sprite_pug.png").subTexture(new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();
        //  animTexture=  texture("sprite_pug.png").subTexture(rectangle2DImagePlayerIzquierda).toAnimatedTexture(3, Duration.seconds(0.6));
        // animTexture=asignarAnimTexture(imagePlayerY);
    onUpdate(.1);
    }

    /* Movimientos por separado
public void moveLeft(){
        imagePlayerY = 71;
        getEntity().translateX(-1 * playerVelocity);
}
    public void moveDown(){
        imagePlayerY = 20;
        getEntity().translateY(playerVelocity);

    }
    public void moveRight(){
        imagePlayerY = 117;
        getEntity().translateX(playerVelocity);

    }
    public void moveUp(){
        imagePlayerY = 162;
        getEntity().translateY(-1 * playerVelocity);

    }
    public void notMove(){    }
*/

    public void asignarMovimiento(String mov) {
        double imagePlayerY;
        /*
         * En este método se asigna la coordenada "y" del sprite de acuerdo a la fila que representa el movimiento
         */
        switch (mov) {
            case "down":
                imagePlayerY = 20;
                getEntity().translateY(playerVelocity);
                animTexture=asignarAnimTexture(imagePlayerY);

                break;
            case "left":
                imagePlayerY = 71;
                getEntity().translateX(-1 * playerVelocity);
                entity.setProperty("imagePlayerY", imagePlayerY);
                entity.getViewComponent().onAdded();
                animTexture=asignarAnimTexture(imagePlayerY);
                break;
            case "right":
                imagePlayerY = 117;
                getEntity().translateX(playerVelocity);
                animTexture=asignarAnimTexture(imagePlayerY);
                break;
            case "up":
                imagePlayerY = 162;
                getEntity().translateY(-1 * playerVelocity);
                animTexture=asignarAnimTexture(imagePlayerY);
                break;
          // default:
               // imagePlayerY = 20;
               // animTexture=asignarAnimTexture(imagePlayerY);

        }



//        animTexture = texture("sprite_pug.png").subTexture(new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();
//return animTexture;


   /*
        animTextureFrenteAndDown=texture("sprite_pug.png").subTexture(new Rectangle2D(0,20,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureDerecha=texture("sprite_pug.png").subTexture(new Rectangle2D(0,117,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureIzquierda=texture("sprite_pug.png").subTexture(new Rectangle2D(0,71,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureUp=texture("sprite_pug.png").subTexture(new Rectangle2D(0,162,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
*/

    }


    public AnimatedTexture asignarAnimTexture(double imagePlayerY) {
        return animTexture = texture("sprite_pug.png").subTexture(new Rectangle2D(0, imagePlayerY, imagePlayer.getWidth(), 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();
    }


/*
    public void onUpdateSegunMov(String mov){
        switch (mov) {
            case "down":
                imagePlayerY = 20;

                break;
            case "left":
                imagePlayerY = 71;
                getEntity().translateX(-1 * playerVelocity);
                entity.setProperty("imagePlayerY", imagePlayerY);
                entity.getViewComponent().onAdded();
                break;
            case "right":
                imagePlayerY = 117;
                getEntity().translateX(playerVelocity);
                break;
            case "up":
                imagePlayerY = 162;
                getEntity().translateY(-1 * playerVelocity);
                break;
            default:
                imagePlayerY = 20;
                onUpdate(0.2);
        }


       }
*/






        @Override
    public void onAdded() {
        //entity.getViewComponent().addChild(animTexture);
            //imagePlayerY=119;
//            animTexture=asignarAnimTexture(imagePlayerY);

            //player.getComponent(PlayerComponent.class).imagePlayerY;



            //prueba con if






 /*
            }

                String down = getInput().getTriggerName("down");
                String left = getInput().getTriggerName("left");
                String right = getInput().getTriggerName("right");
                String up = getInput().getTriggerName("up");
                String idle = getInput().getTriggerName("idle");

                    if ()
                        animTexture=animTextureFrenteAndDown;
                */


            getEntity().getViewComponent().addChild(animTexture);
            System.out.println("--------------------------------Dime lo que hay en detInput(): "+getInput().getTriggerName("Move Down"));
        }

    @Override
    public void onUpdate(double tpf) {
       /*
        var  animTextureFrenteAndDown=texture("sprite_pug.png").subTexture(new Rectangle2D(0,20,imagePlayer.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        var animTextureDerecha=texture("sprite_pug.png").subTexture(new Rectangle2D(0,117,imagePlayer.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        var animTextureIzquierda=texture("sprite_pug.png").subTexture(new Rectangle2D(0,71,imagePlayer.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        var animTextureUp=texture("sprite_pug.png").subTexture(new Rectangle2D(0,162,imagePlayer.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();

        if (!getInput().getTriggerName("Move Right").isBlank()){
            animTexture=animTextureDerecha;
        }
        if (!getInput().getTriggerName("Move Left").isBlank()){
            animTexture=animTextureIzquierda;
        }
        if (!getInput().getTriggerName("Move Up").isBlank()){
            animTexture=animTextureUp;
        }
        if (!getInput().getTriggerName("Move Down").isBlank()){
            animTexture=animTextureFrenteAndDown;
        }
        else animTexture=animTextureFrenteAndDown;



        */
       // animTexture.loop();

        //prueba

    }



}//fin
