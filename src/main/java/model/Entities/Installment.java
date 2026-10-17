package model.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author cmaya
 */
public final class Installment {

    private final LocalDate dueDate;
    private final BigDecimal amount;

    public Installment(LocalDate dueDate, BigDecimal amount) {
        if (dueDate == null) {
            throw new IllegalArgumentException("A data de vencimento da parcela não pode ser nula.");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da parcela deve ser maior que zero.");
        }
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    // Opcional: Um método toString bonito ajuda muito na hora de imprimir no código principal

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dueDate.format(fmt) + " - R$ " + amount;
    }
}
