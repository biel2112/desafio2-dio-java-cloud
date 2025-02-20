package desafios.desafio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe Processo Seletivo.
 * Contém o método main para execução.
 *
 * @author gabrielbarruzi
 * @version 1.0
 * @since 20/02/2025
 */
public class ProcessoSeletivo {

    /**
     * Essa função analisa os nomes dos candidatos e os salários pretendidos de cada candidato de acordo com o index
     * de cada um dos arrays recebidos nos parâmetros. Em seguida, requisita o contato com os candidatos que
     * pretendem receber salários menores ou iguais a 2 mil reais.
     *
     * @param nomes Array com nomes dos candidatos
     * @param salariosPretendidos Array com os salários pretendidos dos candidatos
     * @return Mensagens que requisita contato com os candidatos que atendem aos requisitos e separa em um Array
     * de String os candidatos aprovados
     */
    static List<String> analisarCandidato(String[] nomes, double[] salariosPretendidos){
        double salarioBase = 2000.0;
        List<String> candidatosAprovados = new ArrayList<>();
        for(int i = 0; i < nomes.length; i++){
            if (salarioBase > salariosPretendidos[i]){
                candidatosAprovados.add(nomes[i]);
                System.out.println("LIGAR PARA O CANDIDATO "+ nomes[i].toUpperCase());
            }
            else if (salarioBase == salariosPretendidos[i]){
                candidatosAprovados.add(nomes[i]);
                System.out.println("AGUARDANDO DEMAIS CANDIDATOS");
            }
            else {
                System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA\n");
            }
        }
        System.out.println("\nCANDIDATOS APROVADOS:");
        for (String candidato : candidatosAprovados){
            System.out.println(candidato);
        }
        return candidatosAprovados;
    }


    /**
     * Função que tenta "ligar" para os candidatos em até 3 tentativas. Para cada candidato aprovado,
     * se a variável atendeu (de valor aleatório) não mudar para "true" em até 3 tentativas, o loop do-while
     * é finalizado.
     * @param candidatosAprovados Array de candidatos que atenderam aos requisitos da função analisarCandidato()
     * @return Um array do número de tentativas de contato, que são os valores da variável contador em cada uma
     * das vezes que o foreach de candidato for executado. Neste caso, o foreach rodou 2 vezes, então o array
     * terá 2 valores inteiros.
     */
    public static List<Integer> tentativasDeLigacoes(List<String> candidatosAprovados){
        Random random = new Random();
        List<Integer> tentativas = new ArrayList<>();
        boolean atendeu = false;

        // Para cada candidato, será contada uma tentativa no contador
        // para cada vez que falhar até o candidato atender
        for(String ignored : candidatosAprovados){
            int contador = 0;
            do {
                atendeu = random.nextInt(3) == 1;
                contador++;
                //Se o candidato atender (true) ou o contador chegar a 3 tentativas, o loop se encerra
            }while (!atendeu && contador < 3);
            tentativas.add(contador);
        }
        return tentativas;
    }

    /**
     * Função que nos informa se foi possível entrar em contato com o candidato aprovado
     * @param tentativas Array com os números de tentativas de contato de cada candidato aprovado
     * @param candidatos Array de candidatos que atenderam aos requisitos da função analisarCandidato()
     */
    public static void entrarEmContato(List<Integer> tentativas, List<String> candidatos){
        for(int i = 0; i < candidatos.size();i++){
            if (tentativas.get(i) <= 3){
                System.out.println("\nCONSEGUIMOS CONTATO COM O CANDIDATO "+ candidatos.get(i).toUpperCase()+" APÓS "+tentativas.get(i) + " TENTATIVA(S)");
            }
            else {
                System.out.println("\nNÃO CONSEGUIMOS CONTATO COM O CANDIDATO "+candidatos.get(i).toUpperCase());
            }
        }
    }

    public static void main(String[] args) {
        //Título
        System.out.println("Processo Seletivo");

        //Candidatos
        String[] candidatos = {"Oswaldo", "Iguinho", "Cebolinha", "Julius", "Nami"};

        //Salários pretendidos de cada candidato acima
        double[] salariosPretendidos = {1200.0,2500.68, 8000.0, 1000.20, 800000.0};

        //Lista de candidatos que atenderam aos requisitos (aprovados)
        List<String> candidatosAprovados = analisarCandidato(candidatos, salariosPretendidos);

        //Lista de tentativas de contato para cada candidato aprovado
        List<Integer> tentativasDeContato = tentativasDeLigacoes(candidatosAprovados);

        //Mensagens de que foi ou não foi possível entrar em contato com os candidatos
        entrarEmContato(tentativasDeContato, candidatosAprovados);
    }
}
