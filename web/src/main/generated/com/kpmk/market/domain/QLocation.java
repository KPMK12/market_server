package com.kpmk.market.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocation is a Querydsl query type for Location
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QLocation extends BeanPath<Location> {

    private static final long serialVersionUID = 1665440171L;

    public static final QLocation location = new QLocation("location");

    public final StringPath city = createString("city");

    public final StringPath dong = createString("dong");

    public final StringPath gu = createString("gu");

    public QLocation(String variable) {
        super(Location.class, forVariable(variable));
    }

    public QLocation(Path<? extends Location> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocation(PathMetadata metadata) {
        super(Location.class, metadata);
    }

}

