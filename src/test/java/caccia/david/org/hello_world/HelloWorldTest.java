package caccia.david.org.hello_world;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class HelloWorldTest {

    @org.testng.annotations.Test
    public void testGreet() {
        final String greeter = "Jan";
        HelloWorld hw = new HelloWorld(greeter);
        final String message = hw.greet();
        assertSoftly(softly -> {
            softly.assertThat(message).contains(greeter);
            softly.assertThat(message).contains("Hello world");
        });

    }
}