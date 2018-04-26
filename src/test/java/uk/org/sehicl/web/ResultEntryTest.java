package uk.org.sehicl.web;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import static org.assertj.core.api.Assertions.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class ResultEntryTest
{
    private final static DecimalFormat DF = new DecimalFormat("0.#");

    @Before
    public void setup()
    {
        setBaseUrl("http://localhost:8080");
    }

    @Test
    public void testGetResultEntryPage1()
    {
        final Result result = new Result(18, new League("Division 2"), new Team("IBM South Hants"),
                new Team("Hayling Island"), BatFirst.AWAY)
                        .innings(1)
                        .addBatsman("G Martin", NonBowlerHowOut.NOT_OUT, 60)
                        .addBatsman("M Lever", NonBowlerHowOut.NOT_OUT, 68)
                        .addBatsman("M Hallett", BowlerHowOut.CAUGHT, "P Stride", 3)
                        .addBatsman("D Gorvin", BowlerHowOut.BOWLED, "C Naish", 9)
                        .addBatsman("F Steele", BowlerHowOut.BOWLED, "P Croxson", 3)
                        .addBatsman("T Watton", BowlerHowOut.BOWLED, "R Barnard", 1)
                        .setExtras(21)
                        .addBowler("P Croxson", 3, 34)
                        .addBowler("R Barnard", 3, 26)
                        .addBowler("C Naish", 2, 46)
                        .addBowler("P Stride", 2, 32)
                        .addBowler("P Hicks", 2, 22)
                        .innings(2)
                        .addBatsman("P Hicks", NonBowlerHowOut.NOT_OUT, 29)
                        .addBatsman("P Croxson", BowlerHowOut.CAUGHT, "F Steele", 1)
                        .addBatsman("P Stride", BowlerHowOut.BOWLED, "D Gorvin", 22)
                        .addBatsman("R Barnard", NonBowlerHowOut.RUN_OUT, 5)
                        .addBatsman("A Vikram", NonBowlerHowOut.RUN_OUT, 10)
                        .addBatsman("C Naish", NonBowlerHowOut.NOT_OUT, 7)
                        .setExtras(34)
                        .addBowler("T Watton", 3, 27)
                        .addBowler("F Steele", 3, 34)
                        .addBowler("M Hallett", 3, 14)
                        .addBowler("D Gorvin", 3, 29);
        testResult(result);
    }

    @Test
    public void testGetResultEntryPage2()
    {
        final Result result = new Result(18, new League("Division 5"), new Team("Hambledon C"),
                new Team("OPCS Titchfield"), BatFirst.HOME)
                        .innings(1)
                        .addBatsman("T Rogers", BowlerHowOut.CAUGHT, "J Pitcher", 24)
                        .addBatsman("K Wingham", NonBowlerHowOut.RETIRED, 26)
                        .addBatsman("J Restell", BowlerHowOut.CAUGHT, "C Parker", 6)
                        .addBatsman("T Toogood", NonBowlerHowOut.NOT_OUT, 20)
                        .addBatsman("H Duncan", NonBowlerHowOut.NOT_OUT, 9)
                        .addBatsman("W Norman", NonScoreHowOut.DID_NOT_BAT)
                        .setExtras(62)
                        .addBowler("J Pitcher", 3, 23)
                        .addBowler("C Parker", 3, 27)
                        .addBowler("B Samuel", 3, 28)
                        .addBowler("T Page", 2, 44)
                        .addBowler("S Primmer", 1, 19)
                        .innings(2)
                        .addBatsman("A White", NonBowlerHowOut.RUN_OUT, 6)
                        .addBatsman("C Parker", BowlerHowOut.CAUGHT, "W Norman", 2)
                        .addBatsman("S Primmer", BowlerHowOut.BOWLED, "W Norman", 2)
                        .addBatsman("T Page", BowlerHowOut.BOWLED, "J Restell", 14)
                        .addBatsman("J Pitcher", BowlerHowOut.BOWLED, "J Restell", 6)
                        .addBatsman("B Samuel", NonBowlerHowOut.RUN_OUT, 5)
                        .setExtras(11)
                        .addBowler("T Toogood", 3, 13)
                        .addBowler("W Norman", 3, 12)
                        .addBowler("H Duncan", 3, 11)
                        .addBowler("J Restell", 2.3, 16);
        testResult(result);
    }

    @Test
    public void testGetResultEntryPage3()
    {
        final Result result = new Result(16, new League("Division 1"), new Team("Havant A"),
                new Team("Sarisbury Athletic A"), BatFirst.AWAY)
                        .innings(1)
                        .addBatsman("S Floyd", BowlerHowOut.CAUGHT, "H Gadd", 16)
                        .addBatsman("M Bond", NonBowlerHowOut.RUN_OUT, 10)
                        .addBatsman("C Day", BowlerHowOut.CAUGHT, "P Hopson", 6)
                        .addBatsman("J Floyd", NonBowlerHowOut.NOT_OUT, 36)
                        .addBatsman("P Jewell", NonBowlerHowOut.NOT_OUT, 9)
                        .addBatsman(NonBatsmanHowOut.ABSENT_OUT)
                        .setExtras(20)
                        .addBowler("S Ransley", 3, 31)
                        .addBowler("B Walker", 2, 15)
                        .addBowler("P Hopson", 3, 19)
                        .addBowler("H Gadd", 3, 16)
                        .addBowler("H Hovey", 1, 15)
                        .innings(2)
                        .addBatsman("B Walker", NonBowlerHowOut.RETIRED, 27)
                        .addBatsman("S Ransley", NonBowlerHowOut.RETIRED, 25)
                        .addBatsman("S Loat", NonBowlerHowOut.NOT_OUT, 6)
                        .addBatsman("H Hovey", NonBowlerHowOut.NOT_OUT, 11)
                        .addBatsman("H Gadd", NonScoreHowOut.DID_NOT_BAT)
                        .addBatsman("P Hopson", NonScoreHowOut.DID_NOT_BAT)
                        .setExtras(29)
                        .addBowler("P Jewell", 3, 18)
                        .addBowler("J Floyd", 3, 30)
                        .addBowler("S Floyd", 1.5, 27)
                        .addBowler("M Bond", 1, 23);
        testResult(result);
    }

    private void testResult(Result result)
    {
        beginAt(result.pageAddress);
        selectOption("battingfirst", result.innings.get(0).battingTeam);
        for (int i = 0; i < 2; i++)
            setInningsData(i + 1, result.innings.get(i));
        checkAutoFields(result);
    }

    private void setInningsData(int number, Innings inns)
    {
        for (int b = 0; b < inns.batsmen.size(); b++)
        {
            final Batsman batsman = inns.batsmen.get(b);
            setBatsmanData(number, b + 1, batsman.name, batsman.howOut.getText(),
                    batsman.bowlerName, batsman.score);
        }
        setTextField("extras" + number, DF.format(inns.extras));
        for (int b = 0; b < inns.bowlers.size(); b++)
        {
            final Bowler bowler = inns.bowlers.get(b);
            setBowlerData(number, b + 1, bowler.name, bowler.overs, bowler.runs);
        }
    }

    private void setBatsmanData(int innings, int batter, String name, String howOut, String bowler,
            Integer score)
    {
        if (name != null)
        {
            setTextField("batsman" + innings + batter, name);
        }
        selectOption("howout" + innings + batter, howOut);
        if (bowler != null)
        {
            setTextField("bowlerwicket" + innings + batter, bowler);
        }
        if (score != null)
        {
            setTextField("runsScored" + innings + batter, DF.format(score));
        }
    }

    private void setBowlerData(int innings, int batter, String name, double overs, int runs)
    {
        setTextField("bowler" + innings + batter, name);
        selectOption("overs" + innings + batter, DF.format(overs));
        setTextField("runsConceded" + innings + batter, DF.format(runs));
    }

    private void checkAutoFields(Result result)
    {
        for (int i = 0; i < result.innings.size(); i++)
        {
            final Innings innings = result.innings.get(i);
            int number = i + 1;
            assertThat(getElementById("total" + number).getAttribute("value"))
                    .isEqualTo(DF.format(innings.expectedRuns()));
            assertThat(getElementById("wickets" + number).getAttribute("value"))
                    .isEqualTo(DF.format(innings
                            .expectedWickets()));
            assertThat(getElementById("overs" + number).getAttribute("value"))
                    .isEqualTo(DF.format(innings.expectedOvers()));
            for (int b = 0; b < innings.bowlers.size(); b++)
            {
                assertThat(getElementById("wickets" + number + (b + 1)).getAttribute("value"))
                        .isEqualTo(
                                DF.format(innings.bowlers.get(b).expectedWickets(innings.batsmen)));
            }
        }
    }

    private static class Result
    {
        public final String pageAddress;
        public final List<Innings> innings;
        private Innings currentInnings;

        public Result(int season, League league, Team homeTeam, Team awayTeam, BatFirst batFirst)
        {
            this.pageAddress = String.format("/result/%d/%s/%s/%s", season, league.id, homeTeam.id,
                    awayTeam.id);
            Team battingFirst = batFirst == BatFirst.HOME ? homeTeam : awayTeam;
            Team battingSecond = batFirst == BatFirst.AWAY ? homeTeam : awayTeam;
            innings = Arrays.asList(new Innings(battingFirst.name),
                    new Innings(battingSecond.name));
        }

        public Result innings(int i)
        {
            currentInnings = innings.get(i - 1);
            return this;
        }

        public Result addBatsman(String name, BowlerHowOut howOut, String bowlerName, int score)
        {
            currentInnings.add(new Batsman(name, howOut, bowlerName, score));
            return this;
        }

        public Result addBatsman(String name, NonBowlerHowOut howOut, int score)
        {
            currentInnings.add(new Batsman(name, howOut, score));
            return this;
        }

        public Result addBatsman(NonBatsmanHowOut howOut)
        {
            currentInnings.add(new Batsman(howOut));
            return this;
        }

        public Result addBatsman(String name, NonScoreHowOut howOut)
        {
            currentInnings.add(new Batsman(name, howOut));
            return this;
        }

        public Result addBowler(String name, double overs, int runs)
        {
            currentInnings.add(new Bowler(name, overs, runs));
            return this;
        }

        public Result setExtras(int extras)
        {
            currentInnings.setExtras(extras);
            return this;
        }
    }

    private static class Innings
    {
        private final String battingTeam;
        private final List<Batsman> batsmen = new ArrayList<>();
        private final List<Bowler> bowlers = new ArrayList<>();
        private Integer extras;

        public Innings(String battingTeam)
        {
            this.battingTeam = battingTeam;
        }

        public void add(Batsman b)
        {
            batsmen.add(b);
        }

        public void add(Bowler b)
        {
            bowlers.add(b);
        }

        public void setExtras(int extras)
        {
            this.extras = extras;
        }

        public int expectedRuns()
        {
            return batsmen.stream().map(b -> b.score).filter(Objects::nonNull).collect(
                    Collectors.summingInt(Integer::intValue)) + extras;
        }

        public int expectedWickets()
        {
            return (int) batsmen.stream().map(b -> b.howOut).filter(HowOut::isOut).count();
        }

        public double expectedOvers()
        {
            final int balls = bowlers
                    .stream()
                    .map(b -> b.balls)
                    .collect(Collectors.summingInt(Integer::intValue));
            return balls / 6 + balls % 6 * 0.1;
        }
    }

    private static class Batsman
    {
        private final String name;
        private final HowOut howOut;
        private final String bowlerName;
        private final Integer score;

        public Batsman(String name, BowlerHowOut howOut, String bowlerName, int score)
        {
            this(name, (HowOut) howOut, bowlerName, score);
        }

        public Batsman(String name, NonBowlerHowOut howOut, int score)
        {
            this(name, howOut, null, score);
        }

        public Batsman(NonBatsmanHowOut howOut)
        {
            this(null, howOut, null, null);
        }

        public Batsman(String name, NonScoreHowOut howOut)
        {
            this(name, howOut, null, null);
        }

        private Batsman(String name, HowOut howOut, String bowlerName, Integer score)
        {
            this.name = name;
            this.howOut = howOut;
            this.bowlerName = bowlerName;
            this.score = score;
        }
    }

    private static class Bowler
    {
        private final String name;
        private final int balls;
        private final double overs;
        private final int runs;

        public Bowler(String name, double overs, int runs)
        {
            this.name = name;
            int o10 = (int) (overs * 10);
            this.balls = o10 / 10 * 6 + o10 % 10;
            this.overs = overs;
            this.runs = runs;
        }

        public int expectedWickets(List<Batsman> batsmen)
        {
            return (int) batsmen.stream().filter(b -> Objects.equals(name, b.bowlerName)).count();
        }

    }

    private static abstract interface HowOut
    {
        String getText();

        boolean isOut();
    }

    private static enum BowlerHowOut implements HowOut
    {
        BOWLED("Bowled"), CAUGHT("Caught"), LBW("LBW"), STUMPED("Stumped"), HIT_WICKET(
                "Hit wicket");

        private final String text;

        private BowlerHowOut(String text)
        {
            this.text = text;
        }

        @Override
        public String getText()
        {
            return text;
        }

        @Override
        public boolean isOut()
        {
            return true;
        }
    }

    private static enum NonBowlerHowOut implements HowOut
    {
        NOT_OUT("Not out", false), RUN_OUT("Run out", true), OBSTRUCTING_THE_FIELD(
                "Obstructing the field",
                true), HANDLED_BALL("Handled ball", true), TIMED_OUT("Timed out",
                        true), RETIRED("Retired", false), RETIRED_HURT("Retired hurt - not out",
                                false), RETIRED_HURT_OUT("Retired hurt - out", true);

        private final String text;
        private final boolean out;

        private NonBowlerHowOut(String text, boolean out)
        {
            this.text = text;
            this.out = out;
        }

        @Override
        public String getText()
        {
            return text;
        }

        @Override
        public boolean isOut()
        {
            return out;
        }
    }

    private static enum NonBatsmanHowOut implements HowOut
    {
        ABSENT("Absent", false), ABSENT_OUT("Absent out", true);

        private final String text;
        private final boolean out;

        private NonBatsmanHowOut(String text, boolean out)
        {
            this.text = text;
            this.out = out;
        }

        @Override
        public String getText()
        {
            return text;
        }

        @Override
        public boolean isOut()
        {
            return out;
        }
    }

    private static enum NonScoreHowOut implements HowOut
    {
        DID_NOT_BAT("Did not bat");

        private final String text;

        private NonScoreHowOut(String text)
        {
            this.text = text;
        }

        @Override
        public String getText()
        {
            return text;
        }

        @Override
        public boolean isOut()
        {
            return false;
        }
    }

    private static abstract class EntityWithNameAndId
    {
        public final String name;
        public final String id;

        protected EntityWithNameAndId(String name)
        {
            this(name, null);
        }

        protected EntityWithNameAndId(String name, String idSuffix)
        {
            this.name = name;
            final String idRoot = name.replaceAll("[^A-Za-z0-9]+", "");
            this.id = idRoot + (idSuffix == null ? "" : idSuffix);
        }
    }

    private static class Team extends EntityWithNameAndId
    {

        public Team(String name, String idSuffix)
        {
            super(name, idSuffix);
        }

        public Team(String name)
        {
            super(name);
        }
    }

    private static class League extends EntityWithNameAndId
    {

        public League(String name, String idSuffix)
        {
            super(name, idSuffix);
        }

        public League(String name)
        {
            super(name);
        }
    }

    private static enum BatFirst
    {
        HOME, AWAY
    }
}
