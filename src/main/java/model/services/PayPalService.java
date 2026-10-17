package model.services;

import java.math.BigDecimal;

/**
 *
 * @author cmaya
 */
public class PayPalService implements OnlinePaymentService {
    
    // Constantes de taxa (2%) e juros mensais (1%) mapeadas como BigDecimal
    private static final BigDecimal FEE_PERCENTAGE = new BigDecimal("0.02");
    private static final BigDecimal MONTHLY_INTEREST = new BigDecimal("0.01");
    
    
    @Override
    public BigDecimal paymentFee(BigDecimal amount){
        return amount.multiply(FEE_PERCENTAGE);
    }
    @Override
    public BigDecimal interest(BigDecimal amount, Integer months){
         // Multiplica o valor da parcela por 0.01 e depois pela quantidade de meses
        return amount.multiply(MONTHLY_INTEREST).multiply(BigDecimal.valueOf(months));

    }
}
    
