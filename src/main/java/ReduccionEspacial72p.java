import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ReduccionEspacial72p {

    public static void ejecutar() throws Exception {

        try {
            // Cargar imagen original
            BufferedImage imagenOriginal = ImageIO.read(new File("image.png"));
            // Obtener ancho y alto de la imagen
            int anchoOriginal = imagenOriginal.getWidth(), alturaOrignal = imagenOriginal.getHeight();
            // Reducir resolución a 72 dpi (reduciendo ancho y alto a la mitad)
            int anchoNuevo = anchoOriginal/10, alturaNueva = alturaOrignal/10;

            Image scaledImage = imagenOriginal.getScaledInstance(anchoNuevo, alturaNueva, Image.SCALE_SMOOTH);
            BufferedImage reducedImage = new BufferedImage(anchoNuevo, alturaNueva, BufferedImage.TYPE_INT_RGB);
            reducedImage.getGraphics().drawImage(scaledImage, 0, 0, null);
            
            ImageIO.write(reducedImage, "png", new File("imagenA72dpi.png"));
            JOptionPane.showMessageDialog(null,"Se genero el archivo -> imagenA72dpi.png");

         }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
