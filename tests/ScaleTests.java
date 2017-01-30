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

    @Test
    public void AMajorIonian() {
        String[] expectedScale = {"A", "B", "C#", "D", "E", "F#", "G"};
        testScales(expectedScale, "A");
    }

    @Test
    public void BbMajorIonain(){
        String[] expectedScale = {"Bb", "C", "D", "Eb", "F", "G", "A"};
        testScales(expectedScale, "Bb");
    }

    @Test
    public void BMajorIonian(){
        String[] expectedScale = {"B", "C#", "D#", "E", "F#", "G#","A#"};
        testScales(expectedScale, "B");
    }

    @Test
    public void CMajorIonian(){
        String[] expectedScale = {"C", "D", "E", "F", "G", "A", "B"};
        testScales(expectedScale, "C");
    }

    @Test
    public void DMajorIonian() {
        String[] expectedScale = {"D", "E", "F#", "G", "A", "B", "C#"};
        testScales(expectedScale, "D");
    }

    public static void testScales(String[] expectedScale, String key){
        ArrayList<String> actualScale = Main.IonianScaleTransposition(key, notes);
        for (int i = 0; i < expectedScale.length; i++) {
            System.out.printf("Exepcted: %s Actual: %s\n", expectedScale[i], actualScale.get(i));
            Assert.assertTrue(expectedScale[i].equals(actualScale.get(i)));
        }
    }
}
