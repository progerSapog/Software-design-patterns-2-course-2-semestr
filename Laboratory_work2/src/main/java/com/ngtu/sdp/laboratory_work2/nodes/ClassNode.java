package com.ngtu.sdp.laboratory_work2.nodes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Главный узел графовой структуры - служит корнем графа
 * и/или родителем для узлов типа IndividualNode
 *
 * @see ContainerNode
 * @see IndividualNode
 * */
@Component("class")
@Scope("prototype")
public class ClassNode extends ContainerNode
{
    private List<ClassNodeStateEnum> state;    //Поле отвечающее за состояния данного узла

    /**
     * Конструктор без параметров.
     * Инициализация списка состояний
     * */
    public ClassNode()
    {
        state = new ArrayList<>();
    }

    /**
     * Перегрузка метода добавления дочернего элемента.
     *
     * @param childNode - дочерний узел
     * */
    @Override
    public void addChildNode(Node childNode)
    {
        super.addChildNode(childNode);
        //Если передан узел ClassNode, то текущий узел получает состояние ИМЕЕТ_ПОДКЛАСС
        if (childNode instanceof ClassNode)
        {
            state.add(ClassNodeStateEnum.HAVE_SUBCLASS);
        }
        //Если передан узел IndividualNode, то текущий узел получает состояние ИМЕЕТ_ИНДИВИДА
        if (childNode instanceof IndividualNode)
        {
            state.add(ClassNodeStateEnum.HAVE_INDIVIDUAL);
        }
    }

    /**
     * Возвращает состояние данного узла.
     *
     * @return состояние
     * */
    public List<ClassNodeStateEnum> getState()
    {
        return state;
    }

    /**
     * Установливает состояние узла
     *
     * @param state - состояние, которое необходимо задать.
     * */
    public void setState(ClassNodeStateEnum state)
    {
        this.state.add(state);
    }
}
