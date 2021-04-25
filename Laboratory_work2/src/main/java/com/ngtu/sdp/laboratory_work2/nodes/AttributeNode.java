package com.ngtu.sdp.laboratory_work2.nodes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Узел атрибут
 * Содержит значение Имя атрибута и список дочерних связей
 *
 * @see Node
 * @see ContainerNode
 * @see ClassNode
 * @see IndividualNode
 * */
@Component("attribute")
@Scope("prototype")
public class AttributeNode extends ContainerNode
{
    public AttributeNode() {
    }
}
