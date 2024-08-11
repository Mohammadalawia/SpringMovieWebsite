package com.movie.movieApp.services;
import com.movie.movieApp.dto.DirectorDTO;
import com.movie.movieApp.dto.DirectorMapper;
import com.movie.movieApp.repository.DirectorRepository;
import com.movie.movieApp.model.Director;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;


    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<DirectorDTO> getDirectors(){

        return directorRepository.findAll().stream()
                .map(DirectorMapper::DirectorToDirectorDtoStatic)
                .collect(Collectors.toList());

    }
    public Director GetOneDirector(Long Id) {
        Optional<Director> directorOptional =
                directorRepository.findById(Id);
        if (directorOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        return directorOptional.get();
    }
        public void saveDirectors(Director director){
        Optional<Director> directorsOptional =
                directorRepository.findDirectorByName(director.getName());
        if (directorsOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        directorRepository.save(director);


    }}