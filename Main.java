import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        ReadFile readFile = new ReadFile("text.txt");
//        System.out.println(Arrays.toString(readFile.getWordsArr()));
        String[] wordArr = readFile.getWordsArr();

        int minLen = 5;

        ST st = new ST();
        int cnt = 0;
        for (int i = 0; i < wordArr.length; i++){
            String word = wordArr[i];
            if (word.length() < minLen) continue;
            if (st.contains(word)) {
                st.put(word, st.get(word) + 1);
            }
            else {
                st.put(word, 1);
            }
            if (Objects.equals(word, "shall")){
                cnt++;
            }
        }

        String max = "";
        st.put(max, 0);
        for (String word : st) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        System.out.println("From Symbol Table: " + max + " " + st.get(max));
        System.out.println("From normal word count: " + "shall " + cnt);

    }
}