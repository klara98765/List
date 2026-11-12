import java.time.LocalDate;
import java.io.Serializable;

public class MyLinkList implements Serializable {
    private static final long serialVersionUID = 1L;
    public MyLinkList prevAddress;
    public MyLinkList nextAddress;
    public LocalDate date;
    public MyList records;

    public MyLinkList(){
        date= LocalDate.now();
        records=new MyList();
    }

    public void vypis(){
        IO.println(date);
        IO.println("Počet záznamů: "+records.index);
        records.readAll();
    }
}
