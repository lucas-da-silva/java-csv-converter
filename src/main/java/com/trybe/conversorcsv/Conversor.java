package com.trybe.conversorcsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe Conversor é a classe principal.
 */
public class Conversor {
  /**
   * Função utilizada apenas para validação da solução do desafio.
   *
   * @param args Não utilizado.
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou gravar os
   *         arquivos de saída.
   */
  public static void main(String[] args) throws IOException {
    File pastaDeEntradas = new File("./entradas/");
    File pastaDeSaidas = new File("./saidas/");
    new Conversor().converterPasta(pastaDeEntradas, pastaDeSaidas);
  }

  /**
   * Converte todos os arquivos CSV da pasta de entradas. Os resultados são gerados na pasta de
   * saídas, deixando os arquivos originais inalterados.
   *
   * @param pastaDeEntradas Pasta contendo os arquivos CSV gerados pela página web.
   * @param pastaDeSaidas Pasta em que serão colocados os arquivos gerados no formato requerido pelo
   *        subsistema.
   *
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou gravar os
   *         arquivos de saída.
   */
  public void converterPasta(File pastaDeEntradas, File pastaDeSaidas) throws IOException {
    for (File arquivo : pastaDeEntradas.listFiles()) {
      pastaDeSaidas.mkdir();
      try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
        this.escreverNoArquivo(leitor, pastaDeSaidas, arquivo.getName());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void escreverNoArquivo(BufferedReader bufferedLeitor, File pastaDeSaidas,
      String arquivoNome) throws IOException {
    File arquivoDeSaida = new File(pastaDeSaidas, arquivoNome);
    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoDeSaida))) {
      String conteudoLinha = bufferedLeitor.readLine();
      this.escrever(conteudoLinha, escritor);
      conteudoLinha = bufferedLeitor.readLine();

      while (conteudoLinha != null) {
        this.escrever(this.formatarInscrito(conteudoLinha), escritor);
        conteudoLinha = bufferedLeitor.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void escrever(String linha, BufferedWriter escritor) throws IOException {
    escritor.write(linha);
    escritor.newLine();
    escritor.flush();
  }

  private String formatarInscrito(String inscrito) {
    String[] informacoes = inscrito.split(",");

    String nome = informacoes[0].toUpperCase();
    String data = this.formatarData(informacoes[1]);
    String email = informacoes[2];
    String cpf = this.formatarCpf(informacoes[3]);

    return nome + "," + data + "," + email + "," + cpf;
  }

  private String formatarData(String dataString) {
    DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatoSaida = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    LocalDate data = LocalDate.parse(dataString, formatoEntrada);

    return data.format(formatoSaida);
  }

  private String formatarCpf(String cpf) {
    StringBuilder cpfBuilder = new StringBuilder(cpf);

    cpfBuilder.insert(3, '.');
    cpfBuilder.insert(7, '.');
    cpfBuilder.insert(11, '-');

    return cpfBuilder.toString();
  }
}
