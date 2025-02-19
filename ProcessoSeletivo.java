package desafios.desafio2;

public class ProcessoSeletivo {

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }
        else if (salarioBase == salarioPretendido){
            System.out.println("AGUARDANDO DEMAIS CANDIDATOS");
        }
        else {
            System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA");
        }
    }

    public static void main(String[] args) {
        System.out.println("Processo Seletivo");

    }
}
