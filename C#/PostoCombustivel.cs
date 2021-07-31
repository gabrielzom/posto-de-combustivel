using System;
namespace posto_de_combustivel_recode
{
    
    //------- CLASSE POSTO_COMBUSTÍVEL ------//
    public class PostoCombustivel
    {   
        public string tipoCombustivel;
        public double quantidadeCombustivel;
        public double precoCombustivel;
        public string formaPagamento;

        /*
        /------- CONSTRUTOR DA CLASSE POSTO_COMBUSTÍVEL ------ /
        * NÃO PRECISO USAR NENHUMA VALIDAÇÃO DE DADOS, ENTÃO       
        * POR ISSO CRIEI O MÉTODO CONSTRUTOR VAZIO.
        */
        public PostoCombustivel() 
        { }

        //------- MÉTODOS DA CLASSE POSTO_COMBUSTÍVEL ------//
        public string Abastecer (string tipoCombustivel, double quantidadeCombustivel) {

            if ((tipoCombustivel != "GASOLINA") && (tipoCombustivel != "ALCOOL") && (tipoCombustivel != "ÁLCOOL")) {
                this.tipoCombustivel = "parametroInvalido";
            }

            else {

                switch(tipoCombustivel)
                {
                    case "GASOLINA":
                        this.tipoCombustivel = "Gasolina";
                        this.precoCombustivel = 4.00;
                        break;

                    case "ÁLCOOL":
                        this.tipoCombustivel = "Álcool";
                        this.precoCombustivel = 2.50;
                        break;

                    case "ALCOOL":
                        this.tipoCombustivel = "Álcool";
                        this.precoCombustivel = 2.50;
                        break;
                }
            }

            this.quantidadeCombustivel = quantidadeCombustivel;

            return this.tipoCombustivel;
        }



        public string Pagamento (string formaPagamento) {

            if ((formaPagamento != "DINHEIRO") && (formaPagamento != "CARTÃO") && (formaPagamento != "CARTAO")) {
                this.formaPagamento = "parametroInvalido";
            }

            else {

                switch(formaPagamento)

                {
                    case "DINHEIRO":
                        this.formaPagamento = "Dinheiro";
                        break;
                    case "CARTÃO":
                        this.formaPagamento = "Cartão";
                        break;
                    case "CARTAO":
                        this.formaPagamento = "Cartão";
                        break;
                }
            }

            return this.formaPagamento;
        }

        public void ResumoAbastecimento () {

            Console.WriteLine("=============== RESUMO DO ABASTECIMENTO ===============");
            Console.WriteLine($"Combustível abastecido: {this.tipoCombustivel}.");
            Console.WriteLine($"Quantidade abastecida: {this.quantidadeCombustivel.ToString("F")} Litros.");
            Console.WriteLine($"Forma de pagamento: {this.formaPagamento}.");
            Console.WriteLine($"Total a pagar:  {(this.quantidadeCombustivel*this.precoCombustivel).ToString("C")}.");
        }
    }
}