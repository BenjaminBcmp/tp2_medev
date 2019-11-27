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
public class ImagePGM {
    
    private String path;
    private int[][] mat;

    public ImagePGM(String path) {
        this.path = path;
    }

    public ImagePGM(int[][] mat) {
        this.mat = mat;
    }

    public ImagePGM(ImagePGM img) {
        this.path = img.getPath();
        this.mat = img.getMat();
    }

    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int[][] getMat() {
        return mat;
    }

    public void setMat(int[][] mat) {
        this.mat = mat;
    }
    
    
    
}
