package com.livros.bookstoremanager.service;

import com.livros.bookstoremanager.DTO.MessageResponseDTO;
import com.livros.bookstoremanager.entity.BookEntity;
import com.livros.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookEntity bookEntity){
        BookEntity saveBook = bookRepository.save(bookEntity);
        return MessageResponseDTO.builder()
                .message("Book created With ID" + saveBook.getId())
                .build();
    }
}
