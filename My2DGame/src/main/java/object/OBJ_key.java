package object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_key extends SuperObject{

    GamePanel gp;

    public OBJ_key(GamePanel gp){
        this.gp = gp;
        name = "Key";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}