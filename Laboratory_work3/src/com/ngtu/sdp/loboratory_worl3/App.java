package com.ngtu.sdp.loboratory_worl3;


import com.ngtu.sdp.loboratory_worl3.builder.GraphBuilder;
import com.ngtu.sdp.loboratory_worl3.generator.Generator;
import com.ngtu.sdp.loboratory_worl3.generator.GraphGenerator;
import com.ngtu.sdp.loboratory_worl3.nodes.ClassNode;
import com.ngtu.sdp.loboratory_worl3.printers.GraphPrinter;
import com.ngtu.sdp.loboratory_worl3.query.Query;
import com.ngtu.sdp.loboratory_worl3.services.GeneratorService;
import com.ngtu.sdp.loboratory_worl3.services.GeneratorServiceImpl;

/**
 * Класс, содержащий точку входа в программу - метод main.
 * Язык: java
 * <p>
 * Реализация второй лабораторной работы по диспилине: Шаблоны проектирования ПО
 * Вариант №8
 * <p>
 * Текст задания: https://github.com/progerSapog/Software-design-patterns-2-course-2-semestr
 *
 * @author Vladislav Sapozhnikov 19-IVT-3 (github: https://github.com/progerSapog )
 * @author Valeriy Sukhorukov    19-IVT-3 (github: https://github.com/Valery-S    )
 * @author Vyacheslav Mostashov  19-IVT-3 (github: https://github.com/Vyacheslav-M)
 * @release: 27.04.21
 * @last_update: 27.04.21
 */

public class App
{
    /**
     * Точка входа в программу
     */
    public static void main(String[] args) throws IllegalAccessException
    {

        GraphPrinter printer = new GraphPrinter();



        for (int i = 1; i <= 10; i++)
        {
            Query query = new Query("create graph Graph" + i);

            GeneratorService generatorService = new GeneratorServiceImpl();
            ClassNode rootNode = generatorService.generateGraph(query,  new GraphBuilder());

            printer.print(rootNode);
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println();
        }
    }
}