import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ReduccionIntensidadCambioCanal {
    
    public static void ejecutar() {

        Scanner entrada = new Scanner(System.in);

        try {
            BufferedImage imagen = ImageIO.read(new File("image.png"));
            BufferedImage imagenAuxiliar = new BufferedImage(imagen.getWidth(), imagen.getHeight(), BufferedImage.TYPE_INT_RGB);

            int intensityRange = 256, levels = 2, levelSize = intensityRange/levels ,opc2;
              
                  do {
                   opc2 =  Integer.parseInt(JOptionPane.showInputDialog(null, "===ELIJE TU CANAL PARA APLICAR A LA IMAGEN==="
                    + "\n1)CANAL ROJO"
                    + "\n2)CANAL AZUL"
                    + "\n3)CANAL VERDE"
                    + "\n4) SALIR"));
                
                switch (opc2) {
                    case 1:
                        BufferedImage aux = canalRojo(imagen, imagenAuxiliar, levelSize);
                        ImageIO.write(aux, "png", new File("imagenMenosIntensidadCanalRojo.png"));
                        JOptionPane.showMessageDialog(null, "Canal ROJO en -> imagenMenosIntensidadCanalRojo.png");
                        break;
                    case 2:
                        BufferedImage aux2 = canalAzul(imagen, imagenAuxiliar, levelSize);
                        ImageIO.write(aux2, "png", new File("imagenMenosIntensidadCanalAzul.png"));
                        JOptionPane.showMessageDialog(null, "Canal AZUL en -> imagenMenosIntensidadCanalAzul.png");                 
                        break;
                    case 3:
                        BufferedImage aux3 = canalVerde(imagen, imagenAuxiliar, levelSize);
                        ImageIO.write(aux3, "png", new File("imagenMenosIntensidadCanalVerde.png"));
                        JOptionPane.showMessageDialog(null, "Canal VERDE en -> imagenMenosIntensidadCanalRojo.png");
                        break;
                }
            }while(opc2!=4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage canalRojo(BufferedImage imagen, BufferedImage imagenAuxiliar, int levelSize){
        for (int x = 0; x < imagen.getHeight(); x++) {
            for (int y = 0; y < imagen.getWidth(); y++) {
                int  pixel = imagen.getRGB(x, y) , red = (pixel >> 16) & 0xff, level = red / levelSize, newIntensity = level * levelSize, newPixel = (newIntensity << 16) | 0x000000; //CANAL ROJO
                imagenAuxiliar.setRGB(x, y, newPixel);
                                                        }
                                    }
                                        return imagenAuxiliar;
                                                                            }
    private static BufferedImage canalAzul(BufferedImage imagen, BufferedImage imagenAuxiliar, int levelSize){
        for (int x = 0; x < imagen.getHeight(); x++) {
            for (int y = 0; y < imagen.getWidth(); y++) {
                int  pixel = imagen.getRGB(x, y),red = (pixel >> 16) & 0xff,level = red / levelSize,newIntensity = level * levelSize,newPixel = (0) | (0 << 8) | (newIntensity << 0); //CANAL AZUL
                imagenAuxiliar.setRGB(x, y, newPixel);
            }
        }
        return imagenAuxiliar;
    }
    private static BufferedImage canalVerde(BufferedImage imagen, BufferedImage imagenAuxiliar, int levelSize){
        for (int x = 0; x < imagen.getHeight(); x++) {
            for (int y = 0; y < imagen.getWidth(); y++) {
                int  pixel = imagen.getRGB(x, y),red = (pixel >> 16) & 0xff, level = red / levelSize, newIntensity = level * levelSize,newPixel = (newIntensity << 8) | 0x00; //CANAL VERDE
                imagenAuxiliar.setRGB(x, y, newPixel);
            }
        }
        return imagenAuxiliar;
    }

}