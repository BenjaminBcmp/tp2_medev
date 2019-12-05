/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.tp2_medev_computer_vision;

/**
 *
 * @author Benjamin
 */
public class HistogramPGM {
    private ImagePGM img;
    private int[] hist;
    private int widthBar = 2;
    private int maxHeightBar = 300;

    public HistogramPGM(ImagePGM img) {
        this.img = img;
        this.hist = new int[256];
        for (int i = 0; i < 256; i++) {
            this.hist[i] = 0;
        }
        this.computeHistogram();
    }

    public int[] getHist() {
        return hist;
    }
    
    private void computeHistogram() {
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                this.hist[img.getMat()[i][j]]++;
            }
        }
    }
    
    public void saveHistogram(String path) {
        int[] histScaled = this.rescaleHistogram();
        int imgHeight = this.maxHeightBar + 20;
        int imgWidth = 256 * this.widthBar + 20;
        int[][] mat = new int[imgHeight][imgWidth];
        for (int i = 0; i < imgHeight ; i++) {
            for (int j = 0; j < imgWidth ; j++) {
                mat[i][j] = 255;
            }
        }
        
        // Draw x-axis line
        for (int j = 10; j < imgWidth-10; j++) {
            mat[imgHeight-9][j] = 0;
            mat[imgHeight-10][j] = 0;
        }
        
        // Draw histogram bars
        int baseI = imgHeight - 11;
        int baseJ = 10;
        for (int kHist = 0; kHist < 256; kHist++) {
            for (int i = 0; i < histScaled[kHist]; i++) {
                for (int j = widthBar*kHist; j < widthBar*(kHist+1); j++) {
                    mat[baseI-i][j] = 0;
                }
            }
        }
        
        ImagePGM newImg = new ImagePGM(mat);
        newImg.writeToFile(path);
    }
    
    public int[] rescaleHistogram() {
        int[] histScaled = this.hist.clone();
        int maxValue = 0;
        for (int i = 0; i < 256; i++) {
            if (histScaled[i] > maxValue) {
                maxValue = histScaled[i];
            }
        }
        for (int i = 0; i < 256; i++) {
            histScaled[i] = (int) (((float) histScaled[i]) / maxValue * 255);
        }
        return histScaled;
    }
}
