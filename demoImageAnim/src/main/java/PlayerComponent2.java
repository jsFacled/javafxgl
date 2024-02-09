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

public class PlayerComponent2 extends Component {

    private PhysicsComponent physics;
    int playerVelocity = 3;



    private AnimationChannel animIdle, animWalkDefault, animWalkFront, animWalkUp, animWalkRight, animWalkLeft;
    private AnimatedTexture animTexture, animTextureUp, animTextureRight,animTextureLeft;



    public PlayerComponent2() {

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
        animTextureUp=new  AnimatedTexture(animWalkUp);
        animTextureRight=new  AnimatedTexture(animWalkRight);
        animTextureLeft=new  AnimatedTexture(animWalkLeft);


    }

    /*
    *       -- Movimientos ASWD --
    * Se declara una variable condicional "moving".
    * En cada movimiento se va cambiando dicha variable.
    * */

    // int dy=0;
    // int dx=0;
    String moving="down";
    public void moveLeft(){
        moving="left";
        //dx=-1;
        entity.translateX(-1 * playerVelocity);
       // onUpdate(1);
    }
    public void moveDown(){
        moving="down";
        //dy=1;
        entity.translateY(1*playerVelocity);
       // onUpdate(1);

    }
    public void moveRight(){
        moving="right";
        //dx=1;
        entity.translateX(1*playerVelocity);
      // onUpdate(1);

    }
    public void moveUp(){
        moving="up";
        //dy=-1;
        entity.translateY(-1 * playerVelocity);
       // onUpdate(1);

    }


    @Override
    public void onAdded() {

     entity.getViewComponent().addChild(animTexture);



    }

    @Override
    public void onUpdate(double tpf) {
switch (moving){
    case "left":animTexture.set(animTextureLeft);break;
    case "down":animTexture.set(animTexture);break;
    case "right":animTexture.set(animTextureRight);break;
    case "up":animTexture.set(animTextureUp);break;

}

/*
        if (dy==-1) {
            dx=0;
            animTexture.set(animTextureUp);
        }
        if (dx==-1) {
            dy=0;
            animTexture.set(animTextureLeft);
        }
        if (dx==1) {
            dy=0;
            animTexture.set(animTextureRight);
        }
*/
    }



}
