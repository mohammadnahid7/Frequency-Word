import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ReadFile {
    String[] wordArr;

    public ReadFile(String fileName){
        File file = new File("src/" + fileName);
        try {
            String allContent = Files.readString(file.toPath());
            allContent = allContent.toLowerCase();
            allContent = allContent.replaceAll("[^a-zA-Z\\s]", "");
            wordArr = allContent.split("\\s+");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String[] getWordsArr(){
        return wordArr;
    }
}
