package by.jnetworks.pagereducer.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PageReducer {

    public String reducePages(String pageNumbers) {
        if (pageNumbers.trim().isEmpty()) {
            return "";
        }

        Integer[] pageArr = stringToIntArray(pageNumbers);
        StringBuilder result = new StringBuilder();

        int size = pageArr.length;
        int i = 0;
        int j = 0;
        while (i < size) {
            while (++j < size && pageArr[j] - pageArr[j - 1] == 1) ;
            if (j - i > 2) {
                result.append(pageArr[i])
                        .append("-")
                        .append(pageArr[j - 1]);
                if (j < size) {
                    result.append(",");
                }
            } else {
                for (; i < j; i++) {
                    result.append(pageArr[i]);
                    if (i < size - 1) {
                        result.append(",");
                    }
                }

            }
            i = j;
        }
        return result.toString();
    }

    private Integer[] stringToIntArray(String pages) {
        return Arrays.stream(pages.split(","))
                .map(Integer::valueOf)
                .sorted()
                .toArray(Integer[]::new);
    }
}
