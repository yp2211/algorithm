package yahoo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class g2021Test {
    @Test
    void sample1() {
        int actual = g2021.main(new String[]{"3", "1 2 3"});
        int expected = 4;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sample2() {
        int actual = g2021.main(new String[]{"3", "1 2 2"});
        int expected = 4;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sample3() {
        int actual = g2021.main(new String[]{"8", "1 2 3 4 5 6 7 8"});
        int expected = 128;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sample4() {
        int actual = g2021.main(new String[]{"10", "1 1 1 1 1 1 1 1 1 1"});
        int expected = 28692;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void sample5() {
        int actual = g2021.main(new String[]{"11", "1 1 1 1 1 1 1 1 1 1 2"});
        int expected = 28692 * 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sample6() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("1 ");
        }
        String in = sb.toString().trim();
        int actual = g2021.main(new String[]{"100000", in});
        int expected = 50001;
        Assertions.assertEquals(expected, actual);
    }
}
