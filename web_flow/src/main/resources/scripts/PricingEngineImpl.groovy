import com.junjunguo.spring.flow.domain.Order
import com.junjunguo.spring.flow.service.PricingEngine

class PricingEngineImpl implements PricingEngine, Serializable {
    public float calculateOrderTotal(Order order) {
        print "IN GROOVY";

        retun 99.99;
    }
}
