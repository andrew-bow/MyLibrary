package org.library.main.model;

import javax.persistence.*;
import java.util.List;





@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "releaseData")
    private int releaseData;


    @ManyToOne
    @JoinColumn(name = "person_id")
    private  Person person_id;

    public Person getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Person person_id) {
        this.person_id = person_id;
    }


    public Book(){

    }

    public Book(String name, String author, int releaseData ) {
        this.name = name;
        this.author = author;
        this.releaseData = releaseData;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseData() {
        return releaseData;
    }

    public void setReleaseData(int releaseData) {
        this.releaseData = releaseData;
    }







    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", releaseData=" + releaseData +
                '}';
    }
}
