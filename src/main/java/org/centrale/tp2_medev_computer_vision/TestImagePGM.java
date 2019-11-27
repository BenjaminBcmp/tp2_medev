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
    
    public static void main(String[] args){
        testLoadFromFile();
    }
    
    public static void testLoadFromFile() {
        System.out.println("Test of loadFromFile");
        String path = "/Users/Benjamin/Downloads/lena.pgm";
        System.out.println("Loading image from " + path);
        System.out.println("Image loaded :");
        ImagePGM img = new ImagePGM(path);
        img.affiche();
        System.out.println("Done!");
    }
}
