package com.ngtu.sdp.laboratory_work2.nodes;

/**
 * Узел значение.
 * Содержит значение Атрибута
 *
 * @see Leaf
 * @see AttributeNode
 * */
public class ValueNode extends Leaf
{
    public ValueNode() {
        super();
    }

    public ValueNode(String data)
    {
        super(data);
    }

    public ValueNode(Node parent, String data)
    {
        super(parent, data);
    }
}
