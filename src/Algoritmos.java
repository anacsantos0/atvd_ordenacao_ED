import java.util.ArrayList;

public class Algoritmos {

    private ArrayList<Integer> lista;

    public Algoritmos(ArrayList<Integer> lista) {

        this.lista = lista;
    }

    public void selectionSort() {

        int n = lista.size();

        for(int i = 0 ; i < (n-1) ; i++) {
            int menorNum = i;

            // Encontra o índice do menor elemento não ordenado
            for(int j = (i+1) ; j < n ; j++) {
                if(lista.get(j) < lista.get(menorNum)) {
                    menorNum = j;
                }
            }

            // Troca o elemento atual pelo menor Elemento encontrado
            int temp = lista.get(menorNum);
            lista.set(menorNum, lista.get(i));
            lista.set(i, temp);

        }

    }


    public void bubbleSort() {

        int n = lista.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (lista.get(j) > lista.get(j+1)) {

                    // Troca os elementos se estiverem na ordem errada
                    int temp = lista.get(j);
                    lista.set(j, lista.get(j+1));
                    lista.set(j+1, temp);
                }
            }
        }

    }


    public void insertionSort() {

        int n = lista.size();

        for (int i = 1; i < n; i++) {
            int key = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j) > key) {
                lista.set(j+1, lista.get(j));
                j = j - 1;
            }

            lista.set(j+1, key);
        }

    }


    public void mergeSort(int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;

            mergeSort(esquerda, meio);
            mergeSort(meio + 1, direita);

            merge(esquerda, meio, direita);
        }
    }

    public void merge(int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] vetorEsquerda = new int[n1];
        int[] vetorDireita = new int[n2];

        for (int i = 0; i < n1; ++i) {
            vetorEsquerda[i] = lista.get(esquerda + i);
        }

        for (int j = 0; j < n2; ++j) {
            vetorDireita[j] = lista.get(meio + 1 + j);
        }

        int i = 0, j = 0;
        int k = esquerda;

        while (i < n1 && j < n2) {
            if (vetorEsquerda[i] <= vetorDireita[j]) {
                lista.set(k, vetorEsquerda[i]);
                i++;
            } else {
                lista.set(k, vetorDireita[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            lista.set(k, vetorEsquerda[i]);
            i++;
            k++;
        }

        while (j < n2) {
            lista.set(k, vetorDireita[j]);
            j++;
            k++;
        }
    }



    public void quickSort(int baixo, int cima) {

        if (baixo < cima) {

            int pi = partition(baixo, cima);

            quickSort(baixo, pi - 1);
            quickSort(pi + 1, cima);
        }
    }

    public int partition(int baixo, int cima) {

        int pivot = lista.get(cima);
        int i = (baixo - 1);

        for (int j = baixo; j < cima; j++) {

            if (lista.get(j) < pivot) {
                i++;

                int temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }

        int temp = lista.get(i+1);
        lista.set(i+1, lista.get(cima));
        lista.set(cima, temp);

        return i + 1;
    }

}