package com.bridge;

public class Client {

	public static void main(String[] args) {
		DrawShaper drawShaper = new DrawRect(new RedPainter());
		drawShaper.draw();
	}
}
