import java.time.DateTimeException;
import java.time.LocalDate;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MyLinkList implements Serializable {
    private static final long serialVersionUID = 1L;
    public MyLinkList prevAddress;
    public MyLinkList nextAddress;
    public LocalDate date;
    public MyList records;

    public MyLinkList(){
        date=zadejDatum();
        records=new MyList();
    }

    public void vypis(){
        IO.println(date);
        IO.println("Počet záznamů: "+records.index);
        records.readAll();
    }

    public LocalDate zadejDatum() {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("d.M.uuuu");

        while (true) {
            IO.println("Zadej datum (např. 20.11.2026)");
            String vstup = scanner.nextLine();
            if(vstup.equals("dnes")){
                return LocalDate.now();
            }
            try {
                return LocalDate.parse(vstup, format);
            } catch (DateTimeException e) {
                IO.println("Neplatné datum. Zkus to znovu.");
            }
        }
    }
}
