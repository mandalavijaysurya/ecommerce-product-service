package org.scaler.ecommereceproductservice.annotation;

import org.hibernate.annotations.IdGeneratorType;
import org.scaler.ecommereceproductservice.generator.RandomUUIDGenerator;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@IdGeneratorType(RandomUUIDGenerator.class)
public @interface UUID4Generator {

}
