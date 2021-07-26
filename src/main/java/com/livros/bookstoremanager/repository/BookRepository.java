package com.livros.bookstoremanager.repository;

import com.livros.bookstoremanager.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
