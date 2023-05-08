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
        numbers.add(27693);
        numbers.add(27709);
        numbers.add(27713);
        numbers.add(27714);
        numbers.add(27715);
        numbers.add(27762);
        numbers.add(27763);
        numbers.add(27764);
        numbers.add(27765);
        numbers.add(27766);
        numbers.add(27769);
        numbers.add(27770);
        numbers.add(27771);
        numbers.add(27772);
        numbers.add(27774);
        numbers.add(27775);
        numbers.add(27776);
        numbers.add(27789);
        numbers.add(27791);
        numbers.add(27792);
        numbers.add(27793);
        numbers.add(27794);
        numbers.add(27796);
        numbers.add(27797);
        numbers.add(27823);
        numbers.add(27824);
        numbers.add(27825);
        numbers.add(27826);
        numbers.add(27827);
        numbers.add(27828);
        numbers.add(27829);
        numbers.add(27830);
        numbers.add(27831);
        numbers.add(27832);
        numbers.add(27833);
        numbers.add(27834);
        numbers.add(27835);
        numbers.add(27858);
        numbers.add(27859);
        numbers.add(27877);
        numbers.add(27878);
        numbers.add(27879);
        numbers.add(27880);
        numbers.add(27881);
        numbers.add(27882);
        numbers.add(27883);
        numbers.add(27884);
        numbers.add(27885);
        numbers.add(27886);
        numbers.add(27887);
        numbers.add(27888);
        numbers.add(27889);
        numbers.add(27890);
        numbers.add(27891);
        numbers.add(27892);
        numbers.add(27893);
        numbers.add(27894);
        numbers.add(27895);
        numbers.add(27896);
        numbers.add(27897);
        numbers.add(27898);
        numbers.add(27912);
        numbers.add(27913);
        numbers.add(27927);
        numbers.add(27930);
        numbers.add(28579);
        numbers.add(28580);
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
