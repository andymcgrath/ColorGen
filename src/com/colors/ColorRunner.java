package com.colors;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

/**
 * User: Andy McGrath
 * Date: 6/8/11
 */
public class ColorRunner {
    private static int index = 0;
    private static final int SIZE = 12;

    public static void main(String[] args) throws IOException {

//        System.out.println(getColorByRowCount(30));
//        System.out.println(getColorByIterator(30));

        System.out.println("Index = " + index);
        String color_1 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_2 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_3 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_4 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_5 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_6 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_7 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_8 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_9 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_10 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_11 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_12 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_13 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_14 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_15 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_16 = getColorByNext(index);
        System.out.println("Index = " + index);
        String color_17 = getColorByNext(index);
        System.out.println("Index = " + index);

        System.out.println("Color_1 = " + color_1);
        System.out.println("Color_2 = " + color_2);
        System.out.println("Color_3 = " + color_3);
        System.out.println("Color_4 = " + color_4);
        System.out.println("Color_5 = " + color_5);
        System.out.println("Color_6 = " + color_6);
        System.out.println("Color_7 = " + color_7);
        System.out.println("Color_8 = " + color_8);
        System.out.println("Color_9 = " + color_9);
        System.out.println("Color_10 = " + color_10);
        System.out.println("Color_11 = " + color_11);
        System.out.println("Color_12 = " + color_12);
        System.out.println("Color_13 = " + color_13);
        System.out.println("Color_14 = " + color_14);
    }

    public static String getColorByNext(int i) {

        String color = ColorService.getNextColor(i);
        System.out.println("Color = " + color);
        index++;

        if (index > SIZE) {
            System.out.println("Time to reset!");
            index = 0;
        }
        return color;
    }


    public static String getColorByRowCount(int rowcount) {
        List<String> colors = ColorService.getDefaultColorChips();
        int index = 0;
        while (index < rowcount) {
            for (String s : colors) {

                index++;
            }
        }
        return null;
    }

    public static String getColorByIterator(int rowcount) {
        List<String> colors = ColorService.getDefaultColorChips();

        int index = 0;
        while (index < rowcount) {

            System.out.println("Index = " + index);
            ListIterator<String> colorIterator = colors.listIterator();
            while (colorIterator.hasNext()) {
                String color = colorIterator.next();
                System.out.println("ColorIterator-" + colorIterator.nextIndex() + " = " + color);
            }
            index++;

        }
        return null;
    }
}

