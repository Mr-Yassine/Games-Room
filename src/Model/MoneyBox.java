package Model;



public class MoneyBox {

    private static float total;

    public MoneyBox(){}
    public MoneyBox(float money){
        setTotal(money);
    }


    public static float getTotal() {
        return total;
    }

    public static void setTotal(float total) {
        MoneyBox.total += total;
    }
}
