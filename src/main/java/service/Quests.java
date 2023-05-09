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
//        numbers.add(1168);
//        numbers.add(1201);
//        numbers.add(1202);
//        numbers.add(1204);
//        numbers.add(1205);
//        numbers.add(1222);
//        numbers.add(1258);
//        numbers.add(1270);
//        numbers.add(1271);
//        numbers.add(9437);
//        numbers.add(11208);
//        numbers.add(11211);
//        numbers.add(11212);
//        numbers.add(11213);
//        numbers.add(11215);
//        numbers.add(25051);
//        numbers.add(25292);
//        numbers.add(26596);
//        numbers.add(26682);
//        numbers.add(26687);
//        numbers.add(26696);
//        numbers.add(26701);
//        numbers.add(26702);
//        numbers.add(27182);
//        numbers.add(27183);
//        numbers.add(27184);
//        numbers.add(27186);
//        numbers.add(27188);
//        numbers.add(27189);
//        numbers.add(27190);
//        numbers.add(27191);
//        numbers.add(27210);
//        numbers.add(27211);
//        numbers.add(27212);
//        numbers.add(27213);
//        numbers.add(27214);
//        numbers.add(27215);
//        numbers.add(27216);
//        numbers.add(27217);
//        numbers.add(27218);
//        numbers.add(27219);
//        numbers.add(27220);
//        numbers.add(27221);
//        numbers.add(27222);
//        numbers.add(27229);
//        numbers.add(27234);
//        numbers.add(27235);
//        numbers.add(27236);
//        numbers.add(27237);
//        numbers.add(27238);
//        numbers.add(27239);
//        numbers.add(27240);
//        numbers.add(27241);
//        numbers.add(27242);
//        numbers.add(27243);
//        numbers.add(27244);
//        numbers.add(27245);
//        numbers.add(27246);
//        numbers.add(27247);
//        numbers.add(27248);
//        numbers.add(27249);
//        numbers.add(27251);
//        numbers.add(27252);
//        numbers.add(27253);
//        numbers.add(27254);
//        numbers.add(27255);
//        numbers.add(27256);
//        numbers.add(27257);
//        numbers.add(27258);
//        numbers.add(27259);
//        numbers.add(27260);
//        numbers.add(27261);
//        numbers.add(27262);
//        numbers.add(27263);
//        numbers.add(27264);
//        numbers.add(27284);
//        numbers.add(27285);
//        numbers.add(27286);
//        numbers.add(27287);
//        numbers.add(27288);
//        numbers.add(27289);
//        numbers.add(27291);
//        numbers.add(27292);
//        numbers.add(27293);
//        numbers.add(27294);
//        numbers.add(27295);
//        numbers.add(27296);
//        numbers.add(27297);
//        numbers.add(27306);
//        numbers.add(27336);
//        numbers.add(27339);
//        numbers.add(27340);
//        numbers.add(27346);
//        numbers.add(27347);
//        numbers.add(27348);
//        numbers.add(27407);
//        numbers.add(27408);
//        numbers.add(27409);
//        numbers.add(27410);
//        numbers.add(27411);
//        numbers.add(27412);
//        numbers.add(27413);
//        numbers.add(27414);
//        numbers.add(27415);
//        numbers.add(27416);
//        numbers.add(27417);
//        numbers.add(27418);
//        numbers.add(27419);
//        numbers.add(27424);
//        numbers.add(27425);
//        numbers.add(27426);
//        numbers.add(27427);
//        numbers.add(27428);
//        numbers.add(27429);
//        numbers.add(27430);
//        numbers.add(28552);
//        numbers.add(28554);

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
