package edu.pja.mas.s22460.mp5;

import edu.pja.mas.s22460.mp5.model.Library;
import edu.pja.mas.s22460.mp5.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final LibraryRepository libraryRepository;


    @EventListener
    public void atStart(ContextRefreshedEvent ev){
        System.out.println("context refreshed");
        Iterable<Library> all = libraryRepository.findAll();
        System.out.println(all);
    }

}
