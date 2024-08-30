module GameLauncher {
	requires java.desktop;
	exports br.heinz.iftm.tests;
	requires org.json;
	requires javafx.controls;
	requires javafx.swing;
	exports br.heinz.iftm.gui to javafx.graphics;
}