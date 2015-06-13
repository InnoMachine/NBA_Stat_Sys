package ui_demos;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class PngFileWriter {
	
	public static void main(String args[]) {
		List<String> inputFileNameList = new ArrayList<String>();
		inputFileNameList.add("DAL2.png");
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
            BufferedImage teamImg = null;
            BufferedImage playerImg = null;
            BufferedImage outputImg = null;
            int outputImgW = 0;
            int outputImgH = 0;
            for (String pngFileName : inputFileNameList) {
                if (isFirstPng) {
                    isFirstPng = false;
                    teamImg = ImageIO.read(new File(pngFileName));
                } else {
                    playerImg = ImageIO.read(new File(pngFileName));
                    outputImgW=playerImg.getWidth()*12/10;
                    outputImgH=playerImg.getHeight()*12/10;
         
                    // create basic image
                    Graphics2D g2d = teamImg.createGraphics();
                    outputImg = g2d.getDeviceConfiguration().createCompatibleImage(outputImgW, outputImgH);
                    g2d.dispose();
                    g2d = outputImg.createGraphics();
               
                    g2d.drawImage(teamImg, 0, 0, outputImgW, outputImgH, null);
                    g2d.drawImage(playerImg, (outputImgW-playerImg.getWidth()*90/100)/2,outputImgH-playerImg.getHeight()*90/100,playerImg.getWidth()*90/100, playerImg.getHeight()*90/100, null);      
                    g2d.dispose();
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
