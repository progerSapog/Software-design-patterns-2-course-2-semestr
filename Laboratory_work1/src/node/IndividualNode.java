package node;

import java.util.LinkedList;
import java.util.List;

/**
 * Узел индивид - "узел дерева класс"
 * Каждый индивид содержит несколько атрибутов с уникальными значениями.
 * */
public class IndividualNode implements Node {
    private ClassNode parentNode;                                      //у индивда может быть только 1 родитель
                                                                       //типа узел - класс

    private List<AttributeNode> childNodeList = new LinkedList<>();    //индивд пожет иметь несколько атрибутов

    private StringBuffer name = new StringBuffer("Ид: ");         //индивид может иметь свое имя.
                                                                  //StringBuffer в отличии от String поддерживает
                                                                  //операции над строкой не образуя новый объект.

                                                                  //Ид - просто обозначение, что это индивид, потом
                                                                  //можно убрать и заменить на простой String

    private int countOfAttribute = 0;                             //счетчик для задания id атрибутов


    public IndividualNode(StringBuffer name, ClassNode parentNode)
    {
        this.parentNode = parentNode;
        this.name.append(name);    //конкатенация строк
    }

    @Override
    public void addChildNode(String name, Node parentNode) {
        countOfAttribute++;
        childNodeList.add( new AttributeNode(Integer.toString(countOfAttribute), this));
    }
}
