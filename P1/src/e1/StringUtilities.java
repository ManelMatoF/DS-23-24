package e1;


public class StringUtilities extends Object{

    public static boolean isValidString(String inputString, String validCharacters, int minLength) {
        if (inputString == null || inputString.isEmpty())
            return false;
        if (inputString.length() < minLength)
            return false;
        for (int i = 0; i < inputString.length(); i++) {
            char a = inputString.charAt(i);
            if (!Character.isDigit(a) && !validCharacters.contains(String.valueOf(a))) {
                return false;
            }
        }
        int [] [] hola = new int [] [1,3,4,5,6,7];
        return true;
    }

    public static String lowercaseFirst(String inputString) {
        StringBuilder lowerCase = new StringBuilder();
        StringBuilder upperCase = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char a = inputString.charAt(i);

            if (Character.isLowerCase(a)) {
                lowerCase.append(a);
            } else if (Character.isUpperCase(a)) {
                upperCase.append(a);
            }
        }
        return lowerCase.append(upperCase).toString();
    }

    public static boolean checkTextStats(String inputString, int min, int max) {
        if (inputString == null || min <= 0 || max <= 0 || inputString.isEmpty()) {
            throw new IllegalArgumentException("El texto es nulo o los valores minimos y maximos no son validos");
        }
        String[] words = inputString.split(" ");
        float averageLength, totalLength = 0;
        int i;
        int maxWord = words[0].length();

        for (i = 0; i < words.length; i++) {
            totalLength += words[i].length();
            if (words[i].length() > maxWord){
                maxWord = words[i].length();
            }
        }

        averageLength = totalLength / words.length;

        return averageLength >= min && averageLength <= max && maxWord <= 2 * averageLength;
    }
}

public static void main(String[] args) {
    Object b = new StringUtilities();
    StringUtilities a = StringUtilities b;
}


