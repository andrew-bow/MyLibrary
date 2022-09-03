package org.library.main.model;

import javax.persistence.*;

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
    private Person person;

    public Book(){

    }

    public Book(String name, String author, int releaseData, Person person) {
        this.name = name;
        this.author = author;
        this.releaseData = releaseData;
        this.person = person;
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

    public Person getPerson() {
        return person;
    }



    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", releaseData=" + releaseData +
                ", person=" + person +
                '}';
    }
}
