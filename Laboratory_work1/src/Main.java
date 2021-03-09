import nodes.ChildNodeException;
import nodes.ClassNode;
import nodes.IndividualNode;
import nodes.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
    //Константы для хранения последовательностей для
    //изменения цвета текста в консоли
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";

    public static void main(String[] args)
    {
        try {
            //Вызов метода для создания графовой структуры
            ClassNode classNode = createNewGraph();

////            //Пустой класс - возможность создавать пустые класс (Как в задании написано)
////            //Состояние: класс
////            ClassNode classNode1 = new ClassNode("Пустой класс");
////
////            //Класс студент
////            //Состояние: класс, содержит индивида
////            //Содержит 3 Индивида: Игорь, Коля, Петя
////            //У Игоря и Пети только 1 атрибут - ID (ID задается автоматически)
////            //У Коли 3 атрибута: ID, Пол, Возраст
////            ClassNode classNode2 = new ClassNode("Студент");
////            IndividualNode individualNode1 = new IndividualNode("Игорь");
////
////            IndividualNode individualNode2 = new IndividualNode("Коля");
////            individualNode2.addAttribute("Пол", "М");
////            individualNode2.addAttribute("Возраст", "19");
////
////
////            IndividualNode individualNode3 = new IndividualNode("Петя");
////
////            classNode2.addChild(individualNode1);
////            classNode2.addChild(individualNode2);
////            classNode2.addChild(individualNode3);
////
////            //Класс Человек
////            //Состояние: Класс, имеет индивидаб имеет подкласс
////            //Содержит пустой подкласс Пустой класс, класс с Индвидами - Женщина,
////            //индивида - василия
////            //
////            //Подкласс женщина имеет индивида с автоматический созданным id
////            //и индивида с атрибутами
////            ClassNode classNode3 = new ClassNode("Человек");
////            ClassNode classNode4 = new ClassNode("Пустой класс");
////            ClassNode classNode5 = new ClassNode("Женщина");
////
////            IndividualNode individualNode4 = new IndividualNode("Оля");
////            individualNode4.addAttribute("Возраст", "32");
////            individualNode4.addAttribute("Отдел", "HR");
////
////            IndividualNode individualNode5 = new IndividualNode("Варя");
////            IndividualNode individualNode6 = new IndividualNode("Василий");
////
////            classNode5.addChild(individualNode4);
////            classNode5.addChild(individualNode5);
////
////            classNode3.addChild(classNode4);
////            classNode3.addChild(classNode5);
////            classNode3.addChild(individualNode6);
//
            System.out.println("end");
        }
        catch (ChildNodeException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Метод выводящий разделитель при создании узлов
     * Скрыт, т.к. не использутеся напрямую
     * */
    private static void printSeparator()
    {
        System.out.println("------------------------------------------------------------------------" +
                "------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t" + GREEN + "Создание нового узла" + RESET);
        System.out.println("------------------------------------------------------------------------" +
                "------------------------");
    }

    /**
     * Метод выводящий информацию о переданном узле.
     * */
    public static void printNodeInfo(Node node)
    {
        //Для каждого создающегося в данный момент узла
        //выводим информацию о родителе
        System.out.print(CYAN + "Родитель: " + RESET + node.getData());

        //Если тип данного узла ClassNode, то выводим еще и состояние
        if (node instanceof ClassNode)
        {
            System.out.print(" | " + PURPLE + "Статус родителя: " + RESET + ((ClassNode)node).getState());
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------" +
                "------------------------");
    }

    /**
     * "Автомат создания графа (но это не точно автомат)"
     *
     * @return - ссылку на новую графовую структуру
     * */
    public static ClassNode createNewGraph() throws ChildNodeException
    {
        //Создаем очередь для хранения узлов
        Queue<Node> nodeQueue = new LinkedList<>();

        //Создание ссылки на узел общего типа
        Node tempNode;

        //создаем ссылку на корень
        ClassNode graphRoot = null;

        //Открытие потока ввода
        Scanner scanner = new Scanner(System.in);

        String input;    //Временные ссылки для хранения
        String name;     //введенных строк

        printSeparator();

        //Создание 1ого узла - корня графовой структуры
        //Механизм do while предалагает пользователю повторный ввод
        //при неверных введенных данных
        do {
            System.out.println("1. - Создать узел типа Класс(ClassNode)");
            System.out.println(RED + "q." + RESET + " - Завершить ввод на данном уровне");
            System.out.println();
            System.out.print("Ввод: ");

            input = scanner.nextLine();
            System.out.println();

            switch (input)
            {
                case ("1"): {
                    System.out.print("Введите имя узла: ");
                    name = scanner.nextLine();

                    graphRoot = new ClassNode(name);
                    nodeQueue.offer(graphRoot);

                    //Когда закончили ввод, то устанавливает флаг - выход
                    input = "Выход";

                    break;
                }
                case ("q"): {
                    //Если мы вышли на данном шаге, то graphRoot = null
                    //поэтому сразу возращаем null
                    return null;
                }
                default: {
                    System.out.println(RED + "Ошибка ввода..." + RESET);
                    break;
                }
            }
        }
        while (!input.equals("Выход"));
        System.out.println();

        //Цикл do while
        //пока очередь не опустее
        do
        {
            printSeparator();
            tempNode = nodeQueue.poll();    //"Вытаскиваем" узел из очереди

            assert tempNode != null;        //Проверка на null

            printNodeInfo(tempNode);        //Вывод информации о "вытащенном" узле

            //Если "вытащенный" узел имеет тип ClassNode
            //то предлагается создать дочерний подкласс или индивид
            if (tempNode instanceof ClassNode)
            {
                //Механизм do while предалагает пользователю повторный ввод
                //при неверных введенных данных
                do {
                    System.out.println("1. - Создать узел типа Подкласс(ClassNode)");
                    System.out.println("2. - Создать узел типа Индивид (IndividualNode)");
                    System.out.println(RED + "q." + RESET + " - Завершить ввод на данном уровне");
                    System.out.println();
                    System.out.print("Ввод: ");

                    input = scanner.nextLine();
                    System.out.println();

                    switch (input) {
                        //Создание нового подкласса
                        case ("1"): {
                            System.out.print("Введите имя узла: ");
                            name = scanner.nextLine();

                            ClassNode node = new ClassNode(name);

                            //Приводим общий узел к типу ClassNode и вызываем
                            //метод addChild
                            ((ClassNode) tempNode).addChild(node);

                            //Добавляем новый созданный узел в очередь
                            nodeQueue.offer(node);
                            break;
                        }
                        //Создание нового индивида
                        case ("2"): {
                            System.out.print("Введите имя индивида: ");
                            name = scanner.nextLine();

                            IndividualNode node = new IndividualNode(name);

                            //Приводим общий узел к типу ClassNode и вызываем
                            //метод addChild
                            ((ClassNode) tempNode).addChild(node);

                            //Добавляем новый созданный узел в очередь
                            nodeQueue.offer(node);
                            break;
                        }
                        case ("q"): {
                            break;
                        }
                        default: {
                            System.out.println(RED + "Ошибка ввода..." + RESET);
                            break;
                        }
                    }

                }
                while (!input.equals("q"));
            }
            System.out.println();

            //Если "вытащенный" узел имеет тип IndividualNode
            //то предлагается добавить атрибут для данного индивида
            if (tempNode instanceof IndividualNode)
            {
                //Механизм do while предалагает пользователю повторный ввод
                //при неверных введенных данных
                do {
                    System.out.println("1. - Создать узел типа Атрибут(AttributeNode)");
                    System.out.println(RED + "q." + RESET + " - Завершить ввод на данном уровне");
                    System.out.println();
                    System.out.print("Ввод: ");

                    input = scanner.nextLine();
                    System.out.println();

                    switch (input) {
                        //Создание нового атрибута
                        case ("1"): {
                            String data;

                            System.out.print("Введите имя атрибута: ");
                            name = scanner.nextLine();

                            System.out.print("Введите значение атрибута: ");
                            data = scanner.nextLine();

                            //Приводим общий узел к типу IndividualNode и вызываем
                            //метод addAttribute
                            ((IndividualNode) tempNode).addAttribute(name, data);

                            //Поскольку узла типа Атрибут и значение конечные,
                            //то их уже не добавляем в очередь
                            break;
                        }
                        case ("q"): {
                            break;
                        }
                        default: {
                            System.out.println(RED + "Ошибка ввода..." + RESET);
                            break;
                        }
                    }
                }
                while (!input.equals("q"));
            }
        }
        while (!nodeQueue.isEmpty());

        return graphRoot;
    }
}
