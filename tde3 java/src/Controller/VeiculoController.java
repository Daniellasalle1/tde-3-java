package Controller;

import java.util.ArrayList;
import java.util.List;
import model.*;
import model.excecao.*;

public class VeiculoController {
    private final List<Veiculo> veiculos = new ArrayList<>();

    public void cadastrarVeiculo(Veiculo veiculo) throws EntradaInvalidaException {
        if (veiculo == null) {
            throw new EntradaInvalidaException("Veículo não pode ser nulo");
        }
        if (veiculo.getPlaca() == null || veiculo.getPlaca().trim().isEmpty()) {
            throw new EntradaInvalidaException("Placa não pode ser vazia");
        }
        if (existeVeiculo(veiculo.getPlaca())) {
            throw new EntradaInvalidaException("Veículo com placa " + veiculo.getPlaca() + " já cadastrado");
        }
        veiculos.add(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return new ArrayList<>(veiculos);
    }

    public Veiculo buscarVeiculo(String placa) throws VeiculoNaoEncontradoException {
        if (placa == null || placa.trim().isEmpty()) {
            throw new VeiculoNaoEncontradoException("Placa não pode ser vazia");
        }

        return veiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa.trim()))
                .findFirst()
                .orElseThrow(() -> new VeiculoNaoEncontradoException("Veículo com placa " + placa + " não encontrado"));
    }

    public void atualizarVeiculo(String placa, Veiculo novoVeiculo)
            throws VeiculoNaoEncontradoException, EntradaInvalidaException {
        if (novoVeiculo == null) {
            throw new EntradaInvalidaException("Novo veículo não pode ser nulo");
        }

        Veiculo veiculoAntigo = buscarVeiculo(placa);

        if (!placa.equalsIgnoreCase(novoVeiculo.getPlaca())) {
            if (existeVeiculo(novoVeiculo.getPlaca())) {
                throw new EntradaInvalidaException("Já existe um veículo com a nova placa " + novoVeiculo.getPlaca());
            }
        }

        veiculos.remove(veiculoAntigo);
        veiculos.add(novoVeiculo);
    }

    public void removerVeiculo(String placa) throws VeiculoNaoEncontradoException {
        Veiculo veiculo = buscarVeiculo(placa);
        veiculos.remove(veiculo);
    }

    private boolean existeVeiculo(String placa) {
        return veiculos.stream()
                .anyMatch(v -> v.getPlaca().equalsIgnoreCase(placa.trim()));
    }
}