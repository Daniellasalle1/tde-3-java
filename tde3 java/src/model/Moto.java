package model;

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String placa, String marca, String modelo, int cilindradas) {
        super(placa, marca, modelo);
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularIPVA() {
        return 300.0;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Cilindradas: " + cilindradas);
        System.out.println("IPVA: R$" + calcularIPVA());
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
}