package me.anpan.anpanwebmvc;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Member {


    private int id;

    @NotBlank
    private String name;

    @Min(0)
    private Integer tall;

    public Integer getTall() {
        return tall;
    }

    public void setTall(Integer tall) {
        this.tall = tall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
