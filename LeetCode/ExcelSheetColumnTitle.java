package LeetCode;

public class ExcelSheetColumnTitle {

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            char ch = (char) ('A' + columnNumber % 26);
            sb.insert(0, ch);
            columnNumber = columnNumber/26;
        }
        return sb.toString();
    }

    public static String convertToTitleRecursiveApproach(int columnNumber) {
        if (columnNumber==0) return "";
        columnNumber--;
        char ch = (char) ('A' + columnNumber % 26);
        return convertToTitleRecursiveApproach(columnNumber/26) + ch;
    }

    public static void main(String[] args) {
        int columnNumber = 701;
        System.out.println(convertToTitle(columnNumber));
        System.out.println(convertToTitleRecursiveApproach(756454));
    }
}
