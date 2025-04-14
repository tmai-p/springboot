package com.example.springbatch.config;

import com.example.springbatch.model.UsersRecord;
import com.example.springbatch.repo.UsersRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.PlatformTransactionManager;
import com.example.springbatch.model.Users;

import java.util.Collections;

/*
It's not working.
It's not able to retrieve entity data from MySQL.
ItemWriter is not writing.
 */
@Configuration
public class MyConfig {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private UsersRepository usersRepository;

    @Bean
    public RepositoryItemReader<Users> reader() {
        return new RepositoryItemReaderBuilder<Users>()
                .name("usersReader")
                .repository(usersRepository)
                .methodName("findAll")
                .pageSize(10)
                .sorts(Collections.singletonMap("id", Sort.Direction.ASC))
                .build();
    }

    @Bean
    public ItemProcessor<Users, UsersRecord> processor() {
        return users -> new UsersRecord(users.getId(), users.getUsername(), users.getPassword());
    }

    @Bean
    public ItemWriter<UsersRecord> writer() {
        return items -> {
            for (UsersRecord item : items) {
                System.out.println("Writing user: " + item);
            }
        };
    }

    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("myJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
                .<Users, UsersRecord>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
}