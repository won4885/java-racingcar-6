package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.validator.TryCountValidator;

class TryCountValidatorTest {

    @DisplayName("모든 경우의 수를 따져서 올바른 tryCount일 경우에는 예외가 발생하지 않는다.")
    @Test
    void validate_all_cases_does_not_throw_any_exception() {
        // given
        String validTryCount = "2";

        // when
        // then
        assertThatCode(() -> new TryCountValidator(validTryCount))
                .doesNotThrowAnyException();
    }

    @DisplayName("validateTryCountExists()로 시도할 횟수를 입력하지 않으면 ''으로 저장되기 때문에 예외가 발생한다.")
    @Test
    void validate_tryCount_exists_with_blank() {
        // given
        String invalidTryCount = "";

        // when
        // then
        assertThatThrownBy(() -> new TryCountValidator(invalidTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수를 입력해주세요.");
    }

    @DisplayName("validateTryCountIsInteger()로 시도할 횟수가 정수가 아니라면 예외가 발생한다.")
    @Test
    void validate_tryCount_is_integer_with_invalid_tryCount() {
        // given
        String invalidTryCount = "akb1";

        // when
        // then
        assertThatThrownBy(() -> new TryCountValidator(invalidTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 정수여야 합니다.");
    }

    @DisplayName("validateTryCountIsInteger()로 시도할 횟수가 양의 정수가 아니라면 예외가 발생한다.")
    @Test
    void validate_tryCount_is_positive_with_invalid_tryCount() {
        // given
        String invalidTryCount = "-3";

        // when
        // then
        assertThatThrownBy(() -> new TryCountValidator(invalidTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 양의 정수여야 합니다.");
    }

}
