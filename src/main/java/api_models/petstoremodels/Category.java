package api_models.petstoremodels;

public class Category {
    Integer id;
    String name;

    public Category(){

    }
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
