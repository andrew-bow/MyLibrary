package org.library.main.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.library.main.model.Book;
import org.library.main.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {


    private final SessionFactory sessionFactory;
    @Autowired
    public BookDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Book> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select b from Book b", Book.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Book show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    @Transactional
    public void save(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }

    @Transactional
    public void update(int id, Book updateBook) {
        Session session = sessionFactory.getCurrentSession();
        Book bookToBeUpdate = session.get(Book.class, id);
        bookToBeUpdate.setId(updateBook.getId());
        bookToBeUpdate.setName(updateBook.getName());
        bookToBeUpdate.setAuthor(updateBook.getAuthor());
        bookToBeUpdate.setReleaseData(updateBook.getReleaseData());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Book.class, id));
    }

    @Transactional
    public Optional getBookOwner(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createSQLQuery("select Person.* from Book JOIN Person ON Book.person_id = Person.id where Book.id = :id")
                .addEntity(Person.class)
                .setParameter("id", id)
                .uniqueResultOptional().stream().findAny();
    }

    @Transactional
    public void release(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createSQLQuery("update Book set person_id = null where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    // напиши метод который будет вызываться , когда человек забирает книгу из библиотеки , используй sql запрос
    @Transactional
    public void assign(int id ,  Person selectedPerson){
        Session session = sessionFactory.getCurrentSession();
        session.createSQLQuery("UPDATE Book SET person_id = :owner WHERE id = :id")
                .setParameter("id", id)
                .setParameter("owner", selectedPerson)
                .executeUpdate();
    }


}
