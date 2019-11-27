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
        String path = "/Users/Benjamin/Downloads/lena.pgm";
        ImagePGM img = new ImagePGM(path);
        img.affiche();
    }
}
