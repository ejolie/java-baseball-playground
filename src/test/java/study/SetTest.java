package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("numbers의 크기를 리턴한다.")
    @Test
    void size() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("1,2,3의 값이 존재하므로 true를 리턴한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @DisplayName("1,2,3은 true를 리턴하고 4,5는 false를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1:true",
            "2:true",
            "3:true",
            "4:false",
            "5:false"
    }, delimiter = ':')
    void contains_csv(String input, String expected) {
        boolean result = numbers.contains(Integer.parseInt(input));
        assertThat(String.valueOf(result)).isEqualTo(expected);
    }
}
