package androidcourse.traveldiary;



public class Destination {

    private String name;
    private int image;


    public Destination(String name, int photo) {
        this.name = name;
        this.image = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int photo) {
        this.image = photo;
    }
}
