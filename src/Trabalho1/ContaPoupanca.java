/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho1;

/**
 *
 * @author Eraldo Caetano
 */
public class ContaPoupanca extends Contas{
    public  double  reajustar(double  taxa){
        double  saldoAtual  = this.getSaldo();
        double  reajuste  =  (saldoAtual  *  (taxa/100))+saldoAtual;
        return reajuste;
    }
    
    public double reajustar(){
        double  saldoAtual  = this.getSaldo();
        double  reajuste  =  (saldoAtual  *  0.1)+saldoAtual;
        return reajuste;
    }
    
    @Override
    public String tipoConta(){
        return "Poupança";   
    }
}
