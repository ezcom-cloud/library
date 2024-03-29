package com.masvida.libreria.masvidalibreria.Model;


import com.masvida.libreria.masvidalibreria.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addbook")
    public String addBook(@Valid Book book, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-book";
        }

        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";

    }

    @GetMapping("/edit/book/{isbn}")
    public String updateBook(@PathVariable("id") long id, Model model){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book id" + id));
        model.addAttribute("book", book);
        return "update-book";

    }

    @PostMapping("/update/book/{id}")
    public String updateBook(@PathVariable("id") long id, @Valid Book book,
                             BindingResult result, Model model){
        if (result.hasErrors()) {
            book.setId(id);
            return "update-book";
        }

        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";

    }

    @GetMapping("/delete/book/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        bookRepository.delete(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }
    // additional CRUD methods





}
