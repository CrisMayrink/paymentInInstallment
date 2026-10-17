/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package udemystudy.paymentininstallment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import model.Entities.Contract;
import model.Entities.Installment;
import model.services.ContractService;
import model.services.PayPalService;

/**
 *
 * @author cmaya
 */
public class PaymentInInstallment {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        try{
            
            System.out.print("Entre os dados do contrato ");
            System.out.print("Numero: ");
            int number = sc.nextInt();
            
            System.out.println("Entre com a data do contrato");
            System.out.println("Data (dd/MM/yyyy): ");
            String dateStr = sc.next();
            //transforma o texto digitado pelo usuário em uma data real que o Java entende (LocalDate), aplicando regras de formatação.
            LocalDate date = LocalDate.parse(dateStr, fmt);
            
            System.out.println("Entre com o valor do contrato: ");
            BigDecimal totalValue = sc.nextBigDecimal();
            
             //instanciar o contrato
            Contract contract = new Contract (number, date, totalValue);
            
            System.out.println("Entre com o numero de prestações: ");
            int months = sc.nextInt();
            
            //ativa o serviço injetando o paypal  
            ContractService contractService = new ContractService(new PayPalService());
            
            //processa as parcelas dentro do contrato
            contractService.processContract(contract, months);
            
            //percorre a lista de parcelas geradas e exibe na tela
            System.out.println("\nPARCELAS: ");
            
            //"Para cada objeto do tipo Installments (chamado temporariamente de installment) localizado dentro da lista de parcelas do contrato, faça o seguinte..
            for (Installment installment : contract.getInstallment()){
                System.out.println(installment);// Usa o toString formatado automaticamente            
            }
            
        }catch (Exception e){
                System.out.println("\nError: " + e.getMessage());
            
        } finally{  
            sc.close();    
        }
        
    }
}
