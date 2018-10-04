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

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        Contas cc = new Contas();
        ContaPoupanca cp = new ContaPoupanca();
        ContaEspecial ce = new ContaEspecial();
        int nc, nc1, nc2;
        double vsaq, dep, tr, mu, vt;        
        String[] opcoes = {"Saque", "Depósito", "Transferência", "Reajustar", "Ver saldos", "Sair"};
        String[] coca = {"Confirmar", "Cancelar"};
        String[] voltar = {"Voltar"};
        
        JOptionPane.showMessageDialog(null, "Bem vindo(a)!!!");
        
        do{
            cc.setNome (JOptionPane.showInputDialog(null,"Digite nome do titular da conta comum:", "Nome titular Conta Comum", JOptionPane.QUESTION_MESSAGE));
            cc.setNumero (Integer.parseInt(JOptionPane.showInputDialog(null,"Digite número de conta comum:",  "Número Conta Comum", JOptionPane.QUESTION_MESSAGE)));
            cc.setSaldo (Double.parseDouble(JOptionPane.showInputDialog(null,"Digite saldo de conta comum (R$):",  "Saldo Conta Comum", JOptionPane.QUESTION_MESSAGE)));
        
            cp.setNome (JOptionPane.showInputDialog(null,"Digite nome do titular da conta poupança:", "Nome titular Conta Poupança", JOptionPane.QUESTION_MESSAGE));
            cp.setNumero (Integer.parseInt(JOptionPane.showInputDialog(null,"Digite número de conta poupança:",  "Número Conta Poupança", JOptionPane.QUESTION_MESSAGE)));
            cp.setSaldo(Double.parseDouble(JOptionPane.showInputDialog(null,"Digite saldo de conta poupança (R$):",  "Saldo Conta Poupança", JOptionPane.QUESTION_MESSAGE)));
        
            ce.setNome (JOptionPane.showInputDialog(null,"Digite nome do titular da conta especial:", "Nome titular Conta Especial", JOptionPane.QUESTION_MESSAGE));
            ce.setNumero (Integer.parseInt(JOptionPane.showInputDialog(null,"Digite número de conta especial:",  "Número Conta Especial", JOptionPane.QUESTION_MESSAGE)));
            ce.setSaldo (Double.parseDouble(JOptionPane.showInputDialog(null,"Digite saldo de conta especial (R$):",  "Saldo Conta Especial", JOptionPane.QUESTION_MESSAGE)));
            ce.limite = (Integer.parseInt(JOptionPane.showInputDialog(null,"Digite limite da conta especial (R$):",  "Limite titular Conta Especial", JOptionPane.QUESTION_MESSAGE)));
            mu = (Double.parseDouble(JOptionPane.showInputDialog(null,"Digite multa para conta especial (%):",  "Multa Conta Especial", JOptionPane.QUESTION_MESSAGE)));
            
            if ((cc.getNumero()==cp.getNumero()) || (cc.getNumero()==ce.getNumero())){
                JOptionPane.showOptionDialog(null, "Números de contas iguais! Refaça o cadastro.", "Contas",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
            }
        } while ((cc.getNumero()==cp.getNumero()) || (cc.getNumero()==ce.getNumero()));
        
        int s, c;
        do{
            s = JOptionPane.showOptionDialog(null, "Selecione a operação desejada:", "Contas",
                    JOptionPane.CLOSED_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
            if (s==0){
                nc = Integer.parseInt(JOptionPane.showInputDialog(null,"Número da conta para saque:",  "Saque", JOptionPane.QUESTION_MESSAGE));
                vsaq = Double.parseDouble(JOptionPane.showInputDialog(null,"Valor de saque (R$):",  "Saque", JOptionPane.QUESTION_MESSAGE));
                if (nc==cc.getNumero()){
                    c = JOptionPane.showOptionDialog(null, "Nome do titular da conta:\n"+cc.getNome(), "Saque",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, coca, coca[0]);
                    if (c==0){
                        if(vsaq>0){
                            if(cc.getSaldo()>vsaq){
                                cc.Sacar(vsaq);
                                JOptionPane.showOptionDialog(null, "Saque efetuado com sucesso!!!", "Saque",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                            }
                            else{
                                JOptionPane.showOptionDialog(null, "Saldo insuficiente!!!", "Saque",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                            }
                        }
                        else{
                            JOptionPane.showOptionDialog(null, "Saque inválido!!!", "Saque",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                        }
                    }
                    else{
                        JOptionPane.showOptionDialog(null, "Saque cancelado!!!", "Saque",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                    }
                }
                else if (nc==cp.getNumero()){
                    c = JOptionPane.showOptionDialog(null, "Nome do titular da conta:\n"+cp.getNome(), "Saque",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, coca, coca[0]);
                    if (c==0){
                        if(vsaq>0){
                            if(cp.getSaldo()>vsaq){
                                cp.saldo = cp.Sacar(vsaq);
                                JOptionPane.showOptionDialog(null, "Saque efetuado com sucesso!!!", "Saque",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                            }
                            else{
                                JOptionPane.showOptionDialog(null, "Saldo insuficiente!!!", "Saque",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                            }
                        }
                        else{
                            JOptionPane.showOptionDialog(null, "Saque inválido!!!", "Saque",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                        }
                    }
                    else{
                        JOptionPane.showOptionDialog(null, "Saque cancelado!!!", "Saque",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);    
                    }
                }
                else if (nc==ce.getNumero()){
                    c = JOptionPane.showOptionDialog(null, "Nome do titular da conta:\n"+ce.getNome(), "Saque",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, coca, coca[0]);
                    if (c==0){
                        if(vsaq>0){
                            if(ce.getSaldo()>vsaq){
                                ce.Sacar(vsaq);
                                JOptionPane.showOptionDialog(null, "Saque efetuado com sucesso!!!", "Saque",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                            }
                            else if (ce.getSaldo()+ce.limite>vsaq){
                                ce.Sacar(vsaq);
                                ce.Descontar(mu);
                                JOptionPane.showOptionDialog(null, "Saque efetuado usando cheque especial!!! ", "Saque",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);  
                            }
                            else{
                                JOptionPane.showOptionDialog(null, "Saldo insuficiente!!!", "Saque",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                            }
                        }
                        else{
                            JOptionPane.showOptionDialog(null, "Saque inválido!!!", "Saque",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                        }
                    }
                    else{
                        JOptionPane.showOptionDialog(null, "Saque cancelado!!!", "Saque",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]); 
                    }
                }
                else{
                    JOptionPane.showOptionDialog(null, "Número de conta inexistente!!!", "Saque",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                }
            }
            if (s==1){
                nc = Integer.parseInt(JOptionPane.showInputDialog(null,"Número da conta para depósito:",  "Depósito", JOptionPane.QUESTION_MESSAGE));
                dep = Double.parseDouble(JOptionPane.showInputDialog(null,"Valor de depósito (R$):",  "Depósito", JOptionPane.QUESTION_MESSAGE));
                if(nc==cc.getNumero()){
                    
                    c = JOptionPane.showOptionDialog(null, "Nome do titular da conta:\n"+cc.getNome(), "Depósito",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, coca, coca[0]);
                    if (c==0){
                        if(dep>0){
                            cc.saldo=cc.depositar(dep);
                            JOptionPane.showOptionDialog(null, "Depósito efetuado com sucesso!!! ", "Depósito",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                        }
                        else{
                        JOptionPane.showOptionDialog(null, "Depósito inválido!!!", "Depósito",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                        }
                    }
                    else{
                        JOptionPane.showOptionDialog(null, "Depósito cancelado!!!\n", "Depósito",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                    }
                }
                else if(nc==cp.getNumero()){
                    c = JOptionPane.showOptionDialog(null, "Nome do titular da conta:\n"+cp.getNome(), "Depósito",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, coca, coca[0]);
                        if (c==0){
                            if(dep>0){
                                cp.saldo=cp.depositar(dep);
                                JOptionPane.showOptionDialog(null, "Depósito efetuado com sucesso!!! ", "Depósito",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                            }
                            else{
                                JOptionPane.showOptionDialog(null, "Depósito inválido!!!", "Depósito",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                            }
                        }
                        else{
                                JOptionPane.showOptionDialog(null, "Depósito cancelado!!!\n", "Depósito",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                        }
                }
                else if(nc==ce.getNumero()){
                    c = JOptionPane.showOptionDialog(null, "Nome do titular da conta:\n"+ce.getNome(), "Depósito",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, coca, coca[0]);
                    if (c==0){
                        if(dep>0){
                            ce.saldo=ce.depositar(dep);
                            JOptionPane.showOptionDialog(null, "Depósito efetuado com sucesso!!! ", "Depósito",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                        }
                        else{
                            JOptionPane.showOptionDialog(null, "Depósito inválido!!!", "Depósito",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                        }
                    }
                    else{
                        JOptionPane.showOptionDialog(null, "Depósito cancelado!!!\n", "Depósito",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                    }
                }
                else{
                    JOptionPane.showOptionDialog(null, "Número de conta inexistente!!!", "Depósito",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                }
            }
            if (s==2){
                nc1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Número da conta da qual deseja transferir:",  "Transferência", JOptionPane.QUESTION_MESSAGE));
                nc2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Número da conta para qual deseja transferir:",  "Transferência", JOptionPane.QUESTION_MESSAGE));
                if((nc1==cc.getNumero() || nc1 == cp.getNumero() || nc1 == ce.getNumero()) && (nc2==cc.getNumero() || nc2==cp.getNumero() || nc2==ce.getNumero())){
                    if ((nc1==cc.getNumero()) && (nc2==cp.getNumero())){
                        vt = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite valor de transferência (R$):",  "Transferência", JOptionPane.QUESTION_MESSAGE));
                        c = JOptionPane.showOptionDialog(null, "Nomes do titulares das contas:\n"+cc.getNome()+"\n"+cp.getNome(), "Saque",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, coca, coca[0]);
                        if (c==0){
                            if (vt>0 && vt<cc.saldo){
                                cc.saldo=cc.saldo-vt;
                                cp.saldo=cp.saldo+vt;
                                JOptionPane.showOptionDialog(null, "Transferência efetuada com sucesso!!!\n", "Transferência",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                            }
                            else{
                                JOptionPane.showOptionDialog(null, "Valor de transferência inválido ou excedente ao saldo da conta de "+cc.getNome()+", nº "+cc.getNumero()+"!!!\n", "Transferência",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                            } 
                        }
                        else{
                            JOptionPane.showOptionDialog(null, "Transferência cancelada!!!\n", "Transferência",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                        } 
                    }
                    if ((nc1==cc.getNumero()) && (nc2==ce.getNumero())){
                        vt = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite valor de transferência (R$):",  "Transferência", JOptionPane.QUESTION_MESSAGE));
                        c = JOptionPane.showOptionDialog(null, "Nomes do titulares das contas:\n"+cc.getNome()+"\n"+ce.getNome(), "Saque",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, coca, coca[0]);
                        if (c==0){
                            if (vt>0 && vt<cc.saldo){
                                cc.saldo=cc.saldo-vt;
                                ce.saldo=ce.saldo+vt;
                                JOptionPane.showOptionDialog(null, "Transferência efetuada com sucesso!!!\n", "Transferência",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                            }
                            else{
                                JOptionPane.showOptionDialog(null, "Valor de transferência inválido ou excedente ao saldo da conta de "+cc.getNome()+", nº "+cc.getNumero()+"!!!\n", "Transferência",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                            }
                        }
                        else{
                            JOptionPane.showOptionDialog(null, "Transferência cancelada!!!\n", "Transferência",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                        }
                    }
                    if ((nc1==cp.getNumero()) && (nc2==cc.getNumero())){
                        vt = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite valor de transferência (R$):",  "Transferência", JOptionPane.QUESTION_MESSAGE));
                        c = JOptionPane.showOptionDialog(null, "Nomes do titulares das contas:\n"+cp.getNome()+"\n"+cc.getNome(), "Saque",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, coca, coca[0]);
                        if (c==0){
                            if (vt>0 && vt<cp.saldo){
                                cp.saldo=cp.saldo-vt;
                                cc.saldo=cc.saldo+vt;
                                JOptionPane.showOptionDialog(null, "Transferência efetuada com sucesso!!!\n", "Transferência",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                            }
                            else{
                                JOptionPane.showOptionDialog(null, "Valor de transferência inválido ou excedente ao saldo da conta de "+cp.getNome()+", nº "+cp.getNumero()+"!!!\n", "Transferência",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                            } 
                        }
                        else{
                            JOptionPane.showOptionDialog(null, "Transferência cancelada!!!\n", "Transferência",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                        }
                    }
                    if ((nc1==cp.getNumero()) && (nc2==ce.getNumero())){
                        vt = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite valor de transferência (R$):",  "Transferência", JOptionPane.QUESTION_MESSAGE));
                        c = JOptionPane.showOptionDialog(null, "Nomes do titulares das contas:\n"+cp.getNome()+"\n"+ce.getNome(), "Saque",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, coca, coca[0]);
                        if (c==0){
                            if (vt>0 && vt<cp.saldo){
                                cp.saldo=cp.saldo-vt;
                                ce.saldo=ce.saldo+vt;
                                JOptionPane.showOptionDialog(null, "Transferência efetuada com sucesso!!!\n", "Transferência",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                            }
                            else{
                                JOptionPane.showOptionDialog(null, "Valor de transferência inválido ou excedente ao saldo da conta de "+cp.getNome()+", nº "+cp.getNumero()+"!!!\n", "Transferência",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                            } 
                        }
                        else{
                            JOptionPane.showOptionDialog(null, "Transferência cancelada!!!\n", "Transferência",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                        }
                    }
                    if ((nc1==ce.getNumero()) && (nc2==cc.getNumero())){
                        vt = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite valor de transferência (R$):",  "Transferência", JOptionPane.QUESTION_MESSAGE));
                        c = JOptionPane.showOptionDialog(null, "Nomes do titulares das contas:\n"+ce.getNome()+"\n"+cc.getNome(), "Saque",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, coca, coca[0]);
                        if (c==0){
                            if (vt>0 && vt<ce.saldo){
                                ce.saldo=ce.saldo-vt;
                                cc.saldo=cc.saldo+vt;
                                JOptionPane.showOptionDialog(null, "Transferência efetuada com sucesso!!!\n", "Transferência",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                            }
                            else{
                                JOptionPane.showOptionDialog(null, "Valor de transferência inválido ou excedente ao saldo da conta de "+ce.getNome()+", nº "+ce.getNumero()+"!!!\n", "Transferência",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                            }
                        }
                        else{
                            JOptionPane.showOptionDialog(null, "Transferência cancelada!!!\n", "Transferência",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                        }
                    }
                    if ((nc1==ce.getNumero()) && (nc2==cp.getNumero())){
                        vt = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite valor de transferência(R$):",  "Transferência", JOptionPane.QUESTION_MESSAGE));
                        c = JOptionPane.showOptionDialog(null, "Nomes do titulares das contas:\n"+ce.getNome()+"\n"+cp.getNome(), "Saque",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, coca, coca[0]);
                        if (c==0){
                            if (vt>0 && vt<ce.saldo){
                                ce.saldo=ce.saldo-vt;
                                cp.saldo=cp.saldo+vt;
                                JOptionPane.showOptionDialog(null, "Transferência efetuada com sucesso!!!\n", "Transferência",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                            }
                            else{
                                JOptionPane.showOptionDialog(null, "Valor de transferência inválido ou excedente ao saldo da conta de "+ce.getNome()+", nº "+ce.getNumero()+"!!!\n", "Transferência",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                            }
                        }
                        else{
                            JOptionPane.showOptionDialog(null, "Transferência cancelada!!!\n", "Transferência",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                        }
                    }
                }
                else if (nc1==nc2){
                    JOptionPane.showOptionDialog(null, "Números de contas iguais!\n", "Transferência",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                }
                else {
                    JOptionPane.showOptionDialog(null, "Número(s) de conta(s) diferente(s) dos armazenados!\n", "Transferência",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, voltar, voltar[0]);
                }
            }
            if (s==3){
                try{
                    tr = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite taxa de reajuste para conta poupança(%):",  "Taxa de reajuste Conta Poupança", JOptionPane.QUESTION_MESSAGE));
                    cp.saldo=cp.reajustar(tr);
                    JOptionPane.showOptionDialog(null, "Reajuste realizado!!!\n", "Reajuste",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                }catch (NumberFormatException e ){
                    cp.saldo=cp.reajustar();
                    JOptionPane.showOptionDialog(null, "Reajuste realizado!!!\n", "Reajuste",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, voltar, voltar[0]);
                }
            }
            if (s==4){
                JOptionPane.showMessageDialog(null, "Saldo conta "+cc.tipoConta()+", "+cc.getNome()+", nº "+cc.getNumero()+": \n -> "+cc.saldo+" reais\nSaldo conta "+cp.tipoConta()+", "+cp.getNome()+", nº "+cp.getNumero()+": \n -> "+cp.saldo+" reais\nSaldo conta "+ce.tipoConta()+", "+ce.getNome()+", nº "+ce.getNumero()+": \n -> "+ce.saldo+" reais");
            }
            if (s==5){
               System.exit(0);
            }
        c=1;
        }while(c!=0); 
    }
}