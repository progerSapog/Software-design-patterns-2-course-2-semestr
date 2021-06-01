package com.ngtu.sdp.loboratory_worl3.services;

import com.ngtu.sdp.loboratory_worl3.builder.Builder;
import com.ngtu.sdp.loboratory_worl3.generator.Generator;
import com.ngtu.sdp.loboratory_worl3.generator.GraphGenerator;
import com.ngtu.sdp.loboratory_worl3.nodes.ClassNode;
import com.ngtu.sdp.loboratory_worl3.query.Query;

public class GeneratorServiceImpl implements GeneratorService
{
    Generator<ClassNode> generator = new GraphGenerator();

    @Override
    public ClassNode generateGraph(Query query, Builder builder)
    {
        return generator.generate(query, builder);
    }
}
