package tianyu_19_1215;

public class ClassObject {

    public static void main(String[] args) {
        Class<ClassObject> classObjectClass = ClassObject.class;
        ClassObject object = new ClassObject();
        Class classObjectClass2 = object.getClass();
    }
}
