package com.example.springbatch.batch;

import com.example.springbatch.model.Books;
import org.springframework.batch.item.ItemProcessor;

/*
 * Using built in class ItemProcessor<InputType, OutputType>
 */
public class BookEntityItemProcessor implements ItemProcessor<Books, Books> {

    public Books process(Books item) {
        return item;
    }
}
