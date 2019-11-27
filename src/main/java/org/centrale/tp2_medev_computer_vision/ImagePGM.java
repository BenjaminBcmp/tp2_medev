/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.tp2_medev_computer_vision;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Benjamin
 */
public class ImagePGM {

    /**
     * The absolute path to the image.
     */
    private String path;

    /**
     * The matrix containing the grey value of each pixel in the image.
     */
    private int[][] mat;

    /**
     * The maximum value of a pixel in the image. Defaults to 255.
     */
    private int maxGrayValue = 255;

    /**
     * Height of the image. It is the number of rows in the matrix.
     */
    private int height;

    /**
     * Width of the image. It is the number of columns in the matrix.
     */
    private int width;

    public ImagePGM(String path) {
        this.path = path;
        this.loadFromFile();
    }

    public ImagePGM(int[][] mat) {
        this.mat = mat;
        this.height = mat.length;
        this.width = mat[0].length;
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

    /**
     * Initializes the attributes of the object by reading the file at path.
     */
    private void loadFromFile() {
        BufferedReader file;
        String line;
        StringTokenizer tokenizer;
        
        try {
            // Open file and skip the first two lines. 
            // TODO : Throw an Exception if the first line is not P2
            file = new BufferedReader(new FileReader(this.path));
            file.readLine();
            file.readLine();

            // Read height and width
            line = file.readLine();
            tokenizer = new StringTokenizer(line, " ");
            this.width = Integer.parseInt(tokenizer.nextToken());
            this.height = Integer.parseInt(tokenizer.nextToken());
            
            // Read max gray value
            line = file.readLine();
            this.maxGrayValue = Integer.parseInt(line);

            // Read pixels
            this.mat = new int[this.height][this.width];
            int gray;
            for (int i = 0; i < this.height; i++) {
                line = file.readLine();
                tokenizer = new StringTokenizer(line, "\t");
                for (int j = 0; j < this.height; j++) {
                    gray = Integer.parseInt(tokenizer.nextToken());
                    this.mat[i][j] = gray;
                }
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException er) {
            er.printStackTrace();
        } 
    }
    
    public void affiche() {
        System.out.println("Image at path: " + this.path);
        System.out.println("Width: " + this.width);
        System.out.println("Height: " + this.height);
        System.out.println("Max gray value: " + this.maxGrayValue);
    }

}
