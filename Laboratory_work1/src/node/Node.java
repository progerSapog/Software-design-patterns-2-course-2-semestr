package node;

/**
 * Общий интерфейс узлов
 * */
public interface Node {

    /**
     * Метод для добавления дочерних узлов
     * @param name       - имя нового узла
     * @param parentNode - узел родитель
     * */
    void addChildNode(String name, Node parentNode);
}
