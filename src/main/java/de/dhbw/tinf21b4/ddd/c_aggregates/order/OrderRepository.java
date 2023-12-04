package de.dhbw.tinf21b4.ddd.c_aggregates.order;

import de.dhbw.tinf21b4.ddd.c_aggregates.customer.CustomerAggregate;
import de.dhbw.tinf21b4.ddd.c_aggregates.product.ProductNumber;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    Optional<OrderAggregate> findById(UUID orderId);

    List<OrderAggregate> findByCustomer(CustomerAggregate customer);

    OrderAggregate save(OrderAggregate order);

    /**
     * creates a report
     * @param period
     * @return
     */
    Map<ProductNumber, SalesPerProduct> createSalesPerProductReport(Period period);
}
