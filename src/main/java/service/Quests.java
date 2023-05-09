package service;

import questie.persistence.QuestApiDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


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
     * produces a List of integers corresponding to quest{id} endpoints
     * @return  a List of integers
     */
    public static List<Integer> getQuests() {

        //For manually entering quest{id} endpoints
        List<Integer> numbers = new ArrayList<>();
//        numbers.add(26920);
//        numbers.add(26921);
//        numbers.add(26922);
//        numbers.add(26923);
//        numbers.add(26924);
//        numbers.add(26925);
//        numbers.add(26926);
//        numbers.add(26930);
//        numbers.add(26931);
//        numbers.add(26933);
//        numbers.add(26934);
//        numbers.add(26935);
//        numbers.add(26936);
//        numbers.add(26937);
//        numbers.add(26938);
//        numbers.add(26952);
//        numbers.add(26953);
//        numbers.add(26954);
//        numbers.add(26955);
//        numbers.add(26956);
//        numbers.add(26957);
//        numbers.add(26978);
//        numbers.add(26979);
//        numbers.add(26999);
//        numbers.add(27000);
//        numbers.add(27001);
//        numbers.add(27002);
//        numbers.add(27011);
//        numbers.add(27012);
//        numbers.add(27013);
//        numbers.add(27017);

        numbers.add(27018);

//        numbers.add(27053);
//        numbers.add(27054);
//        numbers.add(27055);
//        numbers.add(27057);
//        numbers.add(27083);
//        numbers.add(27084);
//        numbers.add(27085);
//        numbers.add(27086);
//        numbers.add(27087);
//        numbers.add(27089);
//        numbers.add(27090);
//        numbers.add(27117);
//        numbers.add(27144);
//        numbers.add(27150);
//        numbers.add(27151);
//        numbers.add(27152);
//        numbers.add(27153);
//        numbers.add(27154);
//        numbers.add(27155);
//        numbers.add(27156);
//        numbers.add(27157);
//        numbers.add(27158);
//        numbers.add(27159);
//        numbers.add(27160);
//        numbers.add(27161);
//        numbers.add(27162);
//        numbers.add(27163);
//        numbers.add(27164);
//        numbers.add(27165);
//        numbers.add(27166);
//        numbers.add(27167);
//        numbers.add(27168);
//        numbers.add(27169);
//        numbers.add(27170);
//        numbers.add(27171);
//        numbers.add(27172);
//        numbers.add(27173);
//        numbers.add(27174);
//        numbers.add(27175);
//        numbers.add(27197);
//        numbers.add(27198);
//        numbers.add(27199);
//        numbers.add(27201);
//        numbers.add(27202);
//        numbers.add(27204);
//        numbers.add(27205);
//        numbers.add(27206);
//        numbers.add(27233);
//        numbers.add(28505);
//        numbers.add(28508);
//        numbers.add(28575);
//        numbers.add(28576);
//        numbers.add(28749);
//        numbers.add(28750);



//        numbers.add(29109);
//        numbers.add(29110);
//        numbers.add(29111);
//        numbers.add(29112);
//        numbers.add(43282);
//        numbers.add(43289);
//        numbers.add(43290);
//        numbers.add(24436);
//        numbers.add(24437);
//        numbers.add(24439);
//        numbers.add(24448);
//        numbers.add(24449);
//        numbers.add(24452);
//        numbers.add(24453);
//        numbers.add(24455);
//        numbers.add(24458);
//        numbers.add(24467);
//        numbers.add(24478);
//        numbers.add(24479);
//        numbers.add(24497);
//        numbers.add(25275);
//        numbers.add(25648);
//        numbers.add(26335);
//        numbers.add(26337);
//        numbers.add(26358);
//        numbers.add(26361);
//        numbers.add(26372);
//        numbers.add(26374);
//        numbers.add(26388);
//        numbers.add(28496);
//        numbers.add(28849);
//        numbers.add(43298);
//        numbers.add(43299);
//        numbers.add(43300);
//        numbers.add(43301);

        return numbers;

        //For entering a start value and end value for corresponding quest{id} values if they are sequential
//        List<Integer> range = IntStream.rangeClosed(start, end)
//                .boxed().collect(Collectors.toList());
//        return range;
    }

    /**
     * Retrieves BattleNet API information (QuestApiDAO) with relevant information to fill the table in the database
     * @param quests -- list of integers that correspond to quest{id} endpoints
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

            // USE WHEN QUEST HAS NULL POINTER FOR GOLD/SILVER/COPPER
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
     * @throws IOException io exception
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
