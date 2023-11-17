
/**sugestoes do prefessor
 Poderia tratar entradas inválidas de dados
 Poderia ter criado constantes para mensagens conhecidas
 Explorar a lógica em separação por métodos
 Tratamento de exceções por entradas inválidas


 codigo refatorado*/


import java.util.InputMismatchException;
import java.util.Scanner;

public class FormulaBhaskara {
    // Constantes para mensagens conhecidas
    private static final String MENSAGEM_COEFICIENTE_A_ZERO = "O coeficiente 'a' não pode ser zero. A equação não é quadrática.";
    private static final String MENSAGEM_RAIZES_REAIS = "Raízes reais:";
    private static final String MENSAGEM_UMA_RAIZ_REAL = "Uma raiz real:";
    private static final String MENSAGEM_NENHUMA_RAIZ_REAL = "A equação não possui raízes reais.";

    public static void main(String[] args) {
        // Cria um objeto Scanner para leitura de entrada do usuário
        Scanner input = new Scanner(System.in);

        try {
            // Solicita ao usuário que insira os coeficientes da equação quadrática
            System.out.println("Digite o valor de a:");
            double a = input.nextDouble();

            System.out.println("Digite o valor de b:");
            double b = input.nextDouble();

            System.out.println("Digite o valor de c:");
            double c = input.nextDouble();

            // Verifica se o valor de 'a' é zero
            if (a == 0) {
                System.out.println(MENSAGEM_COEFICIENTE_A_ZERO);
                // Encerra o programa
                System.exit(0);
            }

            // Calcula o discriminante (delta)
            double delta = calcularDelta(a, b, c);

            // Usa uma estrutura condicional para verificar as raízes da equação
            if (delta > 0) {
                // Duas raízes reais
                exibirRaizesReais(a, b, delta);
            } else if (delta == 0) {
                // Uma raiz real
                exibirUmaRaizReal(a, b);
            } else {
                // Nenhuma raiz real
                System.out.println(MENSAGEM_NENHUMA_RAIZ_REAL);
            }
        } catch (InputMismatchException e) {
            System.out.println("Por favor, insira valores numéricos para 'a', 'b' e 'c'.");
        } finally {
            // Fecha o objeto Scanner para liberar recursos
            input.close();
        }
    }

    // Método para calcular o discriminante (delta)
    private static double calcularDelta(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    // Método para exibir duas raízes reais
    private static void exibirRaizesReais(double a, double b, double delta) {
        System.out.println(MENSAGEM_RAIZES_REAIS);
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
    }

    // Método para exibir uma raiz real
    private static void exibirUmaRaizReal(double a, double b) {
        System.out.println(MENSAGEM_UMA_RAIZ_REAL);
        double x = -b / (2 * a);
        System.out.println("x = " + x);
    }
}
