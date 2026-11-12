import java.io.Serializable;
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

    public void add(String record){
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

    public void readAll(){
        for(int i=0; i<index; i++){
            int number=i+1;
            IO.println(number+" "+records[i]);
        }
    }
}
