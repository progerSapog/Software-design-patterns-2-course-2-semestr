package com.ngtu.sdp.laboratory_work2;

import com.ngtu.sdp.laboratory_work2.builder.Builder;
import com.ngtu.sdp.laboratory_work2.builder.Director;
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
    @Autowired
    private GraphPrinter graphPrinter;

    @Autowired
    private Builder GraphBuilder;

    /**
     * Точка входа в программу
     * */
    public static void main(String[] args )
    {
        //Получение контекста из XML файла
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Получение экземпляра класса App
        App app = context.getBean("app", App.class);
        Director director = context.getBean("director", Director.class);
        Optional<ContainerNode> nodeOpt = director.constructorGraph(app.GraphBuilder);

        //Если обретка не пуста, то выводим граф
        nodeOpt.ifPresent(containerNode -> app.graphPrinter.print(containerNode));

        //закрытие контекста
        context.close();
    }
}