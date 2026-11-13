import java.io.*;

public class DiaryFile {
    public static MyLinkListCreate setup() throws IOException {
        File soubor = new File("denik.dat");
        if (!soubor.exists()) {
            soubor.createNewFile();
            MyLinkListCreate diary=new MyLinkListCreate();
            diary.numberOfDays=0;
            uloz(diary);
            return diary;
        }
        else{
            MyLinkListCreate diary=nacti();
            return diary;
        }
    }
    public static void uloz(MyLinkListCreate diary){
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("denik.dat")
            );
            out.writeObject(diary);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static MyLinkListCreate nacti(){
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("denik.dat")
            );
            MyLinkListCreate diary = (MyLinkListCreate) in.readObject();
            in.close();
            return diary;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
