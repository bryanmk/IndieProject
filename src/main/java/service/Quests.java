package service;

import questie.persistence.GenericDAO;
import questie.persistence.QuestApiDAO;
import questie.persistence.QuestDAO;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Quests {
    private int id;
    private String solution;
    private LocalDate printDate;
    private String editor;
    static QuestApiDAO dao;
    LocalDate date;

    public Quests() { }

    public Quests(int id, String solution, LocalDate printDate, String editor) {
        this.id = id;
        this.solution = solution;
        this.printDate = printDate;
        this.editor = editor;
    }

    /**
     * Constructor for just the printDate
     * @param printDate
     */
    public Solutions (LocalDate printDate) {
        this.printDate = printDate;
    }

    public LocalDate getDate() {
        return printDate;
    }

    @Override
    public String toString() {
        return "Solutions [" +
                "id=" + id +
                ", solution=" + solution +
                ", printDate=" + printDate +
                ", editor=" + editor + "]";
    }

    /**
     * produces a collection of dates in a range
     * @param start -- start Date
     * @param end -- end Date (which could be the current Date)
     * @return  a List of LocalDate in the range specified
     * https://www.baeldung.com/java-between-dates
     */
    public static List<String> getDates(LocalDate start, LocalDate end) {
        List<LocalDate> dateList = start.datesUntil(end).collect(Collectors.toList());
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < dateList.size(); i++) {
            strList.add(String.valueOf(dateList.get(i)));
        }
        return strList;
    }

    /**
     * Retrieves the NYTimes API information (wordleDAO) with the dates information
     * @param dates -- String List of dates to search words for
     * @return -- List<String> with correct INSERT values for a SQL statement
     */
    public static List<String> queryValues (List<String> dates) {
        List<String> solutions = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            solutions.add
                    ("('" + String.valueOf(dao.getAnswer(dates.get(i)).getSolution() + "', '" +
                            dao.getAnswer(dates.get(i)).getPrintDate() + "', " + "'" +
                            dao.getAnswer(dates.get(i)).getEditor())+ "')");
        }
        return solutions;
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
        dao = new wordleDAO();
//        LocalDate startDate = LocalDate.parse("2021-06-19"); // starting date for NYTimes
        LocalDate startDate = LocalDate.parse("2023-01-01"); // just for a test
        LocalDate currDate = LocalDate.now();

        toFile(queryValues(getDates(startDate, currDate)));





    }
}
