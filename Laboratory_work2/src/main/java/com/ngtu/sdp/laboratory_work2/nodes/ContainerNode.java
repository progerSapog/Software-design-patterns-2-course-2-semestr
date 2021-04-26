package com.ngtu.sdp.laboratory_work2.nodes;

import com.ngtu.sdp.laboratory_work2.propertys.DataProperty;
import com.ngtu.sdp.laboratory_work2.propertys.ObjectProperty;
import com.ngtu.sdp.laboratory_work2.propertys.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * Лист - контейнер.
 * Имеет связи с дочерними узлами
 *
 * @see Node
 * @see ClassNode
 * @see IndividualNode
 * @see AttributeNode
 * */
public abstract class ContainerNode extends Node
{
    protected List<Property> propertyList;    //список потомков
    
    /**
     * Конструктор без параметров. Производится инициализация 
     * списка.
     * */
    public ContainerNode()
    {
        super();
        this.propertyList = new ArrayList<>();
    }

    public ContainerNode(String data)
    {
        super(data);
        this.propertyList = new ArrayList<>();
    }

    public ContainerNode(Node parent, String data)
    {
        super(parent, data);
        this.propertyList = new ArrayList<>();
    }

    /**
     * Метод для получения списка потомков.
     * 
     * @return - список потомков
     * */
    public List<Property> getPropertyList()
    {
        return propertyList;
    }

    /**
     * Метод для добавления потомка.
     *
     * @param childNode - потомок, которого необходимо добавить
     * */
    public void addChildNode(Node childNode)
    {
        //Если передан узел типа AttributeNode или ValueNode, то создание
        //свойство объекта
        if (childNode instanceof AttributeNode || childNode instanceof ValueNode)
        {
            propertyList.add(new DataProperty(childNode));
        }
        //Иначе создание связи свойство данных
        else
        {
            propertyList.add(new ObjectProperty(childNode));
        }
    }
}
