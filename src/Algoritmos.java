import java.util.ArrayList;

public class Algoritmos {

    private ArrayList<Integer> array;

    public Algoritmos(ArrayList<Integer> list) {

        this.array = list;
    }

    public void selectionSort() {


        for(int i = 0 ; i < (array.size()-1) ; i++) {
            int numMin = i;

            // Busca o menor elemento que não está ordenado
            for(int j = i+1; j < array.size() ; j++) {
                if(array.get(j) < array.get(numMin)) {
                    numMin = j;
                }
            }

            // Elemento atual troca de lugar com o menor elemento que foi encontrado
            int temp = array.get(numMin);
            array.set(numMin, array.get(i));
            array.set(i, temp);

        }

    }


    public void bubbleSort() {

        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (array.get(j) > array.get(j+1)) {
                    // Troca elementos que estão fora de ordem, é feito de dois em dois
                    int temp = array.get(j);
                    array.set(j, array.get(j+1));
                    array.set(j+1, temp);
                }
            }
        }

    }


    public void insertionSort() {
        for (int i = 1; i < array.size(); i++) {
            int temp = array.get(i);
            int j = i - 1;
            while (j >= 0 && array.get(j) > temp) {
                array.set(j + 1, array.get(j));
                j--;
            }
            array.set(j + 1, temp);
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
            vetorEsquerda[i] = array.get(esquerda + i);
        }

        for (int j = 0; j < n2; ++j) {
            vetorDireita[j] = array.get(meio + 1 + j);
        }

        int i = 0, j = 0;
        int k = esquerda;

        while (i < n1 && j < n2) {
            if (vetorEsquerda[i] <= vetorDireita[j]) {
                array.set(k, vetorEsquerda[i]);
                i++;
            } else {
                array.set(k, vetorDireita[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            array.set(k, vetorEsquerda[i]);
            i++;
            k++;
        }

        while (j < n2) {
            array.set(k, vetorDireita[j]);
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

        int pivot = array.get(cima);
        int i = (baixo - 1);

        for (int j = baixo; j < cima; j++) {

            if (array.get(j) < pivot) {
                i++;

                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }
        }

        int temp = array.get(i+1);
        array.set(i+1, array.get(cima));
        array.set(cima, temp);

        return i + 1;
    }

}