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
public class ContaEspecial extends Contas{
    int limite;
    
    public double Descontar(double multa){
        return this.saldo =(this.saldo-limite)*(multa/100)+(this.saldo-limite);
        
    }
   
    @Override
    public String tipoConta(){
        return "Especial";   
    }
}
