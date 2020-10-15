package com.bridge;

public class DrawCircle extends DrawShaper {

	public DrawCircle(ColorPainter colorPainter) {
		super(colorPainter);
	}

	@Override
	public void draw() {
		System.out.println("draw circle ...... ");
		colorPainter.paintColor();
	}
}
