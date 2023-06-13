

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static String caminhoArquivo = "C:\\Users\\Ana Clara Santos\\IdeaProjects\\atvd_ordenacao_ED\\src\\instancias_num\\num.100000.3.txt";
    public static List<Integer> lerArquivoTxt(String caminhoArquivo) throws IOException {
        List<Integer> numeros = new ArrayList<>();

        FileReader arquivo = new FileReader(caminhoArquivo);
        BufferedReader leitor = new BufferedReader(arquivo);

        String linha;
        while ((linha = leitor.readLine()) != null) {
            numeros.add(Integer.parseInt(linha));
        }

        leitor.close();

        return numeros;
    }


    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {

        int opcao;

        do {
            ArrayList<Integer> array;

            array = (ArrayList<Integer>) lerArquivoTxt(caminhoArquivo);

            int tamarray = array.size();

            Algoritmos a = new Algoritmos(array);

            long inicio;
            long fim;

            System.out.println("\n-------------------- MENU ------------------");
            System.out.println("---- Escolha qual algoritmo deseja usar: ---");
            System.out.println("------- Digite o numemero associado --------");
            System.out.println("1) SelectionSort;\n2) BubbleSort;\n3) InsertionSort;\n4) MergeSort;\n5) QuickSort;\n6) SAIR.");
            System.out.print("Digite: ");
            opcao = new Scanner(System.in).nextInt();

            switch (opcao) {
                case 1:

                    inicio = System.nanoTime();
                    a.selectionSort();
                    fim = System.nanoTime();
                    System.out.println("SelectionSort: " + array + "\n-----> Tempo: " + (double)(fim - inicio)/1_000_000_000.0 + "segundos");

                    break;

                case 2:

                    inicio = System.nanoTime();
                    a.bubbleSort();
                    fim = System.nanoTime();
                    System.out.println("BubbleSort: " + array + "\n-----> Tempo: " + (double)(fim - inicio)/1_000_000_000.0 + "segundos");

                    break;

                case 3:

                    inicio = System.nanoTime();
                    a.insertionSort();
                    fim = System.nanoTime();
                    System.out.println("InsertionSort: " + array + "\n-----> Tempo: " + (double)(fim - inicio)/1_000_000_000.0 + "segundos");
                    break;

                case 4:

                    inicio = System.nanoTime();
                    a.mergeSort(0, (tamarray - 1));
                    fim = System.nanoTime();
                    System.out.println("MergeSort: " + array + "\n-----> Tempo: " + (double)(fim - inicio)/1_000_000_000.0 + "segundos");
                    break;

                case 5:

                    inicio = System.nanoTime();
                    a.quickSort(0, tamarray - 1);
                    fim = System.nanoTime();
                    System.out.println("QuickSort: " + array + "\n-----> Tempo: " + (double)(fim - inicio)/1_000_000_000.0 + "segundos");
                    break;

                case 6:
                    System.out.println("---------- saindo... ----------");
                    break;


                default:

                    System.out.println("Opcao inválida!!");
            }
        }while(opcao != 6);
    }
}