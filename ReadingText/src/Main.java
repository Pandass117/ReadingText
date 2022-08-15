import java.io.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> lines = new ArrayList<>();
        String line;
        FileWriter fw = new FileWriter("ProgrammingHistoryOut.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        while ((line = br.readLine()) != null){
            lines.add(line);
            bw.write(line+"\r");
        }

        bw.close();
        br.close();

        System.out.println(findCaseSensitive("program", lines));
        System.out.println(findNotCase("program", lines));


    }

    //Requires: Arraylist of strings, text to have correct casing
    //Modifies: this
    //Effects: return arraylist of indexes of lines that have the string text in them
    private static ArrayList<Integer> findCaseSensitive(String text, ArrayList<String> lines){
        ArrayList<Integer> indexes = new ArrayList<>();

        for(int lineNum = 0; lineNum<lines.size(); lineNum++){
            if (lines.get(lineNum).contains(text)) {
                indexes.add(lineNum);
            }

        }


        return indexes;


    }

    //Requires: Arraylist of strings
    //Modifies: this
    //Effects: return arraylist of indexes of lines that have the string text in them in any casing
    private static ArrayList<Integer> findNotCase(String text, ArrayList<String> lines){
        ArrayList<Integer> indexes = new ArrayList<>();

        for(int lineNum = 0; lineNum<lines.size(); lineNum++){
            if (lines.get(lineNum).toLowerCase().contains(text.toLowerCase())) {
                indexes.add(lineNum);
            }

        }


        return indexes;


    }


}
