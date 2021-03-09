package nodes;

/**
 * Узел значение
 * Фомрмируется при вывозе метод addAttribute
 * у узла типа IndividualNode
 *
 * Содержит значение Атрибута
 * */
public class ValueNode extends Node
{
    private AttributeNode parent;
    /**
     * Конструктор с параметрами
     *
     * @param data   - значение данного узла
     * @param parent - родитель данного узла
     * */
    public ValueNode(String data, AttributeNode parent)
    {
        this.parent = parent;
        this.data = data;
        this.propertyList = null;
    }

    public void setParent(AttributeNode parent)
    {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "ValueNode{" +
                "name='" + data + '\'' +
                ", propertyList=" + propertyList +
                '}';
    }
}
