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
//        numbers.add(25674);
//        numbers.add(25675);
//        numbers.add(25676);
//        numbers.add(25677);
//        numbers.add(25678);
//        numbers.add(25679);
//        numbers.add(25680);
//        numbers.add(25681);
//        numbers.add(25682);
//        numbers.add(25683);
//        numbers.add(25684);
//        numbers.add(25685);
//        numbers.add(25686);
//        numbers.add(25687);
//        numbers.add(25688);
//        numbers.add(25689);
//        numbers.add(25690);
//        numbers.add(25691);
//        numbers.add(25692);
//        numbers.add(25693);
//        numbers.add(25694);
//        numbers.add(25695);
//        numbers.add(25696);
//        numbers.add(25697);
//        numbers.add(25698);
//        numbers.add(25699);
//        numbers.add(25700);
//        numbers.add(25701);
//        numbers.add(25702);
//        numbers.add(25703);
//        numbers.add(25705);
//        numbers.add(25706);
//        numbers.add(25707);
//        numbers.add(25708);
//        numbers.add(25709);
//        numbers.add(25710);
//        numbers.add(25711);
//        numbers.add(25712);
//        numbers.add(25713);
//        numbers.add(25714);
//        numbers.add(25715);
//        numbers.add(25716);
//        numbers.add(25717);


//        numbers.add(25718);
//        numbers.add(25719);
//        numbers.add(25720);
        numbers.add(25771);
        numbers.add(25772);


//        numbers.add(26157);
//        numbers.add(26158);
//        numbers.add(26159);
//        numbers.add(26160);
//        numbers.add(26161);
//        numbers.add(26162);
//        numbers.add(26163);
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
//                    ("('" + String.valueOf(
//                    dao.getAnswer((quests.get(i))).getId() + "', '" +
//                        dao.getAnswer((quests.get(i))).getTitle() + "', '" +
//                        dao.getAnswer((quests.get(i))).getRequirements().getMinCharacterLevel() + "', '" +
//                        dao.getAnswer((quests.get(i))).getArea().getName() + "', '" +
//                        dao.getAnswer((quests.get(i))).getRewards().getExperience() + "', '" +
//                        dao.getAnswer((quests.get(i))).getRewards().getMoney().getUnits().getGold() + "', '" +
//                        dao.getAnswer((quests.get(i))).getRewards().getMoney().getUnits().getSilver() + "', '" +
//                        dao.getAnswer((quests.get(i))).getRewards().getMoney().getUnits().getCopper())+ "')");

            ("('" + String.valueOf(
                    dao.getAnswer((quests.get(i))).getId() + "', '" +
                            dao.getAnswer((quests.get(i))).getTitle() + "', '" +
                            dao.getAnswer((quests.get(i))).getRequirements().getMinCharacterLevel() + "', '" +
                            dao.getAnswer((quests.get(i))).getArea().getName() + "', '" +
                            dao.getAnswer((quests.get(i))).getRewards().getExperience()) + "')" );
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
