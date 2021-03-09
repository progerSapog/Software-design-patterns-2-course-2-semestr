import nodes.ChildNodeException;
import nodes.ClassNode;
import nodes.IndividualNode;

public class Main
{
    public static void main(String[] args)
    {
        try {
            //Пустой класс - возможность создавать пустые класс (Как в задании написано)
            //СостояниеЖ класс
            ClassNode classNode1 = new ClassNode("Пустой класс");

            //Класс студент
            //Состояние: класс, содержит индивида
            //Содержит 3 Индивида: Игорь, Коля, Петя
            //У Игоря и Пети только 1 атрибут - ID (ID задается автоматически)
            //У Коли 3 атрибута: ID, Пол, Возраст
            ClassNode classNode2 = new ClassNode("Студент");
            IndividualNode individualNode1 = new IndividualNode("Игорь");

            IndividualNode individualNode2 = new IndividualNode("Коля");
            individualNode2.addAttribute("Пол", "М");
            individualNode2.addAttribute("Возраст", "19");


            IndividualNode individualNode3 = new IndividualNode("Петя");

            classNode2.addChild(individualNode1);
            classNode2.addChild(individualNode2);
            classNode2.addChild(individualNode3);

            //Класс Человек
            //Состояние: Класс, имеет индивидаб имеет подкласс
            //Содержит пустой подкласс Пустой класс, класс с Индвидами - Женщина,
            //индивида - василия
            //
            //Подкласс женщина имеет индивида с автоматический созданным id
            //и индивида с атрибутами
            ClassNode classNode3 = new ClassNode("Человек");
            ClassNode classNode4 = new ClassNode("Пустой класс");
            ClassNode classNode5 = new ClassNode("Женщина");

            IndividualNode individualNode4 = new IndividualNode("Оля");
            individualNode4.addAttribute("Возраст", "32");
            individualNode4.addAttribute("Отдел", "HR");

            IndividualNode individualNode5 = new IndividualNode("Варя");
            IndividualNode individualNode6 = new IndividualNode("Василий");

            classNode5.addChild(individualNode4);
            classNode5.addChild(individualNode5);

            classNode3.addChild(classNode4);
            classNode3.addChild(classNode5);
            classNode3.addChild(individualNode6);

            System.out.println("end");
        } catch (ChildNodeException e)
        {
            e.printStackTrace();
        }
    }
}
