import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> notes = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Key Transposition Program");

        loadNotes();
        System.out.println(notes.size());
        String currentKey = "";
        System.out.println("Enter the key you want: ");
        String selectedKey = scanner.nextLine().trim();
        ArrayList<String> transposedScale = IonianScaleTransposition(selectedKey, notes);
        for(String note : transposedScale){
            System.out.println(note);
        }
    }

    public static String majorMinorSelectionMenu(){
        String selection = "";
        ArrayList<String> validInput = new ArrayList<>();
        validInput.add("1");
        validInput.add("2");
        validInput.add("3");
        validInput.add("4");
        validInput.add("5");
        validInput.add("6");
        validInput.add("7");

        do {
            System.out.println("Select a scale: ");
            System.out.println("1. Ionian: Major");
            System.out.println("2. Dorian: Minor");
            System.out.println("3. Phrygian: Minor");
            System.out.println("4. Lydian: Major");
            System.out.println("5. Mixolydian: Major");
            System.out.println("6. Aeolian: Minor");
            System.out.println("7. Locrian: Minor");
            selection = scanner.nextLine();
        }while (!validInput.contains(selection));
        return selection;
    }

    public static ArrayList<String> IonianScaleTransposition(String key, ArrayList<String> notes){
        ArrayList<String> transposedScale = new ArrayList<>();
        int root = notes.indexOf(key);
        transposedScale.add(notes.get(root));
        transposedScale.add(notes.get((root + 3) % 17));
        transposedScale.add(notes.get((root + 5) % 17));
        transposedScale.add(notes.get((root + 7) % 17));
        transposedScale.add(notes.get((root + 10) % 17));
        transposedScale.add(notes.get((root + 12) % 17));
        transposedScale.add(notes.get((root + 14) % 17));

        //similar to caesar cipher
        //repeats on major 4th
        // 17 notes

        return transposedScale;
    }

    public static void loadNotes(){
        notes.add("Ab");
        notes.add("A");
        notes.add("A#");
        notes.add("Bb");
        notes.add("B");
        notes.add("C");
        notes.add("C#");
        notes.add("Db");
        notes.add("D");
        notes.add("D#");
        notes.add("Eb");
        notes.add("E");
        notes.add("F");
        notes.add("F#");
        notes.add("Gb");
        notes.add("G");
        notes.add("G#");
    }
}
