package caccia.david.org.hello_world;

public class HelloWorld {

    private String name;

    public HelloWorld(String name)
    {
        if(name == null || name.length() == 0)
        {
            name = "annonymous";
        }
        this.name = name;
    }

    public String greet()
    {
        System.out.println(getMessage());
        return getMessage();
    }

    private String getMessage() {
        return String.format("Hello world - %s", name);
    }
}
