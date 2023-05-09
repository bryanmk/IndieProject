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
        numbers.add(25235);
        numbers.add(26618);
        numbers.add(26620);
        numbers.add(26623);
        numbers.add(26627);
        numbers.add(26645);
        numbers.add(26652);
        numbers.add(26653);
        numbers.add(26654);
        numbers.add(26655);
        numbers.add(26660);
        numbers.add(26661);
        numbers.add(26666);
        numbers.add(26667);
        numbers.add(26669);
        numbers.add(26670);
        numbers.add(26671);
        numbers.add(26672);
        numbers.add(26674);
        numbers.add(26676);
        numbers.add(26677);
        numbers.add(26680);
        numbers.add(26681);
        numbers.add(26683);
        numbers.add(26684);
        numbers.add(26685);
        numbers.add(26686);
        numbers.add(26688);
        numbers.add(26689);
        numbers.add(26690);
        numbers.add(26691);
        numbers.add(26707);
        numbers.add(26717);
        numbers.add(26719);
        numbers.add(26720);
        numbers.add(26721);
        numbers.add(26722);
        numbers.add(26723);
        numbers.add(26724);
        numbers.add(26725);
        numbers.add(26727);
        numbers.add(26728);
        numbers.add(26753);
        numbers.add(26754);
        numbers.add(26760);
        numbers.add(26777);
        numbers.add(26778);
        numbers.add(26785);
        numbers.add(26787);
        numbers.add(26793);
        numbers.add(26794);
        numbers.add(26795);
        numbers.add(26796);
        numbers.add(26797);
        numbers.add(28564);


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
