Package Biblioteca;

public class ISBN{
  private String isbn;
  private static String regex = "^([0-9]{9})(0-9X)$";
  private static  Pattern p = Pattern.compile(regex);
  
  public ISBN (String isbn){
    if(isbn == null) throw new IllegalArgumentException();
      
  }
}