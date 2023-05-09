package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import quest.api.Quest;
import questie.persistence.GenericDAO;
import questie.persistence.QuestApiDAO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Quests {
    private int id;
    private String title;
    static QuestApiDAO dao;

    public Quests() { }

    public Quests(int id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Constructor for just the title
     * @param title
     */
    public Quests (String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Quests [" +
                "id=" + id +
                ", title=" + title + "]";
    }

    /**
     * produces a collection of dates in a range
     * @return  a List of integers
     * https://www.baeldung.com/java-between-dates
     */
    public static List<Integer> getQuests() {
//        List<LocalDate> dateList = start.datesUntil(end).collect(Collectors.toList());
//        List<String> strList = new ArrayList<>();
//        for (int i = 0; i < dateList.size(); i++) {
//            strList.add(String.valueOf(dateList.get(i)));
//        }
//        return strList;

        /**
         * Just to test, it worked.
         */
        List<Integer> numbers = new ArrayList<>();
//        numbers.add(11);
//        numbers.add(16);
//        numbers.add(35);
//        numbers.add(37);
//        numbers.add(40);
//        numbers.add(45);
//        numbers.add(46);
//        numbers.add(47);
//        numbers.add(52);
//        numbers.add(59);
//        numbers.add(60);
//        numbers.add(62);
//        numbers.add(71);
//        numbers.add(76);
//        numbers.add(83);
//        numbers.add(84);
//        numbers.add(85);
//        numbers.add(86);
//        numbers.add(87);
//        numbers.add(88);
//        numbers.add(106);
//        numbers.add(107);
//        numbers.add(111);
//        numbers.add(112);
//        numbers.add(114);
//        numbers.add(123);
//        numbers.add(147);
//        numbers.add(176);
//        numbers.add(239);
//        numbers.add(2158);
//        numbers.add(5545);
//        numbers.add(5805);
//        numbers.add(26150);
//        numbers.add(26152);
//        numbers.add(26393);
//        numbers.add(26394);
//        numbers.add(26395);
//        numbers.add(26396);
//        numbers.add(33422);
//        numbers.add(33428);
//        numbers.add(33429);
//        numbers.add(33431);
//        numbers.add(33432);
//        numbers.add(37112);
//        numbers.add(26128);
//        numbers.add(26137);
//        numbers.add(26189);
//        numbers.add(26195);
//        numbers.add(26196);
//        numbers.add(26327);
//        numbers.add(26980);
//        numbers.add(26981);
//        numbers.add(28565);
//        numbers.add(38843);
//        numbers.add(56371);


//        numbers.add(26164);
//        numbers.add(26165);
//        numbers.add(26166);
//        numbers.add(26167);
//        numbers.add(26168);
//        numbers.add(26169);
//        numbers.add(26170);
//        numbers.add(26171);
//        numbers.add(26172);
//        numbers.add(26173);
//        numbers.add(26174);
//        numbers.add(26175);
//        numbers.add(26184);
//        numbers.add(26185);
//        numbers.add(26186);
//        numbers.add(26187);
//        numbers.add(27919);
//        numbers.add(28553);
//        numbers.add(28671);
//        numbers.add(28673);
//        numbers.add(28857);
//        numbers.add(28858);
//        numbers.add(28865);
//        numbers.add(28867);
//        numbers.add(35460);
//        numbers.add(35462);
//        numbers.add(35463);
//        numbers.add(35464);
//        numbers.add(35486);
//        numbers.add(35488);
//        numbers.add(35492);
//        numbers.add(35494);
//        numbers.add(35495);
//        numbers.add(35496);
//        numbers.add(35499);
//        numbers.add(35500);
//        numbers.add(35744);
//        numbers.add(35745);
//        numbers.add(35746);
//        numbers.add(35748);
//        numbers.add(35750);
//        numbers.add(35751);
//        numbers.add(35760);
//        numbers.add(35761);
//        numbers.add(35762);
//        numbers.add(35763);
//        numbers.add(35764);
//        numbers.add(36292);
//        numbers.add(36307);
//        numbers.add(36379);
//        numbers.add(36382);
//        numbers.add(36498);
//        numbers.add(36499);
//        numbers.add(36940);
//        numbers.add(36941);
        return numbers;


//        List<Integer> range = IntStream.rangeClosed(start, end)
//                .boxed().collect(Collectors.toList());
//        return range;
    }

    /**
     * Retrieves the NYTimes API information (wordleDAO) with the dates information
     * @param quests -- String List of dates to search words for
     * @return -- List<String> with correct INSERT values for a SQL statement
     */
    public static List<String> queryValues (List<Integer> quests) throws IOException {
        List<String> questsAPI = new ArrayList<>();
        for (int i = 0; i < quests.size(); i++) {
            questsAPI.add
                    ("('" + String.valueOf(
                    dao.getAnswer((quests.get(i))).getId() + "', '" +
                        dao.getAnswer((quests.get(i))).getTitle() + "', '" +
                        dao.getAnswer((quests.get(i))).getRequirements().getMinCharacterLevel() + "', '" +
                        dao.getAnswer((quests.get(i))).getArea().getName() + "', '" +
                        dao.getAnswer((quests.get(i))).getRewards().getExperience() + "', '" +
                        dao.getAnswer((quests.get(i))).getRewards().getMoney().getUnits().getGold() + "', '" +
                        dao.getAnswer((quests.get(i))).getRewards().getMoney().getUnits().getSilver() + "', '" +
                        dao.getAnswer((quests.get(i))).getRewards().getMoney().getUnits().getCopper())+ "')");

            // USE WHEN QUEST HAS NULL POINTER FOR GOLD/SILVER/COPPER
//            ("('" + String.valueOf(
//                    dao.getAnswer((quests.get(i))).getId() + "', '" +
//                            dao.getAnswer((quests.get(i))).getTitle() + "', '" +
//                            dao.getAnswer((quests.get(i))).getRequirements().getMinCharacterLevel() + "', '" +
//                            dao.getAnswer((quests.get(i))).getArea().getName() + "', '" +
//                            dao.getAnswer((quests.get(i))).getRewards().getExperience()) + "')" );
        }
        return questsAPI;

    }

    /**
     * Takes a String list and produces a .txt file
     * @param list the list
     * @throws IOException the io exception
     */
    public static void toFile (List<String> list) throws IOException {
        File file = new File("src/main/resources/InsertValues.txt");
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        } else {
            file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        //remove [] from list
        String res = list.toString();
        String result = res.substring(1, res.length()-1);
        bw.write(result);
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        dao = new QuestApiDAO();

        toFile(queryValues(getQuests()));
    }

}
