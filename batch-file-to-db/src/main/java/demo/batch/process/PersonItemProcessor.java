package demo.batch.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import demo.batch.model.Person;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(Person person) throws Exception {

        String firstName = person.firstname().toUpperCase();
        String lastName = person.lastname().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);

        log.info("Converting ({}) into ({})", person, transformedPerson);
        return transformedPerson;
    }
}
