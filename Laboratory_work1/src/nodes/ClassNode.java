package nodes;

import propertys.ObjectProperty;

/**
 * Главный узел графовой структуры - служит корнем графа
 * и/или родителем для узлов типа IndividualNode
 *
 * @see IndividualNode
 * */
public class ClassNode extends Node
{
    private int individualCount = 0;    //счетчик индивидов для которых данный
                                        //узе является родительским

    private String state;               //Поле отвечающее за состояния данного узла

    /**
     * Конструктор с параметрами.
     * Поскольку нет родителя, то узел
     * приобритает состояние класс
     *
     * @param name   - имя данного узла
     * */
    public ClassNode(String name)
    {
        this.data = name;
        this.state = "Класс";
    }

    /**
     * Медот для добавления дочернего узла
     *
     * @param node                - дочерний узел
     * @throws ChildNodeException - исключение созданий связей
     *                              между узлами в графовой структуре
     * */
    public void addChild (Node node) throws ChildNodeException
    {
        //Если дочерний узел принадлжеит классу IndividualNode
        if (node instanceof IndividualNode)
        {
            //Если в состоянии узла еще не указано, что он имеет
            //индивида к текущему состоянию приписываем:
            //имеет индивида
            if (!this.state.contains(", имеет индивида"))
            {
                this.state = this.state + ", имеет индивида";
            }
        }
        //Иначе если тип переданного узла ClassNode то у него устанавливается
        //статус Подкласс
        else if (node instanceof ClassNode)
        {
            ((ClassNode) node).state = "Подкласс";

            //Если у текущего узла не указано в состоянии, что он имеет подкласс
            //то дописываем это
            if (!this.state.contains(", имеет подкласс"))
            {
                this.state = this.state + ", имеет подкласс";
            }
        }
        else
        {
            throw new ChildNodeException("Для узла типа" + this.getClass() + " дочерним узлом могут быть" +
                    " узлы: " + ClassNode.class + " или " + IndividualNode.class);
        }
        //Для дочернего узла устанавливаем родителя - текущий узел
        node.setParent(this);

        //создание свойства объекта
        ObjectProperty property = new ObjectProperty(node);
        propertyList.add(property);
    }

    public int getIndividualCount()
    {
        return this.individualCount;
    }

    public void increaseIndividualCounter()
    {
        this.individualCount++;
    }

    @Override
    public String toString() {
        return "ClassNode{" +
                "parent=" + parent +
                ", individualCount=" + individualCount +
                ", state='" + state + '\'' +
                ", name='" + data + '\'' +
                ", propertyList=" + propertyList +
                '}';
    }
}
