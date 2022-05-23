public class Acc implements Arbitrary{
    int numberAcc;

    Acc(int numberLength){
        this.numberAcc = random(numberLength);
    }
    int getNumberAccount() {
        return numberAcc;
    }

    public Integer getNumberAcc() {
        return numberAcc;
    }
}
