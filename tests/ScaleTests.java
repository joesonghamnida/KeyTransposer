import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by joe on 1/30/17.
 */
public class ScaleTests {


    public static ArrayList<String> notes = new ArrayList<>();

    @Before
    public void loadNotes() {
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

    @Test
    public void AMajorIonian() {
        loadNotes();
        String[] expectedScale = {"A", "B", "C#", "D", "E", "F#", "G"};
        testIonianScales(expectedScale, "A");
    }

    @Test
    public void BflatMajorIonian(){
        loadNotes();
        String[] expectedScale = {"Bb", "C", "D", "Eb", "F", "G", "A"};
        testIonianScales(expectedScale, "Bb");
    }

    @Test
    public void BMajorIonian(){
        loadNotes();
        String[] expectedScale = {"B", "C#", "D#", "E", "F#", "G#","A#"};
        testIonianScales(expectedScale, "B");
    }

    @Test
    public void CMajorIonian(){
        loadNotes();
        String[] expectedScale = {"C", "D", "E", "F", "G", "A", "B"};
        testIonianScales(expectedScale, "C");
    }

    @Test
    public void CSharpMajorIonian(){
        //TODO: figure out what to do with this
        //loadNotes();
        //String[] ExpectedScale = {"C#", "D#", "E#", "F#", "G#/Ab","A#/Bb", "B#"};
    }

    @Test
    public void DflatMajorIonian(){
        String[] expectedScale = {"Db", "Eb", "F", "Gb", "Ab", "Bb"};
        testIonianScales(expectedScale, "Db");
    }

    @Test
    public void DMajorIonian() {
        loadNotes();
        String[] expectedScale = {"D", "E", "F#", "G", "A", "B", "C#"};
        testIonianScales(expectedScale, "D");
    }

    @Test
    public void EFlatMajorIonian(){
        loadNotes();
        String[] expectedScale = {"Eb", "F", "G", "Ab", "Bb", "C", "D"};
        testIonianScales(expectedScale, "Eb");
    }

    @Test
    public void EMajorIonian(){
        loadNotes();
        String[] expectedScale = {"E", "F#", "G#", "A", "B", "C#", "D#"};
        testIonianScales(expectedScale, "E");
    }

    public static void testIonianScales(String[] expectedScale, String key){
        ArrayList<String> actualScale = Main.IonianScaleTransposition(key, notes);
        System.out.println("Key: "+key);
        for (int i = 0; i < expectedScale.length; i++) {
            System.out.printf("Expected: %s Actual: %s\n", expectedScale[i], actualScale.get(i));
            Assert.assertTrue(expectedScale[i].equals(actualScale.get(i)));
        }
    }
}
