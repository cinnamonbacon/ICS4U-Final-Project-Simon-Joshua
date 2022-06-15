import java.io.File; // Imports the File.java class, which allows the program to access files on the computer, such as images.
import java.io.IOException; // Imports the IOException.java class, which allows the program to deal with and catch any errors thrown during reading of IO.
import java.io.FileInputStream; // Imports the FileInputStream.java class, which allows the program to easily read in data from certain files.
import java.io.PrintWriter; // Imports the PrintWriter.java class, which allows the program to write data to a certain file.
import java.io.FileReader; // Imports the FileReader.java class, which allows the program to read data from a certain file using a subclass of the Reader.java class.
import java.io.BufferedReader; // Imports the BufferedReader.java class, which allows the program to read data at a much faster rate due to the buffering that is proved by this class.
import java.util.ArrayList; // Imports the ArrayList.java class, which allows the program to have access to the ArrayList datatype (which is a resizable array).
import java.time.LocalDateTime; // Imports the LocalDateTime.java class, which allows the program to have access to the current time.
import java.time.Period; // Imports the Period.java class, which allows the program to calculate the difference in LocalDateTime instances on a larger duration (so days and up).
import java.time.Duration; // Imports the Duration.java class, which allows the program to calculate the difference in LocalDateTime instances on a smaller duration (so hours and lower).
import java.time.temporal.ChronoUnit; // Imports the ChronoUnit.java class, which allows the program to have access to the difference of a specific unit of time between two LocalDateTime instances. 
import javafx.scene.control.Label; // Imports the Label.java class, which allows the program to have access to Labels that it can use in the leaderboard grid pane that is returned by the getLeaderboardGridPane(); method.
import javafx.scene.layout.GridPane; // Imports the GridPane.java class, which allows the program to have access to a grid layout manager.
import javafx.geometry.Pos; // Imports the Pos.java class, which allows the program to change the positioning of Nodes within layout managers (in this case, changing the positioning of Nodes within a GridPane instance).
import javafx.scene.text.Font; // Imports the Font.java class, which allows the program to create and use different fonts.
import javafx.scene.text.TextFlow; // Imports the TextFlow.java class, which allows the program to add two or more Text.java instances together.
import javafx.scene.text.Text; // Imports the Text.java class, which allows the program to take Strings of text and convert it into a good looking String for the user.
import javafx.scene.paint.Paint; // Imports the Paint.java class, which allows the program to create and use different paint colours.

/**
 * Program to create a leaderboard to keep track of scores.
 * <p>
 * This class will be used to create a leaderboard that will
 * keep track of the scores of users as well as the time that
 * it took the user to complete the level. It will have a file
 * that it stores the all the data in as well.
 * 
 * This was made fully by Joshua Persaud.
 * <p>
 * Course: ICS 4U0/P
 * <p>
 * Teacher Name: Ms. Krasteva
 * <p>
 * Purpose: to create leaderboards.
 * <p>
 * Filename: Leaderboard.java
 * 
 * @author Joshua Persaud
 * @version 6/13/2022
 * 
 * @see java.io.File
 * @see java.io.IOException
 * @see java.io.FileInputStream
 * @see java.io.PrintWriter
 * @see java.io.FileReader
 * @see java.io.BufferedReader
 * @see java.util.ArrayList
 * @see java.time.LocalDateTime
 * @see java.time.Period
 * @see java.time.Duration
 * @see java.time.temporal.ChronoUnit
 * @see javafx.scene.control.Label
 * @see javafx.scene.layout.GridPane
 * @see javafx.geometry.Pos
 * @see javafx.scene.text.Font
 * @see javafx.scene.text.TextFlow
 * @see javafx.scene.text.Text
 * @see javafx.scene.paint.Paint
 *
 * @since JDK1.17
 */
public class Leaderboard {

    /** This private non-static File variable will hold the txt file for leaderboard. */
    private File leaderboardFile;

    /** This private non-static ArrayList <String> variable will hold the names for leaderboard. */
    private ArrayList <String> names;

    /** This private non-static ArrayList <String> variable will hold the scores for leaderboard. */
    private ArrayList <Integer> scores;
    
    /** This private non-static ArrayList <String> variable will hold the start times for leaderboard. */
    private ArrayList <LocalDateTime> startTime;
    
    /** This private non-static ArrayList <String> variable will hold the end times for leaderboard. */
    private ArrayList <LocalDateTime> endTime;
    
    /** This private non-static ArrayList <String> variable will hold the time difference for leaderboard. */
    private ArrayList <Duration> diffTime;

    /** This private non-static int variable will hold the number of entries for the leaderboard. */
    private int numOfEntries;
    
    /** This private non-static String variable will hold the split character for the txt file reading. */
    private String delimiter;
    
    /** This private non-static int variable will hold the current level. */
    private int currentLevel;
    
    /** This private non-static int variable will hold the size of the leaderboard. */
    private int leaderboardSize;
    
    //private int actualLeaderboardSize;
    
    /** This private non-static File variable will hold the font file for the leaderboard. */
    private File textFontFile;
    
    /** This private non-static String variable will hold the colour name for background of the leaderboard. */
    private String backgroundPaint;
    
    /** This private non-static String variable will hold the colour name for text of the leaderboard. */
    private String textPaint;
    
    /** This private non-static double variable will hold the font size for text of the leaderboard. */
    private double fontSize;
    
    /** This private non-static variable is an array that holds String instances. This variable will be used to hold the leaderboard's data as Strings (each element will be one entry). */
    private String[] leaderboardData;
    
    /** This private non-static variable is an instance of the TextFlow.java class, and it will be used to hold onto the TextFlow that will be given to the programmer so that they can display it to the user. */
    private TextFlow leaderboardDataTextFlow;

    /**
     * An instance of the Leaderboard class will be created using this one parameter constructor.
     * 
     * @param leaderboardFile An instance of the File.java class, which will be the file that the
     *                        Leaderboard instance stores all the scores.
     */
    public Leaderboard(File leaderboardFile) {
        this.leaderboardFile = leaderboardFile;
        this.names = new ArrayList <String> ();
        this.scores = new ArrayList <Integer> ();
        this.startTime = new ArrayList <LocalDateTime> ();
        this.endTime = new ArrayList <LocalDateTime> ();
        this.diffTime = new ArrayList <Duration> ();
        this.numOfEntries = 0;
        this.delimiter = ",";
        this.currentLevel = 0;
        this.leaderboardSize = 10;
        this.textFontFile = null;
        this.backgroundPaint = "rgba(0,0,0,0)";
        this.textPaint = "rgb(0,0,0)";
        this.fontSize = 11.5;
        this.leaderboardDataTextFlow = new TextFlow();
        
        try {
            if (!this.leaderboardFile.exists()) {
                this.leaderboardFile.createNewFile();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        this.readFile();
        this.leaderboardData = this.getLeaderboard();
    }
    
    /*
        Here is the file format:
        <name>,<score>,<start time>,<end time>
        Note that the delimiter can be changed
    */
    /**
     * Private non-static method used to read the data in the leaderboard text file.
     * <p>
     * This public non-static method is void and it will be used to read from
     * the leaderboard text file into the program. It will also clear the global
     * ArrayLists so that their data can be overridden with the new leaderboard
     * data.
     * 
     */
    private void readFile() {
        this.names.clear();
        this.scores.clear();
        this.startTime.clear();
        this.endTime.clear();
        this.diffTime.clear();
        this.numOfEntries = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.leaderboardFile));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] tempArr = line.split(this.delimiter);
                String tempName = tempArr[0];
                if (tempName.length() > 8) tempName = tempName.substring(0, 8);
                else if (tempName.length() == 0) tempName = "N/A";
                this.names.add(tempName);
                int tempScore = (int) Double.parseDouble(tempArr[1]);
                if (tempScore > 150) tempScore = 150;
                else if (tempScore < 0) tempScore = 0;
                this.scores.add(tempScore);
                LocalDateTime tempStartTime = LocalDateTime.parse(tempArr[2]);
                this.startTime.add(tempStartTime);
                
                LocalDateTime tempEndTime = LocalDateTime.parse(tempArr[3]);
                this.endTime.add(tempEndTime);
                
                this.diffTime.add(Duration.between(tempStartTime, tempEndTime));
                this.numOfEntries++;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("There is an issue on line "+ (this.numOfEntries + 1) + ".\nPlease make sure that you haven't interfered with the values (e.g. changing the name to having unsupported character encodings, changing the score to a very large number, or interfering with either of the LocalDateTime values)\nand/or you haven't deleted one of the delimiters.");
        }
        this.shellSort();
    }
    
    /**
     * Public non-static method used to add an entry to the leaderboard.
     * <p>
     * This public non-static method is void and it will be used to add an entry
     * to the leaderboard
     * 
     * @param name An instance of the String.java class, which is the name of the user being added.
     * @param score An integer, which is the score of the user being added.
     * @param startLDT An instance of the LocalDateTime.java class, which is the time that the user being added started.
     * @param endLDT An instance of the LocalDateTime.java class, which is the time that the user being added ended.
     */
    public void addEntry(String name, int score, LocalDateTime startLDT, LocalDateTime endLDT) {
        if (!this.names.contains(name)) {
            this.names.add(name);
            this.scores.add(score);
            this.startTime.add(startLDT);
            this.endTime.add(endLDT);
            this.diffTime.add(Duration.between(startLDT, endLDT));
            this.numOfEntries++;
            this.saveData();
        } else {
            int index = this.names.indexOf(name);
            Duration tempDifference = Duration.between(startLDT, endLDT);
            if (tempDifference.compareTo(this.diffTime.get(index)) < 0) {
                this.scores.set(index, score);
                this.startTime.set(index, startLDT);
                this.endTime.set(index, endLDT);
                this.diffTime.set(index, tempDifference);
                this.saveData();
            }
        }
        this.leaderboardData = this.getLeaderboard();
    }
    
    /**
     * Public non-static method used to save the data to the leaderboard text file.
     * <p>
     * This public non-static method is void and it will write to the leaderboard
     * text file to after sorting the entries. It will write to the file using an
     * instance of the PrintWriter.java class.
     */
    public void saveData() {
        this.shellSort();
        try {
            PrintWriter pw = new PrintWriter(this.leaderboardFile);
            for (int i = 0; i < this.numOfEntries; i++) {
                pw.println(this.names.get(i) + this.delimiter + this.scores.get(i) + this.delimiter + this.startTime.get(i) + this.delimiter + this.endTime.get(i));
            }
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Public non-static method used to sort the data in the global ArrayLists.
     * <p>
     * This public non-static method is void and it will sorting the 
     * data in the global ArrayLists using a shell sort algorithm.
     * This shell sort algorithm is modified so that it sorts based
     * on two values. It first sorts based on score, and then if two
     * players have the same score, then it sorts based on time.
     */
    private void shellSort() {
        for (int gap = this.numOfEntries / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < this.numOfEntries; i++) {
                String tempName = this.names.get(i);
                int tempScore = this.scores.get(i);
                LocalDateTime tempStartLDT = this.startTime.get(i);
                LocalDateTime tempEndLDT = this.endTime.get(i);
                Duration tempDur = this.diffTime.get(i);
                int j = i;
                while (j >= gap && (this.scores.get(j - gap) < tempScore || (this.scores.get(j - gap) == tempScore && this.diffTime.get(j - gap).compareTo(tempDur) > 0))) {
                    this.names.set(j, this.names.get(j - gap));
                    this.scores.set(j, this.scores.get(j - gap));
                    this.startTime.set(j, this.startTime.get(j - gap));
                    this.endTime.set(j, this.endTime.get(j - gap));
                    this.diffTime.set(j, this.diffTime.get(j - gap));
                    j -= gap;
                }
                this.names.set(j, tempName);
                this.scores.set(j, tempScore);
                this.startTime.set(j, tempStartLDT);
                this.endTime.set(j, tempEndLDT);
                this.diffTime.set(j, tempDur);
            }
        }
    }
    
    /**
     * Public non-static method used to get the data within the leaderboard.
     * <p>
     * This public non-static method will return an array that holds instances
     * of the String.java class. Each element in this array will hold data on the
     * user, so their ranking, their name, their score, and the amount of time
     * it took them to complete the game.
     * 
     * @return  An array that holds instances of the String.java class, which
     *          will be data from the leaderboard.
     */
    public String[] getLeaderboard() {
        this.shellSort();
        if (this.numOfEntries > 0) {
            int sizeOfArray = this.numOfEntries;
            if (sizeOfArray > 1000) sizeOfArray = 1000;
            String[] returnedArray = new String[sizeOfArray];
            for (int i = 0; i < sizeOfArray; i++) {
                String tempString = "";
                tempString += String.format("%-4s ", Integer.toString(i + 1));
                tempString += String.format("%-8s ", this.names.get(i));
                tempString += String.format("%-3s ", Integer.toString(this.scores.get(i)));
                tempString += this.LDTToString(this.startTime.get(i), this.endTime.get(i));
                returnedArray[i] = tempString;
            }
            return returnedArray;
        } else {
            return new String[0];
        }
    }
    
    /**
     * Public non-static method used to initialize the leaderboard's TextFlow instance.
     * <p>
     * This public non-static method is void and will be used to initialize
     * the TextFlow instance that is used to display the leaderboard to the
     * user.
     */
    public void initializeLeaderboardTextFlow() {
        this.currentLevel = 0;
        this.leaderboardDataTextFlow.getChildren().clear();
        if (this.leaderboardData.length != 0) {
            for (int i = 0; i < ((this.leaderboardData.length < this.leaderboardSize) ? this.leaderboardData.length : this.leaderboardSize); i++) {
                Text tempText = new Text(this.leaderboardData[i] + "\n");
                if (this.textFontFile != null) tempText.setFont(this.getFontFromFile(this.fontSize));
                else tempText.setFont(new Font(this.fontSize));
                tempText.setFill(Paint.valueOf(this.textPaint));
                this.leaderboardDataTextFlow.getChildren().add(tempText);
            }
        }
    }
    
    /**
     * Public non-static method used to get the leaderboard's TextFlow instance.
     * <p>
     * This public non-static method will return an instance of the TextFlow.java
     * class, which is the actual leaderboard but as a TextFlow so that the user
     * can see it.
     * 
     * @return  An instance of the TextFlow.java class, which is a TextFlow with
     *          all the entries in it.
     */
    public TextFlow getLeaderboardTextFlow() {
        return this.leaderboardDataTextFlow;
    }
    
    /**
     * Public non-static method used to move up a level in the leaderboard.
     * <p>
     * This public non-static method is void and is used to move up
     * a level in the TextFlow.java instance that holds the leaderboard
     * data to be shown to the user.
     */
    public void moveUpLeaderboard() {
        if (this.currentLevel > 0 && this.numOfEntries > this.leaderboardSize) {
            this.currentLevel--;
            
            Text newTopText = new Text(this.leaderboardData[this.currentLevel] + "\n");
            if (this.textFontFile != null) newTopText.setFont(this.getFontFromFile(this.fontSize));
            else newTopText.setFont(new Font(this.fontSize));
            newTopText.setFill(Paint.valueOf(this.textPaint));
            this.leaderboardDataTextFlow.getChildren().add(0, newTopText);
            
            int lastIndex = this.leaderboardDataTextFlow.getChildren().size() - 1;
            this.leaderboardDataTextFlow.getChildren().remove(lastIndex);
        }
    }
    
    /**
     * Public non-static method used to move down a level in the leaderboard.
     * <p>
     * This public non-static method is void and is used to move down
     * a level in the TextFlow.java instance that holds the leaderboard
     * data to be shown to the user.
     */
    public void moveDownLeaderboard() {
        if (this.currentLevel + this.leaderboardSize < this.numOfEntries && this.numOfEntries > this.leaderboardSize) {
            this.currentLevel++;
            
            Text newBottomText = new Text(this.leaderboardData[this.currentLevel + this.leaderboardSize - 1] + "\n");
            if (this.textFontFile != null) newBottomText.setFont(this.getFontFromFile(this.fontSize));
            else newBottomText.setFont(new Font(this.fontSize));
            newBottomText.setFill(Paint.valueOf(this.textPaint));
            this.leaderboardDataTextFlow.getChildren().add(newBottomText);
            
            this.leaderboardDataTextFlow.getChildren().remove(0);
        }
    }
    
    /**
     * Public non-static method to get the current level of the leaderboard.
     * <p>
     * This public non-static method will return an integer, which is the
     * the current level of the leaderboard.
     * 
     * @return  An integer, which is the current level of the leaderboard
     *          instance.
     */
    public int getCurrentLevel() {
        return this.currentLevel;
    }
    
    /**
     * Public non-static method used to take two LocalDateTime instances and convert the difference between them into instances of the String.java class.
     * <p>
     * This public non-static method will return an instance of the String.java
     * class, which will hold the difference between the entered start time and
     * end time (both of which are instances of the LocalDateTime.java class and
     * are passed through to the method as parameters).
     * 
     * @param startLDT An instance of the LocalDateTime.java class, which will be the start time.
     * @param endLDT An instance of the LocalDateTime.java class, which will be the end time.
     * @return  An instance of the String.java class, which is the difference between the entered
     *          start time and end time.
     */
    private String LDTToString(LocalDateTime startLDT, LocalDateTime endLDT) {
        String ans = "";
        
        Period perDiff = Period.between(startLDT.toLocalDate(), endLDT.toLocalDate());
        perDiff = perDiff.minusDays(endLDT.toLocalTime().compareTo(startLDT.toLocalTime()) >= 0 ? 0 : 1);
        Duration durDiff = Duration.between(startLDT, endLDT);
        long days = ChronoUnit.DAYS.between(startLDT, endLDT);
        
        if (days > 999) ans = "999:23:59:59:999";
        else ans = String.format("%3s:%2s:%2s:%2s:%3s", Long.toString(days), Long.toString(durDiff.toHoursPart()), Long.toString(durDiff.toMinutesPart()), Long.toString(durDiff.toSecondsPart()), Long.toString(durDiff.toMillis() % 1000)).replace(' ', '0');
        
        return ans;
    }
    
    /**
     * Public non-static method used to gather data from a specific user within the leaderboard.
     * <p>
     * This public non-static method will return an instance of the String.java class,
     * which will be the data of the user whose name has been passed through, as an
     * instance of the String.java class, as a parameter. If the user doesn't exist
     * within the database, then a message is returned saying that they don't exist
     * in the leaderboard's database.
     * 
     * @param name An instance of the String.java class, which will be the name of the
     *             user whose data has to be returned (assuming they exist in the
     *             leaderboard's database).
     * @return  An instance of the String.java class, which will contain information
     *          on the user if they exist within the database. If they don't, then 
     *          a message is returned saying that the passed name doesn't exist in
     *          the database.
     */
    public String findUser(String name) {
        String ans = "";
        
        int position = this.names.indexOf(name);
        if (position == -1) {
            ans = "That name isn't found within the database."; 
        } else {
            ans = "Rank: #" + (position + 1) + " Score: " + this.scores.get(position) + " Time: " + this.diffTime.get(position);
        }
        
        return ans;
    }
    
    /*
     * Public non-static method used to get a font of a specified size, from the file.
     * <p>
     * This public non-static method will return an instance of the Font.java class, and
     * it will be the font type that is created from the Leaderboard instance's textFontFile
     * File instance. The method will also take in a double as a parameter, and this will be
     * the font size of the desired font.
     * 
     * @param fontSize A double, which is the size of the desired font.
     * @return  An instance of the Font.java class, which is the Font that is desired at the 
     *          desired size.
     */
    public Font getFontFromFile(double fontSize) {
        Font fontFont = new Font(1); // It doesn't matter what size font I put, so I will default it to 1.
        try {
            if (this.textFontFile != null) {
                FileInputStream fontFIS = new FileInputStream(this.textFontFile);
                fontFont = Font.loadFont(fontFIS, fontSize);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return fontFont;
    }
    
    /**
     * Public non-static method to get the delimiter (the String that is used to split values in the leaderboard's database).
     * <p>
     * This public non-static method will return an instance
     * of the String.java class, which will be the String that
     * is used to split values in the leaderboard's database.
     * 
     * @return  An instance of the String.java class, which is
     *          the delimiter.
     */
    public String getDelimiter() {
        return this.delimiter;
    }
    
    /**
     * Public non-static method to set the delimiter (the String that is used to split values in the leaderboard's database).
     * <p>
     * This public non-static method is void an will take in
     * an instance of the String.java class, which will be
     * the new String that is used to split values in the
     * leaderboard's database.
     * 
     * @param newDelimiter An instance of the String.java
     *                     class, which will be the new
     *                     delimiter that is used in the
     *                     leaderboard instance's database
     *                     to split data.
     */
    public void setDelimiter(String newDelimiter) {
        this.delimiter = newDelimiter;
    }
    
    /**
     * Public non-static method to get the size of the leaderboard.
     * <p>
     * This public non-static method will return an integer, which is
     * the size of the leaderboard. This is basically returning the size
     * of the "chunks" that leaderboard is set to return, and this value
     * has a default of 10. This means that out of a 100 entry leaderboard,
     * 10 entries are returned at a time.
     * 
     * @return  An integer, which is the size of the leaderboard.
     */
    public int getLeaderboardSize() {
        return this.leaderboardSize;
    }
    
    /**
     * Public non-static method to set the size of the leaderboard.
     * <p>
     * This public non-static method is void and will take in an
     * integer, which will be the new size of the leaderboard.
     * 
     * @param newLeaderboardSize An integer, which is the new
     *                           size of the leaderboard.
     */
    public void setLeaderboardSize(int newLeaderboardSize) {
        if (newLeaderboardSize > 1 && newLeaderboardSize <= this.numOfEntries) {
            this.leaderboardSize = newLeaderboardSize;
            if (this.currentLevel + this.leaderboardSize >= this.numOfEntries) {
                this.currentLevel = this.numOfEntries - this.leaderboardSize;
            }
        }
    }
    
    /**
     * Public non-static method to get the current paint being used as the background paint for the text.
     * <p>
     * This public non-static method will return an instance of the String.java
     * class, which will be the paint that is being used as the background paint
     * but as a String.
     * 
     * @return  An instance of the String.java class, which is the paint that
     *          is being used as the background paint, but as a String.
     */
    public String getBackgroundPaint() {
        return this.backgroundPaint;
    }
    
    /**
     * Public non-static method to set the current paint being used as the background paint for the text.
     * <p>
     * This public non-static method is void and will take in an
     * instance of the String.java class, which will be the new
     * paint that will be the background paint of the text, but
     * as a String.
     * 
     * @param newBackgroundPaint An instance of the String.java
     *                           class, which will be the String
     *                           representation of the new paint
     *                           that will act as the background
     *                           paint for the text.
     */
    public void setBackgroundPaint(String newBackgroundPaint) {
        this.backgroundPaint = newBackgroundPaint;
    }
    
    /**
     * Public non-static method to get the current paint being used as the paint for the text.
     * <p>
     * This public non-static method will return an instance of the String.java
     * class, which will be the paint that is being used as the paint colour for
     * the text, but as a String.
     * 
     * @return  An instance of the String.java class, which is the paint that
     *          is being used as paint for the text, but as a String.
     */
    public String getTextPaint() {
        return this.textPaint;
    }
    
    /**
     * Public non-static method to set the current paint being used as the paint for the text.
     * <p>
     * This public non-static method is void and will take in an
     * instance of the String.java class, which will be the new
     * paint that will be the paint colour of the text, but
     * as a String.
     * 
     * @param newTextPaint An instance of the String.java
     *                     class, which will be the String
     *                     representation of the new paint
     *                     that will be the paint for the
     *                     text.
     */
    public void setTextPaint(String newTextPaint) {
        this.textPaint = newTextPaint;
    }
    
    /*
     * Public non-static method used to get the file for the font of the Leaderboard instance.
     * <p>
     * This public non-static method will return an instance of the File.java class, which will
     * be the file that holds the .ttf file that is used for the font type for the Leaderboard
     * instance's text.
     * 
     * @return  An instance of the File.java class, which will be the file for the font of the Leaderboard instance.
     */
    public File getFontFile() {
        return this.textFontFile;
    }
    
    /*
     * Public non-static method used to set the file for the font of the Leaderboard instance.
     * <p>
     * This public non-static method is void and it will take in an instance of the File.java
     * class as a parameter, which will be the new .ttf file that will be used for the font
     * type for the Leaderboard instance.
     * 
     * @param newFontFile An instance of the File.java class, which will be the new file for
     *                    the font of the Leaderboard instance.
     */
    public void setFontFile(File newFontFile) {
        this.textFontFile = newFontFile;
    }
    
    /**
     * Public non-static method to get the current font size of the text.
     * <p>
     * This public non-static method will return a double, which is the
     * font size of the text being used.
     * 
     * @return  A double, which is the font size of the text.
     */
    public double getFontSize() {
        return this.fontSize;
    }
    
    /**
     * Public non-static method to set the current font size of the text.
     * <p>
     * This public non-static method is void and will take in
     * a double as a parameter, which is the font size of the
     * text being used.
     * 
     * @param newFontSize A double, which is the new font size of the text.
     */
    public void setFontSize(double newFontSize) {
        this.fontSize = newFontSize;
    }
}