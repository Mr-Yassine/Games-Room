package gametype;


public class GameType {
    private String name;

    public GameType(String name){
        this.name = name;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name;
    }
}
