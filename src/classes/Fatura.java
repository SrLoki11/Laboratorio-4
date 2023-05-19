package classes;

import java.util.ArrayList;
import java.util.List;

public class Fatura {
    private List<Item> itens;
    private double valorTotal;

    public Fatura() {
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    
    public void adicionarItem(Item item) {
        itens.add(item);
        valorTotal += item.getValorTotal();
    }

  
    public void removerItem(Item item) {
        itens.remove(item);
        valorTotal -= item.getValorTotal();
    }

   
    public double calcularValorTotal() {
        return valorTotal;
    }

    
    public List<Item> getItens() {
        return itens;
    }
}

