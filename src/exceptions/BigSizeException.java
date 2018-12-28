package exceptions;

public class BigSizeException extends IllegalArgumentException {
     public BigSizeException(String msg){
        super(msg);
    }
    public BigSizeException(){
         super();
    }
}
