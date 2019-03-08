package com.moviesapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class UserMovieId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
    private Long userId;
 
    @Column(name = "movie_id")
    private Long movieId;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        UserMovieId that = (UserMovieId) o;
        return Objects.equals(userId, that.userId) &&
               Objects.equals(movieId, that.movieId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(userId, movieId);
    }

}
