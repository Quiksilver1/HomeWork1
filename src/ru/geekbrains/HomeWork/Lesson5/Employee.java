package ru.geekbrains.HomeWork.Lesson5;

public class Employee {

    private String fullName;
    private String position;
    private String mail;
    protected String callNumber;
    protected int salary;
    public int age;

    public Employee(String fullName, String position, String mail, String callNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.mail = mail;
        this.callNumber = callNumber;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.printf("ФИО: %s; должность: %s; почта: %s;телефон: %s;зарплата: %d;возраст: %d%n", fullName, position,mail,callNumber,salary,age);
    }

    public static void main(String args[]){

        Employee employee1=new Employee("Борисов Николай Викторович","конструктор","boris@mail.ru","79235697900",45000,45);

        Employee[] persArray=new Employee[5];
        persArray[0]=new Employee("Чепкина Мария Валерьевна","технолог 2 категории","chepm@mail.ru","791356722420",35000,30);
        persArray[1]=new Employee("Кузнецова Алевтина Викторовна","технолог 3 категории","alya@mail.ru","7912568955",25000,25);
        persArray[2]=new Employee("Карпов Дениса Александрович","ведущий технолог","karpov@mail.ru","79965467896",70000,34);
        persArray[3]=new Employee("Старцев Александр Павлович","ведущий технолог","rockinheart@mail.ru","79039945812",55000,55);
        persArray[4]=new Employee("Ревин Василий Викторович","технолог 1 категории","reva@mail.ru","79059294122",50000,41);

        persArray[1].info();
        //checkAge(String[] persArray);

        /*for (int i = 0; i < 5; i++) {
            if (persArray[i].age > 39) {
                persArray[i].info();
            }
        }*/
    }

   /* public static void checkAge(String[] persArray){
        for (int i = 0; i < 5; i++) {
            if (persArray[i].age > 39) {
                persArray[i].info();
            }
        }
    }*/
}
