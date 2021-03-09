package nodes;

import propertys.DataProperty;

/**
 * Класс Индивид - экземпляр класс/подкласса типа
 * ClassNode
 * */
public class IndividualNode extends Node
{
    private ClassNode parent;    //ссылка на родителя

    /**
     * Метод для добавления атрибута индивиду
     * Автоматичски создает узел Атрибут, который в свою очередь создает
     * узел Value
     * Формирует связь типа DataProperty
     *
     * @param parameterName - имя параметра
     * @param value         - значение параметра
     * */
    public void addAttribute(String parameterName, String value)
    {
        AttributeNode node = new AttributeNode(parameterName, value);
        addChildNode(node);
    }

    /**
     * Конструктор с паметрами
     *
     * @param name   - имя данного индивида
     * @param parent - ссылка на родителя
     * */
    public IndividualNode(String name, ClassNode parent)
    {
        this.data = name;
        this.parent = parent;

        //Поскольку мы уже указали родителя, то увеличиваем
        //счетчик индивидов узла ClassNode
        parent.increaseIndividualCounter();

        //Автоматический добавляем атрибут - ID
        addAttribute("ID", Integer.toString(parent.getIndividualCount()));
        System.out.println(parent.getIndividualCount() + 1);
    }

    /**
     * Метод для указания родителя
     *
     * @param node - ссылка на родителя
     * */
    public void setParent(ClassNode node)
    {
        this.parent = node;
    }

    /**
     * Метод для добавления дочернего узла
     * Потомком данного вида узла может быть только узел типа
     * AttributeNode
     *
     * @param node - ссылка на потомка
     * */
    private void addChildNode(AttributeNode node)
    {
        DataProperty property = new DataProperty(node);
        propertyList.add(property);
    }

    @Override
    public String toString() {
        return "IndividualNode{" +
                "parent=" + parent +
                ", name='" + data + '\'' +
                ", propertyList=" + propertyList +
                '}';
    }
}
