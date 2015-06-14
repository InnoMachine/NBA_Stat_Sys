package ui_demos;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class PngFileWriter {
	
	public static void main(String args[]) {
		List<String> inputFileNameList = new ArrayList<String>();
		inputFileNameList.add("CHA.png");
		inputFileNameList.add("player.png");
		String outputFileName = "hehe.png";
		new PngFileWriter().append(inputFileNameList, outputFileName);
	}

    public void append(List<String> inputFileNameList, String outputFileName) {
        if (inputFileNameList == null || inputFileNameList.size() == 0) {
            return;
        }

        try {
            boolean isFirstPng = true;
            BufferedImage outputImg = null;
            int outputImgW = 0;
            int outputImgH = 0;
            for (String pngFileName : inputFileNameList) {
                if (isFirstPng) {
                    isFirstPng = false;
                    outputImg = ImageIO.read(new File(pngFileName));
                    outputImgW = outputImg.getWidth();
                    outputImgH = outputImg.getHeight();
                } else {
                    BufferedImage appendImg = ImageIO.read(new File(pngFileName));
                    int appendImgW = appendImg.getWidth();
                    int appendImgH = appendImg.getHeight();

                    outputImgW = outputImgW > appendImgW ? outputImgW : appendImgW;
                    outputImgH = outputImgH + appendImgH;


                    // create basic image
                    Graphics2D g2d = outputImg.createGraphics();
                    BufferedImage imageNew = g2d.getDeviceConfiguration().createCompatibleImage(outputImgW, outputImgH,
                            Transparency.TRANSLUCENT);
                    g2d.dispose();
                    g2d = imageNew.createGraphics();
                    
                    int oldImgW = outputImg.getWidth();
                    int oldImgH = outputImg.getHeight();
                    g2d.drawImage(outputImg, 0, 0, oldImgW/2, oldImgH/2, null);
                    
                    g2d.drawImage(appendImg, 0, 0, appendImgW, appendImgH, null);
                    
                    g2d.dispose();
                    outputImg = imageNew;
                }
            }
            writeImageLocal(outputFileName, outputImg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeImageLocal(String fileName, BufferedImage image) {
        if (fileName != null && image != null) {
            try {
                File file = new File(fileName);
                ImageIO.write(image, "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

