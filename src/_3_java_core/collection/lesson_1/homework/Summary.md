**Результаты замеров времени выполнение сортировки массива:**

| Алгоритм             | Среднее время | выполнения, мс | (3 замера)  |
|:---------------------|:-------------:|:--------------:|:-----------:|
| **Кол-во элементов** |   **1 000**   |   **10 000**   | **100 000** |
| Arrays.sort          |       0       |       2        |     10      |
| Bubble sort          |       6       |      166       |    20280    |
| Select sort          |       3       |       50       |    16447    |
| Insert sort          |       3       |       17       |     931     |
| Merge sort           |       2       |       5        |     18      |
| Quick sort           |       1       |       4        |     82      |
___
**Выводы:**
для массивов, содержащих небольшое количество элементов, выбор алгоритма сортировки не сильно принципиален,
время выполнения исследуемых алгоритмов по сравнению с Arrays.sort различается несущественно.

Только в случае многократного увеличения элементов в массиве становится заметна разница по времени выполнения 
сортировки исследуемых массивов и Arrays.sort. Наибольший прирост времени показали алгоритмы, 
требующие двухкратного прохода по массиву (Bubble sort, Select sort, Insert sort). В сравнении с Arrays.sort
сортировка 100000 элементов алгоритмом Bubble sort происходит в 2000 раз дольше.

Хорошую производительность показали алгоритмыи, использующие концепцию "разделяй и властвуй" (Merge sort, Quick sort).
Merge sort при 100000 элементов выполнялся в 1,8 раза дольше, чем сортировка посредством Arrays.sort.

Таким образом, для сортировки больших массивов целесообразно использовать алгоритмы "разделяй и властвуй", т.к.
время выполнения сортировки с их помощью существенно меньше по сравнению с алгоритмами, требующими двухкратного 
прохода по массиву. Для сортировки массивов небольшого объёма можно использовать алгоритмы, требующие двухкратного
прохода по массиву, т.к. время сортироки с их помощью приемлено, а памяти они используют меньше.
