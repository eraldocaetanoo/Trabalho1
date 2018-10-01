
package Trabalho1;

/**
 *
 * @author Eraldo Caetano
 */
public class Contas{
    private String nome;
    private int numero;
    double saldo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
    public double depositar(double valor){
        this.saldo=this.saldo+ valor;
        return this.saldo;
    }
    
    public double Sacar(double valor){
        this.saldo=saldo-valor;
        return this.saldo;
          
    }
    
    /*
    public double transferir(double valor){
        
        //this.Sacar(con);
  
    }
    */
    public String tipoConta(){
        return "Comum";   
    }
}