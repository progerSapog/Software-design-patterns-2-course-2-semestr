package com.ngtu.sdp.laboratory_work2.nodes;

/**
 * Узел атрибут
 * Содержит значение Имя атрибута и список дочерних связей
 *
 * @see Node
 * @see ContainerNode
 * @see ClassNode
 * @see IndividualNode
 * */
public class AttributeNode extends ContainerNode
{
    public AttributeNode()
    {
    }

    public AttributeNode(Node parent, String data)
    {
        super(parent, data);
    }
}
