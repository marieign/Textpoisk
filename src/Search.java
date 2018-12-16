// The class that handles the search query
// Notice that I've commented out some parts that show errors

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextPane;


public class Search {

    public static String path;
    public static String qri;

    public Search(String dTestFileDAT, String qry) {
        path = dTestFileDAT;
        qri = qry;
    }

    public static JTextPane resultJTextPane;
    public static List<String> linesToPresent = new ArrayList<String>();

    public static List<String> searchFile(String path, String match){

        File f = new File(path);
        FileReader fr;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            do{
                line = br.readLine();
                Pattern p = Pattern.compile(match);
                Matcher m = p.matcher(line);
                if(m.find())
                    linesToPresent.add(line);
            } while(line != null);

            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // resultJTextPane = new JTextPane();
        // resultJTextPane = (JTextPane) Home.BulletinsJPanel.add(linesToPresent);

        return linesToPresent;
    }
}

    // This handles the click event to take the query. Notice that I've commented out some parts that show errors
    private void mouseClickedSearch(java.awt.event.MouseEvent evt) {
        Search fs = new Search("/D:/TestFile.dat/", "Text to search for");

        // searchResultsJPanel.add(Search.searchFile("/D:/TestFile.dat/", "COLE"));
        // searchResultsJTextField.add(fs);
    }