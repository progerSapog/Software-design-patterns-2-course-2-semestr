package node;

import java.util.LinkedList;
import java.util.List;

/**
 * Класс - узле - корень дерева
 * */
public class ClassNode implements Node
{
    private String name;
    private Node parentNode = null;   //не имеет родителя

    private List<Node> childNodeList = new LinkedList<>();    //класс может иметь сыновей индивидов или сыновей
                                                              //другой класс


    public ClassNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Добавление подкласса
     */
    public void addNewClassNode(String name) {
        ClassNode node = new ClassNode(name);

        addChildNode("", node);
    }

    /**
     * Добавление индивида
     */
    public void addNewIndividualNode(String name) {
        IndividualNode node = new IndividualNode(new StringBuffer(name), this);

        addChildNode("", node);
    }

    @Override
    public void addChildNode(String name, Node node) {
        childNodeList.add(node);
    }
}
