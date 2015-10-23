package entity;

public class Group {

    private String authors;
    private String schoolClass;
    private String group;

    public Group(String authors, String schoolClass, String group) {
        this.authors = authors;
        this.schoolClass = schoolClass;
        this.group = group;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "authors: " + authors + " schoolClass: " + schoolClass + " group: " + group;
    }

}
