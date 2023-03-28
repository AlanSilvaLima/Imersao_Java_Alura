
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;


import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {


    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        // leitura da imagem
        // BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg")); // codigo para leitura dentro de um direotiro do pc
      //  URL inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_3.jpg"); //inputStream feito com URL prar pegar Image da internet.
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memoria com transparencia e com tamanho novo
        int largura = imagemOriginal.getWidth(); // largura
        int altura = imagemOriginal.getHeight(); // altura
        int novaAltura = altura + 200; // nova altura para ficar maior a imagem
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT ); // colocando transparencia na imagem

        // copiar a imagem original pra nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte 
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100); // configurando o tamanho e o tipo da fonte .
        graphics.setColor(Color.BLUE); // cor da fonte
        graphics.setFont(fonte); // configurando o tamanho e o tipo da fonte 

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 400, novaAltura - 100); // frase que vai ficar abaixo da figurinha

        // escrever a nova imagem em um aquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo)); // escrevendo  a nova imagem em um arquivo formato png aquivo saida
    }
   
}
