package com.example.springbatch.batch;

import com.example.springbatch.model.Books;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

import java.io.File;

//@Component
public class CsvWriter implements ItemWriter<Books> {

    private static final Logger log = LoggerFactory.getLogger(CsvWriter.class);
    private static final String CSV_FILE = "csv_output.csv";
    //private FlatFileItemWriter<Books> writer;
    FlatFileItemWriter<Books> writer = new FlatFileItemWriter<>();

    public CsvWriter() {
        initializeCsvFile();
        log.info("Writing to file...");
        writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource(CSV_FILE));
        writer.setAppendAllowed(true);  //All job repetitions should "append" to same output file
        writer.setLineAggregator(
            new DelimitedLineAggregator<Books>() {
                {
                    setDelimiter(",");
                    setFieldExtractor(new BeanWrapperFieldExtractor<Books>() {
                        {
                            setNames(new String[]{ "id", "author", "name", "price" });
                        }
                    });
                }
            }
        );
        writer.open(new ExecutionContext());
        log.info("FINISHED Writing to file...");
    }

    private void initializeCsvFile() {
        File file = new File("src/" + CSV_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (Exception e) {
                throw new RuntimeException("Error creating CSV file", e);
            }
        }
    }

    @Override
    public void write(Chunk<? extends Books> items) throws Exception {
        writer.write(items);
    }

}
