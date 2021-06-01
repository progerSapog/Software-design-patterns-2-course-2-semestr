package com.ngtu.sdp.loboratory_worl3.generator;

import com.ngtu.sdp.loboratory_worl3.query.Query;
import com.ngtu.sdp.loboratory_worl3.builder.Builder;

/**
 * Интерфейс генератора.
 *
 * @param <T> - тип данных, который необходимо сгенерировать.
 * */
public interface Generator<T>
{
    T generate(Query query, Builder builder);
}
