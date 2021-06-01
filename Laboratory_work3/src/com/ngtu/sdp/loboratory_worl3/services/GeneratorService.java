package com.ngtu.sdp.loboratory_worl3.services;

import com.ngtu.sdp.loboratory_worl3.builder.Builder;
import com.ngtu.sdp.loboratory_worl3.nodes.ClassNode;
import com.ngtu.sdp.loboratory_worl3.query.Query;

public interface GeneratorService
{
    ClassNode generateGraph(Query query, Builder builder);
}
