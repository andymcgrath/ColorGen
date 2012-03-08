package com.colors;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Andy McGrath
 * Date: 5/25/11
 */
public class ColorGen {
    public static enum ColorScheme {
        TRIAD, TETRAD, SQUARE, COMPLIMENTARY, ANALOGOUS
    }

    ;

    private static final int DEFAULT_WIDTH = 4;
    private static final int DEFAULT_HEIGHT = 4;
    private static final int COLOR_SPECTRUM = 360;
    private static final int ONE_HUNDRED_PERCENT = 100;
    private static final float V = 1f;
    private static final float B = 1f;
    private static int index = 0;


    public static void main(String[] args) throws IOException {
        List<Color> colorArray = new ArrayList<Color>();
//        colorArray.add(new Color(255,0,0));
////        colorArray.add(new Color(255,153,0));
        colorArray.add(new Color(0xfcc25f));
        colorArray.add(new Color(0x5d83b3));
        colorArray.add(new Color(0xa3597c));
        colorArray.add(new Color(0x6d7d65));
        colorArray.add(new Color(0xe27b64));
        colorArray.add(new Color(0x5e9f9b));
        colorArray.add(new Color(0xcd5f60));
        colorArray.add(new Color(0x47866a));
        //colorArray.add(new Color(0xfra562));
        colorArray.add(new Color(0x9d9a58));
        colorArray.add(new Color(0xfa8f5a));
        colorArray.add(new Color(0x7b96ad));
        colorArray.add(new Color(0x578d80));
        colorArray.add(new Color(0xb4c49c));
        colorArray.add(new Color(0xa36467));
        colorArray.add(new Color(0x5d83b3));
        colorArray.add(new Color(0xf9e47e));
        colorArray.add(new Color(0x34505c));
        colorArray.add(new Color(0xbc524e));
        colorArray.add(new Color(0x8cb366));
        colorArray.add(new Color(0x85a4d6));
        colorArray.add(new Color(0xdcd871));
        colorArray.add(new Color(0x496490));



//        getColorChips("Triad", 12);
//        getColorChips("Tetrad", 20);
        getColorChips("Square", 20);
//        getColorChips("Complimentary", 200);
//        getColorChips(null, 20);

        writeFiles(colorArray, "google");
    }

    public static void getColorChips(String scheme, Integer rows) throws IOException {
        Integer rowCount = rows;
        float hue = 0f;
        List<Image> chips = new LinkedList<Image>();
        // TODO: Use this Set to collect chips to send back to consumer
        // Idea is to iterate over collection to provide chart colors. Must
        // preserve order!

        Color hsbColor = Color.getHSBColor(hue, V, B);

        while (index < rowCount) {
            List<Color> colors = new LinkedList<Color>();
            System.out.println("<<<<<<<<<>>>>>>>>>>");
            System.out.println("Scheme: " + scheme);
            System.out.println("Rowcount: " + rowCount);
            System.out.println("Index: " + index);
            if (ColorScheme.SQUARE.name().equalsIgnoreCase(scheme)) {
                getSquareTetrad(hsbColor, colors, getIncrementValue(rowCount));
//                index = index + 12;
                System.out.println("Index: " + index);
            } else if (ColorScheme.TRIAD.name().equalsIgnoreCase(scheme)) {
                getTriad(hsbColor, colors, getIncrementValue(rowCount));
//                index = index + 9;
                System.out.println("Index: " + index);
            } else if (ColorScheme.COMPLIMENTARY.name().equalsIgnoreCase(scheme)) {
                getComplimentary(hsbColor, colors, getIncrementValue(rowCount));
//                index = index + 6;
                System.out.println("Index: " + index);
            } else if (ColorScheme.TETRAD.name().equalsIgnoreCase(scheme)) {
                getTetrad(hsbColor, colors, getIncrementValue(rowCount));
//                index = index + 12;
                System.out.println("Index: " + index);
            } else {
                getAnalogous(hsbColor, colors, getIncrementValue(rowCount));
//                index = index + 9;
                System.out.println("Index: " + index);
            }

            for (Color c : colors) {
                System.out.println("Color = " + c.getRGB());
            }
            writeFiles(colors, scheme);

            hsbColor = incrementHueValue(hsbColor, getIncrementValue(rowCount));
            hue += getIncrementValue(rowCount);

        }
    }

    private static Integer getIncrementValue(Integer rows) {
        if (rows > 216) {
            return 12;
        } else {
            Integer a = 216 / rows;
            Integer b = a * 12;
            return b;
        }
    }

    private static void getComplimentary(Color c, List<Color> colors, Integer increment) {
        gatherColors(c, colors);

        Color oneEightyColor = incrementHueValue(c, 180);
        gatherColors(oneEightyColor, colors);
        index = index + 6;
        System.out.println("getComplimentary... +6");
    }

    private static void getTetrad(Color c, List<Color> colors, Integer increment) {
        gatherColors(c, colors);

        Color oneThirtyNineColor = incrementHueValue(c, 139);
        gatherColors(oneThirtyNineColor, colors);

        Color bizarroOneThirtyNineColor = incrementHueValue(c, -139);
        gatherColors(bizarroOneThirtyNineColor, colors);

        Color oneEightyColor = incrementHueValue(c, 180);
        gatherColors(oneEightyColor, colors);
        index = index + 12;
        System.out.println("getTetrad... +12");
    }

    private static void getSquareTetrad(Color c, List<Color> colors, Integer increment) {
        gatherColors(c, colors);

        Color ninetyColor = incrementHueValue(c, 90);
        gatherColors(ninetyColor, colors);

        Color oneEightyColor = incrementHueValue(c, 180);
        gatherColors(oneEightyColor, colors);

        Color twoSeventyColor = incrementHueValue(c, 270);
        gatherColors(twoSeventyColor, colors);
        index = index + 12;
        System.out.println("getSquareTetrad... +12");
    }

    private static void getAnalogous(Color c, List<Color> colors, Integer increment) {
        gatherColors(c, colors);

        Color fortyFiveColor = incrementHueValue(c, 45);
        gatherColors(fortyFiveColor, colors);

        Color bizarroFortyFiveColor = incrementHueValue(c, -45);
        gatherColors(bizarroFortyFiveColor, colors);
        index = index + 9;
        System.out.println("getAnalogous... +9");
    }

    private static void getTriad(Color c, List<Color> colors, Integer increment) {
        gatherColors(c, colors);

        Color oneThirtyNineColor = incrementHueValue(c, 139);
        gatherColors(oneThirtyNineColor, colors);

        Color bizarroOneThirtyNineColor = incrementHueValue(c, -139);
        gatherColors(bizarroOneThirtyNineColor, colors);
        index = index + 9;
        System.out.println("getTriad... +9");
    }

    private static void gatherColors(Color c, List<Color> colors) {
        colors.add(c);
        colors.add(incrementBrightnessValue(c, 50));
//        colors.add(incrementBrightnessValue(c, 40));
        colors.add(incrementBrightnessValue(c, 75));
        System.out.println("gatherColors... +3");
    }

    private static String getColorHex(int uc, boolean hash) {
        String raw = Integer.toHexString(uc);
        if (hash) {
            return "#" + raw.substring(2);
        } else {
            return raw.substring(2);
        }
    }

    private static Color incrementHueValue(Color c, int increment) {
        float[] hsb = c.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
        float hue = hsb[0] * COLOR_SPECTRUM;
        Float incremented = hue + increment;
//        System.out.println("======================");
//        System.out.println("New HUE: " + incremented.intValue());
        float nHue = incremented / COLOR_SPECTRUM;

        hsb[0] = nHue;
        int rawRGB = c.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
        String hex = getColorHex(rawRGB, false);
//        System.out.println("HEX: " + getColorHex(rawRGB, true));

        int red = Integer.parseInt(hex.substring(0, 2), 16);
        int green = Integer.parseInt(hex.substring(2, 4), 16);
        int blue = Integer.parseInt(hex.substring(4, 6), 16);

//        System.out.println(" - RED: " + red);
//        System.out.println(" - GREEN: " + green);
//        System.out.println(" - BLUE: " + blue);
        return new Color(red, green, blue);
    }

    private static Color incrementBrightnessValue(Color c, int increment) {
        float[] hsb = c.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
        float brightness = hsb[2] * ONE_HUNDRED_PERCENT;
        Float incremented = brightness - increment;
//        System.out.println("New Brightness: " + incremented.intValue());
        float nBrightness = incremented / ONE_HUNDRED_PERCENT;

        hsb[2] = nBrightness;
        int rawRGB = c.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
        String hex = getColorHex(rawRGB, false);
//        System.out.println("HEX: " + getColorHex(rawRGB, true));

        int red = Integer.parseInt(hex.substring(0, 2), 16);
        int green = Integer.parseInt(hex.substring(2, 4), 16);
        int blue = Integer.parseInt(hex.substring(4, 6), 16);

//        System.out.println(" - RED: " + red);
//        System.out.println(" - GREEN: " + green);
//        System.out.println(" - BLUE: " + blue);
        return new Color(red, green, blue);
    }

    private static void writeFiles(List<Color> colors, String scheme) throws IOException {
        File dir = new File("C:/temp/colors/" + scheme);
        dir.mkdir();
        for (Color c : colors) {
            BufferedImage chip = createImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, c);
            Image image = chip;

            String filename = getColorHex(c.getRGB(), false) + ".gif";
            File f = new File(dir, filename);
            if (!f.exists()) {
                f.createNewFile();
                System.out.println("New file has been created in the current directory: " + filename);
            }
            FileImageOutputStream out = new FileImageOutputStream(f);
            ImageIO.write(chip, "gif", out);
        }

    }

    private static BufferedImage createImage(int w, int h, Color color) {

        // validate dimensions
        w = Math.max(w, DEFAULT_WIDTH);
        h = Math.max(h, DEFAULT_HEIGHT);

        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);

        Graphics graphics = image.getGraphics();

        graphics.setPaintMode();
        graphics.setColor(color);
        graphics.fillRect(0, 0, w, h);

        return image;
    }

}
