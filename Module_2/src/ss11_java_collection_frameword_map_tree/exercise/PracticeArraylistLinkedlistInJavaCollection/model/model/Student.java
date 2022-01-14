package ss11_java_collection_frameword_map_tree.exercise.PracticeArraylistLinkedlistInJavaCollection.model.model;

public class Student extends Person {
    private int point;
    private String className;

    public Student() {
    }

    public Student(int point, String className) {
        this.point = point;
        this.className = className;
    }

    public Student(int id, String name, String address, String dateOfBirth, int point, String className) {
        super(id, name, address, dateOfBirth);
        this.point = point;
        this.className = className;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", point=" + point +
                ", className='" + className + '\'';
    }
}
