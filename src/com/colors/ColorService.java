package com.colors;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * User: Andy McGrath
 * Date: 6/8/11
 */
public class ColorService {

	private enum ColorScheme {DEFAULT, ALTERNATE};

	private static List<String> defaultColorChips = new LinkedList<String>();
	private static List<String> alternateColorChips = new LinkedList<String>();
    private static List<String> colors = ColorService.getDefaultColorChips();

	static {
		defaultColorChips.add("000040");
		defaultColorChips.add("000080");
		defaultColorChips.add("0000ff");
		defaultColorChips.add("003040");
		defaultColorChips.add("004000");
		defaultColorChips.add("004030");
		defaultColorChips.add("006080");
		defaultColorChips.add("008000");
		defaultColorChips.add("008060");
		defaultColorChips.add("00bfff");
		defaultColorChips.add("00ff00");
		defaultColorChips.add("00ffbf");
		defaultColorChips.add("300040");

		alternateColorChips.add("ffbf00");
		alternateColorChips.add("ff00bf");
		alternateColorChips.add("ff0000");
		alternateColorChips.add("bfff00");
		alternateColorChips.add("bf00ff");
		alternateColorChips.add("806000");
		alternateColorChips.add("800060");
		alternateColorChips.add("800000");
		alternateColorChips.add("608000");
		alternateColorChips.add("600080");
		alternateColorChips.add("403000");
		alternateColorChips.add("400030");
		alternateColorChips.add("304000");
	}

	public static String getColorChip(String type){
		if (ColorScheme.ALTERNATE.name().equalsIgnoreCase(type)){
			List<String> colors = ColorService.getAlternateColorChips();
			ListIterator<String> colorIterator = colors.listIterator(0);
			if (colorIterator.hasNext()){
				return colorIterator.next();
			}

		} else {
			List<String> colors = ColorService.getDefaultColorChips();
			ListIterator<String> colorIterator = colors.listIterator(0);
			if (colorIterator.hasNext()){
				String color =  colorIterator.next();
                return color;
			}
		}
		return null;
	}

    public static synchronized String getNextColor(int index) {

        String c = colors.listIterator(index).next();

        return c;
    }
	public static List<String> getDefaultColorChips() {
		return defaultColorChips;
	}

	public static List<String> getAlternateColorChips() {
		return alternateColorChips;
	}
}
