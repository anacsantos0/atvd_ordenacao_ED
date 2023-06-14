import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teste_02 {

    /* TESTANDO A INSTANCIA num.10000.1*/
    static String caminhoArquivo = "C:\\Users\\Ana Clara Santos\\IdeaProjects\\atvd_ordenacao_ED\\src\\instancias_num\\num.10000.1.txt";

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
        ArrayList<Integer> array;
        array = (ArrayList<Integer>) lerArquivoTxt(caminhoArquivo);
        int tamarray = array.size();
        Algoritmos a = new Algoritmos(array);
        Algoritmos b = new Algoritmos(array);
        Algoritmos c = new Algoritmos(array);
        Algoritmos d = new Algoritmos(array);
        Algoritmos e = new Algoritmos(array);
        long inicio;
        long fim;

        // SelecionSort
        inicio = System.nanoTime();
        a.selectionSort();
        fim = System.nanoTime();
        System.out.println("SelectionSort: " + array + "\n-----> Tempo: " + (double) (fim - inicio) / 1_000_000_000.0 + "segundos");

        // BubbleSort
        inicio = System.nanoTime();
        b.bubbleSort();
        fim = System.nanoTime();
        System.out.println("BubbleSort: " + array + "\n-----> Tempo: " + (double) (fim - inicio) / 1_000_000_000.0 + "segundos");

        // InsertionSort
        inicio = System.nanoTime();
        c.insertionSort();
        fim = System.nanoTime();
        System.out.println("InsertionSort: " + array + "\n-----> Tempo: " + (double) (fim - inicio) / 1_000_000_000.0 + "segundos");


        // MergeSort
        inicio = System.nanoTime();
        d.mergeSort(0, (tamarray - 1));
        fim = System.nanoTime();
        System.out.println("MergeSort: " + array + "\n-----> Tempo: " + (double) (fim - inicio) / 1_000_000_000.0 + "segundos");

        // QuickSort
        inicio = System.nanoTime();
        e.quickSort(0, tamarray - 1);
        fim = System.nanoTime();
        System.out.println("QuickSort: " + array + "\n-----> Tempo: " + (double) (fim - inicio) / 1_000_000_000.0 + "segundos");

    }
}