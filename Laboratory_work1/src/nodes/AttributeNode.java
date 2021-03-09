package nodes;

import propertys.DataProperty;

/**
 * Узел атрибут
 * Фомрмируется при вывозе метод addAttribute
 * у узла типа IndividualNode
 *
 * Содержит значение Имя атрибута и ссылку на значение
 * */
public class AttributeNode extends Node
{
    private IndividualNode parent;
    /**
     * Конструктор с параметрами
     *
     * @param name  - имя данного атрибута
     * @param value - значение, которое будет передано узлу ValueNode
     * */
    public AttributeNode(String name, String value)
    {
        this.data = name;
        ValueNode valueNode = new ValueNode(value, this);
        addChildNode(valueNode);
    }

    /**
     * Метод для добавления дочернего узла
     * Дочерним узлом для данного типа может быть только узел
     * типа ValueNode
     * Формирует связь типа DataProperty
     *
     * @param node - дочерний узел типа ValueNode
     * */
    public void addChildNode(ValueNode node)
    {
        DataProperty property = new DataProperty(node);
        propertyList.add(property);
    }

    /**
     * Метод для задания родителя данного узла
     *
     * @param parent - ссылка на родителя
     * */
    public void setParent(IndividualNode parent)
    {
        this.parent = parent;
    }

    /**
     * метод для получения ссылки на родителя данного узла
     *
     * @return - ссвылку на родителя данного узла
     * */
    public IndividualNode getParent()
    {
        return parent;
    }

    @Override
    public String toString() {
        return "AttributeNode{" +
                "name='" + data + '\'' +
                ", propertyList=" + propertyList +
                '}';
    }
}
