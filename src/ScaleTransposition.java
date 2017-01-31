import java.util.ArrayList;

/**
 * Created by joe on 1/30/17.
 */
public class ScaleTransposition {

    public static ArrayList<String> IonianScaleTransposition(String key, ArrayList<String> notes) {

        Main.loadNotes();

        ArrayList<String> transposedScale = new ArrayList<>();
        int rootNumber = setRootIndex(key, notes);
        String rootNote = setRootNote(key, notes);

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

    public static ArrayList<String> AeolianScaleTransposition(String key, ArrayList<String> notes){
        Main.loadNotes();

        ArrayList<String> transposedScale = new ArrayList<>();
        int rootNumber = setRootIndex(key, notes);
        String rootNote = setRootNote(key, notes);

        transposedScale.add(rootNote);
        transposedScale.add(notes.get((rootNumber + 2) % 12));
        transposedScale.add(notes.get((rootNumber + 3) % 12));
        transposedScale.add(notes.get((rootNumber + 5) % 12));
        transposedScale.add(notes.get((rootNumber + 7) % 12));
        transposedScale.add(notes.get((rootNumber + 8) % 12));

        transposedScale.add(notes.get((rootNumber + 10) % 12));

        boolean isKeyFlat = isKeyFlat(key);

        if(rootNote.equals("C")){
            isKeyFlat = true;
        }

        transposedScale = purgeSharpOrFlatNotes(isKeyFlat, transposedScale);

        return transposedScale;
    }

    public static Integer setRootIndex(String key, ArrayList<String> notes) {
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

    public static String setRootNote(String key, ArrayList<String> notes) {
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
            } else if (!n.contains("/")) {
                revisedScale.add(n);
            } else {
                boolean skip = false;
                String[] steps = n.split("/");

                for (String s : steps) {
                    if (n.contains("b") && isFlat && !skip) {
                        note = steps[1];
                        skip = true;
                    } else if (!skip) {
                        note = steps[0];
                    }
                }
                revisedScale.add(note);
            }
        }
        return revisedScale;
    }


    public static Boolean isKeyFlat(String key) {
        boolean isFlat = false;

        if (key.contains("b")) {
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

}
