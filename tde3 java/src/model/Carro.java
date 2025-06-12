package model;

public class Carro extends Veiculo {
    private int portas;

    public Carro(String placa, String marca, String modelo, int portas) {
        super(placa, marca, modelo);
        this.portas = portas;
    }

    @Override
    public double calcularIPVA() {
        return 500.0;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Portas: " + portas);
        System.out.println("IPVA: R$" + calcularIPVA());
    }

    // Getter e Setter
    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }
}