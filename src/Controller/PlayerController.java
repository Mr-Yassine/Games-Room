package Controller;

import Enums.PackGame;
import Helpers.MenuHelper;
import Model.MoneyBox;
import Model.Person;
import Model.Post;
import gametype.GameType;
import gametype.Action;
import gametype.Sport;

import javax.lang.model.type.NullType;

import static Helpers.Helper.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class PlayerController {


    public static Scanner scanner = new Scanner(System.in);
    public  ArrayList<GameType>  gameTypeArrayList = new ArrayList<>();
    public  ArrayList<Person> personArrayList = new ArrayList<>();
    public  ArrayList<Post> postArrayList = new ArrayList<>();
    public  ArrayList<Post> postFind = new ArrayList<>();
    public  HashSet<Post> postNotAvailable = new HashSet<>();
    public  PackGame packGame;
    public  HashSet<String> hashListGame = new HashSet<>();


    public void fillListPost(){
        postArrayList.add(new Post(1,"PlayStation5","Samsung",arrayListGame() ,true));
        postArrayList.add(new Post(2,"PlayStation5","Asus",arrayListGame() ,true));
        postArrayList.add(new Post(3,"Xbox","HP",arrayListGame() ,true));
        postArrayList.add(new Post(4,"Xbox","Asus",arrayListGame() ,true));
        postArrayList.add(new Post(5,"Xbox","Asus",arrayListGame() ,true));
        postArrayList.add(new Post(6,"Nintendo switch","Dell",arrayListGame() ,true));
        postArrayList.add(new Post(7,"Nintendo switch","Dell",arrayListGame() ,true));

    }
    public void fillPostNotAvailable(){

        for (Post posts : postArrayList) {
            if (!posts.available()) {
                postNotAvailable.add(posts);
            }
        }
        /*
        for (Post posts : postNotAvailable){
            print("\t\t\t\t\t********************************** POST NOT AVAILABLE NOW **********************************");
            print("\t\t\t\t\tPost Number : " + posts.getNumberPost() + "\n\t\t\t\t\tGames : " + posts.getGamesType() + " \n\t\t\t\t\tDisplay type : " + posts.getTypeDisplay() + " \n\t\t\t\t\tPlay type : " + posts.getTypeEng() + "\n\t\t\t\t\t" + posts.isAvailable());
            print("\t\t\t\t\t**********************************************************************************");

        }
         */

    }

    public void fillListGame(){
        gameTypeArrayList.add(new Sport("FIFA2021"));
        gameTypeArrayList.add(new Sport("PES2021"));
        gameTypeArrayList.add(new Sport("Riders Republic"));
        gameTypeArrayList.add(new Sport("EA SPORTS NHL"));
        gameTypeArrayList.add(new Sport("NBA 2K22"));
        gameTypeArrayList.add(new Sport("Tennis world tour 2"));
        gameTypeArrayList.add(new Action("GTA5"));
        gameTypeArrayList.add(new Action("WWA"));
        gameTypeArrayList.add(new Action("CALL OF DUET"));
        gameTypeArrayList.add(new Action("Battlefield 2042"));
        gameTypeArrayList.add(new Action("The Demon World"));
        gameTypeArrayList.add(new Action("ALL-STAR BRAWL"));
        gameTypeArrayList.add(new Action("World War 2"));
        gameTypeArrayList.add(new Action("Bonfire Peaks"));
        gameTypeArrayList.add(new Action("Death Stranding"));
    }


    public ArrayList<GameType> arrayListGame(){

        ArrayList<GameType> gameReturn = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < 4 ; i++){
            int x = random.nextInt(gameTypeArrayList.size());
            gameReturn.add(gameTypeArrayList.get(x));
        }
        return  gameReturn;
    }

    public boolean searchGame(String game){

        for(String games : hashListGame)
            if(game.equals(games.toUpperCase()))
                return true;
        return false;


    }
    public void searchPost(String game){

        ArrayList<Post> post = new ArrayList<>();
        ArrayList<GameType> games = new ArrayList<>();

        for (Post posts : postArrayList) {
            games = posts.getGames();
            for (GameType g : games)
                if (game.equals(g.getName().toUpperCase())) {
                    if (posts.available()) {
                        print("\n********************************** POST AVAILABLE NOW **********************************");
                        print("Post Number : " + posts.getNumberPost() + "\n\t\t\t\t\tGames : " + posts.getGamesType() + " \n\t\t\t\t\tDisplay type : " + posts.getTypeDisplay() + " \n\t\t\t\t\tPlay type : " + posts.getTypeEng() + "\n\t\t\t\t\t" + posts.isAvailable());
                        print("**********************************************************************************\n");
                        postFind.add(posts);
                    } else
                        print("Post Number : " + posts.getNumberPost()+" is not available for now");
                }
        }

    }
    public void showListPlayer(){
        print("\n\n----------------------------------------------{ List Of Players }----------------------------------------------");
        for (Person p : personArrayList)
            print("|\t\t\t\t\t\t\t Code Game : "+p.getCodeGame()+"\nName : " + p.getFirsName()+"\nLast Name : "+p.getLastName() + "\n"+ this.packGame + "\n");
        print("\t\t---------------------------------------------------------------------------------------------------------------");

    }

    public void showPosts(){
        int cmp = 0;
        for (Post p1 : postArrayList) {
            print("\t\t\t\t\t********************************** POST NUMBER "+ (cmp+1) + "**********************************");
            print("\t\t\t\t\tPost Number : " + p1.getNumberPost() + "\n\t\t\t\t\tGames : " + p1.getGamesType() + " \n\t\t\t\t\tDisplay type : " + p1.getTypeDisplay() + " \n\t\t\t\t\tPlay type : " + p1.getTypeEng() + "\n\t\t\t\t\t" + p1.isAvailable());
            print("\t\t\t\t\t**********************************************************************************");
            cmp++;
        }
    }

    public void fillGames(){

        for (Post p1 : postArrayList) {
            for (GameType g : p1.getGames()){
                hashListGame.add(g.getName());
            }
        }
    }

    public boolean checkPost(int nb_post){

        for (Post p : postFind)
            if (p.getNumberPost() == nb_post){
                postFind.clear();
                postFind.add(p);
                return  true;
            }
        return false;
    }

    public void listGame(){
        print("################################## LIST GAME ##################################");
        for (String game : hashListGame) {
            print("**\t\t\t\t\t\t " + game.toUpperCase() );
        }
        print("###############################################################################\n");
    }



    public  void addplayer(){
        LocalTime time = LocalTime.now();
        //Show List games
        listGame();


        String game ;
        do{
            printl("chose a game : ");
            game = scanner.nextLine();
            if (!searchGame(game.toUpperCase()))
                print("This game is not exist in list game !!! try again ");
        }while (!searchGame(game.toUpperCase()));


        searchPost(game.toUpperCase());
        print(" Number of post available is : "+postFind.size());
        int numberPost ;
        try {
            if(postFind.size() > 0) {
                while (true) {
                    printl("Chose number post of this post available : ");
                    numberPost = scanner.nextInt();
                    if (checkPost(numberPost)) {
                        print(postFind.get(0).getNumberPost());
                        break;
                    } else {
                        print("This Post is not chosen !!!");
                    }
                }

                printl("First Name : ");
                String name = scanner.next();

                printl("Last Name : ");
                String lastname = scanner.next();

                print("############################ { Chose Pack Period } ############################");
                print(" { 1 - "+ PackGame.HALF_HOUR +" } ");
                print(" { 2 - "+ PackGame.HOUR+" } ");
                print(" { 3 - "+ PackGame.TWO_HOURS+" } ");
                print(" { 4 - "+ PackGame.FAVE_HOURS+" } ");
                print(" { 5 - "+ PackGame.ALL_JOURNEY+" } ");
                print("###############################################################################");

                while (true){
                    printl("\nPack number  : ");
                    int packNumber = scanner.nextInt();
                    switch(packNumber){
                        case 1 : packGame = PackGame.HALF_HOUR;
                            print(packGame);
                            break;
                        case 2 : packGame = PackGame.HOUR;
                            print(packGame);
                            break;
                        case 3 : packGame = PackGame.TWO_HOURS;
                            print(packGame);
                            break;
                        case 4 : packGame = PackGame.FAVE_HOURS;
                            print(packGame);
                            break;
                        case 5 : packGame = PackGame.ALL_JOURNEY;
                            print(packGame);
                            break;
                        default:
                            print("this number not exist in pack game !!!");
                            continue;
                    }

                    break;
                }

                while (true) {
                    try{
                        print("\n\n############################ Enter start time ############################ ");
                        System.out.print("Enter HOUR : ");
                        String hourP = scanner.next();

                        System.out.print("Enter Minutes :");
                        String minP = scanner.next();

                        if (Integer.parseInt(hourP) >= 8 || Integer.parseInt(hourP) < 12 || Integer.parseInt(hourP) >= 14 || Integer.parseInt(hourP) > 20 ) {
                            if( (Integer.parseInt(hourP) == 11 && Integer.parseInt(minP) >= 0) && packGame.getDuration() > 30   )
                            {
                                System.out.println("We close in this time sorry !!");
                                continue;
                            }

                            int hour = Integer.parseInt(hourP) ;
                            int min = Integer.parseInt(minP);
                            time = LocalTime.of(hour, min);



                        } else {
                            print("This time is not available");
                        }

                    }catch (Exception e){
                        print(e.getMessage());
                    }

                    print("####################################################################################");
                    print("|\t\t\t\t\t\t\t # Name       : "+name);
                    print("|\t\t\t\t\t\t\t # Last Name  : "+lastname);
                    print("|\t\t\t\t\t\t\t # Game chose : "+ game);
                    print("|\t\t\t\t\t\t\t # Pack Time  : "+ packGame);
                    print("|\t\t\t\t\t\t\t # Post chose : Post NB° "+ postFind.get(0).getNumberPost() +" | Display "+ postFind.get(0).getTypeDisplay()+" | Play type " + postFind.get(0).getTypeEng() );
                    print("####################################################################################");

                    personArrayList.add(new Person(name,lastname,game,time,postFind.get(0),packGame));
                    MoneyBox.setTotal(packGame.getPrice());
                    showListPlayer();
                    break;
                }

            }
        }catch(Exception e){
            print(e.getMessage());
        }

    }

    public  void switchMethod(){
        fillListGame();
        //Method Fill List Post
        fillListPost();
        //fill list post not available
        fillPostNotAvailable();
        //show list post exist
        fillGames();

        String chose = "nothing";

        while (!chose.equals("EXIT")) {
            MenuHelper.menu();
            chose = scanner.next().toUpperCase();
            try {
                switch (chose) {
                    case "1":
                        addplayer();

                        break;
                    case "2":
                        showListPlayer();

                        break;
                    case "3":
                        showPosts();

                        break;
                    case "4":
                        //showListPlayer();

                        break;
                    case "5":
                        print("View Money Box");
                        print(" TOTAl MONEY GET IS :" + MoneyBox.getTotal() + " DH");
                        break;
                    case  "EXIT" :
                        break;
                    default:
                        print("Operation not found !!! "+chose);
                }
            } catch (Exception e) {
                print("Error !!");
            }


        }
    }
}

