package nodes;

import propertys.DataProperty;

/**
 * Класс Индивид - экземпляр класс/подкласса типа
 * ClassNode
 *
 * @see ClassNode
 * @see AttributeNode
 * @see ValueNode
 * */
public class IndividualNode extends Node
{
    private ClassNode parent;
    /**
     * Метод для добавления атрибута индивиду
     * Создает узел атрибут с именем атрибута,
     * так же создается узел
     * Формирует связь типа DataProperty
     *
     * @param parameterName - имя параметра
     * @param value         - значение параметра
     * */
    public void addAttribute(String parameterName, String value)
    {
        AttributeNode node = new AttributeNode(parameterName, value);
        node.setParent(this);
        addChildNode(node);
    }

    /**
     * Конструктор с паметрами
     *
     * @param name   - имя данного индивида
     * */
    public IndividualNode(String name)
    {
        this.data = name;

        //Поскольку мы уже указали родителя, то увеличиваем
        //счетчик индивидов узла ClassNode

        //Автоматический добавляем атрибут - ID
    }

    public void addID()
    {
        addAttribute("ID", Integer.toString(parent.getIndividualCount()));
        System.out.println(parent.getIndividualCount());
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
