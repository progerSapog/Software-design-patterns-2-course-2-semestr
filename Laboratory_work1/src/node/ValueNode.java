package node;

/**
 * Конечный узел - узел значение -
 * не имеет дальнейших потомков
 * */
public class ValueNode implements Node {
    //каждый узел определяется именем и типом (из задания)
    private int number;                  //поле значение

    private AttributeNode parentNode;    //ссылка на родительский узел атрибут (не список, т.к. одому атрибуту
                                         //соответсвуте одно значение)

    /**
     * Конструктор с парамером.
     *
     * @param number - значение данного узла
     * */
    public ValueNode(int number, AttributeNode parentNode) {
        this.parentNode = parentNode;
        this.number = number;
    }

    /**
     * Метод для получения значения данного узла
     * */
    public int getNumber()
    {
        return number;
    }

    /**
     * Реализация пуста, поскольку данный вид узлов
     * не может иметь потомков.
     * */
    @Override
    public void addChildNode(String name, Node parentNode) {
        //Такое допустимо согласно п.5 Шаги реализации компановщика
    }
}
