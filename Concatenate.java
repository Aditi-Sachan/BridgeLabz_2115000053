class Concatenate {
    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();

        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] input = {"Hello", " ", "World", "!"};
        String result = concatenateStrings(input);
        System.out.println("Concatenated String: " + result);
    }
}
