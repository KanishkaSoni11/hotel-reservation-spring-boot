package com.example.hotelreservation.model;

public class Author {

  private String name;
  private int booksWritten;

  public Author() {
    // Mandatory empty constructor
  }

  public Author(String name, int booksWritten) {
    this.name = name;
    this.booksWritten = booksWritten;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBooksWritten() {
    return booksWritten;
  }

  public void setBooksWritten(int booksWritten) {
    this.booksWritten = booksWritten;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Author{");
    sb.append("name='").append(name).append('\'');
    sb.append(", booksWritten=").append(booksWritten);
    sb.append('}');
    return sb.toString();
  }
}
