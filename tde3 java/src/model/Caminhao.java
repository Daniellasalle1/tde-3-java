package model;

public class Caminhao extends Veiculo {
    private int eixos;

    public Caminhao(String placa, String marca, String modelo, int eixos) {
        super(placa, marca, modelo);
        this.eixos = eixos;
    }

    @Override
    public double calcularIPVA() {
        return 1000.0 * eixos;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Eixos: " + eixos);
        System.out.println("IPVA: R$" + calcularIPVA());
    }

    // Getter e Setter
    public int getEixos() {
        return eixos;
    }

    public void setEixos(int eixos) {
        this.eixos = eixos;
    }
}