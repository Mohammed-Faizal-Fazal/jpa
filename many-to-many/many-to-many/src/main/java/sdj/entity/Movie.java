package sdj.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany
    @JoinTable(
            		name="movie_actor",
            		joinColumns={@JoinColumn(name="movie_id")},
            		inverseJoinColumns={@JoinColumn(name="actor_id")}
    )	
	private Set<Actor> actors = new HashSet<Actor>();	
	
	public Movie() {}
	public Movie(String name) {
		this.name = name;
	}
	
	public Set<Actor> getActors() {
		return actors;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + "]";
	}

}




