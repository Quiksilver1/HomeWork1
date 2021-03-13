package ru.geekbrains.HomeWork.Java2.Lesson1.Interface;

        import ru.geekbrains.HomeWork.Java2.Lesson1.model.Cat;
        import ru.geekbrains.HomeWork.Java2.Lesson1.model.Human;
        import ru.geekbrains.HomeWork.Java2.Lesson1.model.Robot;

public interface Treadmill {

    void RunningHuman(Human human);

    void RunningRobot(Robot robot);

    void RunningCat(Cat cat);


}