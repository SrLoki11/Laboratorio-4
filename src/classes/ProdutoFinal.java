package classes; 

import java.util.Scanner;

public class ProdutoFinal {
    
    public static void main(String[] args) {
        
        Produto produto1 = new Produto("Produto 1", 1, 10.0);
        Produto produto2 = new Produto("Produto 2", 2, 20.0);
        Produto produto3 = new Produto("Produto 3", 3, 30.0);

        
        Fatura fatura = new Fatura();

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        
        while (opcao != 3) {
            System.out.println("Menu:");
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver Fatura");
            System.out.println("3 - Encerrar Programa");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                
                case 1:
                    
                    System.out.println("Produtos disponíveis:");
                    System.out.println(produto1.getCodigo() + " - " + produto1.getNome() + " - R$ " + produto1.getPreco());
                    System.out.println(produto2.getCodigo() + " - " + produto2.getNome() + " - R$ " + produto2.getPreco());
                    System.out.println(produto3.getCodigo() + " - " + produto3.getNome() + " - R$ " + produto3.getPreco());

                    
                    System.out.print("Digite o código do produto desejado: ");
                    int codigo = scanner.nextInt();
                    System.out.print("Digite a quantidade comprada: ");
                    int quantidade = scanner.nextInt();

                    
                    Produto produtoEscolhido = null;
                    if (codigo == produto1.getCodigo()) {
                        produtoEscolhido = produto1;
                    } else if (codigo == produto2.getCodigo()) {
                        produtoEscolhido = produto2;
                    } else if (codigo == produto3.getCodigo()) {
                        produtoEscolhido = produto3;
                    }

                    if (produtoEscolhido != null) {
                        
                        Item item = new Item(produtoEscolhido, quantidade);
                        fatura.adicionarItem(item);
                        System.out.println("Item adicionado à fatura.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }

                    break;
                case 2:
                    
                    System.out.println("Fatura:");
                    for (Item item : fatura.getItens()) {
                        System.out.println("Produto: " + item.getProduto().getNome());
                        System.out.println("Quantidade: " + item.getQuantidade());
                        System.out.println("Valor Total: R$ " + item.getValorTotal());
                        System.out.println("-------------------------");
                    }
                    System.out.println("Valor Total da Fatura: R$ " + fatura.calcularValorTotal());
                    break;
                case 3:
                    
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}
