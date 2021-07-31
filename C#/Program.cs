using System;

namespace posto_de_combustivel_recode
{
    class Program
    {
        static void Main(string[] args)
        {
            //------------ DECLARAÇÃO DAS VARIÁVEIS DA CLASSE PROGRAM -----------//
            string tipo, pagamento;  
            double quantidade;
           
            //-------- INSTÂNCIANDO OBJETO DA CLASSE POSTO_COMBUSTIVEL --------//
            PostoCombustivel postoCombustivel = new PostoCombustivel();


            //----------------------- INÍCIO DO PROGRAMA ---------------------//
            Console.WriteLine("========= POSTO DE COMBUSTÍVEL ========");
            Console.WriteLine("Preço por litro: \nGASOLINA = R$ 4,00\nÁLCOOL   = R$ 2,50");
            Console.WriteLine("---------------------------------------");


            Console.WriteLine("Qual a quantidade desejada de combustível em litros?");
            while (!double.TryParse(Console.ReadLine(), out quantidade)) {
                Console.WriteLine("ERRO. Digite Apenas números");
                Console.WriteLine("Qual a quantidade desejada de combustível em litros?");
            }


            Console.WriteLine("Qual tipo de combustível deseja colocar ?");
            Console.WriteLine("Digite 'GASOLINA' ou 'ÁLCOOL': ");
            tipo = Console.ReadLine();

            string combustivelInvalido = postoCombustivel.Abastecer(tipo.ToUpper(), quantidade);

            while (combustivelInvalido == "parametroInvalido") {
                Console.WriteLine("ERRO. O tipo de combustível digitado é INVALIDO.");
                Console.WriteLine("Digite 'GASOLINA' ou 'ÁLCOOL': ");
                tipo = Console.ReadLine();
                combustivelInvalido = postoCombustivel.Abastecer(tipo.ToUpper(), quantidade);
            }

 
            Console.WriteLine("Como será feito o pagamento?");
            Console.WriteLine("Digite 'DINHEIRO' ou 'CARTÃO': ");
            pagamento = Console.ReadLine();

            string pagamentoInvalido = postoCombustivel.Pagamento(pagamento.ToUpper());

            while (pagamentoInvalido == "parametroInvalido") {
                Console.WriteLine("ERRO. O tipo de pagamento é INVALIDO.");
                Console.WriteLine("Digite 'DINHEIRO' ou 'CARTÃO': ");
                pagamento = Console.ReadLine();
                pagamentoInvalido = postoCombustivel.Pagamento(pagamento.ToUpper());
            }
    
            postoCombustivel.ResumoAbastecimento();

            Console.Read();
        }
    }
}