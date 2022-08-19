package sort;

public class Sort {

    public  String[] SelectionSort(String[] A) {

        int menorValor;
        String aux;
        for (int i = 0; i <= A.length - 2; i++) {

            menorValor = i;

            for (int j = i + 1; j <= A.length - 1; j++) {

                if (A[j].length() < A[menorValor].length()) {

                    menorValor = j;
                }
            }
            aux = A[menorValor];
            A[menorValor] = A[i];
            A[i] = aux;

        }

        return A;

    }

}
