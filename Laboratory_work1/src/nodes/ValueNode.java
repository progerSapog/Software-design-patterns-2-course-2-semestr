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
    /**
     * Конструктор с параметрами
     *
     * @param data   - значение данного узла
     * @param parent - родитель данного узла
     * */
    public ValueNode(String data, Node parent)
    {
        this.parent = parent;
        this.data = data;
        this.propertyList = null;
    }

    @Override
    public String toString() {
        return "ValueNode{" +
                "name='" + data + '\'' +
                ", propertyList=" + propertyList +
                '}';
    }
}
