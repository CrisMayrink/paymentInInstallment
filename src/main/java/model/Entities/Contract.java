package model.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author cmaya
 */
public class Contract {

    private Integer number;
    private LocalDate date;
    private BigDecimal totalValue;
    
    // 1. Criamos a lista que vai guardar todas as parcelas do contrato
    private final List<Installment> installment = new ArrayList<>();
    
    public Contract() {
    }

    // Construtor completo (Utiliza os próprios SETTERS para garantir que ninguém crie um contrato inválido)
    public Contract(Integer number, LocalDate date, BigDecimal totalValue) {
        setNumber(number);
        setDate(date);
        setTotalValue(totalValue);
    }
    
    public Integer getNumber() {
        return number;
    }

    // Validação: Garante que o número seja positivo e informado
    public final void setNumber(Integer number) {
        if (number == null || number <= 0) {
            throw new IllegalArgumentException("Erro no Contrato: O número do contrato deve ser maior que zero.");
        }
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public final void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Erro no Contrato: A data do contrato deve ser preenchida.");
        }
        this.date = date;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public final void setTotalValue(BigDecimal totalValue) {
        if (totalValue == null) {
            throw new IllegalArgumentException("Erro no Contrato: O valor total não pode ser nulo.");
        }
        // compareTo retorna -1 se for menor, 0 se for igual e 1 se for maior
        if (totalValue.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Erro no Contrato: O valor total deve ser maior que zero.");
        }
        this.totalValue = totalValue;
    }

    public List<Installment> getInstallment() {
        return Collections.unmodifiableList(installment);
    }
}
