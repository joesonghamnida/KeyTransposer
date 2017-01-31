import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> notes = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Key Transposition Program");

        loadNotes();

        String selection = majorMinorSelectionMenu();

        String currentKey = "";
        ArrayList<String> transposedScale = new ArrayList<>();
        System.out.println("Enter the key you want: ");
        String selectedKey = scanner.nextLine().trim();

        if (selection.equals("1")) {
            transposedScale = ScaleTransposition.IonianScaleTransposition(selectedKey, notes);
        } else {
            transposedScale = ScaleTransposition.AeolianScaleTransposition(selectedKey, notes);
        }

        for (String note : transposedScale) {
            System.out.println(note);
        }
    }
    

    public static String majorMinorSelectionMenu() {
        String selection = "";
        ArrayList<String> validInput = new ArrayList<>();
        validInput.add("1");
        validInput.add("2");
        validInput.add("3");
        validInput.add("4");
        validInput.add("5");
        validInput.add("6");
        validInput.add("7");
        validInput.add("8");

        do {
            System.out.println("Select a scale: ");
            System.out.println("1. Ionian: Major");
            System.out.println("2. Dorian: Minor");
            System.out.println("3. Phrygian: Minor");
            System.out.println("4. Lydian: Major");
            System.out.println("5. Mixolydian: Major");
            System.out.println("6. Aeolian: Minor");
            System.out.println("7. Locrian: Minor");
            System.out.println("8. Exit");
            selection = scanner.nextLine();
        } while (!validInput.contains(selection));
        return selection;
    }

    public static void loadNotes() {
        notes.add("A");
        notes.add("A#/Bb");
        notes.add("B");
        notes.add("C");
        notes.add("C#/Db");
        notes.add("D");
        notes.add("D#/Eb");
        notes.add("E");
        notes.add("F");
        notes.add("F#/Gb");
        notes.add("G");
        notes.add("G#/Ab");
    }
}
