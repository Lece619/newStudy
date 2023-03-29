public class GenericTest <T> {

    private int intData;
    private String strData;

    private T data;
    GenericFlag genericFlag = GenericFlag.INT;

    enum GenericFlag{
        INT,
        STRING
    }

    public T data(){
        if(genericFlag == GenericFlag.INT) {
            if(data instanceof Integer){
                return (T) data;
            }
        }else{
            return (T)data;
        }
        return null;
    }

    public class DataClass{

    }

    public static void main(String[] args) {
        GenericTest genericTest = new GenericTest();
        genericTest.genericFlag = GenericFlag.INT;
        genericTest.data =1;


        System.out.println("data1 = " + (genericTest.data() + 1));

    }
}
