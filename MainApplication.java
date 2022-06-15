/*
  Names: Simon Bakan and Joshua Persaud
  Teacher: Ms. Krasteva
  Date: June 14, 2022
  Course: ICS4U0/P
  
  Purpose: to act as a driver class and run various code in the correct order to simulate a game.
  Worked on by: Joshua and Simon
*/

import javafx.application.Application; // Imports the Application.java class, which allows the program to create a GUI and display it on the screen to the user.
import javafx.animation.Animation; // Imports the Animation.java class, which allows the program to have access to various animation variables and methods.
import javafx.animation.FadeTransition; // Imports the FadeTransition.java class, which allows the program to create a fading transition that is used in various places, such as in the loading screen.
import javafx.animation.TranslateTransition; // Imports the TranslateTransition.java class, which allows the program to create a translating transition that is used in various places, such as in the main menu.
import javafx.animation.ParallelTransition; // Imports the ParallelTransition.java class, which allows the program to have numerous transitions happening at once, such as with the three clouds in the main menu.
import javafx.event.EventHandler; // Imports the EventHandler.java class, which allows the program to recognize inputs and events that are occuring on the computer (say from user input from the mouse or keyboard).
import javafx.event.ActionEvent; // Imports the ActionEvent.java class, which allows the program to recognize inputs and actions that are occuring on the computer (say from user input from the mouse or keyboard).
import javafx.scene.Scene; // Imports the Scene.java class, which allows the program to have access to a scene on which the GUI can be added onto and displayed to the user.
import javafx.scene.Group; // Imports the Group.java class, which allows the program to have access to the group layout to organize Nodes and other graphics within (it can group various nodes together).
import javafx.scene.Cursor; // Imports the Cursor.java class, which allows the program to have access to the cursor, more specifically the icon that is used for the cursor (as it can now be changed to represent different actions, such as clicking a button).
import javafx.scene.control.Label; // Imports the Label.java class, which allows the program to create labels that hold specified text and look good (through various stylistic changes).
import javafx.scene.shape.Shape; //. Imports the Shape.java class, which allows the program to create a generic shape that will be shown to the user (by being added as a node to the current scene).
import javafx.scene.shape.Circle; // Imports the Circle.java class, which allows the program to create a circle that will be shown to the user (by being added as a node to the current scene).
import javafx.scene.shape.Rectangle; // Imports the Rectangle.java class, which allows the program to create a rectangle that will be shown to the user (by being added as a node to the current scene).
import javafx.scene.paint.Paint; // Imports the Paint.java class, which allows the program to create specific paint colours for various parts of the GUI.
import javafx.scene.paint.Color; // Imports the Color.java class, which allows the programa to create specific colors for various parts of the GUI.
import javafx.scene.image.Image; // Imports the Image.java class, which allows the program to create images from various files that are on the user's computer.
import javafx.scene.image.ImageView; // Imports the ImageView.java class, which allows the program to create images that can act as nodes and can be added onto the scenes (and displayed to the user).
import javafx.scene.input.KeyEvent; // Imports the KeyEvent.java class, which allows the program to recognize inputs that are coming from the keyboard and act accordingly based on what key the input is coming from.
import javafx.scene.input.KeyCode; // Imports the KeyCode.java class, which allows the program to see what key the key event is coming from.
import javafx.scene.input.MouseEvent; // Imports the MouseEvent.java class, which allows the program to recognize inputs that are coming from the mouse and act accordingly.
import javafx.scene.text.Font; // Imports the Font.java class, which allows the program to access and use fonts that are installed on the computer, such as the Press Start 2P font that is used in the game.
import javafx.stage.Stage; // Imports the Stage.java class, which allows the program to have access to a stage to display the graphics within.
import javafx.stage.StageStyle; // Imports the StageStyle.java class, which allows the program to set the style of the stage (such as modifying its border).
import javafx.util.Duration; // Imports the Duration.java class, which allows the program to set the duration of time for a specific task (say how long the fading animation (so FadeTransition instance) should last for).

import java.io.File; // Imports the File.java class, which allows the program to access files that are on the user's computer.
import java.io.IOException; // Imports the IOException.java class, which allows the program to take care of the IOExceptions that are thrown by any parts of the program.

// Remember to add JavaDoc for these imports:
import javafx.scene.layout.Region; // Imports the Region.java class, which allows the program to utilize the USE_COMPUTED_SIZE variable to use default heights for various Node.java text instances.
import javafx.scene.text.Text; // Imports the Text.java class, which allows the program to beautiful text to display to the user. 
import javafx.scene.shape.StrokeType; // Imports the StrokeType.java class, which allows the program to set the type of stroke that is used on the outer rectangle for the leaderboard Rectangle.java instance.
import javafx.scene.shape.StrokeLineJoin; // Imports the StrokeLineJoin.java class, which allows the program to set how two lines come together (such as a rounded point or a sharp edge).
import javafx.scene.text.TextFlow; // Imports the TextFlow.java class, which allows the program to add two or more Text.java instances together.
import javafx.scene.layout.Pane; // Imports the Pane.java class, which allows the program to have a simple and vanilla layout manager where multiple Node.java instances can be added to.
import java.io.FileInputStream; // Imports the FileInputStream.java class, which allows the program to read in data from files that arer on the user's computer.
//import java.util.Arrays;
//import javafx.scene.control.Dialog;
//import javafx.scene.control.DialogPane;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.TextField; // Imports the TextField.java class, which allows the program to easily take in Strings from the user (more specifically, their username).
import javafx.animation.ScaleTransition; // Imports the ScaleTransition.java class, which allows the program to make transitions that involve scaling, such as with the scaling of the logo in the intro animation.
import javafx.scene.layout.StackPane; // Imports the StackPane.java class, which allows the program to use the StackPane layout manager (which just centers all the Node.java instances and then stacks them).
import java.time.LocalDateTime; // Imports the LocalDateTime.java class, which allows the program to keep track of various times, such as the time when the user starts the game and when they end it.
import javafx.geometry.Pos; // Imports the Pos.java class, which allows the program to change the positioning of Node.java instances within layout managers.
import javafx.scene.layout.GridPane; // Imports the GridPane.java class, which allows the program to have access to a grid layout manager.
//import java.nio.charset.Charset;
import javafx.scene.shape.Ellipse; // Imports the Ellipse.java class, which will allow the program to create ellipses for the graphics.
//import java.util.Arrays;

/**
 * Main program that will act as driver class and run entire game.
 * <p>
 * This class will be used to create instances of various classes
 * to create the game. It will also coordinate the code so that
 * the program works as intended.
 * <p>
 * Course: ICS 4U0/P
 * <p>
 * Teacher Name: Ms. Krasteva
 * <p>
 * Purpose: to act as a driver class and run various code in
 * the correct order to simulate a game.
 * <p>
 * Filename: MainApplication.java
 *
 * @author Simon Bakan
 * @author Joshua Persaud
 * @version 5/27/2022
 * 
 * @see javafx.application.Application
 * @see javafx.animation.Animation
 * @see javafx.animation.FadeTransition
 * @see javafx.animation.TranslateTransition
 * @see javafx.animation.ParallelTransition
 * @see javafx.event.EventHandler
 * @see javafx.event.ActionEvent
 * @see javafx.scene.Scene
 * @see javafx.scene.Group
 * @see javafx.scene.Cursor
 * @see javafx.scene.control.Label
 * @see javafx.scene.shape.Shape
 * @see javafx.scene.shape.Circle
 * @see javafx.scene.shape.Rectangle
 * @see javafx.scene.paint.Paint
 * @see javafx.scene.paint.Color
 * @see javafx.scene.image.Image
 * @see javafx.scene.image.ImageView
 * @see javafx.scene.input.KeyEvent
 * @see javafx.scene.input.KeyCode
 * @see javafx.scene.input.MouseEvent
 * @see javafx.stage.Stage
 * @see javafx.stage.StageStyle
 * @see javafx.util.Duration
 * @see java.io.File
 * @see java.io.IOException
 *
 * @since JDK1.17
 */
 
 /*
 Sources used:
  * https://www.youtube.com/watch?v=t4ehYIynI34
  * https://jenkov.com/tutorials/javafx/your-first-javafx-application.html
  * https://stackoverflow.com/questions/32512003/java-wildcard-import-statements
  * https://docs.oracle.com/javase/7/docs/api/java/awt/Image.html
  * https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html
  * https://www.youtube.com/watch?v=trAYvIt9mgk
  * https://stackoverflow.com/questions/62453869/how-to-update-part-of-bufferedimage-and-display-it-with-javafx
  * https://stackoverflow.com/questions/20425507/how-to-create-image-in-java
  * https://stackoverflow.com/questions/28100060/javafx-canvas-draw-image-with-transparency
  * https://stackoverflow.com/questions/40825645/javafx-image-display-using-the-hbox-and-the-vbox-from-for-loop
  * https://stackoverflow.com/questions/11188018/how-to-wait-for-a-transition-to-end-in-javafx-2-1 
  * https://www.canva.com/colors/color-meanings/gray/
  * https://www.tabnine.com/code/java/methods/javafx.scene.image.ImageView/setOpacity 
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Parent.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Rectangle.html
  * https://docs.oracle.com/javafx/2/api/javafx/animation/FadeTransition.html
  * https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html
  * https://stackoverflow.com/questions/49216396/clearing-the-scene-in-javafx
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/text/Text.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/Image.html
  * https://edencoding.com/how-to-add-an-image-to-a-button/
  * https://stackoverflow.com/questions/17467137/how-can-i-create-a-switch-button-in-javafx
  * https://stackoverflow.com/questions/16635514/how-to-get-location-of-mouse-in-javafx
  * http://www.java2s.com/ref/java/javafx-text-display-mouse-position.html
  * https://stackoverflow.com/questions/47166686/javafx-regularly-get-mouse-position
  * https://docs.oracle.com/javase/tutorial/uiswing/events/generalrules.html
  * https://docs.oracle.com/javase/tutorial/uiswing/events/mouselistener.html
  * https://docs.oracle.com/javase/tutorial/uiswing/events/problems.html
  * https://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
  * https://docs.oracle.com/javase/7/docs/api/java/beans/EventHandler.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Cursor.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Labeled.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html
  * https://stackoverflow.com/questions/33260896/javafx-mouse-lags-behind-drawing
  * https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html
  * https://stackoverflow.com/questions/58527858/java-vsync-without-fullscreen-window
  * https://stackoverflow.com/questions/37880678/how-to-increase-draw-speed-of-lines-on-canvas-in-javafx
  * https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CountDownLatch.html
  * https://docs.oracle.com/javafx/2/api/javafx/stage/Stage.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/event/EventHandler.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/MouseEvent.html
  * https://docs.oracle.com/javafx/2/api/javafx/application/Platform.html
  * https://stackoverflow.com/questions/16708931/javafx-working-with-threads-and-gui
  * https://stackoverflow.com/questions/37472273/detect-single-key-press-in-javafx
  * https://stackoverflow.com/questions/29962395/how-to-write-a-keylistener-for-javafx
  * https://stackoverflow.com/questions/2352447/what-is-the-need-of-void-class-in-java
  * https://docs.oracle.com/javase/8/docs/api/java/lang/Void.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/animation/ParallelTransition.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/animation/TranslateTransition.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/animation/package-summary.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/StackPane.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/text/Font.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Shape.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Circle.html
  * https://docs.oracle.com/javafx/2/api/javafx/animation/package-summary.html
  * https://docs.oracle.com/javafx/2/api/javafx/animation/TranslateTransition.html
  * https://docs.oracle.com/javafx/2/api/javafx/animation/ParallelTransition.html
  * https://docs.oracle.com/javafx/2/api/javafx/animation/PathTransition.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/transform/package-summary.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/transform/Translate.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/transform/Scale.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/transform/Rotate.html
  * https://stackoverflow.com/questions/10275841/how-to-change-the-icon-on-the-title-bar-of-a-stage-in-java-fx-2-0-of-my-applicat
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Group.html
  * https://blog.idrsolutions.com/tutorial-change-default-cursor-javafx/
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/SceneAntialiasing.html
  * https://fonts.google.com/specimen/Press+Start+2P
  * https://www.fontspace.com/press-start-2p-font-f11591
  * https://www.dafont.com/press-start-2p.font
  * https://docs.oracle.com/javase/8/docs/api/java/io/FileInputStream.html
  * https://stackoverflow.com/questions/33336542/javafx-custom-fonts
  * http://fxexperience.com/2012/12/use-webgoogle-fonts-in-javafx/
  * https://stackoverflow.com/questions/16855677/how-to-embed-ttf-fonts-in-javafx-2-2
  * https://stackoverflow.com/questions/44146774/how-to-debug-error-expected-lbrace-at-75-0-javafx-css
  * https://stackoverflow.com/questions/22047457/how-to-change-the-text-font-size-in-javafx
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Region.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Labeled.html
  * http://www.java2s.com/Code/Java/JavaFX/MoveaLabelbyusingsetTranslateY.htm
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Paint.html
  * https://www.demo2s.com/java/javafx-label-setbackground-background-value.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Background.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BackgroundFill.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/CornerRadii.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Insets.html
  * https://www.w3.org/wiki/CSS/Properties/color/keywords
  * https://stackoverflow.com/questions/20938095/difference-between-final-and-effectively-final
  * https://www.baeldung.com/java-effectively-final
  * https://www.diffchecker.com/diff
  * https://www.tutorialspoint.com/online_java_formatter.htm
  * https://stackoverflow.com/questions/43761138/how-to-properly-switch-scenes-change-root-node-of-scene-in-javafx-without-fxml
  * https://jenkov.com/tutorials/javafx/label.html
  * http://www.java2s.com/Tutorials/Java/JavaFX/0400__JavaFX_Label.htm
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/StackPane.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableList.html
  * https://www.tutorialspoint.com/how-to-strike-through-and-underline-text-in-javafx
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html
  * https://assylias.wordpress.com/2013/12/08/383/
  * https://www.tutorialspoint.com/javafx/javafx_architecture.htm
  * https://www.w3schools.com/cssref/pr_text_text-decoration.asp
  * https://stackoverflow.com/questions/37533915/how-to-align-center-label-in-javafx-fxml
  * https://stackoverflow.com/questions/46997267/how-do-i-insert-text-into-a-shape-in-javafx
  * https://stackoverflow.com/questions/42682154/javafx-how-do-you-add-multiple-elements-to-a-stackpane
  * https://docs.oracle.com/javase/8/javafx/api/javafx/geometry/package-summary.html
  * https://docs.oracle.com/javafx/2/api/javafx/animation/package-summary.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html
  * https://docs.oracle.com/javase/7/docs/api/java/io/FileInputStream.html
  * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
  * https://stackoverflow.com/questions/20019699/javafx-build-your-own-rectangle
  * https://stackoverflow.com/questions/30439848/how-to-adjust-labels-width-to-fit-its-content
  * https://stackoverflow.com/questions/12737829/javafx-textfield-resize-to-text-length
  * https://stackoverflow.com/questions/38096641/how-can-i-get-the-width-and-the-height-of-a-javafx-label
  * https://coderanch.com/t/689275/java/calculate-real-text-layoutbounds-label
  * https://docs.oracle.com/javase/9/docs/api/javafx/scene/text/TextBoundsType.html
  * https://stackoverflow.com/questions/30983584/how-to-get-the-size-of-a-label-before-it-is-laid-out
  * https://stackoverflow.com/questions/21074024/how-to-get-label-getwidth-in-javafx
  * https://stackoverflow.com/questions/46641114/an-alternative-to-fontloader-computestringwidth
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/HBox.html
  * https://stackoverflow.com/questions/23258605/javafx-how-can-i-best-place-a-label-centered-in-a-shape
  * https://stackoverflow.com/questions/17437411/how-to-put-a-text-into-a-circle-object-to-display-it-from-circles-center
  * https://docs.oracle.com/javafx/2/api/javafx/geometry/Pos.html
  * https://stackoverflow.com/questions/33190849/how-to-move-shapes-in-javafx
  * https://stackoverflow.com/questions/23576044/how-to-center-a-node-within-a-pane-javafx
  * https://stackoverflow.com/questions/28835920/when-to-use-translate-and-when-relocate-what-is-the-difference-between-transla
  * https://docs.oracle.com/javase/7/docs/api/java/io/FileReader.html
  * https://docs.oracle.com/javase/7/docs/api/java/io/PrintWriter.html
  * https://docs.oracle.com/javase/7/docs/api/java/io/File.html
  * https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html
  * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
  * https://docs.oracle.com/javase/7/docs/api/java/sql/Time.html
  * https://www.w3schools.com/java/java_files_create.asp
  * https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html
  * https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html
  * https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
  * https://stackoverflow.com/questions/25747499/java-8-difference-between-two-localdatetime-in-multiple-units
  * https://docs.oracle.com/javase/tutorial/datetime/iso/period.html
  * https://docs.oracle.com/javase/8/docs/api/java/time/Period.html
  * https://docs.oracle.com/javafx/2/api/javafx/scene/input/KeyCode.html
  * https://stackoverflow.com/questions/1879860/most-reliable-split-character
  * http://cs.uky.edu/~keen/115/reading/split.pdf
  * https://commons.wikimedia.org/wiki/File:ASCII-Table-wide.svg
  * https://www.delftstack.com/howto/java/empty-char-in-java/
  * https://stackoverflow.com/questions/17780398/sort-two-arraylists-concurrently
  * https://stackoverflow.com/questions/7851830/what-is-the-color-code-for-transparency-in-css
  * https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html
  * https://stackoverflow.com/questions/67238426/certain-components-stacking-on-top-of-each-other-in-javafx
  * https://www.angus-liu.cn/JavaFX-For-Dummies-zh/Chapter-11.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Pane.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/AnchorPane.html
  * https://stackoverflow.com/questions/33880094/adding-a-gridpane-to-a-gridpane
  * https://stackoverflow.com/questions/44017320/javafx-display-background-of-a-disabled-label
  * https://jenkov.com/tutorials/javafx/gridpane.html
  * https://www.tutorialspoint.com/javafx/javafx_layout_panes.htm
  * https://community.oracle.com/tech/developers/discussion/2382755/added-a-gridpane-to-a-stackpane-but-gridpane-not-centered
  * https://jenkov.com/tutorials/javafx/overview.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/text/TextAlignment.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/text/TextFlow.html
  * https://stackoverflow.com/questions/68615101/font-selection-and-rendering-with-javafx
  * https://jenkov.com/tutorials/javafx/text.html
  * https://docs.oracle.com/javafx/2/api/javafx/fxml/doc-files/introduction_to_fxml.html
  * https://stackoverflow.com/questions/34750881/how-to-get-width-and-height-of-the-javafx-scene-text-text-control
  * https://www.codegrepper.com/code-examples/css/increase+text+underline+thickness
  * https://stackoverflow.com/questions/13015698/how-to-calculate-the-pixel-width-of-a-string-in-javafx
  * https://stackoverflow.com/questions/35284816/css-for-javafx-scene-text-text
  * https://openjfx.io/javadoc/16/javafx.graphics/javafx/scene/doc-files/cssref.html
  * https://www.geeksforgeeks.org/javafx-textflow-class/
  * https://stackoverflow.com/questions/27846659/how-to-draw-an-1-pixel-line-using-javafx-canvas
  * https://www.codegrepper.com/code-examples/java/javafx+center+node+in+gridpane
  * https://www.color-name.com/wood-brown.color
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/StrokeLineCap.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/StrokeLineJoin.html
  * https://stackoverflow.com/questions/50574819/javafx-css-two-pixel-border
  * https://stackoverflow.com/questions/33434882/can-a-rectangle-be-styled-to-show-a-border
  * https://docs.oracle.com/javase/8/javafx/api/index.html?javafx/scene/layout/BorderStroke.html
  * https://stackoverflow.com/questions/22725813/javafx-disable-image-smoothing-on-canvas-object
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/FlowPane.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/VBox.html
  * https://stackoverflow.com/questions/40582099/flip-javafx-image-horizontally-or-vertically
  * https://community.oracle.com/tech/developers/discussion/2454365/how-would-you-flip-an-imageview-along-its-vertical-axis
  * https://jewelsea.wordpress.com/2011/11/16/rotation-transform-example/
  * https://gist.github.com/jewelsea/1475424
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Skin.html
  * https://stackoverflow.com/questions/10465752/how-to-create-skinsfxml-for-buttons-and-other-elements-in-javafx-2-0
  * http://fxexperience.com/2009/06/skinning-architecture-in-javafx/
  * https://stackoverflow.com/questions/28037818/how-to-add-a-scrollbar-in-javafx
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ScrollPane.html
  * https://docs.oracle.com/javafx/2/ui_controls/scrollpane.htm
  * https://www.javatpoint.com/javafx-scrollbar
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/KeyCode.html
  * https://stackoverflow.com/questions/45091813/writing-and-reading-localdatetime-from-file-most-efficiently
  * https://stackoverflow.com/questions/53353481/how-to-write-a-localdate-list-to-a-file-in-java
  * https://stackoverflow.com/questions/4805606/how-to-sort-by-two-fields-in-java
  * https://docs.google.com/presentation/d/1g1-KDaWqp-MTs5V3XldSOF1BHwuZivUdiKYRWPVN4qw/edit?usp=sharing
  * https://docs.oracle.com/javase/8/docs/api/java/time/temporal/ChronoUnit.html
  * https://stackoverflow.com/questions/30819196/storing-difference-between-two-localdatetime-values
  * https://stackoverflow.com/questions/4805606/how-to-sort-by-two-fields-in-java
  * https://stackoverflow.com/questions/45458256/java-8-sort-using-2-fields
  * https://stackoverflow.com/questions/29993483/sort-an-arraylist-by-two-fields-java
  * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
  * https://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalAmount.html
  * https://howtodoinjava.com/java/date-time/java8-period/
  * https://stackoverflow.com/questions/9963147/get-the-number-of-weeks-between-two-dates
  * https://docs.oracle.com/javase/8/docs/api/java/time/temporal/ChronoUnit.html
  * https://www.geeksforgeeks.org/period-getdays-method-in-java-with-examples/
  * https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
  * https://stackoverflow.com/questions/43465947/how-to-make-imageview-move-in-the-direction-its-facing-after-rotate-it-in-javaf
  * https://stackoverflow.com/questions/28087776/mirror-effect-in-javafx
  * https://stackoverflow.com/questions/20489908/border-radius-and-shadow-on-imageview
  * https://stackoverflow.com/questions/40258094/javafx-drag-2-nodes-simultaneously
  * https://stackoverflow.com/questions/28283693/use-a-binary-search-on-an-int-array-sorted-in-descending-order
  * https://stackoverflow.com/questions/55232972/why-doesnt-the-binary-search-method-work-if-the-array-is-sorted-in-descending-o
  * https://stackoverflow.com/questions/7908527/java-binarysearch-algo-on-descendant-list
  * https://stackoverflow.com/questions/42204005/java-arraylist-binary-search-arraylist
  * https://github.community/t/why-cant-desktop-find-my-repository/151877
  * https://github.com/desktop/desktop/issues/9604
  * https://softwarekeep.com/help-center/what-is-the-appdata-folder-in-windows-10
  * https://desktop.github.com/
  * https://stackoverflow.com/questions/55936528/how-to-put-buttons-and-strings-together-into-a-javafxml-scrollpane
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ListView.html
  * https://jenkov.com/tutorials/javafx/tableview.html
  * https://stackoverflow.com/questions/41804373/javafx-scrollpane-styling
  * https://docs.oracle.com/javafx/2/css_tutorial/jfxpub-css_tutorial.htm
  * https://www.callicoder.com/javafx-css-tutorial/
  * https://stackoverflow.com/questions/48048943/javafx-8-scroll-bar-css
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Ellipse.html
  * https://stackoverflow.com/questions/55709178/how-to-drag-and-drop-button-onto-gridpane
  * https://docs.oracle.com/javafx/2/api/javafx/scene/input/DragEvent.html
  * https://docs.oracle.com/javafx/2/api/javafx/event/Event.html
  * https://docs.oracle.com/javafx/2/drag_drop/jfxpub-drag_drop.htm
  * https://docs.oracle.com/javafx/2/visual_effects/drop_shadow.htm
  * https://stackoverflow.com/questions/54844351/javafx-dropshadow-css-what-do-the-parameters-mean-how-to-implement-width-and-h
  * https://www.tutorialspoint.com/how-to-adjust-the-line-spacing-in-the-text-node-in-javafx
  * https://stackoverflow.com/questions/12816075/javafx-gridpane-how-to-center-elements
  * https://commons.wikimedia.org/wiki/File:Red_rectangle.svg
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/ImagePattern.html
  * https://stackoverflow.com/questions/70213773/javafx-show-image-on-top-of-a-rectangle
  * https://www.javatpoint.com/how-to-check-null-in-java
  * https://stackoverflow.com/questions/25642585/how-to-check-if-object-is-null-or-not-except-null
  * https://stackoverflow.com/questions/59338131/javafx-is-already-set-as-root-of-another-scene
  * https://www.w3schools.com/java/java_constructors.asp
  * https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html
  * https://stackoverflow.com/questions/6098472/pass-a-local-file-in-to-url-in-java
  * https://stackoverflow.com/questions/8324862/how-to-create-file-object-from-url-object-image
  * https://stackoverflow.com/questions/6164448/convert-url-to-normal-windows-filename-java
  * https://techndeck.com/how-to-convert-file-to-url-and-vice-versa-in-java/
  * https://docs.oracle.com/javase/7/docs/api/java/net/URL.html
  * https://docs.oracle.com/javase/7/docs/api/java/nio/file/Paths.html
  * https://docs.oracle.com/javase/7/docs/api/java/nio/file/Path.html
  * https://docs.oracle.com/javase/7/docs/api/java/net/URI.html
  * https://stackoverflow.com/questions/38539406/how-do-i-convert-google-fonts-ttf-file-to-other-file-to-types-to-support-all-th
  * https://stackoverflow.com/questions/22047457/how-to-change-the-text-font-size-in-javafx
  * https://stackoverflow.com/questions/2649073/fileinputstream-throws-nullpointerexception
  * https://www.quora.com/Is-it-possible-to-call-one-constructor-from-another-in-Java-if-so-how
  * https://stackoverflow.com/questions/16677650/javafx-remove-all-event-handlers-filters
  * https://colorcodes.io/brown/wood-brown-color-codes-2/
  * https://flaviocopes.com/rgb-color-codes/
  * https://encycolorpedia.com/f2eecb
  * https://stackoverflow.com/questions/24212583/javafx-resize-string-in-text-object
  * https://community.oracle.com/tech/developers/discussion/2405932/how-to-add-a-border-around-an-imageview
  * https://stackoverflow.com/questions/28253169/javafx-how-to-make-the-border-of-imageview-when-i-click-the-imageview
  * https://openjfx.io/javadoc/11/javafx.graphics/javafx/scene/text/Text.html
  * https://stackoverflow.com/questions/40826540/javafx-image-color-change
  * https://www.compart.com/en/unicode/U+FFFD
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/DialogPane.html
  * https://commons.wikimedia.org/wiki/File:ASCII-Table.svg
  * https://upload.wikimedia.org/wikipedia/commons/d/dd/ASCII-Table.svg
  * https://stackoverflow.com/questions/33060368/can-utf-8-string-contain-nulls-0x0-in-it
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html
  * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextInputControl.html
  * https://www.geeksforgeeks.org/javafx-textfield/
  * https://www.learningaboutelectronics.com/Articles/Prompt-text-in-JavaFX.php
  * https://stackoverflow.com/questions/34995410/prompt-text-in-text-field-javafx
  * https://stackoverflow.com/questions/36009764/how-to-align-ok-button-of-a-dialog-pane-in-javafx
  * http://www.java2s.com/example/java-src/pkg/javafx/scene/input/keycode-3b265.html
  * https://stackoverflow.com/questions/15991822/java-converting-keycode-to-string-or-char
  * https://stackoverflow.com/questions/54088768/how-to-set-text-to-a-label-on-keyboard-key-press-in-javafx-application
  * https://stackoverflow.com/questions/12219601/formatting-gridpane-to-have-different-background-color-in-one-row
  * https://stackoverflow.com/questions/22841000/how-to-change-the-color-of-pane-in-javafx
  * https://stackoverflow.com/questions/42332905/highlight-gridpane-column
  * https://stackoverflow.com/questions/22872484/javafx-how-can-i-display-emoji
  * https://stackoverflow.com/questions/2701192/what-characters-can-be-used-for-up-down-triangle-arrow-without-stem-for-displa
  * https://stackoverflow.com/questions/54734608/javafx-custom-ui-component-fadetransition-doesnt-working-correctly
  * https://support.techsmith.com/hc/en-us/community/posts/360071781652-Fade-transition-not-working
  * https://stackoverflow.com/questions/25601266/how-to-achieve-javafx-mouse-event-push-and-hold
  * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
  * https://stackoverflow.com/questions/388461/how-can-i-pad-a-string-in-java
  * https://www.geeksforgeeks.org/duration-tohourspart-method-in-java-with-examples/
  * https://www.onlinegdb.com/online_java_compilerhttps://rollbar.com/blog/how-to-fix-the-array-index-out-of-bounds-excepiton-in-java/#
  * https://www.plannedparenthood.org/learn/gender-identity/transgender/whats-transphobia
  * https://www.suicideinfo.ca/resource/transgender-people-suicide/
  * https://transequality.org/issues/employment
  * https://transequality.org/issues/housing-homelessness
  * https://www.plannedparenthood.org/learn/gender-identity/transgender/coming-out-trans 
  * https://www.healthline.com/health/transphobia
  * https://www.wallpaperup.com/648760/lonely_mood_sad_alone_sadness_emotion_people_loneliness_Solitude.html
  * https://www.dreamstime.com/teen-comforting-hes-sad-friend-night-sitting-couch-living-room-home-teen-comforting-hes-sad-friend-image118652864
  * https://www.istockphoto.com/photos/man-staring-at-his-own-reflection-in-mirror
  * https://www.wikihow.com/Stop-Bullying
  * https://www.ftd.com/blog/share/quotes-about-loss
  * https://stock.adobe.com/ca/search?k=friends+hugging+sad
  * https://www.gettyimages.ca/photos/homeless-youth
  * https://www.dreamstime.com/sadness-asian-girl-talking-mobile-phone-sadness-asian-girl-talking-mobile-phone-her-bed-image99956999
  * https://www.mygbhp.com/blog/how-loss-affects-teens/
  * https://docs.oracle.com/javase/7/docs/api/java/io/Reader.html
  * https://www.tutorialspoint.com/opencv-javafx-application-to-alter-the-sharpness-of-an-image
  * https://examples.javacodegeeks.com/desktop-java/awt/image/sharpening-a-buffered-image/
  * https://stackoverflow.com/questions/45419835/javafx-imagepane-resize-bad-quality
  * https://stackoverflow.com/questions/59525384/javafx-new-line-spacing-between-texts-in-textflow
  * https://stackoverflow.com/questions/5068951/what-do-lt-and-gt-stand-for
  * https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 */

public class MainApplication extends Application {
    /** This private non-static File variable will hold the logo for the game. */
    private File logoFile;

    /** This private non-static File variable will hold the intro border design for the game. */
    private File introBorderFile;

    /** This private non-static File variable will hold the grass tile that will be used in the game's grid. */
    private File grassTileFile;

    /** This private non-static File variable will hold the additional grass that will be added onto the grass tile that will be used in the game's grid. */
    private File additionalGrassTileFile;

    /** This private non-static File variable will hold the design for the grass and dirt block in the main menu. */
    private File grassAndDirtBlockFile;

    /** This private non-static File variable will hold the design for the non-pixelated character in the main menu. */
    //private File characterNonPixelatedFile;

    /** This private non-static integer will hold the number of the screen that is currently being rendered. */
    private int screenNum; // Check to see if this variable is useful or not.
    /*
      0 = intro animation
      1 = main menu
      2 = new game
      3 = instructions
      4 = leaderboard
      5 = quit game
    */


    /** This private non-static Scene variable will hold the scene for the introduction animation screen. */
    private Scene introAnimationScene;

    /** This private non-static Scene variable will hold the scene for the main menu screen. */
    private Scene mainMenuScene;

    /** This private non-static Scene variable will hold the scene for the instructions screen. */
    private Scene instructionsScene;

    /** This private non-static Scene variable will hold the scene for level 1 of the game screen. */
    private Scene level1Scene;

    /** This private non-static File variable will hold the water tile that will be used in the game's grid. */
    private File waterTileFile;

    /** This private non-static File variable will hold the sand tile that will be used in the game's grid. */
    private File sandTileFile;

    /** This private non-static File variable will hold the book image that will be on the tiles that will be used in the game's grid. */
    private File bookTileFile;

    /** This private non-static integer variable will hold the number of the grid that the player is currently in. */
    private int gridNum;

    /** This private non-static BookScene[] variable will be used to hold onto the books that are being used in the game (one element for each book). */
    private BookScene[] books;

    /** This private non-static boolean variable will be used to hold onto whether or not the game is showing a book or not. */
    private boolean showingBook;

    /** This private non-static integer variable will be used to keep track of the number of books the player has found. */
    private int bookNum;

    /** This private non-static File variable will hold onto the location of the Press Start 2P file. */
    private File pressStart2PFile;
    
    /** This private non-static Scene variable will hold the scene for the leaderboard of the game. */
    private Scene leaderboardScene;

    /** This private non-static File variable will hold onto the location of the first confrontation character file. */
    //private File level1Confrontation;

    /** This private non-static Scene variable will hold the scene for screen when the player quits the game. */
    private Scene quitGameScene;
    
    /** This private non-static File variable will hold onto the location of the main character image file. */
    private File mainCharFile;
    
    /** This private non-static String variable will hold onto the direction of the main character during grid movement. */
    private String direction;
    
    /** This private non-static File variable will hold onto the location of the cafeteria wall file. */
    private File cafWallFile;
    
    /** This private non-static File variable will hold onto the location of the left door file. */
    private File doorLeftFile;
    
    /** This private non-static File variable will hold onto the location of the right door file. */
    private File doorRightFile;
    
    /** This private non-static File array variable will hold onto the location of the cafeteria floor files. */
    private File cafFloorFiles[];

    /** This private non-static Scene variable will hold the scene for level 2 of the game screen. */
    private Scene level2Scene;
    
    /** This private non-static Scene variable will hold the scene for level 3 of the game screen. */
    private Scene level3Scene;
    
    /** This private non-static int variable will hold onto the health of the main character during confrontations. */
    private int health;
    
    /** This private non-static int variable will hold onto the health of the enemy character during confrontations. */
    private int enemyHealth;
    
    /** This private non-static String variable will hold onto the screen that is showing during confrontations. */
    private String battleMenu;
    
    /** This private non-static String variable will hold onto the form of the main character during confrontations. */
    private String form;
    
    /** This private non-static int variable will hold onto the block of the main character during confrontations. */
    private int block;
    
    /** This private non-static File variable will hold onto the location of the blank image file. */
    private File blankFile;
    
    /** This private non-static File array variable will hold onto the location of the files for the characters of the confrontation. */
    private File[] confrontationChar;
    
    /** This private non-static Scene variable will hold the scene for text before the first confrontation of the game. */
    private Scene confrontationTextScene1;
    
    /** This private non-static Scene variable will hold the scene for text before the second confrontation of the game. */
    private Scene confrontationTextScene2;
    
    /** This private non-static Scene variable will hold the scene for text before the third confrontation of the game. */
    private Scene confrontationTextScene3;
    
    /** This private non-static Scene variable will hold the scene for text before the fourth confrontation of the game. */
    private Scene confrontationTextScene4;
    
    /** This private non-static Scene variable will hold the scene for text before the fifth confrontation of the game. */
    private Scene confrontationTextScene5;
    
    /** This private non-static Scene variable will hold the scene for the first confrontation of the game. */
    private Scene confrontationBattleScene1;
    
    /** This private non-static Scene variable will hold the scene for the second confrontation of the game. */
    private Scene confrontationBattleScene2;
    
    /** This private non-static Scene variable will hold the scene for the third confrontation of the game. */
    private Scene confrontationBattleScene3;
    
    /** This private non-static Scene variable will hold the scene for the fourth confrontation of the game. */
    private Scene confrontationBattleScene4;
    
    /** This private non-static Scene variable will hold the scene for the fifth confrontation of the game. */
    private Scene confrontationBattleScene5;
    
    /** This private non-static int variable will hold the number of confrontations the player has played. */
    private int confrontations;
    
    /** This private non-static Group variable will hold the Group for the second level the game. */
    private Group level2Group;
    
    /** This private non-static Group variable will hold the Group for the third level the game. */
    private Group level3Group;
    
    /** This private non-static File variable will hold the file for the upper part of the image for the father. */
    private File fatherUpperFile;
    
    /** This private non-static File variable will hold the file for the lower part of the image for the father. */
    private File fatherLowerFile;
    
    /** This private non-static File variable will hold the file for the upper part of the image for the mother. */
    private File motherUpperFile;
    
    /** This private non-static File variable will hold the file for the lower part of the image for the mother. */
    private File motherLowerFile;
    
    /** This private non-static File variable will hold the file for the the image of the floors of the house in level 3. */
    private File houseFloorFile;
    
    /** This private non-static File variable will hold the file for the the image of the walls of the house in level 3. */
    private File houseWallFile;
    
    /** This private non-static String variable will keep track of what screen the text before the confrontations are on. */
    private String questionMenu;
    
    /** This private non-static Scene variable will hold the scene for the win scene of the game. */
    private Scene winScene;
    
    /** This private non-static Scene variable will hold the scene for the lose scene of the game. */
    private Scene loseScene;
    
    /** This private non-static int variable will hold the score throughout the game. */
    private int score;
    
    /** This private non-static Scene variable will hold the scene for the text after the second confrontation of the game. */
    private Scene confrontationAfterTextScene2;
    
    /** This private non-static Scene variable will hold the scene for the text after the third confrontation of the game. */
    private Scene confrontationAfterTextScene3;
    
    /** This private non-static Scene variable will hold the scene for the text after the fourth confrontation of the game. */
    private Scene confrontationAfterTextScene4;
    
    /** This private non-static Scene variable will hold the scene for the text after the fifth confrontation of the game. */
    private Scene confrontationAfterTextScene5;
    
    /** This private non-static variable is an instance of the String.java class and it will hold the username of the current user. */
    private String userName;
    
    /** This private non-static variable is an instance of the LocalDateTime.java class and it will hold the time when the user started playing the game. */
    private LocalDateTime startTime;
    
    /** This private non-static variable is an instance of the LocalDateTime.java class and it will hold the time when the user stopped playing the game. */
    //private LocalDateTime endTime;
    
    /** This private non-static variable is an instance of the Leaderboard.java class and it will hold the leaderboard for this game. */
    private Leaderboard leaderboard;
    
    /** This private non-static variable is an instance of the Scene.java class and it will hold the scene for the write up screen. */
    private Scene writeUpScene;
    
    /** This private non-static variable is an instance of the GridPane.java class and it will hold the grid pane that shows the leaderboard values. */
    private GridPane leaderboardValuesToAdd;
    
    /** This private non-static File variable will hold the file for the upper part of the image for the first confrontation. */
    private File confrontation1UpperFile;
    
    /** This private non-static File variable will hold the file for the lower part of the image for the first confrontation. */
    private File confrontation1LowerFile;
    
    /** This private non-static File variable will hold the file for the upper part of the image for the third confrontation. */
    private File confrontation3UpperFile;
    
    /** This private non-static File variable will hold the file for the lower part of the image for the third confrontation. */
    private File confrontation3LowerFile;
    
    /** This private non-static File variable will hold the file for the upper part of the image for the fourth confrontation. */
    private File confrontation4UpperFile;
    
    /** This private non-static File variable will hold the file for the lower part of the image for the fourth confrontation. */
    private File confrontation4LowerFile;
    
    /** This private non-static 2 dimentional File array variable will hold the files for the table in level 3. */
    private File[][] tableFile;
    
    /** This private non-static 2 dimentional File array variable will hold the files for the trees in level 1. */
    private File[][] treeFile;
    
    /** This private non-static File array variable will hold the files for the benches in level 2. */
    private File[] benchFile;
    
    private boolean onPauseScreen;
    
    /**
     * An instance of the MainApplication.java class will be created using this no parameter constructor.
     */
    public MainApplication() {
        this.logoFile = new File("ICS ISP - Single Star Games Logo.png");
        this.introBorderFile = new File("ICS ISP - Border for Intro Screens.png");
        this.grassTileFile = new File("Grass.png");
        this.waterTileFile = new File("Water.png");
        this.sandTileFile = new File("Sand.png");
        this.bookTileFile = new File("Book.png");
        this.additionalGrassTileFile = new File("AdditionalGrass.png");
        this.grassAndDirtBlockFile = new File("ICS ISP - Design for Grass and Dirt Block.png");
        //this.characterNonPixelatedFile = new File("ICS ISP - Design for Character (Non-pixelated).png");
        //this.level1Confrontation = new File("Confrontation1.png");
        
        this.mainCharFile = new File("MainChar.png");
        this.cafWallFile = new File("CafWall.png");
        this.doorLeftFile = new File("DoorLeft.png");
        this.doorRightFile = new File("DoorRight.png");
        this.blankFile = new File("Blank.png");
        this.fatherUpperFile = new File("FatherUpper.png");
        this.fatherLowerFile = new File("FatherLower.png");
        this.motherUpperFile = new File("MotherUpper.png");
        this.motherLowerFile = new File("MotherLower.png");
        this.houseFloorFile = new File("HouseFloor.png");
        this.houseWallFile = new File("HouseWall.png");
        this.confrontation1UpperFile = new File("Confrontation1Upper.png");
        this.confrontation1LowerFile = new File("Confrontation1Lower.png");
        this.confrontation3UpperFile = new File("Confrontation3Upper.png");
        this.confrontation3LowerFile = new File("Confrontation3Lower.png");
        this.confrontation4UpperFile = new File("Confrontation4Upper.png");
        this.confrontation4LowerFile = new File("Confrontation4Lower.png");
        
        this.cafFloorFiles = new File[2];
        this.cafFloorFiles[0] = new File("cafFloor1.png");
        this.cafFloorFiles[1] = new File("cafFloor2.png");
        
        this.books = new BookScene[9];
        this.pressStart2PFile = new File("PressStart2P-Regular.ttf");
        this.screenNum = 0;
        
        this.confrontationChar = new File[5];
        this.confrontationChar[0] = new File("Confrontation1.png");
        this.confrontationChar[1] = new File("Confrontation2.png");
        this.confrontationChar[2] = new File("Confrontation3.png");
        this.confrontationChar[3] = new File("Confrontation4.png");
        this.confrontationChar[4] = new File("Confrontation5.png");
        
        this.tableFile = new File[2][3];
        this.tableFile[0][0] = new File("TableLeftTop.png");
        this.tableFile[1][0] = new File("TableLeftBottom.png");
        this.tableFile[0][1] = new File("TableMidTop.png");
        this.tableFile[1][1] = new File("TableMidBottom.png");
        this.tableFile[0][2] = new File("TableRightTop.png");
        this.tableFile[1][2] = new File("TableRightBottom.png");
        
        this.treeFile = new File[3][2];
        this.treeFile[0][0] = new File("TreeLeftTop.png");
        this.treeFile[1][0] = new File("TreeLeftMid.png");
        this.treeFile[2][0] = new File("TreeLeftBot.png");
        this.treeFile[0][1] = new File("TreeRightTop.png");
        this.treeFile[1][1] = new File("TreeRightMid.png");
        this.treeFile[2][1] = new File("TreeRightBot.png");
        
        this.benchFile = new File[3];
        this.benchFile[0] = new File("BenchLeft.png");
        this.benchFile[1] = new File("BenchMid.png");
        this.benchFile[2] = new File("BenchRight.png");
        this.onPauseScreen = false;
        
        /*
        this.books = new File[8];
        this.pressStart2PFile = new File("PressStart2P-Regular.ttf");
        this.books[0] = new File("Book1.png");
        this.screenNum = 0;
        
        this.confrontationChar = new File[5];
        
        //this.confrontationChar[0] = new File("Level1Confrontation.png");
        //this.confrontationChar[1] = new File("Confrontation2.png");
        //this.confrontationChar[2] = new File("Confrontation3.png");
        //this.confrontationChar[3] = new File("Confrontation4.png");
        //this.confrontationChar[4] = new File("Level1Confrontation.png");
        
        this.confrontationChar[0] = new File("Level1Confrontation.png");
        this.confrontationChar[1] = new File("Level1Confrontation.png");
        this.confrontationChar[2] = new File("Level1Confrontation.png");
        this.confrontationChar[3] = new File("Level1Confrontation.png");
        this.confrontationChar[4] = new File("Level1Confrontation.png");
        */
        
        this.leaderboard = new Leaderboard(new File("Leaderboard.txt"));
        this.leaderboard.setFontFile(this.pressStart2PFile);
    }

    /**
     * Public non-static method used to initialize the settings of the stage for the GUI.
     * <p>
     * This public non-static method is void and it will be used to initialize
     * the settings of the stage that will be used in the GUI for the program.
     * It will set its title to "Trans-form: The Awakening", it will set the
     * surrounding border of the stage to a decorated style (using one of the
     * static variables in the StageStyle.java class), and it will set this
     * stage to have its own icon, not be resizable by the user, and to be
     * at the front of all the current windows.
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @throws IOException
     */
    public void initializeStageSettings(Stage stage) throws IOException {
        stage.setTitle("Trans-form: The Awakening");
        stage.initStyle(StageStyle.DECORATED); // <-------------------------------------------------------------------------------------------------------------------------------- set this to StageStyle.TRANSPARENT later on
        Image logoImage = new Image(logoFile.getPath());
        stage.getIcons().add(logoImage);
        stage.setResizable(false);
        stage.toFront();
    }

    /**
     * Public non-static method used to create the intro animation for the game.
     * <p>
     * This public non-static method is void and it will be used to create the
     * introduction animation for the program. It will use the ImageView.java
     * class to create a Node that holds the image of the logo and can add it
     * to the scene. The method will also use an instance of the FadeTransition
     * class to help create the fading effect that is seen at the start of the
     * game. A nested class will be used to wait for the animation to finish
     * and then call on the mainMenu() method to display the menu for the game.
     * <p>
     * Done by: Joshua
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the introduction animation.
     * @throws IOException
     */
    public Scene introAnimation(Stage stage) throws IOException {
        screenNum = 0;

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(100);
        logoImageView.setY(100);
        logoImageView.setFitWidth(400);
        
        FadeTransition tempFTLogo = new FadeTransition(Duration.millis(1), logoImageView); // <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- set this to 5000 for 5 seconds later on
        tempFTLogo.setFromValue(1.0);
        tempFTLogo.setToValue(0.0);
        tempFTLogo.setByValue(0.1);
        tempFTLogo.play();
        
        tempFTLogo.onFinishedProperty().set(
            new EventHandler <ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    FadeTransition ftLogo = new FadeTransition(Duration.millis(1), logoImageView); // <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- set this to 5000 for 5 seconds later on
                    ftLogo.setFromValue(0.0);
                    ftLogo.setToValue(1.0);
                    ftLogo.setByValue(0.1);
                    ftLogo.play();
            
                    // Taken from https://stackoverflow.com/questions/11188018/how-to-wait-for-a-transition-to-end-in-javafx-2-1
                    ftLogo.onFinishedProperty().set(
                        new EventHandler < ActionEvent > () {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                TranslateTransition ttLogo = new TranslateTransition(Duration.millis(1), logoImageView);
                                ttLogo.setByX(1.0);
                                ttLogo.setFromX(0);
                                ttLogo.setToX(0);
                                ttLogo.setFromY(0);
                                ttLogo.setToY(-150);
                                //ttLogo.play();
                                
                                ScaleTransition scLogo = new ScaleTransition(Duration.millis(1), logoImageView);
                                scLogo.setFromX(1);
                                scLogo.setToX(0.5);
                                scLogo.setByX(0.5);
                                scLogo.setFromY(1);
                                scLogo.setToY(0.5);
                                scLogo.setByY(0.5);
                                
                                ParallelTransition ptLogo = new ParallelTransition(ttLogo, scLogo);
                                ptLogo.setCycleCount(1);
                                ptLogo.play();
                                
                                ptLogo.onFinishedProperty().set(
                                    new EventHandler < ActionEvent > () {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {                                
                                            Rectangle background = new Rectangle(600, 600, Paint.valueOf("rgb(0,0,0)"));
                                            
                                            Text instructionsText = new Text("Please enter your username:");
                                            instructionsText.setFont(getPressStart2PFont(15));
                                            instructionsText.setFill(Paint.valueOf("rgb(255,255,255)"));
                                            instructionsText.setX(100);
                                            instructionsText.setY(325);
                                            
                                            Text sideNoteText = new Text("Max username length: 8\n\nHere are the blacklisted characters: ,");
                                            sideNoteText.setFont(getPressStart2PFont(12));
                                            sideNoteText.setFill(Paint.valueOf("rgb(255,255,255)"));
                                            //sideNoteText.setX(375);
                                            //sideNoteText.setY(450);
                                            
                                            TextFlow tempTextFlowSideNote = new TextFlow();
                                            tempTextFlowSideNote.getChildren().addAll(
                                                sideNoteText
                                            );
                                            tempTextFlowSideNote.setTranslateX(100);
                                            tempTextFlowSideNote.setTranslateY(425);
                                            tempTextFlowSideNote.setPrefWidth(400);
                                            tempTextFlowSideNote.setLineSpacing(5);
                                            
                                            //Leaderboard test = new Leaderboard(new File("Leaderboard.txt"));
                                            //System.out.println(Arrays.deepToString(test.getLeaderboard()));
                                            
                                            //Rectangle inputBox = new 
                                            
                                            TextField testTF = new TextField();
                                            testTF.setFont(getPressStart2PFont(18));
                                            testTF.setPromptText("Username");
                                            testTF.setFocusTraversable(false);
                                            testTF.setTranslateX(100);
                                            testTF.setTranslateY(350);
                                            testTF.setPrefWidth(400);
                                            testTF.setPrefHeight(50);
                                            //Rectangle backgroundRectangle = new Rectangle(500, 50, Paint.valueOf("rgb(255,255,255)"));
                                            //backgroundRectangle.setStroke(Paint.valueOf("rgb(255,0,0)"));
                                            //backgroundRectangle.setStrokeWidth(3.0);
                                            //testTF.setShape(backgroundRectangle);
                                            
                                            //Group nodesToAdd = new Group();
                                            //nodesToAdd.getChildren().addAll(
                                            //    
                                            //);
                                            
                                            //Scene scene = new Scene(nodesToAdd, 600, 600);
                                            //stage.setScene(scene);
                                            //stage.show();
                                            
                                            testTF.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent actionEvent) {
                                                    String buttonText = testTF.getText();
                                                    if (!buttonText.isEmpty() && !buttonText.contains(",") && buttonText.length() <= 8) {
                                                        userName = buttonText;
                                                        screenNum = 1;
                                                        stage.setScene(mainMenuScene);
                                                        stage.show();
                                                    }
                                                }
                                            });
                                            
                                            Group nodesToAdd = new Group();
                                            nodesToAdd.getChildren().addAll(
                                                background,
                                                instructionsText,
                                                tempTextFlowSideNote,
                                                testTF,
                                                logoImageView,
                                                getIntroBorderImageView()
                                            );
                                            
                                            Scene scene = new Scene(nodesToAdd, 600, 600);
                                            stage.setScene(scene);
                                            stage.show();
                                        }
                                    }
                                );
                            }
                        }
                    );
                }
            }
        );

        

        ImageView introBorderImageView = this.getIntroBorderImageView();

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            logoImageView,
            introBorderImageView
        );

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.setFill(Color.BLACK);

        return scene;
    }
    
    /**
     * Public non-static method used to create the main menu for the game.
     * <p>
     * This public non-static method is void and it will be used to create the
     * main menu for the program, which will allow the user to choose the
     * direction that they would like to go in the program. This will be done
     * by using various instances of the ImageView.java class to create Nodes
     * of certain images that can be added to the scene to make it more lovely
     * to look at. There will also be instances of  various classes from the
     * javafx.scene.shape package that will be added to the scene to create the
     * correct design. There are also pieces of code that are triggered by events
     * from the user's input and will act accordingly.
     * <p>
     * Done by: Joshua
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the main menu.
     * @throws IOException
     */
    public Scene mainMenu(Stage stage) throws IOException {
        screenNum = 1;
        this.startTime = LocalDateTime.now();
        this.health = 100;
        this.score = 0;

        ImageView introBorderImageView = this.getIntroBorderImageView();

        Rectangle blackRectangleUnderOptions = new Rectangle(10, 10, 200, 580);
        blackRectangleUnderOptions.setFill(Paint.valueOf("rgb(0,0,0)"));

        Rectangle greyRectangleUnderTitle = new Rectangle(10, 50, 200, 75);
        greyRectangleUnderTitle.setFill(Paint.valueOf("rgb(96,96,96)"));

        GameTitle whiteTitleGameTitle = new GameTitle(this.pressStart2PFile, "Trans-form:", "The Awakening", 30, 56, 14);	
        whiteTitleGameTitle.setWidth(160);	
        whiteTitleGameTitle.setSpacing(10);	
        whiteTitleGameTitle.getUnderlineRectangle().setTranslateY(-13);
        //System.out.println(Region.USE_COMPUTED_SIZE);

        GameButton newGameGameButton = new GameButton(this.pressStart2PFile, "New Game", 30, 205, 17);

        GameButton instructionsGameButton = new GameButton(this.pressStart2PFile, "Instructions", 30, 275, 12);	
        instructionsGameButton.setTextTranslationY(2);
        
        GameButton writeUpGameButton = new GameButton(this.pressStart2PFile, "Write Up", 30, 345, 16);	
        writeUpGameButton.setTextTranslationY(2);	

        GameButton leaderboardGameButton = new GameButton(this.pressStart2PFile, "Leaderboard", 30, 415, 13);	
        leaderboardGameButton.setTextTranslationY(2);

        GameButton quitGameGameButton = new GameButton(this.pressStart2PFile, "Quit Game", 30, 485, 12);
        quitGameGameButton.setWidth(125);	
        quitGameGameButton.setHeight(40);
        
        Text copyrightStatementText = new Text(0, 0, "© 2022 Single Star Games");
        copyrightStatementText.setFont(this.getPressStart2PFont(6.5));
        copyrightStatementText.setFill(Paint.valueOf("white"));

        TextFlow copyrightStatementTextFlow = new TextFlow();
        copyrightStatementTextFlow.getChildren().addAll(
            copyrightStatementText
        );
        copyrightStatementTextFlow.setTranslateX(30);
        copyrightStatementTextFlow.setTranslateY(560);
        copyrightStatementTextFlow.setPrefWidth(160);
        copyrightStatementTextFlow.setPrefHeight(30);


        Group grassAndDirtBlocksGroup = new Group();
        for (int i = 0; i < 5; i++) {
            ImageView grassAndDirtBlockImageView = new ImageView(new Image(grassAndDirtBlockFile.getPath()));
            grassAndDirtBlockImageView.setPreserveRatio(true);
            grassAndDirtBlockImageView.setSmooth(true);
            grassAndDirtBlockImageView.setX(210 + i * 100);
            grassAndDirtBlockImageView.setY(535);
            grassAndDirtBlockImageView.setFitWidth(100);
            grassAndDirtBlocksGroup.getChildren().add(grassAndDirtBlockImageView);
        }

        ImageView mainCharacterImageView = new ImageView(new Image(mainCharFile.getPath()));
        mainCharacterImageView.setPreserveRatio(true);
        mainCharacterImageView.setSmooth(true);
        mainCharacterImageView.setX(230);
        mainCharacterImageView.setY(355);
        mainCharacterImageView.setFitWidth(140);

        Circle yellowCircleForSun = new Circle(600, 0, 100, Paint.valueOf("rgb(255,255,0)"));
        yellowCircleForSun.setStroke(Paint.valueOf("rgb(0,0,0)"));
        //System.out.println(yellowCircleForSun);

        Cloud cloudCloud = new Cloud(0.0, 0.0);
        Shape cloudShapeTop = cloudCloud.getShape();
        cloudShapeTop.setStroke(Paint.valueOf("rgb(0,0,0)"));

        Shape cloudShapeMiddle = cloudCloud.getShape();
        cloudShapeMiddle.setStroke(Paint.valueOf("rgb(0,0,0)"));

        Shape cloudShapeBottom = cloudCloud.getShape();
        cloudShapeBottom.setStroke(Paint.valueOf("rgb(0,0,0)"));

        TranslateTransition ttCloudTop = new TranslateTransition(Duration.millis(7000), cloudShapeTop);
        ttCloudTop.setByX(1.0);
        ttCloudTop.setFromX(700.0);
        ttCloudTop.setToX(0.0);
        ttCloudTop.setFromY(225.0);
        ttCloudTop.setToY(225.0);

        TranslateTransition ttCloudMiddle = new TranslateTransition(Duration.millis(16000), cloudShapeMiddle);
        ttCloudMiddle.setByX(1.0);
        ttCloudMiddle.setFromX(1600.0);
        ttCloudMiddle.setToX(0.0);
        ttCloudMiddle.setFromY(350.0);
        ttCloudMiddle.setToY(350.0);

        TranslateTransition ttCloudBottom = new TranslateTransition(Duration.millis(25000), cloudShapeBottom);
        ttCloudBottom.setByX(1.0);
        ttCloudBottom.setFromX(2500.0);
        ttCloudBottom.setToX(0.0);
        ttCloudBottom.setFromY(100.0);
        ttCloudBottom.setToY(100.0);

        ParallelTransition ptClouds = new ParallelTransition(ttCloudTop, ttCloudMiddle, ttCloudBottom);
        ptClouds.setCycleCount(Animation.INDEFINITE);
        ptClouds.play();

        /*
        // This code will be used in the case that the code for the events take too long to run and start to make the game feel unresponsive and laggy.
        Service<Void> service = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {           
                    @Override
                    protected Void call() throws Exception {
                        stage.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
                            final double xVal = e.getX();
                            final double yVal = e.getY();
                        
                            System.out.println(xVal + " " + yVal);
                        
                        });               
                        final CountDownLatch latch = new CountDownLatch(1);
                        Platform.runLater(new Runnable() {                          
                            @Override
                            public void run() {
                                  try{
                                      // Nothing for now
                                }finally{
                                    latch.countDown();
                                }
                            }
                        });
                        latch.await();                      
                        stage.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
                            final double xVal = e.getX();
                            final double yVal = e.getY();
                        
                            System.out.println(xVal + " " + yVal);
                        
                        }); 
                        return null;
                    }
                };
            }
        };
        service.start();
        */

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            yellowCircleForSun,
            cloudShapeTop,
            cloudShapeMiddle,
            cloudShapeBottom,
            blackRectangleUnderOptions,
            greyRectangleUnderTitle,
            whiteTitleGameTitle.getTitle(),
            newGameGameButton.getButton(),
            instructionsGameButton.getButton(),
            writeUpGameButton.getButton(),
            leaderboardGameButton.getButton(),
            quitGameGameButton.getButton(),
            copyrightStatementTextFlow,
            grassAndDirtBlocksGroup,
            mainCharacterImageView,
            introBorderImageView
        );

        Scene scene = new Scene(nodesToAdd, 600, 600);

        // Keep these two split or else the cursor will not work as expected
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= newGameGameButton.getLeftX() && xVal <= newGameGameButton.getRightX() && yVal >= newGameGameButton.getTopY() && yVal <= newGameGameButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= instructionsGameButton.getLeftX() && xVal <= instructionsGameButton.getRightX() && yVal >= instructionsGameButton.getTopY() && yVal <= instructionsGameButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= writeUpGameButton.getLeftX() && xVal <= writeUpGameButton.getRightX() && yVal >= writeUpGameButton.getTopY() && yVal <= writeUpGameButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= leaderboardGameButton.getLeftX() && xVal <= leaderboardGameButton.getRightX() && yVal >= leaderboardGameButton.getTopY() && yVal <= leaderboardGameButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= quitGameGameButton.getLeftX() && xVal <= quitGameGameButton.getRightX() && yVal >= quitGameGameButton.getTopY() && yVal <= quitGameGameButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else {
                    scene.setCursor(Cursor.DEFAULT);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= newGameGameButton.getLeftX() && xVal <= newGameGameButton.getRightX() && yVal >= newGameGameButton.getTopY() && yVal <= newGameGameButton.getBottomY()) {
                    newGameGameButton.cursorOverButton();
                    //redRectangleAroundNewGameButton.setVisible(true);
                } else {
                    newGameGameButton.cursorNotOverButton();
                    //redRectangleAroundNewGameButton.setVisible(false);
                }

                if (xVal >= instructionsGameButton.getLeftX() && xVal <= instructionsGameButton.getRightX() && yVal >= instructionsGameButton.getTopY() && yVal <= instructionsGameButton.getBottomY()) {
                    instructionsGameButton.cursorOverButton();
                    //redRectangleAroundInstructionsButton.setVisible(true);
                } else {
                    instructionsGameButton.cursorNotOverButton();
                    //redRectangleAroundInstructionsButton.setVisible(false);
                }
                
                if (xVal >= writeUpGameButton.getLeftX() && xVal <= writeUpGameButton.getRightX() && yVal >= writeUpGameButton.getTopY() && yVal <= writeUpGameButton.getBottomY()) {
                    writeUpGameButton.cursorOverButton();
                    //redRectangleAroundInstructionsButton.setVisible(true);
                } else {
                    writeUpGameButton.cursorNotOverButton();
                    //redRectangleAroundInstructionsButton.setVisible(false);
                }

                if (xVal >= leaderboardGameButton.getLeftX() && xVal <= leaderboardGameButton.getRightX() && yVal >= leaderboardGameButton.getTopY() && yVal <= leaderboardGameButton.getBottomY()) {
                    leaderboardGameButton.cursorOverButton();
                    //redRectangleAroundLeaderboardButton.setVisible(true);
                } else {
                    leaderboardGameButton.cursorNotOverButton();
                    //redRectangleAroundLeaderboardButton.setVisible(false);
                }

                if (xVal >= quitGameGameButton.getLeftX() && xVal <= quitGameGameButton.getRightX() && yVal >= quitGameGameButton.getTopY() && yVal <= quitGameGameButton.getBottomY()) {
                    quitGameGameButton.cursorOverButton();
                    //redRectangleAroundQuitGameButton.setVisible(true);
                } else {
                    quitGameGameButton.cursorNotOverButton();
                    //redRectangleAroundQuitGameButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= newGameGameButton.getLeftX() && xVal <= newGameGameButton.getRightX() && yVal >= newGameGameButton.getTopY() && yVal <= newGameGameButton.getBottomY()) {
                    screenNum = 2;
                    try {
                        this.level1Scene = this.level1(stage);
                        this.level2Scene = this.level2(stage);
                        this.level3Scene = this.level3(stage);
                        this.confrontationTextScene1 = this.confrontation1Text(stage);
                        this.confrontationTextScene5 = this.confrontation5Text(stage);
                        this.confrontationBattleScene1 = this.confrontationBattle(stage,1);
                        this.confrontationBattleScene5 = this.confrontationBattle(stage,5);
                    } catch (IOException ioe) {}
                    stage.setScene(this.level1Scene);
                    stage.show();
                } else if (xVal >= instructionsGameButton.getLeftX() && xVal <= instructionsGameButton.getRightX() && yVal >= instructionsGameButton.getTopY() && yVal <= instructionsGameButton.getBottomY()) {
                    screenNum = 3;
                    stage.setScene(this.instructionsScene);
                    stage.show();
                } else if (xVal >= writeUpGameButton.getLeftX() && xVal <= writeUpGameButton.getRightX() && yVal >= writeUpGameButton.getTopY() && yVal <= writeUpGameButton.getBottomY()) {
                    screenNum = 4;
                    stage.setScene(this.writeUpScene);
                    stage.show();
                } else if (xVal >= leaderboardGameButton.getLeftX() && xVal <= leaderboardGameButton.getRightX() && yVal >= leaderboardGameButton.getTopY() && yVal <= leaderboardGameButton.getBottomY()) {
                    screenNum = 5;
                    stage.setScene(this.leaderboardScene);
                    stage.show();
                } else if (xVal >= quitGameGameButton.getLeftX() && xVal <= quitGameGameButton.getRightX() && yVal >= quitGameGameButton.getTopY() && yVal <= quitGameGameButton.getBottomY()) {
                    screenNum = 6;
                    stage.setScene(this.quitGameScene);
                    stage.show();
                }
            }
        );

        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }
    
    /**
     * Public non-static method used to create the first level for the actual game.
     * <p>
     * This public non-static method will be used to create the first level of the
     * program and return it as a scene. It will do this by creating 4 instances of the
     * Grid.java class to simulate the grid and it also has an action listener
     * for moving, and interaction with books. It draws this on a scene that it
     * returns with the draw method in the Grid instance and a photo at the location
     * of the mainX and mainY coordinates of the Grid instance.
     * <p>
     * Done by: Simon
     * Simon Bakan May 23-27 spent 5 hours: completely re-did grid instantiation,
     * added books, added interaction with books, added label for number of books
     * collected, and added multiple grids. 
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show level 1 of the game.
     * @throws IOException
     */
    public Scene level1(Stage stage) throws IOException {
        screenNum = 2;
        Grid[] grid = {
            new Grid(15, 15),
            new Grid(15, 15),
            new Grid(15, 15),
            new Grid(15, 15)
        };
        Scene scene;
        showingBook = false;

        // Top left grid
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 20; j++) {
                grid[0].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int i = 2; i < 20; i++) {
            for (int j = 0; j < 2; j++) {
                grid[0].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int j = 2; j < 20; j++) {
            int i = 2;
            grid[0].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 3; i < 20; i++) {
            int j = 2;
            grid[0].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 3; i < 20; i++) {
            for (int j = 3; j < 20; j++) {
                grid[0].assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), true, false);
            }
        }
        grid[0].setObject(17, 13, bookTileFile.getPath());
        grid[0].setInteractable(17, 13, true);
        grid[0].setMovable(17, 13, false);
        grid[0].setObject(5, 10, bookTileFile.getPath());
        grid[0].setInteractable(5, 10, true);
        grid[0].setMovable(5, 10, false);
        for(int k=3;k<7;k+=3){
            for(int h=15;h<18;h+=2){
                for (int i=0;i<treeFile.length;i++){
                    for (int x=0; x<treeFile[0].length;x++){
                        grid[0].setObject(k+i, h+x, treeFile[i][x].getPath());
                        grid[0].setInteractable(k+i, h+x, false);
                        grid[0].setMovable(k+i, h+x, false);
                    }
                }
            }
        }

        // Top right grid
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 20; j++) {
                grid[1].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int i = 2; i < 20; i++) {
            for (int j = 18; j < 20; j++) {
                grid[1].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int j = 0; j < 18; j++) {
            int i = 2;
            grid[1].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 3; i < 20; i++) {
            int j = 17;
            grid[1].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 3; i < 20; i++) {
            for (int j = 0; j < 17; j++) {
                grid[1].assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), true, false);
            }
        }
        grid[1].setObject(8, 13, bookTileFile.getPath());
        grid[1].setInteractable(8, 13, true);
        grid[1].setMovable(8, 13, false);
        grid[1].setObject(15, 7, bookTileFile.getPath());
        grid[1].setInteractable(15, 7, true);
        grid[1].setMovable(15, 7, false);
        
        for(int k=3;k<16;k+=3){
            for(int h=2;h<5;h+=2){
                for (int i=0;i<treeFile.length;i++){
                    for (int x=0; x<treeFile[0].length;x++){
                        grid[1].setObject(k+i, h+x, treeFile[i][x].getPath());
                        grid[1].setInteractable(k+i, h+x, false);
                        grid[1].setMovable(k+i, h+x, false);
                    }
                }
            }
        }


        // Bottom left grid
        for (int i = 18; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                grid[2].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 2; j++) {
                grid[2].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int j = 2; j < 20; j++) {
            int i = 17;
            grid[2].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 0; i < 17; i++) {
            int j = 2;
            grid[2].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 0; i < 17; i++) {
            for (int j = 3; j < 20; j++) {
                grid[2].assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), true, false);
            }
        }
        grid[2].setObject(3, 17, bookTileFile.getPath());
        grid[2].setInteractable(3, 17, true);
        grid[2].setMovable(3, 17, false);
        grid[2].setObject(10, 10, bookTileFile.getPath());
        grid[2].setInteractable(10, 10, true);
        grid[2].setMovable(10, 10, false);

        for(int k=6;k<13;k+=3){
            for(int h=11;h<12;h+=2){
                for (int i=0;i<treeFile.length;i++){
                    for (int x=0; x<treeFile[0].length;x++){
                        grid[2].setObject(k+i, h+x, treeFile[i][x].getPath());
                        grid[2].setInteractable(k+i, h+x, false);
                        grid[2].setMovable(k+i, h+x, false);
                    }
                }
            }
        }
        for(int k=6;k<13;k+=6){
            for(int h=7;h<11;h+=2){
                for (int i=0;i<treeFile.length;i++){
                    for (int x=0; x<treeFile[0].length;x++){
                        grid[2].setObject(k+i, h+x, treeFile[i][x].getPath());
                        grid[2].setInteractable(k+i, h+x, false);
                        grid[2].setMovable(k+i, h+x, false);
                    }
                }
            }
        }

        // Bottom right grid
        for (int i = 18; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                grid[3].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int i = 0; i < 18; i++) {
            for (int j = 18; j < 20; j++) {
                grid[3].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int j = 0; j < 18; j++) {
            int i = 17;
            grid[3].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 0; i < 17; i++) {
            int j = 17;
            grid[3].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                grid[3].assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), true, false);
            }
        }
        grid[3].setObject(3, 12, bookTileFile.getPath());
        grid[3].setInteractable(3, 12, true);
        grid[3].setMovable(3, 12, false);
        grid[3].setObject(10, 10, bookTileFile.getPath());
        grid[3].setInteractable(10, 10, true);
        grid[3].setMovable(10, 10, false);
        grid[3].setObject(15, 8, bookTileFile.getPath());
        grid[3].setInteractable(15, 8, true);
        grid[3].setMovable(15, 8, false);
        
        for(int k=11;k<12;k+=3){
            for(int h=5;h<15;h+=2){
                for (int i=0;i<treeFile.length;i++){
                    for (int x=0; x<treeFile[0].length;x++){
                        grid[3].setObject(k+i, h+x, treeFile[i][x].getPath());
                        grid[3].setInteractable(k+i, h+x, false);
                        grid[3].setMovable(k+i, h+x, false);
                    }
                }
            }
        }
        
        this.gridNum = 0;
        Group[] gr = new Group[4];
        for (int i = 0; i < 4; i++) {
            gr[i] = grid[i].draw();
        }
        
        direction = "right";
        ImageView mainChar = new ImageView();
        try {
            Image image = new Image(mainCharFile.toURI().toString());
            mainChar.setImage(image);
            mainChar.setX(30 * grid[gridNum].getX());
            mainChar.setY(30 * grid[gridNum].getY()-15);
        } catch (Exception e) {}
        bookNum = 0;
        Label bookLabel = new Label(bookNum + "/" + books.length + " books found");

        bookLabel.setFont(this.getPressStart2PFont(1)); // It doesn't matter what font size I put here so I will default it to 1.
        bookLabel.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-background-color: rgba(255,255,255,0); -fx-text-fill: rgb(0,0,0); -fx-font-size: 15px;");
        bookLabel.setTranslateX(375);
        bookLabel.setTranslateY(12);
        
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);

        Group view = new Group();
        view.getChildren().addAll(
            gr[gridNum],
            mainChar,
            bookLabel
        );
        scene = new Scene(view);
        
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                
                if (!this.onPauseScreen) {
                    if (showingBook) {
                        if (xVal >= books[bookNum].getBackButton().getLeftX() && xVal <= books[bookNum].getBackButton().getRightX() && yVal >= books[bookNum].getBackButton().getTopY() && yVal <= books[bookNum].getBackButton().getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else {
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    } else {
                        scene.setCursor(Cursor.DEFAULT);
                    }
                } else if (this.onPauseScreen && !showingBook) {
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else {
                        scene.setCursor(Cursor.DEFAULT);
                    }
                }
            }
        );
        /*
        if (!showingBook) {
            scene.setCursor(Cursor.DEFAULT);
        }
        */

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                
                if (!this.onPauseScreen) {
                    if (showingBook) {
                        if (xVal >= books[bookNum].getBackButton().getLeftX() && xVal <= books[bookNum].getBackButton().getRightX() && yVal >= books[bookNum].getBackButton().getTopY() && yVal <= books[bookNum].getBackButton().getBottomY()) {
                            books[bookNum].getBackButton().cursorOverButton();
                            scene.setRoot(books[bookNum].getScene());
                            //view.getChildren().set(0, books[bookNum].getScene());
                            //view.getChildren().set(3, books[bookNum].getScene());
                            //backButton.getRedRectangle().setVisible(true);
                            //redRectangleAroundBackButton.setVisible(true);
                        } else {
                            books[bookNum].getBackButton().cursorNotOverButton();
                            scene.setRoot(books[bookNum].getScene());
                            //view.getChildren().set(3, books[bookNum].getScene());
                            //view.getChildren().set(0, books[bookNum].getScene());
                            //backButton.getRedRectangle().setVisible(false);
                            //redRectangleAroundBackButton.setVisible(false);
                        }
                    }
                } else if (this.onPauseScreen && !showingBook) {
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        exitGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        exitGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
    
                    if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        mainMenuGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        mainMenuGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();
                if (!this.onPauseScreen) {
                    if (showingBook) {
                        if (xVal >= books[bookNum].getBackButton().getLeftX() && xVal <= books[bookNum].getBackButton().getRightX() && yVal >= books[bookNum].getBackButton().getTopY() && yVal <= books[bookNum].getBackButton().getBottomY()) {
                            showingBook = false;
                            gr[gridNum] = grid[gridNum].draw();
                            bookNum++;
                            Image image = new Image(mainCharFile.toURI().toString());
                            mainChar.setImage(image);
                            mainChar.setX(30 * grid[gridNum].getX());
                            mainChar.setY(30 * grid[gridNum].getY()-15);
                            if(direction.equals("left")){
                                mainChar.setScaleX(-1);
                            }else{
                                mainChar.setScaleX(1);
                            }
                            //view.getChildren().clear();
                            view.getChildren().set(0, gr[gridNum]);
                            view.getChildren().set(1, mainChar);
                            bookLabel.setText(bookNum + "/" + books.length + " books found");
                            view.getChildren().set(2, bookLabel);
                            scene.setRoot(view);
                        }
                    }
                } else if (this.onPauseScreen && !showingBook) {
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        //this.onPauseScreen = false;
                        //System.exit(0);
                        screenNum = 6;
                        stage.setScene(this.quitGameScene);
                        stage.show();
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        screenNum = 1;
                        this.onPauseScreen = false;
                        //int lastIndex = view.getChildren().size() - 1;
                        //view.getChildren().remove(lastIndex);
                        stage.setScene(this.mainMenuScene);
                        stage.show();
                    } else {
                        int lastIndex = view.getChildren().size() - 1;
                        //System.out.println(view.getChildren());
                        //System.out.println(view.getChildren().remove(lastIndex));
                        view.getChildren().remove(lastIndex);
                        this.onPauseScreen = false;
                        //scene.setRoot(view);
                        /*
                        Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                        Group tempGroup = new Group();
                        tempGroup.getChildren().addAll(
                            back
                        );
                        stage.setScene(new Scene(tempGroup, 600, 600));
                        return;
                        */
                    }
                }
            }
        );

        // Runs on a key press.
        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    if (!this.onPauseScreen) {
                        try {
                            if (!showingBook && k.getCode() == KeyCode.ESCAPE) {
                                this.onPauseScreen = true;
                                view.getChildren().add(ps.getScene());
                                //scene.setRoot(view);
                                //System.out.println(temp);
                                //System.out.println(view.getChildren());
                                //System.out.println(this.onPauseScreen);
                            } else if (k.getCode() == KeyCode.SPACE) {
                                Tile interaction = grid[gridNum].interact();
                                /*
                                    if (showingBook) {
                                        showingBook = false;
                                        gr[gridNum] = grid[gridNum].draw();
                                    } else 
                                */
                                if (interaction != null) {
                                    if (interaction.getObject().equals(bookTileFile.getPath())) {
                                        showingBook = true;
                                        interaction.setObject(additionalGrassTileFile.getPath());
                                        interaction.setMovable(true);
                                        interaction.setInteractable(false);
                                        scene.setRoot(books[bookNum].getScene());
                                        //view.getChildren().add(books[bookNum].getScene());
                                        //scene.setRoot(view);
                                        //bookNum++;
                                        if (bookNum + 1 == books.length) {
                                            grid[0].setObject(15, 15, confrontation1LowerFile.getPath());
                                            grid[0].setMovable(15, 15, false);
                                            grid[0].setInteractable(15, 15, true);
                                            grid[0].setObject(14, 15, confrontation1UpperFile.getPath());
                                            grid[0].setMovable(14, 15, false);
                                            grid[0].setInteractable(14, 15, true);
                                            gr[0] = grid[0].draw();
                                        }
                                    } else if (interaction.getObject().equals(confrontation1UpperFile.getPath())||interaction.getObject().equals(confrontation1LowerFile.getPath())) {
                                        stage.setScene(confrontationTextScene1);
                                    }
                                }
                            }
                            if (!showingBook) {
                                if (k.getCode() == KeyCode.W) {
                                    final int OFF = grid[gridNum].moveUp();
                                    if (OFF != -1) {
                                        this.gridNum -= 2;
                                        grid[gridNum].setX(OFF);
                                        grid[gridNum].setY(19);
                                    }
                                } else if (k.getCode() == KeyCode.A) {
                                    final int OFF = grid[gridNum].moveLeft();
                                    if (OFF != -1) {
                                        this.gridNum -= 1;
                                        grid[gridNum].setX(19);
                                        grid[gridNum].setY(OFF);
                                    }
                                    direction = "left";
                                } else if (k.getCode() == KeyCode.S) {
                                    final int OFF = grid[gridNum].moveDown();
                                    if (OFF != -1) {
                                        gridNum += 2;
                                        grid[gridNum].setX(OFF);
                                        grid[gridNum].setY(0);
                                    }
                                } else if (k.getCode() == KeyCode.D) {
                                    final int OFF = grid[gridNum].moveRight();
                                    if (OFF != -1) {
                                        gridNum += 1;
                                        grid[gridNum].setX(0);
                                        grid[gridNum].setY(OFF);
                                    }
                                    direction = "right";
                                }
                                
                                Image image = new Image(mainCharFile.toURI().toString());
                                mainChar.setImage(image);
                                mainChar.setX(30 * grid[gridNum].getX());
                                mainChar.setY(30 * grid[gridNum].getY()-15);
                                if(direction.equals("left")){
                                    mainChar.setScaleX(-1);
                                }else{
                                    mainChar.setScaleX(1);
                                }
                                //view.getChildren().clear();
                                view.getChildren().set(0, gr[gridNum]);
                                view.getChildren().set(1, mainChar);
                                bookLabel.setText(bookNum + "/" + books.length + " books found");
                                view.getChildren().set(2, bookLabel);
                                scene.setRoot(view);
                            }
                        } catch (Exception e) {e.printStackTrace();}
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    
    /**
     * Public non-static method used to create the second level for the actual game.
     * <p>
     * This public non-static method will be used to create the second level of the
     * program and return it as a scene. It will do this by creating an instance of the
     * Grid.java class to simulate the grid and it also has an action listener
     * for moving, and interaction with books. It draws this on a scene that it
     * returns with the draw method in the Grid instance and a photo at the location
     * of the mainX and mainY coordinates of the Grid instance.
     * <p>
     * Done by: Simon May 30 - June 3
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show level 2 of the game.
     * @throws IOException
     */
    public Scene level2(Stage stage) throws IOException {
        
        //By Simon May 30-June 3 for 1 hour
        screenNum = 2;
        Grid grid = new Grid(15, 15);
        Scene scene;
        health = 100;
        
        // Grid
        for (int i = 0; i < 20; i++) {
            int j=0;
            grid.assign(i, j, cafWallFile.getPath(), "", false, false);
            j=19;
            grid.assign(i, j, cafWallFile.getPath(), "", false, false);
        }
        for (int j = 1; j < 19; j++) {
            int i = 0;
            grid.assign(i, j, cafWallFile.getPath(), "", false, false);
            i = 19;
            grid.assign(i, j, cafWallFile.getPath(), "", false, false);
        }
        for (int i = 1; i < 19; i++) {
            for (int j = 1; j < 19; j++) {
                grid.assign(i, j, cafFloorFiles[(i+j)%2].getPath(), "", true, false);
            }
        }
        grid.setObject(0, 15, doorLeftFile.getPath());
        grid.setObject(0, 16, doorRightFile.getPath());
        
        grid.setObject(10, 5, confrontationChar[1].getPath());
        grid.setInteractable(10, 5, true);
        grid.setMovable(10, 5, false);
        
        grid.setObject(15, 12, confrontation3UpperFile.getPath());
        grid.setInteractable(15, 12, true);
        grid.setMovable(15, 12, false);
        grid.setObject(16, 12, confrontation3LowerFile.getPath());
        grid.setInteractable(16, 12, true);
        grid.setMovable(16, 12, false);
        
        grid.setObject(4, 16, confrontation4UpperFile.getPath());
        grid.setInteractable(4, 16, true);
        grid.setMovable(4, 16, false);
        grid.setObject(5, 16, confrontation4LowerFile.getPath());
        grid.setInteractable(5, 16, true);
        grid.setMovable(5, 16, false);
        
        for(int h=1;h<8;h+=3){
            int k = 2;
            for (int i=0;i<benchFile.length;i++){
                grid.setObject(k, h+i, benchFile[i].getPath());
                grid.setInteractable(k, h+i, false);
                grid.setMovable(k, h+i, false);
            }
        }
        for(int h=13;h<17;h+=3){
            int k = 2;
            for (int i=0;i<benchFile.length;i++){
                grid.setObject(k, h+i, benchFile[i].getPath());
                grid.setInteractable(k, h+i, false);
                grid.setMovable(k, h+i, false);
            }
        }
        
        for(int h=4;h<17;h+=3){
            int k = 4;
            for (int i=0;i<benchFile.length;i++){
                grid.setObject(k, h+i, benchFile[i].getPath());
                grid.setInteractable(k, h+i, false);
                grid.setMovable(k, h+i, false);
            }
        }
        
        for(int h=1;h<11;h+=3){
            int k = 7;
            for (int i=0;i<benchFile.length;i++){
                grid.setObject(k, h+i, benchFile[i].getPath());
                grid.setInteractable(k, h+i, false);
                grid.setMovable(k, h+i, false);
            }
        }
        for(int h=16;h<17;h+=3){
            int k = 7;
            for (int i=0;i<benchFile.length;i++){
                grid.setObject(k, h+i, benchFile[i].getPath());
                grid.setInteractable(k, h+i, false);
                grid.setMovable(k, h+i, false);
            }
        }
        
        for(int h=1;h<4;h+=3){
            int k = 11;
            for (int i=0;i<benchFile.length;i++){
                grid.setObject(k, h+i, benchFile[i].getPath());
                grid.setInteractable(k, h+i, false);
                grid.setMovable(k, h+i, false);
            }
        }
        for(int h=7;h<17;h+=3){
            int k = 11;
            for (int i=0;i<benchFile.length;i++){
                grid.setObject(k, h+i, benchFile[i].getPath());
                grid.setInteractable(k, h+i, false);
                grid.setMovable(k, h+i, false);
            }
        }
        
        for(int h=1;h<7;h+=3){
            int k = 14;
            for (int i=0;i<benchFile.length;i++){
                grid.setObject(k, h+i, benchFile[i].getPath());
                grid.setInteractable(k, h+i, false);
                grid.setMovable(k, h+i, false);
            }
        }
        for(int h=10;h<17;h+=3){
            int k = 14;
            for (int i=0;i<benchFile.length;i++){
                grid.setObject(k, h+i, benchFile[i].getPath());
                grid.setInteractable(k, h+i, false);
                grid.setMovable(k, h+i, false);
            }
        }
        
        for(int h=4;h<17;h+=3){
            int k = 17;
            for (int i=0;i<benchFile.length;i++){
                grid.setObject(k, h+i, benchFile[i].getPath());
                grid.setInteractable(k, h+i, false);
                grid.setMovable(k, h+i, false);
            }
        }
        
        level2Group = grid.draw();
        
        direction = "right";
        ImageView mainChar = new ImageView();
        try {
            Image image = new Image(mainCharFile.toURI().toString());
            mainChar.setImage(image);
            mainChar.setX(30 * grid.getX());
            mainChar.setY(30 * grid.getY()-15);
        } catch (Exception e) {}
        bookNum = 0;

        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);

        Group view = new Group();
        view.getChildren().addAll(
            level2Group,
            mainChar
        );
        scene = new Scene(view);
        
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else {
                        scene.setCursor(Cursor.DEFAULT);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        exitGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        exitGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
    
                    if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        mainMenuGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        mainMenuGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        //this.onPauseScreen = false;
                        //System.exit(0);
                        screenNum = 6;
                        stage.setScene(this.quitGameScene);
                        stage.show();
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        screenNum = 1;
                        this.onPauseScreen = false;
                        stage.setScene(this.mainMenuScene);
                        stage.show();
                    } else {
                        int lastIndex = view.getChildren().size() - 1;
                        view.getChildren().remove(lastIndex);
                        this.onPauseScreen = false;
                        //try {
                        //    this.level1Scene = this.level1(stage);
                        //    this.level2Scene = this.level2(stage);
                        //    this.level3Scene = this.level3(stage);
                        //} catch (IOException ioe) {}
                        /*
                        Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                        Group tempGroup = new Group();
                        tempGroup.getChildren().addAll(
                            back
                        );
                        stage.setScene(new Scene(tempGroup, 600, 600));
                        return;
                        */
                    }
                }
            }
        );

        // Runs on a key press.
        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    if (!this.onPauseScreen) {
                        try {
                            if (k.getCode() == KeyCode.ESCAPE) {
                                this.onPauseScreen = true;
                                view.getChildren().add(ps.getScene());
                            } else if (k.getCode() == KeyCode.W) {
                                grid.moveUp();
                            } else if (k.getCode() == KeyCode.A) {
                                grid.moveLeft();
                                direction = "left";
                            } else if (k.getCode() == KeyCode.S) {
                                grid.moveDown();
                            } else if (k.getCode() == KeyCode.D) {
                                grid.moveRight();
                                direction = "right";
                            } else if (k.getCode() == KeyCode.SPACE) {
                                Tile interaction = grid.interact();
                                if(interaction.getObject().equals(confrontationChar[1].getPath())){
                                    interaction.setObject("");
                                    interaction.setMovable(true);
                                    interaction.setInteractable(false);
                                    level2Group = grid.draw();
                                    enemyHealth = 100;
                                    battleMenu = "main";
                                    form = "";
                                    block=0;
                                    questionMenu = "startText";
                                    this.confrontationTextScene2 = this.confrontation2Text(stage);
                                    stage.setScene(confrontationTextScene2);
                                }else if(interaction.getObject().equals(confrontation3UpperFile.getPath())||interaction.getObject().equals(confrontation3LowerFile.getPath())){
                                    grid.setObject(15, 12, "");
                                    grid.setInteractable(15, 12, false);
                                    grid.setMovable(15, 12, true);
                                    grid.setObject(16, 12, "");
                                    grid.setInteractable(16, 12, false);
                                    grid.setMovable(16, 12, true);
                                    level2Group = grid.draw();
                                    enemyHealth = 100;
                                    battleMenu = "main";
                                    form = "";
                                    block=0;
                                    questionMenu = "startText";
                                    this.confrontationTextScene3 = this.confrontation3Text(stage);
                                    stage.setScene(confrontationTextScene3);
                                }else if(interaction.getObject().equals(confrontation4UpperFile.getPath())||interaction.getObject().equals(confrontation4LowerFile.getPath())){
                                    grid.setObject(4, 16, "");
                                    grid.setInteractable(4, 16, false);
                                    grid.setMovable(4, 16, true);
                                    grid.setObject(5, 16, "");
                                    grid.setInteractable(5, 16, false);
                                    grid.setMovable(5, 16, true);
                                    level2Group = grid.draw();
                                    enemyHealth = 100;
                                    battleMenu = "main";
                                    form = "";
                                    block=0;
                                    questionMenu = "startText";
                                    this.confrontationTextScene4 = this.confrontation4Text(stage);
                                    stage.setScene(confrontationTextScene4);
                                }
                            }
                                
                            Image image = new Image(mainCharFile.toURI().toString());
                            mainChar.setImage(image);
                            mainChar.setX(30 * grid.getX());
                            mainChar.setY(30 * grid.getY()-15);
                            if(direction.equals("left")){
                                mainChar.setScaleX(-1);
                            }else{
                                mainChar.setScaleX(1);
                            }
                            //view.getChildren().clear();
                            view.getChildren().set(0, level2Group);
                            view.getChildren().set(1, mainChar);
                            scene.setRoot(view);
                        } catch (Exception e) {}
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the third level for the actual game.
     * <p>
     * This public non-static method will be used to create the third level of the
     * program and return it as a scene. It will do this by creating an instance of the
     * Grid.java class to simulate the grid and it also has an action listener
     * for moving. It draws this on a scene that it returns with the draw method in the 
     * Grid instance and a photo at the location of the mainX and mainY coordinates of 
     * the Grid instance.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show level 3 of the game.
     * @throws IOException
     */
    public Scene level3(Stage stage) throws IOException {
        screenNum = 2;
        Grid grid = new Grid(15, 15);
        Scene scene;
        health = 100;
        
        // Grid
        for (int i = 0; i < 20; i++) {
            int j=0;
            grid.assign(i, j, houseWallFile.getPath(), "", false, false);
            j=19;
            grid.assign(i, j, houseWallFile.getPath(), "", false, false);
        }
        for (int j = 1; j < 19; j++) {
            int i = 0;
            grid.assign(i, j, houseWallFile.getPath(), "", false, false);
            i = 19;
            grid.assign(i, j, houseWallFile.getPath(), "", false, false);
        }
        for (int i = 1; i < 19; i++) {
            for (int j = 1; j < 19; j++) {
                grid.assign(i, j, houseFloorFile.getPath(), "", true, false);
            }
        }
        
        grid.setObject(9, 14, motherUpperFile.getPath());
        grid.setInteractable(9, 14, true);
        grid.setMovable(9, 14, false);
        grid.setObject(10, 14, motherLowerFile.getPath());
        grid.setInteractable(10, 14, true);
        grid.setMovable(10, 14, false);
        grid.setObject(9, 15, fatherUpperFile.getPath());
        grid.setInteractable(9, 15, false);
        grid.setMovable(9, 15, false);
        grid.setObject(10, 15, fatherLowerFile.getPath());
        grid.setInteractable(10, 15, false);
        grid.setMovable(10, 15, false);
        
        for (int i=0;i<2;i++){
            for (int x=0; x<3;x++){
                grid.setObject(4+i, 5+x, tableFile[i][x].getPath());
                grid.setInteractable(4+i, 5+x, false);
                grid.setMovable(4+i, 5+x, false);
            }
        }

        level3Group = grid.draw();
        
        direction = "right";
        ImageView mainChar = new ImageView();
        try {
            Image image = new Image(mainCharFile.toURI().toString());
            mainChar.setImage(image);
            mainChar.setX(30 * grid.getX());
            mainChar.setY(30 * grid.getY()-15);
        } catch (Exception e) {}
        bookNum = 0;
        
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);

        Group view = new Group();
        view.getChildren().addAll(
            level3Group,
            mainChar
        );
        
        scene = new Scene(view);
        
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else {
                        scene.setCursor(Cursor.DEFAULT);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        exitGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        exitGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
    
                    if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        mainMenuGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        mainMenuGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        //this.onPauseScreen = false;
                        //System.exit(0);
                        screenNum = 6;
                        stage.setScene(this.quitGameScene);
                        stage.show();
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        screenNum = 1;
                        this.onPauseScreen = false;
                        stage.setScene(this.mainMenuScene);
                        stage.show();
                    } else {
                        int lastIndex = view.getChildren().size() - 1;
                        view.getChildren().remove(lastIndex);
                        this.onPauseScreen = false;
                        /*
                        Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                        Group tempGroup = new Group();
                        tempGroup.getChildren().addAll(
                            back
                        );
                        stage.setScene(new Scene(tempGroup, 600, 600));
                        return;
                        */
                    }
                }
            }
        );

        // Runs on a key press.
        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    if (!this.onPauseScreen) {
                        try {
                            if (k.getCode() == KeyCode.ESCAPE) {
                                this.onPauseScreen = true;
                                view.getChildren().add(ps.getScene());
                            } else if (k.getCode() == KeyCode.W) {
                                grid.moveUp();
                            } else if (k.getCode() == KeyCode.A) {
                                grid.moveLeft();
                                direction = "left";
                            } else if (k.getCode() == KeyCode.S) {
                                grid.moveDown();
                            } else if (k.getCode() == KeyCode.D) {
                                grid.moveRight();
                                direction = "right";
                            } else if (k.getCode() == KeyCode.SPACE) {
                                Tile interaction = grid.interact();
                                if(interaction!=null){
                                    enemyHealth = 100;
                                    battleMenu = "main";
                                    form = "";
                                    questionMenu = "startText";
                                    stage.setScene(confrontationTextScene5);
                                }
                            }
                                
                            Image image = new Image(mainCharFile.toURI().toString());
                            mainChar.setImage(image);
                            mainChar.setX(30 * grid.getX());
                            mainChar.setY(30 * grid.getY()-15);
                            if(direction.equals("left")){
                                mainChar.setScaleX(-1);
                            }else{
                                mainChar.setScaleX(1);
                            }
                            //view.getChildren().clear();
                            view.getChildren().set(0, level3Group);
                            view.getChildren().set(1, mainChar);
                            scene.setRoot(view);
                        } catch (Exception e) {}
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    
    /**
     * Public non-static method used to create the first encounter text.
     * <p>
     * This public non-static method will be used to create the text for the first
     * conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text.
     * <p>
     * Done by: Simon May 30 - June 3: 1 hour
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the first encounter of the game.
     * @throws IOException
     */
    public Scene confrontation1Text(Stage stage) throws IOException {
        health = 100;
        Scene scene;

        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[0]))), "Yourself:", "I think I may be transgender, but I'm scared. How will people see me. Maybe its better If I just repress it.", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);
        
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            encounterTxt.getScene()
        );
        scene = new Scene(nodesToAdd);
        
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else {
                        scene.setCursor(Cursor.DEFAULT);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        exitGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        exitGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
    
                    if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        mainMenuGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        mainMenuGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        //this.onPauseScreen = false;
                        //System.exit(0);
                        screenNum = 6;
                        stage.setScene(this.quitGameScene);
                        stage.show();
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        screenNum = 1;
                        this.onPauseScreen = false;
                        stage.setScene(this.mainMenuScene);
                        stage.show();
                    } else {
                        int lastIndex = nodesToAdd.getChildren().size() - 1;
                        nodesToAdd.getChildren().remove(lastIndex);
                        this.onPauseScreen = false;
                        /*
                        Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                        Group tempGroup = new Group();
                        tempGroup.getChildren().addAll(
                            back
                        );
                        stage.setScene(new Scene(tempGroup, 600, 600));
                        return;
                        */
                    }
                }
            }
        );

        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    if (!this.onPauseScreen) {
                        try {
                            if (k.getCode() == KeyCode.ESCAPE) {
                                this.onPauseScreen = true;
                                nodesToAdd.getChildren().add(ps.getScene());
                            } else if (k.getCode() == KeyCode.SPACE) {
                                stage.setScene(confrontationBattleScene1);
                            }
                        } catch (Exception e) {}
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the second encounter text.
     * <p>
     * This public non-static method will be used to create the text for the second
     * conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text. It will also ask if what the the enemy is saying is transphobic and 
     * use buttons to get the answer from the user.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the second encounter of the game.
     * @throws IOException
     */
    public Scene confrontation2Text(Stage stage) throws IOException {
        Scene scene;
        GameButton yesButton = new GameButton(this.pressStart2PFile, "Yes", 85, 470, 17);	
        	
        GameButton noButton = new GameButton(this.pressStart2PFile, "No", 390, 470, 17);	
        
        questionMenu="startText";
        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[1]))), "Thomas:", "That so trans. You don't even look like a girl. You should stop trying to be something you are not.", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        encounterTxt.getChar2ImageView().setFitWidth(175);
        encounterTxt.getChar2ImageView().setTranslateX(-24);
        encounterTxt.getChar2ImageView().setTranslateY(-4);
        
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);
        
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            encounterTxt.getScene()
        );
        scene = new Scene(nodesToAdd);
                
        try{
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    if (!this.onPauseScreen) {
                        if(questionMenu.equals("question")){
                            if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else {
                                scene.setCursor(Cursor.DEFAULT);
                            }
                        }
                    } else {
                        if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else {
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    }
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
    
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    
                    //System.out.println(xVal + " " + yVal);
                    
                    if (!this.onPauseScreen) {
                        if(questionMenu.equals("question")){
                            if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                                yesButton.cursorOverButton();
                                //redRectangleAroundNewGameButton.setVisible(true);
                            } else {
                                yesButton.cursorNotOverButton();
                                //redRectangleAroundNewGameButton.setVisible(false);
                            }
            
                            if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                                noButton.cursorOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(true);
                            } else {
                                noButton.cursorNotOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(false);
                            }
                        } 
                    } else {
                        if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                            exitGameButton.cursorOverButton();
                            //backButton.getRedRectangle().setVisible(true);
                            //redRectangleAroundBackButton.setVisible(true);
                        } else {
                            exitGameButton.cursorNotOverButton();
                            //backButton.getRedRectangle().setVisible(false);
                            //redRectangleAroundBackButton.setVisible(false);
                        }
        
                        if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                            mainMenuGameButton.cursorOverButton();
                            //backButton.getRedRectangle().setVisible(true);
                            //redRectangleAroundBackButton.setVisible(true);
                        } else {
                            mainMenuGameButton.cursorNotOverButton();
                            //backButton.getRedRectangle().setVisible(false);
                            //redRectangleAroundBackButton.setVisible(false);
                        }
                    }             
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
                e -> {
                    try{
                        final double xVal = e.getX();
                        final double yVal = e.getY();
                        if (!this.onPauseScreen) {
                            if(questionMenu.equals("question")){
                                if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                                    score += 50;
                                    ConfrontationScene answerTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[1]))), "You answered yes:", "That is correct! Thomas was talking about your physique and telling you that you are not the gender you are. This is very transphobic.", health, enemyHealth);
                                    answerTxt.getChar2ImageView().setFitWidth(175);
                                    answerTxt.getChar2ImageView().setTranslateX(-24);
                                    answerTxt.getChar2ImageView().setTranslateY(-4);
                                    //scene.setRoot(answerTxt.getScene());
                                    nodesToAdd.getChildren().set(0, answerTxt.getScene());
                                    stage.show();
                                    questionMenu = "endText";
                                } else if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                                    ConfrontationScene answerTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[1]))), "You answered no:", "That is incorrect! Thomas was talking about your physique and telling you that you are not the gender you are. This is very transphobic.", health, enemyHealth);
                                    answerTxt.getChar2ImageView().setFitWidth(175);
                                    answerTxt.getChar2ImageView().setTranslateX(-24);
                                    answerTxt.getChar2ImageView().setTranslateY(-4);
                                    //scene.setRoot(answerTxt.getScene());
                                    nodesToAdd.getChildren().set(0, answerTxt.getScene());
                                    stage.show();
                                    questionMenu = "endText";
                                }
                            }
                        } else {
                            if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                                //this.onPauseScreen = false;
                                //System.exit(0);
                                screenNum = 6;
                                stage.setScene(this.quitGameScene);
                                stage.show();
                            } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                                screenNum = 1;
                                this.onPauseScreen = false;
                                stage.setScene(this.mainMenuScene);
                                stage.show();
                            } else {
                                int lastIndex = nodesToAdd.getChildren().size() - 1;
                                nodesToAdd.getChildren().remove(lastIndex);
                                this.onPauseScreen = false;
                                //try {
                                //    this.level1Scene = this.level1(stage);
                                //    this.level2Scene = this.level2(stage);
                                //    this.level3Scene = this.level3(stage);
                                //} catch (IOException ioe) {}
                                /*
                                Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                                Group tempGroup = new Group();
                                tempGroup.getChildren().addAll(
                                    back
                                );
                                stage.setScene(new Scene(tempGroup, 600, 600));
                                return;
                                */
                            }
                        }
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            );
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    if (!this.onPauseScreen) {
                        try {
                            if (k.getCode() == KeyCode.ESCAPE) {
                                this.onPauseScreen = true;
                                nodesToAdd.getChildren().add(ps.getScene());
                            } else {
                                if (questionMenu.equals("startText")) {
                                    ConfrontationScene questionButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[1]))),"Is Thomas Being transphobic?", yesButton, noButton);
                                    questionButtons.getChar2ImageView().setFitWidth(175);
                                    questionButtons.getChar2ImageView().setTranslateX(-24);
                                    questionButtons.getChar2ImageView().setTranslateY(-4);
                                    //scene.setRoot(questionButtons.getScene());
                                    nodesToAdd.getChildren().set(0, questionButtons.getScene());
                                    stage.show();
                                    questionMenu = "question";
                                } else if(questionMenu.equals("endText")){
                                    this.confrontationBattleScene2 = this.confrontationBattle(stage,2);
                                    stage.setScene(confrontationBattleScene2);
                                }
                            }
                        } catch (Exception e) {}
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the third encounter text.
     * <p>
     * This public non-static method will be used to create the text for the third
     * conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text. It will also ask if what the the enemy is saying is transphobic and 
     * use buttons to get the answer from the user.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the third encounter of the game.
     * @throws IOException
     */
    public Scene confrontation3Text(Stage stage) throws IOException {
        Scene scene;
        GameButton yesButton = new GameButton(this.pressStart2PFile, "Yes", 85, 470, 17);	
        	
        GameButton noButton = new GameButton(this.pressStart2PFile, "No", 390, 470, 17);	
        
        questionMenu="startText";
        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[2]))), "Sarah:", "I really love skirts. Don't you like them too?", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        encounterTxt.getChar2ImageView().setFitWidth(175);
        encounterTxt.getChar2ImageView().setTranslateX(-30);
        encounterTxt.getChar2ImageView().setTranslateY(-4);
        
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);
        
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            encounterTxt.getScene()
        );
        scene = new Scene(nodesToAdd);
                
        try{
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    if (!this.onPauseScreen) {
                        if(questionMenu.equals("question")){
                            if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else {
                                scene.setCursor(Cursor.DEFAULT);
                            }
                        }
                    } else {
                        if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else {
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    }
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
    
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    
                    //System.out.println(xVal + " " + yVal);
                    
                    if (!this.onPauseScreen) {
                        if(questionMenu.equals("question")){
                            if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                                yesButton.cursorOverButton();
                                //redRectangleAroundNewGameButton.setVisible(true);
                            } else {
                                yesButton.cursorNotOverButton();
                                //redRectangleAroundNewGameButton.setVisible(false);
                            }
            
                            if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                                noButton.cursorOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(true);
                            } else {
                                noButton.cursorNotOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(false);
                            }
                        }
                    } else {
                        if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                            exitGameButton.cursorOverButton();
                            //backButton.getRedRectangle().setVisible(true);
                            //redRectangleAroundBackButton.setVisible(true);
                        } else {
                            exitGameButton.cursorNotOverButton();
                            //backButton.getRedRectangle().setVisible(false);
                            //redRectangleAroundBackButton.setVisible(false);
                        }
        
                        if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                            mainMenuGameButton.cursorOverButton();
                            //backButton.getRedRectangle().setVisible(true);
                            //redRectangleAroundBackButton.setVisible(true);
                        } else {
                            mainMenuGameButton.cursorNotOverButton();
                            //backButton.getRedRectangle().setVisible(false);
                            //redRectangleAroundBackButton.setVisible(false);
                        }
                    }                
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
                e -> {
                    try{
                        final double xVal = e.getX();
                        final double yVal = e.getY();
                        if (!this.onPauseScreen) {
                            if(questionMenu.equals("question")){
                                if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                                    ConfrontationScene answerTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[2]))), "You answered yes:", "That is incorrect! Sarah is just trying to talk about something she likes. Even though she might unknowingly be pressuring you to wear a skirt it is not her intention.", health, enemyHealth); 
                                    answerTxt.getChar2ImageView().setFitWidth(175);
                                    answerTxt.getChar2ImageView().setTranslateX(-30);
                                    answerTxt.getChar2ImageView().setTranslateY(-4);
                                    //scene.setRoot(answerTxt.getScene());
                                    nodesToAdd.getChildren().set(0, answerTxt.getScene());
                                    stage.show();
                                    questionMenu = "endText";
                                } else if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                                    score += 50;
                                    ConfrontationScene answerTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[2]))), "You answered no:", "That is correct! Sarah is just trying to talk about something she likes. Even though she might unknowingly be pressuring you to wear a skirt it is not her intention.", health, enemyHealth);
                                    answerTxt.getChar2ImageView().setFitWidth(175);
                                    answerTxt.getChar2ImageView().setTranslateX(-30);
                                    answerTxt.getChar2ImageView().setTranslateY(-4);
                                    //scene.setRoot(answerTxt.getScene());
                                    nodesToAdd.getChildren().set(0, answerTxt.getScene());
                                    stage.show();
                                    questionMenu = "endText";
                                }
                            }
                        } else {
                            if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                                //this.onPauseScreen = false;
                                //System.exit(0);
                                screenNum = 6;
                                stage.setScene(this.quitGameScene);
                                stage.show();
                            } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                                screenNum = 1;
                                this.onPauseScreen = false;
                                stage.setScene(this.mainMenuScene);
                                stage.show();
                            } else {
                                int lastIndex = nodesToAdd.getChildren().size() - 1;
                                nodesToAdd.getChildren().remove(lastIndex);
                                this.onPauseScreen = false;
                                //try {
                                //    this.level1Scene = this.level1(stage);
                                //    this.level2Scene = this.level2(stage);
                                //    this.level3Scene = this.level3(stage);
                                //} catch (IOException ioe) {}
                                /*
                                Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                                Group tempGroup = new Group();
                                tempGroup.getChildren().addAll(
                                    back
                                );
                                stage.setScene(new Scene(tempGroup, 600, 600));
                                return;
                                */
                            }
                        }
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            );
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    if (!this.onPauseScreen) {
                        try {
                            if (k.getCode() == KeyCode.ESCAPE) {
                                this.onPauseScreen = true;
                                nodesToAdd.getChildren().add(ps.getScene());
                            } else {
                                if (questionMenu.equals("startText")) {
                                    ConfrontationScene questionButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[2]))),"Is Sarah being transphobic?", yesButton, noButton);
                                    questionButtons.getChar2ImageView().setFitWidth(175);
                                    questionButtons.getChar2ImageView().setTranslateX(-30);
                                    questionButtons.getChar2ImageView().setTranslateY(-4);
                                    //scene.setRoot(questionButtons.getScene());
                                    nodesToAdd.getChildren().set(0, questionButtons.getScene());
                                    stage.show();
                                    questionMenu = "question";
                                }else if(questionMenu.equals("endText")){
                                    this.confrontationBattleScene3 = this.confrontationBattle(stage,3);
                                    stage.setScene(confrontationBattleScene3);
                                }
                            }
                        } catch (Exception e) {}
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the fourth encounter text.
     * <p>
     * This public non-static method will be used to create the text for the fourth
     * conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text. It will also ask if what the the enemy is saying is transphobic and 
     * use buttons to get the answer from the user.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the fourth encounter of the game.
     * @throws IOException
     */
    public Scene confrontation4Text(Stage stage) throws IOException {
        Scene scene;
        GameButton yesButton = new GameButton(this.pressStart2PFile, "Yes", 85, 470, 17);	
        	
        GameButton noButton = new GameButton(this.pressStart2PFile, "No", 390, 470, 17);	
        
        questionMenu="startText";
        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[3]))), "Karen:", "You are not a real girl.", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        encounterTxt.getChar2ImageView().setFitWidth(175);
        encounterTxt.getChar2ImageView().setTranslateX(-30);
        encounterTxt.getChar2ImageView().setTranslateY(-4);
        
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);
        
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            encounterTxt.getScene()
        );
        scene = new Scene(nodesToAdd);
                
        try{
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    if (!this.onPauseScreen) {
                        if(questionMenu.equals("question")){
                            if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else {
                                scene.setCursor(Cursor.DEFAULT);
                            }
                        }
                    } else {
                        if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else {
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    }
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
    
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    
                    //System.out.println(xVal + " " + yVal);
                    
                    if (!this.onPauseScreen) {
                        if(questionMenu.equals("question")){
                            if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                                yesButton.cursorOverButton();
                                //redRectangleAroundNewGameButton.setVisible(true);
                            } else {
                                yesButton.cursorNotOverButton();
                                //redRectangleAroundNewGameButton.setVisible(false);
                            }
            
                            if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                                noButton.cursorOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(true);
                            } else {
                                noButton.cursorNotOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(false);
                            }
                        }
                    } else {
                        if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                            exitGameButton.cursorOverButton();
                            //backButton.getRedRectangle().setVisible(true);
                            //redRectangleAroundBackButton.setVisible(true);
                        } else {
                            exitGameButton.cursorNotOverButton();
                            //backButton.getRedRectangle().setVisible(false);
                            //redRectangleAroundBackButton.setVisible(false);
                        }
        
                        if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                            mainMenuGameButton.cursorOverButton();
                            //backButton.getRedRectangle().setVisible(true);
                            //redRectangleAroundBackButton.setVisible(true);
                        } else {
                            mainMenuGameButton.cursorNotOverButton();
                            //backButton.getRedRectangle().setVisible(false);
                            //redRectangleAroundBackButton.setVisible(false);
                        }
                    }            
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
                e -> {
                    try{
                        final double xVal = e.getX();
                        final double yVal = e.getY();
                        if (!this.onPauseScreen) {
                            if(questionMenu.equals("question")){
                                if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                                    ConfrontationScene answerTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[3]))), "You answered yes:", "That is correct! Karen said that you are not a \"real girl\" which is very transphobic. A just because your gender is not the same as your gender assigned at birth does not mean you are not the gender you are.", health, enemyHealth);
                                    answerTxt.getChar2ImageView().setFitWidth(175);
                                    answerTxt.getChar2ImageView().setTranslateX(-30);
                                    answerTxt.getChar2ImageView().setTranslateY(-4);
                                    score += 50;
                                    //scene.setRoot(answerTxt.getScene());
                                    nodesToAdd.getChildren().set(0, answerTxt.getScene());
                                    stage.show();
                                    questionMenu = "endText";
                                } else if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                                    ConfrontationScene answerTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[3]))), "You answered no:", "That is incorrect! Karen said that you are not a \"real girl\" which is very transphobic. A just because your gender is not the same as your gender assigned at birth does not mean you are not the gender you are.", health, enemyHealth);
                                    answerTxt.getChar2ImageView().setFitWidth(175);
                                    answerTxt.getChar2ImageView().setTranslateX(-30);
                                    answerTxt.getChar2ImageView().setTranslateY(-4);
                                    //scene.setRoot(answerTxt.getScene());
                                    nodesToAdd.getChildren().set(0, answerTxt.getScene());
                                    stage.show();
                                    questionMenu = "endText";
                                }
                            }
                        } else {
                            if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                                //this.onPauseScreen = false;
                                //System.exit(0);
                                screenNum = 6;
                                stage.setScene(this.quitGameScene);
                                stage.show();
                            } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                                screenNum = 1;
                                this.onPauseScreen = false;
                                stage.setScene(this.mainMenuScene);
                                stage.show();
                            } else {
                                int lastIndex = nodesToAdd.getChildren().size() - 1;
                                nodesToAdd.getChildren().remove(lastIndex);
                                this.onPauseScreen = false;
                                //try {
                                //    this.level1Scene = this.level1(stage);
                                //    this.level2Scene = this.level2(stage);
                                //    this.level3Scene = this.level3(stage);
                                //} catch (IOException ioe) {}
                                /*
                                Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                                Group tempGroup = new Group();
                                tempGroup.getChildren().addAll(
                                    back
                                );
                                stage.setScene(new Scene(tempGroup, 600, 600));
                                return;
                                */
                            }
                        }
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            );
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    if (!this.onPauseScreen) {
                        try {
                            if (k.getCode() == KeyCode.ESCAPE) {
                                this.onPauseScreen = true;
                                nodesToAdd.getChildren().add(ps.getScene());
                            } else {
                                if (questionMenu.equals("startText")) {
                                    ConfrontationScene questionButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[3]))),"Is Karen Being transphobic?", yesButton, noButton);
                                    questionButtons.getChar2ImageView().setFitWidth(175);
                                    questionButtons.getChar2ImageView().setTranslateX(-30);
                                    questionButtons.getChar2ImageView().setTranslateY(-4);
                                    //scene.setRoot(questionButtons.getScene());
                                    nodesToAdd.getChildren().set(0, questionButtons.getScene());
                                    stage.show();
                                    questionMenu = "question";
                                }else if(questionMenu.equals("endText")){
                                    this.confrontationBattleScene4 = this.confrontationBattle(stage,4);
                                    stage.setScene(confrontationBattleScene4);
                                }
                            }
                        } catch (Exception e) {}
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the fifth encounter text.
     * <p>
     * This public non-static method will be used to create the text for the fifth
     * conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the second encounter of the game.
     * @throws IOException
     */
    public Scene confrontation5Text(Stage stage) throws IOException {
        health = 100;
        Scene scene;

        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[4]))), "You:", "I have something to tell you...", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        encounterTxt.getChar2ImageView().setFitWidth(110);
        encounterTxt.getChar2ImageView().setTranslateX(3);
        encounterTxt.getChar2ImageView().setTranslateY(-10);
        
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);
        
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            encounterTxt.getScene()
        );
        scene = new Scene(nodesToAdd);
        
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else {
                        scene.setCursor(Cursor.DEFAULT);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        exitGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        exitGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
    
                    if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        mainMenuGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        mainMenuGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        //this.onPauseScreen = false;
                        //System.exit(0);
                        screenNum = 6;
                        stage.setScene(this.quitGameScene);
                        stage.show();
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        screenNum = 1;
                        this.onPauseScreen = false;
                        stage.setScene(this.mainMenuScene);
                        stage.show();
                    } else {
                        int lastIndex = nodesToAdd.getChildren().size() - 1;
                        nodesToAdd.getChildren().remove(lastIndex);
                        this.onPauseScreen = false;
                        //try {
                        //    this.level1Scene = this.level1(stage);
                        //    this.level2Scene = this.level2(stage);
                        //    this.level3Scene = this.level3(stage);
                        //} catch (IOException ioe) {}
                        /*
                        Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                        Group tempGroup = new Group();
                        tempGroup.getChildren().addAll(
                            back
                        );
                        stage.setScene(new Scene(tempGroup, 600, 600));
                        return;
                        */
                    }
                }
            }
        );

        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    if (!this.onPauseScreen) {
                        try {
                            if (k.getCode() == KeyCode.ESCAPE) {
                                this.onPauseScreen = true;
                                nodesToAdd.getChildren().add(ps.getScene());
                            } else if (k.getCode() == KeyCode.SPACE) {
                                stage.setScene(confrontationBattleScene5);
                            }
                        } catch (Exception e) {}
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the second encounter text after confrontation.
     * <p>
     * This public non-static method will be used to create the text for after the
     * second conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the second encounter of the game.
     * @throws IOException
     */
    public Scene confrontation2AfterText(Stage stage) throws IOException {
        Scene scene;

        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[1]))), "Thomas:", "I'm sorry I said those things, I'm just having a really bad day.", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        encounterTxt.getChar2ImageView().setFitWidth(175);
        encounterTxt.getChar2ImageView().setTranslateX(-24);
        encounterTxt.getChar2ImageView().setTranslateY(-4);
        
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);
        
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            encounterTxt.getScene()
        );
        scene = new Scene(nodesToAdd);

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else {
                        scene.setCursor(Cursor.DEFAULT);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        exitGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        exitGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
    
                    if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        mainMenuGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        mainMenuGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        //this.onPauseScreen = false;
                        //System.exit(0);
                        screenNum = 6;
                        stage.setScene(this.quitGameScene);
                        stage.show();
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        screenNum = 1;
                        this.onPauseScreen = false;
                        stage.setScene(this.mainMenuScene);
                        stage.show();
                    } else {
                        int lastIndex = nodesToAdd.getChildren().size() - 1;
                        nodesToAdd.getChildren().remove(lastIndex);
                        this.onPauseScreen = false;
                        //try {
                        //    this.level1Scene = this.level1(stage);
                        //    this.level2Scene = this.level2(stage);
                        //    this.level3Scene = this.level3(stage);
                        //} catch (IOException ioe) {}
                        /*
                        Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                        Group tempGroup = new Group();
                        tempGroup.getChildren().addAll(
                            back
                        );
                        stage.setScene(new Scene(tempGroup, 600, 600));
                        return;
                        */
                    }
                }
            }
        );

        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    if (!this.onPauseScreen) {
                        try {
                            if (k.getCode() == KeyCode.ESCAPE) {
                                this.onPauseScreen = true;
                                nodesToAdd.getChildren().add(ps.getScene());
                            } else if (k.getCode() == KeyCode.SPACE) {
                                if(confrontations<4){
                                    stage.setScene(level2Scene);
                                }else{
                                    stage.setScene(level3Scene);
                                }
                            }
                        } catch (Exception e) {}
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }

    
    /**
     * Public non-static method used to create the third encounter text after confrontation.
     * <p>
     * This public non-static method will be used to create the text for after the
     * third conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the third encounter of the game.
     * @throws IOException
     */
    public Scene confrontation3AfterText(Stage stage) throws IOException {
        Scene scene;

        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[2]))), "Sarah:", "Thank you for playing with me!", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        encounterTxt.getChar2ImageView().setFitWidth(175);
        encounterTxt.getChar2ImageView().setTranslateX(-30);
        encounterTxt.getChar2ImageView().setTranslateY(-4);
        
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);
        
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            encounterTxt.getScene()
        );
        scene = new Scene(nodesToAdd);
        
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else {
                        scene.setCursor(Cursor.DEFAULT);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        exitGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        exitGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
    
                    if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        mainMenuGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        mainMenuGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        //this.onPauseScreen = false;
                        //System.exit(0);
                        screenNum = 6;
                        stage.setScene(this.quitGameScene);
                        stage.show();
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        screenNum = 1;
                        this.onPauseScreen = false;
                        stage.setScene(this.mainMenuScene);
                        stage.show();
                    } else {
                        int lastIndex = nodesToAdd.getChildren().size() - 1;
                        nodesToAdd.getChildren().remove(lastIndex);
                        this.onPauseScreen = false;
                        //try {
                        //    this.level1Scene = this.level1(stage);
                        //    this.level2Scene = this.level2(stage);
                        //    this.level3Scene = this.level3(stage);
                        //} catch (IOException ioe) {}
                        /*
                        Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                        Group tempGroup = new Group();
                        tempGroup.getChildren().addAll(
                            back
                        );
                        stage.setScene(new Scene(tempGroup, 600, 600));
                        return;
                        */
                    }
                }
            }
        );

        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    if (!this.onPauseScreen) {
                        try {
                            if (k.getCode() == KeyCode.ESCAPE) {
                                this.onPauseScreen = true;
                                nodesToAdd.getChildren().add(ps.getScene());
                            } else if (k.getCode() == KeyCode.SPACE) {
                                if(confrontations<4){
                                    stage.setScene(level2Scene);
                                }else{
                                    stage.setScene(level3Scene);
                                }
                            }
                        } catch (Exception e) {}
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the fourth encounter text after confrontation.
     * <p>
     * This public non-static method will be used to create the text for after the
     * fourth conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the fourth encounter of the game.
     * @throws IOException
     */
    public Scene confrontation4AfterText(Stage stage) throws IOException {
        Scene scene;

        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[3]))), "Karen:", "I'm sorry I said those things, I can't tell you what you are.", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        encounterTxt.getChar2ImageView().setFitWidth(175);
        encounterTxt.getChar2ImageView().setTranslateX(-30);
        encounterTxt.getChar2ImageView().setTranslateY(-4);
        
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);
        
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            encounterTxt.getScene()
        );
        scene = new Scene(nodesToAdd);
        
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else {
                        scene.setCursor(Cursor.DEFAULT);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        exitGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        exitGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
    
                    if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        mainMenuGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        mainMenuGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        //this.onPauseScreen = false;
                        //System.exit(0);
                        screenNum = 6;
                        stage.setScene(this.quitGameScene);
                        stage.show();
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        screenNum = 1;
                        this.onPauseScreen = false;
                        stage.setScene(this.mainMenuScene);
                        stage.show();
                    } else {
                        int lastIndex = nodesToAdd.getChildren().size() - 1;
                        nodesToAdd.getChildren().remove(lastIndex);
                        this.onPauseScreen = false;
                        //try {
                        //    this.level1Scene = this.level1(stage);
                        //    this.level2Scene = this.level2(stage);
                        //    this.level3Scene = this.level3(stage);
                        //} catch (IOException ioe) {}
                        /*
                        Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                        Group tempGroup = new Group();
                        tempGroup.getChildren().addAll(
                            back
                        );
                        stage.setScene(new Scene(tempGroup, 600, 600));
                        return;
                        */
                    }
                }
            }
        );

        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    if (!this.onPauseScreen) {
                        try {
                            if (k.getCode() == KeyCode.ESCAPE) {
                                this.onPauseScreen = true;
                                nodesToAdd.getChildren().add(ps.getScene());
                            } else if (k.getCode() == KeyCode.SPACE) {
                                if(confrontations<4){
                                    stage.setScene(level2Scene);
                                }else{
                                    stage.setScene(level3Scene);
                                }
                            }
                        } catch (Exception e) {}
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the fifth encounter text after confrontation.
     * <p>
     * This public non-static method will be used to create the text for after the
     * fifth conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the fifth encounter of the game.
     * @throws IOException
     */
    public Scene confrontation5AfterText(Stage stage) throws IOException {
        Scene scene;

        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[4]))), "Parents:", "We might need to take some time to process it but you know we love you no matter what.", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        encounterTxt.getChar2ImageView().setFitWidth(110);
        encounterTxt.getChar2ImageView().setTranslateX(3);
        encounterTxt.getChar2ImageView().setTranslateY(-10);
        
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);
        
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            encounterTxt.getScene()
        );
        scene = new Scene(nodesToAdd);
        
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else {
                        scene.setCursor(Cursor.DEFAULT);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        exitGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        exitGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
    
                    if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        mainMenuGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        mainMenuGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        //this.onPauseScreen = false;
                        //System.exit(0);
                        screenNum = 6;
                        stage.setScene(this.quitGameScene);
                        stage.show();
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        screenNum = 1;
                        this.onPauseScreen = false;
                        stage.setScene(this.mainMenuScene);
                        stage.show();
                    } else {
                        int lastIndex = nodesToAdd.getChildren().size() - 1;
                        nodesToAdd.getChildren().remove(lastIndex);
                        this.onPauseScreen = false;
                        //try {
                        //    this.level1Scene = this.level1(stage);
                        //    this.level2Scene = this.level2(stage);
                        //    this.level3Scene = this.level3(stage);
                        //} catch (IOException ioe) {}
                        /*
                        Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                        Group tempGroup = new Group();
                        tempGroup.getChildren().addAll(
                            back
                        );
                        stage.setScene(new Scene(tempGroup, 600, 600));
                        return;
                        */
                    }
                }
            }
        );

        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    if (!this.onPauseScreen) {
                        try {
                            if (k.getCode() == KeyCode.ESCAPE) {
                                this.onPauseScreen = true;
                                nodesToAdd.getChildren().add(ps.getScene());
                            } else if (k.getCode() == KeyCode.SPACE) {
                                stage.setScene(winScene);
                                this.leaderboard.addEntry(this.userName, this.score, this.startTime, LocalDateTime.now());
                            }
                        } catch (Exception e) {}
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }


    
    /**
     * Public non-static method used to create the combat element of all encounters.
     * <p>
     * This public non-static method will be used to create the game for all the 
     * conflicts. It will do this by creating aseveral GameButton instances and 
     * displaying them ConfrontationScene class which will draw a scene with the 
     * main character, the enemy, and the button or text that is being displayed.
     * It will use these buttons to get user input for the player to change forms or
     * perform actions.
     * <p>
     * Done by: Simon May 30 - June 3: 4 hours
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show a confrontation of the game.
     * @throws IOException
     */
    public Scene confrontationBattle(Stage stage, int encounterNum) throws IOException {
        health = 100;
        enemyHealth = 100;
        Scene scene;
        battleMenu = "main";
        form = "";
        
        /*Rectangle char1HealthBarFront = new Rectangle(5, 5, Paint.valueOf("yellow"));
        char1HealthBarFront.setStrokeWidth(1.0);
        char1HealthBarFront.setStroke(Paint.valueOf("black"));
        Rectangle char1HealthBarBack = new Rectangle(5, 5, Paint.valueOf("black"));
        char1HealthBarBack.setStrokeWidth(1.0);
        char1HealthBarBack.setStroke(Paint.valueOf("black"));
        Rectangle char2HealthBarFront = new Rectangle(5, 5, Paint.valueOf("yellow"));
        char2HealthBarFront.setStrokeWidth(1.0);
        char2HealthBarFront.setStroke(Paint.valueOf("black"));
        Rectangle char2HealthBarBack = new Rectangle(5, 5, Paint.valueOf("black"));
        char2HealthBarBack.setStrokeWidth(1.0);
        char2HealthBarBack.setStroke(Paint.valueOf("black"));
        
        Ellipse closeCharPlat = new Ellipse(5, 5);
        closeCharPlat.setFill(Paint.valueOf("red"));
        Ellipse farCharPlat = new Ellipse(5, 5);
        farCharPlat.setFill(Paint.valueOf("blue"));
        */
        GameButton actionButton = new GameButton(this.pressStart2PFile, "Action", 85, 470, 17);	
        	
        GameButton formButton = new GameButton(this.pressStart2PFile, "Form", 390, 470, 17);	
        	
        GameButton debateButton = new GameButton(this.pressStart2PFile, "Debate", 85, 470, 17);	
        	
        GameButton defendButton = new GameButton(this.pressStart2PFile, "Defend", 390, 470, 17);
        
        GameButton actionBackButton = new GameButton(this.pressStart2PFile, "Back", 85, 540, 17);	
        	
        GameButton defensiveButton = new GameButton(this.pressStart2PFile, "Defensive", 85, 470, 17);	
        	
        GameButton assertiveButton = new GameButton(this.pressStart2PFile, "Assertive", 390, 470, 17);	
        	
        GameButton empatheticButton = new GameButton(this.pressStart2PFile, "Empathetic", 85, 540, 17);
        
        GameButton formBackButton = new GameButton(this.pressStart2PFile, "Back", 390, 540, 17);
        
        ConfrontationScene startButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), actionButton, null, formButton, null, health, enemyHealth);                   
        if (encounterNum == 2) {
            startButtons.getChar2ImageView().setFitWidth(175);
            startButtons.getChar2ImageView().setTranslateX(-24);
            startButtons.getChar2ImageView().setTranslateY(-4);
        } else if (encounterNum == 3 || encounterNum == 4) {
            startButtons.getChar2ImageView().setFitWidth(175);
            startButtons.getChar2ImageView().setTranslateX(-30);
            startButtons.getChar2ImageView().setTranslateY(-4);
        } else if (encounterNum == 5) {
            startButtons.getChar2ImageView().setFitWidth(110);
            startButtons.getChar2ImageView().setTranslateX(3);
            startButtons.getChar2ImageView().setTranslateY(-10);
        }
        
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);
        
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            startButtons.getScene()
        );
        scene = new Scene(nodesToAdd);
        
        try{
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    
                    if (!this.onPauseScreen) {
                        if(battleMenu.equals("main")){
                            if (xVal >= actionButton.getLeftX() && xVal <= actionButton.getRightX() && yVal >= actionButton.getTopY() && yVal <= actionButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else if (xVal >= formButton.getLeftX() && xVal <= formButton.getRightX() && yVal >= formButton.getTopY() && yVal <= formButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else {
                                scene.setCursor(Cursor.DEFAULT);
                            }
                        }else if(battleMenu.equals("action")){
                            if (xVal >= debateButton.getLeftX() && xVal <= debateButton.getRightX() && yVal >= debateButton.getTopY() && yVal <= debateButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else if (xVal >= defendButton.getLeftX() && xVal <= defendButton.getRightX() && yVal >= defendButton.getTopY() && yVal <= defendButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else if (xVal >= actionBackButton.getLeftX() && xVal <= actionBackButton.getRightX() && yVal >= actionBackButton.getTopY() && yVal <= actionBackButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else {
                                scene.setCursor(Cursor.DEFAULT);
                            }
                        }else if(battleMenu.equals("form")){
                            if (xVal >= defensiveButton.getLeftX() && xVal <= defensiveButton.getRightX() && yVal >= defensiveButton.getTopY() && yVal <= defensiveButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else if (xVal >= assertiveButton.getLeftX() && xVal <= assertiveButton.getRightX() && yVal >= assertiveButton.getTopY() && yVal <= assertiveButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else if (xVal >= empatheticButton.getLeftX() && xVal <= empatheticButton.getRightX() && yVal >= empatheticButton.getTopY() && yVal <= empatheticButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else if (xVal >= formBackButton.getLeftX() && xVal <= formBackButton.getRightX() && yVal >= formBackButton.getTopY() && yVal <= formBackButton.getBottomY()) {
                                scene.setCursor(Cursor.HAND);
                            } else {
                                scene.setCursor(Cursor.DEFAULT);
                            }
                        }
                    } else {
                        if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else {
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    }
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
    
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    
                    //System.out.println(xVal + " " + yVal);
                    
                    if (!this.onPauseScreen) {
                        if(battleMenu.equals("main")){
                            if (xVal >= actionButton.getLeftX() && xVal <= actionButton.getRightX() && yVal >= actionButton.getTopY() && yVal <= actionButton.getBottomY()) {
                                actionButton.cursorOverButton();
                                //redRectangleAroundNewGameButton.setVisible(true);
                            } else {
                                actionButton.cursorNotOverButton();
                                //redRectangleAroundNewGameButton.setVisible(false);
                            }
            
                            if (xVal >= formButton.getLeftX() && xVal <= formButton.getRightX() && yVal >= formButton.getTopY() && yVal <= formButton.getBottomY()) {
                                formButton.cursorOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(true);
                            } else {
                                formButton.cursorNotOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(false);
                            }
                        }else if(battleMenu.equals("action")){
                            if (xVal >= debateButton.getLeftX() && xVal <= debateButton.getRightX() && yVal >= debateButton.getTopY() && yVal <= debateButton.getBottomY()) {
                                debateButton.cursorOverButton();
                                //redRectangleAroundNewGameButton.setVisible(true);
                            } else {
                                debateButton.cursorNotOverButton();
                                //redRectangleAroundNewGameButton.setVisible(false);
                            }
            
                            if (xVal >= defendButton.getLeftX() && xVal <= defendButton.getRightX() && yVal >= defendButton.getTopY() && yVal <= defendButton.getBottomY()) {
                                defendButton.cursorOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(true);
                            } else {
                                defendButton.cursorNotOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(false);
                            }
                            
                            if (xVal >= actionBackButton.getLeftX() && xVal <= actionBackButton.getRightX() && yVal >= actionBackButton.getTopY() && yVal <= actionBackButton.getBottomY()) {
                                actionBackButton.cursorOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(true);
                            } else {
                                actionBackButton.cursorNotOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(false);
                            }
                        }else if(battleMenu.equals("form")){
                            if (xVal >= defensiveButton.getLeftX() && xVal <= defensiveButton.getRightX() && yVal >= defensiveButton.getTopY() && yVal <= defensiveButton.getBottomY()) {
                                defensiveButton.cursorOverButton();
                                //redRectangleAroundNewGameButton.setVisible(true);
                            } else {
                                defensiveButton.cursorNotOverButton();
                                //redRectangleAroundNewGameButton.setVisible(false);
                            }
            
                            if (xVal >= assertiveButton.getLeftX() && xVal <= assertiveButton.getRightX() && yVal >= assertiveButton.getTopY() && yVal <= assertiveButton.getBottomY()) {
                                assertiveButton.cursorOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(true);
                            } else {
                                assertiveButton.cursorNotOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(false);
                            }
                            
                            if (xVal >= empatheticButton.getLeftX() && xVal <= empatheticButton.getRightX() && yVal >= empatheticButton.getTopY() && yVal <= empatheticButton.getBottomY()) {
                                empatheticButton.cursorOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(true);
                            } else {
                                empatheticButton.cursorNotOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(false);
                            }
                            
                            if (xVal >= formBackButton.getLeftX() && xVal <= formBackButton.getRightX() && yVal >= formBackButton.getTopY() && yVal <= formBackButton.getBottomY()) {
                                formBackButton.cursorOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(true);
                            } else {
                                formBackButton.cursorNotOverButton();
                                //redRectangleAroundInstructionsButton.setVisible(false);
                            }
                        }
                    } else {
                        if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                            exitGameButton.cursorOverButton();
                            //backButton.getRedRectangle().setVisible(true);
                            //redRectangleAroundBackButton.setVisible(true);
                        } else {
                            exitGameButton.cursorNotOverButton();
                            //backButton.getRedRectangle().setVisible(false);
                            //redRectangleAroundBackButton.setVisible(false);
                        }
        
                        if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                            mainMenuGameButton.cursorOverButton();
                            //backButton.getRedRectangle().setVisible(true);
                            //redRectangleAroundBackButton.setVisible(true);
                        } else {
                            mainMenuGameButton.cursorNotOverButton();
                            //backButton.getRedRectangle().setVisible(false);
                            //redRectangleAroundBackButton.setVisible(false);
                        }
                    }
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
                e -> {
                    try{
                        final double xVal = e.getX();
                        final double yVal = e.getY();
                        
                        if (!this.onPauseScreen) {
                            if(battleMenu.equals("main")){
                                if (xVal >= actionButton.getLeftX() && xVal <= actionButton.getRightX() && yVal >= actionButton.getTopY() && yVal <= actionButton.getBottomY()) {
                                    ConfrontationScene act = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), debateButton, actionBackButton, defendButton, null, health, enemyHealth);
                                    if (encounterNum == 2) {
                                        act.getChar2ImageView().setFitWidth(175);
                                        act.getChar2ImageView().setTranslateX(-24);
                                        act.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 3 || encounterNum == 4) {
                                        act.getChar2ImageView().setFitWidth(175);
                                        act.getChar2ImageView().setTranslateX(-30);
                                        act.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 5) {
                                        act.getChar2ImageView().setFitWidth(110);
                                        act.getChar2ImageView().setTranslateX(3);
                                        act.getChar2ImageView().setTranslateY(-10);
                                    }
                                    //scene.setRoot(act.getScene());
                                    nodesToAdd.getChildren().set(0, act.getScene());
                                    stage.show();
                                    battleMenu = "action";
                                } else if (xVal >= formButton.getLeftX() && xVal <= formButton.getRightX() && yVal >= formButton.getTopY() && yVal <= formButton.getBottomY()) {
                                    ConfrontationScene formSc = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), defensiveButton, empatheticButton, assertiveButton, formBackButton, health, enemyHealth);
                                    if (encounterNum == 2) {
                                        formSc.getChar2ImageView().setFitWidth(175);
                                        formSc.getChar2ImageView().setTranslateX(-24);
                                        formSc.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 3 || encounterNum == 4) {
                                        formSc.getChar2ImageView().setFitWidth(175);
                                        formSc.getChar2ImageView().setTranslateX(-30);
                                        formSc.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 5) {
                                        formSc.getChar2ImageView().setFitWidth(110);
                                        formSc.getChar2ImageView().setTranslateX(3);
                                        formSc.getChar2ImageView().setTranslateY(-10);
                                    }
                                    //scene.setRoot(formSc.getScene());
                                    nodesToAdd.getChildren().set(0, formSc.getScene());
                                    stage.show();
                                    battleMenu = "form";
                                }
                            }else if(battleMenu.equals("action")){
                                if (xVal >= debateButton.getLeftX() && xVal <= debateButton.getRightX() && yVal >= debateButton.getTopY() && yVal <= debateButton.getBottomY()) {
                                    final int damage = (int)(20*Math.random()+10);
                                    enemyHealth-=damage;
                                    if (form.equals("defensive")){
                                        block+=10;
                                    }else if (form.equals("assertive")){
                                        enemyHealth-=damage;
                                    }else if (form.equals("empathetic")){
                                        block+=damage;
                                    }
                                    Text title = new Text("Damage");
                                    title.setFont(this.getPressStart2PFont(18));
                                    title.setFill(Paint.valueOf("Black"));
                                    Text body;
                                    ConfrontationScene damageTxt;	
                                    if(form.equals("assertive")){ 
                                        damageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Damage", "You dealt "+(damage*2)+" damage and you have "+block+" block.", health, enemyHealth);
                                    }
                                    else{
                                        damageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Damage", "You dealt "+damage+" damage and you have "+block+" block.", health, enemyHealth);
                                    }	
                                    damageTxt.getTitle().setFont(damageTxt.getFontFromFile(18));	
                                    damageTxt.getTitle().setFill(Paint.valueOf("Black"));	
                                    damageTxt.getBody().setFont(damageTxt.getFontFromFile(12));	
                                    damageTxt.getBody().setFill(Paint.valueOf("Black"));
                                    if (encounterNum == 2) {
                                        damageTxt.getChar2ImageView().setFitWidth(175);
                                        damageTxt.getChar2ImageView().setTranslateX(-24);
                                        damageTxt.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 3 || encounterNum == 4) {
                                        damageTxt.getChar2ImageView().setFitWidth(175);
                                        damageTxt.getChar2ImageView().setTranslateX(-30);
                                        damageTxt.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 5) {
                                        damageTxt.getChar2ImageView().setFitWidth(110);
                                        damageTxt.getChar2ImageView().setTranslateX(3);
                                        damageTxt.getChar2ImageView().setTranslateY(-10);
                                    }
                                    //scene.setRoot(damageTxt.getScene());
                                    nodesToAdd.getChildren().set(0, damageTxt.getScene());
                                    battleMenu = "damageText";
                                    }else if(xVal >= defendButton.getLeftX() && xVal <= defendButton.getRightX() && yVal >= defendButton.getTopY() && yVal <= defendButton.getBottomY()){
                                    block+=15;
                                    if (form.equals("defensive")){
                                        block+=10;
                                    }
                                    Text title = new Text("Defend");
                                    title.setFont(this.getPressStart2PFont(18));
                                    title.setFill(Paint.valueOf("Black"));
                                    Text body = new Text("You Defended and you now have "+block+" block");
                                    body.setFont(this.getPressStart2PFont(12));
                                    body.setFill(Paint.valueOf("Black"));
                                    
                                    ConfrontationScene damageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Defend", "You defended and you now have "+block+" block", health, enemyHealth);	
                                    damageTxt.getTitle().setFont(damageTxt.getFontFromFile(18));	
                                    damageTxt.getTitle().setFill(Paint.valueOf("Black"));	
                                    damageTxt.getBody().setFont(damageTxt.getFontFromFile(12));	
                                    damageTxt.getBody().setFill(Paint.valueOf("Black"));
                                    if (encounterNum == 2) {
                                        damageTxt.getChar2ImageView().setFitWidth(175);
                                        damageTxt.getChar2ImageView().setTranslateX(-24);
                                        damageTxt.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 3 || encounterNum == 4) {
                                        damageTxt.getChar2ImageView().setFitWidth(175);
                                        damageTxt.getChar2ImageView().setTranslateX(-30);
                                        damageTxt.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 5) {
                                        damageTxt.getChar2ImageView().setFitWidth(110);
                                        damageTxt.getChar2ImageView().setTranslateX(3);
                                        damageTxt.getChar2ImageView().setTranslateY(-10);
                                    }
                                    //scene.setRoot(damageTxt.getScene());
                                    nodesToAdd.getChildren().set(0, damageTxt.getScene());
                                    
                                    battleMenu = "damageText";
                                } else if(xVal >= actionBackButton.getLeftX() && xVal <= actionBackButton.getRightX() && yVal >= actionBackButton.getTopY() && yVal <= actionBackButton.getBottomY()){
                                    ConfrontationScene mainButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), actionButton, null, formButton, null, health, enemyHealth);                   
                                    if (encounterNum == 2) {
                                        mainButtons.getChar2ImageView().setFitWidth(175);
                                        mainButtons.getChar2ImageView().setTranslateX(-24);
                                        mainButtons.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 3 || encounterNum == 4) {
                                        mainButtons.getChar2ImageView().setFitWidth(175);
                                        mainButtons.getChar2ImageView().setTranslateX(-30);
                                        mainButtons.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 5) {
                                        mainButtons.getChar2ImageView().setFitWidth(110);
                                        mainButtons.getChar2ImageView().setTranslateX(3);
                                        mainButtons.getChar2ImageView().setTranslateY(-10);
                                    }
                                    //scene.setRoot(mainButtons.getScene());
                                    nodesToAdd.getChildren().set(0, mainButtons.getScene());
                                    battleMenu = "main";
                                }
                            }else if(battleMenu.equals("form")){
                                if (xVal >= defensiveButton.getLeftX() && xVal <= defensiveButton.getRightX() && yVal >= defensiveButton.getTopY() && yVal <= defensiveButton.getBottomY()) {
                                    // Set Scene to damage text
                                    form = "defensive";
                                    block+=10;
                                    battleMenu = "damageText";
                                    
                                    Text title = new Text("Form Change");
                                    title.setFont(this.getPressStart2PFont(18));
                                    title.setFill(Paint.valueOf("Black"));
                                    Text body = new Text("You changed to "+form+" form and you have "+block+" block");
                                    body.setFont(this.getPressStart2PFont(12));
                                    body.setFill(Paint.valueOf("Black"));
                                    
                                    ConfrontationScene damageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Form Change", "You changed to "+form+" form and you have "+block+" block", health, enemyHealth);	
                                    damageTxt.getTitle().setFont(damageTxt.getFontFromFile(18));	
                                    damageTxt.getTitle().setFill(Paint.valueOf("Black"));	
                                    damageTxt.getBody().setFont(damageTxt.getFontFromFile(12));	
                                    damageTxt.getBody().setFill(Paint.valueOf("Black"));
                                    if (encounterNum == 2) {
                                        damageTxt.getChar2ImageView().setFitWidth(175);
                                        damageTxt.getChar2ImageView().setTranslateX(-24);
                                        damageTxt.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 3 || encounterNum == 4) {
                                        damageTxt.getChar2ImageView().setFitWidth(175);
                                        damageTxt.getChar2ImageView().setTranslateX(-30);
                                        damageTxt.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 5) {
                                        damageTxt.getChar2ImageView().setFitWidth(110);
                                        damageTxt.getChar2ImageView().setTranslateX(3);
                                        damageTxt.getChar2ImageView().setTranslateY(-10);
                                    }
                                    //scene.setRoot(damageTxt.getScene());
                                    nodesToAdd.getChildren().set(0, damageTxt.getScene());
                                    
                                } else if (xVal >= assertiveButton.getLeftX() && xVal <= assertiveButton.getRightX() && yVal >= assertiveButton.getTopY() && yVal <= assertiveButton.getBottomY()) {
                                    // Set Scene to damage text
                                    form = "assertive";
                                    battleMenu = "damageText";
                                    
                                    Text title = new Text("Form Change");
                                    title.setFont(this.getPressStart2PFont(18));
                                    title.setFill(Paint.valueOf("Black"));
                                    Text body = new Text("You changed to "+form+" form and you have "+block+" block");
                                    body.setFont(this.getPressStart2PFont(12));
                                    body.setFill(Paint.valueOf("Black"));
                                    
                                    ConfrontationScene damageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Form Change", "You changed to "+form+" form and you have "+block+" block", health, enemyHealth);	
                                    damageTxt.getTitle().setFont(damageTxt.getFontFromFile(18));	
                                    damageTxt.getTitle().setFill(Paint.valueOf("Black"));	
                                    damageTxt.getBody().setFont(damageTxt.getFontFromFile(12));	
                                    damageTxt.getBody().setFill(Paint.valueOf("Black"));
                                    if (encounterNum == 2) {
                                        damageTxt.getChar2ImageView().setFitWidth(175);
                                        damageTxt.getChar2ImageView().setTranslateX(-24);
                                        damageTxt.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 3 || encounterNum == 4) {
                                        damageTxt.getChar2ImageView().setFitWidth(175);
                                        damageTxt.getChar2ImageView().setTranslateX(-30);
                                        damageTxt.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 5) {
                                        damageTxt.getChar2ImageView().setFitWidth(110);
                                        damageTxt.getChar2ImageView().setTranslateX(3);
                                        damageTxt.getChar2ImageView().setTranslateY(-10);
                                    }
                                    //scene.setRoot(damageTxt.getScene());
                                    nodesToAdd.getChildren().set(0, damageTxt.getScene());
                                } else if (xVal >= empatheticButton.getLeftX() && xVal <= empatheticButton.getRightX() && yVal >= empatheticButton.getTopY() && yVal <= empatheticButton.getBottomY()) {
                                    // Set Scene to damage text
                                    form = "empathetic";
                                    battleMenu = "damageText";
                                    
                                    Text title = new Text("Form Change");
                                    title.setFont(this.getPressStart2PFont(18));
                                    title.setFill(Paint.valueOf("Black"));
                                    Text body = new Text("You changed to "+form+" form and you have "+block+" block");
                                    body.setFont(this.getPressStart2PFont(12));
                                    body.setFill(Paint.valueOf("Black"));
                                    
                                    ConfrontationScene damageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Form Change", "You changed to "+form+" form and you have "+block+" block", health, enemyHealth);	
                                    damageTxt.getTitle().setFont(damageTxt.getFontFromFile(18));	
                                    damageTxt.getTitle().setFill(Paint.valueOf("Black"));	
                                    damageTxt.getBody().setFont(damageTxt.getFontFromFile(12));	
                                    damageTxt.getBody().setFill(Paint.valueOf("Black"));
                                    if (encounterNum == 2) {
                                        damageTxt.getChar2ImageView().setFitWidth(175);
                                        damageTxt.getChar2ImageView().setTranslateX(-24);
                                        damageTxt.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 3 || encounterNum == 4) {
                                        damageTxt.getChar2ImageView().setFitWidth(175);
                                        damageTxt.getChar2ImageView().setTranslateX(-30);
                                        damageTxt.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 5) {
                                        damageTxt.getChar2ImageView().setFitWidth(110);
                                        damageTxt.getChar2ImageView().setTranslateX(3);
                                        damageTxt.getChar2ImageView().setTranslateY(-10);
                                    }
                                    //scene.setRoot(damageTxt.getScene());
                                    nodesToAdd.getChildren().set(0, damageTxt.getScene());
                                } else if(xVal >= formBackButton.getLeftX() && xVal <= formBackButton.getRightX() && yVal >= formBackButton.getTopY() && yVal <= formBackButton.getBottomY()){
                                    ConfrontationScene mainButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), actionButton, null, formButton, null, health, enemyHealth);                   
                                    if (encounterNum == 2) {
                                        mainButtons.getChar2ImageView().setFitWidth(175);
                                        mainButtons.getChar2ImageView().setTranslateX(-24);
                                        mainButtons.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 3 || encounterNum == 4) {
                                        mainButtons.getChar2ImageView().setFitWidth(175);
                                        mainButtons.getChar2ImageView().setTranslateX(-30);
                                        mainButtons.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 5) {
                                        mainButtons.getChar2ImageView().setFitWidth(110);
                                        mainButtons.getChar2ImageView().setTranslateX(3);
                                        mainButtons.getChar2ImageView().setTranslateY(-10);
                                    }
                                    //scene.setRoot(mainButtons.getScene());
                                    nodesToAdd.getChildren().set(0, mainButtons.getScene());
                                    battleMenu = "main";
                                }
                            }
                        } else {
                            if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                                //this.onPauseScreen = false;
                                //System.exit(0);
                                screenNum = 6;
                                stage.setScene(this.quitGameScene);
                                stage.show();
                            } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                                screenNum = 1;
                                this.onPauseScreen = false;
                                stage.setScene(this.mainMenuScene);
                                stage.show();
                            } else {
                                int lastIndex = nodesToAdd.getChildren().size() - 1;
                                nodesToAdd.getChildren().remove(lastIndex);
                                this.onPauseScreen = false;
                                //try {
                                //    this.level1Scene = this.level1(stage);
                                //    this.level2Scene = this.level2(stage);
                                //    this.level3Scene = this.level3(stage);
                                //} catch (IOException ioe) {}
                                /*
                                Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                                Group tempGroup = new Group();
                                tempGroup.getChildren().addAll(
                                    back
                                );
                                stage.setScene(new Scene(tempGroup, 600, 600));
                                return;
                                */
                            }
                        }
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            );
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    if (!this.onPauseScreen) {
                        try{
                            if (k.getCode() == KeyCode.ESCAPE) {
                                this.onPauseScreen = true;
                                nodesToAdd.getChildren().add(ps.getScene());
                            } else {
                                if(battleMenu.equals("damageText")){
                                    if(encounterNum==1){
                                        if(enemyHealth<=0){
                                            health = 100;
                                            confrontations += 1;
                                            score -= (100-health)/5;
                                            stage.setScene(level2Scene);
                                        }else{
                                            final int damage = (int)(10*Math.random()+10);
                                            final int damageTaken = damage-block;
                                            if(damage-block>=0){
                                                block = 0;
                                                health-=damageTaken;
                                                ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but "+block+" was blocked block so you took " + damageTaken + " damage. Press any key to continue...", health, enemyHealth);	
                                                enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                                enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                                enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                                enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                                /*
                                                if (encounterNum == 2) {
                                                    enemyDamageTxt.getChar2ImageView().setFitWidth(175);
                                                    enemyDamageTxt.getChar2ImageView().setTranslateX(-24);
                                                    enemyDamageTxt.getChar2ImageView().setTranslateY(-4);
                                                } else if (encounterNum == 3 || encounterNum == 4) {
                                                    enemyDamageTxt.getChar2ImageView().setFitWidth(175);
                                                    enemyDamageTxt.getChar2ImageView().setTranslateX(-30);
                                                    enemyDamageTxt.getChar2ImageView().setTranslateY(-4);
                                                } else if (encounterNum == 5) {
                                                    enemyDamageTxt.getChar2ImageView().setFitWidth(110);
                                                    enemyDamageTxt.getChar2ImageView().setTranslateX(3);
                                                    enemyDamageTxt.getChar2ImageView().setTranslateY(-10);
                                                }
                                                */
                                                //scene.setRoot(enemyDamageTxt.getScene());
                                                nodesToAdd.getChildren().set(0, enemyDamageTxt.getScene());
                                            }else{
                                                block-=damage;
                                                ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but all of it was blocked blocked. You now have " + block + " block. Press any key to continue...", health, enemyHealth);	
                                                enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                                enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                                enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                                enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                                /*
                                                if (encounterNum == 2) {
                                                    enemyDamageTxt.getChar2ImageView().setFitWidth(175);
                                                    enemyDamageTxt.getChar2ImageView().setTranslateX(-24);
                                                    enemyDamageTxt.getChar2ImageView().setTranslateY(-4);
                                                } else if (encounterNum == 3 || encounterNum == 4) {
                                                    enemyDamageTxt.getChar2ImageView().setFitWidth(175);
                                                    enemyDamageTxt.getChar2ImageView().setTranslateX(-30);
                                                    enemyDamageTxt.getChar2ImageView().setTranslateY(-4);
                                                } else if (encounterNum == 5) {
                                                    enemyDamageTxt.getChar2ImageView().setFitWidth(110);
                                                    enemyDamageTxt.getChar2ImageView().setTranslateX(3);
                                                    enemyDamageTxt.getChar2ImageView().setTranslateY(-10);
                                                }
                                                */
                                                //scene.setRoot(enemyDamageTxt.getScene());
                                                nodesToAdd.getChildren().set(0, enemyDamageTxt.getScene());
                                            }
                                        }
                                    }else if(encounterNum==2){
                                        if(enemyHealth<=0){
                                            confrontations += 1;
                                            if(confrontations==4){
                                                score -= (100-health)/5;
                                            }
                                            this.confrontationAfterTextScene2 = confrontation2AfterText(stage);
                                            stage.setScene(confrontationAfterTextScene2);
                                        }else{
                                            final int damage = (int)(10*Math.random()+10);
                                            final int damageTaken = damage-block;
                                            if(damage-block>=0){
                                                block = 0;
                                                health-=damageTaken;
                                                ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but "+block+" was blocked block so you took " + damageTaken + " damage. Press any key to continue...", health, enemyHealth);	
                                                enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                                enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                                enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                                enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                                enemyDamageTxt.getChar2ImageView().setFitWidth(175);
                                                enemyDamageTxt.getChar2ImageView().setTranslateX(-24);
                                                enemyDamageTxt.getChar2ImageView().setTranslateY(-4);
                                                //scene.setRoot(enemyDamageTxt.getScene());
                                                nodesToAdd.getChildren().set(0, enemyDamageTxt.getScene());
                                            }else{
                                                block-=damage;
                                                ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but all of it was blocked blocked. You now have " + block + " block. Press any key to continue...", health, enemyHealth);	
                                                enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                                enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                                enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                                enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                                enemyDamageTxt.getChar2ImageView().setFitWidth(175);
                                                enemyDamageTxt.getChar2ImageView().setTranslateX(-24);
                                                enemyDamageTxt.getChar2ImageView().setTranslateY(-4);
                                                //scene.setRoot(enemyDamageTxt.getScene());
                                                nodesToAdd.getChildren().set(0, enemyDamageTxt.getScene());
                                            }                                
                                        }
                                    }else if(encounterNum==3){
                                        if(enemyHealth<=0){
                                            confrontations += 1;
                                            if(confrontations==4){
                                                score -= (100-health)/5;
                                            }
                                            this.confrontationAfterTextScene3 = confrontation3AfterText(stage);
                                            stage.setScene(confrontationAfterTextScene3);
                                        }else{
                                            final int damage = (int)(10*Math.random()+10);
                                            final int damageTaken = damage-block;
                                            if(damage-block>=0){
                                                block = 0;
                                                health-=damageTaken;
                                                ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but "+block+" was blocked block so you took " + damageTaken + " damage. Press any key to continue...", health, enemyHealth);	
                                                enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                                enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                                enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                                enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                                enemyDamageTxt.getChar2ImageView().setFitWidth(175);
                                                enemyDamageTxt.getChar2ImageView().setTranslateX(-30);
                                                enemyDamageTxt.getChar2ImageView().setTranslateY(-4);
                                                //scene.setRoot(enemyDamageTxt.getScene());
                                                nodesToAdd.getChildren().set(0, enemyDamageTxt.getScene());
                                            }else{
                                                block-=damage;
                                                ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but all of it was blocked blocked. You now have " + block + " block. Press any key to continue...", health, enemyHealth);	
                                                enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                                enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                                enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                                enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                                enemyDamageTxt.getChar2ImageView().setFitWidth(175);
                                                enemyDamageTxt.getChar2ImageView().setTranslateX(-30);
                                                enemyDamageTxt.getChar2ImageView().setTranslateY(-4);
                                                //scene.setRoot(enemyDamageTxt.getScene());
                                                nodesToAdd.getChildren().set(0, enemyDamageTxt.getScene());
                                            }
                                        }
                                    }else if(encounterNum==4){
                                        if(enemyHealth<=0){
                                            confrontations += 1;
                                            if(confrontations==4){
                                                score -= (100-health)/5;
                                            }
                                            this.confrontationAfterTextScene4 = confrontation4AfterText(stage);
                                            stage.setScene(confrontationAfterTextScene4);
                                        }else{
                                            final int damage = (int)(10*Math.random()+10);
                                            final int damageTaken = damage-block;
                                            if(damage-block>=0){
                                                block = 0;
                                                health-=damageTaken;
                                                ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but "+block+" was blocked block so you took " + damageTaken + " damage. Press any key to continue...", health, enemyHealth);	
                                                enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                                enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                                enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                                enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                                enemyDamageTxt.getChar2ImageView().setFitWidth(175);
                                                enemyDamageTxt.getChar2ImageView().setTranslateX(-30);
                                                enemyDamageTxt.getChar2ImageView().setTranslateY(-4);
                                                //scene.setRoot(enemyDamageTxt.getScene());
                                                nodesToAdd.getChildren().set(0, enemyDamageTxt.getScene());
                                            }else{
                                                block-=damage;
                                                ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but all of it was blocked blocked. You now have " + block + " block. Press any key to continue...", health, enemyHealth);	
                                                enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                                enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                                enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                                enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                                enemyDamageTxt.getChar2ImageView().setFitWidth(175);
                                                enemyDamageTxt.getChar2ImageView().setTranslateX(-30);
                                                enemyDamageTxt.getChar2ImageView().setTranslateY(-4);
                                                //scene.setRoot(enemyDamageTxt.getScene());
                                                nodesToAdd.getChildren().set(0, enemyDamageTxt.getScene());
                                            }
                                        }
                                    }else if(encounterNum==5){
                                        if(enemyHealth<=0){
                                            confrontations = 0;
                                            score -= (100-health)/5;
                                            health = 100;
                                            enemyHealth = 100;
                                            this.winScene = this.winGame(stage);
                                            this.confrontationAfterTextScene5 = confrontation5AfterText(stage);
                                            stage.setScene(confrontationAfterTextScene5);
                                        }else{
                                            final int damage = (int)(10*Math.random()+20);
                                            final int damageTaken = damage-block;
                                            if(damage-block>=0){
                                                health-=damageTaken;
                                                ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but "+block+" was blocked block so you took " + damageTaken + " damage. Press any key to continue...", health, enemyHealth);	
                                                block = 0;
                                                enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                                enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                                enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                                enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                                enemyDamageTxt.getChar2ImageView().setFitWidth(110);
                                                enemyDamageTxt.getChar2ImageView().setTranslateX(3);
                                                enemyDamageTxt.getChar2ImageView().setTranslateY(-10);
                                                //scene.setRoot(enemyDamageTxt.getScene());
                                                nodesToAdd.getChildren().set(0, enemyDamageTxt.getScene());
                                            }else{
                                                block-=damage;
                                                ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but all of it was blocked blocked. You now have " + block + " block. Press any key to continue...", health, enemyHealth);	
                                                enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                                enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                                enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                                enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                                enemyDamageTxt.getChar2ImageView().setFitWidth(110);
                                                enemyDamageTxt.getChar2ImageView().setTranslateX(3);
                                                enemyDamageTxt.getChar2ImageView().setTranslateY(-10);
                                                //scene.setRoot(enemyDamageTxt.getScene());
                                                nodesToAdd.getChildren().set(0, enemyDamageTxt.getScene());
                                            }
                                        }
                                    }
                                    if(health<=0){
                                        stage.setScene(loseScene);    
                                        this.leaderboard.addEntry(this.userName, this.score, this.startTime, LocalDateTime.now());
                                        confrontations = 0;
                                    }else{
                                        battleMenu = "enemyText";
                                    }
                                }else if(battleMenu.equals("enemyText")){
                                    ConfrontationScene mainButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), actionButton, null, formButton, null, health, enemyHealth);
                                    if (encounterNum == 2) {
                                        mainButtons.getChar2ImageView().setFitWidth(175);
                                        mainButtons.getChar2ImageView().setTranslateX(-24);
                                        mainButtons.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 3 || encounterNum == 4) {
                                        mainButtons.getChar2ImageView().setFitWidth(175);
                                        mainButtons.getChar2ImageView().setTranslateX(-30);
                                        mainButtons.getChar2ImageView().setTranslateY(-4);
                                    } else if (encounterNum == 5) {
                                        mainButtons.getChar2ImageView().setFitWidth(110);
                                        mainButtons.getChar2ImageView().setTranslateX(3);
                                        mainButtons.getChar2ImageView().setTranslateY(-10);
                                    }        
                                    //scene.setRoot(mainButtons.getScene());
                                    nodesToAdd.getChildren().set(0, mainButtons.getScene());
                                    battleMenu = "main";
                                }
                            }
                        } catch(Exception e){}
                    }
                }
            );
        }catch(Exception e){}
        return scene;
    }

    /**
     * Public non-static method used to create the main menu for the game.
     * <p>
     * This public non-static method is void and it will be used to create the
     * instructions screen for the game. It will show the logo of the game as
     * well as instructions for the game. There will also be a "Back" button
     * that will allow the user to go back to the main menu.
     * <p>
     * Done by: Joshua
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the instructions screen.
     * @throws IOException
     */
    public Scene instructions(Stage stage) throws IOException {
        screenNum = 3;

        ImageView introBorderImageView = this.getIntroBorderImageView();

        GameTitle whiteInstructionsGameTitle = new GameTitle(this.pressStart2PFile, "Trans-form:", "Instructions", 50, 90, 24);	
        whiteInstructionsGameTitle.setWidth(300);	
        whiteInstructionsGameTitle.setSpacing(15);

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(400);
        logoImageView.setY(50);
        logoImageView.setFitWidth(150);

        Text instructionsText = new Text("\"Trans-form:The Awakening\" is a game about combating transphobia. You play as a transgender kid who has to come out to themself, confront transphobia at their school, and then come out to their parents.\n\nMove with WASD and interact with space. You can always press escape to pause the game or quit. Good luck combating transphobia!");
        instructionsText.setFont(this.getPressStart2PFont(18));
        instructionsText.setFill(Paint.valueOf("rgb(0,0,0)"));
        instructionsText.setWrappingWidth(500);
        instructionsText.setX(50);
        instructionsText.setY(250);

        GameButton backButton = new GameButton(this.pressStart2PFile, "Back", 390, 495, 18);	
        backButton.setWidth(125);	
        backButton.setTextTranslationX(1);

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            instructionsText,
            backButton.getButton(),
            whiteInstructionsGameTitle.getTitle(),
            //whiteInstructionsTitleImageView,
            logoImageView,
            introBorderImageView
        );

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else {
                    scene.setCursor(Cursor.DEFAULT);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    backButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    backButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    screenNum = 1;
                    stage.setScene(this.mainMenuScene);
                    stage.show();
                }
            }
        );

        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }
    
    public Scene writeUp(Stage stage) throws IOException {
        screenNum = 4;

        ImageView introBorderImageView = this.getIntroBorderImageView();

        GameTitle whiteWriteUpGameTitle = new GameTitle(this.pressStart2PFile, "Trans-form:", "Write-Up", 50, 40, 24);	
        whiteWriteUpGameTitle.setWidth(300);	
        whiteWriteUpGameTitle.setSpacing(15);

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(400);
        logoImageView.setY(25);
        logoImageView.setFitWidth(150);

        Text writeUpText = new Text("Trans-form is a game centered around the topic of overcoming transphobia.\n\nIn the first level, you can use WASD keys to move around and the SPACE button to pick up nine books to give you information. You can walk off the screen to travel onto another grid to find more books. When you have collected them all, a mirror image of yourself will appear in the top-left grid. You can press SPACE to interact with them and after some text and pressing SPACE again, you will be in the confrontation menu.\n\nHere in the confrontation menu, you can use your turns to change forms or perform actions. Forms include \"defensive\", which gives you block every turn which in turn shields you against damage from the enemy, \"assertive\" which doubles your damage, or \"empathetic\" which adds block for all the damage you deal. The actions include \"debate\" which deals damage to the enemy, and \"defend\" which gives you block. After you beat this you will be in level 2.\n\nHere you will have to determine if people are being transphobic or not and then battle them in the same way as level 1. After all three of the confrontations, you will be in level 3.\n\nIn level 3, you will be tasked with coming out to your parents. There will be another battle and after your parents, will need some time to get through it, but they will tell you they love you no matter what. The scoring gives you 5 points for every correct answer in level 2 and minus 1 point for every 5 damage you take in any of the levels. Good luck!");
        writeUpText.setFont(this.getPressStart2PFont(8));
        writeUpText.setFill(Paint.valueOf("rgb(0,0,0)"));
        writeUpText.setWrappingWidth(500);
        writeUpText.setLineSpacing(4);
        writeUpText.setX(50);
        writeUpText.setY(200);
        
        /*
        TextFlow writeUpTextFlow = new TextFlow();
        writeUpTextFlow.getChildren().addAll(
            writeUpText
        );
        writeUpTextFlow.setLineSpacing(10);
        tempTextFlow.setPrefWidth(this.width);
        */

        GameButton backButton = new GameButton(this.pressStart2PFile, "Back", 135, 120, 18);	
        backButton.setWidth(125);	
        backButton.setTextTranslationX(1);
        //backButton.getBackgroundRectangle().setFill(Paint.valueOf("rgba(0,0,0,0.2)"));

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            writeUpText,
            backButton.getButton(),
            whiteWriteUpGameTitle.getTitle(),
            //whiteInstructionsTitleImageView,
            logoImageView,
            introBorderImageView
        );

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else {
                    scene.setCursor(Cursor.DEFAULT);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    backButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    backButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    screenNum = 1;
                    stage.setScene(this.mainMenuScene);
                    stage.show();
                }
            }
        );

        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }

    public Scene leaderboard(Stage stage) throws IOException {
        screenNum = 5;

        ImageView introBorderImageView = this.getIntroBorderImageView();

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(400);
        logoImageView.setY(50);
        logoImageView.setFitWidth(150);

        GameTitle whiteLeaderboardGameTitle = new GameTitle(this.pressStart2PFile, "Trans-form:", "Leaderboard", 50, 90, 24);	
        whiteLeaderboardGameTitle.setWidth(300);	
        whiteLeaderboardGameTitle.setSpacing(15);

        Rectangle scoresBackground = new Rectangle(100, 225, 400, 250);
        scoresBackground.setFill(Paint.valueOf("rgb(193,154,107)"));
        scoresBackground.setStrokeType(StrokeType.OUTSIDE);
        scoresBackground.setStrokeWidth(10.0);
        scoresBackground.setStroke(Paint.valueOf("rgb(66,47,33)"));
        scoresBackground.setStrokeLineJoin(StrokeLineJoin.ROUND);

        //String [][] leaderboardData = this.leaderboard.getLeaderboard();
        //System.out.println(Arrays.deepToString(leaderboardData));
        
        /*
        GridPane leaderboardValuesToAdd = new GridPane();
        
        int currentLevel = 0;
        
                
        Label [][] displayedLeaderboard = new Label[10][4];
        for (int i = 0; i < displayedLeaderboard.length; i++) {
            for (int j = 0; j < displayedLeaderboard[i].length; j++) {
                displayedLeaderboard[i][j] = new Label(leaderboardData[i][j]);// + " " + leaderboardData[i][1]+ " " + leaderboardData[i][2] + " " + leaderboardData[i][3]);
                displayedLeaderboard[i][j].setFont(this.getPressStart2PFont(12));
                displayedLeaderboard[i][j].setStyle("-fx-background-color: rgb(193,154,107); -fx-text-fill: black;");
                //displayedLeaderboard[i][j].setTextFill(Paint.valueOf("rgb(255,255,255)"));
                //displayedLeaderboard[i][j].setFill(Paint.valueOf("rgb(255,255,255)"));
                //displayedLeaderboard[i].setPrefWidth(400);
                //displayedLeaderboard[i].setTranslateX(100);
                //displayedLeaderboard[i].setTranslateY(225 + i * 15);
                //Pane tempPane = new Pane(displayedLeaderboard[i][j]);
                //if (i % 2 == 1) tempPane.setStyle("-fx-background-color: rgb(143,114,57)");
                leaderboardValuesToAdd.add(displayedLeaderboard[i][j], j, i);//, 1, 1);
            }
        }
        */
        
        GameButton upButton = new GameButton(this.pressStart2PFile, "Up", 525, 275, 16);
        upButton.setWidth(50);
        //GameButton upArrowButton = new GameButton(this.pressStart2PFile, new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x94, (byte)0xBC}, Charset.forName("UTF-8")), 100, 50, 16);
        GameButton downButton = new GameButton(this.pressStart2PFile, "Down", 525, 375, 10);
        downButton.setWidth(50);
        downButton.setTextTranslationY(5);
        
        /*
        if (leaderboard.length == 10) {
            
        }
        */

        //Leaderboard leaderboard = new Leaderboard();
        //Text scoresText = new Text(leaderboard.getLeaderboard());
        //scoresText.setFill(Paint.valueOf("white"));

        GameButton backButton = new GameButton(this.pressStart2PFile, "Back", 390, 495, 18);	
        backButton.setWidth(125);	
        backButton.setTextTranslationX(1);
        
        //leaderboardValuesToAdd.setAlignment(Pos.CENTER);
        /*
        leaderboardValuesToAdd = this.leaderboard.getLeaderboardGridPane();
        leaderboardValuesToAdd.setVgap(12);
        leaderboardValuesToAdd.setHgap(8);
        leaderboardValuesToAdd.setTranslateX(105);
        leaderboardValuesToAdd.setTranslateY(230);
        */
        //displayedLeaderboard[0][0] = new Label("100");
        this.leaderboard.initializeLeaderboardTextFlow();
        TextFlow leaderboardTextFlow = this.leaderboard.getLeaderboardTextFlow();
        leaderboardTextFlow.setLineSpacing(13);
        leaderboardTextFlow.setTranslateX(105);
        leaderboardTextFlow.setTranslateY(233);
        

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            backButton.getButton(),
            upButton.getButton(),
            downButton.getButton(),
            //scoresText,
            scoresBackground,
            whiteLeaderboardGameTitle.getTitle(),
            logoImageView,
            introBorderImageView,
            //leaderboardValuesToAdd
            leaderboardTextFlow
            
        );
        /*
        for (int i = 0; i < displayedLeaderboard.length; i++) {
            nodesToAdd.getChildren().add(displayedLeaderboard[i]);
        }
        */

        this.leaderboard.saveData();
        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= upButton.getLeftX() && xVal <= upButton.getRightX() && yVal >= upButton.getTopY() && yVal <= upButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= downButton.getLeftX() && xVal <= downButton.getRightX() && yVal >= downButton.getTopY() && yVal <= downButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else {
                    scene.setCursor(Cursor.DEFAULT);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                
                if (xVal >= upButton.getLeftX() && xVal <= upButton.getRightX() && yVal >= upButton.getTopY() && yVal <= upButton.getBottomY()) {
                    upButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    upButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }
                
                if (xVal >= downButton.getLeftX() && xVal <= downButton.getRightX() && yVal >= downButton.getTopY() && yVal <= downButton.getBottomY()) {
                    downButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    downButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    backButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    backButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }
            }
        );
        
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= upButton.getLeftX() && xVal <= upButton.getRightX() && yVal >= upButton.getTopY() && yVal <= upButton.getBottomY()) {
                    /*
                    if (currentLevel > 0) {
                        currentLevel--;
                        for (int i = 0; i < displayedLeaderboard.length - 1; i++) {
                            displayedLeaderboard[i] = displayedLeaderboard[i + 1];
                        }
                    }
                    */
                    
                    this.leaderboard.moveUpLeaderboard();
                    TextFlow tempTextFlow = this.leaderboard.getLeaderboardTextFlow();
                    nodesToAdd.getChildren().set(nodesToAdd.getChildren().size() - 1, tempTextFlow);
                    /*
                    this.leaderboard.moveUpLeaderboard();
                    GridPane tempLeaderboardValuesToAdd = this.leaderboard.getLeaderboardGridPane();
                    tempLeaderboardValuesToAdd.setVgap(12);
                    tempLeaderboardValuesToAdd.setHgap(8);
                    tempLeaderboardValuesToAdd.setTranslateX(105);
                    tempLeaderboardValuesToAdd.setTranslateY(230);
                    nodesToAdd.getChildren().set(nodesToAdd.getChildren().size() - 1, tempLeaderboardValuesToAdd);
                    */
                    //nodesToAdd.getChildren().set(nodesToAdd.getChildren().size() - 1, this.leaderboard.getLeaderboardGridPane(this.pressStart2PFile, "rgba(0,0,0,0)", "rgb(0,0,0)"));
                    //leaderboardValuesToAdd = this.leaderboard.getLeaderboardGridPane(this.pressStart2PFile, "rgba(0,0,0,0)", "rgb(0,0,0)");
                    //leaderboardValuesToAdd.moveUpLeaderboard();
                    //leaderboardValuesToAdd = leaderboardValuesToAdd.getLeaderboardGridPane();
                } else if (xVal >= downButton.getLeftX() && xVal <= downButton.getRightX() && yVal >= downButton.getTopY() && yVal <= downButton.getBottomY()) {
                
                    this.leaderboard.moveDownLeaderboard();
                    TextFlow tempTextFlow = this.leaderboard.getLeaderboardTextFlow();
                    nodesToAdd.getChildren().set(nodesToAdd.getChildren().size() - 1, tempTextFlow);
                    /*
                    this.leaderboard.moveDownLeaderboard();
                    GridPane tempLeaderboardValuesToAdd = this.leaderboard.getLeaderboardGridPane();
                    tempLeaderboardValuesToAdd.setVgap(12);
                    tempLeaderboardValuesToAdd.setHgap(8);
                    tempLeaderboardValuesToAdd.setTranslateX(105);
                    tempLeaderboardValuesToAdd.setTranslateY(230);
                    nodesToAdd.getChildren().set(nodesToAdd.getChildren().size() - 1, tempLeaderboardValuesToAdd);
                    */
                    //nodesToAdd.getChildren().set(nodesToAdd.getChildren().size() - 1, this.leaderboard.getLeaderboardGridPane(this.pressStart2PFile, "rgba(0,0,0,0)", "rgb(0,0,0)"));
                    //leaderboardValuesToAdd = this.leaderboard.getLeaderboardGridPane(this.pressStart2PFile, "rgba(0,0,0,0)", "rgb(0,0,0)");
                    //System.out.println("Yo");
                } else if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    this.leaderboard.initializeLeaderboardTextFlow();
                    TextFlow tempTextFlow = this.leaderboard.getLeaderboardTextFlow();
                    nodesToAdd.getChildren().set(nodesToAdd.getChildren().size() - 1, tempTextFlow);
                    /*
                    this.leaderboard.resetCurrentLevel();
                    GridPane tempLeaderboardValuesToAdd = this.leaderboard.getLeaderboardGridPane();
                    tempLeaderboardValuesToAdd.setVgap(12);
                    tempLeaderboardValuesToAdd.setHgap(8);
                    tempLeaderboardValuesToAdd.setTranslateX(105);
                    tempLeaderboardValuesToAdd.setTranslateY(230);
                    nodesToAdd.getChildren().set(nodesToAdd.getChildren().size() - 1, tempLeaderboardValuesToAdd);
                    */
                    screenNum = 1;
                    stage.setScene(this.mainMenuScene);
                    stage.show();
                }
            }
        );

        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }

    /**
     * Public non-static method used to create the quit game screen for the game.
     * <p>
     * This public non-static method is void and it will be used to create the
     * quit game screen for the game. This screen will show the user the logo
     * of the game as well as text saying who made this game. They will also
     * have a button that they can press to leave the game.
     * <p>
     * Done by: Joshua
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the quit game screen.
     * @throws IOException
     */
    public Scene quitGame(Stage stage) throws IOException {
        screenNum = 6;

        ImageView introBorderImageView = this.getIntroBorderImageView();

        GameTitle whiteQuitGameGameTitle = new GameTitle(this.pressStart2PFile, "Trans-form:", "Quit Game", 50, 90, 24);	
        whiteQuitGameGameTitle.setWidth(300);	
        whiteQuitGameGameTitle.setSpacing(15);

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(400);
        logoImageView.setY(50);
        logoImageView.setFitWidth(150);

        Text quitGameText = new Text("Thank you for playing Trans-form: The Awakening!\n\nThis game was made by Simon Bakan and Joshua Persaud (with a special thanks to Valentina Krasteva).\n\n");
        quitGameText.setFont(this.getPressStart2PFont(24));
        quitGameText.setFill(Paint.valueOf("rgb(0,0,0)"));
        quitGameText.setWrappingWidth(500);
        quitGameText.setX(50);
        quitGameText.setY(250);

        GameButton exitButton = new GameButton(this.pressStart2PFile, "Exit Game", 85, 495, 11);	
        exitButton.setWidth(125);	
        exitButton.setTextTranslationX(-1);	
        exitButton.setTextTranslationY(4);	
        	
        GameButton backButton = new GameButton(this.pressStart2PFile, "Back", 390, 495, 18);	
        backButton.setWidth(125);	
        backButton.setTextTranslationX(1);

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            quitGameText,
            exitButton.getButton(),
            backButton.getButton(),
            whiteQuitGameGameTitle.getTitle(),
            //whiteInstructionsTitleImageView,
            logoImageView,
            introBorderImageView
        );

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else {
                    scene.setCursor(Cursor.DEFAULT);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    backButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    backButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }

                if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    exitButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    exitButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    screenNum = 1;
                    stage.setScene(this.mainMenuScene);
                    stage.show();
                } else if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    System.exit(0);
                }
            }
        );


        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }
    
    /**
     * Public non-static method used to create the win game screen for the game.
     * <p>
     * This public non-static method is void and it will be used to create the
     * win game screen for the game. They will also have a button that they can 
     * press to leave the game or to go back to main.
     * <p>
     * Done by: Simon
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the win game screen.
     * @throws IOException
     */
    public Scene winGame(Stage stage) throws IOException {
        screenNum = 7;

        ImageView introBorderImageView = this.getIntroBorderImageView();

        GameTitle whiteWinGameGameTitle = new GameTitle(this.pressStart2PFile, "Trans-form:", "You won!", 50, 90, 24);	
        whiteWinGameGameTitle.getSubheadingText().setFill(Paint.valueOf("Green"));
        whiteWinGameGameTitle.setWidth(300);	
        whiteWinGameGameTitle.setSpacing(15);

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(400);
        logoImageView.setY(50);
        logoImageView.setFitWidth(150);

        Text quitGameText = new Text("Thank you for playing Trans-form: The Awakening!\n\nThis game was made by Simon Bakan and Joshua Persaud (with a special thanks to Valentina Krasteva).\n\n Your Score was "+score);
        quitGameText.setFont(this.getPressStart2PFont(24));
        quitGameText.setFill(Paint.valueOf("rgb(0,0,0)"));
        quitGameText.setWrappingWidth(500);
        quitGameText.setX(50);
        quitGameText.setY(250);

        GameButton exitButton = new GameButton(this.pressStart2PFile, "Exit Game", 85, 495, 11);	
        exitButton.setWidth(125);	
        exitButton.setTextTranslationX(-1);	
        exitButton.setTextTranslationY(4);	
        	
        GameButton backButton = new GameButton(this.pressStart2PFile, "Menu", 390, 495, 18);	
        backButton.setWidth(125);	
        backButton.setTextTranslationX(1);

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            quitGameText,
            exitButton.getButton(),
            backButton.getButton(),
            whiteWinGameGameTitle.getTitle(),
            //whiteInstructionsTitleImageView,
            logoImageView,
            introBorderImageView
        );

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else {
                    scene.setCursor(Cursor.DEFAULT);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    backButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    backButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }

                if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    exitButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    exitButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    screenNum = 1;
                    try{
                        //this.level1Scene = this.level1(stage);
                        //this.level2Scene = this.level2(stage);
                        //this.level3Scene = this.level3(stage);
                        this.health = 100;
                        this.enemyHealth = 100;
                        this.score = 0;
                    }catch(Exception x){}
                    stage.setScene(this.mainMenuScene);
                    stage.show();
                } else if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    System.exit(0);
                }
            }
        );


        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }
    
    
    
    /**
     * Public non-static method used to create the lose game screen for the game.
     * <p>
     * This public non-static method is void and it will be used to create the
     * lose game screen for the game. They will also have a button that they can 
     * press to leave the game or to go back to main.
     * <p>
     * Done by: Simon
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the lose game screen.
     * @throws IOException
     */
    public Scene loseGame(Stage stage) throws IOException {
        screenNum = 7;

        ImageView introBorderImageView = this.getIntroBorderImageView();

        GameTitle whiteLoseGameGameTitle = new GameTitle(this.pressStart2PFile, "Trans-form:", "You lost :(", 50, 90, 24);	
        whiteLoseGameGameTitle.getSubheadingText().setFill(Paint.valueOf("Red"));
        whiteLoseGameGameTitle.setWidth(300);	
        whiteLoseGameGameTitle.setSpacing(15);

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(400);
        logoImageView.setY(50);
        logoImageView.setFitWidth(150);

        Text quitGameText = new Text("Thank you for playing Trans-form: The Awakening!\n\nThis game was made by Simon Bakan and Joshua Persaud (with a special thanks to Valentina Krasteva).\n\n");
        quitGameText.setFont(this.getPressStart2PFont(24));
        quitGameText.setFill(Paint.valueOf("rgb(0,0,0)"));
        quitGameText.setWrappingWidth(500);
        quitGameText.setX(50);
        quitGameText.setY(250);

        GameButton exitButton = new GameButton(this.pressStart2PFile, "Exit Game", 85, 495, 11);	
        exitButton.setWidth(125);	
        exitButton.setTextTranslationX(-1);	
        exitButton.setTextTranslationY(4);	
        	
        GameButton backButton = new GameButton(this.pressStart2PFile, "Menu", 390, 495, 18);	
        backButton.setWidth(125);	
        backButton.setTextTranslationX(1);

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            quitGameText,
            exitButton.getButton(),
            backButton.getButton(),
            whiteLoseGameGameTitle.getTitle(),
            //whiteInstructionsTitleImageView,
            logoImageView,
            introBorderImageView
        );

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else {
                    scene.setCursor(Cursor.DEFAULT);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    backButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    backButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }

                if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    exitButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    exitButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    screenNum = 1;
                    try{
                        //this.level1Scene = this.level1(stage);
                        //this.level2Scene = this.level2(stage);
                        //this.level3Scene = this.level3(stage);
                        this.health = 100;
                        this.enemyHealth = 100;
                        this.score = 0;
                    }catch(Exception x){}
                    stage.setScene(this.mainMenuScene);
                    stage.show();
                } else if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    System.exit(0);
                }
            }
        );


        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }

    /**
     * Public non-static method used to run the entire GUI.
     * <p>
     * This public non-static method is void and it will be used to run the
     * various methods that each do a section of the overall game. This
     * method is overriding the start() method that is present in the
     * Application.java class.
     * <p>
     * Done by: Joshua
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        this.health = 100;
        this.enemyHealth = 100;
        this.score = 0;
        this.initializeStageSettings(stage);
        this.introAnimationScene = this.introAnimation(stage);
        this.mainMenuScene = this.mainMenu(stage);
        this.instructionsScene = this.instructions(stage);
        this.writeUpScene = this.writeUp(stage);
        this.leaderboardScene = this.leaderboard(stage);
        this.level1Scene = this.level1(stage);
        this.level2Scene = this.level2(stage);
        this.level3Scene = this.level3(stage);
        //stage.setScene(this.confrontation2Text(stage));
        this.confrontationTextScene1 = this.confrontation1Text(stage);
        this.confrontationTextScene5 = this.confrontation5Text(stage);
        this.confrontationBattleScene1 = this.confrontationBattle(stage,1);
        this.confrontationBattleScene5 = this.confrontationBattle(stage,5);
        this.quitGameScene = this.quitGame(stage);
        this.loseScene = this.loseGame(stage);

        this.screenNum = 0;
        this.confrontations = 0;
        stage.setScene(this.introAnimationScene);
        
        
        /*
        Rectangle clearOverlay = new Rectangle(600, 600, Paint.valueOf("rgba(0,0,0,0.1)"));
        
        Rectangle leftRectPauseButton = new Rectangle(225, 100, 25, 175);
        leftRectPauseButton.setFill(Paint.valueOf("rgb(255,255,255)"));
        leftRectPauseButton.setStroke(Paint.valueOf("rgb(0,0,0)"));
        leftRectPauseButton.setStrokeWidth(3.0);
        
        Rectangle rightRectPauseButton = new Rectangle(325, 100, 25, 175);
        rightRectPauseButton.setFill(Paint.valueOf("rgb(255,255,255)"));
        rightRectPauseButton.setStroke(Paint.valueOf("rgb(0,0,0)"));
        rightRectPauseButton.setStrokeWidth(3.0);
        
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        exitGameButton.setWidth(200);
        exitGameButton.setHeight(60);
        exitGameButton.setTextTranslationY(5);
        
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        mainMenuGameButton.setWidth(200);
        mainMenuGameButton.setHeight(60);
        mainMenuGameButton.setTextTranslationY(5);
        
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            background,
            clearOverlay,
            leftRectPauseButton,
            rightRectPauseButton,
            exitGameButton.getButton(),
            mainMenuGameButton.getButton()
        );
        */
        /*
        Rectangle background = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
        GameButton exitGameButton = new GameButton(this.pressStart2PFile, "Exit Game", 50, 400, 17);
        GameButton mainMenuGameButton = new GameButton(this.pressStart2PFile, "Main Menu", 350, 400, 17);
        
        PauseScene ps = new PauseScene(this.pressStart2PFile, exitGameButton, mainMenuGameButton);
        
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            background
            //ps.getScene()
        );
        
        Scene scene = new Scene(nodesToAdd, 600, 600);
        
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        scene.setCursor(Cursor.HAND);
                    } else {
                        scene.setCursor(Cursor.DEFAULT);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                
                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        exitGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        exitGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
    
                    if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        mainMenuGameButton.cursorOverButton();
                        //backButton.getRedRectangle().setVisible(true);
                        //redRectangleAroundBackButton.setVisible(true);
                    } else {
                        mainMenuGameButton.cursorNotOverButton();
                        //backButton.getRedRectangle().setVisible(false);
                        //redRectangleAroundBackButton.setVisible(false);
                    }
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (this.onPauseScreen){
                    if (xVal >= exitGameButton.getLeftX() && xVal <= exitGameButton.getRightX() && yVal >= exitGameButton.getTopY() && yVal <= exitGameButton.getBottomY()) {
                        //this.onPauseScreen = false;
                        System.exit(0);
                    } else if (xVal >= mainMenuGameButton.getLeftX() && xVal <= mainMenuGameButton.getRightX() && yVal >= mainMenuGameButton.getTopY() && yVal <= mainMenuGameButton.getBottomY()) {
                        screenNum = 1;
                        this.onPauseScreen = false;
                        stage.setScene(this.mainMenuScene);
                        stage.show();
                    } else {
                        int lastIndex = nodesToAdd.getChildren().size() - 1;
                        nodesToAdd.getChildren().remove(lastIndex);
                        this.onPauseScreen = false;
                        //Rectangle back = new Rectangle(600, 600, Paint.valueOf("rgb(255,0,0)"));
                        //Group tempGroup = new Group();
                        //tempGroup.getChildren().addAll(
                        //    back
                        //);
                        //stage.setScene(new Scene(tempGroup, 600, 600));
                        //return;
                    }
                }
            }
        );
        
        scene.addEventFilter(KeyEvent.KEY_PRESSED,
            k -> {
                if (!this.onPauseScreen && k.getCode() == KeyCode.ESCAPE) {
                    this.onPauseScreen = true;
                    nodesToAdd.getChildren().add(ps.getScene());
                }
            }
        );
        
        stage.setScene(scene);
        */
        
        //stage.setScene(this.leaderboard(stage));
        
        //stage.setScene(confrontation1Text(stage));
        
        /*
        this.leaderboardScene = this.leaderboard(stage);
        this.writeUpScene = this.writeUp(stage);
        this.level1Scene = this.level1(stage);
        this.level2Scene = this.level2(stage);
        this.level3Scene = this.level3(stage);
        this.confrontationTextScene1 = this.confrontation1Text(stage);
        this.confrontationTextScene5 = this.confrontation5Text(stage);
        this.confrontationBattleScene1 = this.confrontationBattle(stage,1);
        this.confrontationBattleScene5 = this.confrontationBattle(stage,5);
        this.quitGameScene = this.quitGame(stage);
        */

        /*
        //GameButton test = new GameButton("New Game", pressStart2PFile, 24, "white", "black", 50, 50, 210, 75, 0, 0);
        //GameTitle test = new GameTitle(pressStart2PFile, "Trans-form:", 24, "black", "Instructions", 24, "blue", 100, 50, 10, 0, 2);
        //Rectangle rect = new Rectangle(50, 50, 1, 1);
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            //test.getButton()
            //rect
            test.getTitle()
        );
        Scene scene = new Scene(nodesToAdd, 600, 600);
        //scene.setFill(Color.BLACK);
        stage.setScene(scene);
        */
        
        /*
        ImageView mainChar = new ImageView(new Image(new FileInputStream(new File("MainChar.png"))));
        ImageView mainCharV2 = new ImageView(new Image(new FileInputStream(new File("MainChar.png"))));
        mainCharV2.setScaleY(-1.0);
        ImageView background = new ImageView(new Image(new FileInputStream(new File("Background.png"))));
        GameButton test1 = new GameButton("Test", this.pressStart2PFile, 24, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        GameButton test2 = new GameButton("Test", this.pressStart2PFile, 24, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        GameButton test3 = new GameButton("Test", this.pressStart2PFile, 24, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        GameButton test4 = new GameButton("Test", this.pressStart2PFile, 24, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        
        ConfrontationScene cs = new ConfrontationScene(this.pressStart2PFile, background, mainChar, mainCharV2, test1, test2, test3, test4, new Rectangle(500, 200, Paint.valueOf("grey")), "red", "blue", false, 0.0, 0.0);
        // Paint closeEllipsePaint, Paint farEllipsePaint, boolean setHealth, double healthChar1, double healthChar2
        */
        
        /*
        ImageView background = new ImageView(new Image(new FileInputStream(new File("Water.png"))));
        ImageView mainChar = new ImageView(new Image(new FileInputStream(new File("MainChar.png"))));
        ImageView mainCharV2 = new ImageView(new Image(new FileInputStream(new File("MainChar.png"))));
        mainCharV2.setScaleX(-1.0);
        Ellipse closeCharPlat = new Ellipse(5, 5);
        closeCharPlat.setFill(Paint.valueOf("red"));
        Ellipse farCharPlat = new Ellipse(5, 5);
        farCharPlat.setFill(Paint.valueOf("blue"));
        Rectangle rect = new Rectangle(5, 5, Paint.valueOf("blue"));
        rect.setStrokeWidth(3.0);
        rect.setStroke(Paint.valueOf("black"));
        GameButton test1 = new GameButton("Top Left Button", this.pressStart2PFile, 15, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        GameButton test2 = new GameButton("Bottom Left Button", this.pressStart2PFile, 15, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        GameButton test3 = new GameButton("Top Right Button", this.pressStart2PFile, 15, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        GameButton test4 = new GameButton("Bottom Right Button", this.pressStart2PFile, 15, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        Rectangle char1HealthBarFront = new Rectangle(5, 5, Paint.valueOf("yellow"));
        char1HealthBarFront.setStrokeWidth(1.0);
        char1HealthBarFront.setStroke(Paint.valueOf("black"));
        Rectangle char1HealthBarBack = new Rectangle(5, 5, Paint.valueOf("black"));
        char1HealthBarBack.setStrokeWidth(1.0);
        char1HealthBarBack.setStroke(Paint.valueOf("black"));
        Rectangle char2HealthBarFront = new Rectangle(5, 5, Paint.valueOf("yellow"));
        char2HealthBarFront.setStrokeWidth(1.0);
        char2HealthBarFront.setStroke(Paint.valueOf("black"));
        Rectangle char2HealthBarBack = new Rectangle(5, 5, Paint.valueOf("black"));
        char2HealthBarBack.setStrokeWidth(1.0);
        char2HealthBarBack.setStroke(Paint.valueOf("black"));
        //mainCharV2.setTranslateX(0);
        //ImageView background = new ImageView(new Image(new FileInputStream(new File("RedBackgroundRectangle.svg"))));
        //ImageView background = new ImageView("https://upload.wikimedia.org/wikipedia/commons/e/e6/Red_rectangle.svg");
        ConfrontationScene cs = new ConfrontationScene(this.pressStart2PFile, background, closeCharPlat, farCharPlat, mainChar, mainCharV2, rect, test1, test2, test3, test4, 50, char1HealthBarFront, char1HealthBarBack, 50, char2HealthBarFront, char2HealthBarBack);
        
        Scene scene = cs.getScene();
        stage.setScene(scene);
        */
        
        /*
        GameButton backButton = new GameButton(this.pressStart2PFile, "Back", 0, 0, 17);
        //BookScene firstBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "What is transphobia?", "Transphobia is caused by a person being harmful and negative towards a transgender person on the basis of them being transgender.\n\nThis issue can also be seen as systemic because of how people are not taught that gender is actually fluid and not as rigid as being only male or only female.", true, backButton, 11);
        //BookScene secondBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "How do I come out to my parents/friends?", "Coming out as a trans person is never an easy task. Here are some things to know before coming out:\n\n- It should be done when you feel safe coming out and it is useful to think through how you are going to do it\n\n- People might need some time to process the information\n\n- The majority of people will be accepting of your outcoming", false, backButton, 4.25);
        //BookScene thirdBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "What are common types of transphobia?", "Transphobia is very common in our everyday lives. Some examples are:\n\n- Using derogatory terms against trans people.\n\n- Excluding transgender people on the basis of their sexuality\n\n- Refusing to use proper pronouns", false, backButton, 12);
        //BookScene fourthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "What are common types of transphobia?", "More examples of transphobia are:\n\n- Not using a trans person’s preferred name\n\n- Bullying a trans person because they are transgender\n\n- Spreading misinformation about trans people (such as by saying that they are in a \"teenage phase\")", true, backButton, 11);
        //BookScene fifthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "How do you combat transphobia?", "A proactive approach is needed to help combat the transphobia that is prevalent within our society.\n\nSome steps you can take are to:\n\n- Recognize and confront internal transphobia\n\n- Call out those who are not using someone’s preferred pronouns or name", false, backButton, 9);
        //BookScene sixthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "How do you combat transphobia?", "More steps that you can take are:\n\n- Ask people for their pronouns (you can also use generalized pronouns like they/them)\n\n- Avoid using slurs against trans people\n\n- Call out those that are making transphobic jokes or remarks", true, backButton, 11);
        //BookScene seventhBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "Statistics on transgender people", "The topic of transgender people has been buzzing for some time now. It is important to know the facts about trans people to get a better understanding of why they are in such dire need.\n\nSome important statistics are:\n\n- 22% - 43% of transgender people have attempted suicide in their lives\n\n- 67% of transgender people have thought less about suicide after transitioning whereas 3% of transgender people have thought about suicide more.", true, backButton, 2.5);
        //BookScene eighthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "Statistics on transgender people", "Here are some more stats on trans people:\n\n- 15 percent of transgender-related online posts are transphobic\n\n- Over one in four transgender people have lost a job due to bias in their workplace\n\n- One in five transgender people have been homeless at least once in their life\n\n- Over one in ten transgender people have been evicted from their homes as a result of being transgender", false, backButton, 3.5);
        //BookScene ninthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "What should I do if I am being bullied?", "If you are being bullied on the basis of being transgender, then you should talk to your friends about it (they will help support you in your outcoming)\n\nIf you are ever feeling suicidal, know that there are still people who love you. You should also call your local suicide hotline, such as 833-456-4566 for the Canada Suicide Prevention Service.", true, backButton, 7.5);
        Scene scene = new Scene(firstBookScene.getScene(), 600, 600);
        stage.setScene(scene);
        */
        
        /*
        Dialog testD = new Dialog();
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            testD.getDialogPane()
        );
        Scene scene = new Scene(nodesToAdd, 600, 600);
        stage.setScene(scene);
        */
        /*
        ButtonType okButton = new ButtonType.OK;
        Dialog<String> dialog = new Dialog<String>();
        dialog.getDialogPane().getButtonTypes().add(okButton);
        boolean disabled = false;
        dialog.getDialogPane().lookupButton(okButton).setDisable(disabled);
        */
        
        /*
        Text text = new Text("asdkj;fk;asdjf;lkaskl;dfj;ajsddfk;jass;fj");
        text.setFont(this.getPressStart2PFont(18));
        text.setFill(Paint.valueOf("rgb(255,255,255)"));
        text.setX(50);
        text.setY(50);
        */
        /*
        text.addEventFilter(KeyEvent.KEY_PRESSED,
            k -> {
                System.out.println("LOL");
                try {
                    boolean shiftIsPressed = k.isShiftDown();
                    if (k.getCode().isDigitKey() || (k.getCode().isLetterKey() && k.getCode() != KeyCode.COMMA) || k.getCode() == KeyCode.BACK_SPACE) {
                        System.out.println(k.getCode().getChar());
                        System.out.println("Yo");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        );
        */
        
        /*
        Rectangle testRectangle = new Rectangle(600, 600, Paint.valueOf("green"));
        Group nodesToAddTemp = new Group();
        nodesToAddTemp.getChildren().addAll(
            testRectangle
        );
        Scene secondScene = new Scene(nodesToAddTemp, 600, 600);
        
        
        Rectangle background = new Rectangle(600, 600, Paint.valueOf("rgb(0,0,0)"));
        //Leaderboard test = new Leaderboard(new File("Leaderboard.txt"));
        //System.out.println(Arrays.deepToString(test.getLeaderboard()));
        
        //Rectangle inputBox = new 
        
        TextField testTF = new TextField();
        testTF.setFont(this.getPressStart2PFont(18));
        testTF.setPromptText("First Name");
        testTF.setFocusTraversable(false);
        //testTF.setPrefWidth(500);
        //testTF.setPrefHeight(50);
        //Rectangle backgroundRectangle = new Rectangle(500, 50, Paint.valueOf("rgb(255,255,255)"));
        //backgroundRectangle.setStroke(Paint.valueOf("rgb(255,0,0)"));
        //backgroundRectangle.setStrokeWidth(3.0);
        //testTF.setShape(backgroundRectangle);
        
        
        
        testTF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String buttonText = testTF.getText();
                if (!buttonText.isEmpty()) {
                    System.out.println(buttonText);
                    stage.setScene(secondScene);
                }
            }
        });
        
        
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            background,
            //text
            testTF
        );
        
        Scene scene = new Scene(nodesToAdd, 600, 600);
        */
        /*
        scene.addEventFilter(KeyEvent.KEY_PRESSED,
            k -> {
                try {
                    boolean shiftIsPressed = k.isShiftDown();
                    if (!text.getText().isEmpty() && k.getCode() == KeyCode.BACK_SPACE) {
                        text.setText(text.getText().substring(0, text.getText().length() - 1));
                    } else if (k.getCode().isDigitKey() || (k.getCode().isLetterKey() && k.getCode() != KeyCode.COMMA) || (k.getCode().isWhitespaceKey() && k.getCode() != KeyCode.TAB)) {
                        //String characterToAdd = k.getCode().getChar();
                        //if (k.);
                        text.setText(text.getText().concat(k.getCode().getChar()));
                        System.out.println(k.getCharacter());
                    }
                    if (k.getCode().isDigitKey() || (k.getCode().isLetterKey() && k.getCode() != KeyCode.COMMA) || k.getCode() == KeyCode.BACK_SPACE) {
                        System.out.println(k.getCode().getChar());
                        //System.out.println("Yo");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        );
        */
        //stage.setScene(scene);
        
        //GameButton backButton = new GameButton(this.pressStart2PFile, "Back", 0, 0, 17);
        
        /*
        BookScene firstBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene1Image.png"))), "What is transphobia?", "Transphobia is caused by a person being harmful and negative towards a transgender person on the basis of them being transgender.\n\nThis issue can also be seen as systemic because of how people are not taught that gender is actually fluid and not as rigid as being only male or only female.", true, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 11);
        BookScene secondBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene2Image.png"))), "How do I come out to my parents/friends?", "Coming out as a trans person is never an easy task. Here are some things to know before coming out:\n\n- It should be done when you feel safe coming out and it is useful to think through how you are going to do it\n\n- People might need some time to process the information\n\n- The majority of people will be accepting of your outcoming", false, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 4.25);
        BookScene thirdBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene3Image.png"))), "What are common types of transphobia?", "Transphobia is very common in our everyday lives. Some examples are:\n\n- Using derogatory terms against trans people.\n\n- Excluding transgender people on the basis of their sexuality\n\n- Refusing to use proper pronouns", false, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 12);
        BookScene fourthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene4Image.png"))), "What are common types of transphobia?", "More examples of transphobia are:\n\n- Not using a trans person's preferred name\n\n- Bullying a trans person because they are transgender\n\n- Spreading misinformation about trans people (such as by saying that they are in a \"teenage phase\")", true, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 11);
        BookScene fifthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene5Image.png"))), "How do you combat transphobia?", "A proactive approach is needed to help combat the transphobia that is prevalent within our society.\n\nSome steps you can take are to:\n\n- Recognize and confront internal transphobia\n\n- Call out those who are not using someone's preferred pronouns or name", false, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 9);
        BookScene sixthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene6Image.png"))), "How do you combat transphobia?", "More steps that you can take are:\n\n- Ask people for their pronouns (you can also use generalized pronouns like they/them)\n\n- Avoid using slurs against trans people\n\n- Call out those that are making transphobic jokes or remarks", true, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 11);
        BookScene seventhBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene7Image.png"))), "Statistics on transgender people", "The topic of transgender people has been buzzing for some time now. It is important to know the facts about trans people to get a better understanding of why they are in such dire need.\n\nSome important statistics are:\n\n- 22% - 43% of transgender people have attempted suicide in their lives\n\n- 67% of transgender people have thought less about suicide after transitioning whereas 3% of transgender people have thought about suicide more.", true, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 2.5);
        BookScene eighthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene8Image.png"))), "Statistics on transgender people", "Here are some more stats on trans people:\n\n- 15 percent of transgender-related online posts are transphobic\n\n- Over one in four transgender people have lost a job due to bias in their workplace\n\n- One in five transgender people have been homeless at least once in their life\n\n- Over one in ten transgender people have been evicted from their homes as a result of being transgender", false, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 3.5);
        BookScene ninthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene9Image.png"))), "What should I do if I am being bullied?", "If you are being bullied on the basis of being transgender, then you should talk to your friends about it (they will help support you in your outcoming)\n\nIf you are ever feeling suicidal, know that there are still people who love you. You should also call your local suicide hotline, such as 833-456-4566 for the Canada Suicide Prevention Service.", true, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 7.5);
        
        books[0] = firstBookScene.getScene();
        books[1] = secondBookScene.getScene();
        books[2] = thirdBookScene.getScene();
        books[3] = fourthBookScene.getScene();
        books[4] = fifthBookScene.getScene();
        books[5] = sixthBookScene.getScene();
        books[6] = seventhBookScene.getScene();
        books[7] = eighthBookScene.getScene();
        books[8] = ninthBookScene.getScene();
        */
        
        books[0] = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene1Image.png"))), "What is transphobia?", "Transphobia is caused by a person being harmful and negative towards a transgender person on the basis of them being transgender.\n\nThis issue can also be seen as systemic because of how people are not taught that gender is actually fluid and not as rigid as being only male or only female.", true, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 11);
        books[1] = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene2Image.png"))), "How do I come out to my parents/friends?", "Coming out as a trans person is never an easy task. Here are some things to know before coming out:\n\n- It should be done when you feel safe coming out and it is useful to think through how you are going to do it\n\n- People might need some time to process the information\n\n- The majority of people will be accepting of your outcoming", false, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 4.25);
        books[2] = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene3Image.png"))), "What are common types of transphobia?", "Transphobia is very common in our everyday lives. Some examples are:\n\n- Using derogatory terms against trans people.\n\n- Excluding transgender people on the basis of their sexuality\n\n- Refusing to use proper pronouns", false, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 12);
        books[3] = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene4Image.png"))), "What are common types of transphobia?", "More examples of transphobia are:\n\n- Not using a trans person's preferred name\n\n- Bullying a trans person because they are transgender\n\n- Spreading misinformation about trans people (such as by saying that they are in a \"teenage phase\")", true, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 11);
        books[4] = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene5Image.png"))), "How do you combat transphobia?", "A proactive approach is needed to help combat the transphobia that is prevalent within our society.\n\nSome steps you can take are to:\n\n- Recognize and confront internal transphobia\n\n- Call out those who are not using someone's preferred pronouns or name", false, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 9);
        books[5] = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene6Image.png"))), "How do you combat transphobia?", "More steps that you can take are:\n\n- Ask people for their pronouns (you can also use generalized pronouns like they/them)\n\n- Avoid using slurs against trans people\n\n- Call out those that are making transphobic jokes or remarks", true, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 11);
        books[6] = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene7Image.png"))), "Statistics on transgender people", "The topic of transgender people has been buzzing for some time now. It is important to know the facts about trans people to get a better understanding of why they are in such dire need.\n\nSome important statistics are:\n\n- 22% - 43% of transgender people have attempted suicide in their lives\n\n- 67% of transgender people have thought less about suicide after transitioning whereas 3% of transgender people have thought about suicide more.", true, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 2.5);
        books[7] = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene8Image.png"))), "Statistics on transgender people", "Here are some more stats on trans people:\n\n- 15 percent of transgender-related online posts are transphobic\n\n- Over one in four transgender people have lost a job due to bias in their workplace\n\n- One in five transgender people have been homeless at least once in their life\n\n- Over one in ten transgender people have been evicted from their homes as a result of being transgender", false, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 3.5);
        books[8] = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("BookScene9Image.png"))), "What should I do if I am being bullied?", "If you are being bullied on the basis of being transgender, then you should talk to your friends about it (they will help support you in your outcoming)\n\nIf you are ever feeling suicidal, know that there are still people who love you. You should also call your local suicide hotline, such as 833-456-4566 for the Canada Suicide Prevention Service.", true, new GameButton(this.pressStart2PFile, "Back", 0, 0, 17), 7.5);
        
        
        stage.show();
    }

    private ImageView getIntroBorderImageView() {
        ImageView introBorderImageView = new ImageView(new Image(introBorderFile.getPath()));
        introBorderImageView.setPreserveRatio(true);
        introBorderImageView.setSmooth(true);
        introBorderImageView.setX(0);
        introBorderImageView.setY(0);
        introBorderImageView.setFitWidth(600);
        return introBorderImageView;
    }

    private Font getPressStart2PFont(double fontSize) {
        Font fontFont = new Font(1); // It doesn't matter what size font I put, so I will default it to 1.
        try {
            FileInputStream fontFIS = new FileInputStream(this.pressStart2PFile);
            fontFont = Font.loadFont(fontFIS, fontSize);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return fontFont;
    }

    // This is the main method, which is public, static, and has a void return type. This will be used to execute the program.

    /**
     * Public static method used to run program.
     * <p>
     * This is the main method, which is a public static method
     * that will be used to execute the program.
     *
     * @param args Arguments from the command line.
     */
    public static void main(String[] args) {
        Application.launch(args);
    } // End of the main() method
} // End of the MainApplication.java class