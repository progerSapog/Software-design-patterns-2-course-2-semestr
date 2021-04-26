package com.ngtu.sdp.laboratory_work2.nodes;

import java.util.stream.Stream;

/**
 * Класс Индивид - экземпляр класс/подкласса типа ClassNode
 *
 * @see ContainerNode
 * @see AttributeNode
 * @see ValueNode
 * */
public class IndividualNode extends ContainerNode
{
    public IndividualNode() {
        super();
    }

    public IndividualNode(Node parent, String data)
    {
        super(parent, data);
    }

    public void setID()
    {
        ValueNode valNode = new ValueNode(Integer.toString(this.hashCode()));
        AttributeNode atrNode = new AttributeNode(this, "ID");
        atrNode.addChildNode(valNode);
        valNode.setParent(atrNode);

        this.addChildNode(atrNode);
    }

    /**
     * Перегруженный метод получения хэша
     *
     * @return значение хэша данного объекта
     * */
    @Override
    public int hashCode()
    {
        int res = propertyList.stream()                  //получаем Stream из списка связей с дочерними узлами
                .map(x -> x.getChildNode().getData())    //из каждой связи получаем дочерний узел, а потом ин-ию из него
                .reduce("" , String::concat)          //складываем всю ин-ию в одну строку
                .chars()                                 //получаем стрим интов (char = int) из строки
                .reduce(0, (x, y) -> x*31 + y);       //складываем элементы, домнажая каждый новый на простое число

        res += Stream.of(parent.getData(), data)         //получаем инф-ии об узле и родителе
                .reduce("", String::concat)           //складываем всю ин-ию в одну строку
                .chars()                                 //получаем стрим интов (char = int) из строки
                .reduce(0, (x, y) -> x*31 + y);        //складываем элементы, домнажая каждый новый на простое число

        //если res отрицательный то меняем знак
        return res < 0 ? -(res) : res;
    }
}
