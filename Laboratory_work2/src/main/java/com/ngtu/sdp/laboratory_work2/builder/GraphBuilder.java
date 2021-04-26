package com.ngtu.sdp.laboratory_work2.builder;

import com.ngtu.sdp.laboratory_work2.nodes.*;

public class GraphBuilder implements Builder
{
    @Override
    public Node reset(String data)
    {
        return new ClassNode(data, ClassNodeStateEnum.CLASS);
    }

    @Override
    public ContainerNode toClassNodeAddClassNode(ContainerNode srcNode, String childNodeData)
    {
        ClassNode childNode = new ClassNode(srcNode, childNodeData, ClassNodeStateEnum.SUBCLASS);
        srcNode.addChildNode(childNode);
        if (!((ClassNode)srcNode).getState().contains(ClassNodeStateEnum.HAVE_SUBCLASS))
        {
            ((ClassNode)srcNode).addState(ClassNodeStateEnum.HAVE_SUBCLASS);
        }

        return childNode;
    }

    @Override
    public ContainerNode toClassNodeAddIndividualNode(ContainerNode srcNode, String childNodeData)
    {
        IndividualNode childNode = new IndividualNode(srcNode, childNodeData);
        srcNode.addChildNode(childNode);
        if (!((ClassNode)srcNode).getState().contains(ClassNodeStateEnum.HAVE_INDIVIDUAL))
        {
            ((ClassNode)srcNode).addState(ClassNodeStateEnum.HAVE_INDIVIDUAL);
        }
        childNode.setID();

        return childNode;
    }

    @Override
    public ContainerNode toIndividualNodeAddAttributeNode(ContainerNode srcNode, String childNodeData)
    {
        AttributeNode childNode = new AttributeNode(srcNode, childNodeData);
        srcNode.addChildNode(childNode);

        return childNode;
    }

    @Override
    public Leaf toAttributeNodeAddValueNode(ContainerNode srcNode, String childNodeData)
    {
        ValueNode childNode = new ValueNode(srcNode, childNodeData);
        srcNode.addChildNode(childNode);

        return childNode;
    }
}
