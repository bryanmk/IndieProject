package service;

import questie.persistence.GenericDAO;
import questie.persistence.QuestApiDAO;

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
        numbers.add(1);
//        numbers.add(314);
//        numbers.add(315);
//        numbers.add(384);
//        numbers.add(412);
//        numbers.add(432);
//        numbers.add(433);
//        numbers.add(6387);
//        numbers.add(6388);
//        numbers.add(6391);
//        numbers.add(6392);
//        numbers.add(25199);
//        numbers.add(25212);
//        numbers.add(25229);
//        numbers.add(25283);
//        numbers.add(25285);
//        numbers.add(25286);
//        numbers.add(25287);
//        numbers.add(25289);
//        numbers.add(25295);
//        numbers.add(25393);
//        numbers.add(25500);
//        numbers.add(25667);
//        numbers.add(25668);
//        numbers.add(25724);
//        numbers.add(25792);
//        numbers.add(25838);
//        numbers.add(25839);
//        numbers.add(25840);
//        numbers.add(25841);
//        numbers.add(25882);
//        numbers.add(25905);
//        numbers.add(25932);
//        numbers.add(25933);
//        numbers.add(25937);
//        numbers.add(25978);
//        numbers.add(25979);
//        numbers.add(25986);
//        numbers.add(25997);
//        numbers.add(25998);
//        numbers.add(26078);
//        numbers.add(26085);
//        numbers.add(26094);
//        numbers.add(26102);
//        numbers.add(26112);
//        numbers.add(26380);
//        numbers.add(28868);
//        numbers.add(43283);
//        numbers.add(43284);
//        numbers.add(43291);
//        numbers.add(43292);
//        numbers.add(47709);
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
