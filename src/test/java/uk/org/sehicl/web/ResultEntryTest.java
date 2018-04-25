package uk.org.sehicl.web;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import static org.assertj.core.api.Assertions.*;

import java.text.DecimalFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.api.IElement;

public class ResultEntryTest
{
    private final static DecimalFormat DF = new DecimalFormat("0.#");

    @Before
    public void setup()
    {
        setBaseUrl("http://localhost:8080");
    }
    
    @Test
    public void testGetResultEntryPage()
    {
        beginAt("result/Division2/IBMSouthHants/HaylingIsland");
        selectOption("battingfirst", "IBM South Hants");
        setBatsmanData(1, 1, "G Martin", "Not out", null, 60);
        setBatsmanData(1, 2, "M Lever", "Not out", null, 68);
        setBatsmanData(1, 3, "M Hallett", "Caught", "P Stride", 3);
        setBatsmanData(1, 4, "D Gorvin", "Bowled", "C Naish", 9);
        setBatsmanData(1, 5, "F Steele", "Bowled", "P Croxson", 3);
        setBatsmanData(1, 6, "T Watton", "Bowled", "R Barnard", 1);
        setTextField("extras1", "21");
        setBowlerData(1, 1, "P Croxson", 3, 34);
        setBowlerData(1, 2, "R Barnard", 3, 26);
        setBowlerData(1, 3, "C Naish", 2, 46);
        setBowlerData(1, 4, "P Stride", 2, 32);
        setBowlerData(1, 5, "P Hicks", 2, 22);
        setBatsmanData(2, 1, "P Hicks", "Not out", null, 29);
        setBatsmanData(2, 2, "P Croxson", "Caught", "F Steele", 1);
        setBatsmanData(2, 3, "P Stride", "Bowled", "D Gorvin", 22);
        setBatsmanData(2, 4, "R Barnard", "Run out", null, 5);
        setBatsmanData(2, 5, "A Vikram", "Run out", null, 10);
        setBatsmanData(2, 6, "C Naish", "Not out", null, 7);
        setTextField("extras2", "34");
        setBowlerData(2, 1, "T Watton", 3, 27);
        setBowlerData(2, 2, "F Steele", 3, 34);
        setBowlerData(2, 3, "M Hallett", 3, 14);
        setBowlerData(2, 4, "D Gorvin", 3, 29);
        assertThat(getElementById("total1").getAttribute("value")).isEqualTo(DF.format(165));
        assertThat(getElementById("wickets1").getAttribute("value")).isEqualTo(DF.format(4));
        assertThat(getElementById("overs1").getAttribute("value")).isEqualTo(DF.format(12));
        assertThat(getElementById("total2").getAttribute("value")).isEqualTo(DF.format(108));
        assertThat(getElementById("wickets2").getAttribute("value")).isEqualTo(DF.format(4));
        assertThat(getElementById("overs2").getAttribute("value")).isEqualTo(DF.format(12));
    }
    
    private void setBatsmanData(int innings, int batter, String name, String howOut, String bowler, int score)
    {
        setTextField("batsman" + innings + batter, name);
        selectOption("howout" + innings + batter, howOut);
        if (bowler != null)
        {
            setTextField("bowlerwicket" + innings + batter, bowler);
        }
        setTextField("runsScored" + innings + batter, DF.format(score));
    }

    private void setBowlerData(int innings, int batter, String name, float overs, int runs)
    {
        setTextField("bowler" + innings + batter, name);
        selectOption("overs" + innings + batter, DF.format(overs));
        setTextField("runsConceded" + innings + batter, DF.format(runs));
    }
}
