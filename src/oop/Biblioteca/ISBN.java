Package Biblioteca;

public class ISBN{
  private String isbn;
  private String regex = "([0-9]{9})(0-9X)";
  private Pattern p = Pattern.compile(regex);
  
  public ISBN (String isbn){
    
  }
}