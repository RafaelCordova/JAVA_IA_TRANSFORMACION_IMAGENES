
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Rotar90grados {

    public static void ejecutar() {
        try {
            BufferedImage imagen = ImageIO.read(new File("image.png"));
            AffineTransformOp op = new AffineTransformOp(
                    AffineTransform.getRotateInstance(Math.toRadians(90), imagen.getWidth() / 2, imagen.getHeight() / 2),
                    AffineTransformOp.TYPE_BILINEAR);

            BufferedImage imagenRotada = op.filter(imagen, null);
            ImageIO.write(imagenRotada, "png", new File("imagenRotada.png"));
            JOptionPane.showMessageDialog(null,"Se genero archivo como imagenRotada.png");
        } catch (Exception e) {
            e.printStackTrace();
                         }
                                    }
                    }