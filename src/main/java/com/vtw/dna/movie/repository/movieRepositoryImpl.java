package com.vtw.dna.movie.repository;

import com.vtw.dna.movie.Movie;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class movieRepositoryImpl extends QuerydslRepositorySupport implements MoviePredicate {


    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public movieRepositoryImpl(Class<?> domainClass) {
        super(domainClass);
    }

    @Override
    public List<Movie> slectMovieList(Movie movie) {

    return null;

    }
}
