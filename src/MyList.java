import java.io.Serializable;
import java.util.Scanner;

public class MyList implements Serializable {
    private static final long serialVersionUID = 1L;
    public int maxLenght;
    public int index;
    public String[] records;

    public MyList(){
        records = new String[8];
        maxLenght=8;
        index=0;
    }
    public void delete(int index2) {
        if (index2 < 0 || index2 >= index) {
            return;
        }
        String[] newRecord = new String[maxLenght];
        for (int i = 0; i < index - 1; i++) {
            if (i < index2) {
                newRecord[i] = records[i];
            } else {
                newRecord[i] = records[i + 1];
            }
        }
        index--;
        records = newRecord;
    }

    public void add(){
        String record=zadejZaznam();
        if (index+2>=maxLenght){
            maxLenght=maxLenght*2;
            String[] newRecords=new String[maxLenght];
            for(int i=0; i<index; i++){
                newRecords[i]=records[i];
            }
            records=newRecords;
        }
        records[index]=record;
        index++;
    }

    public String zadejZaznam() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder zaznam = new StringBuilder();
        IO.println("Zadávej text záznamu.");
        IO.println("Zadávání ukončíš prázdným řádkem.");
        while (true) {
            String radek = scanner.nextLine();
            if (radek.isEmpty()) {
                break;
            }
            if (zaznam.length() > 0) {
                zaznam.append("\n");
            }
            zaznam.append(radek);
        }
        return zaznam.toString();
    }

    public void readAll(){
        for(int i=0; i<index; i++){
            int number=i+1;
            IO.println(number+" "+records[i]);
        }
    }
}
