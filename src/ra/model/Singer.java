package ra.model;

public class Singer {
    private static int idCounter = 0; // For auto-incrementing ID
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private String genre;
    private boolean gender;

    public Singer(String singerName, int age, String nationality, String genre, boolean gender) {
        this.singerId = ++idCounter;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.genre = genre;
        this.gender = gender;
    }

    public Singer() {
    }

    public Singer(String singerName) {
    }

    // Getters and Setters
    public int getSingerId() {
        return singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "ID=" + singerId +
                ", Name='" + singerName + '\'' +
                ", Age=" + age +
                ", Nationality='" + nationality + '\'' +
                ", Genre='" + genre + '\'' +
                ", Gender=" + (gender ? "Nam" : "Nữ") +
                '}';
    }
}
