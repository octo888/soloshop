package com.rest.controller;

import com.core.entity.Book;
import com.core.entity.Image;
import com.core.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping("/book/{id}")
    public String showBook(@PathVariable long id, Model model){
        model.addAttribute("book", bookService.findOneById(id));
        return "book";
    }

    @RequestMapping("/admin/addbook")
    public String showAddBook(Model model) {
        model.addAttribute("genres", bookService.getGenreList());
        return "addbook";
    }

    @RequestMapping(value = "/admin/addbook", method = RequestMethod.POST)
    public String doAddBook(@RequestParam(value = "name") String name,
                          @RequestParam(value = "author") String author,
                          @RequestParam(value = "description") String description,
                          @RequestParam(value = "publisher") String publisher,
                          @RequestParam(value = "publishYear") String publishYear,
                          @RequestParam(value = "selectGenre") String genre,
                          @RequestParam(value = "cover") String cover,
                          @RequestParam(value = "isbn") String isbn,
                          @RequestParam(value = "price") Integer price,
                          @RequestParam(value = "image") MultipartFile image,
                          HttpServletResponse response
                          ) {
        try {
            Book book = new Book();
            book.setName(name);
            book.setAuthor(author);
            book.setCategory(bookService.findCategoryByName("Книги"));
            book.setLongDesc(description);
            book.setShortDesc(description.substring(0, 70) + "...");
            book.setPublisher(publisher);
            book.setPublishYear(publishYear);
            book.setIsbn(isbn);
            book.setGenre(genre);
            book.setCover(cover);
            book.setPrice(price);
            book.setDateOnSite(new Date());
            book.setImage(image.isEmpty() ? null : new Image(image.getOriginalFilename(), image.getBytes()));

            bookService.save(book);
            return "redirect:/admin/addbook.html";
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    @RequestMapping("/image/{file_id}")
    public void getImage(HttpServletRequest request, HttpServletResponse response, @PathVariable("file_id") long id) throws IOException {
        try {
            Image content = bookService.getImage(id);
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(content.getBody());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
