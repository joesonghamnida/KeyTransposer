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
        } while (!validInput.contains(selection));
        return selection;
    }

    public static ArrayList<String> IonianScaleTransposition(String key, ArrayList<String> notes) {

        loadNotes();

        ArrayList<String> transposedScale = new ArrayList<>();
        int rootNumber = setRootIndex(key);
        String rootNote = setRootNote(key);

        transposedScale.add(rootNote);
        transposedScale.add(notes.get((rootNumber + 2) % 12));
        transposedScale.add(notes.get((rootNumber + 4) % 12));
        transposedScale.add(notes.get((rootNumber + 5) % 12));
        transposedScale.add(notes.get((rootNumber + 7) % 12));
        transposedScale.add(notes.get((rootNumber + 9) % 12));

        if (key.equals("A")) {
            transposedScale.add(notes.get((rootNumber + 10) % 12));
        } else {
            transposedScale.add(notes.get((rootNumber + 11) % 12));
        }

        boolean isKeyFlat = isKeyFlat(key);
        transposedScale = purgeSharpOrFlatNotes(isKeyFlat, transposedScale);

        return transposedScale;
    }

    public static Integer setRootIndex(String key) {
        int root = 0;

        for (String note : notes) {
            String[] steps = note.split("/");
            for (String s : steps) {
                if (s.equals(key)) {
                    root = notes.indexOf(note);
                }
            }
        }
        return root;
    }

    public static String setRootNote(String key) {
        String rootNote = "";
        for (String note : notes) {
            String[] steps = note.split("/");
            for (String s : steps) {
                if (s.equals(key)) {
                    rootNote = s;
                }
            }
        }
        return rootNote;
    }

    public static ArrayList<String> purgeSharpOrFlatNotes(Boolean isFlat, ArrayList<String> transposedScale) {
        ArrayList<String> revisedScale = new ArrayList<>();

        String note = "";

        for (String n : transposedScale) {
            boolean firstNote = n.equals(transposedScale.get(0));
            if (firstNote) {
                revisedScale.add(n);
            } else {
                if (n.length() != 1) {
                    String[] steps = n.split("/");
                    boolean skip = false;
                    for (String s : steps) {
                        if (n.contains("b") && isFlat && !skip) {
                            note = steps[1];
                            skip = true;
                        } else if (!skip) {
                            note = steps[1];
                        }
                    }
                } else {
                    note = n;
                }
                revisedScale.add(note);
            }

        }
        return revisedScale;
    }


    public static Boolean isKeyFlat(String key) {
        boolean isFlat = false;

        if (key.charAt(1) == 'b' || key.length() == 1) {
            isFlat = true;
        }
        return isFlat;
    }

    public static Boolean isKeySharp(String key) {
        boolean isSharp = false;

        if (key.charAt(1) == '#' || key.length() == 1) {
            isSharp = true;
        }
        return isSharp;
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
