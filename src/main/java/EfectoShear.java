import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class EfectoShear {

        public static void ejecutar() {

        try {

            BufferedImage imagen = ImageIO.read(new File("image.png"));
            AffineTransform tx = new AffineTransform();
            tx.shear(0.4, 0); // Establece el efecto shear en x = 0.8
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            BufferedImage shearedImage = op.filter(imagen, null);
            ImageIO.write(shearedImage, "png", new File("imagenEfectoShear.png"));
            JOptionPane.showMessageDialog(null,"Se genero archivo en imagenEfectoShear.png");

            } catch (Exception e) {
            e.printStackTrace();
                                  }

            }
}
