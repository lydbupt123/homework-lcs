import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        MyDate myDate = new MyDate(1972,2,29);
        MyDate myDate_copy = new MyDate(2099,11,12);
        MyDate myDate1 = new MyDate();
        MyDate myDate2 = new MyDate(-731);

        System.out.println(myDate.toString());
        System.out.println(myDate1.toString());
        System.out.println(myDate2.toString());

        System.out.println(myDate.equals(myDate_copy));
        System.out.println(myDate.equals(myDate1));

        System.out.println(myDate1.lessThan(myDate));
        System.out.println(myDate1.lessThan(myDate2));

        System.out.println(myDate1.lessThanOrEquals(myDate1));
        System.out.println(myDate1.lessThanOrEquals(myDate));
        System.out.println(myDate1.lessThanOrEquals(myDate2));

        System.out.println(myDate1.compareTo(myDate1));
        System.out.println(myDate1.compareTo(myDate));
        System.out.println(myDate1.compareTo(myDate2));

        System.out.println(myDate1.add(365).toString());
        System.out.println(myDate1.subtract(731).toString());

        /*String dateString1 = "1970-01-01";
        Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(dateString1);
        String dateString2 = "1968-01-01";
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString2);
        long days = ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        System.out.println(myDate.getDays());
        System.out.println(days);
        System.out.println(myDate.toString());*/

    }
}
