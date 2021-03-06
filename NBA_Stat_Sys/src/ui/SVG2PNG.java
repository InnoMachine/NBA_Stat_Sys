package ui;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class SVG2PNG {
	public static void convertSvgFileToPng(File svg, File png)
			throws IOException, TranscoderException {
		InputStream in = new FileInputStream(svg);
		OutputStream out = new FileOutputStream(png);
		out = new BufferedOutputStream(out);
		convertToPNG(in, out);
	}

	private static void convertToPNG(InputStream in, OutputStream out)
			throws IOException, TranscoderException {
		Transcoder transcoder = new PNGTranscoder();
		try {
			TranscoderInput input = new TranscoderInput(in);
			try {
				TranscoderOutput output = new TranscoderOutput(out);
				transcoder.addTranscodingHint(ImageTranscoder.KEY_WIDTH,
						Float.parseFloat(String.valueOf(500)));// 设置图片大小
				transcoder.transcode(input, output);

			} finally {
				out.close();
			}
		} finally {
			in.close();
		}
	}
	public void getFiles(String filePath) throws IOException, TranscoderException{
		File root = new File(filePath);
		File[] files = root.listFiles();
		for (File file : files) {
			String path=file.getAbsolutePath();
			if(path.endsWith(".svg")){
				convertSvgFileToPng(new File(path), new File(
				"CSEdata/teams_png/"+path.substring(path.length()-8, path.length()-3)+"png"));
			}
		}
//		System.out.println("conversion finished!");
	}
	public static void main(String[] args) throws IOException,
			TranscoderException {

		SVG2PNG conversion=new SVG2PNG();
		conversion.getFiles("CSEdata/teams/");

	}
}