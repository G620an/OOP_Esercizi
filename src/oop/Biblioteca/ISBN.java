package oop.Biblioteca;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.*;

public class ISBN implements Comparable<ISBN>, Serializable{
  private String isbn;
  private static final String regex = "^([0-9]{9})(0-9X)$";
  private static  Pattern p = Pattern.compile(regex);
  
  public ISBN (String isbn){
    if(isbn == null) throw new IllegalArgumentException();
    if(isbn.length() != 10) throw new IllegalArgumentException();
    Matcher m = p.matcher(isbn);
    if(!m.matches()) throw new IllegalArgumentException();
    this.isbn = isbn;
  }

  public String getISBN(){
      return this.isbn;
  }

  @Override
    public String toString(){
      return this.getISBN();
  }

  @Override
    public boolean equals(Object o){
      if(o == null)return false;
      if(this == o)return true;
      if(o instanceof ISBN i){
          return this.getISBN().equals(i.getISBN());
      }
      return false;
  }

  @Override
  public int hashCode(){
      return Objects.hash(this.getISBN());
  }

  @Override
  public int compareTo(ISBN o){
      return this.getISBN().compareTo(o.getISBN());
  }
  
}