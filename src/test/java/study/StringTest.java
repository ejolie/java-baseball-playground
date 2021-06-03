package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split_() {
        String str1 = "1,2";
        String str2 = "1";

        String[] splitedStr1 = str1.split(",");
        String[] splitedStr2 = str2.split(",");

        assertThat(splitedStr1).containsExactly("1", "2");
        assertThat(splitedStr2).containsExactly("1");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        String substr = str.substring(1, str.length() - 1);
        assertThat(substr).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져온다.")
    @Test
    void charAt() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
    }

    @DisplayName("특정 위치의 문자를 가져올 때 인덱스 범위를 벗어나면 예외가 발생한다.")
    @Test
    void charAtException() {
        String str = "abc";
        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
