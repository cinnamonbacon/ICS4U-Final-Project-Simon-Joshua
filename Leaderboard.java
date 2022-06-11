import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.text.Font;

public class Leaderboard {

    /** This private non-static File variable will hold the txt file for leaderboard. */
    private File leaderboardFile;

    /** This private non-static ArrayList <String> variable will hold the name for leaderboard. */
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
    
    /** This private String variable will hold the colour name for background of the leaderboard. */
    private String backgroundPaint;
    
    /** This private String variable will hold the colour name for text of the leaderboard. */
    private String textPaint;
    
    /** This private double variable will hold the font size for text of the leaderboard. */
    private double fontSize;

    /**
     * An instance of the Leaderboard class will be created using this parameter constructor.
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
        this.fontSize = 12.0;
        
        try {
            if (!leaderboardFile.exists()) {
                leaderboardFile.createNewFile();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        this.readFile();
        //if (this.numOfEntries < this.leaderboardSize) this.actualLeaderboardSize = this.numOfEntries;
        //else this.actualLeaderboardSize = this.leaderboardSize;
    }
    
    /*
        Here is the file format:
        <name>,<score>,<start time>,<end time>
    */
    
    /**
     * Public non-static method used to read file.
     * <p>
     * This public non-static method is void and it will be used to red from
     * the text file into the program.
     * 
     */
    private void readFile() {
        this.names.clear();
        this.scores.clear();
        this.startTime.clear();
        this.endTime.clear();
        this.diffTime.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.leaderboardFile));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] tempArr = line.split(",");
                this.names.add(tempArr[0]);
                this.scores.add(Integer.parseInt(tempArr[1]));
                LocalDateTime tempStartTime = LocalDateTime.parse(tempArr[2]);
                this.startTime.add(tempStartTime);
                
                LocalDateTime tempEndTime = LocalDateTime.parse(tempArr[3]);
                this.endTime.add(tempEndTime);
                
                this.diffTime.add(Duration.between(tempStartTime, tempEndTime));
                this.numOfEntries++;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        this.shellSort();
    }
    
    /**
     * Public non-static method used to add an entry to the leaderboard.
     * <p>
     * This public non-static method is void and it will be used to add an entry
     * to the leaderboard
     * 
     * @param name String for the name of the user
     * @param startLDT LocalDateTime for the start time.
     * @param endLDT LocalDateTime for the end time.
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
        //if (this.numOfEntries < this.leaderboardSize) this.leaderboardSize = this.numOfEntries;
        //else this.leaderboardSize = 
    }
    
    /**
     * Public non-static method used to save the data to the text file.
     * <p>
     * This public non-static method is void and it will write to the text file
     * to after sorting the entries.
     */
    public void saveData() {
        this.shellSort();
        try {
            PrintWriter pw = new PrintWriter(this.leaderboardFile);
            for (int i = 0; i < this.numOfEntries; i++) {
                pw.println(this.names.get(i) + "," + this.scores.get(i) + "," + this.startTime.get(i) + "," + this.endTime.get(i));
            }
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Public non-static method used to save the data to the text file.
     * <p>
     * This public non-static method is void and it will sort sorting the 
     * entries of the leaderboard using the shell sort algorithm.
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
                while (j >= gap && (this.scores.get(j - gap) < tempScore || (this.scores.get(j - gap) == tempScore && this.diffTime.get(j - gap).compareTo(tempDur) < 0))) {
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
     * Public non-static method used to access the leaderboard.
     * <p>
     * This public non-static method will be used as an accessor method to get
     * the entries of the leaderboard in a 2d String array.
     * 
     * @return String[][] The elements of the leaderboard in a 2d String array.
     */
    public String[][] getLeaderboard() {
        this.shellSort();
        String[][] returnedArray = new String[this.numOfEntries][4];
        for (int i = 0; i < this.numOfEntries; i++) {
            returnedArray[i][0] = Integer.toString(i + 1);
            returnedArray[i][1] = this.names.get(i);
            returnedArray[i][2] = Integer.toString(this.scores.get(i));
            returnedArray[i][3] = this.LDTToString(this.startTime.get(i), this.endTime.get(i));
        }
        return returnedArray;

        /*
        ArrayList<String> data = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader (new FileInputStream (this.leaderboardFile));
            String line = "";
            while ((line = br.readLine()) != null) {
                line.replace
                data.add(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return data.toArray();
        */
    }
    
    /**
     * Public non-static method used to get a GridPane of the leaderboard.
     * <p>
     * This public non-static method will be used to get graphics of the leaderboard
     * in a GridPane.
     * 
     * @return GridPane The elements of the leaderboard.
     */
    public GridPane getLeaderboardGridPane() {
        String [][] leaderboardData = this.getLeaderboard();
        GridPane gridPaneToReturn = new GridPane();
        
        // The first ternary operator checks to see if the number of entries in the file is less than the size of the leaderboard, and if it is, then start counting from 0. If not, then start counting at whatever the current level is.
        // The second ternary operator checks to see if the number of entries in the file is less than the size of the leaderboard, and it if is, then end the counting at the length of the array of data (so however many lines there are). If not, then end the counting at whatever the current level plus the expected size of the leaderboard is.
        for (int i = ((this.numOfEntries <= this.leaderboardSize) ? 0 : this.currentLevel); i < ((this.numOfEntries <= this.leaderboardSize) ? leaderboardData.length : this.currentLevel + this.leaderboardSize); i++) {
            for (int j = 0; j < leaderboardData[i].length; j++) {
                Label tempLabel = new Label(leaderboardData[i][j]);
                if (this.textFontFile != null) tempLabel.setFont(this.getFontFromFile(this.fontSize));
                else tempLabel.setFont(new Font(this.fontSize));
                tempLabel.setStyle("-fx-background-color: " + this.backgroundPaint + "; -fx-text-fill: " + this.textPaint + ";");
                // The ternary operator checks to see if the number of entries in the file is less than the size of the leaderboard, and if it is, then don't subtract anything from the row coordinate. If not, then subtract the current level from the row coordinate.
                gridPaneToReturn.add(tempLabel, j, i - ((this.numOfEntries <= this.leaderboardSize) ? 0 : this.currentLevel));
            }
        }
        gridPaneToReturn.setAlignment(Pos.CENTER);
        return gridPaneToReturn;
    }
    
    /**
     * Public non-static method used to get go up in the leaderboard.
     * <p>
     * This public non-static method will be used to traverse the leaderboard
     * by going up a level of the leaderboard.
     */
    public void moveUpLeaderboard() {
        if (this.currentLevel > 0 && this.numOfEntries > this.leaderboardSize) {
            this.currentLevel--;
        }
    }
    
    /**
     * Public non-static method used to get go down in the leaderboard.
     * <p>
     * This public non-static method will be used to traverse the leaderboard
     * by going down a level of the leaderboard.
     */
    public void moveDownLeaderboard() {
        if (this.currentLevel + this.leaderboardSize < this.numOfEntries && this.numOfEntries > this.leaderboardSize) {
            this.currentLevel++;
        }
    }
    
    /**
     * Public non-static method used to get a turn the times into Strings.
     * <p>
     * This public non-static method will be used to turn the star and end
     * times into a String.
     * @param startLDT LocalDateTime of the start time.
     * @param endLDT LocalDateTime of the end time.
     * @return String for the times.
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
     * Public non-static method find a user in the leaderboard.
     * <p>
     * This public non-static method will be used to find a user in
     * the leaderboard given a name.
     * @param name A String with the name of the user.
     * @return String the information about the user.
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
    
    /**
     * Public non-static method to get the font.
     * <p>
     * This public non-static method will be used access the font
     * file of the leaderboard.
     * @param fontSize A double for the size of the font.
     * @return Font the font of the leaderboard.
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
     * Public non-static method to get the delimiter.
     * <p>
     * This public non-static method will be used access the delimiter
     * of the leaderboard.
     * @return String the delimiter.
     */
    public String getDelimiter() {
        return this.delimiter;
    }
    
    /**
     * Public non-static method to set the delimiter.
     * <p>
     * This public non-static method will be used change the delimiter
     * of the leaderboard.
     * @param newDelimiter String for the delimiter.
     */

    public void setDelimiter(String newDelimiter) {
        this.delimiter = newDelimiter;
    }
    
    /**
     * Public non-static method to get the currentLevel.
     * <p>
     * This public non-static method will be used access the currentLevel
     * of the leaderboard.
     * @return int the currentLevel.
     */
    public int getCurrentLevel() {
        return this.currentLevel;
    }
    
    /**
     * Public non-static method to get the leaderboardSize.
     * <p>
     * This public non-static method will be used access the leaderboardSize
     * of the leaderboard.
     * @return int the leaderboardSize.
     */
    public int getLeaderboardSize() {
        return this.leaderboardSize;
    }
    
    /**
     * Public non-static method to set the leaderboardSize.
     * <p>
     * This public non-static method will be used change the leaderboardSize
     * of the leaderboard.
     * @param newLeaderboardSize int for the leaderboardSize.
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
     * Public non-static method to reset the currentLevel.
     * <p>
     * This public non-static method will be used access the currentLevel
     * of the leaderboard.
     */
    public void resetCurrentLevel() {
        this.currentLevel = 0;
    }
    
    /*
    public String getBackgroundPaint() {
        return this.backgroundPaint;
    }
    */
    
    /**
     * Public non-static method to set the backgroundPaint.
     * <p>
     * This public non-static method will be used change the backgroundPaint
     * of the leaderboard.
     * @param newBackgroundPaint String for the backgroundPaint.
     */
    public void setBackgroundPaint(String newBackgroundPaint) {
        this.backgroundPaint = newBackgroundPaint;
    }
    
    /*
    public String getTextPaint() {
        return this.textPaint;
    }
    */
    
    /**
     * Public non-static method to set the textPaint.
     * <p>
     * This public non-static method will be used change the textPaint
     * of the leaderboard.
     * @param newTextPaint String for the textPaint.
     */
    public void setTextPaint(String newTextPaint) {
        this.textPaint = newTextPaint;
    }
     /*
    public File getFontFile() {
        return this.textFontFile;
    }
    */
    
    /**
     * Public non-static method to set the textFontFile.
     * <p>
     * This public non-static method will be used change the textFontFile
     * of the leaderboard.
     * @param newFontFile File for the textFontFile.
     */
    public void setFontFile(File newFontFile) {
        this.textFontFile = newFontFile;
    }
    /*
    public double getFontSize() {
        return this.fontSize;
    }
    */
    
    /**
     * Public non-static method to set the fontSize.
     * <p>
     * This public non-static method will be used change the fontSize
     * of the leaderboard.
     * @param newFontSize double for the fontSize.
     */
    public void setFontSize(double newFontSize) {
        this.fontSize = newFontSize;
    }
}