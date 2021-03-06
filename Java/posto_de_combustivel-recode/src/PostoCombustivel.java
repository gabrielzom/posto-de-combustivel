//----------- IMPORTA??O DA BIBLIOTECA DE FORMATA??O DE N?MEROS DECIMAIS EM JAVA ---------- //
import java.text.DecimalFormat;


//------- CLASSE POSTO_COMBUST?VEL ------//

public class PostoCombustivel {
	
	//----- INSTANCIA DE DOIS OBJETOS DA CLASSE DECIMAL_FORMAT------//
	
	//----- UM PARA FORMATA??O DE PRECO EM BRL E OUTRO PARA QUANTIDADES COM PONTO FLUTUANTE COM PRECIS?O DE DUAS CASAS DECIMAIS ------//
	DecimalFormat preco = new DecimalFormat("###,###.00");
	DecimalFormat quantidade = new DecimalFormat("#,##0.00");
	
	public String tipoCombustivel;
    public double quantidadeCombustivel;
    public double precoCombustivel;
    public String formaPagamento;
    
    
    
    /*
    /------- CONSTRUTOR DA CLASSE POSTO_COMBUST?VEL ------ /
    * N?O PRECISO USAR NENHUMA VALIDA??O DE DADOS, ENT?O       
    * POR ISSO CRIEI O M?TODO CONSTRUTOR VAZIO.
    */
    
    
    public PostoCombustivel() 
    { }
    
  //------- M?TODOS DA CLASSE POSTO_COMBUST?VEL ------//
    
    public String Abastecer (String tipoCombustivel, double quantidadeCombustivel) {

        if ((!tipoCombustivel.equals("GASOLINA")) && (!tipoCombustivel.equals("ALCOOL")) && (!tipoCombustivel.equals("?LCOOL"))) {
           this.tipoCombustivel = "parametroInvalido";
       }

       else {

           switch(tipoCombustivel)
           {
               case "GASOLINA":
                   this.tipoCombustivel = "Gasolina";
                   this.precoCombustivel = 4.00;
                   break;

               case "?LCOOL":
                   this.tipoCombustivel = "?lcool";
                   this.precoCombustivel = 2.50;
                   break;

               case "ALCOOL":
                   this.tipoCombustivel = "?lcool";
                   this.precoCombustivel = 2.50;
                   break;
           }
       }

       this.quantidadeCombustivel = quantidadeCombustivel;

       return this.tipoCombustivel;
   }



   public String Pagamento (String formaPagamento) {

       if ((!formaPagamento.equals("DINHEIRO")) && (!formaPagamento.equals("CART?O")) && (!formaPagamento.equals("CARTAO"))) {
           this.formaPagamento = "parametroInvalido";
       }

       else {

           switch(formaPagamento)

           {
               case "DINHEIRO":
                   this.formaPagamento = "Dinheiro";
                   break;
               case "CART?O":
                   this.formaPagamento = "Cart?o";
                   break;
               case "CARTAO":
                   this.formaPagamento = "Cart?o";
                   break;
           }
       }

       return this.formaPagamento;
   }
   
   public void ResumoAbastecimento () {

       System.out.println("=============== RESUMO DO ABASTECIMENTO ===============");
       System.out.println("Combust?vel abastecido: " + this.tipoCombustivel);
       System.out.println("Quantidade abastecida: " + quantidade.format(this.quantidadeCombustivel) + " Litros");
       System.out.println("Forma de pagamento: " + this.formaPagamento);
       System.out.println("Total a pagar: R$ " + preco.format(this.quantidadeCombustivel*this.precoCombustivel));
   }
}