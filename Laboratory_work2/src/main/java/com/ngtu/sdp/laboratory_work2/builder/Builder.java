package com.ngtu.sdp.laboratory_work2.builder;

import com.ngtu.sdp.laboratory_work2.nodes.ContainerNode;
import com.ngtu.sdp.laboratory_work2.nodes.Leaf;
import com.ngtu.sdp.laboratory_work2.nodes.Node;

public interface Builder
{
    Node reset(String data);

    ContainerNode toClassNodeAddClassNode(ContainerNode srcNode, String childNodeData);

    ContainerNode toClassNodeAddIndividualNode(ContainerNode srcNode, String childNodeData);

    ContainerNode toIndividualNodeAddAttributeNode(ContainerNode srcNode, String childNodeData);

    Leaf toAttributeNodeAddValueNode(ContainerNode srcNode, String childNodeData);
}
