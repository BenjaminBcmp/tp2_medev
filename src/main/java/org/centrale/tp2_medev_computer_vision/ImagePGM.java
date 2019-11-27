/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.tp2_medev_computer_vision;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Benjamin
 */
public class ImagePGM {

    /**
     * The absolute path to the image as a Path object for convenience.
     */
    private Path path;

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
        this.path = Paths.get(path);
        this.loadFromFile();
    }

    /**
     * Creates an ImagePGM object from a matrix of gray pixels. Assumes that the
     * maximum value of a pixel is 255 and sets path to a null object.
     *
     * @param mat A matrix containing the gray value of the pixels in the image.
     */
    public ImagePGM(int[][] mat) {
        this.mat = mat;
        this.height = mat.length;
        this.width = mat[0].length;
    }

    public ImagePGM(ImagePGM img) {
        this.path = img.getPath();
        this.mat = img.getMat().clone();
        this.height = img.getHeight();
        this.width = img.getWidth();
        this.maxGrayValue = img.getMaxGrayValue();
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public int getMaxGrayValue() {
        return maxGrayValue;
    }

    public void setMaxGrayValue(int maxGrayValue) {
        this.maxGrayValue = maxGrayValue;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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
            file = new BufferedReader(new FileReader(this.path.toString()));
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

    /**
     * Writes the image to a file.
     *
     * @param path The path to where the image should be stored
     */
    public void writeToFile(String path) {
        BufferedWriter file = null;
        String line;
        try {
            // Open the file
            file = new BufferedWriter(new FileWriter(path));

            // Write the header of the file
            file.write("P2");
            file.newLine();
            file.write("#");
            file.newLine();

            // Write height, width and max gray value
            file.write(Integer.toString(this.width) + " " + Integer.toString(this.height));
            file.newLine();
            file.write(Integer.toString(this.maxGrayValue));
            file.newLine();
            
            // Write pixels
            for (int i=0;i<this.height;i++){
                for(int j=0;j<this.width;j++){
                    file.write(Integer.toString(this.mat[i][j]));
                    if (j < this.width - 1){ // Do not write \t for the last pixel
                        file.write("\t");
                    }
                }
                file.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.flush();
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
