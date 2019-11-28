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
        testWriteToFile(path);
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
    
    public static void testSeuillage(String path) {
        System.out.println("Test of seuillage");
        System.out.println("Loading image from " + path);
        System.out.println("Image loaded :");
        ImagePGM img = new ImagePGM(path);
        img.affiche();
        
        String pathCopy = img.getPath().getParent().toString() + "/seuillage_"
                + img.getPath().getFileName().toString();
        System.out.println("Writing image to " + pathCopy);
        img.seuillage(pathCopy);
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
