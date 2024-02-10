import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGL.entityBuilder;

/*
*   En esta app tenemos un sprite de 4x4=16 frames.
*   Captamos cada movimiento con AnimationChannel
*   En este caso las figuras están confeccionadas simétricamente.
*
* */

public class AppPruMov extends GameApplication {



    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1480);
        settings.setHeight(1020);
    }

    @Override
    protected void initInput() {
    }


    @Override
    protected void initGame() {
        getGameScene().setBackgroundColor(Color.ALICEBLUE);

        AnimationChannel animChannel1 = new AnimationChannel(image("character_base_16x16.png"), 4, 16, 16, Duration.seconds(2.6), 0, 15);
        AnimationChannel animChannel2 = new AnimationChannel(image("character_base_16x16.png"), 4, 16, 16, Duration.seconds(1), 0, 3);
        AnimationChannel animChannel3 = new AnimationChannel(image("character_base_16x16.png"), 4, 16, 16, Duration.seconds(1), 4, 7);
        AnimationChannel animChannel4 = new AnimationChannel(image("character_base_16x16.png"), 4, 16, 16, Duration.seconds(1), 8, 11);
        AnimationChannel animChannel5 = new AnimationChannel(image("character_base_16x16.png"), 4, 16, 16, Duration.seconds(1), 12, 15);

        AnimatedTexture animTexture1=new AnimatedTexture(animChannel1);
        AnimatedTexture animTexture2=new AnimatedTexture(animChannel2);
        AnimatedTexture animTexture3=new AnimatedTexture(animChannel3);
        AnimatedTexture animTexture4=new AnimatedTexture(animChannel4);
        AnimatedTexture animTexture5=new AnimatedTexture(animChannel5);


       // Construye entidad Sprite
        entityBuilder()
                .at(500,500)
                .scale(4,4)
                .view("character_base_16x16.png")
                .buildAndAttach();

        // Construye entidad1
       entityBuilder()
                .at(5,5)
                .scale(3,3)
                .view(animTexture1.loop())
                .buildAndAttach();

        // Construye entidad2
        entityBuilder()
                .at(100,30)
                .scale(3,3)
                .view(animTexture2.loop())
                .buildAndAttach();

        // Construye entidad3
        entityBuilder()
                .at(200,60)
                .scale(3,3)
                .view(animTexture3.loop())
                .buildAndAttach();
        // Construye entidad4
        entityBuilder()
                .at(300,100)
                .scale(3,3)
                .view(animTexture4.loop())
                .buildAndAttach();
        // Construye entidad5
        entityBuilder()
                .at(400,150)
                .scale(3,3)
                .view(animTexture5.loop())
                .buildAndAttach();
    }


    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        launch(args);
    }
}
