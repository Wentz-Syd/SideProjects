package object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_chucks extends SuperObject{

    GamePanel gp;

    public OBJ_chucks(GamePanel gp){
        name = "Chucks";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chucks.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}
