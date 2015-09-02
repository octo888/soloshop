package com.core.service;

import com.core.constants.GenreConstants;
import com.core.entity.Book;
import com.core.entity.Category;
import com.core.entity.Image;
import com.core.repository.BookRepository;
import com.core.repository.CategoryRepository;
import com.core.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageRepository imageRepository;

    public List<String> getGenreList() {
        GenreConstants genre = new GenreConstants();
        return genre.getGenresAsList();
    }

    public Category findCategoryByName(String name){
        return categoryRepository.findByName(name);
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Image getImage(long id) {
        return imageRepository.findOne(id);
    }

    public Book findOneById(long id) {
        return bookRepository.findOne(id);
    }

    public void delete(Long id) {
        bookRepository.delete(id);
    }
}
