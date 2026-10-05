package com.example.libraryApi.book.adapters.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {

    boolean existsByIsbn(String isbn);

}
