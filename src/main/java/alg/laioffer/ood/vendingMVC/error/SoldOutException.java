package alg.laioffer.ood.vendingMVC.error;

public class SoldOutException extends RuntimeException{
    private String message;

    public SoldOutException(String string) {
        this.message = string;
    }

    public String getMessage() {
        return message;
    }
}
