package mix_producao;

/**
 * A empresa Dalai-Lama deseja planejar a produção de incensos. Os incensos
 * requerem dois tipos de recursos: mão-de-obra e materiais. A empresa fabrica
 * três tipos de incenso, cada qual com diferentes necessidades de mão-de-obra e
 * materiais, conforme tabela abaixo: A B C Mão de obra (horas por unidade) | 7
 * | 3 | 6 | Materiais (g/por unidade produzida) | 4 | 4 | 5 | Lucro ($/unidade)
 * | 4 | 2 | 3 |
 * 
 * A disponiblidade de materiasi é de 200 g/dia. A mão de obra disponivel por
 * dia é de 150 horas. Formule um problema de programação linear para determinar
 * quanto deve ser produzido de cada tipo de incenso, tal que o lucro total seja
 * maximizado.
 * 
 * '''
 * 
 * # PASSO 1 - IDENTIFICAÇÃO DAS VARIAVEIS DE DECISÃO # XA, XB, XC = PRODUÇÃO
 * DIARIA DOS TIPOS DE INCENSO
 * 
 * #PASSO 2 - INDENTIFICAÇÃO DAS RESTRIÇÕES # 7XA = O TIPO A DE INCENSO LEVA 7
 * HORAS PARA SER PRODUZIDO # 3XB = O TIPO B DE INCENSO LEVA 3 HORAS PARA SER
 * PRODUZIDO # 6XC = O TIPO C CE INCENSO LEVA 6 HORAS PARA SER PRODUZIDO
 * 
 * # RESTRIÇÃO RELACIONADA MÃO DE OBRA # 7XA + 3XB + 6XC <= 150 (A QUANTIDADE DE
 * HORAS QUE NÃO PODE SER EXCEDIDAS)
 * 
 * # RESTRIÇÃO RELACIONADA A MATERIAS # 4XA + 4XB + 5XB <= 200 (A QUATIDADE DE
 * MATERIAL DISPONIVEL AO DIA)
 * 
 * # PASSO 3 - IDENTIFICAÇÃO DO OBJETIVO # MAXIMIZAR O LUCRO TOTAL ORIUNDO DA
 * VENDA DOS PRODUTOS # z = 4XA + 2XB + 3XC # XA, XB, XC >= 0
 **/

public class Mix_producao {
	public static void main(String[] args) {

		// PRODUÇÃO DIARIA DOS TIPOS DE INCENSO
		int XA = 6;
		int XB = 5;
		int XC = 4;

		System.out.print(
				"A produção diaria de incenso dos tipos A, B e C foi de: " + XA + " un " + XB + " un " + XC + " un");
		System.out.println();

		int horas_trabalhadas = restricao_mao_obra(XA, XB, XC);
		if (horas_trabalhadas <= 150) {
			System.out.print("A quantidade de horas trabalhada foi: " + horas_trabalhadas + " horas.");
		} else {
			System.out.print("A quantidade de horas excedida foi: " + horas_trabalhadas + " horas.");
		}

		System.out.println();

		int material_gramas = restricao_materias(XA, XB, XC);
		if (material_gramas <= 200) {
			System.out.print("A quantidade de materia prima usada foi: " + material_gramas + " gramas.");
		} else {
			System.out.print("A quantidade de materia prima excediada foi: " + material_gramas + " gramas.");
		}

		System.out.println();

		int vendas = lucro(XA, XB, XC);
		if (vendas >= 0) {
			System.out.print("O lucro obtido com as vendas foi de R$: " + vendas + " reais.");
		}

	}

	public static int restricao_mao_obra(int A, int B, int C) {

		// RESTRIÇÕES POR HORAS TRABALHADAS
		int rest_XA = 7;
		int rest_XB = 3;
		int rest_XC = 6;
		int resultado = (rest_XA * A) + (rest_XB * B) + (rest_XC * C);

		return resultado;
	}

	public static int restricao_materias(int A, int B, int C) {

		// RESTRIÇÕES DOS MATERIAIS EM GRAMAS
		int rest_MA = 4;
		int rest_MB = 4;
		int rest_MC = 5;
		int resultado = (rest_MA * A) + (rest_MB * B) + (rest_MC * C);

		return resultado;
	}

	public static int lucro(int A, int B, int C) {

		// RESTRIÇÕES DO LUCRO
		int rest_MA = 4;
		int rest_MB = 2;
		int rest_MC = 3;
		int resultado = (rest_MA * A) + (rest_MB * B) + (rest_MC * C);

		return resultado;
	}

}
