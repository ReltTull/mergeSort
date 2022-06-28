public class MergeSort {
    public static void dividingAndMerging (int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] leftPart = new int[mid];
        int[] rightPart = new int[arr.length - mid];

        for(int i = 0; i < mid; i++) {
            leftPart[i] = arr[i];
        }
        for(int i = mid; i < arr.length; i++) {
            // Влад, привет, если прочитаешь, то подскажи в ответе пожалуйста, почему в индекс задаётся
            // "i - mid",а не i? Я это решение нашёл, разобрал и переписал по памяти, но тут индекс вылетал
            // из rightPart.lenght, и пришлось подсматривать снова. Единственный момент, который не понял в коде.
            rightPart[i - mid] = arr[i];
        }

        // делим подмассивы на меньшие подмассивы длиной не более 2 элементов.
        dividingAndMerging(leftPart);
        dividingAndMerging(rightPart);

        // мержим подмассивы.
        merge(arr, leftPart, rightPart, mid, arr.length - mid);
    }

    public static void merge (int[] unitArr, int[] leftArr, int[] rightArr, int leftLenght, int rightLenght) {
        int leftCounter = 0;
        int rightCounter = 0;
        int unitedCounter = 0;

        // сравниваем поэлементно массивы и меньший из пары добавляем в arr.
        while (leftCounter < leftLenght && rightCounter < rightLenght) {
            if(leftArr[leftCounter] <= rightArr[rightCounter]) {
                unitArr[unitedCounter++] = leftArr[leftCounter++];
            } else {
                unitArr[unitedCounter++] = rightArr[rightCounter++];
            }
        }
        // после последнего сравнения по двум массивам закидываем в массив оставшиеся элменты из непустого подмассива.
        while (leftCounter < leftLenght) {
            unitArr[unitedCounter++] = leftArr[leftCounter++];
        }
        while (rightCounter < rightLenght) {
            unitArr[unitedCounter++] = rightArr[rightCounter++];
        }
    }

    public static void main(String[] args) {
        int[] actual = { 5, 1, 6, 2, 3, 4, 4, 10, 27, 0, 5};
        dividingAndMerging(actual);
        for (int i = 0; i < actual.length; i++) {
            System.out.print(actual[i] + " ");
        }
    }
}
