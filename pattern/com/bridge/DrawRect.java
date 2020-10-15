package com.bridge;

public class DrawRect extends DrawShaper {

	public DrawRect(ColorPainter colorPainter) {
		super(colorPainter);
	}

	@Override
	public void draw() {
		System.out.println("draw rect ......");
		colorPainter.paintColor();
	}
}
