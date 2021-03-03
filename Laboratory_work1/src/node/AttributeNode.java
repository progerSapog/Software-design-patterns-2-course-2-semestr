package node;

/**
 * Узел атрибут - автоматически создается для
 * каждого индивида, имеет уникальный номер в пределах
 * всех узлов-атрибутов текущего индивида.
 * */
public class AttributeNode implements Node {
    private String name      = "Идентиффикатор";    //для каждого индивида автоматически создается атрибут
                                                    //«Идентификатор» с уникальным номером в пределах всех
                                                    //узлов-атрибутов текущего индивида.

    private ValueNode value;                        //Ссылка на узел - значение
    private IndividualNode parentNode;              //ссылка на узел - родитель

    /**
     * Конструктор с параметром.
     * @param name       - значение переданное
     * @param parentNode - узел родитель
     * */
    public AttributeNode(String name, Node parentNode)
    {
        this.parentNode = (IndividualNode) parentNode;
        addChildNode(name, this);
    }

    /**
     * Метод для создания узла - значения
     *
     * @param name       - никальный номер в пределах всех узлов-атрибутов текущего индивида,
     *                     передается из счетчика атрибутов у узла - индивида
     * @param parentNode - узел родитель
     * */
    @Override
    public void addChildNode(String name, Node parentNode)
    {
        value = new ValueNode(Integer.parseInt(name), this);
    }
}
