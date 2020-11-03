package com.cloud.api.bean.image;

/**
 * rgb实体类
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/11/3 10:12
 */
public class Rgb {

    private int red;

    private int green;

    private int blue;

    public Rgb(){}

    public Rgb(int red,int green,int blue){
        setRed(red);
        setBlue(blue);
        setGreen(green);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        if (red < 0) {
            this.red = 0;
        } else if (red > 255) {
            this.red = 255;
        } else {
            this.red = red;
        }
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        if (green < 0) {
            this.green = 0;
        } else if (green > 255) {
            this.green = 255;
        } else {
            this.green = green;
        }
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        if (blue < 0) {
            this.blue = 0;
        } else if (blue > 255) {
            this.blue = 255;
        } else {
            this.blue = blue;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Rgb theRGB = (Rgb) obj;
        return this.getRed() == theRGB.getRed() && this.getGreen() == theRGB.getGreen() && this.getBlue() == theRGB.getBlue();
    }

    @Override
    public int hashCode() {
        return this.getRed() * 1000000 + this.getGreen() * 1000 + this.getBlue();
    }

    @Override
    public String toString() {
        return "RGB {" + this.red + ", " + this.green + ", " + this.blue + "}";
    }

}
