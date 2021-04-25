package com.ngtu.sdp.laboratory_work2;

import com.ngtu.sdp.laboratory_work2.builder.GraphBuilder;
import com.ngtu.sdp.laboratory_work2.nodes.AttributeNode;
import com.ngtu.sdp.laboratory_work2.nodes.ClassNode;
import com.ngtu.sdp.laboratory_work2.nodes.IndividualNode;
import com.ngtu.sdp.laboratory_work2.nodes.ValueNode;
import com.ngtu.sdp.laboratory_work2.printers.GraphPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("app")
@Scope("singleton")
public class App
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        App app = context.getBean("app", App.class);
//        ClassNode graph = app.createGraph(context);
//
//        app.printGraph(graph);
//
//        System.out.println("\n\t\t\t\t\u001B[31m Конец работы...\u001B[0m");


        ClassNode rootNode = context.getBean("class", ClassNode.class);
        rootNode.setData("Чловек");

        IndividualNode individualNode = context.getBean("individual", IndividualNode.class);
        individualNode.setData("Игорь");
        individualNode.setParent(rootNode);
        rootNode.addChildNode(individualNode);

        AttributeNode atr1 = context.getBean("attribute", AttributeNode.class);
        AttributeNode atr2 = context.getBean("attribute", AttributeNode.class);

        atr1.setData("Возраст");
        atr2.setData("Пол");

        ValueNode val1 = context.getBean("value", ValueNode.class);
        ValueNode val2 = context.getBean("value", ValueNode.class);

        val1.setData("53");
        val2.setData("M");

        val1.setParent(atr1);
        val2.setParent(atr2);
        atr1.addChildNode(val1);
        atr2.addChildNode(val2);

        individualNode.addChildNode(atr1);
        individualNode.addChildNode(atr2);

        atr1.setParent(individualNode);
        atr2.setParent(individualNode);

        System.out.println(individualNode.hashCode());


        context.close();

        //Обработка исключений реализованных в рамке данной работы

    }

    //Dependency Injection
    @Autowired
    private GraphBuilder builder;
    private ClassNode createGraph(ClassPathXmlApplicationContext context)
    {
        return builder.build(context);
    }

    @Autowired
    private GraphPrinter printer;
    private void printGraph(ClassNode rootNode)
    {
        printer.print(rootNode);
    }
}