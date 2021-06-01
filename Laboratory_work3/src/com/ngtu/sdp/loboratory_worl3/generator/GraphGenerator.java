package com.ngtu.sdp.loboratory_worl3.generator;

import com.ngtu.sdp.loboratory_worl3.query.Query;
import com.ngtu.sdp.loboratory_worl3.builder.Builder;
import com.ngtu.sdp.loboratory_worl3.nodes.*;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/**
 * Генератор графовой структуры.
 * Созданный граф содержит:
 *     Корневой узел
 *     1-4 подкласса корневого узла
 *     0-4 индивидов для каждого подкласса
 *     1-5 атрибутов для каждого индивида (включая ID)
 *
 * @see Generator
 * @see Builder
 * @see Query
 * */
public class GraphGenerator implements Generator<ClassNode>
{
    /**
     * Генерация графа.
     * Имя графа берется из запроса.
     *
     * @param builder - билдер при помощи которого будет создавать графовая структура.
     * @param query   - запрос на создание графа.
     * @return ссылка на корень созданного графа
     * */
    @Override
    public ClassNode generate(Query query, Builder builder)
    {
        Queue<ContainerNode> nodeQueue = new ArrayDeque<>();    //очередь для создания узлов

        ContainerNode outputNode;                               //переменная для хранения обрабатываемого
                                                                //(вытащенного из очереди) узла

        ContainerNode tempNode;                                 //переменная для хранения ссылки на созданный узел

        /* Из запроса получаем имя графа (корневого узла).
           Создаем узел с таким именем и помещаем в очередь. */
        ClassNode rootNode = new ClassNode(query.getGraphName());
        nodeQueue.add(rootNode);

        //генерация узлов, пока очередь не будет пуста
        while (!nodeQueue.isEmpty())
        {
            //Вытаскиваем из чоереди узел, который будет обрабатывать.
            outputNode = nodeQueue.poll();

            //Обработка, если вытащенный узел принадлежит классу ClassNode
            if (outputNode instanceof ClassNode)
            {
                /* Для сокращения созданного графа иметь подклассы может только корневой узел.
                   До первой операции корневой узел не имеет состояний.
                   К корневому узлы добавляем от 1 до 3 подклассов*/
                if (((ClassNode) outputNode).getState().isEmpty())
                {
                    for (int i = 0; i < getRandomNumberUsingInts(1, 4); i++)
                    {
                        tempNode = builder.toClassNodeAddClassNode(outputNode, "подкласс" + "№" + (i + 1));
                        nodeQueue.offer(tempNode);
                    }
                }

                //Для любого узла типа ClassNode создаем от 0 до 4 индивидов
                for (int i = 0; i < getRandomNumberUsingInts(0, 5); i++)
                {
                    tempNode = builder.toClassNodeAddIndividualNode(outputNode, "индивид" + "№" + (i + 1));
                    nodeQueue.offer(tempNode);
                }
            }

            /* Обработка, если вытащенный узел принадлежит классу IndividualNode
               Создаем для индивида от 0 до 4 атрибутов + Каждый индивид по умолчанию имеет атрибут ID*/
            if (outputNode instanceof IndividualNode)
            {
                for (int i = 0; i < getRandomNumberUsingInts(0, 5); i++)
                {
                    tempNode = builder.toIndividualNodeAddAttributeNode(outputNode, "атрибут" + "№" + (i + 1), "значение");
                    nodeQueue.offer(tempNode);
                }
            }
        }
        return rootNode;
    }

    /**
     * Всопогательный метод получения случайного значения типа int
     * в заданном диапазоне [min; max)
     *
     * @param min - левая  граница диапазона (включительно)
     * @param max - правая граница диапазона (не включительно)
     * @return случайное значение из заданного диапазона.
     * */
    private int getRandomNumberUsingInts(int min, int max)
    {
        Random random = new Random();

        return random.ints(min, max)    //создание бесконечного потока интов в заданном диапазоне
                .findFirst()            //выбираем первый элемент
                .getAsInt();            //получаем его как тип int
    }
}
