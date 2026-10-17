package model.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import model.Entities.Contract;
import model.Entities.Installment;

/**
 *
 * @author cmaya
 */
public class ContractService {

    // Apenas declaramos a interface aqui dentro. Isso é ATRIBUIÇÃO/USO, não implementação.
    private final OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        //O RoundingMode.HALF_UP é uma instrução que define a regra de arredondamento comercial padrão para o Java.
        //Como o Java não permite dividir um objeto BigDecimal por um número primitivo ou inteiro direto, nós usamos o método BigDecimal.valueOf(months) para converter o número de meses em um objeto BigDecimal temporário. Isso permite que a operação ocorra entre dois objetos do mesmo tipo.
        BigDecimal basicQuota = contract.getTotalValue().divide(BigDecimal.valueOf(months), 2, RoundingMode.HALF_UP);

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            // Calcula o juro e a taxa direto na soma final
            BigDecimal interest = onlinePaymentService.interest(basicQuota, i);
            BigDecimal totalQuota = basicQuota.add(interest).add(onlinePaymentService.paymentFee(basicQuota.add(interest)));

            contract.getInstallment().add(new Installment(dueDate, totalQuota.setScale(2, RoundingMode.HALF_UP)));
        }
    }
}


