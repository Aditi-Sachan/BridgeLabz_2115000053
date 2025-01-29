public class ReplaceWord {
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        return sentence.replace(oldWord, newWord);
    }

    public static void main(String[] args) {
        String sentence = "Java is a programming language.";
        String oldWord = "Java";
        String newWord = "Python";

        System.out.println(replaceWord(sentence, oldWord, newWord));
    }
}
