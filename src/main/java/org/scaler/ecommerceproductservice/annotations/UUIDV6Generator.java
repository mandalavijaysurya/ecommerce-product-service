package org.scaler.ecommerceproductservice.annotations;

import org.hibernate.annotations.IdGeneratorType;
import org.scaler.ecommerceproductservice.generators.SortedUUIDGenerator;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@IdGeneratorType(SortedUUIDGenerator.class)
public @interface UUIDV6Generator {

}
