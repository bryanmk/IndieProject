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
        numbers.add(185);
        numbers.add(186);
        numbers.add(187);
        numbers.add(188);
        numbers.add(190);
        numbers.add(191);
        numbers.add(192);
        numbers.add(193);
        numbers.add(194);
        numbers.add(195);
        numbers.add(196);
        numbers.add(197);
        numbers.add(208);
        numbers.add(583);
        numbers.add(9436);
        numbers.add(9457);
        numbers.add(26269);
        numbers.add(26278);
        numbers.add(26279);
        numbers.add(26280);
        numbers.add(26281);
        numbers.add(26298);
        numbers.add(26299);
        numbers.add(26300);
        numbers.add(26301);
        numbers.add(26302);
        numbers.add(26303);
        numbers.add(26304);
        numbers.add(26305);
        numbers.add(26317);
        numbers.add(26321);
        numbers.add(26323);
        numbers.add(26325);
        numbers.add(26330);
        numbers.add(26332);
        numbers.add(26334);
        numbers.add(26338);
        numbers.add(26340);
        numbers.add(26343);
        numbers.add(26344);
        numbers.add(26345);
        numbers.add(26350);
        numbers.add(26351);
        numbers.add(26352);
        numbers.add(26359);
        numbers.add(26360);
        numbers.add(26362);
        numbers.add(26386);
        numbers.add(26399);
        numbers.add(26400);
        numbers.add(26403);
        numbers.add(26405);
        numbers.add(26407);
        numbers.add(26412);
        numbers.add(26416);
        numbers.add(26417);
        numbers.add(26729);
        numbers.add(26730);
        numbers.add(26731);
        numbers.add(26732);
        numbers.add(26733);
        numbers.add(26734);
        numbers.add(26735);
        numbers.add(26736);
        numbers.add(26737);
        numbers.add(26738);
        numbers.add(26739);
        numbers.add(26740);
        numbers.add(26741);
        numbers.add(26742);
        numbers.add(26743);
        numbers.add(26744);
        numbers.add(26745);
        numbers.add(26746);
        numbers.add(26747);
        numbers.add(26748);
        numbers.add(26749);
        numbers.add(26751);
        numbers.add(26763);
        numbers.add(26764);
        numbers.add(26765);
        numbers.add(26772);
        numbers.add(26773);
        numbers.add(26774);
        numbers.add(26775);
        numbers.add(26776);
        numbers.add(26779);
        numbers.add(26780);
        numbers.add(26781);
        numbers.add(26782);
        numbers.add(26783);
        numbers.add(26838);
        numbers.add(28688);
        numbers.add(28699);





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
