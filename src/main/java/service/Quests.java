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
//        numbers.add(840);
//        numbers.add(844);
//        numbers.add(845);
//        numbers.add(848);
//        numbers.add(850);
//        numbers.add(851);
//        numbers.add(852);
//        numbers.add(855);
//        numbers.add(858);
//        numbers.add(863);
//        numbers.add(865);
//        numbers.add(867);
//        numbers.add(869);
//        numbers.add(870);
//        numbers.add(871);
//        numbers.add(872);
//        numbers.add(875);
//        numbers.add(876);
//        numbers.add(877);
//        numbers.add(880);
//        numbers.add(881);
//        numbers.add(887);
//        numbers.add(891);
//        numbers.add(895);
//        numbers.add(899);
//        numbers.add(903);
//        numbers.add(905);
//        numbers.add(4021);
//        numbers.add(5041);
//        numbers.add(9267);
//        numbers.add(13878);
//        numbers.add(13949);
//        numbers.add(13961);
//        numbers.add(13963);
//        numbers.add(13968);
//        numbers.add(13969);
//        numbers.add(13970);
//        numbers.add(13971);
//        numbers.add(13973);
//        numbers.add(13975);
//        numbers.add(13988);
//        numbers.add(13991);
//        numbers.add(13992);
//        numbers.add(13995);
//        numbers.add(13998);
//        numbers.add(13999);
//        numbers.add(14003);
//        numbers.add(14004);
//        numbers.add(14006);
//        numbers.add(14034);
//        numbers.add(14038);
//        numbers.add(14042);
//        numbers.add(14045);
//        numbers.add(14046);
//        numbers.add(14049);
//        numbers.add(14050);
//        numbers.add(14052);
//        numbers.add(14056);
//        numbers.add(14057);
//        numbers.add(14063);
//        numbers.add(14066);
//        numbers.add(14067);
//        numbers.add(14068);
//        numbers.add(14072);
//        numbers.add(14073);
//        numbers.add(25264);
//        numbers.add(26642);
//        numbers.add(26769);
//        numbers.add(28494);
//        numbers.add(28877);
//        numbers.add(29015);
//        numbers.add(29021);
//        numbers.add(29022);
//        numbers.add(29023);
//        numbers.add(29024);
//        numbers.add(29026);
//        numbers.add(29027);
//        numbers.add(29086);
//        numbers.add(29087);
//        numbers.add(29088);
//        numbers.add(29089);
//        numbers.add(29090);
//        numbers.add(29091);
//        numbers.add(29094);
//        numbers.add(29095);
//        numbers.add(29096);
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
