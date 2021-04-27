package com.ngtu.sdp.laboratory_work2.aspects;

import com.ngtu.sdp.laboratory_work2.nodes.ContainerNode;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Aspect
public class BuilderLoggerAspect
{
    private static final String graphBuildPrefix = "Building a graph structure: ";
    private static final Logger LOGGER = LoggerFactory.getLogger(BuilderLoggerAspect.class);

    /******************************************   reset   *************************************************************/
    @Before("execution(* com.ngtu.sdp.laboratory_work2.builder.GraphBuilder.reset(..))")
    public void beforeResetLogger(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();

        LOGGER.debug(graphBuildPrefix + "building the root of the graph (class) - " + args[0]);
    }

    @AfterReturning(value = "execution(* com.ngtu.sdp.laboratory_work2.builder.GraphBuilder.reset(..))",
        returning = "node")
    public void afterReturningResetLogger(ContainerNode node)
    {
        if (node != null) LOGGER.debug(graphBuildPrefix + "root of the graph (class) - " + node.getData() + " - " +
                " built success!");
        else LOGGER.error(graphBuildPrefix + "graph root building error!");
    }

    /*********************************   toClassNodeAddClassNode   ****************************************************/
    @Before("execution(* com.ngtu.sdp.laboratory_work2.builder.GraphBuilder.toClassNodeAddClassNode(..))")
    public void beforeToClassNodeAddClassNodeLogger(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();

        LOGGER.debug(graphBuildPrefix + "building subclass - " + args[1]);
    }

    @AfterReturning(value = "execution(* com.ngtu.sdp.laboratory_work2.builder.GraphBuilder.toClassNodeAddClassNode(..))",
            returning = "node")
    public void afterReturningToClassNodeAddClassNodeLogger(ContainerNode node)
    {
        if (node != null) LOGGER.debug(graphBuildPrefix + "subclass - " + node.getData() + " - " +
                " built success!");
        else LOGGER.error(graphBuildPrefix + "subclass building error!");
    }

    /*******************************   toClassNodeAddIndividualNode   *************************************************/
    @Before("execution(* com.ngtu.sdp.laboratory_work2.builder.GraphBuilder.toClassNodeAddIndividualNode(..))")
    public void beforeToClassNodeAddIndividualNodeLogger(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();

        LOGGER.debug(graphBuildPrefix + "building individual - " + args[1]);
    }

    @AfterReturning(value = "execution(* com.ngtu.sdp.laboratory_work2.builder.GraphBuilder.toClassNodeAddIndividualNode(..))",
            returning = "node")
    public void afterReturningToClassNodeAddIndividualNodeLogger(ContainerNode node)
    {
        if (node != null) LOGGER.debug(graphBuildPrefix + "individual - " + node.getData() + " - " +
                " built success!");
        else LOGGER.error(graphBuildPrefix + "individual building error!");
    }

    /*****************************   toIndividualNodeAddAttributeNode   ***********************************************/
    @Before("execution(* com.ngtu.sdp.laboratory_work2.builder.GraphBuilder.toIndividualNodeAddAttributeNode(..))")
    public void beforeToIndividualNodeAddAttributeNodeLogger(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();

        LOGGER.debug(graphBuildPrefix + "building attribute - " + args[1] + " with value = " + args[2]);
    }

    @AfterReturning(value = "execution(* com.ngtu.sdp.laboratory_work2.builder.GraphBuilder.toIndividualNodeAddAttributeNode(..))",
            returning = "node")
    public void afterReturningToIndividualNodeAddAttributeNodeLogger(ContainerNode node)
    {
        if (node != null) LOGGER.debug(graphBuildPrefix + "attribute - " + node.getData() + " with value = "
                + node.getPropertyList().get(0).getChildNode().getData() + " - built success!");
        else LOGGER.error(graphBuildPrefix + "attribute building error!");
    }

    /************************************   Director.construct   ******************************************************/
    @AfterReturning(value = "execution(* com.ngtu.sdp.laboratory_work2.builder.Director.constructorGraph(..))",
            returning = "nodeOpt")
    public void afterReturningToIndividualNodeAddAttributeNodeLogger(Optional<ContainerNode> nodeOpt)
    {
        if (nodeOpt.isPresent()) LOGGER.debug(graphBuildPrefix + " graph build success");
        else LOGGER.warn(graphBuildPrefix + "graph build canceled");
    }
}
