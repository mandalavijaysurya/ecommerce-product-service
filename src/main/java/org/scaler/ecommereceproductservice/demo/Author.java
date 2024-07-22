package org.scaler.ecommereceproductservice.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Entity
@Getter
@Setter
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String authorName;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "author")
//    @Fetch(FetchMode.JOIN)
    @ToString.Exclude
    private List<Book> books;
}

/*
    --- Fetch Mode Join ---
    Hibernate: select a1_0.id,a1_0.author_name,b1_0.author_id,b1_0.id,b1_0.name from author a1_0 left join book b1_0 on a1_0.id=b1_0.author_id where a1_0.id=?
    --- Without Fetch Mode ---
    Hibernate: select a1_0.id,a1_0.author_name,b1_0.author_id,b1_0.id,b1_0.name from author a1_0 left join book b1_0 on a1_0.id=b1_0.author_id where a1_0.id=?
 */
