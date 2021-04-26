package com.ngtu.sdp.laboratory_work2.nodes;

/**
 * Конечй лист - не имеет потомков
 *
 * @see Node
 * @see ValueNode
 * */
public abstract class Leaf extends Node
{
    public Leaf() {
        super();
    }

    public Leaf(String data)
    {
        super(data);
    }

    public Leaf(Node parent, String data)
    {
        super(parent, data);
    }

}
