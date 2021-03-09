package propertys;

import nodes.Node;

/**
 * Свойство данных - связь между
 * Узлом родителем типа ClassNode и дочерним узлом
 * типа ClassNode или IndividualNode
 *
 * @see Node
 * @see nodes.ClassNode
 * @see nodes.IndividualNode
 * */
public class DataProperty extends Property
{

    /**
     * Констурктор с параметром,
     * использует конструктор род. класса
     * */
    public DataProperty(Node childNode)
    {
        super(childNode);
    }
}
