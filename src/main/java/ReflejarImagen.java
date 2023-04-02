
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ReflejarImagen {

    public static void ejecutar()throws IOException {

        File file= new File("image.png");
        BufferedImage imagen = ImageIO.read(file);

        int largo = imagen.getWidth(), altura = imagen.getHeight();

        BufferedImage res = new BufferedImage(largo, altura, BufferedImage.TYPE_INT_ARGB);
        for(int j = 0; j < altura; j++){
            for(int i = 0, w = largo - 1; i < largo; i++, w--){
                int p = imagen.getRGB(i, j);
                res.setRGB(w, j, p);
                                                         }
                                    }

        file = new File("imagenReflejada.png");
        JOptionPane.showMessageDialog(null,"Se genero archivo en imagenReflejada.png");
        ImageIO.write(res, "png", file);
    }
}
