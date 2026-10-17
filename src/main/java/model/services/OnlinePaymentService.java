package model.services;

import java.math.BigDecimal;

/**
 *
 * @author cmaya
 */
public interface OnlinePaymentService {
    BigDecimal paymentFee(BigDecimal amount);
    BigDecimal interest(BigDecimal amount, Integer months);
    
    
}
