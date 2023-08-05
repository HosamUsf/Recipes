package recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity(name = "recipe")
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    private LocalDateTime date;

    @NotBlank
    private String description;

    @ElementCollection
    @Size(min = 1)
    @NotNull
    private List<String> ingredients;

    @ElementCollection
    @Size(min = 1)
    @NotNull
    private List<String> directions;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false, name="user_id")
    private User user;



}
