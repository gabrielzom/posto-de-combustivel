//----------- IMPORTA??O DA BIBLIOTECA DE SCANNER, QUE PERMITE A ENTRADA DE DADOS PELO CONSOLE COM JAVA ---------- //
import java.util.Scanner;

public class Program {
	
    private static Scanner input;

	public static Double tentaConverter(String quantidade) {
    	try {
    		return Double.parseDouble(quantidade);
    	} 
    	
    	catch(NumberFormatException e ) {
    		return 0.0;
    	}
    }
	
	public static void main(String[] args) {
		//------------ DECLARA??O DAS VARI?VEIS DA CLASSE PROGRAM -----------//
        String tipo, pagamento, quantidadeCombustivel;  
        double quantidade;
        
        //-------- INSTANCIA DE UM OBJETO DA CLASSE DE UTILITARIOS JAVA ------//
        input = new Scanner(System.in);
        
        
        //-------- INST?NCIANDO OBJETO DA CLASSE POSTO_COMBUSTIVEL --------//
        PostoCombustivel postoCombustivel = new PostoCombustivel();

      //----------------------- IN?CIO DO PROGRAMA ---------------------//
        System.out.println("========= POSTO DE COMBUST?VEL ========");
        System.out.println("Pre?o por litro: \nGASOLINA = R$ 4,00\n?LCOOL   = R$ 2,50");
        System.out.println("---------------------------------------");
        
        System.out.println("Qual a quantidade desejada de combust?vel em litros?");   
        quantidadeCombustivel = input.next();
        quantidade = tentaConverter(quantidadeCombustivel);
        
        while (quantidade == 0.0) {
        	System.out.println("ERRO. Digite apenas n?meros");
        	System.out.println("Qual a quantidade desejada de combust?vel em litros?");
        	quantidadeCombustivel = input.next();
        	quantidade = tentaConverter(quantidadeCombustivel);
        }
        
        System.out.println("Qual tipo de combust?vel deseja colocar ?");
        System.out.println("Digite 'GASOLINA' ou '?LCOOL': ");
        tipo = input.next().toUpperCase();
        
        String combustivelInvalido = postoCombustivel.Abastecer(tipo, quantidade);
        
        while (combustivelInvalido == "parametroInvalido") {
        	System.out.println("ERRO. O tipo de combust?vel digitado ? INVALIDO.");
        	System.out.println("Digite 'GASOLINA' ou '?LCOOL': ");
            tipo = input.next().toUpperCase();
            combustivelInvalido = postoCombustivel.Abastecer(tipo, quantidade);   
        }
            
        
        
        System.out.println("Como ser? feito o pagamento?");
        System.out.println("Digite 'DINHEIRO' ou 'CART?O': ");
        pagamento = input.next().toUpperCase();

        String pagamentoInvalido = postoCombustivel.Pagamento(pagamento.toUpperCase());

        while (pagamentoInvalido == "parametroInvalido") {
        	System.out.println("ERRO. O tipo de pagamento ? INVALIDO.");
            System.out.println("Digite 'DINHEIRO' ou 'CART?O': ");
            pagamento = input.next().toUpperCase();
            pagamentoInvalido = postoCombustivel.Pagamento(pagamento.toUpperCase());
        }    
     
        postoCombustivel.ResumoAbastecimento();
	}
        
}