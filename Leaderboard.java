import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Duration;

public class Leaderboard {

    private File leaderboardFile;

    private ArrayList < String > names;

    private ArrayList < Integer > scores;
    
    private ArrayList < LocalDateTime > startTime;
    
    private ArrayList < LocalDateTime > endTime;
    
    private ArrayList < Duration > diffTime;

    private int numOfEntries;

    public Leaderboard(File leaderboardFile) {
        this.leaderboardFile = leaderboardFile;
        this.names = new ArrayList < String > ();
        this.scores = new ArrayList < Integer > ();
        this.startTime = new ArrayList < LocalDateTime > ();
        this.endTime = new ArrayList < LocalDateTime > ();
        this.diffTime = new ArrayList < Duration > ();
        this.numOfEntries = 0;

        try {
            if (!leaderboardFile.exists()) {
                leaderboardFile.createNewFile();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        this.readFile();
    }

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
                String[] tempArr = line.split('\u0000' + "");
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
    }

    public void addEntry(String name, int score, LocalDateTime startLDT, LocalDateTime endLDT) {
        this.names.add(name);
        this.scores.add(score);
        this.startTime.add(startLDT);
        this.endTime.add(endLDT);
        this.diffTime.add(Duration.between(startLDT, endLDT));
        this.saveData();
    }

    public void saveData() {
        this.shellSort();
        try {
            PrintWriter pw = new PrintWriter(this.leaderboardFile);
            for (int i = 0; i < this.numOfEntries; i++) {
                pw.println(this.names.get(i) + '\u0000' + this.scores.get(i) + '\u0000' + this.startTime.get(i) + '\u0000' + this.endTime.get(i));
            }
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

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


    public String[][] getLeaderboard() {
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
    
    private String LDTToString(LocalDateTime startLDT, LocalDateTime endLDT) {
        String ans = "";
        
        Period perDiff = Period.between(startLDT.toLocalDate(), endLDT.toLocalDate());
        perDiff = perDiff.minusDays(endLDT.toLocalTime().compareTo(startLDT.toLocalTime()) >= 0 ? 0 : 1);
        Duration durDiff = Duration.between(startLDT, endLDT);
        
        if (perDiff.getYears() > 0) ans = "364:23:59:59:999";
        else ans = String.format("%d:%d:%d:%d:%d", perDiff.getDays(), durDiff.toHoursPart(), durDiff.toMinutesPart(), durDiff.toSecondsPart(), durDiff.toMillisPart());
        
        return ans;
    }
}