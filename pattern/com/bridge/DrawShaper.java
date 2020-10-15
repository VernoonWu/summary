package com.bridge;

public abstract class DrawShaper {

	protected ColorPainter colorPainter;

	public DrawShaper(ColorPainter colorPainter) {
		super();
		this.colorPainter = colorPainter;
	}

	abstract public void draw();
}
