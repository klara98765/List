//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws IOException {
    Scanner scanner = new Scanner(System.in);
    MyLinkListCreate diary=DiaryFile.setup();
    MyLinkList show=diary.lastDay;
    while(true){
        IO.println("Počet dní: "+diary.numberOfDays);
        show.vypis();
        IO.println("Možnosti: predchozi, dalsi, smaz, uloz, nacti, novy, konec, zacatek, zavri");
        switch(scanner.nextLine()){
            case "predchozi":
                if(show.prevAddress!=null){
                    show=show.prevAddress;
                }else{
                    IO.println("Toto je první záznam.");
                }
                break;
            case "dalsi":
                if(show.nextAddress!=null){
                    show=show.nextAddress;
                }
                break;
            case "smaz":
                show=deleteRecord(show, diary);
                break;
            case "uloz":
                DiaryFile.uloz(diary);
                break;
            case "nacti":
                diary=DiaryFile.nacti();
                break;
            case "novy":
                if(diary.lastDay.date.equals(LocalDate.now())){
                    diary.lastDay.records.add(zadejZaznam());
                }else{
                    diary.addDay();
                }
                show=diary.lastDay;
                break;
            case "konec":
                show=diary.lastDay;
                break;
            case "zacatek":
                show=diary.firstDay;
                break;
            case "zavri":
                DiaryFile.uloz(diary);
                return;
        }
    }
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
public MyLinkList deleteRecord(MyLinkList day, MyLinkListCreate diary){
    int cislo=-1;
    while(cislo<1 || cislo>day.records.maxLenght){
        String text = zadej("Zadej číslo záznamu, který chcete smazat: ");
        try {
            cislo = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("Neplatné číslo.");
        }
    }
    if(zadej("Opravdu chcete smazat: "+day.records.records[cislo-1]+"? (pokud ano, zadejte ano)").equals("ano")){
        IO.println("Dobře");
        day.records.delete(cislo-1);
        if(day.records.index==0){
            diary.delete(day);
            day=diary.lastDay;
        }
    }
    return day;
}
public String zadej(String line){
    Scanner scanner = new Scanner(System.in);
    IO.println(line);
    String text=scanner.nextLine();
    return text;
}