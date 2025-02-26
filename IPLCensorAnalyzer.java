import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class IPLCensorAnalyzer {
    public static void main(String[] args) {
        processJSON("ipl_data.json", "censored_ipl_data.json");
        processCSV("ipl_data.csv", "censored_ipl_data.csv");
    }

    private static void processJSON(String inputFile, String outputFile) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(inputFile)));
            JSONArray jsonArray = new JSONArray(content);
            
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject match = jsonArray.getJSONObject(i);
                match.put("team1", censorTeamName(match.getString("team1")));
                match.put("team2", censorTeamName(match.getString("team2")));
                match.put("winner", censorTeamName(match.getString("winner")));
                match.put("player_of_match", "REDACTED");
                
                JSONObject score = match.getJSONObject("score");
                JSONObject censoredScore = new JSONObject();
                for (String key : score.keySet()) {
                    censoredScore.put(censorTeamName(key), score.getInt(key));
                }
                match.put("score", censoredScore);
            }
            
            Files.write(Paths.get(outputFile), jsonArray.toString(4).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            
            String header = br.readLine();
            bw.write(header + "\n");
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                values[1] = censorTeamName(values[1]);
                values[2] = censorTeamName(values[2]);
                values[5] = censorTeamName(values[5]);
                values[6] = "REDACTED";
                
                bw.write(String.join(",", values) + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String censorTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            return words[0] + " ***";
        }
        return teamName;
    }
}
