package Section7.OOPpart1.POJO;

public class Pojo {
    public static void main(String[] args) {
        for(int i = 1; i <= 5; i++){
        LPAStudent s = new LPAStudent("S92300" + i,switch (i){
            case 1 -> "Mary";
            case 2 -> "Faruk";
            case 3 -> "John";
            case 4 -> "Craig";
            case 5 -> "Tim";
            default -> "Anonymous";
        },"05/11/1985","Java Class");
            System.out.println(s);
        }
        Student pojo = new Student("S9230006","Ann","1","Java");
        LPAStudent recordStudent = new LPAStudent("S9230007","Bill","2","Python");
        System.out.println(pojo );
        System.out.println(recordStudent);

        pojo.setClassList(pojo.getClassList()+ " JAVA OCP");

        System.out.println(pojo.getName() + "is taking " + pojo.getClassList());
        System.out.println(recordStudent.name() + "is taking "+ recordStudent.classList());

    }

}
