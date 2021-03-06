package Model;


import Enums.PackGame;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;




public class Person  {


    private String firstName ;
    private String lastName;
    private String game;
    private LocalTime dateStart;
    private Post post;
    private String codeGame;
    private PackGame timePeriod;

    public Person(String firstName,String lastName , String game,LocalTime dateStart,Post post,PackGame timePeriod){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateStart =dateStart;
        this.game =game;
        this.post =post;
        this.timePeriod= timePeriod;
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter ltf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        this.codeGame = "N°_"+time.format(ltf);
    }

    public String getFirsName() {
        return firstName;
    }

    public void setFirsName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalTime getDateStart() {
        return dateStart;
    }

    public boolean setDateStart(LocalTime dateStart) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm");
        //this.dateStart = dtf.format(dateStart);
        System.out.println("this time is not accepted !!!");
        return false;
    }
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCodeGame() {
        return codeGame;
    }

    public void setCodeGame(String codeGame) {
        this.codeGame = codeGame;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public PackGame getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(PackGame timePeriod) {
        this.timePeriod = timePeriod;
    }
}
