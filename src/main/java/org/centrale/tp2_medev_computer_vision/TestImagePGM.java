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
public class TestImagePGM {
    
    public static void main(String[] args) {
        String path = "data/lena.pgm";
        String pathSeuillage = "data/seuillage_lena.pgm";
        testSeuillage(path);
        testDifference(path,pathSeuillage);
        
    }
    
    public static void testLoadFromFile(String path) {
        System.out.println("Test of loadFromFile");
        System.out.println("Loading image from " + path);
        System.out.println("Image loaded :");
        ImagePGM img = new ImagePGM(path);
        img.affiche();
        System.out.println("Done!");
    }
    
    public static void testWriteToFile(String path) {
        System.out.println("Test of writeToFile");
        System.out.println("Loading image from " + path);
        System.out.println("Image loaded :");
        ImagePGM img = new ImagePGM(path);
        img.affiche();
        
        String pathCopy = img.getPath().getParent().toString() + "/copy_"
                + img.getPath().getFileName().toString();
        System.out.println("Writing image to " + pathCopy);
        img.writeToFile(pathCopy);
        System.out.println("Done!");
    }
    
    public static void testHistogram(String path){
        System.out.println("Test of histogram");
        System.out.println("Loading image from " + path);
        ImagePGM img = new ImagePGM(path);
        img.affiche();
        
        HistogramPGM hist = new HistogramPGM(img);
        System.out.println("Histogram :");
        int[] histArray = hist.getHist();
        for (int i = 0; i < histArray.length; i++) {
            System.out.print(histArray[i] + " ");
        }
        System.out.println();
        
        System.out.println("Histogram rescaled:");
        int[] histArrayRescaled = hist.rescaleHistogram();
        for (int i = 0; i < histArrayRescaled.length; i++) {
            System.out.print(histArrayRescaled[i] + " ");
        }
        System.out.println();
        
        String pathHisto = img.getPath().getParent().toString() + "/histogram_" +
                img.getPath().getFileName().toString();
        System.out.println("Saving histogram to : " + pathHisto);
        hist.saveHistogram(pathHisto);
    }


    public static void testSeuillage(String path) {
        System.out.println("Test of seuillage");
        System.out.println("Loading image from " + path);
        System.out.println("Image loaded :");
        ImagePGM img = new ImagePGM(path);
        img.affiche();
        
        String pathCopy = img.getPath().getParent().toString() + "/seuillage_"
                + img.getPath().getFileName().toString();
        System.out.println("Writing image to " + pathCopy);
        img.seuillage(150).writeToFile(pathCopy);
        System.out.println("Done!");
    }

    
    public static void testDifference(String path, String pathSeuillage) {
        System.out.println("Test of difference");
        ImagePGM imgOriginal = new ImagePGM(path);
        ImagePGM imgthreshold = new ImagePGM(pathSeuillage);
        
        ImagePGM imagediff = imgOriginal.difference(imgthreshold);
        
        String pathCopy = imgOriginal.getPath().getParent().toString() + "/difference_"
                + imgOriginal.getPath().getFileName().toString();
        
        System.out.println("Writing image to " + pathCopy);
        
        imagediff.writeToFile(pathCopy);
        
        System.out.println("Done!");
    }
    

}
