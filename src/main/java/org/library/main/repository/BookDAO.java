package org.library.main.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.library.main.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class BookDAO {

    private final SessionFactory sessionFactory;
    @Autowired
    public BookDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Book> index(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select a from Book a" , Book.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Book show(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class , id );
    }

    @Transactional
    public void save(Book book){
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }
    @Transactional
    public void update (int id , Book updateBook){
        Session session = sessionFactory.getCurrentSession();
        Book bookToBeUpdate = session.get(Book.class ,id);
        bookToBeUpdate.setId(updateBook.getId());
        bookToBeUpdate.setName(updateBook.getName());
        bookToBeUpdate.setAuthor(updateBook.getAuthor());
        bookToBeUpdate.setReleaseData(updateBook.getReleaseData());
    }

    @Transactional
    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Book.class , id));
    }

}
