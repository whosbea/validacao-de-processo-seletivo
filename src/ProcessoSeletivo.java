import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        // imprimirSelecionados();
        // selecaoCandidatos();
        String [] candidatosSelecionados = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
		for(String candidato: candidatosSelecionados) {
			ligarParaCandidato(candidato);
		}
    }

    static void ligarParaCandidato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MAXIMO DE TENTATIVAS " + tentativasRealizadas + " REALIZADA");
    }

    static boolean atender() {
        return ThreadLocalRandom.current().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de número " + (indice + 1) + " é " + candidatos[indice]);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este Valor de Salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O Candidato " + candidato + " Foi Selecionado para a Vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar Para o Candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o Candidato com Contra Proposta");
        } else {
            System.out.println("Aguardando o Resultado dos Demais Candidatos");
        }
    }
}
