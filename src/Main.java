import java.util.HashMap;
import java.util.Map;

public class Main {
    static String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing " +
            "elit, sed do eiusmod tempor incididunt ut labore et dolore magna " +
            "aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
            "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure " +
            "dolor in reprehenderit in voluptate velit esse cillum dolore eu " +
            "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non " +
            "proident, sunt in culpa qui officia deserunt mollit anim id est laborum";

    public static void main(String[] args) {
        Map<Character, Integer> loremMap = new HashMap<>();

        for (int i = 0; i < lorem.length(); i++) {
            char key = lorem.charAt(i);
            if (!loremMap.containsKey(key)) {
                loremMap.put(key, 1);
            } else {
                int value = loremMap.remove(key);
                loremMap.put(key, value + 1);
            }
        }

        System.out.println("\n" + "Буквы, которые встречаются реже всего - " +
                minLetter(loremMap) + " раз(а):");
        for (char key : loremMap.keySet()) {
            if (loremMap.get(key) == minLetter(loremMap)) {
                System.out.print(key + " ");
            }
        }
        System.out.println();

        System.out.println("\n" + "Буквы, которые встречаются чаще всего - " +
                maxLetter(loremMap) + " раз(а):");
        for (char key : loremMap.keySet()) {
            if (loremMap.get(key) == maxLetter(loremMap)) {
                System.out.print(key + " ");
            }
        }
        System.out.println();

    }

    public static int minLetter(Map<Character, Integer> loremMap) {
        int min = Integer.MAX_VALUE;
        for (char key : loremMap.keySet()) {
            int value = loremMap.get(key);
            if ((value < min) && ((key > 64 && key < 91) || (key > 96 && key < 123))) {
                min = value;
            }
        }
        return min;
    }

    public static int maxLetter(Map<Character, Integer> loremMap) {
        int max = -1;
        for (char key : loremMap.keySet()) {
            int value = loremMap.get(key);
            if ((value > max) && ((key > 64 && key < 91) || (key > 96 && key < 123))) {
                max = value;
            }
        }
        return max;
    }
}