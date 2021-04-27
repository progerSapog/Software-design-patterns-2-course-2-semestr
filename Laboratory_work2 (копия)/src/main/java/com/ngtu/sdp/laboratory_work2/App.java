package com.ngtu.sdp.laboratory_work2;

import com.ngtu.sdp.laboratory_work2.builder.Director;
import com.ngtu.sdp.laboratory_work2.builder.GraphBuilder;
import com.ngtu.sdp.laboratory_work2.nodes.ContainerNode;
import com.ngtu.sdp.laboratory_work2.printers.GraphPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Класс, содержащий точку входа в программу - метод main.
 * Язык: java
 *
 * Реализация второй лабораторной работы по диспилине: Шаблоны проектирования ПО
 *  Вариант №8
 *
 * Текст задания: https://github.com/progerSapog/Software-design-patterns-2-course-2-semestr
 *
 * @release:     -
 * @last_update: 26.04.21
 *
 * @author Vladislav Sapozhnikov 19-IVT-3 (github: https://github.com/progerSapog )
 * @author Valerii Sukhorukov    19-IVT-3 (github: https://github.com/Valery-S    )
 * @author Vyacheslav Mostashov  19-IVT-3 (github: https://github.com/Vyacheslav-M)
 */
@Component("app")
@Scope("singleton")
public class App
{
    //Dependency Injection
    @Autowired
    private GraphBuilder graphBuilder;

    @Autowired
    private GraphPrinter graphPrinter;

    /**
     * Точка входа в программу
     * */
    public static void main(String[] args )
    {
        //Получение контекста из XML файла
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Получение экземпляра класса App
        App app = context.getBean("app", App.class);

        //Получение экземпляра директора из контекста
        Director director = context.getBean("director", Director.class);

        //Получение родительского узла в обертке Optional
        Optional<ContainerNode> nodeOpt = director.constructorGraph(app.graphBuilder);

        //Если обретка не пуста, то выводим граф
        nodeOpt.ifPresent(containerNode -> app.graphPrinter.print(containerNode));

        //закрытие контекста
        context.close();
    }
}












//    ClassNode rootNode = context.getBean("class", ClassNode.class);
//        rootNode.setData("Чловек");
//
//                IndividualNode individualNode = context.getBean("individual", IndividualNode.class);
//        individualNode.setData("Игорь");
//        individualNode.setParent(rootNode);
//        rootNode.addChildNode(individualNode);
//
//        AttributeNode atr1 = context.getBean("attribute", AttributeNode.class);
//        AttributeNode atr2 = context.getBean("attribute", AttributeNode.class);
//
//        atr1.setData("Возраст");
//        atr2.setData("Пол");
//
//        ValueNode val1 = context.getBean("value", ValueNode.class);
//        ValueNode val2 = context.getBean("value", ValueNode.class);
//
//        val1.setData("53");
//        val2.setData("M");
//
//        val1.setParent(atr1);
//        val2.setParent(atr2);
//        atr1.addChildNode(val1);
//        atr2.addChildNode(val2);
//
//        individualNode.addChildNode(atr1);
//        individualNode.addChildNode(atr2);
//
//        atr1.setParent(individualNode);
//        atr2.setParent(individualNode);
//
//        System.out.println(individualNode.hashCode());