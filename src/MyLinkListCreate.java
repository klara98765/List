import java.io.Serializable;
import java.util.Scanner;

public class MyLinkListCreate implements Serializable {
    private static final long serialVersionUID = 1L;
    public MyLinkList firstDay;
    public MyLinkList lastDay;
    public int numberOfDays;

    public void add(MyLinkList day){
        if(firstDay==null){
            firstDay=day;
            lastDay=day;
            day.prevAddress = null;
        }else{
            lastDay.nextAddress=day;
            day.prevAddress = lastDay;
            lastDay=day;
        }
    }
    public void delete(MyLinkList day) {
        if (day == firstDay && day == lastDay) {
            firstDay = null;
            lastDay = null;
        } else if (day == firstDay) {
            firstDay = day.nextAddress;
            firstDay.prevAddress = null;
        } else if (day == lastDay) {
            lastDay = day.prevAddress;
            lastDay.nextAddress = null;
        } else {
            day.prevAddress.nextAddress = day.nextAddress;
            day.nextAddress.prevAddress = day.prevAddress;
        }
        day.prevAddress = null;
        day.nextAddress = null;
        numberOfDays--;
    }

    public void addDay() {
        MyLinkList n = new MyLinkList();
        add(n);
        Scanner scanner = new Scanner(System.in);
        IO.println("Zadej první záznam: ");
        String text = scanner.nextLine();
        n.records.add(text);
        numberOfDays++;
    }
}
