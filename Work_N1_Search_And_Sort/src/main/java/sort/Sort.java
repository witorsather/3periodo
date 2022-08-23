package sort;

public class Sort {

    public String[] BubbleSort(String[] B) {

        String aux = "";

        for (int i = 0; i < B.length; i++) {

            for (int j = 0; j < B.length - 1; j++) {

                if (B[j].length() > B[j + 1].length()) {

                    aux = B[j];
                    B[j] = B[j + 1];
                    B[j + 1] = aux;

                }

            }

        }

        return B;
    }

    public String[] InsertionSort(String[] C) {

        String aux;

        for (int i = 0; i < C.length; ++i) {

            int j = i;

            while (j > 0 && C[j - 1].length() > C[j].length()) {

                aux = C[j];
                C[j] = C[j - 1];
                C[j - 1] = aux;
                j = j - 1;

            }
        }
        return C;
    }

    public String[] MergeSort(String[] D) {
        
        return null;

    }

}
