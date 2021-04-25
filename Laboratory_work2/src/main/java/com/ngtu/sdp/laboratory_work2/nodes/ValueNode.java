package com.ngtu.sdp.laboratory_work2.nodes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Узел значение.
 * Содержит значение Атрибута
 *
 * @see Leaf
 * @see AttributeNode
 * */
@Component("value")
@Scope("prototype")
public class ValueNode extends Leaf
{
    public ValueNode() {
    }
}
