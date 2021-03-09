package nodes;

import propertys.Property;

import java.util.LinkedList;
import java.util.List;

/**
 * Абстрактный класс, содержащий основные поля
 * и методы узлов графовой структуры
 * */
public abstract class Node
{
    protected Node parent;
    protected String data;    //Поля для хранения данных

    //Список связей с дочерними узлами
    protected List<Property> propertyList = new LinkedList<>();

    /**
     * Метод для получения данных из узла
     *
     * @return данные
     * */
    public String getData()
    {
        return data;
    }

    public void setParent(Node parent)
    {
        this.parent = parent;
    }
}
