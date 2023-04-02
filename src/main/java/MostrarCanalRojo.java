

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class MostrarCanalRojo {

    public static void ejecutar() {

        try {
            BufferedImage imagen = ImageIO.read(new File("image.png"));
            BufferedImage imagenAuxiliar = new BufferedImage(imagen.getWidth(), imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
            int pixel, pixelRojo,nuevoPixel;

            for (int x = 0; x < imagen.getHeight(); x++){
                for (int y = 0; y < imagen.getWidth(); y++) {
                    // Obtener el valor RGB del pixel
                    pixel = imagen.getRGB(x, y);
                    // Extraer el valor del canal rojo
                    pixelRojo = (pixel >> 16) & 0xff; //CANAL ROJO
                    //int green = (pixel >> 8) & 0xff; //CANAL VERDE
                    //int blue = (pixel) & 0xff; //CANAL AZUL
                    nuevoPixel = (pixelRojo <<16 ) | 0x0000;
                    imagenAuxiliar.setRGB(x, y, nuevoPixel);
                                                            }
                                                         }
            ImageIO.write(imagenAuxiliar, "png", new File("imagenCanalRojo.png"));
            JOptionPane.showMessageDialog(null, "Se genero imagen imagenCanalRojo.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}