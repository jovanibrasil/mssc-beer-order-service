package guru.sfg.beer.order.service.sm;

import guru.sfg.beer.order.service.domain.BeerOrderStatusEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory
public class BeerOrderStateMachineConfig extends
        StateMachineConfigurerAdapter<BeerOrderStatusEnum, BeerOrderStatusEnum> {

    @Override
    public void configure(StateMachineStateConfigurer<BeerOrderStatusEnum, BeerOrderStatusEnum> states) throws Exception {
        states.withStates()
                .states(EnumSet.allOf(BeerOrderStatusEnum.class))
                .initial(BeerOrderStatusEnum.NEW)
                .end(BeerOrderStatusEnum.PICKED_UP)
                .end(BeerOrderStatusEnum.DELIVERED)
                .end(BeerOrderStatusEnum.DELIVERY_EXCEPTION)
                .end(BeerOrderStatusEnum.VALIDATION_EXCEPTION)
                .end(BeerOrderStatusEnum.ALLOCATION_EXCEPTION);
    }
}
